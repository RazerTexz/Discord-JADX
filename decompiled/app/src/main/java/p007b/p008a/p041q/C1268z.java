package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import java.util.Map;
import kotlin.Tuples2;
import p507d0.Tuples;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: b.a.q.z */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1268z<T1, T2, R> implements Func2<Map<String, ? extends MediaSinkWantsManager9>, RtcConnection.StateChange, Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State>> {

    /* JADX INFO: renamed from: j */
    public static final C1268z f1874j = new C1268z();

    @Override // p658rx.functions.Func2
    public Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> call(Map<String, ? extends MediaSinkWantsManager9> map, RtcConnection.StateChange stateChange) {
        return Tuples.m10073to(map, stateChange.state);
    }
}
