package net.incongru.tichu.simu;

import net.incongru.tichu.action.Action;
import net.incongru.tichu.action.impl.ActionFactoryImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public class SimulationFileParser {

    private final ActionLineParsers actionLineParsers;

    public SimulationFileParser() {
        actionLineParsers = new ActionLineParsers(new ActionFactoryImpl());
    }

    Simulation parse(Path p) throws IOException {
        final ImmutableSimulation.Builder builder = ImmutableSimulation.builder();

        final List<String> lines = SimulationFileLoader.from(p);
        lines.stream()
                .map(actionLineParsers::parse)
                .map((Function<Action, Simulation.ActionAndExpectations>) action -> {
                    return ImmutableActionAndExpectations.builder()
                            .action(action)
                            .build();
                })
                .forEach(builder::addActionAndExpectations);
        return builder.build();
    }

}
