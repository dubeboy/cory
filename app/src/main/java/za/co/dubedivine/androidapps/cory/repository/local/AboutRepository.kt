package za.co.dubedivine.androidapps.cory.repository.local

import za.co.dubedivine.androidapps.cory.model.Information

object AboutRepository {
    fun aboutAppData(): Array<Information> {
        return arrayOf(
            Information(
                "About this app",
                "This app can help you verify if your symptons are those of the novel coronavirus.\n\nBenefits are that you keep your self quarantined so that you do not spread the disease or worse catch it in the process of going to the hospital for a check up."
            ),
            Information(
                "Information sources",
                "Screening Tool: https://sharedhealthmb.ca/covid19/screening-tool/\n\nCOVID-19 Q&A: https://www.who.int/emergencies/diseases/novel-coronavirus-2019"
            ),
             Information(
                "App Source Code",
                "github.com/dubeboy"
            )
        )
    }
}