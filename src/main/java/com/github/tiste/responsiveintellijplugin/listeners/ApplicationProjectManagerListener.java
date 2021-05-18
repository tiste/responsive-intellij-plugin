package com.github.tiste.responsiveintellijplugin.listeners;

import com.github.tiste.responsiveintellijplugin.services.WindowProjectService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ApplicationProjectManagerListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        ProjectManagerListener.super.projectOpened(project);

        StartupManager.getInstance(project).runAfterOpened(() -> {
            WindowManager.getInstance().getIdeFrame(project).getComponent().addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    WindowProjectService.getInstance().updateFontForSize(e.getComponent().getWidth());
                }
            });
        });
    }
}
