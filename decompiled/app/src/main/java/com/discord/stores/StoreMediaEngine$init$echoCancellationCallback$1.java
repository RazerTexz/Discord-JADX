package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import d0.z.d.m;

/* compiled from: StoreMediaEngine.kt */
/* loaded from: classes2.dex */
public final class StoreMediaEngine$init$echoCancellationCallback$1 implements MediaEngine.b {
    public final /* synthetic */ StoreMediaEngine this$0;

    public StoreMediaEngine$init$echoCancellationCallback$1(StoreMediaEngine storeMediaEngine) {
        this.this$0 = storeMediaEngine;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine.b
    public void onEchoCancellationUpdated(MediaEngine.EchoCancellationInfo info) {
        m.checkNotNullParameter(info, "info");
        StoreMediaEngine.access$getDispatcher$p(this.this$0).schedule(new StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1(info));
    }
}
