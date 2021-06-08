import java.io.*;
/**
 * Write a description of class Validator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validator
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Validator
     */
    public Validator()
    {
        // initialise instance variables
    }
    
    /**
     * To validate registration number
     * @param regNo of type string
     * @return void
     */
    public void validateRegNo(String regNo) throws Exception
    {
        if (regNo == "" || regNo.length() > 6)
        {
            throw new Exception("registration number cannot be blank");
        }
        if (!isAlphaNumeric(regNo))
        {
            throw new Exception("Registration number can only contain “A”-“Z”, “a”-“z” or “0-9");
        }
        return;
    }
    
    /**
     * To validate main menu input choice
     * @param i of type int
     * @return void
     */
    public void validateMainMenuInput(int i) throws Exception
    {
        if (i > 5 || i < 1)
        {
            throw new Exception("Invalid input value");
        }
        return;
    }
    
    /**
     * To validate search menu input choice
     * @param i of type int
     * @return void
     */
    public void validateSearchMenuInput(int i) throws Exception
    {
        if (i > 5 || i < 1)
        {
            throw new Exception("Invalid input value");
        }
        return;
    }
    
    /**
     * To validate price of a car
     * @param price of type int
     * @return void
     */
    public void validatePrice(int price) throws Exception
    {
        if (price <= 0)
        {
            throw new Exception("price cannot be NEGETIVE or ZERO");
        }
        return;
    }
    
    /**
     * To validate model chocie input
     * @param str of type String
     * @return void
     */
    public void validateModelInput(String str) throws Exception
    {
        if (str == "ANY")
        {
            return;
        }
        throw new Exception("Invalid Input");
    }
    
    /**
     * To validate car maker choice 
     * @param size of type int , i of type int 
     * @return void
     */
    public void validateCMInput(int size, int i) throws Exception
    {
        if (i > 0 && i < size)
        {
            return;
        }
        throw new Exception("Invalid input");
    }
    
    /**
     * To validate colours 
     * @param colors of type string
     * @return void
     */
    public void validateColors(String colors) throws Exception
    {
        if (isColorProperFormat(colors))
        {
            return;
        }
        throw new Exception("Invalid input");
    }
    
    /**
     * To validate number of years
     * @param num of type int
     * @return boolean
     */
    public boolean validateNoOfYears(int num)
    {
        if (num >= 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * To validate colours format
     * @param colors of type string
     * @return boolean
     */
    public boolean isColorProperFormat(String colors)
    {
        int noOfPlus = 0;
        for (int i = 0; i < colors.length(); i++)
        {
            if (colors.charAt(i) == '+')
            {
                noOfPlus++;
            }
        }
        if (noOfPlus == 2)
        {
            return true;
        }
        return false;
    }
    
    /**
     * To check if a string is alphanumeric
     * @param str of type string
     * @return boolean
     */
    public boolean isAlphaNumeric(String str)
    {
        boolean flag = false;
        char[] Char = str.toCharArray();
        for (int i = 0; i < Char.length; i++)
        {
            if (!Character.isDigit(Char[i]) && !Character.isLetter(Char[i]))
            {
                flag = false;
            }
            else
            {
            flag = true;
            }
        }
        return flag;
    }
    
    /**
     * To check if a string is numeric
     * @param str of type string
     * @return boolean
     */
    public boolean isNumeric(String str)
    {
        boolean flag = false;
        char[] Char = str.toCharArray();
        for (int i = 0; i < Char.length; i++)
        {
            if (!Character.isDigit(Char[i]))
            {
                flag = false;
            }
            else
            {
                flag = true;
            }
        }
        return flag;
    }
}
