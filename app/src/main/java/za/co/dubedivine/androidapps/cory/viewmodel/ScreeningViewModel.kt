package za.co.dubedivine.androidapps.cory.viewmodel

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningNode
import za.co.dubedivine.androidapps.cory.repository.local.ScreeningQuestionsRepository

class ScreeningViewModel {

    private var decisionTree: ScreeningNode? = ScreeningQuestionsRepository.screeningQuestionsDecisionTree()

    val question: ScreeningQuestion? = decisionTree?.parent
    var terminalMessage = ""


    fun nextQuestion(answer: Boolean): ScreeningQuestion? {
        val nextNode = decisionTree?.nextNode(answer)
        decisionTree = nextNode  // should be in ADT mananger
        terminalMessage = nextNode?.terminalMessage ?: "" // not right
        return nextNode?.parent
    }
    fun canContinue(answer: Boolean) = decisionTree?.isTerminal(answer) == false

}