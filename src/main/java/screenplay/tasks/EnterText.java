package screenplay.tasks;

import static screenplay.user_interfaces.CountTextElementsPage.TEXT_INPUT_FIELD;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class EnterText implements Task {

	private static String inputText;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Enter.theValue(inputText).into(TEXT_INPUT_FIELD)
				.thenHit(Keys.ENTER)
		);
	}

	public static EnterText inTheTextInputBox(String inputText) {
		EnterText.inputText = inputText;
		return new EnterText();
	}

}