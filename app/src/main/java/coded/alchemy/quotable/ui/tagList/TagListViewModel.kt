package coded.alchemy.quotable.ui.tagList

import androidx.lifecycle.viewModelScope
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.data.TagRepository
import coded.alchemy.quotable.ui.app.QuotableViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TagListViewModel(private val tagRepository: TagRepository) : QuotableViewModel() {
    private val _tags = MutableStateFlow<List<Tag>>(emptyList())
    val tags: StateFlow<List<Tag>> = _tags

    init {
        getAllTags()
    }

    private fun getAllTags() {
        viewModelScope.launch {
            try {
                _loading.value = true
                tagRepository.getAllTags().collect { authors ->
                    _tags.value = authors
                    _error.value = null
                }
            } catch (e: Exception) {
                _error.value = "Failed to fetch tags: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
