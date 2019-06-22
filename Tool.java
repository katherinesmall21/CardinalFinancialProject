import java.math.BigDecimal;


/**
 * @author katherinesmall
 * 
 *This class creates a Tool object with instance variables type, brand, and dailyCharge
 */

public class Tool {
	
	
	//Instance variables: type is the type of tool, brand is the brand of tool, dailyCharge is the dailyCharge of the tool
	private String type;
	private String brand;
	private RentalCharges rentalCharges;
	
	
	//This is the constructor of the Tool class
	public Tool(String type, String brand, RentalCharges dailyCharge) {
		super();
		this.type = type;
		this.brand = brand;
		this.rentalCharges = dailyCharge;
	}
	
	//returns the type of tool
	public String getType() {
		return type;
	}
	
	//sets the value for type of tool
	public void setType(String type) {
		this.type = type;
	}
	
	//returns the brand of tool
	public String getBrand() {
		return brand;
	}
	
	//sets the value for brand of tool
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	//this method prints all of the tool variables
	@Override
	public String toString() {
		return "Tool [type=" + type + ", brand=" + brand + "]";
	}
	
	//gets the boolean value for tool if there is a holiday charge or not
	public boolean isHolidayCharge()
	{
		return rentalCharges.isHoliday();
	}
	
	//gets the boolean value for tool if there is a weekend charge or not
	public boolean isWeekendCharge()
	{
		return rentalCharges.isWeekend();
	}
	
	//gets the value for daily charge of tool
	public BigDecimal getDailyRentalCharge()
	{
		return rentalCharges.getCharge();
	}
	

}
