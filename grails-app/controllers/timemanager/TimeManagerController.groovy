package timemanager
import java.time.LocalTime
import java.util.Date
import java.text.SimpleDateFormat


class TimeManagerController {
    
    static defaultAction = "list"

    def timeCalculationService

        def list() {
        // Render the list page.
        render(view: 'timeCheckerForm')
    }


    def timeManagerForm() {

       render(view:"timeCheckerForm")
    }

    def submit() {

        // Date today = new Date()
        // def dateFormat = new SimpleDateFormat("dd-MM-yyyy")
        // def todayString = dateFormat.format(today)

        // println(todayString)

        def date = params.date
        def heureDepartMatin = LocalTime.parse(params.heureDepartMatin)
        def heureArriveeMatin = LocalTime.parse(params.heureArriveeMatin)
        def heureDepartApresMidi = LocalTime.parse(params.heureDepartApresMidi)
        def heureArriveeApresMidi = LocalTime.parse(params.heureArriveeApresMidi)

        Date submittedDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.date)
        def formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(submittedDate)

        
        def totalMatin = timeCalculationService.totalHours(heureArriveeMatin, heureDepartMatin)
        def totalApresMidi = timeCalculationService.totalHours(heureArriveeApresMidi, heureDepartApresMidi)
        def totalJour = timeCalculationService.totalHoursDay(heureArriveeMatin, heureDepartMatin, heureArriveeApresMidi, heureDepartApresMidi)

        totalMatin = convertDurationToLocalTime(totalMatin)
        totalApresMidi = convertDurationToLocalTime(totalApresMidi)
        totalJour = convertDurationToLocalTime(totalJour)

        println(date)



        def timeData = [date: formattedDate,
            totalMatin: totalMatin,
            totalApresMidi: totalApresMidi,
            totalJour: totalJour]


        timeCalculationService.addTimeWorked(timeData)

        redirect(action: "timeManagerList")
    }


    private LocalTime convertDurationToLocalTime(duration) {
    int hours = duration.toHours()
    int minutes = duration.toMinutes() % 60
    String formattedTime = (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes
    return LocalTime.parse(formattedTime)
    }



    def timeManagerList() {
     
        // Retrieve data from the service
        def timeList = timeCalculationService.getAllTimeWorked()

        // Render the list page and send the data to the view
        render(view: 'timeCheckerResult', model: [times: timeList])
    }
}