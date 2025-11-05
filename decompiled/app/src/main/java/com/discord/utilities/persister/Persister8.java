package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.Func1;

/* compiled from: Persister.kt */
/* renamed from: com.discord.utilities.persister.Persister$Preloader$isPreloaded$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister8<T, R> implements Func1<Persister<?>, Boolean> {
    public static final Persister8 INSTANCE = new Persister8();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Persister<?> persister) {
        return call2(persister);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Persister<?> persister) {
        return Boolean.valueOf(persister == null);
    }
}
