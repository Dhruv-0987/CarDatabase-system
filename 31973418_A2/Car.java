 
/**
 * Car class contains all the properties of a car
 *
 * @author Dhruv Mathur
 * @version 25-05-2021
 */
public class Car
{
    // instance variables 
    private String regNumber;
    private int yearMade;
    private String colours;
    private String carMake;
    private String carModel;
    private int price;
    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        regNumber = "XXXXXX";
        yearMade = 0;
        colours = "color1 + color2 + color3";
        carMake = "unknown";
        carModel = "unknown";
        price = 0;
    }
    
    /**
     * Parameterized Constructor for objects of class Car
     */
    public Car(String regNumber, int yearMade, String colours, String carMake, String carModel, int price)
    {
        if (!regNumber.isEmpty() && regNumber.length() == 6)
            this.regNumber = regNumber;            
        else
            this.regNumber = "XXXXXX";
        if (yearMade != 0 && yearMade <= 2021)
            this.yearMade = yearMade;
        else
            this.yearMade = 0;
        if (!colours.isEmpty())
            this.colours = colours;
        else
             this.colours = "colour1+colour2+colour3";   
        if (!carMake.isEmpty())
            this.carMake = carMake;
        else
            this.carMake = "unknown";   
        if (!carModel.isEmpty())
            this.carModel = carModel;
        else
            this.carModel = "unknown";
        if (price != 0 && price > 0)
            this.price = price;
        else
            this.price = 0;
    }
    
    /**
     * acessor method for registration number
     * @param 
     * @return String
     */
    public String getRegNumber()
    {
        return this.regNumber;
    }
    
    /**
     * mutator method for registration number
     * @param String regNo
     * @return void
     */
    public void setRegNumber(String regNo)
    {
        if (!regNumber.isEmpty() && regNumber.length() == 6)
            this.regNumber = regNo;            
        else
            this.regNumber = "XXXXXX";
    }
    
    /**
     * acessor method for yearMade
     * @param 
     * @return int
     */
    public int getYearMade()
    {
        return yearMade;
    }
    
    /**
     * mutator method for yearMade
     * @param year of type int
     * @return void
     */
    public void setYearMade(int year)
    {
        if (yearMade != 0 && yearMade <= 2021)
            this.yearMade = yearMade;
        else
            this.yearMade = 0;
    }
    
    /**
     * acessor method for colours 
     * @param 
     * @return String
     */
    public String getColours()
    {
        return colours;
    }
    
    /**
     * mutator method for colours 
     * @param String colours
     * @return void
     */
    public void setColours(String colours)
    {
        if (!colours.isEmpty())
            this.colours = colours;
        else
            this.colours = "colour1+colour2+colour3";
    }
    
    /**
     * acessor method for car maker
     * @param 
     * @return String
     */
    public String getCarMake()
    {
        return this.carMake;
    }
    
    /**
     * mutator method for car maker
     * @param String carMake
     * @return void
     */
    public void setCarMake(String carMake)
    {
        if (!carMake.isEmpty())
            this.carMake = carMake;
        else
            this.carMake = "unknown";    
    }
    
    /**
     * acessor method for car model
     * @param 
     * @return String
     */
    public String getCarModel()
    {
        return carModel;
    }
    
    /**
     * mutator method for car model
     * @param String model
     * @return void
     */
    public void setCarModel(String model)
    {
        if (!carModel.isEmpty())
            this.carModel = carModel;
        else
            this.carModel = "unknown";
    }
    
    /**
     * acessor method for price
     * @param 
     * @return int
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * mutator method for price
     * @param int price
     * @return void
     */
    public void setPrice(int price)
    {
        if (price != 0 && price > 0)
            this.price = price;
        else
            this.price = 0;
    }
    
    /**
     * To display colour scheme
     * @param 
     * @return void
     */
    public void displayColours()
    {
        if (!colours.isEmpty())
            System.out.println("the colour scheme is " + colours);
    }
    
    /**
     * To display a car object
     * @param 
     * @return void
     */
    public void display()
    {
        System.out.println("The registration number is: " + regNumber + "\n" +
                            "The year of manufacturing is: " + yearMade + "\n" +
                            "The car Maker Name is : " + carMake + "\n" +
                            "The car model is: " + carModel + "\n" +
                            "The car price is: " + price);
        displayColours();
    }
    
    /**
     * toString method for the class
     * @param 
     * @return String
     */
    public String toString()
    {
        String[] colors = colours.split("[+]");
        String color = "";
        if (colors.length == 1)
        {
            color += colors[0] + "," + "," + ",";
        }
        else if (colors.length == 2)
        {
            if (colors[1] !=  "")
            {
                color += colors[0] + ",";
                color += colors[1] + "," + ",";
            }
            else
            {
                color += colors[0] + ",";
                color += "," + ",";
            }
        }
        else if (colors.length == 3)
        {
            color += colors[0] + "," + colors[1] + "," + colors[2] + ",";
        }
        return regNumber + "," + yearMade + "," + color + carMake + "," + carModel + "," + price;
    }
    
}
