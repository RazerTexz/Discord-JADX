package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: SequenceBuilder.kt */
/* renamed from: d0.f0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class SequenceBuilder<T> extends SequenceBuilder2<T> implements Iterator<T>, Continuation<Unit>, KMarkers {

    /* renamed from: j */
    public int f25100j;

    /* renamed from: k */
    public T f25101k;

    /* renamed from: l */
    public Iterator<? extends T> f25102l;

    /* renamed from: m */
    public Continuation<? super Unit> f25103m;

    /* renamed from: b */
    public final Throwable m10064b() {
        int i = this.f25100j;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        StringBuilder sbM833U = outline.m833U("Unexpected state of the iterator: ");
        sbM833U.append(this.f25100j);
        return new IllegalStateException(sbM833U.toString());
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return CoroutineContextImpl4.f25237j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.f25100j;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw m10064b();
                }
                Iterator<? extends T> it = this.f25102l;
                Intrinsics3.checkNotNull(it);
                if (it.hasNext()) {
                    this.f25100j = 2;
                    return true;
                }
                this.f25102l = null;
            }
            this.f25100j = 5;
            Continuation<? super Unit> continuation = this.f25103m;
            Intrinsics3.checkNotNull(continuation);
            this.f25103m = null;
            Unit unit = Unit.f27425a;
            Result2.a aVar = Result2.f25169j;
            continuation.resumeWith(Result2.m11474constructorimpl(unit));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i = this.f25100j;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f25100j = 1;
            Iterator<? extends T> it = this.f25102l;
            Intrinsics3.checkNotNull(it);
            return it.next();
        }
        if (i != 3) {
            throw m10064b();
        }
        this.f25100j = 0;
        T t = this.f25101k;
        this.f25101k = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Result3.throwOnFailure(obj);
        this.f25100j = 4;
    }

    public final void setNextStep(Continuation<? super Unit> continuation) {
        this.f25103m = continuation;
    }

    @Override // p507d0.p578f0.SequenceBuilder2
    public Object yield(T t, Continuation<? super Unit> continuation) {
        this.f25101k = t;
        this.f25100j = 3;
        this.f25103m = continuation;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == Intrinsics2.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.f27425a;
    }

    @Override // p507d0.p578f0.SequenceBuilder2
    public Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.f27425a;
        }
        this.f25102l = it;
        this.f25100j = 2;
        this.f25103m = continuation;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == Intrinsics2.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.f27425a;
    }
}
