import java.util.*;
/**
 * CarWarehouse class contains all the main functionality and working
 *
 * @author Dhruv Mathur
 * @version 5
 */
public class CarWareHouse
{
    // instance variables 
    private CarDatabase carDB;
    private CarMakerDatabase carMakerDB;
    private boolean leave;
    /**
     * Constructor for objects of class CarWareHouse
     */
    public CarWareHouse()
    {
        // initialise instance variables
        carDB = new CarDatabase();
        carMakerDB = new CarMakerDatabase();
        leave = false;
    }
    
    /**
     * Parameterized constructor of class CarWareHouse
     * @param CarDB of type CarDatabase, carMakerDB of type CarMakerDatabase
     */
    public CarWareHouse(CarDatabase carDB, CarMakerDatabase carMakerDB)
    {
        this.carDB = carDB;
        this.carMakerDB = carMakerDB;
    }
    
    /**
     * mutator method for carDB
     * @param CarDB of type CarDatabase
     * @return void
     */
    public void setCarDB(CarDatabase carDB)
    {
        this.carDB = carDB;
    }
    
    /**
     * accessor method for carDB
     * @param 
     * @return CarDatabase
     */
    public CarDatabase getCarDB()
    {
        return this.carDB;
    }
    
    /**
     * mutator method for carMakerDB
     * @param CarMakerDB of type CarMakerDatabase
     * @return void
     */
    public void setCarMakerDB(CarMakerDatabase carMakerDB)
    {
        this.carMakerDB = carMakerDB;
    }
    
    /**
     * accessor method for carMakerDB
     * @param 
     * @return CarMakerDatabase
     */
    public CarMakerDatabase getCarMakerDB()
    {
        return this.carMakerDB;
    }
    
    /**
     * To start the program and handle the flow
     * @param no parameters
     * @return void.
     */
    public void startProgram()
    {
        carMakerDB.loadCarMakers();
        carDB.loadCars();
        leave = false;
        while(!leave)
        {
            Input input = new Input();
            displayMenu();
            int choice = input.getMainMenuInput();
            initializeChoice(choice);
        }
    }
    
    /**
     * To initialize main menu and the respective choices.
     * @param choice of the type int.
     * @return void.
     */
    private void initializeChoice(int choice)
    {
        switch(choice)
        {
            case 1:
                search();
                break;
            case 2:
                addCar();
                break;
            case 3:
                deleteCar();
                break;
            case 4:
                editCar();
                break;
            case 5:
                System.out.println("Thanks for doing business with us");
                leave = true;
                carDB.writeCars();
                carDB.clearDatabase();
                carMakerDB.clearDatabase();
                break;
            default:
                System.out.println("invalid input");
                break;
        }
    }
    
    /**
     * To initialize search menu 
     * @param no parameters.
     * @return void
     */
    private void search()
    {
        displaySearchChoices();
        Input input = new Input();
        int option = input.getSearchMenuInput();
        if (option == 5)
        {
            startProgram();
        }
        else
        {
            initializeSearchChoice(option, carDB, carMakerDB);
        }
    }
    
    /**
     * To initialize the search choices
     * @param option of the type int, carDB of the type CarDatabase, carMakerDB of the type CarMakerDatabase
     * @return void
     */
    private void initializeSearchChoice(int option, CarDatabase carDB, CarMakerDatabase carMakerDB)
    {
        switch(option)
        {
            case 1:
                searchCarsByRegNo(carDB);
                break;
            case 2:
                searchByMakeandModel(carDB, carMakerDB);
                break;
            case 3:
                searchByAge(carDB);
                break;
            case 4:
                searchByPrice(carDB);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    
    /**
     * To search car by age
     * @param  carDB of type CarDatabase.
     * @return void
     */
    private void searchByAge(CarDatabase carDB)
    {
        Input input = new Input();
        int age = input.getYearInput();
        carDB.searchCarByAgeDisplay(age);
    }
    
    /**
     * To search car by Maker and the Model
     * @param  carDB fo the type CarDatabase, carMakerDB fo the type CarMakerDatabase
     * @return void.
     */
    private void searchByMakeandModel(CarDatabase carDB, CarMakerDatabase carMakerDB)
    {
        Validator v = new Validator();
        Input input = new Input();
        displayCarMakersNames();
        int carMakerChoice = input.getIntCMInput(carMakerDB.getTotalCarMakers());
        String maker = getCarMakerName(carMakerChoice);
        displayModels(carMakerChoice);
        String modelChoice = input.getIntModelInput((carMakerDB.getNumberOfModels(carMakerChoice)));
        System.out.println("got model input");
        if (v.isNumeric(modelChoice))
        {
            int c = Integer.valueOf(modelChoice);
            String model = getParticularModel(carMakerChoice, c);
            carDB.searchCarByMakeAndModelDisplay(maker, model);
        }
        else
        {
             carDB.searchCarsByMakeAndDisplay(maker);   
        }
    }
    
    /**
     * To search car by registration number
     * @param  carDB fo the type CarDatabase
     * @return void.
     */
    private void searchCarsByRegNo(CarDatabase carDB)
    {
        Input input = new Input();
        String regNo = input.getRegNumberInput();
        carDB.searchAndDisplayByRegNo(regNo);
    }
    
    /**
     * To search car by Price range
     * @param  carDB fo the type CarDatabase
     * @return void.
     */
    private void searchByPrice(CarDatabase carDB)
    {
         Input input = new Input();
         int[] priceRange = input.getPriceRangeInput();
         carDB.searchCarByPriceDisplay(priceRange[1], priceRange[0]);
    }
    
    /**
     * To delete car by registration number
     * @param  no parameters
     * @return void.
     */   
    private void deleteCar()
    {
        Input input = new Input();
        String regNo = input.getRegNumberInput();
        carDB.deleteCar(regNo);
    }
    
    /**
     * To edit car by registration number
     * @param  no parameters
     * @return void.
     */  
    private void editCar()
    {
        Input input = new Input();
        String regNo = input.getRegNumberInput();
        int price = input.getPriceInput();
        String colours = input.getColourInput();
        carDB.editCar(regNo, colours, price);
    }
    
    /**
     * To add a new car 
     * @param  no parameters
     * @return void.
     */  
    private void addCar()
    {
        Input input = new Input();
        displayCarMakersNames();
        int carMakerChoice = input.getIntCMInput(carMakerDB.getTotalCarMakers());
        String maker = getCarMakerName(carMakerChoice);
        displayModels(carMakerChoice);
        int modelChoice = input.getIntCMInput((carMakerDB.getNumberOfModels(carMakerChoice)));
        String model = getParticularModel(carMakerChoice, modelChoice);
        String regNo = input.getRegNumberInput();
        int price = input.getPriceInput();
        int yearMade = input.getYearInput();
        String color = input.getColourInput();
        carDB.addCar(regNo, yearMade, color, maker, model, price);
        System.out.println("car added succesfully");
    }
    
    /**
     * To get a particular model of a specific car maker
     * @param  carMakerChoice of type int, modelChoice of type int
     * @return String.
     */  
    private String getParticularModel(int carMakerChoice, int modelChoice)
    {
        return carMakerDB.getParticularModel(carMakerChoice, modelChoice);
    }
    
    /**
     * To get a specific car maker
     * @param  carMakerChoice of type int
     * @return String.
     */  
    private String getCarMakerName(int carMakerChoice)
    {
        return carMakerDB.getMakerName(carMakerChoice);
    }
    
    /**
     * To display all the models of a particular car maker
     * @param  carMakerChoice of type int
     * @return void.
     */  
    private void displayModels(int carMakerChoice)
    {
        System.out.println("Choose car model from the following:");
        carMakerDB.displayModels(carMakerChoice);
    }
    
    /**
     * To display all the available car makers
     * @param  
     * @return void.
     */  
    private void displayCarMakersNames()
    {
        System.out.println("Choose car Maker from the following:");
        carMakerDB.displayCarMakersName();
    }
    
    /**
     * To display the main menu
     * @param  
     * @return void.
     */ 
    private void displayMenu()
    {
        System.out.println("Welcome to USEDCARS please select and option");
        System.out.println("(1) Search Cars" + "\n" +
                            "(2) Add Car" + "\n" +
                            "(3) Delete Car" + "\n" +
                            "(4) Edit Car" + "\n" +
                            "(5) Exit");
    }
    
    /**
     * To display the search menu
     * @param  
     * @return void.
     */ 
    private void displaySearchChoices()
    {
        System.out.println("Choose form these search options");
        System.out.println("(1) By Registration Number" + "\n" +
                            "(2) By Car Make and Car Model" + "\n" +
                            "(3) By Car Age" + "\n" +
                            "(4) By Price (range)" + "\n"
                            + "(5) Back to main menu");
    }
    
    /**
     * To display all available cars
     * @param  
     * @return void.
     */ 
    private void displayAvailableCars()
    {
        carDB.displayAvalableCars();
    }
    
    /**
     * To display all the car makers
     * @param  
     * @return void.
     */ 
    private void displayCarMakers()
    {
        carMakerDB.displayCarMakers();
    }
}
