package booking.com.actions;

import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseDuration {

    public static Interaction withStartDate(LocalDateTime startDate) {
        return instrumented(ChooseDate.class, startDate, "start");
    }

    public static Interaction withEndDate(LocalDateTime endDate) {
        return instrumented(ChooseDate.class, endDate, "end");
    }
}
