package uz.gita.users_app.diimport android.content.Contextimport com.chuckerteam.chucker.api.ChuckerInterceptorimport dagger.Moduleimport dagger.Providesimport dagger.hilt.InstallInimport dagger.hilt.android.qualifiers.ApplicationContextimport dagger.hilt.components.SingletonComponentimport okhttp3.OkHttpClientimport retrofit2.Retrofitimport retrofit2.converter.gson.GsonConverterFactoryimport uz.gita.users_app.data.source.remote.api.UsersApiimport uz.gita.users_app.utils.Constants.BASE_URLimport javax.inject.Singleton@Module@InstallIn(SingletonComponent::class)class NetworkModule {    @[Provides Singleton]    fun okHttpClient(@ApplicationContext context: Context): OkHttpClient =        OkHttpClient.Builder()            .addInterceptor(                ChuckerInterceptor.Builder(context)                    .build()            ).build()    @[Provides Singleton]    fun myRetrofit(okHttpClient: OkHttpClient): Retrofit =        Retrofit.Builder()            .client(okHttpClient)            .baseUrl(BASE_URL)            .addConverterFactory(GsonConverterFactory.create())            .build()    @[Provides]    fun myApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)}