package p007b.p225i.p226a.p242c.p257e3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BandwidthMeter.java */
/* renamed from: b.i.a.c.e3.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface BandwidthMeter {

    /* compiled from: BandwidthMeter.java */
    /* renamed from: b.i.a.c.e3.f$a */
    public interface a {

        /* compiled from: BandwidthMeter.java */
        /* renamed from: b.i.a.c.e3.f$a$a, reason: collision with other inner class name */
        public static final class C13224a {

            /* renamed from: a */
            public final CopyOnWriteArrayList<C13225a> f6524a = new CopyOnWriteArrayList<>();

            /* compiled from: BandwidthMeter.java */
            /* renamed from: b.i.a.c.e3.f$a$a$a, reason: collision with other inner class name */
            public static final class C13225a {

                /* renamed from: a */
                public final Handler f6525a;

                /* renamed from: b */
                public final a f6526b;

                /* renamed from: c */
                public boolean f6527c;

                public C13225a(Handler handler, a aVar) {
                    this.f6525a = handler;
                    this.f6526b = aVar;
                }
            }

            /* renamed from: a */
            public void m2847a(a aVar) {
                for (C13225a c13225a : this.f6524a) {
                    if (c13225a.f6526b == aVar) {
                        c13225a.f6527c = true;
                        this.f6524a.remove(c13225a);
                    }
                }
            }
        }
    }

    @Nullable
    /* renamed from: c */
    TransferListener mo2844c();

    /* renamed from: d */
    void mo2845d(a aVar);

    /* renamed from: f */
    void mo2846f(Handler handler, a aVar);
}
