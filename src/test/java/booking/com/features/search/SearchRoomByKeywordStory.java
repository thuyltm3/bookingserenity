package booking.com.features.search;

import booking.com.questions.SearchQuestion;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import booking.com.tasks.OpenTheApplication;
import booking.com.tasks.SearchRoom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class SearchRoomByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void booking_2_rooms_for_4_adult_and_3_children_for_3_days_at_Phu_Quoc() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime startDateTime = today.plusDays(7);
        LocalDateTime endDateTime = today.plusDays(10);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = startDateTime.format(formatter);
        String endDate = endDateTime.format(formatter);

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                SearchRoom.withDestination("Phú Quốc")
                        .andFrom(startDate)
                        .andTo(endDate)
                        .forAdult(4)
                        .andChildren(3)
                        .andRoom(2)
                        .build()
        );

        then(anna).should((seeThat(SearchQuestion.totalRoomDisplay(), equalTo(278))));
    }
}