package com.discord.widgets.chat.input.models;

import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringOptionValue(String str) {
        super(str, null);
        Intrinsics3.checkNotNullParameter(str, "value");
    }
}
