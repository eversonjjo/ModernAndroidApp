package me.fleka.modernandroidapp

import android.databinding.ObservableField
import me.fleka.modernandroidapp.data.OnDataReadyCallback
import me.fleka.modernandroidapp.data.RepoModel

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class MainViewModel {
    var repoModel: RepoModel = RepoModel()

    val text = ObservableField<String>()

    var isLoading = ObservableField<Boolean>()

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)
        }
    }

    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(onDataReadyCallback)
    }
}