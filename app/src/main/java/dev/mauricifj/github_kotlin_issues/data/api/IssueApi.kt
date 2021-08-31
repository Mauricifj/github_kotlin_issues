package dev.mauricifj.github_kotlin_issues.data.api

import com.squareup.moshi.Json
import dev.mauricifj.github_kotlin_issues.data.model.IssueResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

// TODO: ADD FILTERS AND PAGINATION

interface IssueApi {
    @GET("issues")
    fun getIssues(
        @Query("state") state: IssueState,
//        @Query("per_page") perPage: Int, // MAX: 100, DEFAULT: 30,
//        @Query("page") page: Int,
    ): Observable<List<IssueResponse>>
}

enum class IssueState(val value: String) {
    @Json(name = "open")
    Open("open"),

    @Json(name = "closed")
    Closed("closed"),

    @Json(name = "all")
    All("all")
}