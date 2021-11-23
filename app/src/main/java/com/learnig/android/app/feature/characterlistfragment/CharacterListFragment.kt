package com.learnig.android.app.feature.characterlistfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.data.remoteapi.State
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



    private val adapter = CharacterAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModelApp.getCharacterList()

    }

    private fun initView() {
        binding?.run {
            characterRecycler.adapter = adapter
            characterRecycler.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onStart() {
        super.onStart()
        observePost()
    }

    private fun observePost() {

        viewModelApp.characterList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Loading -> showLoading(true)
                is State.Success -> {
                    if (state.data.isNotEmpty()) {
                        adapter.submitList(state.data)
                        //showLoading(false)
                    }
                }
                is State.Error -> {
                    //showToast(state.message)
                   // showLoading(false)
                }
            }

        }

    }

    private fun showLoading(isLoading: Boolean) {

    }

    companion object {
        fun newInstance(): CharacterListFragment {
            return CharacterListFragment()
        }
    }

}
