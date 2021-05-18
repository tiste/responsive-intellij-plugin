package com.github.tiste.responsiveintellijplugin.settings;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class ApplicationSettingsStateTest {

    ApplicationSettingsState applicationSettingsState;

    @BeforeEach
    void init() {
        applicationSettingsState = new ApplicationSettingsState();

        LinkedHashMap<Integer, Integer> testMap = new LinkedHashMap();
        testMap.put(0, 12);
        testMap.put(1000, 13);
        testMap.put(2000, 14);

        applicationSettingsState.breakpoints = testMap;
    }

    @Test
    void findBreakpointValueWhenBreakpointIsLarge() {
        Assert.assertEquals(12, applicationSettingsState.findBreakpointValue(900));
    }

    @Test
    void findBreakpointValueWhenBreakpointIsClose() {
        Assert.assertEquals(13, applicationSettingsState.findBreakpointValue(1200));
    }

    @Test
    void findBreakpointValueWhenBreakpointIsHuge() {
        Assert.assertEquals(14, applicationSettingsState.findBreakpointValue(5000));
    }
}
