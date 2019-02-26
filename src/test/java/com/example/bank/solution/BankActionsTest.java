package com.example.bank.solution;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class BankActionsTest {

	private SoftAssertions softAssertions = new SoftAssertions();

	@Test
	public void transferMoney_singleThread_goodPath() throws Exception {
		BankAccount from = new BankAccount(100, 1);
		BankAccount to = new BankAccount(0, 2);

		TransferMoneyTask transferMoneyTask = new TransferMoneyTask(from, to, 70);

		transferMoneyTask.run();

		softAssertions.assertThat(from.getBalance()).isEqualTo(30);
		softAssertions.assertThat(to.getBalance()).isEqualTo(70);
		softAssertions.assertAll();
	}

}