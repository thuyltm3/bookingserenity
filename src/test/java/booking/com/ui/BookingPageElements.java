package booking.com.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPageElements {
    public static Target DESTINATION_FIELD = Target.the("Destination filed")
            .located(By.cssSelector("input[class*=destination__input]"));

    public static Target FIRST_ITEM = Target.the("choose first item on the suggestion box ")
            .located(By.cssSelector("li.sb-autocomplete__item-with_photo:nth-child(1)"));

    public static Target PERIOD_FIELD = Target.the("input booking time from-to")
            .located(By.cssSelector("div[class=xp__dates-inner]"));

    public static Target VISITED_CUSTOMER_FIELD = Target.the("input number visitor")
            .located(By.cssSelector("div[class$=xp__guests]"));

    public static Target BTN_SEARCH = Target.the("button search")
            .located(By.cssSelector("div[class=xp__button]"));

    public static Target NUMBER_OF_ADULT = Target.the("get number of adult")
            .located(By.cssSelector("div.sb-group__field:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(3)"));

    public static Target PLUS_ADULT = Target.the("increase number of adult")
            .located(By.cssSelector("div.sb-group__field:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(4)"));

    public static Target MINUS_ADULT = Target.the("decrease number of adult")
            .located(By.cssSelector("div.sb-group__field:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)"));

    public static Target NUMBER_OF_CHILDREN = Target.the("get number of children")
            .located(By.cssSelector("div.sb-group__field:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(3)"));

    public static Target PLUS_CHILDREN = Target.the("increase number of children")
            .located(By.cssSelector("div.sb-group__field:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(4)"));

    public static Target MINUS_CHILDREN = Target.the("decrease number of children")
            .located(By.cssSelector("div.sb-group__field:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)"));

    public static Target NUMBER_OF_ROOM = Target.the("get number of room")
            .located(By.cssSelector("div.sb-group__field:nth-child(3) > div:nth-child(1) > div:nth-child(2) > span:nth-child(3)"));

    public static Target PLUS_ROOM = Target.the("increase number of room")
            .located(By.cssSelector("div.sb-group__field:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(4)"));

    public static Target MINUS_ROOM = Target.the("decrease number of room")
            .located(By.cssSelector("div.sb-group__field:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)"));

    public static Target HEADER_RESULT = Target.the("total room display")
            .located(By.cssSelector("div[class=sr_header--title] h1"));
}
