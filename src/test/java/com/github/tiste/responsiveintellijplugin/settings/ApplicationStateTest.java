package com.github.tiste.responsiveintellijplugin.settings;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class ApplicationStateTest {

    ApplicationState applicationState;

    @BeforeEach
    void init() {
        applicationState = new ApplicationState();

        LinkedHashMap<Integer, Integer> testMap = new LinkedHashMap();
        testMap.put(0, 12);
        testMap.put(1000, 13);
        testMap.put(2000, 14);

        applicationState.breakpoints = testMap;
    }

    @Test
    void findBreakpointValueWhenBreakpointIsLarge() {
        Assert.assertEquals(12, applicationState.findBreakpointValue(900));
    }

    @Test
    void findBreakpointValueWhenBreakpointIsClose() {
        Assert.assertEquals(13, applicationState.findBreakpointValue(1200));
    }

    @Test
    void findBreakpointValueWhenBreakpointIsHuge() {
        Assert.assertEquals(14, applicationState.findBreakpointValue(5000));
    }
}
