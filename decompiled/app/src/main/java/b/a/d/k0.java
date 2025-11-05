package b.a.d;

import com.discord.rtcconnection.RtcConnection;

/* compiled from: DiscordConnectService.kt */
/* loaded from: classes.dex */
public final class k0<T, R> implements j0.k.b<RtcConnection.StateChange, Boolean> {
    public static final k0 j = new k0();

    @Override // j0.k.b
    public Boolean call(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Boolean.valueOf(((state instanceof RtcConnection.State.d) || (state instanceof RtcConnection.State.h)) ? false : true);
    }
}
