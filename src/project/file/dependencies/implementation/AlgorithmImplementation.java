package project.file.dependencies.implementation;

import java.util.List;
import java.util.stream.Collectors;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Task;
import project.file.dependencies.interfaces.InputFacade;
import project.file.dependencies.interfaces.OutputFacade;

/**
 * Algorithm implementation
 * <div style = "font-weight:bold"> Thread Safety: None </div>
 * @author joao.rebelo
 * 
 */
public final class AlgorithmImplementation {
	
	private final InputFacade inputFacade;
	private final OutputFacade outputFacade;
	
	public AlgorithmImplementation(List<Task> tasks, List<Rule> rules){
		inputFacade = new InputFacadeImplementation(rules.size(), rules, tasks.size(), tasks);
		outputFacade = new OutputFacadeImplementation();
		
		outputFacade.addListOfSolvedTasks(
				inputFacade.getRulesWithoutDependencies()
				.stream()
				.map( (rule) -> rule.getTarget())
				.collect(Collectors.toList()));
	}
	
	
	public boolean isProblemSolved(){
		return checkProblemSolved();
	}
	
	private boolean checkProblemSolved() {
		return inputFacade.getTasks().size() == outputFacade.getSolvedTasks().size();
	}


	public List<Task> solve(){
		if (checkProblemSolved()){
			return outputFacade.getSolvedTasks();
		}
		return solve(inputFacade.getRulesWithDependencies());
	}
	
	private List<Task> solve(List<Rule> rules){
		int headIdx = 0;
		if(rules.isEmpty()){
			return outputFacade.getSolvedTasks();
		}
		
		Rule head = rules.get(headIdx);
		
		if(outputFacade.getSolvedTasks().containsAll(head.getDependents())){
			outputFacade.addResolvedTask(head.getTarget());
			return solve (rules
					.stream()
					.skip(1)
					.collect(Collectors.toList()));
		}
		else{
			List<Rule> tail = rules
					.stream()
					.skip(1)
					.collect(Collectors.toList());
			tail.add(head);
			return solve(tail);
		}
		
	}
	
	

}
