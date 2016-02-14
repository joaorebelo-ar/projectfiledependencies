package project.file.dependencies.classes;

import java.util.List;

import project.file.dependencies.interfaces.Builder;

/**
 * Class representing a Rule with a target and a given number of dependents.
 * 
 * <div style='font-weight:bold' > Thread Safety: Immutable</div>
 * @author joao.rebelo
 * 
 */
public final class Rule {
	
	private final Task target;
	
	private final int numberOfDependents;
	
	private final List<Task> dependents;
	
		
	public Task getTarget() {
		return target;
	}

	public int getNumberOfDependents() {
		return numberOfDependents;
	}

	public List<Task> getDependents() {
		return dependents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependents == null) ? 0 : dependents.hashCode());
		result = prime * result + numberOfDependents;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Rule other = (Rule) obj;
		if (dependents == null) {
			if (other.dependents != null)
				return false;
		} else if (!dependents.equals(other.dependents))
			return false;
		if (numberOfDependents != other.numberOfDependents)
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rule [target=" + target + ", numberOfDependents=" + numberOfDependents + ", dependents=" + dependents
				+ "]";
	}

	public boolean hasDependencies(){
		return !dependents.isEmpty();
	}
	
	private Rule(RuleBuilder b){
		this.target = b.target;
		this.numberOfDependents = b.numberOfDependents;
		this.dependents = b.dependents;
	}

	public final static class RuleBuilder implements Builder<Rule>{
		
		private Task target;
		private int numberOfDependents;
		private List<Task> dependents;
		
		public RuleBuilder(Task target, int numberOfDependents, List<Task> dependents){
			
			//Defensive referencing
			List<Task> referenceOfDependents = dependents;
				
			
			this.target = target;
			this.numberOfDependents = numberOfDependents;
			this.dependents = referenceOfDependents;
		}
		
		public RuleBuilder setTarget(Task target){
			this.target = target;
			return this;
		}		
		
		public RuleBuilder setNumberOfDependents(int numberOfDependents){
			this.numberOfDependents = numberOfDependents;
			return this;
		}
		
		public RuleBuilder setDependents(List<Task> dependents){
			List<Task> referenceOfDependents = dependents;
			this.dependents = referenceOfDependents;
			return this;
		}
		
		@Override
		public Rule build() {
			validateInput();
			return new Rule(this);
		}
		
		private void validateInput(){
			if(numberOfDependents != dependents.size())
				throw new IllegalStateException("Sizes declared don't match " + numberOfDependents + "!=" + dependents.size());
		}
	}
	
}
