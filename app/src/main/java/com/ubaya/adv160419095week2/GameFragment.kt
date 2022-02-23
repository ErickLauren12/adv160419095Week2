package com.ubaya.adv160419095week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_result.*

class GameFragment : Fragment() {

    var result = 0
    var score = 0
    var name = ""
    var rand1 = (0..99).random()
    var rand2 = (0..99).random()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            name = GameFragmentArgs.fromBundle(requireArguments()).name
            textPlayer.text = "$name's Turn"
        }

        textQuestion.text = "$rand1 + $rand2"
        buttonSubmit.setOnClickListener {
            result = rand1 + rand2

            var answer = textAnswer.text.toString()

            if(answer != result.toString()){
                val action = GameFragmentDirections.actionResultFragment(score, name)
                Navigation.findNavController(it).navigate(action)
            }else{
                score += 1

                rand1 = (0..99).random()
                rand2 = (0..99).random()

                textAnswer.setText("")
                textQuestion.text = "$rand1 + $rand2"
            }
        }
    }
}