package com.discord.utilities.textprocessing;

import b.d.b.a.outline;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* compiled from: Rules.kt */
/* loaded from: classes2.dex */
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
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        StringBuilder sbU = outline.U("^(");
        sbU.append(Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisPattern().pattern());
        sbU.append(')');
        return Pattern.compile(sbU.toString());
    }
}
