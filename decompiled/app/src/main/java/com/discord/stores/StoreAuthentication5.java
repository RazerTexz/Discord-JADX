package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.authentication.AuthState;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$observeIsAuthed$1, reason: use source file name */
/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication5<T, R> implements Func1<AuthState, Boolean> {
    public static final StoreAuthentication5 INSTANCE = new StoreAuthentication5();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(AuthState authState) {
        return call2(authState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(AuthState authState) {
        return Boolean.valueOf(authState != null);
    }
}
