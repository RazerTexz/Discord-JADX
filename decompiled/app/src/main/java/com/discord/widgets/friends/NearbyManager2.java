package com.discord.widgets.friends;

import b.i.a.f.j.b.c;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.friends.NearbyManager;
import java.util.HashSet;

/* compiled from: NearbyManager.kt */
/* renamed from: com.discord.widgets.friends.NearbyManager$buildClient$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NearbyManager2 extends c {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager2(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // b.i.a.f.j.b.c
    public void onPermissionChanged(boolean permissionGranted) {
        super.onPermissionChanged(permissionGranted);
        if (!permissionGranted) {
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager.NearbyState.Disconnected(98));
        } else {
            AnalyticsTracker.nearbyConnected();
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager.NearbyState.Connected(new HashSet(NearbyManager.access$getNearbyUserIds$p(this.this$0))));
        }
    }
}
