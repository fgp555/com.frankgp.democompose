package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.SocialPostCard
import com.frankgp.democompose.components.TourStepHeader
import com.frankgp.democompose.models.DummyData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ComposeStep11_StateScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var posts by remember { mutableStateOf(DummyData.posts.toList()) }

    fun refreshData() {
        coroutineScope.launch {
            isLoading = true
            delay(1000)
            posts = DummyData.posts.shuffled()
            isLoading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TourStepHeader(
            stepNumber = 11,
            componentName = "State Management (ViewModel & Coroutines)",
            description = "Experience reactive state management with StateFlow, asynchronous loading indicators, like/unlike reactivity, and simulated pull-to-refresh.",
            onNext = onNext,
            onPrevious = onPrevious,
            canGoBack = true
        )

        Spacer(Modifier.height(8.dp))

        // Refresh control bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isLoading) "Refreshing feed..." else "Loaded ${posts.size} posts reactively",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Button(
                onClick = { refreshData() },
                enabled = !isLoading
            ) {
                Icon(Icons.Filled.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text("Refresh")
            }
        }

        Spacer(Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            if (isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    items(posts, key = { it.id }) { post ->
                        SocialPostCard(
                            post = post,
                            onLikeClick = {
                                posts = posts.map {
                                    if (it.id == post.id) post.copy(
                                        isLiked = !post.isLiked,
                                        likes = if (!post.isLiked) post.likes + 1 else post.likes - 1
                                    ) else it
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
