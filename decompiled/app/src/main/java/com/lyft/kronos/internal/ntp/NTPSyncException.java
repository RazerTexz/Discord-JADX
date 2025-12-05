package com.lyft.kronos.internal.ntp;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NTPSyncException.kt */
/* loaded from: classes3.dex */
public final class NTPSyncException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPSyncException(String str) {
        super(str);
        Intrinsics3.checkParameterIsNotNull(str, "message");
    }
}
