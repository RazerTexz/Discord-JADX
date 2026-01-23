package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$init$echoCancellationCallback$1 implements MediaEngine.InterfaceC5641b {
    public final /* synthetic */ StoreMediaEngine this$0;

    public StoreMediaEngine$init$echoCancellationCallback$1(StoreMediaEngine storeMediaEngine) {
        this.this$0 = storeMediaEngine;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5641b
    public void onEchoCancellationUpdated(MediaEngine.EchoCancellationInfo info) {
        Intrinsics3.checkNotNullParameter(info, "info");
        StoreMediaEngine.access$getDispatcher$p(this.this$0).schedule(new C6174x527da00c(info));
    }
}
