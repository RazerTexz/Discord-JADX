package p637j0.p642l.p643a;

import java.util.NoSuchElementException;
import p637j0.SingleSubscriber;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeSingle<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f26762j;

    /* JADX INFO: renamed from: k */
    public boolean f26763k;

    /* JADX INFO: renamed from: l */
    public T f26764l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ SingleSubscriber f26765m;

    public OnSubscribeSingle(OnSubscribeSingle2 onSubscribeSingle2, SingleSubscriber singleSubscriber) {
        this.f26765m = singleSubscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26762j) {
            return;
        }
        if (this.f26763k) {
            this.f26765m.m10736b(this.f26764l);
        } else {
            this.f26765m.m10735a(new NoSuchElementException("Observable emitted no items"));
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f26765m.m10735a(th);
        unsubscribe();
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (!this.f26763k) {
            this.f26763k = true;
            this.f26764l = t;
        } else {
            this.f26762j = true;
            this.f26765m.m10735a(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
        }
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(2L);
    }
}
