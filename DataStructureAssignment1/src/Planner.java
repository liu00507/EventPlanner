import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**This is the planner class which supplies all the methods to handle the tasks which users wish to execute
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Planner
 */
public class Planner {
/**
 * Instance variable section where a ArralyList of events is decaled
 */
private ArrayList<Event> events=new ArrayList<>();

Planner(){}
/**
 * displays the events of a particular month, an enhanced for loop is used to loop through each event object 
 * and find the matching month
 * @param month is the month number which user wishes to display events for
 */
public void displayEventsMonthly(int month) {//menu 4
//	events.add(new Meeting(new OurDate(8,8,2020),new OurTime(15,30),"this is meeting","T307"));
//	events.add(new Work(new OurDate(10,8,2020),new OurTime(15,30),"this is meeting","T307",5));   //testing data
	System.out.println("Your calendar events for the given date are");
	printTitle();
	for(Event temp:events) {
		if(temp.date.getMonth()==month) System.out.println(temp.toString());	
	}
}
/**
 * this method simply displays every single event object in the arraylist and display them with an enhanced for loop
 */
public void displayAllEvents() {//7
	printTitle();
	for(Event temp:events) 
		System.out.println(temp.toString());	
	
}

/**
 * this static method display the title of the chart that gets printed on console
 */
public static void printTitle() {
	System.out.printf("%8s%8s%8s%7s%s%20s%13s%6s\n","Day|","Month|","Year|","Hour|","Minute|","Description|","Location|","Hours");
	System.out.println("=================================================================================");
}

/**
 * this method takes a sepcific date that user wishes to display
 * @param date is the particular date a user wishes to display events for
 */
public void displayEventsDaily(OurDate date) {//menu 2
	System.out.println("Your calendar events for the given date are");
	printTitle();
	for(Event temp:events) {
		if(temp.date.isEqual(date)) System.out.println(temp.toString());	
	}
}

/**
 * this method takes a specific date that user wishes to display and calculate which week of the year that date belongs to
 * then it will display the whole week of events that are registered in the array list
 * @param date is the particular date a user wishes to display events for the week where the date belongs to
 */
public void displayEventsWeekly(OurDate date) {//menu 3
	System.out.println("Your calendar events for the given date are");
	printTitle();
	Calendar c = Calendar.getInstance();Calendar d=Calendar.getInstance();
	c.set(date.getYear()-1900,date.getMonth(),date.getDay());
	int WeekOfDate = c.get(Calendar.WEEK_OF_YEAR);
	for(Event temp:events) {
		d.set(temp.date.getYear()-1900,temp.date.getMonth(),temp.date.getDay());
		int WeekNo=d.get(Calendar.WEEK_OF_YEAR);
		if(WeekNo==WeekOfDate) System.out.println(temp.toString());
	}
}
/**
 * This method take a particular date and time to delete the event that has matching result in the arraylist
 * @param myDate is the date when the user wishes to delete
 * @param myTime is the time of that particular date which the user wishes to delete
 */
public void deleteEvent(OurDate myDate, OurTime myTime) {//menu 5
	Event toRemove=null; //declare an temp Event object to avoid ConcurrentModificationException
	for(Event temp:events) {
		if(temp.date.isEqual(myDate) && temp.time.isEqual(myTime)) 
		toRemove=temp;
	}
	if(toRemove!=null) {events.remove(toRemove); System.out.println("Event deleted");}
	else System.out.println("There is no event scheduled for this date and time");
}

/**
 * Recusive binary search technique to search if an event object exists in an arraylist, return the index if there is
 * a match
 * @param temp is the event object that binary recusive search works on
 * @param first is the first index of the elements that binary recursive search works on
 * @param last is the last index of the elements that binary recursive search works on
 * @return -1 if the element is not found in the arraylist, != -1 when there is a match and return the
 * index of the element in the arraylist
 */
public int binarySearch(Event temp, int first, int last) {
	int mid=0;
	if (first > last) {
        return -1;
    }
	mid = (first+last)/2;
	if(events.get(mid).isEqual(temp)) {//date and time being the same
			return mid; //1 means event already exsits
	}
	else if(events.get(mid).date.isEqual(temp.date)){//date is the same, but not the time
		if(events.get(mid).time.isGreater(temp.time)) //time is greater
		return binarySearch(temp,first,mid-1);
		else//time is smaller
		return binarySearch(temp,mid+1,last);
	}
	else if(events.get(mid).date.isGreater(temp.date)) 
		return binarySearch(temp,first,mid-1);
	else
		return binarySearch(temp,mid+1,last);
}

/**
 * this method find the correct postition where the index should be for an event object, put the event with the correct
 * index in date ascending order
 * @param e is the event that is going to be placed into the arraylist 
 * @return 0 if the operation is success and -1 if the event already exists in the array list
 */
public int findPosition(Event e) {//re write // use method aboove
	if(events.isEmpty()) events.add(e);
	
	else if(binarySearch(e,0,events.size()-1)==-1)
		for (int i=events.size()-1;i>=0;i--) {
				 if(e.isGreater(events.get(i))) {
					 events.add(events.indexOf(events.get(i))+1, e);
					 return events.indexOf(events.get(i))+1;
				 }
				 else if(i==0 && !e.isGreater(events.get(i))){
					 events.add(0, e);
					 return 0;
					 }
			 }
	else
		System.out.println("You already have an event scheduled for that date and time.... cannot be added");
		return -1;
}
/**
 * This method prompts user to add an event from keyboard and put the event according to date with the correct 
 * index through calling findPosition() method
 * @param input is the scanner object that is used to read user input
 */
public void addEvent(Scanner input) {//menu 1
	Event temp = null;
	System.out.print("1. Meeting\n"
			+ "2. College\n"
			+ "3. Work\n"
			+ "4. Gym\n"
			+ "5. Social\n"
			+ "Enter type of event:\n");
	int choice=input.nextInt();
	OurDate date=new OurDate();
	OurTime time=new OurTime();
	switch(choice) {
	case 1:
		date.readDate(input);
		time.readTime(input);
		temp = new Meeting(date,time,null,null);
		temp.readInfo(input);
		break;
	case 2:
		date.readDate(input);
		time.readTime(input);
		temp = new School(date,time,null);
		temp.readInfo(input);
		break;
	case 3:
		date.readDate(input);
		time.readTime(input);
		temp = new Work(date,time,null,null,0);
		temp.readInfo(input);
		break;
	case 4:
		date.readDate(input);
		time.readTime(input);
		temp = new Gym(date,time,null);
		temp.readInfo(input);
		break;
	case 5:
		date.readDate(input);
		time.readTime(input);
		temp = new Social(date,time,null);
		temp.readInfo(input);
		break;
	default:
		System.out.println("No such menu option!");
	}
	if(temp!=null) findPosition(temp);
}
/**
 * This method uses the scanner to read the txt file line by line and contruct the correct object according to 
 * the event type. Then it will add events into the arraylist without sorting. A bubble sort algorithum is then 
 * called to put events in arraylist in date ascending order and remove the ones with conflicting time schedule
 * @param input is the scanner object that is used to read event.txt file
 */
public void readEventsFromFile(Scanner input) {//menu 6
	try{
		Event temp = null;
		ArrayList<Event> toRemove=new ArrayList<>();
		printTitle();
		input =new Scanner(new File("Events.txt"));
		while (input.hasNextLine()) {
			switch(Integer.parseInt(input.next())) {
			case 1:
				temp=new Meeting();
				temp.readInfoFromFile(input);
				break;
			case 2:
				temp=new School();
				temp.readInfoFromFile(input);
				break;
			case 3:
				temp=new Work();
				temp.readInfoFromFile(input);
				break;
			case 4:
				temp=new Gym();
				temp.readInfoFromFile(input);
				break;
			case 5:
				temp=new Social();
				temp.readInfoFromFile(input);
				break;
			}
			events.add(temp);
			System.out.println(temp.toString());
		}//while
//bubble sort dates
        for (int i = 0; i < events.size(); i++) 
            for (int j = i+1; j<events.size(); j++) 
                if (events.get(i).isGreater(events.get(j))) 
                {
                	Event tmp = events.get(i);
                	events.set(i,events.get(j));
                	events.set(j,tmp);
                } 
         for(Event e:events) {
        	 for (int i=0;i<events.indexOf(e);i++)
        		 if(e.isEqual(events.get(i))) {
        			 System.out.println("There is time conflict between:");
        			 System.out.println(e.toString());
        			 System.out.println("And:");
        			 System.out.println(events.get(i).toString());
        			 System.out.println("Events can not be added, both are removed! \n"
        			 		+ "Sorry for changing the assignment requirement here \n"
        			 		+ "as I thought it's more fair than deleting whichever event showed in the file first");
        			 toRemove.add(e);toRemove.add(events.get(i));
        		 }
         }	
        if(!toRemove.isEmpty()) events.removeAll(toRemove);
	} catch (FileNotFoundException e) {
		System.out.print("File Not Found! Please move 'Events.txt' into the project folder!");
	} catch (NoSuchElementException n) {}
}

}//class
