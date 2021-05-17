package com.github.tiste.responsiveintellijplugin.services;

import com.intellij.application.options.EditorFontsConstants;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.colors.impl.AppEditorFontOptions;
import com.intellij.openapi.editor.colors.impl.FontPreferencesImpl;

public class ApplicationEditorFontPreferences {
    private final FontPreferencesImpl fontPreferences;
    static final int DEFAULT_FONT_SIZE = EditorFontsConstants.getDefaultEditorFontSize();
    static final int MIN_FONT_SIZE = EditorFontsConstants.getMinEditorFontSize();
    static final int MAX_FONT_SIZE = EditorFontsConstants.getMaxEditorFontSize();

    public ApplicationEditorFontPreferences() {
        this.fontPreferences = (FontPreferencesImpl) AppEditorFontOptions.getInstance().getFontPreferences();
    }

    public void setFontSize(int fontSize) {
        if (this.isEditorFontSizeAllowed(fontSize)) {
            this.fontPreferences.setFontSize(this.fontPreferences.getFontFamily(), fontSize);
            EditorFactory.getInstance().refreshAllEditors();
        }
    }

    public final boolean isEditorFontSizeAllowed(int fontSize) {
        if (MIN_FONT_SIZE <= fontSize) {
            return MAX_FONT_SIZE >= fontSize;
        }

        return false;
    }

    public static ApplicationEditorFontPreferences getInstance() {
        return ServiceManager.getService(ApplicationEditorFontPreferences.class);
    }
}
