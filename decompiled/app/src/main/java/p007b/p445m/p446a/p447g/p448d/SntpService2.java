package p007b.p445m.p446a.p447g.p448d;

import com.lyft.kronos.internal.ntp.NTPSyncException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p445m.p446a.Clock5;
import p007b.p445m.p446a.Clock6;
import p007b.p445m.p446a.SyncListener;
import p007b.p445m.p446a.p447g.p448d.SntpClient;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.d.i, reason: use source file name */
/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SntpService2 implements SntpService {

    /* JADX INFO: renamed from: a */
    public final AtomicReference<a> f13658a;

    /* JADX INFO: renamed from: b */
    public final AtomicLong f13659b;

    /* JADX INFO: renamed from: c */
    public final ExecutorService f13660c;

    /* JADX INFO: renamed from: d */
    public final SntpClient f13661d;

    /* JADX INFO: renamed from: e */
    public final Clock5 f13662e;

    /* JADX INFO: renamed from: f */
    public final SntpResponseCache f13663f;

    /* JADX INFO: renamed from: g */
    public final SyncListener f13664g;

    /* JADX INFO: renamed from: h */
    public final List<String> f13665h;

    /* JADX INFO: renamed from: i */
    public final long f13666i;

    /* JADX INFO: renamed from: j */
    public final long f13667j;

    /* JADX INFO: renamed from: k */
    public final long f13668k;

    /* JADX INFO: renamed from: b.m.a.g.d.i$a */
    /* JADX INFO: compiled from: SntpService.kt */
    public enum a {
        INIT,
        IDLE,
        SYNCING,
        STOPPED
    }

    /* JADX INFO: renamed from: b.m.a.g.d.i$b */
    /* JADX INFO: compiled from: SntpService.kt */
    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: j */
        public static final b f13674j = new b();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "kronos-android");
        }
    }

    /* JADX INFO: renamed from: b.m.a.g.d.i$c */
    /* JADX INFO: compiled from: SntpService.kt */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z2;
            SntpService2 sntpService2 = SntpService2.this;
            sntpService2.m7152c();
            Iterator<String> it = sntpService2.f13665h.iterator();
            do {
                z2 = false;
                if (!it.hasNext()) {
                    return;
                }
                String next = it.next();
                a aVar = a.IDLE;
                AtomicReference<a> atomicReference = sntpService2.f13658a;
                a aVar2 = a.SYNCING;
                if (atomicReference.getAndSet(aVar2) != aVar2) {
                    long jMo7129b = sntpService2.f13662e.mo7129b();
                    SyncListener syncListener = sntpService2.f13664g;
                    if (syncListener != null) {
                        syncListener.m7130a(next);
                    }
                    try {
                        SntpClient.b bVarM7147d = sntpService2.f13661d.m7147d(next, Long.valueOf(sntpService2.f13666i));
                        Intrinsics3.checkExpressionValueIsNotNull(bVarM7147d, "response");
                        if (bVarM7147d.m7148a() < 0) {
                            throw new NTPSyncException("Invalid time " + bVarM7147d.m7148a() + " received from " + next);
                        }
                        sntpService2.f13663f.mo7149a(bVarM7147d);
                        long j = bVarM7147d.f13654c;
                        long jMo7129b2 = sntpService2.f13662e.mo7129b() - jMo7129b;
                        SyncListener syncListener2 = sntpService2.f13664g;
                        if (syncListener2 != null) {
                            syncListener2.m7131b(j, jMo7129b2);
                        }
                        sntpService2.f13658a.set(aVar);
                        sntpService2.f13659b.set(sntpService2.f13662e.mo7129b());
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

    public SntpService2(SntpClient sntpClient, Clock5 clock5, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        Intrinsics3.checkParameterIsNotNull(sntpClient, "sntpClient");
        Intrinsics3.checkParameterIsNotNull(clock5, "deviceClock");
        Intrinsics3.checkParameterIsNotNull(sntpResponseCache, "responseCache");
        Intrinsics3.checkParameterIsNotNull(list, "ntpHosts");
        this.f13661d = sntpClient;
        this.f13662e = clock5;
        this.f13663f = sntpResponseCache;
        this.f13664g = syncListener;
        this.f13665h = list;
        this.f13666i = j;
        this.f13667j = j2;
        this.f13668k = j3;
        this.f13658a = new AtomicReference<>(a.INIT);
        this.f13659b = new AtomicLong(0L);
        this.f13660c = Executors.newSingleThreadExecutor(b.f13674j);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    @Override // p007b.p445m.p446a.p447g.p448d.SntpService
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Clock6 mo7150a() {
        m7152c();
        SntpClient.b bVar = this.f13663f.get();
        boolean z2 = true;
        if (!this.f13658a.compareAndSet(a.INIT, a.IDLE) || bVar == null) {
            z2 = false;
        } else {
            if (Math.abs((bVar.f13652a - bVar.f13653b) - (bVar.f13655d.mo7128a() - bVar.f13655d.mo7129b())) < 1000) {
            }
        }
        if (z2) {
            this.f13663f.clear();
            bVar = null;
        }
        if (bVar == null) {
            if (this.f13662e.mo7129b() - this.f13659b.get() >= this.f13667j) {
                mo7151b();
            }
            return null;
        }
        long jMo7129b = bVar.f13655d.mo7129b() - bVar.f13653b;
        if (jMo7129b >= this.f13668k && this.f13662e.mo7129b() - this.f13659b.get() >= this.f13667j) {
            mo7151b();
        }
        return new Clock6(bVar.m7148a(), Long.valueOf(jMo7129b));
    }

    @Override // p007b.p445m.p446a.p447g.p448d.SntpService
    /* JADX INFO: renamed from: b */
    public void mo7151b() {
        m7152c();
        if (this.f13658a.get() != a.SYNCING) {
            this.f13660c.submit(new c());
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7152c() {
        if (this.f13658a.get() == a.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }
}
