package com.learnig.android.app.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    private var _binding: VB? = null
    private val binding get() = _binding

    protected abstract val viewModelApp: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  getViewBinding(inflater, container)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun applicationContext(): Context = requireActivity().applicationContext


    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    companion object {
        private const val TAG_PROGRESS_DIALOG = "progress_dialog"
        private const val TAG_ERROR_DIALOG = "error_dialog"
    }
}