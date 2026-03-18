package banking.model

abstract class Account(
    val accountNumber: String,
    protected var balance: Double,
    val openedDate: String,
    protected var isActive: Boolean = true,
    private var isFrozen: Boolean = false
) {

    fun deposit(amount: Double) {
        if (!isActive || isFrozen) {
            println("Account not allowed to operate")
            return
        }
        require(amount > 0) { "Deposit must be positive" }
        balance += amount
    }

    open fun withdraw(amount: Double) {
        if (!isActive || isFrozen) {
            println("Account not allowed to operate")
            return
        }
        if (amount > balance) {
            println("Insufficient balance")
            return
        }
        balance -= amount
    }

    fun transfer(amount: Double, target: Account) {
        if (!isActive || isFrozen) {
            println("Transfer not allowed")
            return
        }
        if (amount > balance) {
            println("Insufficient balance")
            return
        }
        withdraw(amount)
        target.deposit(amount)
    }

    fun freeze() { isFrozen = true }
    fun unfreeze() { isFrozen = false }

    fun getBalance(): Double = balance

    abstract fun calculateMonthlyInterest(): Double
}
