package com.github.tiste.responsiveintellijplugin.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ApplicationSettingsComponent {
    private final JPanel mainPanel;
    private final JBTextField firstBreakpoint = new JBTextField();
    private final JBTextField firstFontSize = new JBTextField();
    private final JBTextField secondBreakpoint = new JBTextField();
    private final JBTextField secondFontSize = new JBTextField();

    public ApplicationSettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter first breakpoint: "), firstBreakpoint, 1, false)
                .addLabeledComponent(new JBLabel("Enter first font size: "), firstFontSize, 1, false)
                .addLabeledComponent(new JBLabel("Enter second breakpoint: "), secondBreakpoint, 1, false)
                .addLabeledComponent(new JBLabel("Enter second font size: "), secondFontSize, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return firstBreakpoint;
    }

    @NotNull
    public Number getFirstBreakpoint() {
        return Integer.parseInt(firstBreakpoint.getText());
    }

    @NotNull
    public Number getFirstFontSize() {
        return Integer.parseInt(firstFontSize.getText());
    }

    @NotNull
    public Number getSecondBreakpoint() {
        return Integer.parseInt(secondBreakpoint.getText());
    }

    @NotNull
    public Number getSecondFontSize() {
        return Integer.parseInt(secondFontSize.getText());
    }

    public void reset() {
        firstBreakpoint.setText("0");
        firstFontSize.setText("0");
        secondBreakpoint.setText("0");
        secondFontSize.setText("0");
    }
}
