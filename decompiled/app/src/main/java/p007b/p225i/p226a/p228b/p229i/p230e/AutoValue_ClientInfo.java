package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p229i.p230e.ClientInfo2;

/* JADX INFO: renamed from: b.i.a.b.i.e.e, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_ClientInfo extends ClientInfo2 {

    /* JADX INFO: renamed from: a */
    public final ClientInfo2.a f5165a;

    /* JADX INFO: renamed from: b */
    public final AndroidClientInfo f5166b;

    public AutoValue_ClientInfo(ClientInfo2.a aVar, AndroidClientInfo androidClientInfo, a aVar2) {
        this.f5165a = aVar;
        this.f5166b = androidClientInfo;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.ClientInfo2
    @Nullable
    /* JADX INFO: renamed from: a */
    public AndroidClientInfo mo2314a() {
        return this.f5166b;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.ClientInfo2
    @Nullable
    /* JADX INFO: renamed from: b */
    public ClientInfo2.a mo2315b() {
        return this.f5165a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo2)) {
            return false;
        }
        ClientInfo2 clientInfo2 = (ClientInfo2) obj;
        ClientInfo2.a aVar = this.f5165a;
        if (aVar != null ? aVar.equals(clientInfo2.mo2315b()) : clientInfo2.mo2315b() == null) {
            AndroidClientInfo androidClientInfo = this.f5166b;
            if (androidClientInfo == null) {
                if (clientInfo2.mo2314a() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo2.mo2314a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo2.a aVar = this.f5165a;
        int iHashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f5166b;
        return iHashCode ^ (androidClientInfo != null ? androidClientInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ClientInfo{clientType=");
        sbM833U.append(this.f5165a);
        sbM833U.append(", androidClientInfo=");
        sbM833U.append(this.f5166b);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
