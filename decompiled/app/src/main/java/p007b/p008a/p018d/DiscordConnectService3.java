package p007b.p008a.p018d;

import com.discord.rtcconnection.RtcConnection;
import p637j0.p641k.Func1;

/* compiled from: DiscordConnectService.kt */
/* renamed from: b.a.d.k0, reason: use source file name */
/* loaded from: classes.dex */
public final class DiscordConnectService3<T, R> implements Func1<RtcConnection.StateChange, Boolean> {

    /* renamed from: j */
    public static final DiscordConnectService3 f527j = new DiscordConnectService3();

    @Override // p637j0.p641k.Func1
    public Boolean call(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Boolean.valueOf(((state instanceof RtcConnection.State.C5610d) || (state instanceof RtcConnection.State.C5614h)) ? false : true);
    }
}
