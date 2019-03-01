package utils;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args){
		String query = "select count(1) from med_bos_transactions where medtr_oid between 1 and 100000 order by medtr_oid desc";
		
//		myTestCase(query, url, user, pass);
//		myTestCase2(query, url, user, pass);
		List<String> ids = new ArrayList<String>();
		ids.add("18");
		List<String> showTransaction = DatabaseConnector.getTransactionValuesInDatabase(ids);
		System.out.println(String.join(",", showTransaction));
	}
	
	private static void myTestCase(String query){
		Long testResultOK = 31462L;
		Long testResult = DatabaseConnector.checkResultInDatabase(query);
		writeResult("myTestCase", testResult.equals(testResultOK));
	}
	
	private static void myTestCase2(String query){
		Long testResultOK = 1L;
		Long testResult = DatabaseConnector.checkResultInDatabase(query);
		writeResult("myTestCase2", testResult.equals(testResultOK));
	}
	
	private static void writeResult(String testName, boolean result){
		System.out.println("Test " + testName + " : " + (result ? "OK" : "KO"));
	}
	
}
