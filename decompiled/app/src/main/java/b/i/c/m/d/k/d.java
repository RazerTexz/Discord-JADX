package b.i.c.m.d.k;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* loaded from: classes3.dex */
public abstract class d implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        a();
    }
}
