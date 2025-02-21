package com.example.domain.usecase

import com.example.domain.model.Character
import com.example.domain.repository.CharacterRepository


class GetCharactersUseCase(private val repository: CharacterRepository) {
    suspend operator fun invoke(page: Int): List<Character> {
        return repository.getCharacters(page)
    }
}
