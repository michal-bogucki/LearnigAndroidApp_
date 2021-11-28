package com.learnig.android.app.feature.characterlistfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.learnig.android.app.R
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.data.remoteapi.State
import com.learnig.android.app.databinding.FragmentCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_characters_list.*


@AndroidEntryPoint
class CharacterListFragment :
    BaseFragment<FragmentCharactersListBinding, CharacterListViewModel>() {
    override val viewModelApp: CharacterListViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharactersListBinding.inflate(inflater, container, false)


    private val adapter = CharacterAdapter { character ->
        openDetailsFragment(character.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModelApp.getCharacterList()

    }

    override fun onStart() {
        super.onStart()
        observePost()
    }

    private fun initView() {
        binding?.run {
            characterRecycler.adapter = adapter
            characterRecycler.layoutManager = GridLayoutManager(context, 1)
            changeLayoutManager.setOnClickListener {
                val gridLayoutManager = characterRecycler.layoutManager as GridLayoutManager
                gridLayoutManager.spanCount = if (gridLayoutManager.spanCount == 2) 1 else 2
            }
        }

    }


    private fun observePost() {

        viewModelApp.characterList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Loading -> showLoading(true)
                is State.Success -> {
                    if (state.data.isNotEmpty()) {
                        adapter.submitList(state.data)
                        showLoading(false)
                    }
                }
                is State.Error -> {
                    showToast(state.message)
                    showLoading(false)
                }
            }
        }
    }

    private fun openDetailsFragment(characterId: Int) {
        val bundle = Bundle().apply {
            putSerializable("characterId", characterId)
        }
        findNavController().navigate(R.id.action_characterListFragment_to_characterFragment, bundle)
    }

    private fun showLoading(isLoading: Boolean) {
        when (isLoading) {
            true -> progressBar.visibility = VISIBLE
            false -> progressBar.visibility = GONE
        }
    }

    companion object {
        fun newInstance(): CharacterListFragment {
            return CharacterListFragment()
        }
    }

}
