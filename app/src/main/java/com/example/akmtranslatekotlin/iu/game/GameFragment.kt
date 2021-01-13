package com.example.akmtranslatekotlin.iu.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.akmtranslatekotlin.R


class GameFragment : Fragment() {
    private var gameViewModel: GameViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_game, container, false)
        val textView = root.findViewById<TextView>(R.id.enterAnswer)
        gameViewModel!!.text.observe(viewLifecycleOwner,
            Observer<String?> { s -> textView.text = s })
        return root
    }
}
