package com.dragon.apps.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.dragon.apps.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val myName :MyName = MyName("Muhammad Saeed Abdullah")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val doneBtn :Button = findViewById(R.id.done_btn)
//        doneBtn.setOnClickListener{
//            addNickname(doneBtn)
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneBtn.setOnClickListener{
            addNickname(binding.doneBtn)
        }
    }

    private fun addNickname(doneBtn :Button)
    {

//        val editText :EditText = findViewById(R.id.nickname_editText)
//        val nicknameText :TextView = findViewById(R.id.nickname_text)
//
//        nicknameText.text = editText.text
//        editText.visibility = View.GONE
//        doneBtn.visibility = View.GONE
//        nicknameText.visibility = View.VISIBLE

//        binding.nicknameText.text = binding.nicknameEditText.text
//        binding.nicknameEditText.visibility = View.GONE
//        binding.doneBtn.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

        binding.apply {
//            nicknameText.text = nicknameEditText.text
            myName?.nickname = nicknameEditText.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            nicknameEditText.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        hideKeyboard(doneBtn)
    }

    private fun hideKeyboard(btn :Button)
    {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(btn.windowToken, 0)
    }
}