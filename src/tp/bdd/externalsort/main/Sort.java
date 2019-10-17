package tp.bdd.externalsort.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sort {
	public int pageSize;
	public int bufferSize;
	public String inputFile;
	public String outputFile;
	
	public void Sorter() throws FileNotFoundException {
		BufferedReader objReader = new BufferedReader(new FileReader("SourceFiles\\in.txt"));
		BufferedReader objWriter;
		int currentline;
		int filenumber;
		String line;
		try {
			int linecount=0;
			while ((line = objReader.readLine()) != null) {
				linecount++;
				filenumber=linecount/6;
				objWriter = new BufferedReader(new FileReader("buffer\\"+filenumber+".txt"));
				if(linecount % 6 == 0) {
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileToArrayList(String filename) throws IOException {
		BufferedReader objReader = new BufferedReader(new FileReader(filename));
		String line;
		while((line= objReader.readLine())!=null){
			
		}
	}
	
	
	public List arrayToArrays(int sublistsize, List<Integer> mylist) {
		List<List<Integer>> ba3oucha = new ArrayList<List<Integer>>();
		
		return ba3oucha;
	}
	
	public static void main(String[] args) {
		
	}
}

