package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class Test_Lab01 {
	
	public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}
	
	@Test
	@DisplayName("Test problem1()")
	void test1() {
		String problemNumber = "Problem #1";
		String[][] tests = {{"6", "Five, six, pickup sticks!"},
							{"-1", "That's so negative of you!"},
							{"-4", "That's so negative of you!"},
							{"-15", "That's so negative of you!"},
							{"13", "Oh the teenage years..."},
							{"14", "Oh the teenage years..."},
							{"15", "Oh the teenage years..."},
							{"16", "Oh the teenage years..."},
							{"17", "Oh the teenage years..."},
							{"18", "Oh the teenage years..."},
							{"19", "Oh the teenage years..."},
							{"20", "What about the odds?"},
							{"48", "What about the odds?"},
							{"156", "What about the odds?"},
							{"372", "What about the odds?"},
							{"21", "I haven't found that one yet."},
							{"77", "I haven't found that one yet."},
							{"491", "I haven't found that one yet."},
							{"0", "I haven't found that one yet."},
							{"1", "I haven't found that one yet."},
							{"2", "I haven't found that one yet."},
							{"3", "I haven't found that one yet."},
							{"4", "I haven't found that one yet."},
							{"5", "I haven't found that one yet."}
							};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab01.problem1();
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
					+ "\n   Expected return should be: " + tests[i][1] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}

	@Test
	@DisplayName("Test problem2()")
	void test2() {
		String problemNumber = "Problem #2";
		String[][] tests = {{Lab01.name, "What can I do for you?"},
							{"James Earl Jones", "You don't even know my name. We're THROUGH!!"},
							{"Fred Estaire", "You don't even know my name. We're THROUGH!!"},
							{"Pierce Brosnin", "You don't even know my name. We're THROUGH!!"}
							};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab01.problem2();
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   3 Possible Problems"
					+ "\n      name variable not declared at top (as per instructions)"
					+ "\n      Strings not compared correctly"
					+ "\n      Output not formatted correctly"
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected return should be: " + tests[i][1] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}

	
	
	@Test
	@DisplayName("Test problem3()")
	void test3() {
		String problemNumber = "Problem #3";
		String[][] tests = {{"9", "1", "You have enough nails."},
							{"15", "25", "You have enough nails."},
							{"25", "3", "You have enough nails."},
							{"327", "37", "You have enough nails."},
							{"19", "5", "You have enough nails."},
							{"1", "9", "You have enough nails."},
							{"10", "1", "You need 1 more nail boxes."},
							{"10", "0", "You need 2 more nail boxes."},
							{"327", "34", "You need 3 more nail boxes."},
							{"75", "5", "You need 4 more nail boxes."},
							{"42", "1", "You need 4 more nail boxes."},
							};
		int i = 0;

		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0] + "\n" + tests[i][1]);
				Lab01.problem3();
				assertTrue(inOut.getOutputStream().contains(tests[i][2]));
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " 
					+ "\n      Boards     = " + tests[i][0]
					+ "\n      Nail Boxes = " + tests[i][1]
					+ "\n   Expected return should be: " + tests[i][2] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
}
