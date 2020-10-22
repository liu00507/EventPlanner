/**
 * This is the School class which extends from Event superclass
 * @author Sam Liu
 * Student Number: 40984702
 * Class Name:School
 */
public class School extends Event{
	
public School() {}
/**
 * 3-arg constructor that takes a date object, a time object and description string then pass them into Event super class
 * @param date is the date object of an school event
 * @param time is the time object of an school event
 * @param desc is the desscription of the school event
 */
public School(OurDate date, OurTime time, String desc) {
	super(date,time,desc);
}
/**
 * overriden toString method to returned formatted school object
 */
public String toString() {
	return String.format("%7s|%7s|%7s|%6s|%6s|%19s|",date.getDay(),date.getMonth(),date.getYear(),time.getHour(),time.getMinute(),description);
}
}
