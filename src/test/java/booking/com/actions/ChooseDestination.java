package booking.com.actions;

import booking.com.ui.BookingPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseDestination implements Interaction {

    private final String destination;

    public ChooseDestination(String destination){
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

    public static Interaction with(String destination) {
        return instrumented(ChooseDestination.class, destination);
    }
}
