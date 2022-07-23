package com.mahmoud_bashir.madartask.presentation.fragment.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahmoud_bashir.madartask.R
import com.mahmoud_bashir.madartask.databinding.FragmentSavedBinding

class SavedDataFragment:Fragment(R.layout.fragment_saved) {

    lateinit var bd:FragmentSavedBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentSavedBinding.inflate(layoutInflater)

        return bd.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}