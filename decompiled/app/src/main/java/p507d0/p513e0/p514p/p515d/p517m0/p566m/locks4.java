package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.l, reason: use source file name */
/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface locks4 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f24733a = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.l$a */
    /* JADX INFO: compiled from: locks.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f24734a = new a();

        public final locks2 simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            return (runnable == null || function1 == null) ? new locks2(null, 1, null) : new locks(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
