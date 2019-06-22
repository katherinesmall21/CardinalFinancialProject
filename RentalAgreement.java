import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * @author katherinesmall
 *
 *This class creates a RentalAgreement object with instance variables type is the type of tool, brand is the brand of tool, 
 *dailyRentalCharge is the daily rental charge of the tool, code is the code of the tool, rentalDays is how many days the tool is rented,
 *checkoutDate is the day the tool is checked out, dueDate is the day the tool is due, chargeDays are the number of days to charge for
 *the tool from the day after the checkout day to and including the due date, discount is the percent specified at checkout,
 *discountAmount is the discount in decimal form, finalCharge is the final amount after all computations to charge for the full rental
 */

public class RentalAgreement {

	private String type;
	private String code;
	private String brand;
	private int rentalDays;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BigDecimal dailyRentalCharge;
	private int chargeDays;
	private int discount;
	private BigDecimal discountAmount;
	private BigDecimal finalCharge;
	
	//This is the constructor of the RentalAgreement class
	public RentalAgreement(String code, int rentalDays, LocalDate checkoutDate, int discount) {
		super();
		this.code = code;
		this.rentalDays = rentalDays;
		this.checkoutDate = checkoutDate;
		this.discount = discount;
	}

	//returns the type for the RentalAgreement
	public String getType() {
		return type;
	}

	//sets the type for the RentalAgreement
	public void setType(String type) {
		this.type = type;
	}

	//returns the code for the RentalAgreement
	public String getCode() {
		return code;
	}

	//sets the code for the RentalAgreement
	public void setCode(String code) {
		this.code = code;
	}

	//returns the brand for the RentalAgreement
	public String getBrand() {
		return brand;
	}

	//sets the brand for the RentalAgreement
	public void setBrand(String brand) {
		this.brand = brand;
	}

	//returns the rentalDays for the RentalAgreement
	public int getRentalDays() {
		return rentalDays;
	}

	//sets the rentalDays for the RentalAgreement
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	//returns the checkoutDate for the RentalAgreement
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	//sets the checkoutDate for the RentalAgreement
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	//returns the dueDate for the RentalAgreement
	public LocalDate getDueDate() {
		return dueDate;
	}

	//sets the dueDate for the RentalAgreement
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	//returns the dailyRentalCharge for the RentalAgreement
	public BigDecimal getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	//sets the dailyRentalCharge for the RentalAgreement
	public void setDailyRentalCharge(BigDecimal rentalCharge) {
		this.dailyRentalCharge = rentalCharge;
	}

	//returns the chargeDays for the RentalAgreement
	public int getChargeDays() {
		return chargeDays;
	}

	//sets the chargeDays for the RentalAgreement
	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}

	//returns the discount for the RentalAgreement
	public int getDiscount() {
		return discount;
	}

	//sets the discount for the RentalAgreement
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	//returns the discountAmount for the RentalAgreement
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	//sets the discountAmount for the RentalAgreement
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	//returns the finalCharge for the RentalAgreement
	public BigDecimal getFinalCharge() {
		return finalCharge;
	}

	//sets the finalCharge for the RentalAgreement
	public void setFinalCharge(BigDecimal finalCharge) {
		this.finalCharge = finalCharge;
	}

	//this method prints all of the RentalAgreement variables
	@Override
	public String toString() 
	{
		return "Rental Agreement: [type=" + type + ", code=" + code + ", brand=" + brand + ", rentalDays=" + rentalDays
				+ ", checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", dailyRentalCharge=" + dailyRentalCharge.setScale(2, RoundingMode.DOWN)
				+ ", chargeDays=" + chargeDays + ", discount=" + discount + ", discountAmount=" + discountAmount.setScale(2, RoundingMode.DOWN)
				+ ", finalCharge=" + finalCharge + "]";
	}
	
	
}
