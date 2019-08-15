package jdls.one.domain.usecases

import jdls.one.domain.model.Fox
import jdls.one.domain.repository.FoxRepository

class GetFoxes(private val foxRepository: FoxRepository) {
  operator fun invoke(): List<Fox> = foxRepository.getSavedFoxes()
}