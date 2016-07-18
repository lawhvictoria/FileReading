import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Victoria
 */
public class HW6 {

    public static void main(String[] args) {
        try
        {
            FileReader fr = new FileReader("hotel.txt");//takes in a file to read.
            BufferedReader br = new BufferedReader(fr); //buffer reader reads each line of text and ends at \n of each line.

            String str;
            
            while((str = br.readLine()) != null)
            {
                String [] ar = str.split(";"); // splits the line by ; and puts it into the arguments of the array created. 

                if(!isDouble(ar[0]) && !isDouble(ar[1]) && isDouble(ar[2])) //checks if it's in the correct format.
                {
                
                try
                {
                    FileWriter fw = new FileWriter(ar[1]+ ".txt", true); //opens a file and checks if it's pre-existing.
                    PrintWriter pw = new PrintWriter(fw); //writes to the file.

                    pw.println(str + "\n");

                    pw.close();
                }

                catch (IOException e)
                {
                    System.out.println("ERROR!");
                }
		}
		else
		{
			System.out.println("Wrong Format!");
		}
                
            } 

            br.close();
        }
        
        catch (IOException e)
        {
            System.out.println("File not found!");
        }
    }
    
    public static boolean isDouble(String s)
    {
        try
        {
            double i = Double.parseDouble(s); 
            return true;
        }

        catch(NumberFormatException er)
        {
            return false;
        }
    }
}
