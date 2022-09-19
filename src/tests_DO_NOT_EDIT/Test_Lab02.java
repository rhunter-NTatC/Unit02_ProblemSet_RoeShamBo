package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class Test_Lab02 {

public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}
	
	@Test
	@DisplayName("Test problem1()")
	void test1() {
		String problemNumber = "Problem #1";
		String[][] tests = {{"100", "A"},
							{"90", "A"},
							{"89", "B"},
							{"80", "B"},
							{"79", "C"},
							{"70", "C"},
							{"69", "D"},
							{"60", "D"},
							{"59", "F"},
							{"35", "F"},
							{"0", "F"},
							};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem1();
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected grade: " + tests[i][1] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	
	
	@Test
	@DisplayName("Test problem2()")
	void test2() {
		String problemNumber = "Problem #2";
		String[][] tests = {{"60\n60\n60","equilateral"},
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
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem2();
				if (tests[i].length < 3) {
					assertTrue(inOut.getOutputStream()
									.toLowerCase()
									.contains(tests[i][1]));
				}
				else {
					assertTrue(inOut.getOutputStream()
							   		.toLowerCase()
							   		.contains(tests[i][1])
						       ||
						       inOut.getOutputStream()
							   		.toLowerCase()
							   		.contains(tests[i][2]));
				}
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			String expectedOutput = tests[i][1].equals("not") ? "Those do not make a triangle." : tests[i][1];
			
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Inputs were: angle 1 = " + tests[i][0].substring(0, 2)
					+ "\n                angle 2 = " + tests[i][0].substring(3, 5)
					+ "\n                angle 3 = " + tests[i][0].substring(6)
					+ "\n   Expected triangle type: " + expectedOutput
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	@Test
	@DisplayName("Test problem3()")
	void test3() {
		String problemNumber = "Problem #3";
		String[][] tests = {{"32\n32\n32\n32", "fine", "ok", "good"},
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
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				isOK = false;
				numLow = 0;
				numLowPrinted = 0;
				isUneven = false;
				inOut.provideInput(tests[i][0]);
				Lab02.problem3();
				
				for (int j = 0; j < tests[i].length; j++) {
					if (tests[i][j].equals("fine")) {
						isOK = true;
						break;
					}
					else if (tests[i][j].equals("uneven")) {
						isUneven = true;
					}
					else if (tests[i][j].equals("low")) {
						numLow++;
					}
				}
				
				if (isOK) {
					Assertions.assertTrue(inOut.getOutputStream().toLowerCase().contains("ok") 
							    	   || inOut.getOutputStream().toLowerCase().contains("good") 
							    	   || inOut.getOutputStream().toLowerCase().contains("fine"));
				}
				
				if (isUneven) {
					Assertions.assertTrue(inOut.getOutputStream().toLowerCase().contains("uneven"));
				}
				
				if (numLow > 0) {
					for (int j = 0; j < inOut.getOutputStream().length() - 2; j++ ) {
						if (inOut.getOutputStream().substring(j, j + 3).equalsIgnoreCase("low")) {
							numLowPrinted++;
						}
					}
					
					Assertions.assertEquals(numLow, numLowPrinted);
					
				}
				
				
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			String expectedOutput = "";
			
			if (isOK)
				expectedOutput += "\n      Output should indicate the tires are fine.";
			if (numLow == 1)
				expectedOutput += "\n      Output should indicate which tire is low.";
			else if (numLow > 1) 
				expectedOutput += "\n      Output should indicate which " + numLow + " tires are low.";
			if (isUneven)
				expectedOutput += "\n      Output should indicate the tires are uneven.";
			
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Inputs were: tire 1 = " + tests[i][0].substring(0, 2)
					+ "\n                tire 2 = " + tests[i][0].substring(3, 5)
					+ "\n                tire 3 = " + tests[i][0].substring(6, 8)
					+ "\n                tire 4 = " + tests[i][0].substring(9)
					+ "\n   Expected output: " + expectedOutput
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
				
	}
	
	
	
	
	@Test
	@DisplayName("Test problem4()")
	void test4() {
		String problemNumber = "Problem #4";
		String[][] tests = {{"44", "40"},
				 			{"45", "50"},
				 			{"97", "100"},
				 			{"10479", "10480"},
				 			{"19996", "20000"},
				 			{"3", "0"},
				 			{"97", "100"},
				 			{"19993", "19990"},
				 			{"148", "150"},
				 			{"2147483632", "2147483630"}
				 			};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem4();
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected return: " + tests[i][1] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	
	
}
