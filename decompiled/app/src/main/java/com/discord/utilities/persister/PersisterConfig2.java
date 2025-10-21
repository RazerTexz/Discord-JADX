package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;

/* compiled from: PersisterConfig.kt */
/* renamed from: com.discord.utilities.persister.PersisterConfig$persistenceStrategy$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PersisterConfig2<T, R> implements Func1<Long, Boolean> {
    public static final PersisterConfig2 INSTANCE = new PersisterConfig2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.TRUE;
    }
}
