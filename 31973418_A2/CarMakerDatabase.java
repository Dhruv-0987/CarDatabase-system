import java.util.*;
/**
 * CarMakerDatabase contains all the information about car makers 
 *
 * @author Dhruv Mathur
 * @version 25-05-2021
 */
public class CarMakerDatabase
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, CarMaker> carMakerDB;
    private int index;
    private FileIO fileIO;
    /**
     * Constructor for objects of class CarMakerDatabase
     */
    public CarMakerDatabase()
    {
        // initialise instance variables
        carMakerDB = new HashMap<>();
        index = 1;
        fileIO = new FileIO();
    }
    
    /**
     * Parameterized Constructor for objects of class CarMakerDatabase
     * @param 
     * @return void
     */
    public CarMakerDatabase(HashMap<Integer, CarMaker> carMakerDB)
    {
        this.carMakerDB = carMakerDB;
    }
    
    /**
     * mutator method for CarMakerDB
     * @param 
     * @return HashMap<Integer, CarMaker> 
     */
    public void setCarMakerDB(HashMap<Integer, CarMaker> carMakerDB)
    {
        this.carMakerDB = carMakerDB;
    }
    
    /**
     * accessor methos for CarMakerDB
     * @param 
     * @return HashMap<Integer, CarMaker> 
     */
    public HashMap<Integer, CarMaker> getCarMakerDB()
    {
        return carMakerDB;     
    }
    
    /**
     * To add a new car maker to the database
     * @param name of type string, models of type ArrayList<String>, index of type int
     * @return void
     */
    public void addCarMaker(String name, ArrayList<String> models, int index)
    {
       CarMaker carM = new CarMaker(name, models);
       carMakerDB.put(index, carM);
    }
    
    /**
     * To load cars makers from the database 
     * @param 
     * @return void
     */
    public void loadCarMakers()
    {
        String fileName = "carmakers.txt";
        String content = fileIO.readFile(fileName);
        String[] carMakers = content.split("[\n]");
        for (int i = 0; i < carMakers.length; i++)
        {
            String[] values = carMakers[i].split("[,]");
            String name = values[0];
            ArrayList<String> models = new ArrayList<>();
            for(int j = 1; j < values.length; j++)
            {
                models.add(values[j]);
            }
            addCarMaker(name, models, i+1);
        }
    }
    
    /**
     * To display car makers names only
     * @param 
     * @return void
     */
    public void displayCarMakersName()
    {
        for(int i = 1; i < carMakerDB.size(); i++)
        {
            CarMaker carM = carMakerDB.get(i);
            System.out.println("(" + i + ")" + carM.getName());
        }
    }
    
    /**
     * To display car makes name
     * @param 
     * @return void
     */
    public void displayCarMakers()
    {
        for (int i : carMakerDB.keySet())
        {
            CarMaker carM = carMakerDB.get(i);
            System.out.println(carM.getName());
        }
    }
    
    /**
     * To get a specific car makers name
     * @param i of type int
     * @return String
     */
    public String getMakerName(int carMakerIndex)
    {
        return carMakerDB.get(carMakerIndex).getName();
    }
    
    /**
     * To display car makers all models
     * @param int of type int
     * @return void
     */
    public void displayModels(int carMakerIndex)
    {
        carMakerDB.get(carMakerIndex).displayModels();
    }
    
    /**
     * To get all available models of a car maker    
     * @param int makerIndex of type int
     * @return ArrayList<String>
     */
    public ArrayList<String> getAllModelsifAny(int makerIndex)
    {
        return carMakerDB.get(makerIndex).getModels();
    }
    
    /**
     * To get a specific model from a particular car maker
     * @param makerIndex of parameter int, modelIndex of type int
     * @return String
     */
    public String getParticularModel(int makerIndex, int modelIndex)
    {
        return carMakerDB.get(makerIndex).getModelByIndex(modelIndex);
    }
    
    /**
     * To get total number of car makers
     * @param 
     * @return int
     */
    public int getTotalCarMakers()
    {
        return carMakerDB.size();
    }
    
    /**
     * To get total number of models of a particular car maker
     * @param carMakerIndex of type int
     * @return int
     */
    public int getNumberOfModels(int carMakerIndex)
    {
        return carMakerDB.get(carMakerIndex).getNumberOfModels();
    }
    
    /**
     * To clear the database
     * @param 
     * @return void
     */
    public void clearDatabase()
    {
        carMakerDB.clear();
    }
}
