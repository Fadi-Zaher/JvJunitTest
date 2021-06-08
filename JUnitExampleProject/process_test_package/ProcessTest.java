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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
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
		ProcessRun process = new ProcessRun();
		
		try {
			String[] dir_rist = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe", ""};
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
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
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

	@Test
	void testAddCommand() {
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
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

	/***
	 * Test the console application runs 
	 * and execute command-line echo command.
	 */
	@Test
	void testEchoCommand() {
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
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
	void testSubCommand() {
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
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
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
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
		String output = "";
		ProcessRun process = new ProcessRun();
		String[] command = {"C:\\Users\\ZAHER\\_SOURCEDIV.TEST\\CPPCONSOLEAPI\\WsCppConsoleAPI\\CppConsoleAPI\\Debug\\CppConsoleAPI.exe",""};
		try {
			output = process.Run(command);
			Assert.assertTrue(output.contentEquals("\r\n>"));
			
			output = process.Command("div(1,1,1)\n");
			Assert.assertTrue(output.contentEquals("1\r\n>"));

			output = process.Command("div(2,2,2)\n");
			Assert.assertTrue(output.contentEquals("1\r\n>"));

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
