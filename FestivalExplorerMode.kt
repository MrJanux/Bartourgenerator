class FestivalExplorerMode(
    private val predefinedBars: List<Bar>,
    private val drinkRandomizer: DrinkRandomizerService,
    private val tourService: TourService
) : GameMode {

    override fun startTour() {
        println("Starte Festival-Tour!")
        nextStop()
    }

    override fun nextStop() {
        val visitedBars = tourService.getVisitedBars()
        val remainingBars = predefinedBars.filterNot { it in visitedBars }

        if (remainingBars.isEmpty()) {
            println("Alle Bars wurden besucht!")
            return
        }

        // Wähle eine zufällige Bar und ein Getränk
        val nextBar = Randomizer.pickRandom(remainingBars)
        val drink = drinkRandomizer.generateRandomDrink()

        // Ausgabe der Bar und des Getränks
        println("Nächste Bar: ${nextBar.name} (Bewertung: ${nextBar.rating}), Getränk: $drink")

        // Logge die Bar
        tourService.addToTourLog(
            TourLogEntry(nextBar, drink.name, System.currentTimeMillis())
        )
    }

    override fun endTour() {
        println("Festival-Tour beendet!")
        val log = tourService.getVisitedBars()
        println("Besuchte Bars: ${log.joinToString { it.name }}")
    }
}
