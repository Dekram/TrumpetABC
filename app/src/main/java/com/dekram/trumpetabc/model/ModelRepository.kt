package com.dekram.trumpetabc.model

interface ModelRepository {

    fun loadFingerings(): Int

    fun loadTones()

    fun loadNotesCards()
}