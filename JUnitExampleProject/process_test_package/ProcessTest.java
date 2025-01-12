/**
 * 
 */
package process_test_package;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Process.ProcessRun;





/**
 * @author Itai
 *
 */
class ProcessTest {

	String output;
	
	ProcessRun process;
	String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
	static int counter = 0;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 output = "";
		 process = new ProcessRun();
		 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	counter++;
	System.out.println("finished test number : " + String.valueOf(counter));
	}


	/***
	 * Test the stack trace pring is working.
	 */
	@Test
	void testTrace() {	
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String trace1 = sw.toString();
			System.out.print(trace1);
			
			Assert.assertTrue(!trace1.isEmpty());
		}
	}


	/***
	 * Test operating system command line.
	 * Run command line sub process.
	 */	
	@Test
	void testCmdDir() {
		try {
			//in dir_rist you should change the path to ur own path, make sure u do it before runing 
			//the test, otherwise you gonna get an error ! 
			String[] dir_rist = {"dir", "C:\\Users\\ZAHER\\"};
			process.Execute(dir_rist);
			process = null;
		} catch (Exception e) {
			fail("Unable to run dir");
		}
		return;
	}
	
	
	/***
	 * Test the console application runs.
	 */
	@Test
	void testConsole() {
		
		try {
			output = process.Run(command);
			System.out.println(output);
						
			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}

	

	/***
	 * Test the console application runs 
	 * and execute command-line echo command.
	 */
	@Test
	void testEchoCommand() {
		
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("echo(Hello world)\n");
			Assert.assertTrue(output.contentEquals("Hello world\r\n>"));

			output = process.Command("echo(Hello world)\n");
			Assert.assertTrue(output.contentEquals("Hello world\r\n>"));

			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}
	@Test
	void testAddCommand() {
	
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("add(2,3,4)\n");
			Assert.assertTrue(output.contentEquals("9\r\n>"));

			output = process.Command("add(3,3,3)\n");
			Assert.assertTrue(output.contentEquals("9\r\n>"));

			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}
	
	@Test
	void testSubCommand() {
		
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("sub(1,1,1)\n");
			Assert.assertTrue(output.contentEquals("-1\r\n>"));

			output = process.Command("sub(3,3,2)\n");
			Assert.assertTrue(output.contentEquals("-2\r\n>"));

			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}
	
	@Test
	void testMultiCommand() {
		
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("mul(1,2,3)\n");
			Assert.assertTrue(output.contentEquals("6\r\n>"));

			output = process.Command("mul(2,3,4)\n");
			Assert.assertTrue(output.contentEquals("24\r\n>"));

			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}
	@Test
	void testDivideCommand() {
		
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("div(1,1,1)\n");
			Assert.assertTrue(output.contentEquals("1\r\n>"));

			output = process.Command("div(2,2,2)\n");
			Assert.assertTrue(output.contentEquals("0\r\n>"));

			output = process.Exit();			
		}
		catch (Exception e) {
			//	In case of exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			//	Read the trace information.
			e.printStackTrace(pw);
			String trace = sw.toString();
			
			//	Write the trace to console and fail the test.
			System.out.print(trace);
			Assert.assertTrue(!trace.isEmpty());
		}
		return;
	}

}
