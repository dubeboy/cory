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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {

    private val TAG = "MainActivity"

    private val viewModel = ScreeningViewModel()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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

    companion object {
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
