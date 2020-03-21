package za.co.dubedivine.androidapps.cory.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_results.*
import za.co.dubedivine.androidapps.cory.R

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val isPositive = intent.getBooleanExtra(EXTRA_IS_POSITIVE, false)
        val terminalMessage = intent.getStringExtra(EXTRA_TERMINAL_MESSAGE)

        tv_what_to_do_next_instructions.text = terminalMessage

        val colorRes = if (isPositive) R.color.positive else R.color.negative
        root_view_results.setBackgroundColor(ResourcesCompat.getColor(resources, colorRes, null))

        val status = if (isPositive) getString(R.string.positive) else getString(R.string.negative)
        tv_your_status.text = status
    }

    companion object {

        private const val EXTRA_IS_POSITIVE = "is_negative"
        private const val EXTRA_TERMINAL_MESSAGE = "terminal_message"

        fun startActivity(context: Context, isPositive: Boolean, terminalMessage: String) {
            val intent = Intent(context, ResultsActivity::class.java)
            intent.putExtra(EXTRA_IS_POSITIVE, isPositive)
            intent.putExtra(EXTRA_TERMINAL_MESSAGE, terminalMessage)
            context.startActivity(intent)
        }
    }
}
