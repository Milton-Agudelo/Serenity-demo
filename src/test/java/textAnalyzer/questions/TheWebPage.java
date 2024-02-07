package textAnalyzer.questions;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static textAnalyzer.count.CountForm.CHARACTERS_COUNT_FIELD;
import static textAnalyzer.count.CountForm.SENTENCES_COUNT_FIELD;
import static textAnalyzer.count.CountForm.WORDS_COUNT_FIELD;
import static textAnalyzer.count.CountForm.WORDS_DENSITY_FIELD;

@NoArgsConstructor
public class TheWebPage {

	public static Question<String> showsCharactersCounter() {
		return Question.about("The characters of the text").answeredBy((actor) -> {
			return actor.asksFor(Text.of(CHARACTERS_COUNT_FIELD).asString());
		});
	}

	public static Question<String> showsWordsCounter() {
		return Question.about("The words of the text").answeredBy((actor) -> {
			return actor.asksFor(Text.of(WORDS_COUNT_FIELD).asString());
		});
	}

	public static Question<String> showsSentencesCounter() {
		return Question.about("The sentences of the text").answeredBy((actor) -> {
			return actor.asksFor(Text.of(SENTENCES_COUNT_FIELD).asString());
		});
	}

	public static Question<Map<String, Integer>> showsTheMostRepeatedWords(Integer wordsNumber) {
		return Question.about("The most repeated words of the text").answeredBy((actor) -> {
			String[] wordDensity = actor.asksFor(Text.of(WORDS_DENSITY_FIELD).asString())
									.split("\n", wordsNumber*2+1);
			Map<String, Integer> moreRepeatedWords = new LinkedHashMap<>();

			for (int i = 0; i < Math.min(wordsNumber*2, wordDensity.length); i+=2) {
				moreRepeatedWords.put(wordDensity[i+1].trim(),
					Integer.valueOf(wordDensity[i].substring(0,wordDensity[i].indexOf(" "))));
			}

			return moreRepeatedWords;
		});
	}
}
