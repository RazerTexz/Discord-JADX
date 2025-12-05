package p007b.p109f.p148h.p149a.p150a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p148h.p149a.p150a.AnimationBackend;

/* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* renamed from: b.f.h.a.a.c, reason: use source file name */
/* loaded from: classes.dex */
public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {

    /* renamed from: b */
    public final MonotonicClock f3489b;

    /* renamed from: c */
    public final ScheduledExecutorService f3490c;

    /* renamed from: d */
    public boolean f3491d;

    /* renamed from: e */
    public long f3492e;

    /* renamed from: f */
    public b f3493f;

    /* renamed from: g */
    public final Runnable f3494g;

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    /* renamed from: b.f.h.a.a.c$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AnimationBackendDelegateWithInactivityCheck.this) {
                AnimationBackendDelegateWithInactivityCheck animationBackendDelegateWithInactivityCheck = AnimationBackendDelegateWithInactivityCheck.this;
                animationBackendDelegateWithInactivityCheck.f3491d = false;
                if (animationBackendDelegateWithInactivityCheck.f3489b.now() - animationBackendDelegateWithInactivityCheck.f3492e > 2000) {
                    b bVar = AnimationBackendDelegateWithInactivityCheck.this.f3493f;
                    if (bVar != null) {
                        bVar.mo1146c();
                    }
                } else {
                    AnimationBackendDelegateWithInactivityCheck.this.m1145c();
                }
            }
        }
    }

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    /* renamed from: b.f.h.a.a.c$b */
    public interface b {
        /* renamed from: c */
        void mo1146c();
    }

    public AnimationBackendDelegateWithInactivityCheck(T t, b bVar, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.f3491d = false;
        this.f3494g = new a();
        this.f3493f = bVar;
        this.f3489b = monotonicClock;
        this.f3490c = scheduledExecutorService;
    }

    /* renamed from: c */
    public final synchronized void m1145c() {
        if (!this.f3491d) {
            this.f3491d = true;
            this.f3490c.schedule(this.f3494g, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackendDelegate, p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* renamed from: j */
    public boolean mo1141j(Drawable drawable, Canvas canvas, int i) {
        this.f3492e = this.f3489b.now();
        boolean zMo1141j = super.mo1141j(drawable, canvas, i);
        m1145c();
        return zMo1141j;
    }
}
