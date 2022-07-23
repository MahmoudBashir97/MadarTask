package com.mahmoud_bashir.madartask.presentation.fragment.add

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.navigation.NavigationBarView
import com.mahmoud_bashir.madartask.R
import com.mahmoud_bashir.madartask.data.model.UserData
import com.mahmoud_bashir.madartask.databinding.FragmentAddDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDataFragment : Fragment(R.layout.fragment_add_data){

    lateinit var bd:FragmentAddDataBinding

    private var selectedGender:String? = null
    private var name:String?=null
    private var age:String?=null
    private var jobTitle:String?=null

    val addVM : AddFragmentViewModel by viewModels<AddFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentAddDataBinding.inflate(layoutInflater)


        return bd.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        spinnerOperation()

        bd.saveBtn.setOnClickListener {
            if (validateInputs()){
                val userData = UserData(
                    0,name,age!!.toInt(),jobTitle,selectedGender
                )
                val check = addVM.insertUserData(userData).isActive.and(isAdded)

                if (check) {
                    bd.edtName.setText("")
                    bd.edtAge.setText("")
                    bd.edtJobTitle.setText("")
                    bd.spinGender.setSelection(0)
                    showToastMsg("Added Successfully!")
                }
            }
        }
    }

    private fun validateInputs():Boolean{
        name = bd.edtName.text.toString()
        age = bd.edtAge.text.toString().toString()
        jobTitle = bd.edtJobTitle.text.toString()

        if (name == null || TextUtils.isEmpty(name)){
            bd.edtName.error = "please enter a valid name"
            bd.edtName.requestFocus()
            return false
        }else if (age == null || TextUtils.isEmpty(age)){
            bd.edtAge.error = "please enter a valid age"
            bd.edtAge.requestFocus()
            return false
        }else if (jobTitle == null || TextUtils.isEmpty(jobTitle)){
            bd.edtJobTitle.error = "please enter a valid job title"
            bd.edtJobTitle.requestFocus()
            return false
        }else if (selectedGender == null){
            showToastMsg("please select ur gender")
        }

        return true
    }

    private fun showToastMsg(s: String) {
        Toast.makeText(requireContext(),s,Toast.LENGTH_LONG).show()
    }

    private fun spinnerOperation() {
        val gender = resources.getStringArray(R.array.gender)
        bd.spinGender.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position>0) selectedGender = gender[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }
    }

    private fun initializeViews(){
        val spinAdapter = ArrayAdapter(
            requireContext(),android.R.layout.simple_list_item_1,resources.getStringArray(R.array.gender)
        )
        bd.spinGender.adapter = spinAdapter
    }
}