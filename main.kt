fun main() {
    // 1. Vordefinierte Liste von Bars (vom Veranstalter bereitgestellt)
    val bars = listOf(
        Bar("1", "Bar A", 4.5),
        Bar("2", "Bar B", 4.0),
        Bar("3", "Bar C", 4.2),
        Bar("4", "Bar D", 3.8)
    )

    // 2. Initialisierung der Services
    val drinkRandomizer = DrinkRandomizerServiceImpl()
    val tourService = TourServiceImpl()

    // 3. Initialisierung des Festival Explorer Modus
    val festivalExplorer = FestivalExplorerMode(
        predefinedBars = bars,
        drinkRandomizer = drinkRandomizer,
        tourService = tourService
    )

    // 4. Simulierter Ablauf des Spiels
    println("Willkommen zum Festival Explorer!")
    while (true) {
        println("\nWas möchtest du tun?")
        println("1: Starte Tour")
        println("2: Nächste Bar")
        println("3: Tour beenden")
        println("4: Beenden")

        when (readlnOrNull()?.trim()) {
            "1" -> festivalExplorer.startTour()
            "2" -> festivalExplorer.nextStop()
            "3" -> festivalExplorer.endTour()
            "4" -> {
                println("Vielen Dank fürs Spielen! Bis zum nächsten Mal.")
                break
            }
            else -> println("Ungültige Eingabe. Bitte wähle eine Option aus.")
        }
    }
}
