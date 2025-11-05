package d0.e0.p.d.m0.m;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public interface l {
    public static final /* synthetic */ int a = 0;

    /* compiled from: locks.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        public final d simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            return (runnable == null || function1 == null) ? new d(null, 1, null) : new c(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
