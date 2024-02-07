package textAnalyzer.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static textAnalyzer.count.CountForm.CHARACTERS_COUNT_FIELD;
import static textAnalyzer.util.AnalyzeText.countCharactersOf;
import static textAnalyzer.util.AnalyzeText.countWordsOf;
import static textAnalyzer.util.AnalyzeText.countSentencesOf;
import static textAnalyzer.util.AnalyzeText.getMostRepeatedWordsOf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import textAnalyzer.navigation.NavigateTo;
import textAnalyzer.count.CountTextElements;
import textAnalyzer.questions.TheWebPage;
import textAnalyzer.util.ReadFile;

public class CountStepDefinitions {

    @Given("{actor} wants to know the features of a text")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(
            NavigateTo.theSearchHomePage());
    }

    @When("{actor} enters the text to analyze")
    public void searchesFor(Actor actor) {
        actor.attemptsTo(
            CountTextElements.about(ReadFile.getInputText()),
            WaitUntil.the(CHARACTERS_COUNT_FIELD, isVisible())
        );
    }

    @Then("{actor} should see the number of characters")
    public void should_see_the_number_of_characters(Actor actor) {
            actor.should(seeThat(TheWebPage.showsCharactersCounter(),
                equalTo(countCharactersOf(ReadFile.getInputText()))));
    }

    @And("{actor} should see the number of words")
    public void should_see_the_number_of_words(Actor actor) {
        actor.should(seeThat(TheWebPage.showsWordsCounter(),
            equalTo(countWordsOf(ReadFile.getInputText()))));
    }

    @And("{actor} should see the number of sentences")
    public void should_see_the_number_of_sentences(Actor actor) {
        actor.should(seeThat(TheWebPage.showsSentencesCounter(),
            equalTo(countSentencesOf(ReadFile.getInputText()))));
    }

    @And("{actor} should see the {int} most repeated words")
    public void should_see_the_n_most_repeated_words(Actor actor, Integer wordsNumber) {
        actor.should(
            seeThat(TheWebPage.showsTheMostRepeatedWords(wordsNumber),
                equalTo(getMostRepeatedWordsOf(wordsNumber, ReadFile.getInputText())))
            );
    }
}
