package booking.com.actions;

import booking.com.ui.BookingPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Choose implements Interaction {

    private String destination;

    public Choose(String destination){
        this.destination = destination;
    }

    @Step("{0} enter #destination into textbox search & choose #destination on the suggestion box")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.destination).into(BookingPageElements.DESTINATION_FIELD),
                Click.on(BookingPageElements.FIRST_ITEM)
        );
//        BookingPageElements.FIRST_ITEM.resolveFor(actor).click();
    }

    public static Interaction withDestination(String destination) {
        return instrumented(Choose.class, destination);
    }
}
