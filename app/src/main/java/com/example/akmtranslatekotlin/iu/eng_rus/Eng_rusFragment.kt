package com.example.akmtranslatekotlin.iu.eng_rus

import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.akmtranslatekotlin.R

class Eng_rusFragment : Fragment() {
    private var eng_rusViewModel: Eng_rusViewModel? = null
    var editText: EditText? = null
    var translateTextRus: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        eng_rusViewModel = ViewModelProviders.of(this).get(Eng_rusViewModel::class.java)
        eng_rusViewModel
        return inflater.inflate(R.layout.fragment_eng_rus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitializationVariable()
        onCreateListening()
    }

    private fun onInitializationVariable() {
        editText = requireActivity().findViewById(R.id.editTextEng)
        translateTextRus = requireActivity().findViewById(R.id.translateTextRus)
        println(
            Settings.Secure.getString(
                requireActivity().contentResolver,
                Settings.Secure.DEFAULT_INPUT_METHOD
            )
        )
        val imeManage =
            requireActivity().applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //      imeManage.showInputMethodPicker();
        val methodInmput: List<*> = imeManage.getEnabledInputMethodSubtypeList()
        //imeManage.setInputMethod(null, "jp.co.omronsoft.openwnn/.OpenWnnJAJP");
    }

    private fun onCreateListening() {

        // вешаем слушатель на нажатие на ентер
        editText!!.setOnKeyListener(View.OnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                val strEditText = editText!!.text.toString()
                translateTextRus!!.text = strEditText
                return@OnKeyListener true
            }
            false
        })
    }
}