package alecta;

import java.sql.Time;

/*
 * Keeps the daily attendance details of the employee
 */
// mokakda me branch scene eka :(
public class DailyAttendance {
    
    private Time arrival; // Time of arrival
    private Time departure; // Time of departure
    private double hours; //No of hours the employee has worked for the day 
    private boolean leave; //*********If the employee has a leave or not
    private boolean present; //If the employee is present for the day

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public void setLeave(boolean leave) {
        this.leave = leave;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public boolean isLeave() {
        return leave;
    }

    public boolean isPresent() {
        return present;
    }

    public double getHours() {
        hours = (departure.getTime() - arrival.getTime()) / 3600.00;
        return hours;
    }       
}
