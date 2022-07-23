package com.mahmoud_bashir.madartask.presentation.fragment.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahmoud_bashir.madartask.databinding.FragmentSavedBinding
import com.mahmoud_bashir.madartask.presentation.base.BaseFragment
import com.mahmoud_bashir.madartask.presentation.fragment.saved.view.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedDataFragment:BaseFragment(){

    lateinit var bd:FragmentSavedBinding
    val savedVM : SavedFragmentViewModel by viewModels<SavedFragmentViewModel>()
    private lateinit var user_Adpt: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentSavedBinding.inflate(layoutInflater)

        return bd.root
    }

    override fun initEvent() {
        //
    }

    override fun initObservers() {
        savedVM.userDataList.observe(viewLifecycleOwner){userList ->
            if (userList != null ){
                bd.proBar.visibility = View.GONE
                bd.recUser.visibility = View.VISIBLE
                user_Adpt.differ.submitList(userList)
            }
        }
    }

    override fun initLoading() {
        bd.proBar.visibility = View.VISIBLE
        initializeViews()
    }

    private fun initializeViews() {
        user_Adpt = UserAdapter()
        bd.recUser.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = user_Adpt
        }
    }

    override fun initErrorObserver() {
       savedVM.userErrorState.observe(viewLifecycleOwner){errorMsg->
           showToastMsg(errorMsg)
       }
    }
    private fun showToastMsg(s:String){
        Toast.makeText(requireContext(),s,Toast.LENGTH_LONG).show()
    }
}