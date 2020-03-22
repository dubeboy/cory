package za.co.dubedivine.androidapps.cory.activity.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import za.co.dubedivine.androidapps.cory.R
import za.co.dubedivine.androidapps.cory.activity.result.ResultsActivity
import za.co.dubedivine.androidapps.cory.viewmodel.ScreeningViewModel

class MainFragment : Fragment() {

    private val TAG = "MainActivity"

    private val viewModel = ScreeningViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.tv_question.text = viewModel.question?.question ?: ""

        view.btn_yes.setOnClickListener {
            nextQuestion(true)
        }

        view.btn_no.setOnClickListener {
            nextQuestion(false)
        }

        return view
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
        ResultsActivity.startActivity(
            context!!,
            isPostive,
            terminalMessage
        )
    }
}
