import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PeddieStudents {

	Tree<String> t = new Tree<String>();

	public void insertPeddieStudents(){
		Scanner scan = null;

		try 
		{
			scan = new Scanner (new File ("List.csv"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		while (scan.hasNext()) 
		{
			String line = scan.nextLine();
			String [] fields = new String[3];
			fields = line.split(",");
			String name = fields[0] + " " + fields[1];
			String year = fields[2];    
			t.insert(name, year);
		}
		scan.close();
	}

	void testStuff(){
		t.inorderPrint();
		System.out.println("Number of Nodes: " + t.numNodes());
		System.out.println("Highest Node: " + t.highestNumber());
		System.out.println("Height: " + t.printHeight());
		System.out.println("Class of: 20" + t.getData("Vincent Luo"));
	}

}

