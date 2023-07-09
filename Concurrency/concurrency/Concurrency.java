package concurrency;

import java.io.IOException;

public class Concurrency {

	//Initialing global variables to be used in multiple different functions
	public int[] randNumbs= new int[200000000];
	public int localTotal;
	
	public void Main() throws IOException {
		
		//Defining min and max for random number generator
		int max = 10;
		int min = 1;		
		
		int number = 0;
		
		//Populating array with random numbers defined by min and max
		for(int i = 0; i < randNumbs.length; i++) {
			number = (int)Math.floor(Math.random() * (max - min + 1) + min);
			//System.out.println(number);
			randNumbs[i] = number;
			localTotal += number;
		}

	}

	//Computing sum in single thread
	public int Sum() throws IOException {
		Main();
		
		int total = 0;
		for(int i = 0; i < randNumbs.length; i++) {
			total += randNumbs[i];
		}
		
		return total;
	}
	
	//Computing sum in multiple threads
	public int multiSum() throws IOException {
		Main();
		int total = 0;
		
		total = Multi1() + Multi2() + Multi3() + Multi4();
		
		return total;
	}
	
	
	//The different threads used in multiSum function
	//This thread adds up the first quarter of numbers in the array
	public int Multi1() {
		int total = 0;
		
		//System.out.println("Start= " + 0 + ", End= " + randNumbs.length/4);
		
		for(int i = 0; i < randNumbs.length/4; i++) {
			total += randNumbs[i];
		}
		
		return total;
	}
	//This thread adds up the second quarter of numbers in the array
	public int Multi2() {
		int total = 0;
		
		int start = (randNumbs.length/4);
		int end = (randNumbs.length/4)*2;
		
		//System.out.println("Start= " + start + ", End= " + end);
		
		for(int i = start; i < end; i++) {
			total += randNumbs[i];
		}
		
		return total;
	}
	//This thread adds up the third quarter of numbers in the array
	public int Multi3() {
		int total = 0;
		
		int start = (randNumbs.length/4)*2;
		int end = (randNumbs.length/4)*3;
		
		//System.out.println("Start= " + start + ", End= " + end);
		
		for(int i = start; i < end; i++) {
			total += randNumbs[i];
		}
		
		return total;
	}
	//This thread adds up the last quarter of numbers in the array
	public int Multi4() {
		int total = 0;
		
		int start = (randNumbs.length/4)*3;
		int end = randNumbs.length;
		
		//System.out.println("Start= " + start + ", End= " + end);
		
		for(int i = start; i < end; i++) {
			total += randNumbs[i];
		}
		return total;
	}
	

}

