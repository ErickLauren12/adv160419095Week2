package com.ubaya.adv160419095week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

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

        txtQuestion.text = "$rand1 + $rand2"
        btnSubmit.setOnClickListener {
            result = rand1 + rand2

            var answer = txtAnswer.text.toString()

            if(answer != result.toString()){
                val action = MainFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }else{
                score += 1

                rand1 = (0..99).random()
                rand2 = (0..99).random()

                txtAnswer.setText("")
                txtQuestion.text = "$rand1 + $rand2"
            }
        }
    }
}