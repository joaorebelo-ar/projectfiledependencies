package project.file.dependencies.classes;

import project.file.dependencies.interfaces.Builder;

/**
 * Class representing a Task.
 * 
 * <div style='font-weight:bold' > Thread Safety: Immutable</div>
 * 
 * @author joao.rebelo
 * 
 * 
 */
public final class Task {
	
	private final int taskNumber;
	
	public int getTaskNumber(){
		return taskNumber;		
	}
	
	private Task(TaskBuilder b){
		this.taskNumber = b.taskNumber;
	}
	
	/**
	 * The builder inner type for {@link Task}.
	 *  
	 * @author joao.rebelo
	 */
	public final static class TaskBuilder implements Builder<Task>{

		private int taskNumber;
		
		/**
		 * 
		 * @param taskNumber
		 * @throws IndexOutOfBoundsException if taskNumber < 0 or taskNumber > 100
		 */
		public TaskBuilder(int taskNumber){
			validateTaskNumber(taskNumber);
			this.taskNumber = taskNumber;
			
		}
		
		public TaskBuilder setTaskNumber(int taskNumber){
			validateTaskNumber(taskNumber);
			this.taskNumber = taskNumber;
			return this;
		}
		
		private void validateTaskNumber(int taskNumber){
			if(taskNumber <0 || taskNumber > 100){
				throw new IndexOutOfBoundsException("Index out of range: " + taskNumber);
			}
		}		
		
		@Override
		public Task build() {
			return new Task(this);
		}
		
		
	}

}
