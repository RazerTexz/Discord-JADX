package com.discord.utilities.textprocessing;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$PATTERN_UNICODE_EMOJI$2 extends Lambda implements Function0<Pattern> {
    public static final Rules$PATTERN_UNICODE_EMOJI$2 INSTANCE = new Rules$PATTERN_UNICODE_EMOJI$2();

    public Rules$PATTERN_UNICODE_EMOJI$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pattern invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        StringBuilder sbM833U = outline.m833U("^(");
        sbM833U.append(Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisPattern().pattern());
        sbM833U.append(')');
        return Pattern.compile(sbM833U.toString());
    }
}
