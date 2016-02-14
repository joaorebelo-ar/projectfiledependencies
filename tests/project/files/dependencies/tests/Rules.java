package project.files.dependencies.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.file.dependencies.classes.Rule;
import project.file.dependencies.classes.Rule.RuleBuilder;
import project.file.dependencies.classes.Task;
import project.file.dependencies.classes.Task.TaskBuilder;

public class Rules {

	int taskNumber = 1;
	Task target = new TaskBuilder(taskNumber).build();
	List<Task> firstListOfDependents;
	List<Task> secondListOfDependents;
	
	
	@Before
	public void setUp() throws Exception {
		int i = taskNumber + 1;
		
		firstListOfDependents = Arrays.asList(
				new TaskBuilder(taskNumber + i++).build(),
				new TaskBuilder(taskNumber + i++).build(),
				new TaskBuilder(taskNumber + i++).build(),
				new TaskBuilder(taskNumber + i++).build());
		secondListOfDependents = Arrays.asList(
				new TaskBuilder(taskNumber + i++).build(),
				new TaskBuilder(taskNumber + i++).build(),
				new TaskBuilder(taskNumber + i++).build());
		
	}
	@Test
	public void testRuleConstruction(){
		Rule r = new RuleBuilder(target,firstListOfDependents.size(),firstListOfDependents).build();
		assertEquals(target,r.getTarget());
		assertEquals(firstListOfDependents.size(), r.getNumberOfDependents());
		assertEquals(firstListOfDependents, r.getDependents());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testRuleSizeDifference(){
		//Exception here
		Rule r = new RuleBuilder(target,secondListOfDependents.size(),firstListOfDependents).build();
		assertEquals(target,r.getTarget());
		assertEquals(firstListOfDependents.size(), r.getNumberOfDependents());
		assertEquals(firstListOfDependents, r.getDependents());
	}
	
}
