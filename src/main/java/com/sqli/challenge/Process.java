package com.sqli.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.stream.Collectors;

final class Process
{
  private final Queue<String> instructionsToRun;
  private Collection<String> executedInstructions;

  Process(final String[] instructions)
  {
    instructionsToRun = new ArrayDeque<>(Arrays.asList(instructions));
  }

  void run()
  {
    run(null);
  }
  
  void run(Integer roundRobin)
  {
    executedInstructions = new ArrayList<>();

    String instructionToRun;

    while ((roundRobin != null ? roundRobin-- > 0 : true) && (instructionToRun = instructionsToRun.poll()) != null)
    {
      executedInstructions.add(instructionToRun);
    }
  }

  String getExecutionResult(final String processName)
  {
    return executedInstructions.stream()
        .map(executedInstruction -> String.format("<<%s>>%s", processName, executedInstruction))
        .collect(Collectors.joining());
  }
  
  boolean hasRemainingInstructionsToRun()
  {
    return !instructionsToRun.isEmpty();
  }
}
