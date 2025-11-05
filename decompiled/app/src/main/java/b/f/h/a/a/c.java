package b.f.h.a.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import b.f.h.a.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* loaded from: classes.dex */
public class c<T extends b.f.h.a.a.a> extends b.f.h.a.a.b<T> {

    /* renamed from: b, reason: collision with root package name */
    public final b.f.d.k.b f525b;
    public final ScheduledExecutorService c;
    public boolean d;
    public long e;
    public b f;
    public final Runnable g;

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                c cVar = c.this;
                cVar.d = false;
                if (cVar.f525b.now() - cVar.e > 2000) {
                    b bVar = c.this.f;
                    if (bVar != null) {
                        bVar.c();
                    }
                } else {
                    c.this.c();
                }
            }
        }
    }

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public interface b {
        void c();
    }

    public c(T t, b bVar, b.f.d.k.b bVar2, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.d = false;
        this.g = new a();
        this.f = bVar;
        this.f525b = bVar2;
        this.c = scheduledExecutorService;
    }

    public final synchronized void c() {
        if (!this.d) {
            this.d = true;
            this.c.schedule(this.g, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // b.f.h.a.a.b, b.f.h.a.a.a
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        this.e = this.f525b.now();
        boolean zJ = super.j(drawable, canvas, i);
        c();
        return zJ;
    }
}
