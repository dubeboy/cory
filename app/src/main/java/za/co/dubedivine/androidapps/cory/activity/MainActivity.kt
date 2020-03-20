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

        tv_question.text = viewModel.firstQuestion().question

        btn_yes.setOnClickListener {
            val question = viewModel.nextQuestion(true)
//            if (viewModel.shouldContinue(true))
               tv_question.text = question.question
            Log.d(TAG, "should continue $question ")
        }

        btn_no.setOnClickListener {
            val question = viewModel.nextQuestion(false)
//            if (viewModel.shouldContinue(true))
                tv_question.text = question.question
            Log.d(TAG, "should continue $question ")
        }
    }


}
