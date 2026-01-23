package com.discord.widgets.friends;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.friends.NearbyManager;
import java.util.HashSet;
import p007b.p225i.p226a.p288f.p333j.p334b.C4266c;

/* JADX INFO: renamed from: com.discord.widgets.friends.NearbyManager$buildClient$$inlined$also$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager2 extends C4266c {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager2(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.C4266c
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
