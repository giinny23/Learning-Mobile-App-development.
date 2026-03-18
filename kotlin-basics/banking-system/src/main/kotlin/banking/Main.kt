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
        println("8. Exit")
        print("Choose an option: ")

        when (readLine()!!.toInt()) {

            1 -> {
                print("Enter Customer ID: ")
                val id = readLine()!!

                print("Enter Name: ")
                val name = readLine()!!

                val customer = Customer(id, name)
                bank.addCustomer(customer)

                println("Customer created successfully.")
            }

            2 -> {
                print("Enter Customer ID: ")
                val id = readLine()!!

                val customer = bank.findCustomer(id)

                if (customer == null) {
                    println("Customer not found.")
                    continue
                }

                print("Enter Account Number: ")
                val accNum = readLine()!!

                print("Enter Initial Balance: ")
                val balance = readLine()!!.toDouble()

                println("Choose Account Type: 1.Savings 2.Current")
                when (readLine()!!.toInt()) {
                    1 -> {
                        val account = SavingsAccount(accNum, balance, "2026", 0.05)
                        customer.openAccount(account)
                    }
                    2 -> {
                        val account = CurrentAccount(accNum, balance, "2026", 500.0)
                        customer.openAccount(account)
                    }
                }

                println("Account created successfully.")
            }

            3 -> {
                print("Enter Customer ID: ")
                val customer = bank.findCustomer(readLine()!!)

                if (customer == null) {
                    println("Customer not found.")
                    continue
                }

                print("Enter Account Number: ")
                val accNum = readLine()!!

                val account = customer.getAccounts().find { it.accountNumber == accNum }

                if (account == null) {
                    println("Account not found.")
                    continue
                }

                print("Enter amount: ")
                val amount = readLine()!!.toDouble()

                account.deposit(amount)
                println("Deposit successful.")
            }

            4 -> {
                print("Enter Customer ID: ")
                val customer = bank.findCustomer(readLine()!!)

                if (customer == null) {
                    println("Customer not found.")
                    continue
                }

                print("Enter Account Number: ")
                val accNum = readLine()!!

                val account = customer.getAccounts().find { it.accountNumber == accNum }

                if (account == null) {
                    println("Account not found.")
                    continue
                }

                print("Enter amount: ")
                val amount = readLine()!!.toDouble()

                account.withdraw(amount)
            }

            5 -> {
                print("Enter Sender Customer ID: ")
                val sender = bank.findCustomer(readLine()!!)

                print("Enter Receiver Customer ID: ")
                val receiver = bank.findCustomer(readLine()!!)

                if (sender == null || receiver == null) {
                    println("Invalid customers.")
                    continue
                }

                print("Enter Sender Account Number: ")
                val senderAcc = sender.getAccounts().find { it.accountNumber == readLine()!! }

                print("Enter Receiver Account Number: ")
                val receiverAcc = receiver.getAccounts().find { it.accountNumber == readLine()!! }

                if (senderAcc == null || receiverAcc == null) {
                    println("Invalid accounts.")
                    continue
                }

                print("Enter amount: ")
                val amount = readLine()!!.toDouble()

                senderAcc.transfer(amount, receiverAcc)
                println("Transfer completed.")
            }

            6 -> {
                print("Enter Customer ID: ")
                val customer = bank.findCustomer(readLine()!!)

                customer?.printCustomerDetails() ?: println("Customer not found.")
            }

            7 -> {
                bank.generateReport()
            }

            8 -> {
                println("Exiting system...")
                return
            }

            else -> println("Invalid choice.")
        }
    }
}
