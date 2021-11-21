package com.learnig.android.app.feature.characterfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {

    override val viewModelApp: CharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharactersBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance(): CharacterFragment {
            return CharacterFragment()
        }
    }



}
