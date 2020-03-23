package za.co.dubedivine.androidapps.cory.feature.main.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import za.co.dubedivine.androidapps.cory.R
import za.co.dubedivine.androidapps.cory.feature.extension.showDialog
import za.co.dubedivine.androidapps.cory.feature.main.viewmodel.ScreeningViewModel


class MainFragment : Fragment() {

    private val TAG = "MainActivity"

    private lateinit var viewModel: ScreeningViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ScreeningViewModel(view.context)

        view.tv_question.text = viewModel.question?.question ?: ""

        view.btn_yes.setOnClickListener {
            nextQuestion(true)
        }

        view.btn_no.setOnClickListener {
            nextQuestion(false)
        }

        view.btn_chat.isEnabled = viewModel.isWhatsappInstalled()

        view.btn_chat.setOnClickListener {
            startActivity(viewModel.getOpenWHatsAppIntent())
        }

        view.btn_hotline.setOnClickListener {
            if (viewModel.getDialZAHotlineIntent() != null) {
                startActivity(viewModel.getDialZAHotlineIntent())
            } else {
                Snackbar.make(view, "This feature is available to SA citizens only.\nPlease use the international chat feature provided by the World Health Organization.", Snackbar.LENGTH_LONG).apply {
                    getView().findViewById<TextView>(com.google.android.material.R.id.snackbar_text).maxLines = 5
                }
                .show()

            }
        }

        return view
    }


    private fun nextQuestion(answer: Boolean) {
        if (viewModel.canContinue(answer)) {
            val question = viewModel.nextQuestion(answer)
            tv_question.text = question?.question
            Log.d(TAG, "the question is this $question ")
        } else {
            showResultsActivity( viewModel.terminalMessage(answer))
        }
    }

    private fun showResultsActivity(terminalMessage: String) {
        activity?.showDialog("Screening Results", terminalMessage)
    }
}
