package com.discord.utilities.embed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: FileType.kt */
/* renamed from: com.discord.utilities.embed.FileType$threadLocalMatcher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FileType2 extends ThreadLocal<Matcher> {
    public final /* synthetic */ Pattern $pattern;

    public FileType2(Pattern pattern) {
        this.$pattern = pattern;
    }

    @Override // java.lang.ThreadLocal
    public /* bridge */ /* synthetic */ Matcher initialValue() {
        return initialValue2();
    }

    @Override // java.lang.ThreadLocal
    /* renamed from: initialValue, reason: avoid collision after fix types in other method */
    public Matcher initialValue2() {
        return this.$pattern.matcher("");
    }
}
