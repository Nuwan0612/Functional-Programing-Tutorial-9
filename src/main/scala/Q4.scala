object Q4 {
  class Account(accountID: String, intialBalance: Double) {
    private var balance = intialBalance
    private val accountNumber = accountID

    def deposite(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println("Deposite amount: " + amount)
        println("New balance: " + balance)
      } else {
        println("Amount must be positive")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println("Withdraw amount: " + amount)
        println("New balance: " + balance)
      } else if (amount < 0) {
        println("Amount must be positive")
      } else {
        println("Insufficient balance")
      }
    }

    def transfer(amount: Double, transferAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        transferAccount.deposite(amount)
        println("Transfer Successfull")
        println("New balance: " + balance)
      } else if (amount < 0) {
        println("Amount must be positive")
      } else {
        println("Insufficient balance")
      }
    }

    def calculateInterst(): Unit = {
      if(balance >= 0) {
        balance += balance *0.05
      } else {
        balance += balance *0.01
      }
      println(accountNumber + " new balance: " + balance)
    }

    def getBalance: Double = balance
    def getAccountNumber: String = accountNumber
  }

  class Bank(accounts: List[Account]) {
    def negativeAccounts: List[Account] = {
      accounts.filter(account => account.getBalance < 0)
    }

    def caculateAll: Double = {
      var totalBalance: Double = 0
      accounts.foreach(account => totalBalance += account.getBalance)
      return totalBalance
    }

    def finalBalance: Unit = {
      accounts.foreach(account => account.calculateInterst())
    }
  }

  def main(args: Array[String]): Unit = {

      val acc1 = new Account("AB123",1)
      val acc2 = new Account("AC456",-5)
      val acc3 = new Account("AD789",2)
      val acc4 = new Account("AP612",-1)
      val acc5 = new Account("AW356",5)

      val bank = new Bank(List(acc1, acc2, acc3, acc4, acc5))

      println("Accounts with negative values")
      bank.negativeAccounts.foreach(account => println(account.getAccountNumber))

      println("\nTotal balance: " + bank.caculateAll)

      println("\nAfter calculate interest")
      bank.finalBalance

  }

}
