package com.discord.samsung;

import d0.z.d.m;

/* compiled from: SamsungConnect.kt */
/* loaded from: classes.dex */
public final class SamsungConnect$SamsungCallbackException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect$SamsungCallbackException(String str, String str2) {
        super('[' + str + "] " + str2);
        m.checkNotNullParameter(str, "errorCode");
    }
}
