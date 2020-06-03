package booking.com.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChooseDate implements Interaction {

    private LocalDateTime dateTime;
    private String dateString;
    private String status;

    public ChooseDate(LocalDateTime dateTime, String status){
        this.dateTime = dateTime;
        this.status = status;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateString = this.dateTime.format(formatter);
    }

    @Step("{0} choose #status date is #dateString")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Target DATE_TARGET = Target.the("date")
                .located(By.cssSelector("td[data-date=\"" + this.dateString + "\"]"));

        DATE_TARGET.resolveFor(actor).click();
    }
}
