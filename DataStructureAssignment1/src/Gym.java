/**
 * This is the Gym class which extends from Event superclass
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:Gym
 */
public class Gym extends Event{
	
public Gym() {}
/**
 * 3-arg constructor that takes a date object, a time object and description string then pass them into Event super class
 * @param date is the date object of an gym event
 * @param time is the time object of an gym event
 * @param desc is the desscription of the gym event
 */
public Gym(OurDate date, OurTime time, String desc) {
	super(date,time,desc);
}
/**
 * overriden toString method to returned formatted gym object
 */
public String toString() {
	String text=String.format("%7s|%7s|%7s|%6s|%6s|%19s|",date.getDay(),date.getMonth(),date.getYear(),time.getHour(),time.getMinute(),description);
	return text;
}
}
