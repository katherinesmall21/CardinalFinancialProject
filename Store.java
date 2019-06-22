import java.math.BigDecimal;
import java.util.HashMap;


/**
 * @author katherinesmall
 * 
 * This class creates a Store object which is a hashmap of tools with the key being the tool code to easily lookup the tools by their 
 * code. It also sets sets all the rentalAgreement variables and does all of the calculations for holidays, weekdays and weekends, 
 * discount, final charge
 */

public class Store {

	private HashMap<String,Tool> tools;
	
	//this is the constructor of the Store class
	public Store() {
		super();
		tools = new HashMap<String,Tool>();
		populateData();
	}
	
	//this returns the entire HashMap that contains all of the Too objects and their codes
	public HashMap<String,Tool> getTools() {
		return tools;
	}
	
	
	public void setTools(HashMap<String,Tool> tools) {
		this.tools = tools;
	}

	
	
	//for now just populating some of the test data - would normally use a database for this
	public void populateData()
	{
		RentalCharges ladderCharge = new RentalCharges(new BigDecimal(1.99), true, true, false);
		Tool tool1 = new Tool("Ladder", "Werner", ladderCharge);
		tools.put("LADW",tool1);
		
		RentalCharges chainsawCharge = new RentalCharges(new BigDecimal(1.49), true, false, true);
		Tool tool2 = new Tool("Chainsaw", "Stihl", chainsawCharge);
		tools.put("CHNS", tool2);
		
		RentalCharges jackhammerCharge = new RentalCharges(new BigDecimal(2.99), true, false, false);
		Tool tool3 = new Tool("Jackhammer", "Ridgid", jackhammerCharge);
		tools.put("JAKR", tool3);
		
		Tool tool4 = new Tool("Jackhammer", "DeWalt", jackhammerCharge);
		tools.put("JAKD", tool4);
	}
}
