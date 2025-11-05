package b.i.a.c.t2;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import java.util.Objects;

/* compiled from: AudioRendererEventListener.java */
/* loaded from: classes3.dex */
public interface r {

    /* compiled from: AudioRendererEventListener.java */
    public static final class a {

        @Nullable
        public final Handler a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final r f1126b;

        public a(@Nullable Handler handler, @Nullable r rVar) {
            if (rVar != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.a = handler;
            this.f1126b = rVar;
        }

        public void a(b.i.a.c.v2.e eVar) {
            synchronized (eVar) {
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new b(this, eVar));
            }
        }
    }

    void B(String str);

    void C(String str, long j, long j2);

    void I(j1 j1Var, @Nullable b.i.a.c.v2.g gVar);

    void N(Exception exc);

    void R(long j);

    void T(Exception exc);

    @Deprecated
    void U(j1 j1Var);

    void d(boolean z2);

    void e0(int i, long j, long j2);

    void k(b.i.a.c.v2.e eVar);

    void m(b.i.a.c.v2.e eVar);
}
