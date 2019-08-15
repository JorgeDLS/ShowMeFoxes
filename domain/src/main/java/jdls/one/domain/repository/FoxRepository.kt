package jdls.one.domain.repository

import io.reactivex.Single
import jdls.one.domain.model.Fox

interface FoxRepository {
  fun getSavedFoxes(): List<Fox>

  fun getFox(): Single<List<Fox>>
}