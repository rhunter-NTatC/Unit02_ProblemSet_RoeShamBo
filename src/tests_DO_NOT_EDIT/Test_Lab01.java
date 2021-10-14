package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.InputStream;

class Test_Lab01 {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	
	
	@Test
	@DisplayName("Test problem1() #1")
	void test1() {
		
		outputStream = "";
		overridePrintStatements();
		
		String expectedOutput = "Five, six, pickup sticks!";
		String input = "6";
		provideInput(input);
		
		Lab01.problem1();
		
		resetPrintStream();
		
		try {
		
			Assertions.assertTrue(outputStream.contains(expectedOutput));
			
			System.out.println("Test problem1() #1: Passed\n\n\n\n");
			
		}
		catch(Error e) {
			
			System.out.println("Test problem1() #1: Failed");
			System.out.println("   Input: " + input);
			System.out.println("   Expected Output: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	@Test
	@DisplayName("Test problem1() #2")
	void test2() {
		
		outputStream = "";
		overridePrintStatements();
		
		String expectedOutput = "That's so negative of you!";
		String[] inputs = {"-100", "15", "-5", "-1", "0", "5", "38", "500"};
		
		int i = 0;
		
		try {
		
			for (i = 0; i < inputs.length; i++) {
				
				outputStream = "";
				provideInput(inputs[i]);
				Lab01.problem1();
				if (Integer.valueOf(inputs[i]) < 0) 
					Assertions.assertTrue(outputStream.contains(expectedOutput));
				else
					Assertions.assertFalse(outputStream.contains(expectedOutput));
				
			}
			
			resetPrintStream();
			
			System.out.println("Test problem1() #2: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			
			System.out.println("Test problem1() #2: Failed");
			System.out.println("   Input: " + inputs[i]);
			if (Integer.valueOf(inputs[i]) < 0)
				System.out.println("   Expected Output: " + expectedOutput);
			else
				System.out.println("   Expected Output Should NOT Be: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	
	@Test
	@DisplayName("Test problem1() #3")
	void test3() {
		
		outputStream = "";
		overridePrintStatements();
		
		String expectedOutput = "Oh the teenage years...";
		String[] inputs = {"12", "13", "14", "15", "16", "17", "18", "19", "20"};
		
		int i = 0;
		
		try {
		
			for (i = 0; i < inputs.length; i++) {
				
				outputStream = "";
				provideInput(inputs[i]);
				Lab01.problem1();
				if (Integer.valueOf(inputs[i]) != 12 && Integer.valueOf(inputs[i]) != 20)
					Assertions.assertTrue(outputStream.contains(expectedOutput));
				else
					Assertions.assertFalse(outputStream.contains(expectedOutput));
				
			}
			
			resetPrintStream();
			
			System.out.println("Test problem1() #3: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			
			System.out.println("Test problem1() #3: Failed");
			System.out.println("   Input: " + inputs[i]);
			if (Integer.valueOf(inputs[i]) != 12 && Integer.valueOf(inputs[i]) != 20)
				System.out.println("   Expected Output: " + expectedOutput);
			else
				System.out.println("   Expected Output Should NOT Be: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	@Test
	@DisplayName("Test problem1() #4")
	void test4() {
		
		outputStream = "";
		overridePrintStatements();
		
		String expectedOutput = "What about the odds?";
		String[] inputs = {"1", "7", "11", "20", "101", "100", "5028", "19", "20"};
		
		int i = 0;
		
		try {
		
			for (i = 0; i < inputs.length; i++) {
				
				outputStream = "";
				provideInput(inputs[i]);
				Lab01.problem1();
				if (Integer.valueOf(inputs[i]) % 2 == 0 && Integer.valueOf(inputs[i]) >= 20)
					Assertions.assertTrue(outputStream.contains(expectedOutput));
				else
					Assertions.assertFalse(outputStream.contains(expectedOutput));
				
			}
			
			resetPrintStream();
			
			System.out.println("Test problem1() #4: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			
			System.out.println("Test problem1() #4: Failed");
			System.out.println("   Input: " + inputs[i]);
			if (Integer.valueOf(inputs[i]) % 2 == 0 && Integer.valueOf(inputs[i]) >= 20)
				System.out.println("   Expected Output: " + expectedOutput);
			else
				System.out.println("   Expected Output Should NOT Be: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	

	
	@Test
	@DisplayName("Test problem1() #5")
	void test5() {
		
		outputStream = "";
		overridePrintStatements();
		
		String expectedOutput = "I haven't found that one yet.";
		String[] inputs = {"1", "7", "11", "21", "101", "100", "505", "19", "20"};
		
		int i = 0;
		
		try {
		
			for (i = 0; i < inputs.length; i++) {
				
				outputStream = "";
				provideInput(inputs[i]);
				Lab01.problem1();
				if (Integer.valueOf(inputs[i]) % 2 == 1 && Integer.valueOf(inputs[i]) >= 20
					|| Integer.valueOf(inputs[i]) >= 0 && Integer.valueOf(inputs[i]) <= 12)
					Assertions.assertTrue(outputStream.contains(expectedOutput));
				else
					Assertions.assertFalse(outputStream.contains(expectedOutput));
				
			}
			
			resetPrintStream();
			
			System.out.println("Test problem1() #5: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			
			System.out.println("Test problem1() #5: Failed");
			System.out.println("   Input: " + inputs[i]);
			if (Integer.valueOf(inputs[i]) % 2 == 1 && Integer.valueOf(inputs[i]) >= 20
					|| Integer.valueOf(inputs[i]) >= 0 && Integer.valueOf(inputs[i]) <= 12)
				System.out.println("   Expected Output: " + expectedOutput);
			else
				System.out.println("   Expected Output Should NOT Be: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
			
		}
		
	}

	
	
	
	@Test
	@DisplayName("Test problem2() #1")
	void test6() {
	
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "What can I do for you?";
		String input = Lab01.name;
		provideInput(input);
		
		Lab01.problem2();
		
		resetPrintStream();
		
		try {
			Assertions.assertTrue(outputStream.contains(expectedOutput));
		
			System.out.println("Test problem2() #1: Passed all inputs\n\n\n\n");
		}
		catch (Error e) {
			System.out.println("Test problem2() #1: Failed");
			System.out.println("   Input: " + input);
			System.out.println("   Expected Output: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
		}
		
	}

	
	
	@Test
	@DisplayName("Test problem2() #2")
	void test7() {
	
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "You don't even know my name. We're THROUGH!!";
		String input = Lab01.name;
		provideInput(input + ";kadfhs");
		
		Lab01.problem2();
		
		resetPrintStream();
		
		try {
			Assertions.assertTrue(outputStream.contains(expectedOutput));
		
			System.out.println("Test problem2() #2: Passed all inputs\n\n\n\n");
		}
		catch (Error e) {
			System.out.println("Test problem2() #2: Failed");
			System.out.println("   Input: " + input);
			System.out.println("   Expected Output: " + expectedOutput);
			System.out.println("   Your Output: \n" + outputStream + "\n\n\n\n");
			Assertions.fail();
		}
		
	}
	
	
	
	@Test
	@DisplayName("Test problem3() #1")
	void test8() {
		
		outputStream = "";
		overridePrintStatements();
		
		
		String[] inputs = {"11\n2", "7\n1", "19\n2", "19\n3", "19\n4", "25\n1", "51\n3", "27\n3"};
		String[] expectedOutputs = {"enough",
				"enough",
				"1",
				"enough",
				"enough",
				"2",
				"3",
				"enough"};
		
		int i = 0;
		
		try {
		
			for (i = 0; i < inputs.length; i++) {
				outputStream = "";
				provideInput(inputs[i]);
				Lab01.problem3();
				Assertions.assertTrue(outputStream.contains(expectedOutputs[i]));
			}
			
			resetPrintStream();
			
			System.out.println("Test problem3() #1: Passed all inputs\n\n\n\n");
			
		}
		catch(Error e) {
			
			resetPrintStream();
			System.out.println("Test problem3() #1: Failed");
			System.out.println("   Input: boards = " + inputs[i].substring(0, inputs[i].indexOf("\n")));
			System.out.println("          nails  = " + inputs[i].substring(inputs[i].indexOf("\n") + 1));
			if (expectedOutputs[i].equals("enough"))
				System.out.println("   Expected Output: You have enough nails.");
			else
				System.out.println("   Expected Output: You need " + expectedOutputs[i] + " more nail boxes.");
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
