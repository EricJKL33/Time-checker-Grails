package timeManagerCalculation

import java.time.Duration
import java.time.LocalTime


class TimeCalculationService {


    List<Map> LISTE_HORAIRE = []

    def addTimeWorked(Map timeData) {
        LISTE_HORAIRE.add(timeData)
    }

    // private static List LISTE_HORAIRE = [
        // [date: "2020/05/12", totalMatin: LocalTime.parse("03:30"), totalApresMidi: LocalTime.parse("03:45"), totalJour: LocalTime.parse("07:15")],
        // [date: "2020/05/12", totalMatin: LocalTime.parse("03:30"), totalApresMidi: LocalTime.parse("03:45"), totalJour: LocalTime.parse("07:15")],
        // [date: "2020/05/12", totalMatin: LocalTime.parse("03:30"), totalApresMidi: LocalTime.parse("03:45"), totalJour: LocalTime.parse("07:15")],
        // [date: "2020/05/12", totalMatin: LocalTime.parse("03:30"), totalApresMidi: LocalTime.parse("03:45"), totalJour: LocalTime.parse("07:15")],
        
    // ]

    def totalHours(heureArrivee, heureDepart) {
        def totalHours = Duration.between(heureArrivee, heureDepart)

		return totalHours
    }

    def totalHoursDay(heureArriveeMatin, heureDepartMatin, heureArriveeApresMidi, heureDepartApresMidi) {
        def totalMatin = totalHours(heureArriveeMatin, heureDepartMatin)
		def totalApresMidi = totalHours(heureArriveeApresMidi, heureDepartApresMidi)
		def totalJour = totalMatin + totalApresMidi
		return totalJour
    }
    def getAllTimeWorked(){
        return LISTE_HORAIRE
    }
}   

