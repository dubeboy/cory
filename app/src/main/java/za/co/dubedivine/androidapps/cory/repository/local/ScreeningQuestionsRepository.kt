package za.co.dubedivine.androidapps.cory.repository.local

import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningDecisionTree
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningNode

object ScreeningQuestionsRepository {

    private val terminalMessages = arrayOf(
        "Please call 911 or go directly to your nearest Emergency Department",
        "You should speak with a nurse about your symptoms.",
        "You should immediately limit your contact with others and isolate yourself at home.",
        "Based on your responses you do not need to be tested for COVID-19 at this time.",
        "You should speak with a nurse about your exposure.",
        "All international travellers are asked to self-isolate and self-monitor for symptoms"
    )

   private val screeningQuestions = arrayOf(
        ScreeningQuestion(
            "Do you or the person you are inquiring about have any of the following symptoms: severe difficulty breathing, chest pain, confusion, extreme drowsiness or loss of consciousness?",
            1.0
        ),
        ScreeningQuestion(
            "Do you or the person you are inquiring about have shortness of breath at rest or difficulty breathing when lying down?",
            2.0
        ),
        ScreeningQuestion(
            "Do you have any of the following symptoms: fever, cough, sore throat, shortness of breath, runny nose or poor feeding if an infant?, lack of energy or tiredness?",
            3.0
        ),
        ScreeningQuestion(
            "Have you been in contact in the last 14 days with someone that is confirmed to have COVID-19?",
            4.0
        ),
        ScreeningQuestion(
            "Have you had laboratory exposure while working directly with specimens known to contain COVID-19?",
            5.0
        ),
        ScreeningQuestion(
            "Have you been notified of or are you aware of an exposure in the last 14 days in a setting where someone has been confirmed or suspected to have a case of COVID-19, such as at a large conference or on a plane?",
            6.0
        ),
        ScreeningQuestion(
            "Have you travelled outside of Canada, including to the United States, in the last 14 days?",
            7.0
        ),

       ScreeningQuestion(
           "Have you had close contact (face-to-face contact within 2 meters/6 feet) with someone who is ill with cough and/or fever that traveled outside of Canada within the last 14 days prior to feeling ill?",
           8.0
       ),
       ScreeningQuestion(
           "Have you had close contact (face-to-face contact within 2 meters/6 feet) with someone who has been tested for COVID-19 and doesn’t know the results of the test yet?",
           9.0
       ),
       ScreeningQuestion(
           "Do you or the person you are inquiring about have a chronic health condition that you are concerned about?",
           10.0
       )
    )

    fun screeningQuestionsDecisionTree() {
        ScreeningNode(
            parent = screeningQuestions[0],
            nextNode = ScreeningDecisionTree(
                yes = ScreeningNode(
                    screeningQuestions[1],
                    nextNode = ScreeningDecisionTree(
                        yes = ScreeningNode(
                            parent = screeningQuestions[2],
                            nextNode = ScreeningDecisionTree(
                                yes = ScreeningNode(
                                    parent = screeningQuestions[2],
                                    nextNode = null
                                ),
                                no = ScreeningNode(
                                    parent = screeningQuestions[1],
                                    nextNode = null
                                )
                            )
                        ),
                        no =  ScreeningNode(
                            parent = screeningQuestions[2],
                            nextNode = ScreeningDecisionTree(
                                yes = ScreeningNode(
                                    parent = screeningQuestions[2],
                                    nextNode = null
                                ),
                                no = ScreeningNode(
                                    parent = screeningQuestions[1],
                                    nextNode = null
                                )
                            )
                        )
                    )
                ),
                no = ScreeningNode(
                    screeningQuestions[1],
                    nextNode = ScreeningDecisionTree(
                        yes = ScreeningNode(
                            parent = screeningQuestions[2],
                            nextNode = ScreeningDecisionTree(
                                yes = ScreeningNode(
                                    parent = screeningQuestions[2],
                                    nextNode = null
                                ),
                                no = ScreeningNode(
                                    parent = screeningQuestions[1],
                                    nextNode = null
                                )
                            )
                        ),
                        no =  ScreeningNode(
                            parent = screeningQuestions[2],
                            nextNode = ScreeningDecisionTree(
                                yes = ScreeningNode(
                                    parent = screeningQuestions[2],
                                    nextNode = null
                                ),
                                no = ScreeningNode(
                                    parent = screeningQuestions[1],
                                    nextNode = null
                                )
                            )
                        )
                    )
                )
            )
        )
    }

    private fun createNextNode() {

    }

}