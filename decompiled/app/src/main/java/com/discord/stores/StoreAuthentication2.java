package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.authentication.AuthState;
import p637j0.p641k.Func1;

/* compiled from: StoreAuthentication.kt */
/* renamed from: com.discord.stores.StoreAuthentication$getAuthedToken$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication2<T, R> implements Func1<AuthState, String> {
    public static final StoreAuthentication2 INSTANCE = new StoreAuthentication2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ String call(AuthState authState) {
        return call2(authState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(AuthState authState) {
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
