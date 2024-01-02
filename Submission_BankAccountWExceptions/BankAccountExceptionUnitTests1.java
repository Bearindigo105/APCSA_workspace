import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountExceptionUnitTests1 {

	private static BankAccount acc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acc = new BankAccount(100, "ellis");
	}

	@Test
	public void test_get_balance() {
		assertEquals(100, acc.getBalance(), 0.00001);
	}

	@Test
	public void negative_deposit() {
		assertThrows(IllegalArgumentException.class, () -> {
			acc.deposit(-20);
		});
	}

	@Test
	public void zero_deposit() {
		assertThrows(IllegalArgumentException.class, () -> {
			acc.deposit(0);
		});
	}

	@Test
	public void negative_withdraw() {
		assertThrows(IllegalArgumentException.class, () -> {
			acc.withdraw(-20);
		});
	}

	@Test
	public void zero_withdraw() {
		assertThrows(IllegalArgumentException.class, () -> {
			acc.withdraw(0);
		});
	}

	@Test
	public void overdraw_withdraw() {
		assertThrows(InsufficientBalanceException.class, () -> {
			acc.withdraw(120);
		});
	}

	@Test
	public void legal_withdraw() {
		BankAccount a = new BankAccount(100, "ellis");
		a.withdraw(20);
		assertEquals(80, a.getBalance(), 0.0001);
	}

	@Test
	public void legal_deposit() {
		BankAccount a = new BankAccount(100, "ellis");
		a.deposit(20);
		assertEquals(120, a.getBalance(), 0.0001);
	}

}
