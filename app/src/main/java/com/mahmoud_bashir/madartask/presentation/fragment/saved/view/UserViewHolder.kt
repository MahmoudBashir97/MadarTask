package com.mahmoud_bashir.madartask.presentation.fragment.saved.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_bashir.madartask.data.model.UserData
import com.mahmoud_bashir.madartask.databinding.ViewItemUserDataBinding

class UserViewHolder(itemView: ViewItemUserDataBinding) : RecyclerView.ViewHolder(itemView.root) {
    lateinit var bd:ViewItemUserDataBinding
    fun bind(data:UserData){
        bd = ViewItemUserDataBinding.bind(itemView)
        bd.txtName.text = data.name
        bd.txtAge.text = "${data.age}"
        bd.txtJobTitle.text = data.jobTitle
    }
}