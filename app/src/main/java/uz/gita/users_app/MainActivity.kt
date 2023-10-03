package uz.gita.users_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.users_app.presenter.screens.main.MainScreen
import uz.gita.users_app.ui.theme.WeatherAppTheme
import uz.gita.users_app.utils.navigation.AppNavigatorHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigatorHandler: AppNavigatorHandler

    @SuppressLint("FlowOperatorInvokedInComposition", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Navigator(MainScreen()) { navigator ->
                    appNavigatorHandler.uiNavigator.onEach {
                        it.invoke(navigator)
                    }.launchIn(lifecycleScope)
                    CurrentScreen()
                }
            }
        }
    }
}