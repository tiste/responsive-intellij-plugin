package com.github.tiste.responsiveintellijplugin.services;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.WindowManager;

import java.awt.*;

public class WindowProjectService {

    public int getCurrentProjectWidth() {
        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        Project activeProject = null;
        for (Project project : projects) {
            Window window = WindowManager.getInstance().suggestParentWindow(project);
            if (window != null && window.isActive()) {
                activeProject = project;
            }
        }

        assert activeProject != null;
        return FileEditorManager.getInstance(activeProject).getSelectedTextEditor().getComponent().getWidth();
    }

    public static WindowProjectService getInstance() {
        return ServiceManager.getService(WindowProjectService.class);
    }
}
