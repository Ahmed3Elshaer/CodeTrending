package io.ahmed3elshaer.domain.interactor.browse

import io.ahmed3elshaer.domain.executor.PostExecutionThread
import io.ahmed3elshaer.domain.interactor.ObservableUseCase
import io.ahmed3elshaer.domain.model.Project
import io.ahmed3elshaer.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetProjects @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<MutableList<Project>, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<MutableList<Project>> {
        return projectsRepository.getProjects()
    }

}