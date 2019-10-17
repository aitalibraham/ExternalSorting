package tp.bdd.externalsort.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort {
	public int pageSize;
	public int bufferSize;
	public String inputFile;
	public String outputFile;
	
	public void getFromFile() throws FileNotFoundException {
			Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\abahlel\\eclipse-workspace\\ExternalSort\\src\\tp\\bdd\\externalsort\\main\\in.txt")));
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		
	}
	
	public void putToFile(String fileName, List<Integer> sortedListe) {
		
	}
	
	
	public List arrayToArrays(int sublistsize, List<Integer> mylist) {
		List<List<Integer>> ba3oucha = new ArrayList<List<Integer>>();
		
		return ba3oucha;
	}
	
	public static void main(String[] args) {
		
	}
}

