package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* renamed from: b.i.c.m.d.k.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    /* renamed from: a */
    public abstract void mo6398a();

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        mo6398a();
    }
}
