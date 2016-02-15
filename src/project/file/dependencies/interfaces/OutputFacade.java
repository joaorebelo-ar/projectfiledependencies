package project.file.dependencies.interfaces;

import java.util.List;

import project.file.dependencies.classes.Task;

/**
 * Interface that abstracts the output transformation
 * @author joao.rebelo
 *
 */
public interface OutputFacade {
	
	
	/**
	 * Method which should be capable of accepting a solved task.
	 * @param t - solved task
	 */
	public void addResolvedTask(Task t);
	
	/**
	 * Method which should be capable of adding and sorting the list of solved tasks received.
	 * @param tasks - list of solved tasks.
	 */
	public void addListOfSolvedTasks(List<Task> tasks);
	
	/**
	 * Method which should return an ordered list of the solved tasks.
	 * @return a list of solved tasks
	 */
	public List<Task> getSolvedTasks();
	

}
