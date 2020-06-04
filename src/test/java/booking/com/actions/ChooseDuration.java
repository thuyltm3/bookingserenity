package booking.com.actions;

import net.serenitybdd.screenplay.Interaction;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseDuration {

    public static Interaction with(String startDate, String endDate) {
        return instrumented(ChooseDate.class, startDate, endDate);
    }
}
