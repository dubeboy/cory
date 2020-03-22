package za.co.dubedivine.androidapps.cory.activity.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.dubedivine.androidapps.cory.R

import za.co.dubedivine.androidapps.cory.activity.information.dummy.DummyContent
import za.co.dubedivine.androidapps.cory.repository.local.InformationRepository
import za.co.dubedivine.androidapps.cory.viewmodel.InformationViewModel

class InformationFragment : Fragment() {

    private val viewModel = InformationViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_information_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter =
                    InformationRecyclerViewAdapter(
                        viewModel.coronaQuestionsAndAnswers()
                    )
            }
        }
        return view
    }
}
