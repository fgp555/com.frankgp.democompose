package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.SocialPostCard
import com.frankgp.democompose.components.TourStepHeader
import com.frankgp.democompose.models.DummyData

@Composable
fun ComposeStep5_LazyColumnScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var posts by remember { mutableStateOf(DummyData.posts.toList()) }

    Column(modifier = Modifier.fillMaxSize()) {
        TourStepHeader(
            stepNumber = 5,
            componentName = "LazyColumn (Vertical List)",
            description = "LazyColumn efficiently renders vertically scrolling lists of items (like social media feeds) by only composing items currently visible on screen.",
            onNext = onNext,
            onPrevious = onPrevious,
            canGoBack = true
        )

        Spacer(Modifier.height(8.dp))

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
                            if (it.id == post.id) it.copy(
                                isLiked = !it.isLiked,
                                likes = if (!it.isLiked) it.likes + 1 else it.likes - 1
                            ) else it
                        }
                    }
                )
            }
        }
    }
}
