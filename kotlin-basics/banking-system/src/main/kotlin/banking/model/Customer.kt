package banking.model

class Customer(
    val customerId: String,
    val fullName: String
) {

    private val accounts = mutableListOf<Account>()

    fun openAccount(account: Account) {
        accounts.add(account)
    }

    fun getAccounts(): List<Account> = accounts

    fun getTotalBalance(): Double {
        return accounts.sumOf { it.getBalance() }
    }

    fun printCustomerDetails() {
        println("Customer: $fullName")
        accounts.forEach {
            println("Account: ${it.accountNumber}, Balance: ${it.getBalance()}")
        }
    }
}
