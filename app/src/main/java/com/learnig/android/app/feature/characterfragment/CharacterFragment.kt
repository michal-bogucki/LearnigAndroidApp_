package com.learnig.android.app.feature.characterfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.learnig.android.app.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : Fragment() {
    private val viewModel: CharacterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_calibration_dialog, container, false)
        return inflate
    }

    companion object {
        fun newInstance(): CharacterFragment {
            return CharacterFragment()
        }
    }

}