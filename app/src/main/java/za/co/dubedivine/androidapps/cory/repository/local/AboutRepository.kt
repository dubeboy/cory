package za.co.dubedivine.androidapps.cory.repository.local

import za.co.dubedivine.androidapps.cory.model.Information

object AboutRepository {
    fun aboutAppData(): Array<Information> {
        return arrayOf(
            Information(
                "About this app",
                "This app helps you"
            ),
            Information(
                "Information sources",
                "WHO: http:saddens.com\nCnadian website: http://dsdsdsds.com"
            ),
             Information(
                "App Source Code",
                "github.com/dubeboy"
            )
        )
    }
}