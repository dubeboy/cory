package za.co.dubedivine.androidapps.cory.feature.shared

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.item_fragment_information.view.*
import za.co.dubedivine.androidapps.cory.R
import za.co.dubedivine.androidapps.cory.model.Information

class InformationRecyclerViewAdapter(private val coronaQuestionsAndAnswers: List<Information>) : RecyclerView.Adapter<InformationRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Information

            v.tv_imformation_body.visibility = if( v.tv_imformation_body.visibility == View.GONE) {
                item.isVisible = true
                View.VISIBLE
            } else {
                item.isVisible = false
                View.GONE
            }

            v.img_chevron.setImageDrawable(ResourcesCompat.getDrawable(v.resources, if( v.tv_imformation_body.visibility == View.GONE) R.drawable.ic_keyboard_arrow_up else R.drawable.ic_arrow_down, null))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fragment_information, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = coronaQuestionsAndAnswers[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = coronaQuestionsAndAnswers.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cardTitle: TextView = view.tv_information_header
        private val cardBody: TextView = view.tv_imformation_body

        fun bind(item: Information) {
            cardTitle.text = item.title
            cardBody.text = item.information

            cardBody.visibility = if(item.isVisible) View.VISIBLE else View.GONE

            with(itemView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }
        }
    }
}
