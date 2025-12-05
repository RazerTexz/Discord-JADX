package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p041q.p046n0.RtcControlSocket;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RtcConnection.kt */
/* renamed from: b.a.q.o */
/* loaded from: classes.dex */
public final class C1251o extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Boolean $isConnected;
    public final /* synthetic */ C1258p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1251o(C1258p c1258p, Boolean bool) {
        super(0);
        this.this$0 = c1258p;
        this.$isConnected = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0.f1868j;
        Boolean bool = this.$isConnected;
        Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
        boolean zBooleanValue = bool.booleanValue();
        RtcControlSocket rtcControlSocket = rtcConnection.socket;
        if (rtcControlSocket == null) {
            RtcConnection.m8460o(rtcConnection, "handleConnectivityChange() socket was null.", null, null, 6);
        } else if (zBooleanValue) {
            rtcControlSocket.m343g(5000L, "network detected online", true);
        } else {
            rtcControlSocket.m343g(15000L, "network detected offline", false);
        }
        return Unit.f27425a;
    }
}
