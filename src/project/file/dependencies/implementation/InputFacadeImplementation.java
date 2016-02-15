package project.file.dependencies.implementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Rule.RuleBuilder;
import project.file.dependencies.classes.Task;
import project.file.dependencies.interfaces.InputFacade;

public final class InputFacadeImplementation implements InputFacade {

	private final List<Task> tasks;
	private final List<Rule> rulesWithDependencies;
	private final List<Rule> rulesWithoutDependencies;
	
	private final int numberOfRules, numberOfTasks;
	
	//Assumes previous validations where made
	//Doesn't guarantee corrected behaviour if invoked incorrectly
	public InputFacadeImplementation(int nrOfRules, List<Rule> rules, int nrOfTasks, List<Task> tasks) {
		this.numberOfRules = nrOfRules;
		this.numberOfTasks = nrOfTasks;
		this.tasks = Collections.unmodifiableList(tasks);
		
		this.rulesWithDependencies = Collections.unmodifiableList(rules);
		
		if(nrOfTasks == rules.size()){
			this.rulesWithoutDependencies = Collections.emptyList();
		}
		else{
			//Create rules without dependencies and sort
			this.rulesWithoutDependencies = Collections.unmodifiableList(
					tasks
						.stream()
						.filter(task ->	rulesWithDependencies.stream().filter(rule -> rule.getTarget().equals(task)).count() == 0)
						.sorted( (t1, t2) -> t1.getTaskNumber() - t2.getTaskNumber())
						.map(task -> new RuleBuilder(task,0,Collections.emptyList()).build()).collect(Collectors.toList())						
					);
					
					
		}
	}
	
	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public List<Rule> getRulesWithDependencies() {
		return rulesWithDependencies;
	}
	
	@Override
	public List<Rule> getRulesWithoutDependencies() {
		return rulesWithoutDependencies;
	}

	@Override
	public boolean hasDependents(Rule r) {
		return r.hasDependencies();
	}
	
}
