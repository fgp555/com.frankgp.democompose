package com.frankgp.democompose.models

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val avatar: String, // placeholder identifier or URL
    val bio: String,
    val followerCount: Int
)

data class Post(
    val id: Int,
    val author: User,
    val content: String,
    val image: String? = null,
    var likes: Int,
    val comments: Int,
    val timestamp: String,
    var isLiked: Boolean = false
)

data class Story(
    val id: Int,
    val user: User,
    val image: String,
    val viewedTime: Long = System.currentTimeMillis()
)

object DummyData {
    val currentUser = User(
        id = 1,
        name = "Alex Johnson",
        username = "@alex_compose",
        avatar = "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde",
        bio = "Jetpack Compose enthusiast & Android developer 🚀",
        followerCount = 1420
    )

    val users = listOf(
        currentUser,
        User(2, "Sarah Connor", "@sarah_c", "https://images.unsplash.com/photo-1494790108377-be9c29b29330", "Building the future of UI.", 890),
        User(3, "Devon Lane", "@devon_dev", "https://images.unsplash.com/photo-1570295999919-56ceb5ecca61", "Kotlin lover. Coroutines wizard.", 2300),
        User(4, "Emily Watson", "@emily_w", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80", "Design systems & M3 architecture.", 540),
        User(5, "Michael Chen", "@mchen", "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d", "Open source contributor.", 1120)
    )

    val posts = mutableListOf(
        Post(
            id = 101,
            author = users[1],
            content = "Just explored Jetpack Compose LazyColumn and LazyRow! The performance and smooth scrolling are incredible compared to traditional RecyclerViews. What's your favorite layout component? ✨",
            image = "https://images.unsplash.com/photo-1555066931-4365d14bab8c",
            likes = 342,
            comments = 45,
            timestamp = "2h ago",
            isLiked = false
        ),
        Post(
            id = 102,
            author = users[2],
            content = "Material 3 dynamic color theming makes switching between dark and light mode so seamless in Compose. Loving the new design tokens!",
            image = "https://images.unsplash.com/photo-1517694712202-14dd9538aa97",
            likes = 128,
            comments = 12,
            timestamp = "4h ago",
            isLiked = true
        ),
        Post(
            id = 103,
            author = users[3],
            content = "Quick tip for state management: StateFlow + ViewModel keeps UI reactive and survives configuration changes effortlessly. 💡",
            image = null,
            likes = 512,
            comments = 89,
            timestamp = "6h ago",
            isLiked = false
        ),
        Post(
            id = 104,
            author = users[4],
            content = "Working on a responsive tablet layout using NavigationRail and multi-pane support. Compose makes adaptive UIs a breeze!",
            image = "https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5",
            likes = 230,
            comments = 19,
            timestamp = "1d ago",
            isLiked = false
        )
    )

    val stories = listOf(
        Story(1, users[1], "https://images.unsplash.com/photo-1555066931-4365d14bab8c"),
        Story(2, users[2], "https://images.unsplash.com/photo-1517694712202-14dd9538aa97"),
        Story(3, users[3], "https://images.unsplash.com/photo-1570295999919-56ceb5ecca61"),
        Story(4, users[4], "https://images.unsplash.com/photo-1438761681033-6461ffad8d80"),
        Story(5, users[0], "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d")
    )
}
