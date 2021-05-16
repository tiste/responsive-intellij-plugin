package com.github.tiste.responsiveintellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
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
        settingsComponent = new ApplicationSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ApplicationSettingsState settings = ApplicationSettingsState.getInstance();
        HashMap<Number, Number> compare = new HashMap();
        compare.put(settingsComponent.getFirstBreakpoint(), settingsComponent.getFirstFontSize());
        compare.put(settingsComponent.getSecondBreakpoint(), settingsComponent.getSecondFontSize());
        boolean modified = !compare.equals(settings.breakpoints);
        return modified;
    }

    @Override
    public void apply() throws ConfigurationException {
        ApplicationSettingsState settings = ApplicationSettingsState.getInstance();
        settings.breakpoints.clear();
        settings.breakpoints.put(settingsComponent.getFirstBreakpoint(), settingsComponent.getFirstFontSize());
        settings.breakpoints.put(settingsComponent.getSecondBreakpoint(), settingsComponent.getSecondFontSize());
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
