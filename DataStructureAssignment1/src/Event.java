import java.util.*;
/**
 * This is the Event super class
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Event
 */
public class Event {
/**
 * instance variables that includes associative date and time object from OurDate and Ourtime class, and a string of description
 */
protected String description;
protected OurDate date;
protected OurTime time;

Event() {}
/**
 * 3-arg constructor of Event class, set instance variable
 * @param date is the date object of an event
 * @param time is the time object of an event
 * @param desc is the desscription of the event
 */
Event(OurDate date, OurTime time, String desc){
	this.date=date;
	this.time=time;
	this.description=desc;
}
/**
 * overriden toString method to returned formatted event object
 */
public String toString() {
String text=String.format("%7s|%7s|%7s|%6s|%6s|%19s|",date.getDay(),date.getMonth(),date.getYear(),time.getHour(),time.getMinute(),description);
return text;
}
/**
 * compare the date and time with the input parameter and return true if it's equal
 * @param e is the event we want to compare to with this object
 * @return true if the date and time are equal
 */
public boolean isEqual(Event e) {
	return this.date.isEqual(e.date) && this.time.isEqual(e.time); //&& this.description.equals(e.description);
}
/**
 * compare the date and time with the input parameter and return true if it's greater
 * @param e is the event we want to compare to with this object
 * @return true if this date and time are greater than e.date and e.time
 */
public boolean isGreater(Event e) {
	return this.date.isGreater(e.date) || (this.date.isEqual(e.date) && this.time.isGreater(e.time));
}
/**
 * read description info from the user
 * @param input is the scanner object that reads the event description from user
 */
public void readInfo(Scanner input) {
	System.out.println("Enter description:");
	this.description=input.next();
}
/**
 * read info from file, the scanner will read whole line of the file and put it in the buffer first then this method reads what's in the line
 * @param input is the scanner object that we use to read information from file
 */
public void readInfoFromFile(Scanner input) {
	this.date=new OurDate(Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next()));
	this.time=new OurTime(Integer.parseInt(input.next()),Integer.parseInt(input.next()));
	this.description=input.next();
}

}//class
