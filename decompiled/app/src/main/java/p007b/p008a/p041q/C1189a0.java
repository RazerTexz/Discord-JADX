package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p046n0.RtcControlSocket;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.a0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1189a0 extends FunctionReferenceImpl implements Function1<Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State>, Unit> {
    public C1189a0(RtcConnection rtcConnection) {
        super(1, rtcConnection, RtcConnection.class, "onLocalMediaSinkWants", "onLocalMediaSinkWants(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> tuples2) {
        Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> tuples22 = tuples2;
        Intrinsics3.checkNotNullParameter(tuples22, "p1");
        RtcConnection rtcConnection = (RtcConnection) this.receiver;
        if (rtcConnection.enableMediaSinkWants) {
            Map<String, ? extends MediaSinkWantsManager9> mapComponent1 = tuples22.component1();
            if (Intrinsics3.areEqual(tuples22.component2(), RtcConnection.State.C5612f.f18814a)) {
                rtcConnection.logger.mo8366i(rtcConnection.loggingTag, "local MediaSinkWants: " + mapComponent1, null);
                RtcControlSocket rtcControlSocket = rtcConnection.socket;
                if (rtcControlSocket == null) {
                    RtcConnection.m8460o(rtcConnection, "onLocalMediaSinkWants() socket was null.", null, null, 6);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(mapComponent1.size()));
                    Iterator<T> it = mapComponent1.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), Integer.valueOf(((MediaSinkWantsManager9) entry.getValue()).getValue()));
                    }
                    Intrinsics3.checkNotNullParameter(linkedHashMap, "wants");
                    rtcControlSocket.f1773H.m266a();
                    if (rtcControlSocket.f1781r >= 5) {
                        rtcControlSocket.m350n(15, linkedHashMap);
                    }
                }
            }
        }
        return Unit.f27425a;
    }
}
