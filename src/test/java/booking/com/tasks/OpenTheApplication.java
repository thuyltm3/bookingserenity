package booking.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import booking.com.ui.BookingPage;

public class OpenTheApplication implements Task {

    BookingPage bookingPage;

    @Step("Open the page booking.com")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(bookingPage)
        );
    }
}
