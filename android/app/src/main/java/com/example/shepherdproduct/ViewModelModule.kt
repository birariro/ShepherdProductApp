package com.example.shepherdproduct

import com.example.shepherdproduct.layer_data.CommonProductRepository
import com.example.shepherdproduct.layer_data.datasource.RemoteDataSource
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.usecase.SearchUseCase
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ViewModelComponent::class)
@Module
class ViewModelModule {

    //use case
    @Provides
    fun provideSearchUseCase(productRepository: ProductRepository) : SearchUseCase {
        return SearchUseCase(productRepository)
    }

    //repository
    @Provides
    fun provideProductRepository(remoteDataSource: RemoteDataSource) : ProductRepository {
        return CommonProductRepository(remoteDataSource)
    }

    // data source
    @Provides
    fun provideRemoteDataSource(retrofit: Retrofit) : RemoteDataSource {
        return RemoteDataSource(retrofit)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        val RASE_URL = "http://apis.data.go.kr/1471000/"

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS).build()

        return Retrofit.Builder()
            .baseUrl(RASE_URL)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }
}