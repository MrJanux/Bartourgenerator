class FestivalExplorerCLI {
    private val bars = listOf(
        Bar("1", "Bar A", 4.5),
        Bar("2", "Bar B", 4.0),
        Bar("3", "Bar C", 4.2)
    )

    private val festivalMode = FestivalExplorerMode(
        predefinedBars = bars,
        drinkRandomizer = DrinkRandomizerServiceImpl(),
        tourService = TourServiceImpl()
    )

    fun start() {
        println("Willkommen zum Festival Explorer!")
        var running = true
        while (running) {
            println("Wähle eine Option:")
            println("1. Starte Tour")
            println("2. Nächster Halt")
            println("3. Beende Tour")
            println("4. Beenden")

            when (readLine()?.toIntOrNull()) {
                1 -> festivalMode.startTour()
                2 -> festivalMode.nextStop()
                3 -> festivalMode.endTour()
                4 -> {
                    println("Programm beendet.")
                    running = false
                }
                else -> println("Ungültige Eingabe.")
            }
        }
    }
}

fun main() {
    FestivalExplorerCLI().start()
}
