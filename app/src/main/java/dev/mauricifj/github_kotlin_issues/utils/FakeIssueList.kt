package dev.mauricifj.github_kotlin_issues.utils

import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue

fun fakeIssueList() = listOf(
    Issue(
        id = "123456",
        title = "It's not working on my pc",
        state = IssueState.Open,
        description = "I tried to restart but it still doesn't work",
        avatar = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMIAAADCBAMAAADpzwACAAAAHlBMVEUAAAD///8fHx9fX1/f39+fn5+/v79/f38/Pz87OzuSAa7GAAAACXBIWXMAAA7EAAAOxAGVKw4bAAABMklEQVR4nO3SvU/CQBiA8ZcKqeNxKul4JwYdS9I481EDI4lEHQtEZMSPGEbrR2D1P7YHJi46tZ18fpfecMM9ubuKAAAAAAAAAAAAAAAAAPgv7o2bK6aErT2VTVYObGkFWWafL9ovsmCj/jhsdRdWrBf0lB+Htlr/zDpxaloNcydR7kLSXqnbzdgVGg8qetPW09ktRZuJGayTZ7nOXTDW6KXY7Rk8NZMbK64wk7SZSM/KMHchG3rvqusKylM9t+IKWuxpvR5UX1UhhfHKfhf0T6HSnB6b2uOokEIgqZXUFYay2BUWkp51ZLo/DwspDJrdk3DiCk/rzrYwOjfZS38kcpg3sCu8X7Qu47Yr1OKXbUH7cdv9rTLPXfgjW7a09MJR6QVTegEAAAAAAAAAAAAAAOBXXxvuKzgie3AYAAAAAElFTkSuQmCC",
        createdAt = "020-08-19T10:00:00Z",
        url = "https://github.com/JetBrains/kotlin/pull/123456",
        user = "mauricifj"
    ),
    Issue(
        id = "654321",
        title = "There are 10 types of people in the world",
        state = IssueState.Closed,
        description = "Those who understand binary and those who don't",
        avatar = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMIAAADCBAMAAADpzwACAAAAHlBMVEUAAAD///8fHx9fX1/f39+fn5+/v79/f38/Pz87OzuSAa7GAAAACXBIWXMAAA7EAAAOxAGVKw4bAAABMklEQVR4nO3SvU/CQBiA8ZcKqeNxKul4JwYdS9I481EDI4lEHQtEZMSPGEbrR2D1P7YHJi46tZ18fpfecMM9ubuKAAAAAAAAAAAAAAAAAPgv7o2bK6aErT2VTVYObGkFWWafL9ovsmCj/jhsdRdWrBf0lB+Htlr/zDpxaloNcydR7kLSXqnbzdgVGg8qetPW09ktRZuJGayTZ7nOXTDW6KXY7Rk8NZMbK64wk7SZSM/KMHchG3rvqusKylM9t+IKWuxpvR5UX1UhhfHKfhf0T6HSnB6b2uOokEIgqZXUFYay2BUWkp51ZLo/DwspDJrdk3DiCk/rzrYwOjfZS38kcpg3sCu8X7Qu47Yr1OKXbUH7cdv9rTLPXfgjW7a09MJR6QVTegEAAAAAAAAAAAAAAOBXXxvuKzgie3AYAAAAAElFTkSuQmCC",
        createdAt = "020-08-19T12:00:00Z",
        url = "https://github.com/JetBrains/kotlin/pull/654321",
        user = "mauricifj"
    ),
    Issue(
        id = "987654",
        title = "Whats the object-oriented way to become wealthy?",
        state = IssueState.Open,
        description = "Inheritance",
        avatar = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMIAAADCBAMAAADpzwACAAAAHlBMVEUAAAD///8fHx9fX1/f39+fn5+/v79/f38/Pz87OzuSAa7GAAAACXBIWXMAAA7EAAAOxAGVKw4bAAABMklEQVR4nO3SvU/CQBiA8ZcKqeNxKul4JwYdS9I481EDI4lEHQtEZMSPGEbrR2D1P7YHJi46tZ18fpfecMM9ubuKAAAAAAAAAAAAAAAAAPgv7o2bK6aErT2VTVYObGkFWWafL9ovsmCj/jhsdRdWrBf0lB+Htlr/zDpxaloNcydR7kLSXqnbzdgVGg8qetPW09ktRZuJGayTZ7nOXTDW6KXY7Rk8NZMbK64wk7SZSM/KMHchG3rvqusKylM9t+IKWuxpvR5UX1UhhfHKfhf0T6HSnB6b2uOokEIgqZXUFYay2BUWkp51ZLo/DwspDJrdk3DiCk/rzrYwOjfZS38kcpg3sCu8X7Qu47Yr1OKXbUH7cdv9rTLPXfgjW7a09MJR6QVTegEAAAAAAAAAAAAAAOBXXxvuKzgie3AYAAAAAElFTkSuQmCC",
        createdAt = "020-08-19T14:00:00Z",
        url = "https://github.com/JetBrains/kotlin/pull/987654",
        user = "mauricifj"
    ),
    Issue(
        id = "456789",
        title = "How many programmers does it take to change a light bulb?",
        state = IssueState.Closed,
        description = "none, that's a hardware problem",
        avatar = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMIAAADCBAMAAADpzwACAAAAHlBMVEUAAAD///8fHx9fX1/f39+fn5+/v79/f38/Pz87OzuSAa7GAAAACXBIWXMAAA7EAAAOxAGVKw4bAAABMklEQVR4nO3SvU/CQBiA8ZcKqeNxKul4JwYdS9I481EDI4lEHQtEZMSPGEbrR2D1P7YHJi46tZ18fpfecMM9ubuKAAAAAAAAAAAAAAAAAPgv7o2bK6aErT2VTVYObGkFWWafL9ovsmCj/jhsdRdWrBf0lB+Htlr/zDpxaloNcydR7kLSXqnbzdgVGg8qetPW09ktRZuJGayTZ7nOXTDW6KXY7Rk8NZMbK64wk7SZSM/KMHchG3rvqusKylM9t+IKWuxpvR5UX1UhhfHKfhf0T6HSnB6b2uOokEIgqZXUFYay2BUWkp51ZLo/DwspDJrdk3DiCk/rzrYwOjfZS38kcpg3sCu8X7Qu47Yr1OKXbUH7cdv9rTLPXfgjW7a09MJR6QVTegEAAAAAAAAAAAAAAOBXXxvuKzgie3AYAAAAAElFTkSuQmCC",
        createdAt = "020-08-19T16:00:00Z",
        url = "https://github.com/JetBrains/kotlin/pull/456789",
        user = "mauricifj"
    ),
    Issue(
        id = "999999",
        title = "Why did the database administrator leave his wife?",
        state = IssueState.Closed,
        description = "She had one-to-many relationships",
        avatar = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMIAAADCBAMAAADpzwACAAAAHlBMVEUAAAD///8fHx9fX1/f39+fn5+/v79/f38/Pz87OzuSAa7GAAAACXBIWXMAAA7EAAAOxAGVKw4bAAABMklEQVR4nO3SvU/CQBiA8ZcKqeNxKul4JwYdS9I481EDI4lEHQtEZMSPGEbrR2D1P7YHJi46tZ18fpfecMM9ubuKAAAAAAAAAAAAAAAAAPgv7o2bK6aErT2VTVYObGkFWWafL9ovsmCj/jhsdRdWrBf0lB+Htlr/zDpxaloNcydR7kLSXqnbzdgVGg8qetPW09ktRZuJGayTZ7nOXTDW6KXY7Rk8NZMbK64wk7SZSM/KMHchG3rvqusKylM9t+IKWuxpvR5UX1UhhfHKfhf0T6HSnB6b2uOokEIgqZXUFYay2BUWkp51ZLo/DwspDJrdk3DiCk/rzrYwOjfZS38kcpg3sCu8X7Qu47Yr1OKXbUH7cdv9rTLPXfgjW7a09MJR6QVTegEAAAAAAAAAAAAAAOBXXxvuKzgie3AYAAAAAElFTkSuQmCC",
        createdAt = "020-08-19T16:00:00Z",
        url = "https://github.com/JetBrains/kotlin/pull/456789",
        user = "mauricifj"
    )
)