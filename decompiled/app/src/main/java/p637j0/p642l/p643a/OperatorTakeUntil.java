package p637j0.p642l.p643a;

import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorTakeUntil<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26767j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorTakeUntil(OperatorTakeUntil3 operatorTakeUntil3, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.f26767j = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        try {
            this.f26767j.onCompleted();
        } finally {
            this.f26767j.unsubscribe();
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        try {
            this.f26767j.onError(th);
        } finally {
            this.f26767j.unsubscribe();
        }
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f26767j.onNext(t);
    }
}
