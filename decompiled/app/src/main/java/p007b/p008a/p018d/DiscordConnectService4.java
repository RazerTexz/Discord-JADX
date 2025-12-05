package p007b.p008a.p018d;

import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: DiscordConnectService.kt */
/* renamed from: b.a.d.l0, reason: use source file name */
/* loaded from: classes.dex */
public final class DiscordConnectService4<T, R> implements Func1<Boolean, Observable<? extends RtcConnection.StateChange>> {

    /* renamed from: j */
    public static final DiscordConnectService4 f531j = new DiscordConnectService4();

    @Override // p637j0.p641k.Func1
    public Observable<? extends RtcConnection.StateChange> call(Boolean bool) {
        return StoreStream.INSTANCE.getRtcConnection().getConnectionState().m11118y(DiscordConnectService3.f527j);
    }
}
