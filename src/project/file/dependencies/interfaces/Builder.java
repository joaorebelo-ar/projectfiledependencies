package project.file.dependencies.interfaces;


/**
 * A builder interface which allows immutable type creation.
 * 
 * @author joao.rebelo
 *
 * @param <T> - the Type which will be built
 */
public interface Builder<T> {

	public T build();
}
