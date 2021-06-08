import java.util.Scanner;
/**
 * Input class used for taking all the different kind of inputs
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Input
{
    // instance variables - replace the example below with your own
    private Validator validator;
    private Scanner in;
    /**
     * Constructor for objects of class Input
     */
    public Input()
    {
        // initialise instance variables
        validator = new Validator();
        in = new Scanner(System.in);
    }
    
    /**
     * To get input for main menu option
     * @param 
     * @return int 
     */
    public int getMainMenuInput()
    {
        int choice = 0;
        System.out.println("choose one option:");
        while(true)
        {
            try
            {
                 choice = Integer.valueOf(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter integer values only: ");
                continue;
            }
           
            try
            {
                 validator.validateMainMenuInput(choice);
            }
            catch(Exception e)
            {
                System.out.println("Invalid choice Enter again:");
                continue;
            }
            break;
        }
        return choice; 
    }
    
    /**
     * To get input for saerch menu option
     * @param 
     * @return int 
     */
    public int getSearchMenuInput()
    {
        int option = 0;
        System.out.println("choose one option:");
        while(true)
        {
            try
            {
                option = Integer.valueOf(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter integer values only: ");
                continue;
            }
            try
            {
                 validator.validateSearchMenuInput(option);
            }
            catch(Exception e)
            {
                System.out.println("Invalid choice Enter again:");
                continue;
            }
            break;
        }
        return option;
    }
    
    /**
     * To get input for registration number
     * @param 
     * @return String
     */
    public String getRegNumberInput()
    {
        String regNo = "";
        System.out.println("Enter Registration number:");
        while(true)
        {
            regNo = in.nextLine();
            try
            {
                 validator.validateRegNo(regNo);
            }
            catch(Exception e)
            {
                System.out.println("Enter Registration number again:");
                continue;
            }
            break;
        }
        return regNo;
    }
    
    /**
     * To get input for car model
     * @param int size
     * @return String
     */
    public String getIntModelInput(int size)
    {
        String choice = "";
        while(true)
        {
            choice = in.nextLine();
            if ( validator.isNumeric(choice))
            {
                int c = Integer.valueOf(choice);    
                try
                {
                     validator.validateCMInput(size+1, c);
                }
                catch(Exception e)
                {
                    System.out.println("Enter choice again from the above values:");
                    continue;
                }
                return choice;
            }
            else 
            {
                if (choice.equals("ANY"))
                {
                    return choice;
                }
                else
                {
                    System.out.println("only numeric values from above list and 'ANY' is valid");
                    continue;
                }
                
            }
        }
    }
    
    /**
     * To get input for car maker index
     * @param 
     * @return int
     */
    public int getIntCMInput(int size)
    {
        int choice = 0;
        while(true)
        {
            try
            {
                choice = Integer.parseInt(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter numeric values from the above available values:");
                continue;
            }
            try
            {
                 validator.validateCMInput(size+1, choice);
            }
            catch(Exception e)
            {
                System.out.println("Enter choice again:");
                continue;
            }
            break;
        }
        return choice;
    }
    /**
     * To get input for price range
     * @param 
     * @return int[]
     */
    public int[] getPriceRangeInput()
    {
        int[] range = new int[2];
        System.out.println("Enter Minimum Price:");
        while(true)
        {
            range[0] = Integer.parseInt(in.nextLine());
            try
            {
                 validator.validatePrice(range[0]);
            }
            catch(Exception e)
            {
                System.out.println("Enter Price again:");
                continue;
            }
            break;
        }
        System.out.println("Enter Maximum Price:");
        while(true)
        {
            range[1] = Integer.parseInt(in.nextLine());
            try
            {
                 validator.validatePrice(range[1]);
            }
            catch(Exception e)
            {
                System.out.println("Enter Price again:");
                continue;
            }
            break;
        }
        return range;
    }
    
    /**
     * To get input for year made
     * @param 
     * @return int
     */
    public int getYearInput()
    {
        System.out.println("Enter the number of years");
        int num = 0;
        while (true)
        {
            try
            {
                num = Integer.parseInt(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter numeric values only:");
                continue;
            }
            try
            {
                validator.validateNoOfYears(num);
            }
            catch(Exception e)
            {
                System.out.println("Enter valid value for year that is not negetive:");
                continue;
            }
            break;
        }
        return num;
    }
    
    /**
     * To get input for price of a car
     * @param 
     * @return int
     */
    public int getPriceInput()
    {
        System.out.println("enter price for the car");
        int price = 0;
        while (true)
        {
            try
            {
                price = Integer.parseInt(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Enter numeric values only");
                continue;
            }
            
            try
            {
                 validator.validatePrice(price);
            }
            catch(Exception e)
            {
                System.out.println("Enter Price again:");
                continue;
            }
            break;
        }
        return price;
    }
    
    /**
     * To get input for colours of a car
     * @param 
     * @return String
     */
    public String getColourInput()
    {
        System.out.println("Enter colour scheme like 'colour1 + colour2 + colour3'");
        String color = "";
        while(true)
        {
            color = in.nextLine();
            try
            {
                 validator.validateColors(color);
            }
            catch(Exception e)
            {
                System.out.println("Enter colors according to the format : color1+color2+color3");
                continue;
            }
            break;
        }
        return color;
    }
}
