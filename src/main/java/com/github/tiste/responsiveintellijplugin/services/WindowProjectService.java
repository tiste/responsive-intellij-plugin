package com.github.tiste.responsiveintellijplugin.services;

import com.github.tiste.responsiveintellijplugin.settings.ApplicationState;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.WindowManager;

import java.awt.*;

public class WindowProjectService {
    public static WindowProjectService getInstance() {
        return ServiceManager.getService(WindowProjectService.class);
    }

    public int getCurrentProjectWidth() {
        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        Project activeProject = null;
        for (Project project : projects) {
            Window window = WindowManager.getInstance().suggestParentWindow(project);
            if (window != null && window.isActive()) {
                activeProject = project;
            }
        }

        try {
            return WindowManager.getInstance().getIdeFrame(activeProject).getComponent().getWidth();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void updateFontForSize(int width) {
        ApplicationState settings = ApplicationState.getInstance();
        ApplicationEditorFontPreferences applicationEditorFontPreferences = ApplicationEditorFontPreferences.getInstance();

        int fontSize = settings.findBreakpointValue(width);
        applicationEditorFontPreferences.setFontSize(fontSize);
    }
}
