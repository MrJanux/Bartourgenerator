interface TourService {
    fun getVisitedBars(): List<Bar>
    fun addToTourLog(entry: TourLogEntry)
    fun clearTourLog() // Hier definieren wir die Methode
}
