package p659s.p660a.p666e2;

import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p512d0._Ranges;
import p659s.p660a.p661a.SystemProps;

/* JADX INFO: renamed from: s.a.e2.k, reason: use source file name */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Tasks7 {

    /* JADX INFO: renamed from: a */
    public static final long f27831a = C3404f.m4317m1("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: b */
    public static final int f27832b;

    /* JADX INFO: renamed from: c */
    public static final int f27833c;

    /* JADX INFO: renamed from: d */
    public static final long f27834d;

    /* JADX INFO: renamed from: e */
    public static Tasks8 f27835e;

    static {
        C3404f.m4313l1("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int i = SystemProps.f27706a;
        int iM4313l1 = C3404f.m4313l1("kotlinx.coroutines.scheduler.core.pool.size", _Ranges.coerceAtLeast(i, 2), 1, 0, 8, null);
        f27832b = iM4313l1;
        f27833c = C3404f.m4313l1("kotlinx.coroutines.scheduler.max.pool.size", _Ranges.coerceIn(i * 128, iM4313l1, 2097150), 0, 2097150, 4, null);
        f27834d = TimeUnit.SECONDS.toNanos(C3404f.m4317m1("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f27835e = Tasks2.f27826a;
    }
}
