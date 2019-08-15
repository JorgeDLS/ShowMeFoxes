package jdls.one.showmefoxes.framework.datasource

import io.reactivex.Single
import jdls.one.data.repository.FoxRemoteDataSource
import jdls.one.domain.model.Fox
import jdls.one.showmefoxes.framework.api.FoxApi

class FoxApiDataSource(private val foxApi: FoxApi) : FoxRemoteDataSource {
  override fun getRandomFox(): Single<Fox> = foxApi.service.getRandomFox().map { it.mapToDomain() }
}