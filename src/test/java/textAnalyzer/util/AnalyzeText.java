package textAnalyzer.util;

import static net.serenitybdd.core.Serenity.recordReportData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalyzeText {

	public static String countCharactersOf(String text) {
		return formatCounter(String.valueOf(text.replace("\n",
			"").length()));
	}

	public static String countWordsOf(String text) {
		String[] words = text.split("[\\s/:]+");
		return formatCounter(String.valueOf(words.length));
	}

	public static String countSentencesOf(String text) {
		text = text.replace(":\n", ":");
		String[] sentences = text.split("[.!?\n]+");
		return formatCounter(String.valueOf(sentences.length));
	}

	public static Map<String, Integer> getMostRepeatedWordsOf(Integer wordsNumber, String text) {
		List<Entry<String, Integer>> sortedWordList = getWordFrequencyOf(text);

		Map<String, Integer> moreRepeatedWords = new LinkedHashMap<>();
		for (int i = 0; i < Math.min(wordsNumber, sortedWordList.size()); i++) {
			moreRepeatedWords.put(sortedWordList.get(i).getKey().trim(), sortedWordList.get(i).getValue());
		}

		return moreRepeatedWords;
	}

	private static List<Entry<String, Integer>> getWordFrequencyOf(String text) {
		Map<String, Integer> wordCount = new LinkedHashMap<>();
		String[] words = text.split("[\\s/:,.?!]+");

		for (String word : words) {
			word = word.toLowerCase(); // Convert to lowercase to consider words regardless of capitalization
			if (wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}

		List<Map.Entry<String, Integer>> sortedWordList = new ArrayList<>(wordCount.entrySet());
		sortedWordList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

		String wordsHistogram = "";

		for (Map.Entry<String, Integer> entry : sortedWordList) {
			String word = entry.getKey();
			int frequency = entry.getValue();
			wordsHistogram += String.format("%-" + 15 + "s", word) + " : " +
				String.format("%" + 6 + "s",frequency) + " " +
				new String(new char[frequency]).replace("\0", "*") + "\n";
		}

		recordReportData().withTitle("Total words:")
			.andContents(String.valueOf(sortedWordList.stream().mapToInt(Entry::getValue).sum()));
		recordReportData().withTitle("Total characters:")
			.andContents(String.valueOf(wordCount.keySet().stream().mapToInt(String::length).sum()));
		recordReportData().withTitle("Word histogram:")
			.andContents(wordsHistogram);

		return sortedWordList;
	}

	private static String formatCounter(String counter) {
		if (counter.length() > 3) {
			StringBuilder sb = new StringBuilder(counter);
			sb.insert(counter.length()-3,",");
			counter = sb.toString();
		}
		return counter;
	}
}
