package com.example.dynamicedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.example.dynamicedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val fieldName = binding.fieldNameEdittext.text?.toString()
            if (!(fieldName != null && fieldName.isNotBlank())) {
                binding.fieldNameEdittext.error = ("Incorrect Field Name")
            } else {
                addField()
                clearInput()
            }
        }
    }

    private fun addField() {
        val fieldName = binding.fieldNameEdittext.text.toString()
        val checkNumber = binding.isNumericCheck.isChecked
        val fieldContainer = binding.fieldsContainer

        val newField = EditText(this).apply {
            hint = fieldName
            inputType = if (checkNumber) InputType.TYPE_CLASS_NUMBER else InputType.TYPE_CLASS_TEXT
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
        }
        fieldContainer.addView(newField)
    }

    private fun clearInput() {
        binding.fieldNameEdittext.text.clear()
        binding.isNumericCheck.isChecked = false
    }
}