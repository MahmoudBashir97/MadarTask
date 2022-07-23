package com.mahmoud_bashir.madartask.presentation.fragment.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahmoud_bashir.madartask.R
import com.mahmoud_bashir.madartask.databinding.FragmentAddDataBinding

class AddDataFragment : Fragment(R.layout.fragment_add_data){

    lateinit var bd:FragmentAddDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentAddDataBinding.inflate(layoutInflater)

        return bd.root
    }
}