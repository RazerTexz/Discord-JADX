package p007b.p225i.p226a.p242c.p266w2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: DrmSessionEventListener.java */
/* renamed from: b.i.a.c.w2.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface DrmSessionEventListener {
    /* renamed from: J */
    void mo2567J(int i, @Nullable MediaSource2.a aVar);

    /* renamed from: S */
    void mo2568S(int i, @Nullable MediaSource2.a aVar);

    /* renamed from: c0 */
    void mo2571c0(int i, @Nullable MediaSource2.a aVar, int i2);

    /* renamed from: d0 */
    void mo2572d0(int i, @Nullable MediaSource2.a aVar);

    /* renamed from: i0 */
    void mo2573i0(int i, @Nullable MediaSource2.a aVar);

    /* renamed from: u */
    void mo2574u(int i, @Nullable MediaSource2.a aVar, Exception exc);

    /* compiled from: DrmSessionEventListener.java */
    /* renamed from: b.i.a.c.w2.s$a */
    public static class a {

        /* renamed from: a */
        public final int f8012a;

        /* renamed from: b */
        @Nullable
        public final MediaSource2.a f8013b;

        /* renamed from: c */
        public final CopyOnWriteArrayList<C13226a> f8014c;

        /* compiled from: DrmSessionEventListener.java */
        /* renamed from: b.i.a.c.w2.s$a$a, reason: collision with other inner class name */
        public static final class C13226a {

            /* renamed from: a */
            public Handler f8015a;

            /* renamed from: b */
            public DrmSessionEventListener f8016b;

            public C13226a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f8015a = handler;
                this.f8016b = drmSessionEventListener;
            }
        }

        public a() {
            this.f8014c = new CopyOnWriteArrayList<>();
            this.f8012a = 0;
            this.f8013b = null;
        }

        /* renamed from: a */
        public void m3587a() {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2978i(this, c13226a.f8016b));
            }
        }

        /* renamed from: b */
        public void m3588b() {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2977h(this, c13226a.f8016b));
            }
        }

        /* renamed from: c */
        public void m3589c() {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2979j(this, c13226a.f8016b));
            }
        }

        /* renamed from: d */
        public void m3590d(int i) {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2981l(this, c13226a.f8016b, i));
            }
        }

        /* renamed from: e */
        public void m3591e(Exception exc) {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2980k(this, c13226a.f8016b, exc));
            }
        }

        /* renamed from: f */
        public void m3592f() {
            for (C13226a c13226a : this.f8014c) {
                Util2.m2984E(c13226a.f8015a, new RunnableC2976g(this, c13226a.f8016b));
            }
        }

        @CheckResult
        /* renamed from: g */
        public a m3593g(int i, @Nullable MediaSource2.a aVar) {
            return new a(this.f8014c, i, aVar);
        }

        public a(CopyOnWriteArrayList<C13226a> copyOnWriteArrayList, int i, @Nullable MediaSource2.a aVar) {
            this.f8014c = copyOnWriteArrayList;
            this.f8012a = i;
            this.f8013b = aVar;
        }
    }
}
