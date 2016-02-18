package project.file.dependencies.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Rule.RuleBuilder;
import project.file.dependencies.classes.Task;
import project.file.dependencies.classes.Task.TaskBuilder;

public final class Utils {
	
	public final static String SEPARATOR = " ";
	
	public final static int TARGET_INDEX = 0, NUMBER_OF_DEPENDENTS_INDEX = 1, TASK_LIST_STARTING_INDEX = 2;
	
	
	public final static boolean isValidString (String s){
		return s != null && s != "";
	}
	
	
	public final static List<Task> createTasksFromNumber(int numberOfTasks){
		return IntStream
				.rangeClosed(1, numberOfTasks)
				.mapToObj( i -> new TaskBuilder(i).build())
				.collect(Collectors.toList());
	}
	
	public final static Rule createRuleFromUnformatedRule(String rule){
		String [] splited = rule.split(SEPARATOR);
		List<String> tasks = Arrays.asList(Arrays.copyOfRange(splited, TASK_LIST_STARTING_INDEX, splited.length));
		
		return new RuleBuilder(
				new TaskBuilder(Integer.parseInt(splited[TARGET_INDEX])).build(),
				Integer.parseInt(splited[NUMBER_OF_DEPENDENTS_INDEX]),
				tasks.stream().map((strVal) -> new TaskBuilder(Integer.parseInt(strVal)).build())
				.collect(Collectors.toList())).build();
	}
	
}
