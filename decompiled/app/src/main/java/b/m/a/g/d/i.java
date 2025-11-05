package b.m.a.g.d;

import b.m.a.g.d.e;
import com.lyft.kronos.internal.ntp.NTPSyncException;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SntpService.kt */
/* loaded from: classes3.dex */
public final class i implements h {
    public final AtomicReference<a> a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f1909b;
    public final ExecutorService c;
    public final e d;
    public final b.m.a.b e;
    public final f f;
    public final b.m.a.e g;
    public final List<String> h;
    public final long i;
    public final long j;
    public final long k;

    /* compiled from: SntpService.kt */
    public enum a {
        INIT,
        IDLE,
        SYNCING,
        STOPPED
    }

    /* compiled from: SntpService.kt */
    public static final class b implements ThreadFactory {
        public static final b j = new b();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "kronos-android");
        }
    }

    /* compiled from: SntpService.kt */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z2;
            i iVar = i.this;
            iVar.c();
            Iterator<String> it = iVar.h.iterator();
            do {
                z2 = false;
                if (!it.hasNext()) {
                    return;
                }
                String next = it.next();
                a aVar = a.IDLE;
                AtomicReference<a> atomicReference = iVar.a;
                a aVar2 = a.SYNCING;
                if (atomicReference.getAndSet(aVar2) != aVar2) {
                    long jB = iVar.e.b();
                    b.m.a.e eVar = iVar.g;
                    if (eVar != null) {
                        eVar.a(next);
                    }
                    try {
                        e.b bVarD = iVar.d.d(next, Long.valueOf(iVar.i));
                        m.checkExpressionValueIsNotNull(bVarD, "response");
                        if (bVarD.a() < 0) {
                            throw new NTPSyncException("Invalid time " + bVarD.a() + " received from " + next);
                        }
                        iVar.f.a(bVarD);
                        long j = bVarD.c;
                        long jB2 = iVar.e.b() - jB;
                        b.m.a.e eVar2 = iVar.g;
                        if (eVar2 != null) {
                            eVar2.b(j, jB2);
                        }
                        iVar.a.set(aVar);
                        iVar.f1909b.set(iVar.e.b());
                        z2 = true;
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            } while (!z2);
        }
    }

    public i(e eVar, b.m.a.b bVar, f fVar, b.m.a.e eVar2, List<String> list, long j, long j2, long j3) {
        m.checkParameterIsNotNull(eVar, "sntpClient");
        m.checkParameterIsNotNull(bVar, "deviceClock");
        m.checkParameterIsNotNull(fVar, "responseCache");
        m.checkParameterIsNotNull(list, "ntpHosts");
        this.d = eVar;
        this.e = bVar;
        this.f = fVar;
        this.g = eVar2;
        this.h = list;
        this.i = j;
        this.j = j2;
        this.k = j3;
        this.a = new AtomicReference<>(a.INIT);
        this.f1909b = new AtomicLong(0L);
        this.c = Executors.newSingleThreadExecutor(b.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    @Override // b.m.a.g.d.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.m.a.d a() {
        c();
        e.b bVar = this.f.get();
        boolean z2 = true;
        if (!this.a.compareAndSet(a.INIT, a.IDLE) || bVar == null) {
            z2 = false;
        } else {
            if (Math.abs((bVar.a - bVar.f1907b) - (bVar.d.a() - bVar.d.b())) < 1000) {
            }
        }
        if (z2) {
            this.f.clear();
            bVar = null;
        }
        if (bVar == null) {
            if (this.e.b() - this.f1909b.get() >= this.j) {
                b();
            }
            return null;
        }
        long jB = bVar.d.b() - bVar.f1907b;
        if (jB >= this.k && this.e.b() - this.f1909b.get() >= this.j) {
            b();
        }
        return new b.m.a.d(bVar.a(), Long.valueOf(jB));
    }

    @Override // b.m.a.g.d.h
    public void b() {
        c();
        if (this.a.get() != a.SYNCING) {
            this.c.submit(new c());
        }
    }

    public final void c() {
        if (this.a.get() == a.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }
}
