package b.i.a.c.w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.w2.s;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;

/* compiled from: DrmSessionManager.java */
/* loaded from: classes3.dex */
public interface u {
    public static final u a = new a();

    /* compiled from: DrmSessionManager.java */
    public class a implements u {
        @Override // b.i.a.c.w2.u
        public /* synthetic */ void a() {
            t.b(this);
        }

        @Override // b.i.a.c.w2.u
        public /* synthetic */ b b(Looper looper, s.a aVar, j1 j1Var) {
            return t.a(this, looper, aVar, j1Var);
        }

        @Override // b.i.a.c.w2.u
        @Nullable
        public DrmSession c(Looper looper, @Nullable s.a aVar, j1 j1Var) {
            if (j1Var.f1020z == null) {
                return null;
            }
            return new z(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // b.i.a.c.w2.u
        public int d(j1 j1Var) {
            return j1Var.f1020z != null ? 1 : 0;
        }

        @Override // b.i.a.c.w2.u
        public /* synthetic */ void release() {
            t.c(this);
        }
    }

    /* compiled from: DrmSessionManager.java */
    public interface b {
        public static final /* synthetic */ int a = 0;

        void release();
    }

    void a();

    b b(Looper looper, @Nullable s.a aVar, j1 j1Var);

    @Nullable
    DrmSession c(Looper looper, @Nullable s.a aVar, j1 j1Var);

    int d(j1 j1Var);

    void release();
}
