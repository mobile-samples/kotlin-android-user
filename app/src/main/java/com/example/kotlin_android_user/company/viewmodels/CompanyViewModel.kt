package com.example.kotlin_android_user.company.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlin_android_user.company.models.Company
import com.example.kotlin_android_user.company.repositories.CompanyRepository
import com.example.kotlin_android_user.commons.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(private val companyRepository: CompanyRepository):ViewModel() {
    private val _company= MutableLiveData<Company>()

    val company:LiveData<Company> = _company;

    fun load(id:String) = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(companyRepository.load(id)))
        }catch (exception:Exception){
            emit(Resource.error(null, exception.message))
        }
    }
    fun setCompany(company: Company){
        _company.value = company
    }
}