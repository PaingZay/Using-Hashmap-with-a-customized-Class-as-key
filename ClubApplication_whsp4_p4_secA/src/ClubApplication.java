import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClubApplication {

   public static void main(String args[]) {

	  DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
      Club club = new Club();

      // Test class Member
      Member member1, member2, member3, member4, member5;

      member1 = club.addMember("Einstein", "Albert", null);
      member2 = club.addMember("Picasso", "Pablo", "Ruiz");
      member3 = club.addMember("Webber", "Andrew", "Lloyd");
      member4 = club.addMember("Baggio", "Roberto", null);
      member5 = club.addMember("Raffles", "Stamford", null);

      // Test class Facility
      Facility lab = club.addFacility("Lab", "Einstein's Experiment Area");
      Facility studio = club.addFacility("Studio", "Picasso's Work Place");
      club.addFacility("Room1", "Conference Room on Level 2");
      club.addFacility("Room2", "Meeting Room on Level 3");
      club.show();

      // Test class Booking
      LocalDateTime date1 = LocalDateTime.parse("1-Aug-2007 09:00", df);
      LocalDateTime date5 = LocalDateTime.parse("5-Aug-2007 09:00", df);
      LocalDateTime date6 = LocalDateTime.parse("6-Aug-2007 09:00", df);
      LocalDateTime date8 = LocalDateTime.parse("8-Aug-2007 09:00", df);
      LocalDateTime date10 = LocalDateTime.parse("10-Aug-2007 09:00", df);
      
      BookingRegister register = new BookingRegister();
      try {
		register.addBooking(member1, lab, date1, date6);
		register.addBooking(member2, studio, date1, date10);
		register.addBooking(member3, lab, date8, date10);
		register.addBooking(member4, lab, date5, date10);
		
	} catch (BadBookingException e) {
		System.err.println(e.getMessage());
	}
      
      

   }

}
