package b.i.a.c.g3;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import java.util.Objects;

/* compiled from: VideoRendererEventListener.java */
/* loaded from: classes3.dex */
public interface x {

    /* compiled from: VideoRendererEventListener.java */
    public static final class a {

        @Nullable
        public final Handler a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final x f995b;

        public a(@Nullable Handler handler, @Nullable x xVar) {
            if (xVar != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.a = handler;
            this.f995b = xVar;
        }
    }

    void F(int i, long j);

    void K(Object obj, long j);

    @Deprecated
    void O(j1 j1Var);

    void P(b.i.a.c.v2.e eVar);

    void Q(j1 j1Var, @Nullable b.i.a.c.v2.g gVar);

    void V(Exception exc);

    void Z(b.i.a.c.v2.e eVar);

    void f(y yVar);

    void h0(long j, int i);

    void l(String str);

    void n(String str, long j, long j2);
}
