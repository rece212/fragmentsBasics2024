package com.cat.fragmentsbasics2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val layout = inflater.inflate(R.layout.fragment_second,container,false)
        val editText : EditText = layout.findViewById(R.id.txtInput)
        val button: Button = layout.findViewById(R.id.btnFrag2)
        val textView :TextView = layout.findViewById(R.id.lblOutput)

        button.setOnClickListener {
            textView.text = editText.text
        }
        return layout
    }

}