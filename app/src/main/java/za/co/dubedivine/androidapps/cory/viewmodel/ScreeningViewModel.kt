package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion

class ScreeningViewModel {

    private val questions = screeningQuestions()
    private var questionIndex: Int = 0
    private var previousQuestion = screeningQuestions().first()
    private var shouldContinue: Boolean = true

    fun numberOfQuestions() = questions.size

    fun nextQuestion(answer: Boolean): ScreeningQuestion {
        if (hasNotReachedEndOfQuestions()) previousQuestion = screeningQuestions()[questionIndex]
        shouldContinue(answer)
        questionIndex += 1
        return when {
            hasNotReachedEndOfQuestions() -> {
                screeningQuestions()[questionIndex]
            }
            else -> {
                previousQuestion
            }
        }

    }

    private fun shouldContinue(answer: Boolean) {
        if (shouldContinue) {
            shouldContinue = previousQuestion.weight == 0.0 || (previousQuestion.weight == 1.0 && !answer)
        }
    }

    fun firstQuestion(): ScreeningQuestion = screeningQuestions().first()

    /**
    *  private functions
    * */

    private fun hasNotReachedEndOfQuestions(): Boolean = questionIndex < numberOfQuestions()
}