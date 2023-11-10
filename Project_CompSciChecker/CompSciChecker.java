/**
 * 
 * @author mellis
 * represents a single CompSciChecker piece
 * 
 */
public class CompSciChecker 
{
	private String color;
	private boolean reachedEnd;

	
	/**
	 * Constructs a CompSciChecker with given color
	 * @param color color of the piece
	 */
	public CompSciChecker(String color)
	{
		this.color = color;
		reachedEnd = false;

	}
	
	/**
	 * Constructs a CompSciChecker with given color and
	 * value for initializing reachedEnd
	 * @param color
	 * @param end
	 */
	public CompSciChecker(String color, boolean end)
	{
		this.color = color;
		this.reachedEnd = end;
	}
	

	
	/**
	 * 
	 * @return color of piece
	 */
	public String getColor()
	{
		return color;
	}
	
	
	public boolean reachedEnd()
	{
		return reachedEnd;
	}
	
	public void setReachedEnd(boolean reached)
	{
		reachedEnd = reached;
	}


}
