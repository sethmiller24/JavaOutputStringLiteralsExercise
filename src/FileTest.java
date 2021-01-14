import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String curDir = System.getProperty("user.dir");
		File cd = new File(curDir);
		File [] files = cd.listFiles();
		
		for (File f: files) {
			 if (f.getName().endsWith(".java")) {
				 try(FileInputStream is = new FileInputStream(f)){
					 InputStreamReader ir = new InputStreamReader(is);
					 BufferedReader rdr = new BufferedReader(ir);
					 String line = rdr.readLine();
					 while(!line.contains("\"")) {
						 line = rdr.readLine();
						 line = line.substring(line.indexOf("\""), line.lastIndexOf("\""));
						 System.out.println(f.getName()+ ": "+line);
					 }
				 }catch(Exception ex) {
					 System.out.printf("Failed for %s\n", f.getName());
				 }
			 }
 
		}
	}	
}
		
​
​
