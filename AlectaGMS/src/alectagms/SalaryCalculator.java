package alecta;
import java.util.Calendar;

/*
 * Salary Calculator
 */

public class SalaryCalculator {
    
    private int HOURS = 9; //No of maximum hours for work per day
    private int HOURS_SAT = 5; //No of maximum hours for Saturday
    private double salaryPerHour;
    private double salaryOT1 = 12.5;
    private double salaryOT2 = 25;
    private double attendanceAllowance = 1000;
    private Calendar c; //Calendar instance to set the date
    private Employee employee;
    private double netSalary;
    
    public SalaryCalculator(int year, int month) {
        c = Calendar.getInstance();
        c.set(Calendar.YEAR, year); //Set the year and month
        c.set(Calendar.MONTH, month);
        netSalary = 0;
    }
     
    private void calculate() {       
        double workHours = c.getActualMaximum(Calendar.DAY_OF_MONTH) * HOURS + getSaturdays() * HOURS_SAT;
        
        salaryPerHour = employee.getBasic() / workHours;
        
        double salary = employee.getAttendance().getWork_hours() * salaryPerHour + employee.getAttendance().getOverTime1_hours() * salaryOT1 + employee.getAttendance().getOverTime2_hours() * salaryOT2;
        
        if(employee.getAttendance().getAbsentDays() <= 1) {
            salary += attendanceAllowance;
        }
        
        netSalary = salary - employee.getExpenses();
    }
    
    public double getSalary(Employee e) {
        employee = e;
        calculate();
        return netSalary;
    }
    
    private double getSaturdays() { //Get the no of saturdays in the month
        double saturdays = 0;
        Calendar sat = Calendar.getInstance(); //Calendar instance to count the no of Saturdays
        sat.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1); //Set the year and month
        for( int i=2; i <= sat.getActualMaximum(Calendar.MONTH); i++ ) { //Iterate through the month
            if( sat.get(Calendar.DAY_OF_WEEK) == 7 ) { //If it is a Saturday count
                saturdays++;
            }
            sat.set(Calendar.DAY_OF_MONTH, i);
        }
        return saturdays;
    }
}
