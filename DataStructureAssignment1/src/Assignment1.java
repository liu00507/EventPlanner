import java.util.*;
/**This is the assignment1 class with the main method which displays the menu, calls methods to handle tasks from 
 * the planner class and catch possible input mismatch exceptions.
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Assignment1 
 *
 */
public class Assignment1 {
/**the main method which displays the menu, calls methods to handle tasks from 
 * the planner class and catch possible input mismatch exceptions.
 * @param args supplied command-line arguments
 */
	public static void main(String[] args) {
		Planner pl=new Planner();
		System.out.println(
				"================================="+"\n"
				+"\t"+   "EVENTS PLANNER"		   +"\n"
				+"=================================");
		int choice=0;
		Scanner input = new Scanner(System.in);
			 do {
				 try {
				 System.out.println("1 ... Add an event from keyboard \n"
						 			+"2 ... Display events of a day \n"
						 			+"3 ... Display events of a week \n"
						 			+"4 ... Display events of a month \n"
						 			+"5 ... Delete an event \n"
						 			+"6 ... Add events from a file \n"
						 			+"7 ... Display all events \n"
						 			+"8 ... Quit \n" + "Enter your option:");
				 choice = input.nextInt();
				 OurDate date=new OurDate();
				 OurTime time=new OurTime();
				 switch(choice) {
				 case 1:
					 pl.addEvent(input);
					 break;
				 case 2:
					 date.readDate(input);
					 pl.displayEventsDaily(date);
					 break;
				 case 3:
					 date.readDate(input);
					 pl.displayEventsWeekly(date);
					 break;
				 case 4:
					 System.out.println("Enter the month for which events to be displayed:");
					 int month=input.nextInt();
					 if(month>0 && month<13)
					 pl.displayEventsMonthly(month);
					 else System.out.println("Invalid month number!");
					 break;
				 case 5:
					 System.out.println("Enter the date and time of the event to delete:");
					 date.readDate(input);
					 time.readTime(input);
					 pl.deleteEvent(date, time);
					 break;
				 case 6:
					 pl.readEventsFromFile(input);
					 break;
				 case 7:
					 pl.displayAllEvents();
					 break;
				 case 8:break;
				 case 9://secret testing mode for a sepecific method
					 pl.findPosition(new Event(new OurDate(2,5,2020),new OurTime(17,0),"desc"));
					 break;
				 default:
					 System.out.println("No Such Menu Option!");
					 break;
				 }
				 }catch(InputMismatchException e) {System.out.println("Input Mismatch Exception!");input.next();}
			 }while(choice!=8);
			System.out.print("Bye.... have a nice day!");
			input.close();
	}//main
}//class
