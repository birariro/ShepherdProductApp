package com.example.shepherdproduct

import com.example.shepherdproduct.layer_data.CommonProductRepository
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class ViewModelModule {

    //use case
    @Provides
    fun provideSearchUseCase(productRepository: ProductRepository) : SearchUseCase {
        return SearchUseCase(productRepository)
    }

    //REPOSITORY
    @Provides
    fun provideProductRepository() : ProductRepository {
        return CommonProductRepository()
    }
}