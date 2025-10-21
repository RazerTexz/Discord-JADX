package com.discord.utilities.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;

/* compiled from: NetworkMonitor.kt */
/* renamed from: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NetworkMonitor2 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NetworkMonitor this$0;

    public NetworkMonitor2(NetworkMonitor networkMonitor, Context context) {
        this.this$0 = networkMonitor;
        this.$context = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onAvailable fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Intrinsics3.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onCapabilitiesChanged fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onLost fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onUnavailable fired.", null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }
}
