package com.learnig.android.app.feature.episodelistfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentEpisodeListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EpisodeListFragment : BaseFragment<FragmentEpisodeListBinding, EpisodeListViewModel>() {
    override val viewModelApp: EpisodeListViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEpisodeListBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance(): EpisodeListFragment {
            return EpisodeListFragment()
        }
    }

}
