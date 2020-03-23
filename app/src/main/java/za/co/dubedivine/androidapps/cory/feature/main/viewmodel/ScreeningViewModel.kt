package za.co.dubedivine.androidapps.cory.feature.main.viewmodel

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.ConfigurationCompat
import za.co.dubedivine.androidapps.cory.model.ScreeningQuestion
import za.co.dubedivine.androidapps.cory.model.screeningdecisiontree.ScreeningNode
import za.co.dubedivine.androidapps.cory.repository.local.ScreeningQuestionsRepository


class ScreeningViewModel(private val context: Context) {

    private var decisionTree: ScreeningNode? =
        ScreeningQuestionsRepository.screeningQuestionsDecisionTree()

    val question: ScreeningQuestion? = decisionTree?.parent
    fun terminalMessage(answer: Boolean) = decisionTree?.terminalMessage(answer) ?: ""


    fun nextQuestion(answer: Boolean): ScreeningQuestion? {
        val nextNode = decisionTree?.nextNode(answer)
        decisionTree = nextNode  // should be in ADT mananger
        return nextNode?.parent
    }

    fun canContinue(answer: Boolean) = decisionTree?.isTerminal(answer) == false

    fun getOpenWHatsAppIntent(): Intent? {

        if (!isWhatsappInstalled()) return null

        val number = when {
            getCountry() == "ZA" -> {
                "27600123456"
            }
            else -> {
                "41225017596"
            }
        }

        val sendIntent = Intent("android.intent.action.MAIN")
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        sendIntent.putExtra("jid", "$number@s.whatsapp.net")
        sendIntent.setPackage("com.whatsapp")
        return sendIntent
    }

    fun isWhatsappInstalled(): Boolean {
        return try {
            context.packageManager.getPackageInfo("com.whatsapp", 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun getCountry() =
        ConfigurationCompat.getLocales(context.resources.configuration)[0].country

    fun getDialZAHotlineIntent(): Intent? {
        return if(getCountry() == "ZA") Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0800029999")) else null
    }
}