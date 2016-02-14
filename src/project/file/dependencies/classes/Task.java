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
			//No need for a defensive copy here.
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
	
	@Override
	public String toString(){
		return "Task: " + taskNumber;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + taskNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (taskNumber != other.taskNumber)
			return false;
		return true;
	}
	
	

}
