package tp.bdd.externalsort.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	public int pageSize;
	public int bufferSize;
	public String inputFile;
	public String outputFile;
	
	public void Sorter() throws IOException {
		divideFileIntoFiles();
		String[] files = new File("buffer").list();
		for(int i=0;i<files.length-1;i++) {
			mergeCouple(files[i], files[i+1]);
		}
		new File("buffer\\"+files[files.length-1]).renameTo(new File("buffer\\out.txt"));
	}


	public void mergeCouple(String firstFile, String secondFile) throws IOException {
		BufferedReader firstReader = new BufferedReader(new FileReader("buffer\\"+firstFile));
		BufferedReader secondReader = new BufferedReader(new FileReader("buffer\\"+secondFile));
		String firstLine=firstReader.readLine(), secondLine=secondReader.readLine();
		int firstInt, secondInt;
		List mylist = new ArrayList<Integer>();
		while(firstLine!=null) {
			firstInt=Integer.parseInt(firstLine);
			if(secondLine!=null) {
				secondInt=Integer.parseInt(secondLine);
				if(firstInt<secondInt) {
					mylist.add(firstInt);
					firstLine=firstReader.readLine();
				}else {
					mylist.add(secondInt);
					secondLine=secondReader.readLine();
				}
			}else {
				mylist.add(firstInt);
				firstLine=firstReader.readLine();;
			}
		}
		while((secondLine=firstReader.readLine())!=null) {	
			secondInt=Integer.parseInt(secondLine);
			mylist.add(secondInt);
			}
		arrayListToFile("buffer\\"+secondFile, mylist);
		firstReader.close();
		secondReader.close();
		new File("buffer\\"+firstFile).delete();
	}
	
	public void divideFileIntoFiles() throws IOException {
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
					l.clear();
				}
			}
			if(!l.isEmpty()) {
				Collections.sort(l);
				arrayListToFile("buffer\\"+(((int) linecount/6)+1)+".txt", l);
			}
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		objReader.close();
	}
	
	public void arrayListToFile(String filepath, List<Integer> mylist) throws IOException {
		FileWriter writer = new FileWriter(filepath); 
		for(int i: mylist) {
			  writer.write(i + System.lineSeparator());
			}
			writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		try {
			new Sort().Sorter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

