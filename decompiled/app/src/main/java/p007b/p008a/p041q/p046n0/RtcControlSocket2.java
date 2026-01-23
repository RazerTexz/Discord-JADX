package p007b.p008a.p041q.p046n0;

import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.n0.b, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket2 extends TimerTask {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcControlSocket f1802j;

    /* JADX INFO: renamed from: b.a.q.n0.b$a */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RtcControlSocket rtcControlSocket = RtcControlSocket2.this.f1802j;
            int i = RtcControlSocket.f1763j;
            rtcControlSocket.m347k();
            return Unit.f27425a;
        }
    }

    public RtcControlSocket2(RtcControlSocket rtcControlSocket) {
        this.f1802j = rtcControlSocket;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1802j.m349m(new a());
    }
}
