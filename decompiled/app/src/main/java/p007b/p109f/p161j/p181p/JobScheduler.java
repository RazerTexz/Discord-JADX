package p007b.p109f.p161j.p181p;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.c0, reason: use source file name */
/* JADX INFO: compiled from: JobScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class JobScheduler {

    /* JADX INFO: renamed from: a */
    public final Executor f3999a;

    /* JADX INFO: renamed from: b */
    public final c f4000b;

    /* JADX INFO: renamed from: e */
    public final int f4003e;

    /* JADX INFO: renamed from: c */
    public final Runnable f4001c = new a();

    /* JADX INFO: renamed from: d */
    public final Runnable f4002d = new b();

    /* JADX INFO: renamed from: f */
    @VisibleForTesting
    public EncodedImage2 f4004f = null;

    /* JADX INFO: renamed from: g */
    @VisibleForTesting
    public int f4005g = 0;

    /* JADX INFO: renamed from: h */
    @VisibleForTesting
    public int f4006h = 1;

    /* JADX INFO: renamed from: i */
    @VisibleForTesting
    public long f4007i = 0;

    /* JADX INFO: renamed from: j */
    @VisibleForTesting
    public long f4008j = 0;

    /* JADX INFO: renamed from: b.f.j.p.c0$a */
    /* JADX INFO: compiled from: JobScheduler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EncodedImage2 encodedImage2;
            int i;
            JobScheduler jobScheduler = JobScheduler.this;
            Objects.requireNonNull(jobScheduler);
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (jobScheduler) {
                encodedImage2 = jobScheduler.f4004f;
                i = jobScheduler.f4005g;
                jobScheduler.f4004f = null;
                jobScheduler.f4005g = 0;
                jobScheduler.f4006h = 3;
                jobScheduler.f4008j = jUptimeMillis;
            }
            try {
                if (JobScheduler.m1430e(encodedImage2, i)) {
                    jobScheduler.f4000b.mo1436a(encodedImage2, i);
                }
            } finally {
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                jobScheduler.m1433c();
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.c0$b */
    /* JADX INFO: compiled from: JobScheduler.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.f3999a.execute(jobScheduler.f4001c);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.c0$c */
    /* JADX INFO: compiled from: JobScheduler.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo1436a(EncodedImage2 encodedImage2, int i);
    }

    public JobScheduler(Executor executor, c cVar, int i) {
        this.f3999a = executor;
        this.f4000b = cVar;
        this.f4003e = i;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m1430e(EncodedImage2 encodedImage2, int i) {
        return BaseConsumer.m1419e(i) || BaseConsumer.m1422m(i, 4) || EncodedImage2.m1338u(encodedImage2);
    }

    /* JADX INFO: renamed from: a */
    public void m1431a() {
        EncodedImage2 encodedImage2;
        synchronized (this) {
            encodedImage2 = this.f4004f;
            this.f4004f = null;
            this.f4005g = 0;
        }
        if (encodedImage2 != null) {
            encodedImage2.close();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1432b(long j) {
        Runnable runnable = this.f4002d;
        if (j <= 0) {
            runnable.run();
            return;
        }
        if (AnimatableValueParser.f2217b == null) {
            AnimatableValueParser.f2217b = Executors.newSingleThreadScheduledExecutor();
        }
        AnimatableValueParser.f2217b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: c */
    public final void m1433c() {
        boolean z2;
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            z2 = true;
            if (this.f4006h == 4) {
                jMax = Math.max(this.f4008j + ((long) this.f4003e), jUptimeMillis);
                this.f4007i = jUptimeMillis;
                this.f4006h = 2;
            } else {
                this.f4006h = 1;
                jMax = 0;
                z2 = false;
            }
        }
        if (z2) {
            m1432b(jMax - jUptimeMillis);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m1434d() {
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z2 = false;
            if (!m1430e(this.f4004f, this.f4005g)) {
                return false;
            }
            int iM758h = C1563b.m758h(this.f4006h);
            if (iM758h != 0) {
                if (iM758h == 2) {
                    this.f4006h = 4;
                }
                jMax = 0;
            } else {
                jMax = Math.max(this.f4008j + ((long) this.f4003e), jUptimeMillis);
                this.f4007i = jUptimeMillis;
                this.f4006h = 2;
                z2 = true;
            }
            if (z2) {
                m1432b(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m1435f(EncodedImage2 encodedImage2, int i) {
        EncodedImage2 encodedImage22;
        if (!m1430e(encodedImage2, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage22 = this.f4004f;
            this.f4004f = EncodedImage2.m1336a(encodedImage2);
            this.f4005g = i;
        }
        if (encodedImage22 == null) {
            return true;
        }
        encodedImage22.close();
        return true;
    }
}
