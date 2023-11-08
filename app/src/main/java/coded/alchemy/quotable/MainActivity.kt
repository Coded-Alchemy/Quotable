package coded.alchemy.quotable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import coded.alchemy.quotable.di.appModule
import coded.alchemy.quotable.ui.app.QuotableApp
import coded.alchemy.quotable.ui.theme.QuotableTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        insertKoin()
        displayComposable()
    }

    private fun insertKoin() {
        GlobalContext.startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule)
        }
    }

    private fun displayComposable() {
        setContent {
            QuotableTheme {
                QuotableApp()
            }
        }
    }
}
