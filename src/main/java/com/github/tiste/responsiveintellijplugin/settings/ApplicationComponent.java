package com.github.tiste.responsiveintellijplugin.settings;

import com.github.tiste.responsiveintellijplugin.services.ApplicationEditorFontPreferences;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.apache.commons.lang.math.NumberUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationComponent {
    private final JPanel mainPanel;
    private final JBTextField firstBreakpoint = new JBTextField("0");
    private final JBTextField firstFontSize = new JBTextField("" + ApplicationEditorFontPreferences.DEFAULT_FONT_SIZE);
    private final JBTextField secondBreakpoint = new JBTextField("0");
    private final JBTextField secondFontSize = new JBTextField("" + ApplicationEditorFontPreferences.DEFAULT_FONT_SIZE);
    private final JBTextField thirdBreakpoint = new JBTextField("0");
    private final JBTextField thirdFontSize = new JBTextField("" + ApplicationEditorFontPreferences.DEFAULT_FONT_SIZE);
    final JBTextField[][] textFields = {{firstBreakpoint, firstFontSize}, {secondBreakpoint, secondFontSize}, {thirdBreakpoint, thirdFontSize}};

    public ApplicationComponent(String currentWindowSize) {
        JBLabel windowSize = new JBLabel(currentWindowSize);

        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Actual window size: "), windowSize, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel("Enter first breakpoint: "), firstBreakpoint, 1, false)
                .addLabeledComponent(new JBLabel("Enter first font size: "), firstFontSize, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel("Enter second breakpoint: "), secondBreakpoint, 1, false)
                .addLabeledComponent(new JBLabel("Enter second font size: "), secondFontSize, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel("Enter third breakpoint: "), thirdBreakpoint, 1, false)
                .addLabeledComponent(new JBLabel("Enter third font size: "), thirdFontSize, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return firstBreakpoint;
    }

    public int getBreakpointAtPosition(int position) {
        return NumberUtils.toInt(textFields[position][0].getText(), 0);
    }

    public int getFontSizeAtPosition(int position) {
        return NumberUtils.toInt(textFields[position][1].getText(), ApplicationEditorFontPreferences.DEFAULT_FONT_SIZE);
    }

    public void reset() {
        ApplicationState settings = ApplicationState.getInstance();

        List keys = new ArrayList(settings.breakpoints.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Object breakpoint = keys.get(i);

            textFields[i][0].setText(breakpoint.toString());
            textFields[i][1].setText(settings.breakpoints.get(breakpoint).toString());
        }
    }
}
