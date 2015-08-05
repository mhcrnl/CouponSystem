package exceptions;

public class objectAlreadyExistException extends Exception
{
	public objectAlreadyExistException()
	{
		super("Object you are trying to add already exists");
	}
}
