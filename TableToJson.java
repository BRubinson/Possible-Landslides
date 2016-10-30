import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TableToJson {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("convert"));
		
	//ArrayList<String> locations = new ArrayList<String>();
		String Json = "[";
		//for(int x = 0;x<10;x++)
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			line=line.replaceAll("  ", " ");
			line=line.replaceAll("  ", " ");
			line=line.replaceAll("  ", " ");
			String[] temp = line.split("LIKELY at ")[1].split(" ");
			String dist = temp[3].substring(0, temp[3].length()-2);
			Json = Json+ temp[0] +"," + temp[1] + "," +( (Double.parseDouble(dist)/200));
			if(scan.hasNextLine())
				Json = Json+",";
		//	System.out.println(Json);
			
			
		}
		Json+="]";
		try{
		    PrintWriter writer = new PrintWriter("PossibleLandslides.json", "UTF-8");
		    writer.println(Json);
		    writer.close();
		} catch (Exception e) {
		   // do something
		}

	}

}
