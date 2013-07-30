import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;


public class LogEngine {

	private static ArrayList<String> errors;
	
	private String fileName = "log.txt";
	
	public void loadErrors() throws IOException{
		
		FileInputStream fstream = new FileInputStream(this.fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(fstream)));
		
		String strLine = br.readLine();
		
		while (strLine != null)   {
			errors.add(strLine);
		}
		
		br.close();
		fstream.close();
		
	}
	
	public void addError(String error){
		errors.add(error);
	}
	
	public String getError(int index){
		return errors.get(index);
	}
	
	public void saveErrors() throws IOException{
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		
		for (int i = 0; i < errors.size(); i++){
			out.write(errors.get(i) + "\n");
		}
		
		out.close();
		
	}
	
}
