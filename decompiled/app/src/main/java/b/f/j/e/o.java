package b.f.j.e;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PriorityThreadFactory.java */
/* loaded from: classes.dex */
public class o implements ThreadFactory {
    public final int j;
    public final String k;
    public final boolean l;
    public final AtomicInteger m = new AtomicInteger(1);

    /* compiled from: PriorityThreadFactory.java */
    public class a implements Runnable {
        public final /* synthetic */ Runnable j;

        public a(Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(o.this.j);
            } catch (Throwable unused) {
            }
            this.j.run();
        }
    }

    public o(int i, String str, boolean z2) {
        this.j = i;
        this.k = str;
        this.l = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.l) {
            str = this.k + "-" + this.m.getAndIncrement();
        } else {
            str = this.k;
        }
        return new Thread(aVar, str);
    }
}
