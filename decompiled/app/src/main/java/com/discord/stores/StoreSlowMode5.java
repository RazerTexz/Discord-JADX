package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$4, reason: use source file name */
/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode5 implements Action0 {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    public StoreSlowMode5(StoreSlowMode storeSlowMode, long j, StoreSlowMode.Type type) {
        this.this$0 = storeSlowMode;
        this.$channelId = j;
        this.$type = type;
    }

    @Override // p658rx.functions.Action0
    public final void call() {
        StoreSlowMode.access$removeChannelCooldownObservable(this.this$0, this.$channelId, this.$type);
    }
}
