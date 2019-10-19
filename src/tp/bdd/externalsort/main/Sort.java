package tp.bdd.externalsort.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	public int pageSize;
	public int bufferSize;
	public String inputFile;
	public String outputFile;
	
	public void Sorter() throws FileNotFoundException {
		BufferedReader objReader = new BufferedReader(new FileReader("SourceFiles\\in.txt"));
		String line;
		List l=new ArrayList<Integer>();;
		try {
			int linecount=0;
			while ((line = objReader.readLine()) != null) {
				l.add(Integer.parseInt(line));
				linecount++;
				if(linecount % 6 == 0) {
					Collections.sort(l);
					arrayListToFile("buffer\\"+(linecount/6)+".txt", l);
					l=new ArrayList<Integer>();
				}
			}
			
			if(!l.isEmpty()) {
				Collections.sort(l);
				arrayListToFile("buffer\\"+(((int) linecount/6)+1)+".txt", l);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List fileToArrayList(String filename) throws IOException {
		
	}
	
	public void arrayListToFile(String filepath, List<Integer> mylist) throws IOException {
		FileWriter writer = new FileWriter(filepath); 
		for(int i: mylist) {
			  writer.write(i + System.lineSeparator());
			}
			writer.close();
	}
	
	public static void main(String[] args) {
		try {
			new Sort().Sorter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

