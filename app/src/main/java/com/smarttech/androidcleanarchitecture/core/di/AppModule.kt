package com.smarttech.androidcleanarchitecture.core.di


import android.content.Context
import androidx.room.Room
import com.smarttech.androidcleanarchitecture.data.Remote.PostApi
import com.smarttech.androidcleanarchitecture.module.main.data.local.entity.PostDao
import com.smarttech.androidcleanarchitecture.data.local.PostDatabase
import com.smarttech.androidcleanarchitecture.domain.repository.PostRepository
import com.smarttech.androidcleanarchitecture.domain.repository.PostRepositoryImpl
import com.smarttech.androidcleanarchitecture.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostDatabase(@ApplicationContext context: Context): PostDatabase {
        return Room.databaseBuilder(context, PostDatabase::class.java, "post_db").build()
    }

    @Provides
    fun providePostDao(postDatabase: PostDatabase): PostDao {
        return postDatabase.postDao()
    }

    @Provides
    @Singleton
    fun providePostRepository(postDao: PostDao, postApi: PostApi): PostRepository {
        return PostRepositoryImpl(postDao, postApi)
    }

    @Provides
    @Singleton
    fun provideGetPostsUseCase(postRepository: PostRepository): GetPostsUseCase {
        return GetPostsUseCase(postRepository)
    }
}
