package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningNode
import za.co.dubedivine.androidapps.cory.repository.local.ScreeningQuestionsRepository

class ScreeningViewModel {

    private var decisionTree: ScreeningNode? = ScreeningQuestionsRepository.screeningQuestionsDecisionTree()

    val question: ScreeningQuestion? = decisionTree?.parent
    fun terminalMessage(answer: Boolean) = decisionTree?.terminalMessage(answer) ?: ""


    fun nextQuestion(answer: Boolean): ScreeningQuestion? {
        val nextNode = decisionTree?.nextNode(answer)
        decisionTree = nextNode  // should be in ADT mananger
        return nextNode?.parent
    }
    fun canContinue(answer: Boolean) = decisionTree?.isTerminal(answer) == false

}