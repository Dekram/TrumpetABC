package com.dekram.trumpetabc

interface MainContract {

    interface Presenter: BasePresenter {
        fun onViewCreated()
    }

    interface View: BaseView<Presenter> {
        fun displayMainActivity()

        fun displayFingerings()

        fun displayTones()

        fun displayNotesCards()
    }
}