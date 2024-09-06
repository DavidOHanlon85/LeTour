package challengeLeTour;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRider {

	// test data

	String validNameLow;
	String validNameHigh;

	String validNationalityLow;
	String validNationalityHigh;

	LocalTime validLocalTimeLow;
	LocalTime validLocalTimeHigh;

	Rider r;

	@BeforeEach
	void setUp() throws Exception {

		validNameLow = "x".repeat(3);
		validNameHigh = "x".repeat(10);

		validNationalityLow = "x".repeat(3);
		validNationalityHigh = "x".repeat(15);

		validLocalTimeLow = LocalTime.of(3, 40, 16);
		validLocalTimeHigh = LocalTime.of(5, 45, 18);

		r = new Rider(validNameLow, validNameLow, validNationalityLow, validNameLow, validLocalTimeLow);
	}

	@Test
	void testRider() {
		assertEquals(validNameLow, r.getFirstName());
		assertEquals(validNameLow, r.getLastName());
		assertEquals(validNationalityLow, r.getNationality());
		assertEquals(validNameLow, r.getTeam());
		assertEquals(validLocalTimeLow, r.getTime());

		r = new Rider(validNameHigh, validNameHigh, validNationalityHigh, validNameHigh, validLocalTimeHigh);

		assertEquals(validNameHigh, r.getFirstName());
		assertEquals(validNameHigh, r.getLastName());
		assertEquals(validNationalityHigh, r.getNationality());
		assertEquals(validNameHigh, r.getTeam());
		assertEquals(validLocalTimeHigh, r.getTime());

	}

	@Test
	void testSetGetFirstName() {
		r.setFirstName(validNameLow);
		assertEquals(validNameLow, r.getFirstName());
		
		r.setFirstName(validNameHigh);
		assertEquals(validNameHigh, r.getFirstName());
	}


	@Test
	void testSetGetLastName() {
		r.setLastName(validNameLow);
		assertEquals(validNameLow, r.getLastName());
		
		r.setLastName(validNameHigh);
		assertEquals(validNameHigh, r.getLastName());
	}


	@Test
	void testSetGetNationality() {
		r.setNationality(validNationalityLow);
		assertEquals(validNationalityLow, r.getNationality());
		
		r.setNationality(validNationalityHigh);
		assertEquals(validNationalityHigh, r.getNationality());
	}

	@Test
	void testSetGetTeam() {
		r.setTeam(validNameLow);
		assertEquals(validNameLow, r.getTeam());
		
		r.setTeam(validNameHigh);
		assertEquals(validNameHigh, r.getTeam());
	}


	@Test
	void testSetGetTime() {
		r.setTime(validLocalTimeLow);
		assertEquals(validLocalTimeLow, r.getTime());
		
		r.setTime(validLocalTimeHigh);
		assertEquals(validLocalTimeHigh, r.getTime());
	}

	

}
