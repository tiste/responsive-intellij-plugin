package com.github.tiste.responsiveintellijplugin.services

import com.github.tiste.responsiveintellijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
