package jdls.one.data.repository

import io.reactivex.Single
import jdls.one.domain.model.Fox
import jdls.one.domain.repository.FoxRepository

class FoxDataRepository(
  private val remoteDataSource: FoxRemoteDataSource,
  private val localDataSource: FoxLocalDataSource
) : FoxRepository {

  override fun getSavedFoxes(): List<Fox> = localDataSource.getSavedFoxes()

  override fun getFox(): Single<List<Fox>> {
    return remoteDataSource.getRandomFox().toObservable()
      .doOnNext { fox -> localDataSource.saveFox(fox) }
      .map { localDataSource.getSavedFoxes() }
      .singleOrError()
  }
}

interface FoxLocalDataSource {
  fun getSavedFoxes(): List<Fox>
  fun saveFox(fox: Fox)
}

interface FoxRemoteDataSource {
  fun getRandomFox(): Single<Fox>
}