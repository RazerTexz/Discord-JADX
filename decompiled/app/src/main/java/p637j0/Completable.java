package p637j0;

import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.b, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class Completable extends Subscriber<Object> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CompletableSubscriber f26685j;

    public Completable(Completable2 completable2, CompletableSubscriber completableSubscriber) {
        this.f26685j = completableSubscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f26685j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f26685j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(Object obj) {
    }
}
