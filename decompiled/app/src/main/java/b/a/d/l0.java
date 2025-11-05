package b.a.d;

import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import rx.Observable;

/* compiled from: DiscordConnectService.kt */
/* loaded from: classes.dex */
public final class l0<T, R> implements j0.k.b<Boolean, Observable<? extends RtcConnection.StateChange>> {
    public static final l0 j = new l0();

    @Override // j0.k.b
    public Observable<? extends RtcConnection.StateChange> call(Boolean bool) {
        return StoreStream.INSTANCE.getRtcConnection().getConnectionState().y(k0.j);
    }
}
