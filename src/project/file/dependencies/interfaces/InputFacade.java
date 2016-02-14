package project.file.dependencies.interfaces;

import java.util.List;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Task;

/**
 * Interface that abstracts the input transformation
 * @author joao.rebelo
 *
 */
public interface InputFacade {
	
	/**
	 * Method which should return a list of tasks for a given input
	 * @return list of tasks present in the input
	 */
	public List<Task> getTasks();
	
	/**
	 * Method which should return the rules with dependencies associated with the tasks returned by {@link InputFacade#getTasks()}
	 * @return list of rules present in the input
	 */
	public List<Rule> getRulesWithDependencies();
	
	/**
	 * Method which should return the rules without dependencies associated with the tasks returned by {@link InputFacade#getTasks()}
	 * @return list of rules present in the input
	 */
	public List<Rule> getRulesWithoutDependencies();
	
	
	
	/**
	 * Method which checks the existence of dependencies in {@link Rule} r
	 * @param r - Rule on which to check if there are any dependents.
	 * @return true if r has dependents; false if r has no dependents
	 */
	public boolean hasDependents(Rule r);
}
