package p617h0.p628c;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import org.webrtc.NetworkMonitorAutoDetect;

/* compiled from: lambda */
/* renamed from: h0.c.q */
/* loaded from: classes3.dex */
public final /* synthetic */ class C12482q implements WifiP2pManager.GroupInfoListener {

    /* renamed from: a */
    public final /* synthetic */ NetworkMonitorAutoDetect.WifiDirectManagerDelegate f26456a;

    public /* synthetic */ C12482q(NetworkMonitorAutoDetect.WifiDirectManagerDelegate wifiDirectManagerDelegate) {
        this.f26456a = wifiDirectManagerDelegate;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.f26456a.m11034a(wifiP2pGroup);
    }
}
