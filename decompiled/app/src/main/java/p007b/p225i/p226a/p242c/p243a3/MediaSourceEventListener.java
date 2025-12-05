package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: MediaSourceEventListener.java */
/* renamed from: b.i.a.c.a3.b0, reason: use source file name */
/* loaded from: classes3.dex */
public interface MediaSourceEventListener {
    /* renamed from: X */
    void mo2461X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    /* renamed from: g0 */
    void mo2462g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    /* renamed from: o */
    void mo2463o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData);

    /* renamed from: q */
    void mo2464q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    /* renamed from: x */
    void mo2465x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    /* compiled from: MediaSourceEventListener.java */
    /* renamed from: b.i.a.c.a3.b0$a */
    public static class a {

        /* renamed from: a */
        public final int f5481a;

        /* renamed from: b */
        @Nullable
        public final MediaSource2.a f5482b;

        /* renamed from: c */
        public final CopyOnWriteArrayList<C13222a> f5483c;

        /* renamed from: d */
        public final long f5484d;

        /* compiled from: MediaSourceEventListener.java */
        /* renamed from: b.i.a.c.a3.b0$a$a, reason: collision with other inner class name */
        public static final class C13222a {

            /* renamed from: a */
            public Handler f5485a;

            /* renamed from: b */
            public MediaSourceEventListener f5486b;

            public C13222a(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f5485a = handler;
                this.f5486b = mediaSourceEventListener;
            }
        }

        public a() {
            this.f5483c = new CopyOnWriteArrayList<>();
            this.f5481a = 0;
            this.f5482b = null;
            this.f5484d = 0L;
        }

        /* renamed from: a */
        public final long m2466a(long j) {
            long jM2992M = Util2.m2992M(j);
            if (jM2992M == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f5484d + jM2992M;
        }

        /* renamed from: b */
        public void m2467b(MediaLoadData mediaLoadData) {
            for (C13222a c13222a : this.f5483c) {
                Util2.m2984E(c13222a.f5485a, new RunnableC2535d(this, c13222a.f5486b, mediaLoadData));
            }
        }

        /* renamed from: c */
        public void m2468c(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            for (C13222a c13222a : this.f5483c) {
                Util2.m2984E(c13222a.f5485a, new RunnableC2539f(this, c13222a.f5486b, loadEventInfo, mediaLoadData));
            }
        }

        /* renamed from: d */
        public void m2469d(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            for (C13222a c13222a : this.f5483c) {
                Util2.m2984E(c13222a.f5485a, new RunnableC2533c(this, c13222a.f5486b, loadEventInfo, mediaLoadData));
            }
        }

        /* renamed from: e */
        public void m2470e(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            for (C13222a c13222a : this.f5483c) {
                Util2.m2984E(c13222a.f5485a, new RunnableC2531b(this, c13222a.f5486b, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        /* renamed from: f */
        public void m2471f(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            for (C13222a c13222a : this.f5483c) {
                Util2.m2984E(c13222a.f5485a, new RunnableC2537e(this, c13222a.f5486b, loadEventInfo, mediaLoadData));
            }
        }

        @CheckResult
        /* renamed from: g */
        public a m2472g(int i, @Nullable MediaSource2.a aVar, long j) {
            return new a(this.f5483c, i, aVar, j);
        }

        public a(CopyOnWriteArrayList<C13222a> copyOnWriteArrayList, int i, @Nullable MediaSource2.a aVar, long j) {
            this.f5483c = copyOnWriteArrayList;
            this.f5481a = i;
            this.f5482b = aVar;
            this.f5484d = j;
        }
    }
}
