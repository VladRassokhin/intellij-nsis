package com.krylysov.nsisplugin;


import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class NsisColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Compiler command", NsisSyntaxHighlighter.COMPILER_COMMAND),
            new AttributesDescriptor("Instruction", NsisSyntaxHighlighter.INSTRUCTION),
            new AttributesDescriptor("String", NsisSyntaxHighlighter.STRING),
            new AttributesDescriptor("Number", NsisSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Identifier", NsisSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Comment", NsisSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Block declaration", NsisSyntaxHighlighter.BLOCK_DECLARATION),
            new AttributesDescriptor("Keyword", NsisSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Constant", NsisSyntaxHighlighter.CONSTANT),
            new AttributesDescriptor("Special symbol", NsisSyntaxHighlighter.SPECIAL_SYMBOL),
            new AttributesDescriptor("Bad character", NsisSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return NsisFileType.INSTANCE.getIcon();
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new NsisSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "!include 1 '2' \"3\" CONST ${test} `123` _ABC\n" +
                "; comment\n" +
                "CRCCheck On\n" +
                "nsProcess::_FindProcess /NOUNLOAD\n" +
                "File /r mpg\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "NSIS";
    }
}