package app.models

import app.models.AccountTypes.AccountNumber

object AccountTypes {
  type AccountNumber = String
  type Balance = Double
}

abstract class BankAccount(accountNumber : AccountTypes.AccountNumber,
                           val balance: AccountTypes.Balance) {

  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount

  override def toString: AccountNumber = s"Account number: $accountNumber, balance : $balance"
}
