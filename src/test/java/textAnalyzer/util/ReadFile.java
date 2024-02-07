package textAnalyzer.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import net.serenitybdd.screenplay.Actor.ErrorHandlingMode;


public class ReadFile {

	private static String FILE_PATH = "\\src\\test\\resources\\inputText"; // Replace this with the path to your file
	private static String PROJECT_PATH = System.getProperty("user.dir");
	public static String getInputText() {
		String fileContent = null;

		try {
			fileContent = readFile(PROJECT_PATH+FILE_PATH);
			System.out.println("File content:");
			System.out.println(fileContent);
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}

		return fileContent;
	}
	// "C:\Users\Milton\IdeaProjects\serenity-demo\src\test\resources\inputText"

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
