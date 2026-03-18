package banking.staff

import banking.model.Account

class Employee(
    val employeeId: String,
    val name: String,
    val role: String
) {

    fun freezeAccount(account: Account) {
        account.freeze()
        println("Account frozen")
    }

    fun unfreezeAccount(account: Account) {
        account.unfreeze()
        println("Account unfrozen")
    }

    fun approveLoan(amount: Double) {
        if (role != "Manager") {
            println("Only managers can approve loans")
            return
        }
        println("Loan approved: $amount")
    }
}
