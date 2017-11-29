package app.models

import app.models.AccountTypes.{AccountNumber, Balance}

final class SavingsAccount(accountNumber: AccountNumber,
                           balance: Balance) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Balance): BankAccount = {
    if ((balance - amount) < 0) {
      println(s"You have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      new SavingsAccount(accountNumber, deducted)
    }
  }

  override def deposit(amount: Balance): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }

}
