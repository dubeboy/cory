package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion

class ScreeningViewModel {

    private val questions = screeningQuestions()

    private var questionIndex: Int = 0

    private var currentQuestion: ScreeningQuestion? = null

    fun numberOfQuestions() = questions.size

    fun nextQuestion(answer: Boolean): Pair<Boolean, ScreeningQuestion> {

        val shouldContinue = !answer && currentQuestion?.weight ?: 0.0 < 1.0

        currentQuestion = screeningQuestions()[questionIndex]

        if (numberOfQuestions() < questionIndex && shouldContinue) {
            questionIndex += 1
        }

        return  Pair(shouldContinue, currentQuestion!!)
    }

    fun firstQuestion(): ScreeningQuestion = nextQuestion(false).second

    private companion object {
        fun screeningQuestions(): Array<ScreeningQuestion> {
            return arrayOf(
                ScreeningQuestion("Do you or the person you are inquiring about have any of the following symptoms: severe difficulty breathing, chest pain, confusion, extreme drowsiness or loss of consciousness?", 1.0),
             ScreeningQuestion("Do you or the person you are inquiring about have shortness of breath at rest or difficulty breathing when lying down?", 1.0),
             ScreeningQuestion("Do you have any of the following symptoms: fever, cough, sore throat, shortness of breath, runny nose or poor feeding if an infant?", 1.0),
             ScreeningQuestion("Have you been in contact in the last 14 days with someone that is confirmed to have COVID-19?", 0.0),
             ScreeningQuestion("Have you had laboratory exposure while working directly with specimens known to contain COVID-19?", 1.0),
             ScreeningQuestion("Have you been notified of or are you aware of an exposure in the last 14 days in a setting where someone has been confirmed or suspected to have a case of COVID-19, such as at a large conference or on a plane?", 1.0),
             ScreeningQuestion("Have you travelled outside of Canada, including to the United States, in the last 14 days?", 1.0)

            )
        }
    }
}