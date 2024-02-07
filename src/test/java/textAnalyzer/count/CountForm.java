package textAnalyzer.count;

import net.serenitybdd.screenplay.targets.Target;

public class CountForm {
    public static Target TEXT_INPUT_FIELD = Target.the("Text input field").locatedBy("#box");

    public static Target CHARACTERS_COUNT_FIELD = Target.the("Character count field").locatedBy("#character_count");

    public static Target WORDS_COUNT_FIELD = Target.the("Character count field").locatedBy("#word_count");

    public static Target SENTENCES_COUNT_FIELD = Target.the("Sentences count field").locatedBy("#sentence_count");
    public static Target WORDS_DENSITY_FIELD = Target.the("Words density").locatedBy("#kwd-accordion-data");

}
