package jdls.one.domain.usecases

import io.reactivex.Single
import jdls.one.domain.model.Fox
import jdls.one.domain.repository.FoxRepository

class GetFox(private val foxRepository: FoxRepository) {
  operator fun invoke(): Single<List<Fox>> = foxRepository.getFox()
}