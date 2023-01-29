package com.example.kotlin_android_user.company.fragments;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_android_user.company.repositories.CompanyRepository
import com.example.kotlin_android_user.company.repositories.impl.CompanyRepositoryImpl
import com.example.kotlin_android_user.databinding.FragmentAboutBinding

public class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAboutBinding.inflate(inflater, container, false).root;
    }
}
