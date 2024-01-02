
public class InsufficientBalanceException extends RuntimeException
{


	private static final long serialVersionUID = 1233567L;
	
	
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
	
	
	public InsufficientBalanceException()
	{
		super();
	}
	

}
