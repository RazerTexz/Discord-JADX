package com.discord.widgets.chat.input.models;

import d0.z.d.m;

/* compiled from: CommandOptionValue.kt */
/* loaded from: classes2.dex */
public final class RawOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawOptionValue(String str) {
        super(str, null);
        m.checkNotNullParameter(str, "rawValue");
    }
}
