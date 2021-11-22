package com.learnig.android.app.feature.locationfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>() {
    override val viewModelApp: LocationViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLocationBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance(): LocationFragment {
            return LocationFragment()
        }
    }

}
