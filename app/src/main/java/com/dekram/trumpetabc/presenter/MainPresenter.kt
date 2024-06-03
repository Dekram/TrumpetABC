package com.dekram.trumpetabc.presenter

import com.dekram.trumpetabc.MainContract
import com.dekram.trumpetabc.model.DependencyInjector

class MainPresenter(view: MainContract.View, dependencyInjector: DependencyInjector) :
    MainContract.Presenter {

    private val modelRepository = dependencyInjector.modelRepository()
    private var view: MainContract.View? = view

    private fun loadMainActivity() {
        view?.displayMainActivity()
    }

    fun loadFingerings() {
        view?.displayFingerings()
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadMainActivity()
    }
}