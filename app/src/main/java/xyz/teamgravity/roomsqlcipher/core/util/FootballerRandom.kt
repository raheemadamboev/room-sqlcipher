package xyz.teamgravity.roomsqlcipher.core.util

import xyz.teamgravity.roomsqlcipher.core.constant.Position
import xyz.teamgravity.roomsqlcipher.data.model.FootballerModel

class FootballerRandom {

    companion object {
        private val FOOTBALLERS = listOf(
            FootballerModel(
                name = "Neuer",
                ranking = 91,
                position = Position.Goalkeeper
            ),
            FootballerModel(
                name = "Alisson",
                ranking = 89,
                position = Position.Goalkeeper
            ),
            FootballerModel(
                name = "Oblak",
                ranking = 90,
                position = Position.Goalkeeper
            ),
            FootballerModel(
                name = "Alaba",
                ranking = 87,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Ramos",
                ranking = 89,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Boateng",
                ranking = 86,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Pique",
                ranking = 87,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Lord Maguire",
                ranking = 99,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Van Dick",
                ranking = 90,
                position = Position.Defender
            ),
            FootballerModel(
                name = "De Light",
                ranking = 89,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Bonucci",
                ranking = 87,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Alderweirld",
                ranking = 86,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Marcelo",
                ranking = 87,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Thiago Silva",
                ranking = 88,
                position = Position.Defender
            ),
            FootballerModel(
                name = "David Luis",
                ranking = 87,
                position = Position.Defender
            ),
            FootballerModel(
                name = "Kimmich",
                ranking = 91,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Pogba",
                ranking = 85,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Eriksen",
                ranking = 88,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Kross",
                ranking = 88,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Pjanic",
                ranking = 89,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Veratti",
                ranking = 84,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Ozil",
                ranking = 89,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Coutinho",
                ranking = 86,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Kante",
                ranking = 91,
                position = Position.Midfielder
            ),
            FootballerModel(
                name = "Ronaldo",
                ranking = 99,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Messi",
                ranking = 99,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Lewandowski",
                ranking = 98,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Neymar",
                ranking = 97,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Mbappe",
                ranking = 96,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Halland",
                ranking = 96,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Ibrahimovich",
                ranking = 98,
                position = Position.Forward
            ),
            FootballerModel(
                name = "Son",
                ranking = 96,
                position = Position.Forward
            )
        )
    }

    fun nextTeam(): List<FootballerModel> {
        val team = mutableListOf<FootballerModel>()

        team.add(FOOTBALLERS.filter { it.position == Position.Goalkeeper }.random())

        val defenders = FOOTBALLERS.filter { it.position == Position.Defender }
        getRandomIndexes(defenders.size, 4).forEach { team.add(defenders[it]) }

        val midfielders = FOOTBALLERS.filter { it.position == Position.Midfielder }
        getRandomIndexes(midfielders.size, 3).forEach { team.add(midfielders[it]) }

        val forwards = FOOTBALLERS.filter { it.position == Position.Forward }
        getRandomIndexes(forwards.size, 3).forEach { team.add(forwards[it]) }

        return team
    }

    private fun getRandomIndexes(until: Int, times: Int): List<Int> {
        if (times > until) throw RuntimeException()

        val indexes = mutableListOf<Int>()
        repeat(until) { indexes.add(it) }
        indexes.shuffle()

        if (until == times) return indexes

        return indexes.subList(0, times)
    }
}