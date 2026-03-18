package banking.model

class CurrentAccount(
    accountNumber: String,
    balance: Double,
    openedDate: String,
    private val overdraftLimit: Double
) : Account(accountNumber, balance, openedDate) {

    override fun withdraw(amount: Double) {
        if (balance - amount < -overdraftLimit) {
            println("Overdraft limit exceeded")
            return
        }
        balance -= amount
    }

    override fun calculateMonthlyInterest(): Double = 0.0
}
