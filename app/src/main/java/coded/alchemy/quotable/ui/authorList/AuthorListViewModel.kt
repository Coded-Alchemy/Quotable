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
    val authorsList: StateFlow<List<Author>> = _authors

    fun getAuthors() {
        viewModelScope.launch {
            val quotesFlow = authorRepository.getAllAuthorsFlow()
            quotesFlow.collect { authors ->
                _authors.value = listOf(authors)
            }
        }
    }
}
