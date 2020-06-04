package booking.com.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChooseDate implements Interaction {

    private String startDate;
    private String endDate;

    public ChooseDate(String startDate, String  endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Step("{0} books a room from #startDate to #endDate")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Target START_DATE = Target.the("date")
                .located(By.cssSelector("td[data-date=\"" + this.startDate + "\"]"));
        START_DATE.resolveFor(actor).click();

        Target END_DATE = Target.the("date")
                .located(By.cssSelector("td[data-date=\"" + this.endDate + "\"]"));
        END_DATE.resolveFor(actor).click();
    }
}
