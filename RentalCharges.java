import java.math.BigDecimal;

/**
 * @author katherinesmall
 *
 *This class creates a RentalCharges object with instance variables charge, weekday, weekend, and holiday
 */
public class RentalCharges {
	
	//Instance variables: dailyCharge is the dailyCharge for the tool, weekday is whether there is a weekday charge or not, 
	//weekend is whether there is a weekend charge or not, and holiday is whether there is a holiday charge or not
	private BigDecimal dailyCharge;
	private boolean weekday;
	private boolean weekend;
	private boolean holiday;
	
	//This is the constructor of the RentalCharges class
	public RentalCharges(BigDecimal charge, boolean weekday, boolean weekend, boolean holiday) {
		super();
		this.dailyCharge = charge;
		this.weekday = weekday;
		this.weekend = weekend;
		this.holiday = holiday;
	}
	
	//returns the dailyCharge for the RentalCharges
	public BigDecimal getCharge() {
		return dailyCharge;
	}
	
	//sets the dailyCharge for the RentalCharges
	public void setCharge(BigDecimal charge) {
		this.dailyCharge = charge;
	}
	
	//gets the boolean value for RentalCharges if there is a weekday charge or not
	public boolean isWeekday() {
		return weekday;
	}
	
	//sets the boolean value for RentalCharges if there is a weekday charge or not
	public void setWeekday(boolean weekday) {
		this.weekday = weekday;
	}
	
	//gets the boolean value for RentalCharges if there is a weekend charge or not
	public boolean isWeekend() {
		return weekend;
	}
	
	//sets the boolean value for RentalCharges if there is a weekend charge or not
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	
	//gets the boolean value for RentalCharges if there is a holiday charge or not
	public boolean isHoliday() {
		return holiday;
	}
	
	//sets the boolean value for RentalCharges if there is a holiday charge or not
	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}

	//this method prints all of the RentalCharges variables
	@Override
	public String toString() {
		return "RentalCharges [charge=" + dailyCharge + ", weekday=" + weekday + ", weekend=" + weekend + ", holiday="
				+ holiday + "]";
	}
	
	

}
