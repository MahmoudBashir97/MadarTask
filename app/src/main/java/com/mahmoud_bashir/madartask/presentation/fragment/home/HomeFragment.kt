package com.mahmoud_bashir.madartask.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.mahmoud_bashir.madartask.R
import com.mahmoud_bashir.madartask.databinding.FragmentHomeBinding
import com.mahmoud_bashir.madartask.presentation.fragment.add.AddDataFragment
import com.mahmoud_bashir.madartask.presentation.fragment.saved.SavedDataFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment() , NavigationBarView.OnItemSelectedListener{

    lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        homeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected)
        homeBinding.bottomNavigationView.selectedItemId = R.id.add
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.add) {
            replacementFragments(AddDataFragment())
        } else if (id == R.id.saved) {
            replacementFragments(SavedDataFragment())
        }
        return true
    }

    private fun replacementFragments(fragment: Fragment) {
        try {
            val fragmentManager = childFragmentManager
            fragmentManager.beginTransaction().replace(homeBinding.mainFrame.id, fragment).commit()
        } catch (e: Exception) {
            e.message
        }
    }
}