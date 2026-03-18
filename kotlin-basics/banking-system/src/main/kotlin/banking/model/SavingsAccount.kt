package banking.model

class SavingsAccount(
    accountNumber: String,
    balance: Double,
    openedDate: String,
    private val interestRate: Double
) : Account(accountNumber, balance, openedDate) {

    private var withdrawals = 0

    override fun withdraw(amount: Double) {
        if (withdrawals >= 3) {
            println("Withdrawal limit reached")
            return
        }
        super.withdraw(amount)
        withdrawals++
    }

    override fun calculateMonthlyInterest(): Double {
        return getBalance() * interestRate
    }
}
