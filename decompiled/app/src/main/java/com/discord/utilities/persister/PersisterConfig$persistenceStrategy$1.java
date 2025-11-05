package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* compiled from: PersisterConfig.kt */
/* loaded from: classes2.dex */
public final class PersisterConfig$persistenceStrategy$1<T, R> implements b<Long, Boolean> {
    public static final PersisterConfig$persistenceStrategy$1 INSTANCE = new PersisterConfig$persistenceStrategy$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.TRUE;
    }
}
