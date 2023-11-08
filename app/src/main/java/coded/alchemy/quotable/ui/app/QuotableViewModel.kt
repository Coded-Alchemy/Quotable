package coded.alchemy.quotable.ui.app

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class QuotableViewModel: ViewModel() {
    protected val _loading = MutableStateFlow(false)
    protected val loading: StateFlow<Boolean> = _loading

    protected val _error = MutableStateFlow<String?>(null)
    protected val error: StateFlow<String?> = _error
}