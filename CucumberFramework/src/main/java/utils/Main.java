package utils;

import java.util.ArrayList;
import java.util.List;

import gherkin.lexer.Da;

public class Main {

	public static void main(String[] args){
		String url = "jdbc:oracle:thin:@10.101.138.58:1521:DEVI77";
		String user = "I77";
		String pass = "I77";
		String query = "select count(1) from med_bos_transactions where medtr_oid between 1 and 100000 order by medtr_oid desc";
		
//		myTestCase(query, url, user, pass);
//		myTestCase2(query, url, user, pass);
		List<String> ids = new ArrayList<String>();
		ids.add("18");
		List<String> showTransaction = DatabaseConnector.getTransactionValuesInDatabase(url, user, pass, ids);
		System.out.println(String.join(",", showTransaction));
	}
	
	private static void myTestCase(String query, String url, String user, String pass){
		Long testResultOK = 31462L;
		Long testResult = DatabaseConnector.checkResultInDatabase(query, url, user, pass);
		writeResult("myTestCase", testResult.equals(testResultOK));
	}
	
	private static void myTestCase2(String query, String url, String user, String pass){
		Long testResultOK = 1L;
		Long testResult = DatabaseConnector.checkResultInDatabase(query, url, user, pass);
		writeResult("myTestCase2", testResult.equals(testResultOK));
	}
	
	private static void writeResult(String testName, boolean result){
		System.out.println("Test " + testName + " : " + (result ? "OK" : "KO"));
	}
	
}
