package com.ubaya.adv160419095week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_result.*

class MainFragment : Fragment() {
    var result = 0
    var score = 0

    var rand1 = (0..99).random()
    var rand2 = (0..99).random()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = txtName.text
        btnSubmit.setOnClickListener {
            val action =MainFragmentDirections.actionGameFragment(name.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}