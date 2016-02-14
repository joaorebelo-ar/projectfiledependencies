package project.files.dependencies.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Rule.RuleBuilder;
import project.file.dependencies.classes.Task;
import project.file.dependencies.classes.Task.TaskBuilder;
import project.file.dependencies.implementation.InputFacadeImplementation;

public class InputFacade {
	
	int taskGen = 1;
	Task t1 = new TaskBuilder(taskGen++).build(),
		 t2 = new TaskBuilder(taskGen++).build(),
		 t3 = new TaskBuilder(taskGen++).build(),
		 t4 = new TaskBuilder(taskGen++).build(),
		 t5 = new TaskBuilder(taskGen++).build();
	
	Rule r1 = new RuleBuilder(t3, 2, Arrays.asList(t1,t5)).build(),
		 r2 = new RuleBuilder(t2, 2, Arrays.asList(t5,t3)).build(),
		 r3 = new RuleBuilder(t4, 1, Arrays.asList(t3)).build();
	
	List<Rule> listWithoutDependencies = Arrays.asList(
			new RuleBuilder(t1, 0, Collections.emptyList()).build(),
			new RuleBuilder(t5, 0, Collections.emptyList()).build());
		
	InputFacadeImplementation infac;
	List<Rule> listWithDependencies;
	
	@Before
	public void setUp() throws Exception {
		listWithDependencies = Arrays.asList(r1,r2,r3);
		List<Task> tasks = Arrays.asList(t1,t2,t3,t4,t5);
		
		infac = new InputFacadeImplementation(listWithDependencies.size(), listWithDependencies, tasks.size(), tasks);	
				
		
	}

	@Test
	public void testListWithoutDependencies() {
		assertEquals(listWithoutDependencies,infac.getRulesWithoutDependencies());
	}
	
	@Test
	public void testListWithDependencies(){
		assertEquals(listWithDependencies,infac.getRulesWithDependencies());
	}

}
