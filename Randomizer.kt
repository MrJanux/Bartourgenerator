object Randomizer {
    // Wählt ein zufälliges Element aus der Liste aus
    fun <T> pickRandom(list: List<T>): T {
        return list.random()
    }
}
