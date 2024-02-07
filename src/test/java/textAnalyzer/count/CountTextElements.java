package textAnalyzer.count;

import static textAnalyzer.count.CountForm.TEXT_INPUT_FIELD;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class CountTextElements {
    public static Performable about(String inputText) {
        return Task.where("{0} counting for '" + inputText + "'",
                Enter.theValue(inputText)
                        .into(TEXT_INPUT_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }
}
