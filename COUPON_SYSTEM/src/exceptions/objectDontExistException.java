package exceptions;

public class objectDontExistException extends Exception
{
	public objectDontExistException()
	{
		super("Object you are looking for does not exist");
	}
}
