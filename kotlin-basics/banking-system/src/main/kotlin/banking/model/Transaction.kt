package banking.model

class Transaction(
    val transactionId: String,
    val type: String,
    val amount: Double,
    val sourceAccount: String,
    val targetAccount: String? = null
) {

    fun printTransactionDetails() {
        println("[$transactionId] $type: $amount from $sourceAccount to ${targetAccount ?: "N/A"}")
    }
}
