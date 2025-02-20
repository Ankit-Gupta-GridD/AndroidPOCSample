package com.example.domain.repository

import com.example.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(page: Int): List<Character>
}
