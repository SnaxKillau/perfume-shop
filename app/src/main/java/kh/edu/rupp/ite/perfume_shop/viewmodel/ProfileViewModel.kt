package kh.edu.rupp.ite.perfume_shop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kh.edu.rupp.ite.perfume_shop.api.model.Profile


class ProfileViewModel : ViewModel() {

    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile> = _profileData

    fun fetchProfileData() {
        val profile = Profile("John Doe", "johndoe@example.com")
        _profileData.value = profile
    }
}