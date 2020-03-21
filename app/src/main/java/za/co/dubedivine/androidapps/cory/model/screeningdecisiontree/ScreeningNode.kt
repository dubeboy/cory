package za.co.dubedivine.androidapps.cory.model.screeningdecisiontree

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion

data class ScreeningNode(val parent: ScreeningQuestion?, val nextNode: ScreeningDecisionTree?, val terminalMessage: String? = null)