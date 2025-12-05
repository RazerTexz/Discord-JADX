package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: locks.kt */
/* renamed from: d0.e0.p.d.m0.m.d, reason: use source file name */
/* loaded from: classes3.dex */
public class locks2 implements locks4 {

    /* renamed from: b */
    public final Lock f24707b;

    public locks2(Lock lock) {
        Intrinsics3.checkNotNullParameter(lock, "lock");
        this.f24707b = lock;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.locks4
    public void lock() {
        this.f24707b.lock();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.locks4
    public void unlock() {
        this.f24707b.unlock();
    }

    public /* synthetic */ locks2(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
