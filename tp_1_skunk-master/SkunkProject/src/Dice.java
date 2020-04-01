import edu.princeton.cs.introcs.StdOut;

public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
		this.lastRoll = this.die1.getLastRoll() + this.die2.getLastRoll();
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}
	
	public Die getDie1()
	{
		return this.die1;
	}
	
	public Die getDie2()
	{
		return this.die2;
	}
	
	public boolean hasSkunk() {
		if (die1.getLastRoll() == 1) return true;
		if (die2.getLastRoll() == 1) return true;
		return false;
	}
	
	public boolean oneSkunk()
	{
		return (getDie1().getLastRoll()==1 && getDie2().getLastRoll() != 1 || getDie1().getLastRoll()!=1 && getDie2().getLastRoll() == 1);
		
	}
	
	public boolean skunkDeuce()
	{
		return (getDie1().getLastRoll() * getDie2().getLastRoll() ==2);
	}
	
	public boolean twoSkunk()
	{
		return (getDie1().getLastRoll()==1 && getDie2().getLastRoll() == 1);
	}
	
	public String getTypeofSkunk()
	{
		if (oneSkunk())
		{
			return "Single Skunk!";
		}
		else if (skunkDeuce())
		{
			return "Skunk Deuce!";
		}
		else if (twoSkunk())
		{
			return "Two Skunk!";
		}
		else
		{
			return "";
		}
	}	

	public void roll()
	{
		// Roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Value of each thrown die: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}

	// static methods can go anywhere - but at end is one convention

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		// simulate repeated rolls of Dice, counting the many double skunks
		
		Dice dice = new Dice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice.roll();
			StdOut.println(dice);

			if (dice.getLastRoll() == 2)
				doubleSkunkCount++;
		}

		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
}