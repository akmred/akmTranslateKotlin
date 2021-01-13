package com.example.akmtranslatekotlin.iu.rus_eng

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.akmtranslatekotlin.R
import com.example.akmtranslatekotlin.iu.translate.ThreadTranslate


class Rus_engFragment : Fragment() {
    private var rus_engViewModel: Rus_engViewModel? = null
    var translateTextEng: TextView? = null
    var url =
        "https://api.cognitive.microsofttranslator.com" + "/translate?api-version=3.0&from=en&to=ru"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        rus_engViewModel = ViewModelProviders.of(this).get(Rus_engViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_rus_eng, container, false)
        val editText = root.findViewById<View>(R.id.editTextRus) as EditText
        translateTextEng = root.findViewById<View>(R.id.translateTextEng) as TextView
        editText.setOnKeyListener(View.OnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                val threadTranslate = ThreadTranslate(editText.text.toString(), "en", "ru")
                threadTranslate.start()
                try {
                    threadTranslate.join()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                translateTextEng!!.setText(threadTranslate.GetTextTranslate())
                return@OnKeyListener true
            }
            false
        })
        return root
    }

    companion object {
        private const val TAG = "myLogs"
        private val subscriptionKey = System.getenv("TRANSLATOR_TEXT_SUBSCRIPTION_KEY")
        private val endpoint = System.getenv("TRANSLATOR_TEXT_ENDPOINT")
    }
}
