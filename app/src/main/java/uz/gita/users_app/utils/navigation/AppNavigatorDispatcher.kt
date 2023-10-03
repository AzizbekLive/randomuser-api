package uz.gita.users_app.utils.navigationimport android.util.Logimport kotlinx.coroutines.flow.MutableSharedFlowimport javax.inject.Injectimport javax.inject.Singleton@Singletonclass AppNavigatorDispatcher @Inject constructor() : AppNavigator, AppNavigatorHandler {    override val uiNavigator = MutableSharedFlow<NavigatorArgs>()    private suspend fun myNav(navigatorArgs: NavigatorArgs) {        uiNavigator.emit(navigatorArgs)    }    override suspend fun openWithSave(myScreen: MyScreen) = myNav {        push(myScreen)    }    override suspend fun openWithoutSave(myScreen: MyScreen) = myNav {        replace(myScreen)    }    override suspend fun back() = myNav {        pop()    }}