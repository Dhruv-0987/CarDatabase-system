import java.util.*;
/**
 * CarDatabase stores all the cars and has all the related methods of CRUD
 *
 * @author Dhruv Mathur
 * @version 24/05/2021
 */
public class CarDatabase
{
    // instance variables 
    private ArrayList<Car> carDatabase;
    /**
     * Constructor for objects of class CarDatabase
     */
    public CarDatabase()
    {
        // initialise instance variables
        carDatabase = new ArrayList<>();
    }
    
    /**
     * Parameterized Constructor for objects of class CarDatabase
     * @param newList of type ArrayList<Car>
     */
    public CarDatabase(ArrayList<Car> newList)
    {
        this.carDatabase = newList;
    }
    
    /**
     * acessor method for carDatabase
     * @param 
     * @return ArrayList<Car>
     */
    public ArrayList<Car> getCarDatabase()
    {
        return this.carDatabase;
    }
    
    /**
     * mutator method for carDatabase
     * @param carDB of type ArrayList<Car>
     * @return void
     */
    public void setCarDatabase(ArrayList<Car> carDB)
    {
        this.carDatabase = carDB;
    }
    
    /**
     * To check if the database contains a certain car
     * @param String regNumber, int yearMade, String colours, String carMake, String carModel, int price.
     * @return boolean.
     */
    public boolean isContainsCar(String regNumber, int yearMade, String colours, String carMake, String carModel, int price)
    {
        Car car = new Car(regNumber, yearMade, colours, carMake, carModel, price);
        if (carDatabase.contains(car))
        {
            return true;
        }
        return false;
    }
    
    /**
     * To add a new car to the database
     * @param String regNumber, int yearMade, String colours, String carMake, String carModel, int price
     * @return void.
     */
    public void addCar(String regNumber, int yearMade, String colours, String carMake, String carModel, int price)
    {
        Car car = new Car(regNumber, yearMade, colours, carMake, carModel, price);
        if(!carDatabase.contains(car))
        {
            carDatabase.add(car);
        }
        else
        {
            System.out.println("duplicate cars not allowed");
        }
    }
    
    /**
     * To add a new car to the database
     * @param String regNumber, int yearMade, String colours, String carMake, String carModel, int price
     * @return void.
     */ 
    public void loadCars()
    {
        FileIO fileIO = new FileIO();
        String fileName = "usedcars.txt";
        String content = fileIO.readFile(fileName);
        String[] cars = content.split("[\n]");
        for (String car : cars)
        {
            String[] values = car.split("[,]");
            String colors = values[2];
            for (int i = 3; i < 5; i++)
            {
                if (values[i].length() != 0)
                {
                    colors += "+";
                    colors += values[i];
                }
            }
            addCar(values[0], Integer.parseInt(values[1]), colors, values[5], values[6], Integer.parseInt(values[7]));
        }
    }
    
    /**
     * To write the cars back to he file from the database
     * @param 
     * @return void.
     */ 
    public void writeCars()
    {
        FileIO fileIO = new FileIO();
        String fileName = "usedcars.txt";
        String content = "";
        content = getOutputFile();
        fileIO.writeFile(content, fileName);
    }
    
    /**
     * To delete a car from the database
     * @param regNo of type string
     * @return void.
     */ 
    public void deleteCar(String regNo)
    {
        Car car = searchByRegNumber(regNo);
        if(carDatabase.contains(car))
        {
            carDatabase.remove(searchByRegNumber(regNo));
            System.out.println("car deleted succesfully");
        }
        else
        {
            System.out.println("this car does not exist");
        }
    }
    
    /**
     * To edit a car in the database
     * @param regNo of type string, colours type of string, price type of int
     * @return void.
     */ 
    public void editCar(String regNo, String colours, int price)
    {
        Car car = searchByRegNumber(regNo);
        car.setPrice(price);
        car.setColours(colours);
    }
    
    /**
     * To search a car by the registration number
     * @param regNo of type string
     * @return Car.
     */ 
    public Car searchByRegNumber(String regNo)
    {
        for (Car car : carDatabase)
        {
            if (regNo.equals(car.getRegNumber()))
            {
                return car;
            }
        }
        System.out.print("No such car with " + regNo + " Exist ");
        return null;
    }
    
    /**
     * To search a car by the registration number and then display it
     * @param regNo of type string
     * @return void.
     */ 
    public void searchAndDisplayByRegNo(String regNo)
    {
        Car car = searchByRegNumber(regNo);
        if (car != null)
        {
            car.display();
        }
    }
    
    /**
     * To search a car by the car maker and the model
     * @param maker type of string, model type of string
     * @return ArrayList<Car>.
     */ 
    public ArrayList<Car> searchCarByMakeAndModel(String maker, String model)
    {
        ArrayList<Car> cars = new ArrayList<>();
        for (Car car : carDatabase)
        {
            if (maker.equals(car.getCarMake()) && model.equals(car.getCarModel()))
            {
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * To search a car by the car maker and display all its cars
     * @param maker type of string, model type of string
     * @return void.
     */ 
    public void searchCarsByMakeAndDisplay(String make)
    {
        ArrayList<Car> cars = new ArrayList<>();
        for (Car car : carDatabase)
        {
            if (make.equals(car.getCarMake()))
            {
                cars.add(car);
            }
        }        
        if (cars.size() == 0)
        {
            System.out.println("No cars with this make exist");
        }
        else
        {
            for (Car car : cars)
            {
                car.display();
            }
        }
    }
    
    /**
     * To search a car by the car maker and the model and display
     * @param maker type of string, model type of string
     * @return void.
     */ 
    public void searchCarByMakeAndModelDisplay(String maker, String model)
    {
        ArrayList<Car> cars = searchCarByMakeAndModel(maker, model);
        if (cars.size() == 0)
        {
            System.out.println("No cars with this make and model exist");
        }
        else
        {
            for (Car car : cars)
            {
                car.display();
            }
        }
    }
    
    /**
     * To search a car by the year or age
     * @param age type of int
     * @return ArrayList<Car>.
     */ 
    public ArrayList<Car> searchCarByAge(int age)
    {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Integer> years = new ArrayList<>();
        if (age == 0)
            years.add(2021);
        else
        {
            years.add(2021);
            for (int i = 1; i <= age; i++)
            {
                years.add(2021 - i);
            }
        }
        for (Car car : carDatabase)
        {
            if (years.contains(car.getYearMade()))
            {
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * To search a car by the year or age and display
     * @param age type of int
     * @return void.
     */ 
    public void searchCarByAgeDisplay(int age)
    {
        ArrayList<Car> cars = searchCarByAge(age);
        if (cars.size() == 0)
        {
            System.out.println("No cars in this year range exist");
        }
        else
        {
            for (Car car : cars)
            {
                car.display();
            }
        }
    }
    
    /**
     * To search a car by the price range
     * @param maxPrice type of int, minPrice type of int
     * @return ArrayList<Car>.
     */ 
    public ArrayList<Car> searchByPrice(int maxPrice, int minPrice)
    {
        ArrayList<Car> cars = new ArrayList<>();
        for (Car car : carDatabase)
        {
            if (car.getPrice() <= maxPrice && car.getPrice() >= minPrice)
            {
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * To search a car by the price range and display
     * @param maxPrice type of int, minPrice type of int
     * @return void.
     */ 
    public void searchCarByPriceDisplay(int maxPrice, int minPrice)
    {
        ArrayList<Car> cars = searchByPrice(maxPrice, minPrice);
        for (Car car : cars)
        {
            car.display();
        }
    }
    
    /**
     * To generate the output file for writing back
     * @param 
     * @return void
     */ 
    public String getOutputFile()
    {
        String content = "";
        for (Car car : carDatabase)
        {
            content += car.toString();
            content += "\n";
        }
        return content;
    }
    
    /**
     * To display the available cars
     * @param 
     * @return void
     */
    public void displayAvalableCars()
    {
        for (Car car : carDatabase)
        {
            car.display();
        }
    }
    
    /**
     * To clear the database
     * @param 
     * @return void
     */
    public void clearDatabase()
    {
        carDatabase.clear();
    }
}
