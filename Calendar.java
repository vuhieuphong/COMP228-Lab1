import java.util.Scanner;

public class Calendar {
	//method to print the calendar of the month
	public void printMonth(int year,int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);         
	 }
	//method to print the month title
	private void printMonthTitle(int year, int month) {
		String[] months = {"","January", "February", "March","April", "May", "June",
	            "July", "August", "September","October", "November", "December"};
		System.out.println();
        System.out.println("Calendar for "+months[month] + " " + year);
	}
    //method to print the days of the month  
	private void printMonthBody(int year, int month) {
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//days of month in a leap year		
		if(((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0)) && month == 2)
        {
        	days[2] = 29;            	
        }
                
        System.out.println("===================================");
        System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat");
               
        
        int startDayOfMonthSpaces = getStartDayOfMonthSpaces(year, month);
        //print the blank spaces at the start of a month
        for (int i = 0; i < startDayOfMonthSpaces; i++)
        {
        	System.out.print("     ");
        }
        //print the days of the month    
        for (int day = 1; day <= days[month]; day++) {
            System.out.printf(" %3d ", day);
            if ((day + startDayOfMonthSpaces) % 7 == 0)
            {
            	System.out.println();
            }
        }
        System.out.println();
        System.out.println("===================================");
        System.out.println();
	}
    //method to get the number of blanks spaces at the start of the month
	private int getStartDayOfMonthSpaces(int year, int month) {
		int startDayOfMonth=0;
		int startDayOfMonthSpaces=0;
        //algorithm to determine weekday of the first day of the month in Gregorian calendar
        if (month == 1) 
		{ 
			month = 13; 
			year--; 
		} 
		if (month == 2) 
		{ 
			month = 14; 
			year--; 
		} 
		int Y = year % 100; 
		int C = year / 100; 
		startDayOfMonth = 1 + 13*(month + 1) / 5 + Y + Y / 4 + C / 4 + 5 * C; 
		startDayOfMonth = startDayOfMonth % 7; 
        if(startDayOfMonth==0)
        {
        	startDayOfMonthSpaces=6;
        }
        else
        {
        	startDayOfMonthSpaces=startDayOfMonth-1;
        }
		return startDayOfMonthSpaces;
	}
	
	public static void main(String[] args) {
		System.out.println("==WELCOME TO GREGORIAN CALENDAR==");
		while(true)
		{
			//get user input
			Scanner input = new Scanner(System.in);
			System.out.print("Would you like to look at calendar? (y/n): ");
			String choice=input.next();
			if(choice.equals("y"))
			{
				System.out.print("Enter a year: ");
		        int year = input.nextInt();
		        while(true) {
		        	if(year<1)
			        {
			        	System.out.print("Year must be greater than 0. Enter another year: ");
				        year = input.nextInt();
			        }
		        	else
		        	{
		        		break;
		        	}
		        }
		        	        
				System.out.print("Enter a month: ");
		        int month = input.nextInt();
		        while(true) {
		        	if(month<1||month>12)
			        {
			        	System.out.print("Month must be between 1 and 12. Enter another month: ");
				        month = input.nextInt();
			        }
		        	else
		        	{
		        		break;
		        	}
		        }
		                
		        Calendar newCalendar=new Calendar();
		        
		        newCalendar.printMonth(year,month);
			}
			else if(choice.equals("n"))
			{
				System.out.println("Bye!");
				break;				
			}
			else
			{
				System.out.println("Invalid choice! Please choose again.");
			}
		}
			    
	}

}
