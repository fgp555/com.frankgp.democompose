package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.SocialPostCard
import com.frankgp.democompose.components.StoryItemView
import com.frankgp.democompose.components.TourStepHeader
import com.frankgp.democompose.models.DummyData

@Composable
fun ComposeStep6_LazyRowScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    val stories = DummyData.stories
    val posts = DummyData.posts

    Column(modifier = Modifier.fillMaxSize()) {
        TourStepHeader(
            stepNumber = 6,
            componentName = "LazyRow (Horizontal List)",
            description = "LazyRow powers horizontal scrolling components like story carousels, category filters, and suggested friend profiles smoothly.",
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
            // Stories Header Section
            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Stories Carousel (LazyRow)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(12.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(stories) { story ->
                                StoryItemView(story = story)
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Feed Below Horizontal List",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            items(posts, key = { it.id }) { post ->
                SocialPostCard(post = post, onLikeClick = { })
            }
        }
    }
}
