package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.user_interfaces.ApplicationHomePage;


public class NavigateTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.browserOn().the(ApplicationHomePage.class)
        );
    }

    public static NavigateTo theApplicationHomePage() { return new NavigateTo();}


}
