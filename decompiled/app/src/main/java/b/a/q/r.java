package b.a.q;

import com.discord.rtcconnection.RtcConnection;

/* compiled from: RtcConnection.kt */
/* loaded from: classes.dex */
public final class r extends RtcConnection.b {
    public final /* synthetic */ RtcConnection j;

    public r(RtcConnection rtcConnection) {
        this.j = rtcConnection;
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onStateChange(RtcConnection.StateChange stateChange) {
        d0.z.d.m.checkNotNullParameter(stateChange, "stateChange");
        this.j.connectionStateSubject.onNext(stateChange);
    }
}
