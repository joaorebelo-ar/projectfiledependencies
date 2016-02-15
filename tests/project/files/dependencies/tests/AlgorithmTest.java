package project.files.dependencies.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Rule.RuleBuilder;
import project.file.dependencies.classes.Task;
import project.file.dependencies.classes.Task.TaskBuilder;
import project.file.dependencies.implementation.AlgorithmImplementation;

public class AlgorithmTest {

	int taskGen = 1;
	Task t1 = new TaskBuilder(taskGen++).build(), t2 = new TaskBuilder(taskGen++).build(),
			t3 = new TaskBuilder(taskGen++).build(), t4 = new TaskBuilder(taskGen++).build(),
			t5 = new TaskBuilder(taskGen++).build();

	Rule r1 = new RuleBuilder(t3, 2, Arrays.asList(t1, t5)).build(),
			r2 = new RuleBuilder(t2, 2, Arrays.asList(t5, t3)).build(),
			r3 = new RuleBuilder(t4, 1, Arrays.asList(t3)).build(),
			r4 = new RuleBuilder(t5, 1, Arrays.asList(t1)).build();

	List<Rule> listWithoutDependencies = Arrays.asList(new RuleBuilder(t1, 0, Collections.emptyList()).build(),
			new RuleBuilder(t5, 0, Collections.emptyList()).build());

	AlgorithmImplementation algorithm;
	List<Rule> listWithDependencies;

	@Before
	public void setUp() throws Exception {
		//listWithDependencies = Arrays.asList(r1, r2, r3, r4);
		listWithDependencies = Arrays.asList(r1, r2, r3);
		List<Task> tasks = Arrays.asList(t1, t2, t3, t4, t5);

		algorithm = new AlgorithmImplementation(tasks, listWithDependencies);
	}

	@Test
	public void TestAlgorithmExerciseOne() {
		assertFalse(algorithm.isProblemSolved());
		List<Task> solvedCorrect = Arrays.asList(t1,t5,t3,t2,t4);
		List<Task> solved = algorithm.solve();
		System.out.println(solvedCorrect);
		System.out.println(solved);
		
		assertTrue(algorithm.isProblemSolved());
		assertEquals(solvedCorrect,solved);
	}

}
