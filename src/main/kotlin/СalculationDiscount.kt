class CalculationDiscount (private val isVipClient: Boolean) {

    private var maximumDiscount = 5
    private var discountVipClient = 1
    private var standardDiscount = 100L
    private var purchaseAmountFrom = 1001L
    private var purchaseAmountUpTo = 10_0000L
    private var transfertInKopecks = 1000

    fun calc(amountRub: Long): Long {
        var totalAmount: Long
        val amountInKopecks = exchangeKopecksToRubles(amountRub)
        val purchaseAmountFromInKopecks = exchangeKopecksToRubles(purchaseAmountFrom)
        val purchaseAmountUpToInKopecks = exchangeKopecksToRubles(purchaseAmountUpTo)
        val standardDiscountInKopecks = exchangeKopecksToRubles(standardDiscount)

        when (amountInKopecks) {
            in 0 until purchaseAmountFromInKopecks -> totalAmount = amountInKopecks
            in purchaseAmountFromInKopecks..purchaseAmountUpToInKopecks -> totalAmount = amountInKopecks - standardDiscountInKopecks
            else -> totalAmount = amountInKopecks * (100 - maximumDiscount) / 100
        }

        totalAmount = exchangeRublesForKopecks(if (isVipClient) totalAmount * (100 - discountVipClient) / 100 else totalAmount)
            return totalAmount
        }
    private fun exchangeRublesForKopecks(amountRub: Long): Long {
        return amountRub / transfertInKopecks
    }

    private fun exchangeKopecksToRubles(amountKop: Long): Long {
        return amountKop * transfertInKopecks
    }
}