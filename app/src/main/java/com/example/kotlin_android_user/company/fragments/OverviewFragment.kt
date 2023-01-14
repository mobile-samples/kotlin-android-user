package com.example.kotlin_android_user.company.fragments;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_android_user.databinding.FragmentOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: FragmentOverviewBinding =
            FragmentOverviewBinding.inflate(inflater, container, false)
        binding.tvOverview.text = "Overview";
        return binding.root
    }
}
