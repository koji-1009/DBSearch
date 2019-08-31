package com.app.dr1009.dbsearch

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.app.dr1009.dbsearch.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject

class AddWordDialog : DaggerAppCompatDialogFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setContentView(R.layout.dialog_add_word)

        val editText = dialog.findViewById<EditText>(R.id.edit_text)
        val buttonOk = dialog.findViewById<Button>(R.id.button_ok)
        buttonOk.setOnClickListener {
            viewModel.addWord(editText.text.toString())
            dismiss()
        }

        return dialog
    }
}