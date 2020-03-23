package za.co.dubedivine.androidapps.cory.feature.about.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_about.view.*

import za.co.dubedivine.androidapps.cory.R
import za.co.dubedivine.androidapps.cory.feature.about.viewmodel.AboutViewModel
import za.co.dubedivine.androidapps.cory.feature.information.viewmodel.InformationViewModel
import za.co.dubedivine.androidapps.cory.feature.shared.InformationRecyclerViewAdapter

class AboutFragment : Fragment() {

    private val viewModel =  AboutViewModel()

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        with(view.recyclerView_about) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = InformationRecyclerViewAdapter(viewModel.aboutAppInformation)
        }

        view.btn_rate_app.setOnClickListener {
            rateOnPlayStore()
        }

        return view
    }

    private fun rateOnPlayStore() {
        // todo open play store
    }
}
