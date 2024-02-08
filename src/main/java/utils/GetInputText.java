package utils;


import static net.serenitybdd.core.Serenity.recordReportData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GetInputText {

	private static final String FILE_PATH = "\\src\\test\\resources\\inputText"; // Replace this with the path to your file
	private static final String PROJECT_PATH = System.getProperty("user.dir");

	public static String fromFile() {
		StringBuilder fileContent = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(PROJECT_PATH + FILE_PATH))) {

			String line;

			while ((line = reader.readLine()) != null) {
				fileContent.append(line).append("\n");
			}

			recordReportData().withTitle("File content:").andContents(fileContent.toString());
		} catch (IOException e) {
			recordReportData().withTitle("Error reading the file:").andContents(e.getMessage());
		}

		return fileContent.toString();
	}

}
