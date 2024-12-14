class DrinkRandomizerServiceImpl : DrinkRandomizerService {
    override fun generateRandomDrink(): DrinkType {
        val random = (1..100).random()
        return when {
            random <= 47 -> DrinkType.BEER
            random <= 94 -> DrinkType.SHOT
            else -> DrinkType.HOUSE_SPECIALITY
        }
    }
}
