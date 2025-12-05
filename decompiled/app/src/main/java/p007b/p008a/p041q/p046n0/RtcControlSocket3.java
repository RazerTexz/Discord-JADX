package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RtcControlSocket.kt */
/* renamed from: b.a.q.n0.c, reason: use source file name */
/* loaded from: classes.dex */
public final class RtcControlSocket3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Integer $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ boolean $wasFatal;
    public final /* synthetic */ RtcControlSocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RtcControlSocket3(RtcControlSocket rtcControlSocket, boolean z2, Integer num, String str) {
        super(0);
        this.this$0 = rtcControlSocket;
        this.$wasFatal = z2;
        this.$code = num;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcControlSocket rtcControlSocket = this.this$0;
        boolean z2 = this.$wasFatal;
        Integer num = this.$code;
        String str = this.$reason;
        int i = RtcControlSocket.f1763j;
        rtcControlSocket.m348l(z2, num, str);
        return Unit.f27425a;
    }
}
