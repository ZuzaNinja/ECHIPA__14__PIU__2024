package com.example.proiectpiu_managementfinanciar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SelectionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adolescentRadioButton: RadioButton
    private lateinit var parentRadioButton: RadioButton
    private lateinit var registerButton: View
    private lateinit var authenticateButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        adolescentRadioButton = findViewById(R.id.adolescent_radio)
        parentRadioButton = findViewById(R.id.parent_radio)
        registerButton = findViewById(R.id.register_button)
        authenticateButton = findViewById(R.id.authenticate_button)
    }

    private fun setListeners() {
        registerButton.setOnClickListener(this)
        authenticateButton.setOnClickListener(this)

        findViewById<View>(R.id.adolescent_option).setOnClickListener(this)
        findViewById<View>(R.id.parent_option).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.adolescent_option -> {
                if (adolescentRadioButton.isChecked) {
                    adolescentRadioButton.isChecked = false
                    Toast.makeText(this, getString(R.string.adolescent_deselected), Toast.LENGTH_SHORT).show()
                } else {
                    adolescentRadioButton.isChecked = true
                    parentRadioButton.isChecked = false
                    Toast.makeText(this, getString(R.string.adolescent_selected), Toast.LENGTH_SHORT).show()
                }
            }
            R.id.parent_option -> {
                if (parentRadioButton.isChecked) {
                    parentRadioButton.isChecked = false
                    Toast.makeText(this, getString(R.string.parent_deselected), Toast.LENGTH_SHORT).show()
                } else {
                    parentRadioButton.isChecked = true
                    adolescentRadioButton.isChecked = false
                    Toast.makeText(this, getString(R.string.parent_selected), Toast.LENGTH_SHORT).show()
                }
            }
            R.id.register_button -> {
                if (!adolescentRadioButton.isChecked && !parentRadioButton.isChecked) {
                    Toast.makeText(this, getString(R.string.select_account_type), Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
            R.id.authenticate_button -> {
                if (!adolescentRadioButton.isChecked && !parentRadioButton.isChecked) {
                    Toast.makeText(this, getString(R.string.select_account_type), Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, AuthenticationActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
