import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * @author katherinesmall
 * 
 * this is the JUnit test class that creates a checkout object, rents a tool by calling the rentTool method of the Checkout class and
 * gets the finalCharge returned from this method, converts it to a double for testing purposes and compares against the expected result
 */
public class PointOfSaleTest 
{
	
	//This test has a percentage out of the zero to one hundred range, so it should throw an exception
	@Test public void firstRental()
	{ 
		try {
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2015, 3, 15);
		check.rentTool("JAKR", testDate, 5, 101);
		fail("Expected an IllegalArgumentException to be thrown");
		}
		catch (IllegalArgumentException anIllegalArgumentException)
		{
			Assert.assertEquals(anIllegalArgumentException.getMessage(), "Percent discount is not in the range zero to one hundred.");
		}
	}
	
	@Test public void secondRental()
	{
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2020, 7, 2);
		BigDecimal toConvert = check.rentTool("LADW", testDate, 3, 10);
		double actual = toConvert.doubleValue();
		double expected = 3.58;
		Assert.assertEquals(expected, actual, .001);
	}
	
	@Test public void thirdRental()
	{
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2015, 7, 2);
		BigDecimal toConvert = check.rentTool("CHNS", testDate, 5, 25);
		double actual = toConvert.doubleValue();
		double expected = 3.35;
		Assert.assertEquals(expected, actual, .001);
	}
	
	@Test public void fourthRental()
	{
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2015, 9, 3);
		BigDecimal toConvert = check.rentTool("JAKD", testDate, 6, 0);
		double actual = toConvert.doubleValue();
		double expected = 8.97;
		Assert.assertEquals(expected, actual, .001);
	}
	
	@Test public void fifthRental()
	{
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2015, 7, 2);
		BigDecimal toConvert = check.rentTool("JAKR", testDate, 9, 0);
		double actual = toConvert.doubleValue();
		double expected = 14.95;
		Assert.assertEquals(expected, actual, .001);
	}
	
	@Test public void sixthRental()
	{
		Checkout check = new Checkout();
		LocalDate testDate = LocalDate.of(2020, 7, 2);
		BigDecimal toConvert = check.rentTool("JAKR", testDate, 4, 50);
		double actual = toConvert.doubleValue();
		double expected = 1.49;
		Assert.assertEquals(expected, actual, .001);
	}
	
}
