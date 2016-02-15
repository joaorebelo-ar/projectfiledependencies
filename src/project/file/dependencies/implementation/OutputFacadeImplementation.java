package project.file.dependencies.implementation;

import java.util.ArrayList;
import java.util.List;

import project.file.dependencies.classes.Task;
import project.file.dependencies.interfaces.OutputFacade;

public final class OutputFacadeImplementation implements OutputFacade {
	
	List<Task> solvedTasks = new ArrayList<>();
	
	@Override
	public void addResolvedTask(Task t) {
		solvedTasks.add(t);
	}

	@Override
	public void addListOfSolvedTasks(List<Task> tasks) {
		solvedTasks.addAll(tasks);
	}

	@Override
	public List<Task> getSolvedTasks() {
		return solvedTasks;
	}

}
