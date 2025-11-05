package b.a.q.n0;

import d0.z.d.o;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: RtcControlSocket.kt */
/* loaded from: classes.dex */
public final class b extends TimerTask {
    public final /* synthetic */ b.a.q.n0.a j;

    /* compiled from: RtcControlSocket.kt */
    public static final class a extends o implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            b.a.q.n0.a aVar = b.this.j;
            int i = b.a.q.n0.a.j;
            aVar.k();
            return Unit.a;
        }
    }

    public b(b.a.q.n0.a aVar) {
        this.j = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.j.m(new a());
    }
}
