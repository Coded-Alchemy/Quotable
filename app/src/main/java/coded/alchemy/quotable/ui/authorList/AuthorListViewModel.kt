package coded.alchemy.quotable.ui.authorList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.quotable.data.AuthorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthorListViewModel(private val authorRepository: AuthorRepository) : ViewModel() {
    private val _authors = MutableStateFlow<List<Author>>(emptyList())
    val authors: StateFlow<List<Author>> = _authors

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        getAllAuthors()
    }

    private fun getAllAuthors() {
        viewModelScope.launch {
            try {
                _loading.value = true
                authorRepository.getAllAuthors().collect { authors ->
                    _authors.value = authors
                    _error.value = null
                }
            } catch (e: Exception) {
                _error.value = "Failed to fetch authors: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
