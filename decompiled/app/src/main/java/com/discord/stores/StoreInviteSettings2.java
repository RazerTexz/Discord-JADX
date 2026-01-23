package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreInviteSettings$trackWithInvite$1, reason: use source file name */
/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings2<T, R> implements Func1<ModelInvite, Boolean> {
    public static final StoreInviteSettings2 INSTANCE = new StoreInviteSettings2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(ModelInvite modelInvite) {
        return call2(modelInvite);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelInvite modelInvite) {
        return Boolean.valueOf(modelInvite != null);
    }
}
