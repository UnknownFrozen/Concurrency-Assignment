package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;


public class ConcurrencyTest1 {

	public Concurrency test = new Concurrency();
	@Test
	public void test1() throws IOException {
		
		int sum = test.Sum();
		int localSum = test.localTotal;
		
		assertEquals(Integer.valueOf(sum), localSum);
		System.out.println("Local Sum of instance: " + localSum);
		System.out.println("Sum of single thread: " + sum);
		System.out.println("");
		
	}
	@Test
	public void test2() throws IOException {
		int sum = test.multiSum();
		int localSum = test.localTotal;
		
		assertEquals(Integer.valueOf(sum), localSum);
		System.out.println("Local Sum of instance: " + localSum);
		System.out.println("Sum of multi thread: " + sum);
		System.out.println("");
		
	}
}