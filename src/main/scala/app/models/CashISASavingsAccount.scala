package app.models

import app.models.AccountTypes.{AccountNumber, Balance}

final class CashISASavingsAccount(accountNumber: AccountNumber,
                                  balance: Balance,
                                  private val depositThreshold : Double = 200.00) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Balance): BankAccount = {
    println(s"You can't withdraw yet, your money is locked in for 3 years!!! And... we've reduced your APR to 0.2%!")
    this
  }

  override def deposit(amount: Balance): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You can't deposit more than £$depositThreshold. Excess: £$difference.")
      new CashISASavingsAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, balance + amount)
    }
  }

}