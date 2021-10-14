
package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.InputStream;

class Test_Lab02 {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	
	
	@Test
	@DisplayName("Test problem1() #1")
	void test1() {
		
		outputStream = "";
		overridePrintStatements();
		String[] inputs = {"100", "90", "89", "80", "79", "70", "69", "60", "59", "43", "0"};
		String[] expectedOutputs = {"A", "A", "B", "B", "C", "C", "D", "D", "F", "F", "F"};
		
		int i = 0;
		
		try {
			
			for (i = 0; i < inputs.length; i++) {
				outputStream = "";
				provideInput(inputs[i]);
				Lab02.problem1();
				Assertions.assertTrue(outputStream.contains(expectedOutputs[i]));
			}
			
			resetPrintStream();
			
			System.out.println("Test problem1() #1: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			System.out.println("Test problem1() #1: Failed");
			System.out.println("   Input: " + inputs[i]);
			System.out.println("   Expected Output Should Contain: " + expectedOutputs[i]);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	
	
	@Test
	@DisplayName("Test problem2() #1")
	void test2() {
		
		outputStream = "";
		overridePrintStatements();
		String[][] inputs = {{"60\n60\n60","equilateral"},
				{"50\n50\n80","isosceles"},
				{"50\n80\n50","isosceles"},
				{"80\n50\n50","isosceles"},
				{"46\n47\n87","scalene"},
	 			{"45\n45\n45","not", "don't"},
				{"38\n38\n27","not", "don't"},
				{"38\n54\n38","not", "don't"},
				{"11\n62\n106","not", "don't"}
				};
		
		int i = 0;
		
		try {
			
			for (i = 0; i < inputs.length; i++) {
				outputStream = "";
				provideInput(inputs[i][0]);
				Lab02.problem2();
				if (inputs[i].length < 3)
					Assertions.assertTrue(outputStream.toLowerCase().contains(inputs[i][1]));
				else
					Assertions.assertTrue(outputStream.toLowerCase().contains(inputs[i][1])
							|| outputStream.toLowerCase().contains(inputs[i][2]));
			}
			
			resetPrintStream();
			
			System.out.println("Test problem2() #1: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			System.out.println("Test problem2() #1: Failed");
			System.out.println("   Inputs were: angle 1 = " + inputs[i][0].substring(0, 2));
			System.out.println("                angle 2 = " + inputs[i][0].substring(3, 5));
			System.out.println("                angle 3 = " + inputs[i][0].substring(6));
			if (inputs[i][1].equals("not"))
				System.out.println("   Output should indicate the angles don't form a triangle.");
			else
				System.out.println("   Expected Output Should Contain: " + inputs[i][1]);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	
	
	@Test
	@DisplayName("Test problem3() #1")
	void test3() {
		
		outputStream = "";
		overridePrintStatements();
		String[][] inputs = {{"32\n32\n32\n32", "fine", "ok", "good"},
				 			 {"32\n32\n32\n36", "fine", "ok", "good"},
							 {"32\n32\n36\n32", "fine", "ok", "good"},
							 {"32\n36\n32\n32", "fine", "ok", "good"},
							 {"36\n32\n32\n32", "fine", "ok", "good"},
							 {"40\n41\n42\n43", "fine", "ok", "good"},
							 {"31\n32\n31\n32", "low", "low"},
							 {"32\n31\n32\n32", "low"},
							 {"32\n32\n32\n31", "low"},
							 {"33\n37\n32\n35", "uneven"},
							 {"31\n28\n32\n35", "low", "low", "uneven"},
							 {"31\n28\n32\n35", "low", "low", "uneven"},
							 {"31\n32\n30\n22", "low", "low", "low", "uneven"},
							 {"20\n21\n20\n21", "low", "low", "low", "low",},
							 {"27\n21\n19\n20", "low", "low", "low", "low", "uneven"}
							 };
				
		
		int i = 0;
		
		boolean isOK = false;
		int numLow = 0;
		int numLowPrinted = 0;
		boolean isUneven = false;
		
		try {
			
			for(i = 0; i < inputs.length; i++) {
				
				outputStream = "";
				isOK = false;
				numLow = 0;
				numLowPrinted = 0;
				isUneven = false;
				provideInput(inputs[i][0]);
				Lab02.problem3();
				
				for (int j = 0; j < inputs[i].length; j++) {
					if (inputs[i][j].equals("fine")) {
						isOK = true;
						break;
					}
					else if (inputs[i][j].equals("uneven")) {
						isUneven = true;
					}
					else if (inputs[i][j].equals("low")) {
						numLow++;
					}
				}
				
				if (isOK) {
					Assertions.assertTrue(outputStream.toLowerCase().contains("ok") 
							    	   || outputStream.toLowerCase().contains("good") 
							    	   || outputStream.toLowerCase().contains("fine"));
				}
				
				if (isUneven) {
					Assertions.assertTrue(outputStream.toLowerCase().contains("uneven"));
				}
				
				if (numLow > 0) {
					for (int j = 0; j < outputStream.length() - 2; j++ ) {
						if (outputStream.substring(j, j + 3).equalsIgnoreCase("low")) {
							numLowPrinted++;
						}
					}
					
					Assertions.assertEquals(numLow, numLowPrinted);
					
				}
				
				
				
				
			}
			
			
			resetPrintStream();
			
			System.out.println("Test problem3() #1: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			System.out.println("Test problem3() #1: Failed");
			System.out.println("   Inputs were: tire 1 = " + inputs[i][0].substring(0, 2));
			System.out.println("                tire 2 = " + inputs[i][0].substring(3, 5));
			System.out.println("                tire 3 = " + inputs[i][0].substring(6, 8));
			System.out.println("                tire 4 = " + inputs[i][0].substring(9));
			if (isOK)
				System.out.println("   Output should indicate the tires are fine.");
			if (numLow == 1)
				System.out.println("   Output should indicate which tire is low.");
			else if (numLow > 1) {
				System.out.println("   Output should indicate which " + numLow + " tires are low.");
			}
			if (isUneven)
				System.out.println("   Output should indicate the tires are uneven.");
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	
	
	@Test
	@DisplayName("Test problem4() #1")
	void test4() {
		
		outputStream = "";
		overridePrintStatements();
		String[][] inputs = {{"44", "40"},
							 {"45", "50"},
							 {"97", "100"},
							 {"10479", "10480"},
							 {"19995", "20000"},
							 {"3", "0"},
							 {"2147483637", "2147483640"},};
		
		int i = 0;
		
		try {
			
			for (i = 0; i < inputs.length; i++) {
				outputStream = "";
				provideInput(inputs[i][0]);
				Lab02.problem4();
				Assertions.assertTrue(outputStream.toLowerCase().contains(inputs[i][1]));
				
			}
			
			resetPrintStream();
			
			System.out.println("Test problem4() #1: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			System.out.println("Test problem4() #1: Failed");
			System.out.println("   Input: " + inputs[i][0]);
			System.out.println("   Expected Output: " + inputs[i][1]);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	
	
	private void overridePrintStatements() {
		System.setOut(new PrintStream(System.out) {
			
			//override all println()s
			public void println() {
				printCalled("\n");
			}
			public void println(boolean b) {
				printCalled(String.valueOf(b) + "\n");
			}
			public void println(char c) {
				printCalled(String.valueOf(c) + "\n");
			}
			public void println(char[] s) {
				printCalled(String.valueOf(s) + "\n");
			}
			public void println(double d) {
				printCalled(String.valueOf(d) + "\n");
			}
			public void println(float f) {
				printCalled(String.valueOf(f) + "\n");
			}
			public void println(int i) {
				printCalled(String.valueOf(i) + "\n");
			}
			public void println(long l) {
				printCalled(String.valueOf(l) + "\n");
			}
			public void println(Object obj) {
				printCalled(String.valueOf(obj) + "\n");
			}
			public void println(String str) {
				printCalled(str + "\n");
			}
			
			
			//override printf()
			public void printf(String str) {
				printCalled(str);
			}
			
			
			//override all print()s
			public void print(boolean b) {
				printCalled(String.valueOf(b));
			}
			public void print(char c) {
				printCalled(String.valueOf(c));
			}
			public void print(char[] s) {
				printCalled(String.valueOf(s));
			}
			public void print(double d) {
				printCalled(String.valueOf(d));
			}
			public void print(float f) {
				printCalled(String.valueOf(f));
			}
			public void print(int i) {
				printCalled(String.valueOf(i));
			}
			public void print(long l) {
				printCalled(String.valueOf(l));
			}
			public void print(Object obj) {
				printCalled(String.valueOf(obj));
			}
			public void print(String str) {
				printCalled(str);
			}
			
		});

	}
	
	
	private void printCalled(String str) {
		outputStream += str; 
	}
	
	
	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}
	
	private void resetPrintStream() {
		System.setOut(systemOut);
		System.setIn(systemIn); 
	}
	
	@AfterAll
	static void afterAll() {
		System.setOut(systemOut);
		System.setIn(systemIn);
	}
	

}