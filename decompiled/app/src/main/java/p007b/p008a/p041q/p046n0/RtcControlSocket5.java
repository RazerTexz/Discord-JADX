package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RtcControlSocket.kt */
/* renamed from: b.a.q.n0.e, reason: use source file name */
/* loaded from: classes.dex */
public final class RtcControlSocket5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RtcControlSocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RtcControlSocket5(RtcControlSocket rtcControlSocket) {
        super(0);
        this.this$0 = rtcControlSocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcControlSocket rtcControlSocket = this.this$0;
        int i = RtcControlSocket.f1763j;
        rtcControlSocket.m348l(true, 4800, "Heartbeat timeout.");
        return Unit.f27425a;
    }
}
