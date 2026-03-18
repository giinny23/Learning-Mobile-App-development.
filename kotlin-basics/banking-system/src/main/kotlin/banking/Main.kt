package banking

import banking.model.*
import banking.service.Bank

fun main() {

    val bank = Bank("My Bank")

    while (true) {
        println("\n=== Banking System ===")
        println("1. Create Customer")
        println("2. Open Account")
        println("3. Deposit")
        println("4. Withdraw")
        println("5. Transfer")
        println("6. View Customer Details")
        println("7. View Bank Report")
        println("8. View Transactions")
        println("9. Exit")

        when (readLine()!!.toInt()) {

            1 -> {
                val id = readLine()!!
                val name = readLine()!!
                bank.addCustomer(Customer(id, name))
            }

            2 -> {
                val customer = bank.findCustomer(readLine()!!) ?: continue
                val accNum = readLine()!!
                val balance = readLine()!!.toDouble()

                val account = SavingsAccount(accNum, balance, "2026", 0.05)
                bank.createAccount(customer, account)
            }

            3 -> {
                val customer = bank.findCustomer(readLine()!!) ?: continue
                val account = customer.getAccounts().firstOrNull() ?: continue
                val amount = readLine()!!.toDouble()

                account.deposit(amount)
                bank.logTransaction(Transaction("T${System.currentTimeMillis()}", "Deposit", amount, account.accountNumber))
            }

            4 -> {
                val customer = bank.findCustomer(readLine()!!) ?: continue
                val account = customer.getAccounts().firstOrNull() ?: continue
                val amount = readLine()!!.toDouble()

                account.withdraw(amount)
                bank.logTransaction(Transaction("T${System.currentTimeMillis()}", "Withdraw", amount, account.accountNumber))
            }

            5 -> {
                val sender = bank.findCustomer(readLine()!!) ?: continue
                val receiver = bank.findCustomer(readLine()!!) ?: continue

                val senderAcc = sender.getAccounts().firstOrNull() ?: continue
                val receiverAcc = receiver.getAccounts().firstOrNull() ?: continue

                val amount = readLine()!!.toDouble()

                senderAcc.transfer(amount, receiverAcc)

                bank.logTransaction(
                    Transaction("T${System.currentTimeMillis()}", "Transfer", amount, senderAcc.accountNumber, receiverAcc.accountNumber)
                )
            }

            6 -> bank.findCustomer(readLine()!!)?.printCustomerDetails()

            7 -> bank.generateReport()

            8 -> bank.showTransactions()

            9 -> return
        }
    }
}
