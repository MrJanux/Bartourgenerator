class TourServiceImpl : TourService {
    private val visitedBars = mutableListOf<Bar>()
    private val tourLog = mutableListOf<TourLogEntry>()

    override fun getVisitedBars(): List<Bar> {
        return visitedBars
    }

    override fun addToTourLog(entry: TourLogEntry) {
        tourLog.add(entry)
        if (!visitedBars.contains(entry.bar)) {
            visitedBars.add(entry.bar)
        }
    }

    override fun clearTourLog() {
        tourLog.clear()
        visitedBars.clear()  // Optional: Falls du auch die besuchten Bars zurücksetzen möchtest
    }
}
