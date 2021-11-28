package com.learnig.android.app.feature.characterfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.learnig.android.app.base.BaseFragment
import com.learnig.android.app.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {
    private val args: CharacterFragmentArgs by navArgs()
    override val viewModelApp: CharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharactersBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        viewModelApp.getCharacter(args.characterId)


    }

    private fun observe() {
        viewModelApp.character.observe(viewLifecycleOwner) { character ->
            binding?.let {
                it.characterName.text = character.name
                Glide.with(requireContext()).load(character.image).into(it.characterImage)
            }
        }
    }

    companion object {
        fun newInstance(): CharacterFragment {
            return CharacterFragment()
        }
    }


}
