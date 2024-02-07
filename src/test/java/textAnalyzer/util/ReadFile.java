package textAnalyzer.util;


import static net.serenitybdd.core.Serenity.recordReportData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

	private static String FILE_PATH = "\\src\\test\\resources\\inputText"; // Replace this with the path to your file
	private static String PROJECT_PATH = System.getProperty("user.dir");
	public static String getInputText() {
		String fileContent = null;

		try {
			fileContent = readFile(PROJECT_PATH + FILE_PATH);
			recordReportData().withTitle("File content:").andContents(fileContent);
		} catch (IOException e) {
			recordReportData().withTitle("Error reading the file:").andContents(e.getMessage());
		}

		return fileContent;
	}

	public static String readFile(String filePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}
}
