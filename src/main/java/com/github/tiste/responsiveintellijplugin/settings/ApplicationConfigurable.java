package com.github.tiste.responsiveintellijplugin.settings;

import com.github.tiste.responsiveintellijplugin.services.WindowProjectService;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.LinkedHashMap;

public class ApplicationConfigurable implements Configurable {
    private ApplicationComponent settingsComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Responsive";
    }

    @Override
    public @Nullable JComponent createComponent() {
        WindowProjectService windowProjectService = WindowProjectService.getInstance();
        settingsComponent = new ApplicationComponent(Integer.toString(windowProjectService.getCurrentProjectWidth()));
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ApplicationState settings = ApplicationState.getInstance();
        LinkedHashMap<Integer, Integer> compare = new LinkedHashMap();

        for (int i = 0; i < settingsComponent.textFields.length; i++) {
            compare.put(settingsComponent.getBreakpointAtPosition(i), settingsComponent.getFontSizeAtPosition(i));
        }

        return !compare.equals(settings.breakpoints);
    }

    @Override
    public void apply() {
        ApplicationState settings = ApplicationState.getInstance();
        settings.breakpoints.clear();

        for (int i = 0; i < settingsComponent.textFields.length; i++) {
            settings.breakpoints.put(settingsComponent.getBreakpointAtPosition(i), settingsComponent.getFontSizeAtPosition(i));
        }

        WindowProjectService.getInstance().updateFontForSize(WindowProjectService.getInstance().getCurrentProjectWidth());
    }

    @Override
    public void reset() {
        settingsComponent.reset();
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }
}
