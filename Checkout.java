import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * @author katherinesmall
 *
 *This class creates a Checkout object with instance variable tools which is a hashmap of tools to easily lookup the tools by their 
 * code. It also sets sets all the rentalAgreement variables and does all of the calculations for holidays, weekdays and weekends, 
 * discount, final charge
 */

public class Checkout {

	private HashMap<String,Tool> tools;

	//This is the constructor of the Checkout class which creates the store object and initializes the hashmap
	//Using a hashmap for the test data - in actual implementation database would probably be used
	//instructions seemed to want only java
	public Checkout()
	{
		Store homeDepot = new Store();
		tools = homeDepot.getTools();
	}
	

	/*This is the method that simulates the rental of a tool. You give the method the tool code, the checkout date, the number of days 
	 * it is rented, and the discount. It calls all the necessary methods to calculate discount, chargeDays, and finalCharge and sets 
	 * the necessary values for rentalAgreement.
	 */
	
	public BigDecimal rentTool(String code, LocalDate checkout, int days, int discount)
	{
		//Makes sure that the tool is being rented for one or more days if not, throws exception
		if(days < 1)
		{
			throw new IllegalArgumentException("Days needs to be greater than one.");
		}
		
		//Makes sure the discount is in normal range
		if(discount < 0 || discount > 100)
		{
			throw new IllegalArgumentException("Percent discount is not in the range zero to one hundred.");
		}
		
		//creates the RentalAgreement object and initializes the finalCharge to zero
		RentalAgreement rA = new RentalAgreement(code, days, checkout, discount);
		Tool currentTool; 
		BigDecimal finalCharge = new BigDecimal(0);

		//gets the current tool from the hashmap using its code and sets the brand, type, isHolidayCharge, isWeekendCharge
		currentTool = tools.get(code);
		rA.setBrand(currentTool.getBrand());
		rA.setType(currentTool.getType());
		boolean isHolidayCharge = currentTool.isHolidayCharge();
		boolean isWeekendCharge = currentTool.isWeekendCharge();
		
		//calls the method to calculate and sets the due date passing it the checkout date and number of days rented
		LocalDate dueDate = calculateDueDate(checkout, days);
		rA.setDueDate(dueDate);
		
		//gets and sets the dailyRentalCharge and passes it to calculate the rentalCharge before the discount 
		BigDecimal dailyRentalCharge = currentTool.getDailyRentalCharge();
		rA.setDailyRentalCharge(currentTool.getDailyRentalCharge());
		BigDecimal rentalCharge = calculateRentalCharge(dailyRentalCharge, checkout, days, dueDate, isHolidayCharge, isWeekendCharge, rA);
		
		//calls the method to calculate the discount passing it the prediscounted rental charge and the discount whole number
		BigDecimal finalDiscount = calculateDiscount(rentalCharge, discount);
		rA.setDiscountAmount(finalDiscount);
		
		//uses the final discount to calculate the final charge and sets the finalCharge
		finalCharge = rentalCharge.subtract(finalDiscount);
		finalCharge = finalCharge.setScale(2, RoundingMode.DOWN);
		rA.setFinalCharge(finalCharge);
		
		//Prints the entire rental agreement and returns the finalCharge
		System.out.println(rA.toString());
		return finalCharge;
	}

	//Calculates the rentalCharge using the dailyRentalCharge, the checkoutDate, the days, and the dueDate
	public BigDecimal calculateRentalCharge(BigDecimal dailyRentalCharge, LocalDate checkoutDate, int days, LocalDate dueDate, 
			boolean isHolidayCharge, boolean isWeekendCharge, RentalAgreement rA)
	{
		int chargeDays = days;
		checkoutDate = checkoutDate.plusDays(1);
		dueDate = dueDate.plusDays(1);

		//calls the getWeekdays method only if there is not a weekend charge then uses the amount of weekdays returned to subtract
		//the weekends away from the total charge
		if(!isWeekendCharge)
		{
			int totalWeekdays = getWeekdays(checkoutDate, days);
			int daysToSubtract = days - totalWeekdays;
			chargeDays = chargeDays - daysToSubtract;
		}

		//calls the checkHoliday method only if there is not a holiday charge then uses the amount of holidays returned to subtract
		//the holidays away from the total charge
		if(!isHolidayCharge)
		{
			int countHolidays = checkHoliday(checkoutDate, days, dueDate);
			if(countHolidays > 0)
			{
				chargeDays = chargeDays - countHolidays;
			}
		}
		
		//sets the charge days for the RentalAgreement object
		rA.setChargeDays(chargeDays);
		
		//calculates the rental charge by multiplying the daily charge by the chargeDays
		BigDecimal rentalCharge = dailyRentalCharge.multiply(new BigDecimal(chargeDays));
		return rentalCharge;
	}

	//calculates the discount using the rentalCharge and the discount, changes discount to a decimal and multiplies it by the 
	//rentalCharge and returns that discount
	public BigDecimal calculateDiscount(BigDecimal rentalCharge, int discount)
	{
		if(discount == 0)
		{
			return BigDecimal.ZERO;
		}
		double discountToMultiply = discount/100.0;
		BigDecimal discountToSubtract = rentalCharge.multiply(new BigDecimal(discountToMultiply));
		return discountToSubtract;
	}
	
	//calculates the due date for the tool using the checkout day and number of days
	public LocalDate calculateDueDate(LocalDate checkout, int days)
	{
		LocalDate finalDate;
		finalDate = checkout.plusDays(days);		
		return finalDate;
	}

	//gets the number of weekdays that the tool is checked out for using the checkoutDate and number of days and returns it
	public int getWeekdays(LocalDate checkoutDate, int days) {

		LocalDate test = checkoutDate;
		int countWeekdays = 0;
		int checkedDays = 0;
		while (checkedDays < days) 
		{
			checkedDays ++;
			DayOfWeek dayOfWeek = test.getDayOfWeek();
			int weekDay = dayOfWeek.getValue();
			if (weekDay >= 1  && weekDay <= 5)
			{
				++countWeekdays;
			}
			test = test.plusDays(1);
		}
		return countWeekdays;
	}

	//gets the number of holidays that the tool is checked out for using the checkoutDate, dueDate, and number of days and returns it
	public int checkHoliday(LocalDate checkoutDate, int days, LocalDate dueDate)
	{
		int countHolidays = 0;
		int year = checkoutDate.getYear();
		int dueYear = dueDate.getYear();
		LocalDate septemberFirst = LocalDate.of(year, 9, 1);
		LocalDate septemberSeventh = LocalDate.of(year, 9, 7);
		int checkoutMonth = checkoutDate.getMonthValue();

		//counts labor days if tool is rented for multiple years
		if(checkoutDate.isBefore(septemberFirst) && dueDate.isAfter(septemberSeventh))
		{
			countHolidays = (dueYear - year) + 1;
		}
		//counts labor day if tool is rented for less than one year
		else
		{
			if(checkoutMonth == 9)
			{

				for(int daysBetween = days; daysBetween >= 0; daysBetween --)
				{
					DayOfWeek dayOfWeek = checkoutDate.getDayOfWeek();
					int weekDay = dayOfWeek.getValue();
					checkoutDate = checkoutDate.plusDays(1);
					if(weekDay == 1)
					{
						countHolidays ++;
					}
				}
			}
		}

		//counts independenceDay for tool rental taking into account the if independenceDay is on a Saturday it is observed the 
		//Friday the day before and if it is on a Sunday it is observed on Monday the day after
		for(int checkoutYear = year; checkoutYear <= dueYear; checkoutYear++)
		{
			LocalDate independenceDay = LocalDate.of(checkoutYear, 7, 4);
			LocalDate independenceDayFriday = LocalDate.of(checkoutYear, 7, 3);
			LocalDate independenceDayMonday = LocalDate.of(checkoutYear, 7, 5);
			DayOfWeek dayOfWeek = checkoutDate.getDayOfWeek();
			int weekDay = dayOfWeek.getValue();

			if((checkoutDate.isBefore(independenceDay) || checkoutDate.equals(independenceDay)) && dueDate.isAfter(independenceDay))
			{
				countHolidays++;
			}
			if(checkoutDate.isBefore(independenceDayFriday) && dueDate.isAfter(independenceDayFriday) && weekDay == 5)
			{
				countHolidays++;
			}
			if(checkoutDate.isBefore(independenceDayMonday) && dueDate.isAfter(independenceDayMonday) && weekDay == 1)
			{
				countHolidays++;
			}
		}
		return countHolidays;
	}

}
