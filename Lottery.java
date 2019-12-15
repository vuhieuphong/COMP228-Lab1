import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	//instance variables
	Random rand = new Random();
	private int firstDigit;
	private int secondDigit;
	//class variables
	private static List<String> firstPlaceWinners=new ArrayList<String>(); 
	private static List<String> secondPlaceWinners=new ArrayList<String>();
	private static List<String> thirdPlaceWinners=new ArrayList<String>();
	//non-static methods
	//method to get lottery number
	public String getLotteryNumber() {
		firstDigit=rand.nextInt(10);
		secondDigit=rand.nextInt(10);
		return Integer.toString(firstDigit)+Integer.toString(secondDigit);
	}
	//method to get lottery result
	public void getLotteryResult(int chosenNumber,String name) {
		int firstChosenDigit=(int)chosenNumber/10;
		int secondChosenDigit=chosenNumber%10;	
		if(firstChosenDigit==firstDigit&&secondChosenDigit==secondDigit)
		{
			System.out.println("You won $1,000,000.");	
			firstPlaceWinners.add(name);
		}	
		else if(firstChosenDigit==secondDigit&&secondChosenDigit==firstDigit)
		{
			System.out.println("You won $500,000.");	
			secondPlaceWinners.add(name);
		}
		else if((firstChosenDigit==firstDigit)
				&&(secondChosenDigit!=secondDigit))
		{
			System.out.println("You won $100,000.");
			thirdPlaceWinners.add(name);
		}
		else if((firstChosenDigit==secondDigit)
				&&(secondChosenDigit!=firstDigit))
		{
			System.out.println("You won $100,000.");
			thirdPlaceWinners.add(name);
		}
		else if((secondChosenDigit==firstDigit)
				&&(firstChosenDigit!=secondDigit))
		{
			System.out.println("You won $100,000.");
			thirdPlaceWinners.add(name);
		}
		else if((secondChosenDigit==secondDigit)
				&&(firstChosenDigit!=firstDigit))
		{
			System.out.println("You won $100,000.");
			thirdPlaceWinners.add(name);
		}
		else 
		{
			System.out.println("Sorry no luck this time.");		
		}
	}
	//method to get the lottery leaderboard
	public void getLeaderBoard() 
	{
		System.out.println("====LEADERBOARD====");
		System.out.print("$1 million winners: ");
		for(int i=0;i<firstPlaceWinners.size();i++)
		{				
			System.out.print(firstPlaceWinners.get(i)+", ");
		}
		System.out.println();
		System.out.print("$500,000 winners: ");
		for(int i=0;i<secondPlaceWinners.size();i++)
		{
			System.out.print(secondPlaceWinners.get(i)+", ");
		}
		System.out.println();
		System.out.print("$100,000 winners: ");
		for(int i=0;i<thirdPlaceWinners.size();i++)
		{
			System.out.print(thirdPlaceWinners.get(i)+", ");
		}	
	}
	
	public static void main(String[] args) {		
		System.out.println("Welcome to the Lottery program!");		
		while(true)
		{	
			//getting user input
			Scanner input=new Scanner(System.in);
			System.out.print("Want to place a bet? (y/n): ");
			String chosenChoice=input.next();	
			if(chosenChoice.equals("y"))
			{
				System.out.print("Enter your name: ");
				String name=input.next();
				
				System.out.print("Pick a two digit number: ");
				int chosenNumber=input.nextInt();			
				while(true) 
				{
					if(chosenNumber>=0&&chosenNumber<100)
					{
						break;
					}
					else
					{
						System.out.print("Invalid number. Pick a two digit number: ");
						chosenNumber=input.nextInt();
					}
				}				
								
				Lottery newLottery=new Lottery();
				String lotteryNumber=newLottery.getLotteryNumber();
				System.out.println("The lottery number is: "+lotteryNumber);
				
				newLottery.getLotteryResult(chosenNumber, name);	
				
				System.out.println();
				newLottery.getLeaderBoard();
				System.out.println();
				System.out.println();
			}
			else if(chosenChoice.equals("n"))
			{
				System.out.println("Goodbye!");
				break;				
			}
			else
			{
				System.out.println("Invalid choice. Try again. ");
			}
		}	
	}	
}
