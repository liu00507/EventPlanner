import java.util.Scanner;
/**
 * This is the Meeting class which extends from Event superclass
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Meeting
 */
public class Meeting extends Event{
/**
 *location is the only instance variable over the Event super class for this Meeting class  
 */
private String location;

public Meeting() {}
/**
 * 4 arguments constructor of the meeting class which passes date and time object, string of description to its super class
 * @param date object that is associated with the event
 * @param time object that is associated with the event
 * @param desc string of description of the event super class
 * @param location is the instance variable of location string
 */
public Meeting(OurDate date, OurTime time, String desc, String location) {
	super(date,time,desc);
	this.location=location;
}
/**
 * overriden toString method to returned formatted meeting object
 */
public String toString() {
	return String.format("%7s|%7s|%7s|%6s|%6s|%19s|%12s|",super.date.getDay(),super.date.getMonth(),super.date.getYear(),super.time.getHour(),super.time.getMinute(),super.description,location); 
}
/**
 * this method first calls super class readInfo method which reads description and then reads the location info from user input
 */
public void readInfo(Scanner input) {
	super.readInfo(input);
	System.out.println("Enter location:");
	this.location=input.next();
}
/**
 * This method first calls super class readInfoFromFile method and reads then sets info off a file
 */
public void readInfoFromFile(Scanner input) {
	super.readInfoFromFile(input);
	this.location=input.next();
}

}
