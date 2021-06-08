import java.io.*;
import java.util.Scanner;
/**
 * class for reading and writing from external files
 *
 * @author Dhruv Mathur
 * @version 25-05-2021
 */
public class FileIO
{
    
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
        
    }
            
    /**
     * To read from a comma seprated file
     * @param fileName of type String
     * @return void
     */
    public String readFile(String fileName)
    {
        String content = "";
        try
        {
            FileReader fileRd = new FileReader(fileName);
            Scanner parser = new Scanner(fileRd);
            while(parser.hasNext())
            {
                content += parser.nextLine();
                content += "\n";
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found at the given filename" + e);
        }
        catch(IOException e)
        {
            System.out.println("input parsing interrupted" + e);
        }
        return content;
    }
    
    /**
     * To write to a file in a comma seperated format
     * @param fileName of type String, content of type Stirng
     * @return void
     */
    public void writeFile(String content, String fileName)
    {
        try
        {
            PrintWriter output = new PrintWriter(fileName);
            output.print(content);
            output.close();
        }
        catch(IOException e)
        {
            System.out.println("IO exception handled" + e);
        } 
    }
}
