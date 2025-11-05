package b.i.a.c.e3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BandwidthMeter.java */
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: BandwidthMeter.java */
    public interface a {

        /* compiled from: BandwidthMeter.java */
        /* renamed from: b.i.a.c.e3.f$a$a, reason: collision with other inner class name */
        public static final class C0099a {
            public final CopyOnWriteArrayList<C0100a> a = new CopyOnWriteArrayList<>();

            /* compiled from: BandwidthMeter.java */
            /* renamed from: b.i.a.c.e3.f$a$a$a, reason: collision with other inner class name */
            public static final class C0100a {
                public final Handler a;

                /* renamed from: b, reason: collision with root package name */
                public final a f940b;
                public boolean c;

                public C0100a(Handler handler, a aVar) {
                    this.a = handler;
                    this.f940b = aVar;
                }
            }

            public void a(a aVar) {
                Iterator<C0100a> it = this.a.iterator();
                while (it.hasNext()) {
                    C0100a next = it.next();
                    if (next.f940b == aVar) {
                        next.c = true;
                        this.a.remove(next);
                    }
                }
            }
        }
    }

    @Nullable
    a0 c();

    void d(a aVar);

    void f(Handler handler, a aVar);
}
