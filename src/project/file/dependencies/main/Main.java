package project.file.dependencies.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Task;
import project.file.dependencies.implementation.AlgorithmImplementation;
import project.file.dependencies.utils.Utils;

public final class Main {

	
	public static void main(String[] args) {
		//Simple read file and decript the information.
		//File is assumed to be passed as the 0th argument of args
		String filename = args[0];
		if( Utils.isValidString(filename)){
			
			try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
				
				String firstLine = reader.readLine();
				
				String [] params = firstLine.split(Utils.SEPARATOR);
				
				int numberOfTasks = Integer.parseInt(params[0]);
								
				List<Task> tasks = Utils.createTasksFromNumber(numberOfTasks); 
				
				//Info
				System.out.println(tasks);	
				
				int numberOfRules = Integer.parseInt(params[1]);
				
				List<String> unparsedRules = IntStream.range(0, numberOfRules)
						.mapToObj(
								(val) -> {
									try { return reader.readLine();}
									catch (IOException ie){return "";}
									})
						.collect(Collectors.toList());
						
				
				//Info
				System.out.println(unparsedRules);
				
				List<Rule> parsedRules = unparsedRules
						.stream()
						.map(Utils::createRuleFromUnformatedRule)
						.collect(Collectors.toList());
				//Info
				System.out.println(parsedRules);
				
				AlgorithmImplementation impl = new AlgorithmImplementation(tasks, parsedRules);
				
				//Info
				System.out.println("Problem Solved: " + impl.isProblemSolved());
				
				List<Task> orderedTasks = impl.solve();
				
				System.out.println("Problem Solved: " + impl.isProblemSolved());
				
				System.out.print("Final Result Should Be: ");
				System.out.println(orderedTasks);
				System.out.println("Guide me Oh Might Anubis!!!!");
				
				
				
				
			} catch (FileNotFoundException e) {
				// Log exception
				e.printStackTrace();
			} catch (IOException e) {
				// Log exception
				e.printStackTrace();
			}
			
			
			
		}
		//Should be replaced by log
		else{
			System.out.println("Invalid filename on args[0]. Ending program!");
		}
	}
}
