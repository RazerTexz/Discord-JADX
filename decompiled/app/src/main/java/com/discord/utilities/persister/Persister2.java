package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.Func1;

/* compiled from: Persister.kt */
/* renamed from: com.discord.utilities.persister.Persister$Companion$init$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister2<T, R> implements Func1<Boolean, Boolean> {
    public static final Persister2 INSTANCE = new Persister2();

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return bool;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }
}
