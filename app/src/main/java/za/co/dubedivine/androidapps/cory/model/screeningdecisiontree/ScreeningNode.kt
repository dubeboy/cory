package za.co.dubedivine.androidapps.cory.model.screeningdecisiontree

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion

data class ScreeningNode(val parent: ScreeningQuestion?, val nextNode: ScreeningDecisionTree?, val terminalMessage: String? = null) {

    /*
    *  these functions should be moved to ADT manager sort of class
    * */

    fun isTerminal(answer: Boolean) = if (answer) nextNode?.yes?.terminalMessage != null else nextNode?.no?.terminalMessage != null

    fun nextNode(answer: Boolean): ScreeningNode? {
        return if (answer) nextNode?.yes  else nextNode?.no
    }

}