package com.example.kotlin_android_user.company.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class PostRateFragment(val name: String) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(name)
            .create()

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }
}
