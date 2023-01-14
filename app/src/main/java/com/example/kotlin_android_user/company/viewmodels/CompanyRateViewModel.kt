package com.example.kotlin_android_user.company.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.Resource
import com.example.kotlin_android_user.commons.models.SearchResult
import com.example.kotlin_android_user.company.repositories.CompanyRateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CompanyRateViewModel @Inject constructor(private val companyRateRepository: CompanyRateRepository):ViewModel() {
    private val _searchResult = MutableLiveData<SearchResult<Rates>?>()
    val searchResult:LiveData<SearchResult<Rates>?> = _searchResult
    fun search() = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(companyRateRepository.search()))
        }catch (exception:Exception){
            emit(Resource.error(null,exception.message))
        }
    }
    fun setSearchResult(res:SearchResult<Rates>?){
        _searchResult.value = res
    }
}