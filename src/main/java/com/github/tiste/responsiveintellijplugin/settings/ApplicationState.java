package com.github.tiste.responsiveintellijplugin.settings;

import com.github.tiste.responsiveintellijplugin.services.ApplicationEditorFontPreferences;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

@State(
        name = "com.github.tiste.responsiveintellijplugin.settings.ApplicationState",
        storages = {@Storage("ResponsiveSettingsPlugin.xml")}
)
public class ApplicationState implements PersistentStateComponent<ApplicationState> {
    public LinkedHashMap<Integer, Integer> breakpoints = new LinkedHashMap();

    @Nullable
    @Override
    public ApplicationState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ApplicationState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static ApplicationState getInstance() {
        return ServiceManager.getService(ApplicationState.class);
    }

    public int findBreakpointValue(int windowSize) {
        int minDistance = Integer.MAX_VALUE;
        int closerBreakpoint = 0;

        for (Map.Entry<Integer, Integer> entry : breakpoints.entrySet()) {
            int distance = windowSize - entry.getKey();
            if (distance > 0 && distance < minDistance) {
                minDistance = distance;
                closerBreakpoint = entry.getKey();
            }
        }

        return breakpoints.getOrDefault(closerBreakpoint, ApplicationEditorFontPreferences.DEFAULT_FONT_SIZE);
    }
}
