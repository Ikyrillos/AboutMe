package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val myName = MyName(name = "Kyrillos Maher")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View) {
binding.apply {
   myName?.nickName = nicknameEdit.text.toString()
    invalidateAll()
    binding.nicknameEdit.visibility = View.GONE
    view.visibility = View.GONE
    binding.nicknameText.visibility = View.VISIBLE
}


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
data class MyName (
    var name: String = "",
    var nickName : String = ""
)