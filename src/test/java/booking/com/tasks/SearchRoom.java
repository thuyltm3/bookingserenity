package booking.com.tasks;

import booking.com.actions.ChooseDestination;
import booking.com.actions.ChooseDuration;
import booking.com.actions.VisitorBooking;
import booking.com.ui.BookingPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SearchRoom implements Task {

    private final String destination;
    private final String startDate;
    private final String endDate;
    private final int numberOfAdult;
    private final int numberOfChildren;
    private final int numberOfRoom;

    public SearchRoom(String destination,
                         String startDate,
                         String endDate,
                         int numberOfAdult,
                         int numberOfChildren,
                         int numberOfRoom) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
        this.numberOfRoom = numberOfRoom;
    }

    public static SearchRoomBuilder withDestination(String destination){
        return new SearchRoomBuilder(destination);
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ChooseDestination.with(this.destination),
                ChooseDuration.with(this.startDate, this.endDate),
                VisitorBooking.forAdults(this.numberOfAdult)
                        .andChild(this.numberOfChildren)
                        .andRoom(this.numberOfRoom),
                Click.on(BookingPageElements.BTN_SEARCH)
        );
    }

    public static class SearchRoomBuilder{
        private final String destination;
        private String startDate;
        private String endDate;
        private int numberOfAdult;
        private int numberOfChildren;
        private int numberOfRoom;

        public SearchRoomBuilder (String destination){
            this.destination = destination;
        }

        public SearchRoomBuilder andFrom(String startDate){
            this.startDate = startDate;
            return this;
        }

        public SearchRoomBuilder andTo(String endDate){
            this.endDate = endDate;
            return this;
        }

        public SearchRoomBuilder forAdult(int numberOfAdult){
            this.numberOfAdult = numberOfAdult;
            return this;
        }

        public SearchRoomBuilder andChildren(int numberOfChildren){
            this.numberOfChildren = numberOfChildren;
            return this;
        }

        public SearchRoomBuilder andRoom(int numberOfRoom){
            this.numberOfRoom = numberOfRoom;
            return this;
        }

        public SearchRoom build(){
            return new SearchRoom(this.destination,
                    this.startDate,
                    this.endDate,
                    this.numberOfAdult,
                    this.numberOfChildren,
                    this.numberOfRoom);
        }
    }
}
