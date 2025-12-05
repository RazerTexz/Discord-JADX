package com.discord.samsung;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SamsungConnect.kt */
/* renamed from: com.discord.samsung.SamsungConnect$SamsungCallbackException, reason: use source file name */
/* loaded from: classes.dex */
public final class SamsungConnect3 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect3(String str, String str2) {
        super('[' + str + "] " + str2);
        Intrinsics3.checkNotNullParameter(str, "errorCode");
    }
}
