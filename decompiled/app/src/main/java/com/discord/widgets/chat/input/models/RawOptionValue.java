package com.discord.widgets.chat.input.models;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CommandOptionValue.kt */
/* loaded from: classes2.dex */
public final class RawOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawOptionValue(String str) {
        super(str, null);
        Intrinsics3.checkNotNullParameter(str, "rawValue");
    }
}
