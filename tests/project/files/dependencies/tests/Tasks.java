package project.files.dependencies.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.file.dependencies.classes.Task.TaskBuilder;

public class Tasks {

	@Test
	public void testTaskImmutable() {
		int value = 1;
		assertEquals(value, new TaskBuilder(value).build().getTaskNumber());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testLowerIndex(){
		int lowerIndex = -1;
		new TaskBuilder(lowerIndex).build().getTaskNumber();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testHigherIndex(){
		int higherIndex = 101;
		new TaskBuilder(higherIndex).build().getTaskNumber();
	}
	

}
