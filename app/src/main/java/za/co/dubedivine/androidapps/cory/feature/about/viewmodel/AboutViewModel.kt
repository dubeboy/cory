package za.co.dubedivine.androidapps.cory.feature.about.viewmodel

import za.co.dubedivine.androidapps.cory.repository.local.AboutRepository

class AboutViewModel {
    val aboutAppInformation = AboutRepository.aboutAppData().toList()
}