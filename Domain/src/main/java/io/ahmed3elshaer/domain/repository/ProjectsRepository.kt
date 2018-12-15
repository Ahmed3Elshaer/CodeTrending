package io.ahmed3elshaer.domain.repository

import io.ahmed3elshaer.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsRepository {

    fun getProjects(): Observable<MutableList<Project>>
    fun bookmarkProject(projectId: String): Completable
    fun unBookmarkProject(projectId: String): Completable
    fun getBookmarkedProjects(): Observable<MutableList<Project>>

}