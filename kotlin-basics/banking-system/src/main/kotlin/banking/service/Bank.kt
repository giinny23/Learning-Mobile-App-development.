package banking.service

import banking.model.*

class Bank(val bankName: String) {

    private val customers = mutableListOf<Customer>()
    private val transactions = mutableListOf<Transaction>()
    private val accountNumbers = mutableSetOf<String>()

    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun findCustomer(id: String): Customer? {
        return customers.find { it.customerId == id }
    }

    fun createAccount(customer: Customer, account: Account) {
        if (accountNumbers.contains(account.accountNumber)) {
            println("Account number already exists!")
            return
        }
        accountNumbers.add(account.accountNumber)
        customer.openAccount(account)
    }

    fun logTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun showTransactions() {
        println("=== Transactions ===")
        transactions.forEach { it.printTransactionDetails() }
    }

    fun generateReport() {
        println("=== Bank Report ===")
        customers.forEach { it.printCustomerDetails() }
    }
}
