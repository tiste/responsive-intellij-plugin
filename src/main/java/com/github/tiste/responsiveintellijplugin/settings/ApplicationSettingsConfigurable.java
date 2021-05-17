package com.github.tiste.responsiveintellijplugin.settings;

import com.github.tiste.responsiveintellijplugin.services.ApplicationEditorFontPreferences;
import com.github.tiste.responsiveintellijplugin.services.WindowProjectService;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;

public class ApplicationSettingsConfigurable implements Configurable {
    private ApplicationSettingsComponent settingsComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Responsive";
    }

    @Override
    public @Nullable JComponent createComponent() {
        WindowProjectService windowProjectService = WindowProjectService.getInstance();
        settingsComponent = new ApplicationSettingsComponent(Integer.toString(windowProjectService.getCurrentProjectWidth()));
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ApplicationSettingsState settings = ApplicationSettingsState.getInstance();
        HashMap<Integer, Integer> compare = new HashMap();
        compare.put(settingsComponent.getFirstBreakpoint(), settingsComponent.getFirstFontSize());
        compare.put(settingsComponent.getSecondBreakpoint(), settingsComponent.getSecondFontSize());
        return !compare.equals(settings.breakpoints);
    }

    @Override
    public void apply() {
        ApplicationSettingsState settings = ApplicationSettingsState.getInstance();
        settings.breakpoints.clear();
        settings.breakpoints.put(settingsComponent.getFirstBreakpoint(), settingsComponent.getFirstFontSize());
        settings.breakpoints.put(settingsComponent.getSecondBreakpoint(), settingsComponent.getSecondFontSize());

        ApplicationEditorFontPreferences applicationEditorFontPreferences = ApplicationEditorFontPreferences.getInstance();
        applicationEditorFontPreferences.setFontSize(settingsComponent.getFirstFontSize());
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
