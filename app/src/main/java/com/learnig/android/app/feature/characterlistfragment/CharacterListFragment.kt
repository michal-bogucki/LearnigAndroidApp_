package com.learnig.android.app.feature.characterlistfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterListFragment :
    BaseFragment<FragmentCharactersListBinding, CharacterListViewModel>() {
    override val viewModelApp: CharacterListViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharactersListBinding.inflate(inflater, container, false)


    companion object {
        fun newInstance(): CharacterListFragment {
            return CharacterListFragment()
        }
    }

}
