package p007b.p085c.p086a;

import java.util.ArrayList;
import java.util.Iterator;
import p007b.p085c.p086a.p089b0.Logger2;

/* JADX INFO: renamed from: b.c.a.q, reason: use source file name */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieTask implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ LottieTask2 f2451j;

    public LottieTask(LottieTask2 lottieTask2) {
        this.f2451j = lottieTask2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.f2451j.f2456e == null) {
            return;
        }
        LottieResult<T> lottieResult = this.f2451j.f2456e;
        V v = lottieResult.f2449a;
        if (v != 0) {
            LottieTask2 lottieTask2 = this.f2451j;
            synchronized (lottieTask2) {
                Iterator it = new ArrayList(lottieTask2.f2453b).iterator();
                while (it.hasNext()) {
                    ((LottieListener) it.next()).mo680a(v);
                }
            }
            return;
        }
        LottieTask2 lottieTask22 = this.f2451j;
        Throwable th = lottieResult.f2450b;
        synchronized (lottieTask22) {
            ArrayList arrayList = new ArrayList(lottieTask22.f2454c);
            if (arrayList.isEmpty()) {
                Logger2.m641c("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((LottieListener) it2.next()).mo680a(th);
            }
        }
    }
}
