package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import rx.functions.Action0;

/* compiled from: StoreSlowMode.kt */
/* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSlowMode5 implements Action0 {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    public StoreSlowMode5(StoreSlowMode storeSlowMode, long j, StoreSlowMode.Type type) {
        this.this$0 = storeSlowMode;
        this.$channelId = j;
        this.$type = type;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreSlowMode.access$removeChannelCooldownObservable(this.this$0, this.$channelId, this.$type);
    }
}
