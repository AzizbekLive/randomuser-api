package uz.gita.users_app.diimport dagger.Bindsimport dagger.Moduleimport dagger.hilt.InstallInimport dagger.hilt.components.SingletonComponentimport uz.gita.users_app.domain.usecase.UsersUseCaseimport uz.gita.users_app.domain.usecase.impl.UsersUseCaseImplimport javax.inject.Singleton@Module@InstallIn(SingletonComponent::class)interface UseCaseModule {    @[Binds Singleton]    fun bindsUseCase(impl: UsersUseCaseImpl): UsersUseCase}