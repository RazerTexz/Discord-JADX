package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.Func1;

/* compiled from: StoreInviteSettings.kt */
/* renamed from: com.discord.stores.StoreInviteSettings$trackWithInvite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreInviteSettings2<T, R> implements Func1<ModelInvite, Boolean> {
    public static final StoreInviteSettings2 INSTANCE = new StoreInviteSettings2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(ModelInvite modelInvite) {
        return call2(modelInvite);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelInvite modelInvite) {
        return Boolean.valueOf(modelInvite != null);
    }
}
