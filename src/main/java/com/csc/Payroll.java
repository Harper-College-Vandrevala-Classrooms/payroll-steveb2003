package com.csc;
import java.util.Scanner;
public class Payroll 
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Welcome to the Payroll Calculator! ");
    System.out.print("Please enter in the number of hours worked this week: ");
    int hours_worked = in.nextInt();
    
    System.out.print("Please enter the number of dependents you have: ");
    int dependents = in.nextInt();

    System.out.print("Please enter your pay rate: ");
    double pay_rate= in.nextDouble();

    double gross_pay = total_pay(hours_worked, pay_rate);
    double total_expenses = expenses(gross_pay, dependents);

    in.nextLine();
    
    System.out.print("Please enter your life insurance plan. Enter 'Single Plan' if single, 'Married Plan' if married, 'Married with Children' if you have a family, or 'No Plan' if you have no plan: ");
    String plan = in.nextLine();
    if (plan.equals("Single Plan"))
    {
      total_expenses +=5;
    }

    else if (plan.equals("Married Plan"))
    {
      total_expenses += 10;
    }

    else if (plan.equals("Married with Children"))
    {
      total_expenses +=15;
    }

    else if (plan.equals("No Plan"))
    {
      total_expenses +=0;
    }



    System.out.printf("%nTotal Hours Worked: %d%nGross Pay: %7.2f%nTotal Expenses: %7.2f%nNet Pay: %7.2f%n", hours_worked, gross_pay, total_expenses, gross_pay - total_expenses);
    System.out.print("Goodbye!");
    in.close();

  }
  public static double total_pay(int hours_worked, double pay_rate)
  {
    final int REGULAR_TIME = 40;
    double gross_pay;
    if (hours_worked>0 && hours_worked <= REGULAR_TIME)
    {
      gross_pay = hours_worked * pay_rate;
    }
    else if (hours_worked > REGULAR_TIME)
    {
      gross_pay = (40 * pay_rate) + ((hours_worked - REGULAR_TIME) * pay_rate * 1.5);
    }
    else
    {
      gross_pay = 0;
      System.out.print("Please enter a positive number of hours%n");
    }
    return gross_pay;
  }
    
  public static double expenses(double gross_pay, int dependents)
  {
    final double SOCIAL_SECURITY_TAX = 0.06;
    final double FED_INCOME_TAX = 0.14;
    final double STATE_INCOME_TAX = 0.05;
    final double UNION_DUES = 10;
  
    double total_expenses = (gross_pay * (SOCIAL_SECURITY_TAX + FED_INCOME_TAX + STATE_INCOME_TAX)) + UNION_DUES;
    if (dependents >= 3 )
    {
      total_expenses += 35;
    }
    else if (dependents >=0 && dependents < 3 )
    {
      total_expenses += 15;
    }
    else
    {
      total_expenses +=0;
      System.out.print("Please enter a positive number of dependents");
    }

    return total_expenses;
  }    
 
}



