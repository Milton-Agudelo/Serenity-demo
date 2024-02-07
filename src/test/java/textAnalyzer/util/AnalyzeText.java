package textAnalyzer.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalyzeText {

	public static String countCharactersOf(String text) {
		return String.valueOf(text.replace("\n", "").length());
	}

	public static String countWordsOf(String text) {
		String[] words = text.split("[\\s/:]+");
		return String.valueOf(words.length);
	}

	public static String countSentencesOf(String text) {
		String[] sentences = text.split("[.!?]+");
		return String.valueOf(sentences.length);
	}

	public static Map<String, Integer> getMostRepeatedWordsOf(Integer wordsNumber, String text) {
		Map<String, Integer> wordCount = new LinkedHashMap<>();
		String[] words = text.split("[\\s/:]+");

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

		Map<String, Integer> moreRepeatedWords = new LinkedHashMap<>();
		for (int i = 0; i < Math.min(wordsNumber, sortedWordList.size()); i++) {
			moreRepeatedWords.put(sortedWordList.get(i).getKey().trim(), sortedWordList.get(i).getValue());
		}

		return moreRepeatedWords;
	}
}
