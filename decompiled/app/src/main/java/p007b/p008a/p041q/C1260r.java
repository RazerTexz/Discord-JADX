package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RtcConnection.kt */
/* renamed from: b.a.q.r */
/* loaded from: classes.dex */
public final class C1260r extends RtcConnection.AbstractC5616b {

    /* renamed from: j */
    public final /* synthetic */ RtcConnection f1870j;

    public C1260r(RtcConnection rtcConnection) {
        this.f1870j = rtcConnection;
    }

    @Override // com.discord.rtcconnection.RtcConnection.AbstractC5616b, com.discord.rtcconnection.RtcConnection.InterfaceC5617c
    public void onStateChange(RtcConnection.StateChange stateChange) {
        Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
        this.f1870j.connectionStateSubject.onNext(stateChange);
    }
}
