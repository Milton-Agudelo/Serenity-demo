package stepdefinitions.count_elements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static screenplay.user_interfaces.CountTextElementsPage.CHARACTERS_COUNT_FIELD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.questions.TheWebPage;
import screenplay.tasks.EnterText;
import screenplay.tasks.NavigateTo;
import utils.GetInputText;
import utils.Count;

public class CountElementsStepDefinitions {

    @Given("{actor} wants to know the number of elements of a text")
    public void wants_to_know_the_number_of_elements_of_a_text(Actor actor) {
        actor.wasAbleTo(
            NavigateTo.theApplicationHomePage());
    }

    @When("{actor} enters the text to analyze")
    public void enters_the_text_to_analyze(Actor actor) {
        actor.attemptsTo(
            EnterText.inTheTextInputBox(GetInputText.fromFile()),
            WaitUntil.the(CHARACTERS_COUNT_FIELD, isVisible())
        );
    }

    @Then("{actor} should see the number of characters")
    public void should_see_the_number_of_characters(Actor actor) {
            actor.should(seeThat(TheWebPage.showsCharactersCounter(),
                equalTo(Count.charactersIn(GetInputText.fromFile()))));
    }

    @And("{actor} should see the number of words")
    public void should_see_the_number_of_words(Actor actor) {
        actor.should(seeThat(TheWebPage.showsWordsCounter(),
            equalTo(Count.wordsIn(GetInputText.fromFile()))));
    }

    @And("{actor} should see the number of sentences")
    public void should_see_the_number_of_sentences(Actor actor) {
        actor.should(seeThat(TheWebPage.showsSentencesCounter(),
            equalTo(Count.sentencesIn(GetInputText.fromFile()))));
    }

    @And("{actor} should see the {int} most repeated words")
    public void should_see_the_most_repeated_words(Actor actor, Integer wordsNumber) {
        actor.should(
            seeThat(TheWebPage.showsTheMostRepeatedWords(wordsNumber),
                equalTo(Count.mostRepeatedWordsIn(wordsNumber, GetInputText.fromFile())))
            );
    }

}
