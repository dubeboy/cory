package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.repository.local.ScreeningQuestionsRepository

class ScreeningViewModel {

    private val decisionTree = ScreeningQuestionsRepository.screeningQuestionsDecisionTree()

    val canContinue = !decisionTree.isTerminal()
    val question: ScreeningQuestion? = decisionTree.parent
    val terminalMessage = decisionTree.terminalMessage ?: ""

    fun nextQuestion(answer: Boolean): ScreeningQuestion? = decisionTree.nextNode(answer)?.parent

}