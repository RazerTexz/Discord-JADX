package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.WebSocket;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.n0.d, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket4 extends Lambda implements Function1<WebSocket, Unit> {

    /* JADX INFO: renamed from: j */
    public static final RtcControlSocket4 f1803j = new RtcControlSocket4();

    public RtcControlSocket4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WebSocket webSocket) {
        WebSocket webSocket2 = webSocket;
        Intrinsics3.checkNotNullParameter(webSocket2, "it");
        webSocket2.mo10349e(4800, "Heartbeat timeout.");
        return Unit.f27425a;
    }
}
