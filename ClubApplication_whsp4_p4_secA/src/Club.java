import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Club {

	private int currentNumber = 1;
    private ArrayList<Member> memberList = new ArrayList<>();
    private HashMap<String, Facility> nameToFacilityMap = new HashMap<>();

    public Member addMember (String surname, String firstName,
						String secondName) {
        Member m = new Member (surname, firstName, secondName,
        		currentNumber);
        memberList.add(m);
        currentNumber++;
        
        return m;
    }
    
    public void showMembers () {
        for (Member member: memberList) {
        	member.show();
        }
    }

    public Member findMember (int memberNumber) {
    	for (Member member: memberList) {
    		if (member.getMemberNumber() == memberNumber) {
    			return member;
    		}
    	}
    	
    	return null;
    }
    
    public void removeMember (int memberNumber) {
        Member memberToRemove = findMember(memberNumber);
    	
        if (memberToRemove != null) {
        	memberList.remove(memberToRemove);
        }
    }
    
    
    public Facility getFacility(String name) {
    	return nameToFacilityMap.get(name);
    }
    
    public Facility addFacility(String name, String description) {
    	Facility facility = new Facility(name, description);
    	
    	nameToFacilityMap.put(name, facility);
    	
    	return facility;
    }
    
    public void removeFacility(String name) {
    	nameToFacilityMap.remove(name);
    }
    
    
    public Collection<Facility> getFacilities() {
    	return nameToFacilityMap.values();
    }
    
    public void showFacilities() {
    	Collection<Facility> facilities = getFacilities();
    	
    	for (Facility facility: facilities) {
    		facility.show();
    	}
    }
    
    public void show () {
        System.out.println ("Current Members:");
        showMembers ();
        System.out.println ();
        System.out.println ("Facilities:");
        showFacilities ();
    }
    

}
