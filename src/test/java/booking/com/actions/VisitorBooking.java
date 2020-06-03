package booking.com.actions;

import booking.com.ui.BookingPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisitorBooking implements Interaction {

    private int numberOfAdult;
    private int numberOfChildren;
    private int numberOfRoom;

    public VisitorBooking(int numberOfAdult, int numberOfChildren, int numberOfRoom){
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
        this.numberOfRoom = numberOfRoom;
    }

    public static VisitorBookingBuilder forAdults(int numberOfAdult){
        return new VisitorBookingBuilder(numberOfAdult);
    }

    @Step("{0} books #numberOfRoom Rooms for #numberOfAdult Adults and #numberOfChildren Children")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingPageElements.VISITED_CUSTOMER_FIELD.resolveFor(actor).click();

        int numberOfAdultDisplay = Integer.parseInt(BookingPageElements.NUMBER_OF_ADULT.resolveFor(actor).getText());
        int numberOfChildDisplay = Integer.parseInt(BookingPageElements.NUMBER_OF_CHILDREN.resolveFor(actor).getText());
        int numberOfRoomDisplay = Integer.parseInt(BookingPageElements.NUMBER_OF_ROOM.resolveFor(actor).getText());

        // for adult
        if(numberOfAdult > numberOfAdultDisplay){
            for(int i = numberOfAdultDisplay; i < numberOfAdult; i++){
                BookingPageElements.PLUS_ADULT.resolveFor(actor).click();
            }
        } else if(numberOfAdult < numberOfAdultDisplay){
            for(int i = numberOfAdult; i < numberOfAdultDisplay; i++){
                BookingPageElements.MINUS_ADULT.resolveFor(actor).click();
            }
        }

        // for children
        if(numberOfChildren > numberOfChildDisplay){
            for(int i = numberOfChildDisplay; i < numberOfChildren; i++){
                BookingPageElements.PLUS_CHILDREN.resolveFor(actor).click();
            }
        } else if(numberOfChildren < numberOfChildDisplay){
            for(int i = numberOfChildren; i < numberOfChildDisplay; i++){
                BookingPageElements.MINUS_CHILDREN.resolveFor(actor).click();
            }
        }

        // for room
        if(numberOfRoom > numberOfRoomDisplay){
            for(int i = numberOfRoomDisplay; i < numberOfRoom; i++){
                BookingPageElements.PLUS_ROOM.resolveFor(actor).click();
            }
        } else if(numberOfRoom < numberOfRoomDisplay){
            for(int i = numberOfRoom; i < numberOfRoomDisplay; i++){
                BookingPageElements.MINUS_ROOM.resolveFor(actor).click();
            }
        }

        // finish choose visitor
        BookingPageElements.VISITED_CUSTOMER_FIELD.resolveFor(actor).click();
        BookingPageElements.VISITED_CUSTOMER_FIELD.resolveFor(actor).click();
    }

    public static class VisitorBookingBuilder {
        private int numberOfAdult;
        private int numberOfChildren;
        private int numberOfRoom;

        public VisitorBookingBuilder(int numberOfAdult){
            this.numberOfAdult = numberOfAdult;
        }

        public VisitorBookingBuilder andChild(int numberOfChildren){
            this.numberOfChildren = numberOfChildren;
            return this;
        }

        public Interaction andRoom(int numberOfRoom){
            return instrumented(VisitorBooking.class,
                    numberOfAdult,
                    numberOfChildren,
                    numberOfRoom);
        }
    }
}
