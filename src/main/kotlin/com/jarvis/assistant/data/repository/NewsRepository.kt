package com.jarvis.assistant.data.repository

import com.jarvis.assistant.data.api.NewsApiService
import com.jarvis.assistant.data.models.NewsArticle

class NewsRepository(private val newsService: NewsApiService) {
    suspend fun getTopHeadlines(country: String = "de", apiKey: String): List<NewsArticle>? {
        return try {
            val response = newsService.getTopHeadlines(country = country, apiKey = apiKey)
            response.articles
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
