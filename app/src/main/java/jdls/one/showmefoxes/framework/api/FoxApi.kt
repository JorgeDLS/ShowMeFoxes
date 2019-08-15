package jdls.one.showmefoxes.framework.api

import io.reactivex.Single
import jdls.one.showmefoxes.BuildConfig
import jdls.one.showmefoxes.framework.datasource.FoxEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


class FoxApi {

  private fun getOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      clientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    return clientBuilder.build()
  }

  var retrofit = Retrofit.Builder()
    .baseUrl("https://randomfox.ca/")
    .client(getOkHttpClient())
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

  var service = retrofit.create(FoxService::class.java)
}

interface FoxService {
  @GET("floof/")
  fun getRandomFox(): Single<FoxEntity>
}