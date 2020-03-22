package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.Information
import za.co.dubedivine.androidapps.cory.repository.local.InformationRepository

class InformationViewModel {

    fun coronaQuestionsAndAnswers(): List<Information> =  InformationRepository.coronaQuestionsAndAnswers().toList()
}