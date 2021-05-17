package com.github.tiste.responsiveintellijplugin.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@State(
        name = "com.github.tiste.responsiveintellijplugin.settings.ApplicationSettingsState",
        storages = {@Storage("ResponsiveSettingsPlugin-test2.xml")}
)
public class ApplicationSettingsState implements PersistentStateComponent<ApplicationSettingsState> {
    public Map<Integer, Integer> breakpoints = new HashMap();

    @Nullable
    @Override
    public ApplicationSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ApplicationSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static ApplicationSettingsState getInstance() {
        return ServiceManager.getService(ApplicationSettingsState.class);
    }
}
