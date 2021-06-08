import java.util.*;
/**
 * CarMaker class contains information about a particular car maker
 *
 * @author Dhruv Mathur
 * @version 25-05-2021
 */
public class CarMaker
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<String> models;
    /**
     * Constructor for objects of class CarMaker
     */
    public CarMaker()
    {
        // initialise instance variables
        name = "None";
        models = new ArrayList<>();
    }
    
    /**
     * Parameterised Constructor for objects of class CarMaker
     */
    public CarMaker(String name, ArrayList<String> models)
    {
        this.name = name;
        this.models = models;
    }
    
    /**
     * mutator method for name
     * @param name of type string
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * add a new model from this particular car maker
     * @param String model
     * @return void
     */
    public void addModel(String model)
    {
        this.models.add(model);
    }
    
    /**
     * remove a model from this particular car maker
     * @param String model
     * @return void
     */
    public void removeModel(String model)
    {
        this.models.remove(model);
    }
    
    /**
     * acressor method for name of the car maker
     * @param 
     * @return String
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * accessor for a list of all the model
     * @param 
     * @return ArrayList<String>
     */
    public ArrayList<String> getModels()
    {
         return models;   
    }
    
    /**
     * To display all models
     * @param 
     * @return void
     */
    public void displayModels()
    {
        System.out.println("Available models are: ");
        for (int i = 0; i < models.size(); i++)
        {
            int temp = i+1;
            System.out.println("(" + temp + ")" + models.get(i));
        }
    }
    
    /**
     * To get a particular model by index
     * @param i of type int
     * @return String
     */
    public String getModelByIndex(int i)
    {
        return models.get(i - 1);
    }
    
    /**
     * display method for car maker
     * @param 
     * @return String
     */
    public void display()
    {
        System.out.println("The car manufacturer name is: " + name);
        displayModels();
    }
    
    /**
     * To get the total number of models
     * @param 
     * @return int
     */
    public int getNumberOfModels()
    {
        return models.size();
    }
}
