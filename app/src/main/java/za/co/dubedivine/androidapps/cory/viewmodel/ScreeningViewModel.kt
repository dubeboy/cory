package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningNode
import za.co.dubedivine.androidapps.cory.repository.local.ScreeningQuestionsRepository

class ScreeningViewModel {

    private var decisionTree: ScreeningNode? = ScreeningQuestionsRepository.screeningQuestionsDecisionTree()

    val question: ScreeningQuestion? = decisionTree?.parent
    val terminalMessage = decisionTree?.terminalMessage ?: ""

    fun nextQuestion(answer: Boolean): ScreeningQuestion? {
        val nextNode = decisionTree?.nextNode(answer)
        decisionTree = nextNode
        return nextNode?.parent
    }
    fun canContinue(answer: Boolean) = decisionTree?.isTerminal(answer) == false

}