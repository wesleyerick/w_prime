package com.wesleyerick.wprime.model

data class UpcomingBanners(
    val dates: Dates?,
    val page: Int?,
    val results: List<Banner>?,
    val total_pages: Int?,
    val total_results: Int?,
)
