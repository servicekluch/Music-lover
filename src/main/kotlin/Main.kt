fun main() {

    val amount: Long

    println("Введите сумму покупки в руб. Для выхода введите end")

    val input = readLine()
    if (input != "end" && input != null) {
        amount = input.toLong()
    } else {
        return
    }

    println("Вы уже делали покупки в этом месяце, напишите да или нет?")
    var vipClient: String?
    while (true) {
        vipClient = readLine()
        when (vipClient) {
            "нет" -> break
            "да" -> break
            else -> println("Некорректный ввод, введите да или нет")
        }
    }

    val isVipClient = vipClient.equals("да")
    val customer = CalculationDiscount(isVipClient)
    println("Сумма покупки со скидкой ${customer.calc(amount)} руб.")
}