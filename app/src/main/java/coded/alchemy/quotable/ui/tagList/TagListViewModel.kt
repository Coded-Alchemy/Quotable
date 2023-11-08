package coded.alchemy.quotable.ui.tagList

import androidx.lifecycle.ViewModel
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.data.TagRepository
import coded.alchemy.quotable.ui.app.QuotableViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TagListViewModel(private val tagRepository: TagRepository) : QuotableViewModel() {
    private val _tags = MutableStateFlow<List<Tag>>(emptyList())
    val tags: StateFlow<List<Tag>> = _tags
}