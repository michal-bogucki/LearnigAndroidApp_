package com.learnig.android.app.feature.episodefragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>() {
    override val viewModelApp: EpisodeViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEpisodeBinding.inflate(inflater, container, false)


    companion object {
        fun newInstance(): EpisodeFragment {
            return EpisodeFragment()
        }
    }

}
