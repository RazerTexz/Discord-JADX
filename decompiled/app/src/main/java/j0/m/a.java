package j0.m;

import b.i.a.f.e.o.f;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: BlockingObservable.java */
/* loaded from: classes3.dex */
public final class a<T> {
    public final Observable<? extends T> a;

    /* compiled from: BlockingObservable.java */
    /* renamed from: j0.m.a$a, reason: collision with other inner class name */
    public class C0635a extends Subscriber<T> {
        public final /* synthetic */ CountDownLatch j;
        public final /* synthetic */ AtomicReference k;
        public final /* synthetic */ AtomicReference l;

        public C0635a(a aVar, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.j = countDownLatch;
            this.k = atomicReference;
            this.l = atomicReference2;
        }

        @Override // j0.g
        public void onCompleted() {
            this.j.countDown();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            this.k.set(th);
            this.j.countDown();
        }

        @Override // j0.g
        public void onNext(T t) {
            this.l.set(t);
        }
    }

    public a(Observable<? extends T> observable) {
        this.a = observable;
    }

    public final T a(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Subscription subscriptionU = observable.U(new C0635a(this, countDownLatch, atomicReference2, atomicReference));
        if (countDownLatch.getCount() != 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                subscriptionU.unsubscribe();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        if (atomicReference2.get() == null) {
            return (T) atomicReference.get();
        }
        f.V0((Throwable) atomicReference2.get());
        throw null;
    }

    public T b() {
        return a(this.a.R());
    }
}
