package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: locks.kt */
/* renamed from: d0.e0.p.d.m0.m.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class locks extends locks2 {

    /* renamed from: c */
    public final Runnable f24705c;

    /* renamed from: d */
    public final Function1<InterruptedException, Unit> f24706d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public locks(Lock lock, Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        Intrinsics3.checkNotNullParameter(lock, "lock");
        Intrinsics3.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics3.checkNotNullParameter(function1, "interruptedExceptionHandler");
        this.f24705c = runnable;
        this.f24706d = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.locks2, p507d0.p513e0.p514p.p515d.p517m0.p566m.locks4
    public void lock() {
        while (!this.f24707b.tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f24705c.run();
            } catch (InterruptedException e) {
                this.f24706d.invoke(e);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public locks(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        Intrinsics3.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics3.checkNotNullParameter(function1, "interruptedExceptionHandler");
    }
}
