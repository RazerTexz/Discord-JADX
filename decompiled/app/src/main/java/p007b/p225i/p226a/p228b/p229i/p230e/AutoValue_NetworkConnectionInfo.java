package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p229i.p230e.NetworkConnectionInfo;

/* JADX INFO: renamed from: b.i.a.b.i.e.i, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {

    /* JADX INFO: renamed from: a */
    public final NetworkConnectionInfo.b f5189a;

    /* JADX INFO: renamed from: b */
    public final NetworkConnectionInfo.a f5190b;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.b bVar, NetworkConnectionInfo.a aVar, a aVar2) {
        this.f5189a = bVar;
        this.f5190b = aVar;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.NetworkConnectionInfo
    @Nullable
    /* JADX INFO: renamed from: a */
    public NetworkConnectionInfo.a mo2331a() {
        return this.f5190b;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.NetworkConnectionInfo
    @Nullable
    /* JADX INFO: renamed from: b */
    public NetworkConnectionInfo.b mo2332b() {
        return this.f5189a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.b bVar = this.f5189a;
        if (bVar != null ? bVar.equals(networkConnectionInfo.mo2332b()) : networkConnectionInfo.mo2332b() == null) {
            NetworkConnectionInfo.a aVar = this.f5190b;
            if (aVar == null) {
                if (networkConnectionInfo.mo2331a() == null) {
                    return true;
                }
            } else if (aVar.equals(networkConnectionInfo.mo2331a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.b bVar = this.f5189a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.a aVar = this.f5190b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("NetworkConnectionInfo{networkType=");
        sbM833U.append(this.f5189a);
        sbM833U.append(", mobileSubtype=");
        sbM833U.append(this.f5190b);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
