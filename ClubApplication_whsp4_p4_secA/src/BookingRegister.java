import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRegister {

	/**
	 * 18)	Create a class BookingRegister and give it a private 
	 * HashMap attribute. Make sure the table is instantiated when
	 *  we create the BookingRegister.
	 * 
	 */
	private Map<Facility, List<Booking>> facilityToBookingListMap;
	
	public BookingRegister() {
		facilityToBookingListMap = new HashMap<>();
	}
	
	/**
	 * 19)	Add a method addBooking() to class BookingRegister. This method will 
	 * accept reference to the Member and Facility objects, 
	 * and to the start and end LocalDateTime objects. 
	 * 
•	
•	
	 * @throws BadBookingException 
	 */
	
	public void addBooking(Member member, Facility facility, LocalDateTime start, 
			LocalDateTime end) throws BadBookingException {
		// The addBooking() method should
		// instantiate a Booking object
		Booking booking = new Booking(member, facility, start, end);
		
		// retrieve the ArrayList corresponding to the given Facility from the HashMap, 
		//using the Facility object as the key
		List<Booking> bookingList = facilityToBookingListMap.get(facility);
		
		// if no ArrayList object is retrieved (i.e. this is the first booking for
		// the Facility), a new empty ArrayList object must be created,
		//	and put into the table, using the Facility object as the key
		if (bookingList == null) {
			bookingList = new ArrayList<>();
			facilityToBookingListMap.put(facility, bookingList);
		}
		
		// go through all the existing Booking objects in the ArrayList, 
		// and make sure they do not overlap with the new booking; 
		// if there is an overlap, the addBooking() method must throw a BadBookingException
		for (Booking existedBooking : bookingList) {
			if (existedBooking.overlaps(booking)) {
				throw new BadBookingException("Adding an overlaped booking");
			}
		}
		
		// if there are no overlaps, the new Booking object is added to the ArrayList.
		bookingList.add(booking);
	}
	
	
}
