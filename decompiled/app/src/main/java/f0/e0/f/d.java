package f0.e0.f;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TaskRunner.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final d a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f3611b;
    public static final b c = new b(null);
    public int d;
    public boolean e;
    public long f;
    public final List<f0.e0.f.c> g;
    public final List<f0.e0.f.c> h;
    public final Runnable i;
    public final a j;

    /* compiled from: TaskRunner.kt */
    public interface a {
        void a(d dVar);

        void b(d dVar, long j);

        long c();

        void execute(Runnable runnable);
    }

    /* compiled from: TaskRunner.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: TaskRunner.kt */
    public static final class c implements a {
        public final ThreadPoolExecutor a;

        public c(ThreadFactory threadFactory) {
            m.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // f0.e0.f.d.a
        public void a(d dVar) {
            m.checkParameterIsNotNull(dVar, "taskRunner");
            dVar.notify();
        }

        @Override // f0.e0.f.d.a
        public void b(d dVar, long j) throws InterruptedException {
            m.checkParameterIsNotNull(dVar, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                dVar.wait(j2, (int) j3);
            }
        }

        @Override // f0.e0.f.d.a
        public long c() {
            return System.nanoTime();
        }

        @Override // f0.e0.f.d.a
        public void execute(Runnable runnable) {
            m.checkParameterIsNotNull(runnable, "runnable");
            this.a.execute(runnable);
        }
    }

    /* compiled from: TaskRunner.kt */
    /* renamed from: f0.e0.f.d$d, reason: collision with other inner class name */
    public static final class RunnableC0605d implements Runnable {
        public RunnableC0605d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0.e0.f.a aVarC;
            while (true) {
                synchronized (d.this) {
                    aVarC = d.this.c();
                }
                if (aVarC == null) {
                    return;
                }
                f0.e0.f.c cVar = aVarC.a;
                if (cVar == null) {
                    m.throwNpe();
                }
                long jC = -1;
                b bVar = d.c;
                boolean zIsLoggable = d.f3611b.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jC = cVar.e.j.c();
                    f.e(aVarC, cVar, "starting");
                }
                try {
                    d.a(d.this, aVarC);
                    if (zIsLoggable) {
                        long jC2 = cVar.e.j.c() - jC;
                        StringBuilder sbU = b.d.b.a.a.U("finished run in ");
                        sbU.append(f.a0(jC2));
                        f.e(aVarC, cVar, sbU.toString());
                    }
                } finally {
                }
            }
        }
    }

    static {
        String str = f0.e0.c.g + " TaskRunner";
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        a = new d(new c(new f0.e0.b(str, true)));
        Logger logger = Logger.getLogger(d.class.getName());
        m.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f3611b = logger;
    }

    public d(a aVar) {
        m.checkParameterIsNotNull(aVar, "backend");
        this.j = aVar;
        this.d = 10000;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new RunnableC0605d();
    }

    public static final void a(d dVar, f0.e0.f.a aVar) {
        Objects.requireNonNull(dVar);
        byte[] bArr = f0.e0.c.a;
        Thread threadCurrentThread = Thread.currentThread();
        m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.c);
        try {
            long jA = aVar.a();
            synchronized (dVar) {
                dVar.b(aVar, jA);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (dVar) {
                dVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(f0.e0.f.a aVar, long j) {
        byte[] bArr = f0.e0.c.a;
        f0.e0.f.c cVar = aVar.a;
        if (cVar == null) {
            m.throwNpe();
        }
        if (!(cVar.f3610b == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean z2 = cVar.d;
        cVar.d = false;
        cVar.f3610b = null;
        this.g.remove(cVar);
        if (j != -1 && !z2 && !cVar.a) {
            cVar.e(aVar, j, true);
        }
        if (!cVar.c.isEmpty()) {
            this.h.add(cVar);
        }
    }

    public final f0.e0.f.a c() {
        boolean z2;
        byte[] bArr = f0.e0.c.a;
        while (!this.h.isEmpty()) {
            long jC = this.j.c();
            long jMin = RecyclerView.FOREVER_NS;
            Iterator<f0.e0.f.c> it = this.h.iterator();
            f0.e0.f.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                f0.e0.f.a aVar2 = it.next().c.get(0);
                long jMax = Math.max(0L, aVar2.f3609b - jC);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z2 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                byte[] bArr2 = f0.e0.c.a;
                aVar.f3609b = -1L;
                f0.e0.f.c cVar = aVar.a;
                if (cVar == null) {
                    m.throwNpe();
                }
                cVar.c.remove(aVar);
                this.h.remove(cVar);
                cVar.f3610b = aVar;
                this.g.add(cVar);
                if (z2 || (!this.e && (!this.h.isEmpty()))) {
                    this.j.execute(this.i);
                }
                return aVar;
            }
            if (this.e) {
                if (jMin < this.f - jC) {
                    this.j.a(this);
                }
                return null;
            }
            this.e = true;
            this.f = jC + jMin;
            try {
                try {
                    this.j.b(this, jMin);
                } catch (InterruptedException unused) {
                    d();
                }
            } finally {
                this.e = false;
            }
        }
        return null;
    }

    public final void d() {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            this.g.get(size).b();
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            f0.e0.f.c cVar = this.h.get(size2);
            cVar.b();
            if (cVar.c.isEmpty()) {
                this.h.remove(size2);
            }
        }
    }

    public final void e(f0.e0.f.c cVar) {
        m.checkParameterIsNotNull(cVar, "taskQueue");
        byte[] bArr = f0.e0.c.a;
        if (cVar.f3610b == null) {
            if (!cVar.c.isEmpty()) {
                List<f0.e0.f.c> list = this.h;
                m.checkParameterIsNotNull(list, "$this$addIfAbsent");
                if (!list.contains(cVar)) {
                    list.add(cVar);
                }
            } else {
                this.h.remove(cVar);
            }
        }
        if (this.e) {
            this.j.a(this);
        } else {
            this.j.execute(this.i);
        }
    }

    public final f0.e0.f.c f() {
        int i;
        synchronized (this) {
            i = this.d;
            this.d = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new f0.e0.f.c(this, sb.toString());
    }
}
