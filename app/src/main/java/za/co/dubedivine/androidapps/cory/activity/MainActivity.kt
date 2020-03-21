package za.co.dubedivine.androidapps.cory.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import za.co.dubedivine.androidapps.cory.R
import za.co.dubedivine.androidapps.cory.viewmodel.ScreeningViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val viewModel = ScreeningViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_question.text = viewModel.question?.question ?: ""

        btn_yes.setOnClickListener {
            nextQuestion(true)
        }

        btn_no.setOnClickListener {
            nextQuestion(false)
        }
    }

    private fun nextQuestion(answer: Boolean) {
        if (viewModel.canContinue(answer)) {
            val question = viewModel.nextQuestion(answer)
            tv_question.text = question?.question
            Log.d(TAG, "the question is this $question ")
        } else {
            showResultsActivity(answer, viewModel.terminalMessage(answer))
        }
    }

    private fun showResultsActivity(isPostive: Boolean, terminalMessage: String) {
        ResultsActivity.startActivity(this, isPostive, terminalMessage)
    }


}
