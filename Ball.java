/**
 * Models a simple solid sphere. 
 * This class represents a Ball object. When combined with the GameArena class,
 * instances of the Ball class can be displayed on the screen.
 */
public class Ball 
{
	// The following instance variables define the
	// information needed to represent a Ball
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this ball
	private double yPosition;			// The Y coordinate of this ball
	private double size;				// The diameter of this ball
	private int layer;					// The layer of this ball is on
	private String colour;				// The colour of this ball
	private int num;					// The number of this ball
	private double XSpeed;				// The speed of the ball on the X axis 
	private double YSpeed;				// The speed of the ball on the Y axis

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW or #RRGGBB 

	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 */
	public Ball(double x, double y, double diameter, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = 0;
	}	

	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param layer The layer this ball is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 */
	public Ball(double x, double y, double diameter, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = layer;
	}	

	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param layer The layer this ball is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 * @param num The number that represents the ball.
	 */
	public Ball(double x, double y, double diameter, String col, int layer, int number, double speedX, double speedY)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = layer;
		this.num = number;
		this.XSpeed = speedX;
		this.YSpeed = speedY;
	}
	/**
	 * Sets a new speed for the ball to move to on the X axis
	 * @param x the speed which the ball moves on the X axis
	 */
	public void setXSpeed(double x)
	{
		this.XSpeed = x;
	}

	/**
	 * Sets a new speed for the ball to move to on the Y axis
	 * @param y the speed which the ball moves on the Y axis
	 */
	public void setYSpeed(double y)
	{
		this.YSpeed = y;
	}

	/**
	 * Returns the speed in which the ball moves on the X axis, in double
	 * @return Speed of ball on the X axis
	 */
	public double getXSpeed()
	{
		return XSpeed;
	}

	/**
	 * Returns the speed in which the ball moves on the Y axis, in doubl
	 * @return Speed of ball on the Y axis
	 */
	public double getYSpeed()
	{
		return YSpeed;
	}
	
	public int getNum()
	{
		return num;
	}
	/**
	 * Obtains the current position of this Ball.
	 * @return the X coordinate of this Ball within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the current radius of this Ball.
	 * @return the radius of this Ball.
	 */
	public double getRadius(){
		double radius = getSize()/2;
		return radius;
	}

	/**
	 * Obtains the current position of this Ball.
	 * @return the Y coordinate of this Ball within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param x the new x co-ordinate of this Ball
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param y the new y co-ordinate of this Ball
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	/**
	 * Obtains the size of this Ball.
	 * @return the diameter of this Ball,in pixels.
	 */
	public double getSize()
	{
		return size;
	}
	
	/**
	 * Sets the diameter of this Ball to the given size.
	 * @param s the new diameter of this Ball, in pixels.
	 */
	public void setSize(double s)
	{
		size = s;
	}

	/**
	 * Obtains the layer of this Ball.
	 * @return the layer of this Ball.
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * Obtains the colour of this Ball.
	 * @return a textual description of the colour of this Ball.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Sets the colour of this Ball.
	 * @param c the new colour of this Ball, as a String value. Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB.
	 */
	public void setColour(String c)
	{
		colour = c;
	}

	/**
	 * Moves this Ball by the given amount.
	 * 
	 * @param dx the distance to move on the x axis (in pixels)
	 * @param dy the distance to move on the y axis (in pixels)
	 */
	public void move()
	{
		xPosition += this.getXSpeed();
		yPosition += this.getYSpeed();

		double xSpeed = this.getXSpeed();
		double ySpeed = this.getYSpeed();

		this.setXSpeed(xSpeed *= 0.97);
		this.setYSpeed(ySpeed *= 0.97);

		if(this.getXSpeed() >= -0.05 && this.getXSpeed() <= 0.1){
			this.setXSpeed(0);
		}
		else if (this.getYSpeed() >= -0.05 && this.getYSpeed() <= 0.1){
			this.setYSpeed(0);
		}

				if (this.getXPosition() < 120)
                    this.setXSpeed(-this.getXSpeed());
                if (this.getXPosition() > 1840)
                    this.setXSpeed(-this.getXSpeed());
                if (this.getYPosition() < 190)
                    this.setYSpeed(-this.getYSpeed());
                if (this.getYPosition() > 905)
                    this.setYSpeed(-this.getYSpeed());;
	}

	/**
	 * Determines if this Ball is overlapping the given ball.
	 * 
	 * @param b the ball to test for collision
	 * @return true of this ball is overlapping the ball b, false otherwise.
	 */
	public boolean collides(Ball b)
	{
		double dx = b.xPosition - xPosition;
		double dy = b.yPosition - yPosition;
		double distance = Math.sqrt(dx*dx+dy*dy);

		return distance < size/2 + b.size/2;
	}
}
