package com.frankgp.democompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankgp.democompose.models.DummyData
import com.frankgp.democompose.models.Post
import com.frankgp.democompose.models.Story
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SocialFeedViewModel : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _selectedPostIds = MutableStateFlow<Set<Int>>(emptySet())
    val selectedPostIds: StateFlow<Set<Int>> = _selectedPostIds.asStateFlow()

    private val _filterCategory = MutableStateFlow("All Posts")
    val filterCategory: StateFlow<String> = _filterCategory.asStateFlow()

    init {
        loadFeed()
    }

    fun loadFeed() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000) // Simulate network latency
            _posts.value = DummyData.posts.toList()
            _stories.value = DummyData.stories
            _isLoading.value = false
        }
    }

    fun refreshFeed() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(800)
            _posts.value = DummyData.posts.shuffled()
            _isLoading.value = false
        }
    }

    fun toggleLike(postId: Int) {
        _posts.value = _posts.value.map { post ->
            if (post.id == postId) {
                val newLiked = !post.isLiked
                val newLikes = if (newLiked) post.likes + 1 else post.likes - 1
                post.copy(isLiked = newLiked, likes = newLikes)
            } else {
                post
            }
        }
    }

    fun addNewPost(content: String) {
        if (content.isBlank()) return
        val newPost = Post(
            id = (System.currentTimeMillis() % 10000).toInt(),
            author = DummyData.currentUser,
            content = content,
            image = null,
            likes = 1,
            comments = 0,
            timestamp = "Just now",
            isLiked = true
        )
        _posts.value = listOf(newPost) + _posts.value
    }

    fun togglePostSelection(postId: Int) {
        val current = _selectedPostIds.value
        _selectedPostIds.value = if (current.contains(postId)) {
            current - postId
        } else {
            current + postId
        }
    }

    fun setFilterCategory(category: String) {
        _filterCategory.value = category
    }
}
