object Q3 {
  class Account(intialBalance: Double){
    private var balance = intialBalance

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
      } else if(amount < 0){
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

    def getBalance: Double = balance
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000)
    val account2 = new Account(5000)

    println("Initial balance Account1: " + account1.getBalance)
    println("Initial balance Account1: " + account2.getBalance)
    println()

    println("Transfer money from account 1 to account 2")
    account1.transfer(500, account2)
    println("New balance: " + account2.getBalance)

  }
}
