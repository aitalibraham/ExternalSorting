package tp.bdd.externalsort.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sun.font.CreatedFontTracker;

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
	
	public void putToFile(String fileName, List<Integer> sortedList) throws IOException {
		PrintWriter pr = new PrintWriter(fileName);
		
		for (int num:sortedList)
			pr.println(num);
		
		pr.close();
	}
	
	
	public List arrayToArrays(int sublistsize, List<Integer> mylist) {
		List<List<Integer>> ba3oucha = new ArrayList<List<Integer>>();
		
		return ba3oucha;
	}
	
	public static void main(String[] args) throws IOException {
		Sort srt = new Sort();
		List<Integer> yanisList =  new ArrayList<Integer>();
		yanisList.add(13);
		yanisList.add(3);
		yanisList.add(1);
		srt.putToFile("yanis.txt" , yanisList);
		
	}
}

