import java.util.Scanner;
/**
 * This is the work class which extends from Event superclass
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Work
 */
public class Work extends Event{
/**
 * instance varibale, which consists of a string of location and a double of work hours
 */
private String location;
private double numHours;

public Work() {}
/**
 * 5-arg constructor that takes a date object, a time object and description string then pass them into Event super class
 * then set the string of location and double hours
 * @param date is the date object of an work event
 * @param time is the time object of an work event
 * @param desc is the desscription of the work event
 * @param location is the string of location info of work event
 * @param hrs is the hours of work 
 */
public Work(OurDate date, OurTime time, String desc, String location, double hrs) {
	super(date,time,desc);
	this.location=location;
	this.numHours=hrs;
}
/**
 * overriden toString method to returned formatted work object
 */
public String toString() {
	return String.format("%7s|%7s|%7s|%6s|%6s|%19s|%12s|%4s",super.date.getDay(),super.date.getMonth(),super.date.getYear(),super.time.getHour(),super.time.getMinute(),super.description,location,numHours);
}
/**
 * this method first calls super class readInfo method which reads description and then reads the location and work hour from user input
 */
public void readInfo(Scanner input) {
	super.readInfo(input);
	System.out.println("Enter location:");
	this.location=input.next();
	System.out.println("Enter number of hours worked:");
	this.numHours=input.nextDouble();
}
/**
 * This method first calls super class readInfoFromFile method and reads then sets info off a file
 */
public void readInfoFromFile(Scanner input) {
	super.readInfoFromFile(input);
	this.location=input.next();
	this.numHours=input.nextDouble();
}
}
