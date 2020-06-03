package booking.com.questions;

import booking.com.ui.BookingPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchQuestion implements Question<Integer> {

    public static Question<Integer> totalRoomDisplay(){
        return new SearchQuestion();
    }

    @Step("{0} see #numberOfRoomMatch rooms matched with destination in the list of result")
    @Override
    public Integer answeredBy(Actor actor) {
        String headerResult = BookingPageElements.HEADER_RESULT.resolveFor(actor).getText();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(headerResult);
        matcher.find();

        return Integer.parseInt(matcher.group());
    }
}
