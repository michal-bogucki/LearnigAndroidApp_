package com.learnig.android.app.feature.locationlistfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentLocationListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocationListFragment : BaseFragment<FragmentLocationListBinding, LocationListViewModel>() {
    override val viewModelApp: LocationListViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLocationListBinding.inflate(inflater, container, false)


    companion object {
        fun newInstance(): LocationListFragment {
            return LocationListFragment()
        }
    }

}
