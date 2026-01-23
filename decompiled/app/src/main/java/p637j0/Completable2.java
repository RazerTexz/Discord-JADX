package p637j0;

import p637j0.Completable3;
import p658rx.Observable;

/* JADX INFO: renamed from: j0.c, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Completable2 implements Completable3.a {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Observable f26686j;

    public Completable2(Observable observable) {
        this.f26686j = observable;
    }

    @Override // p658rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompletableSubscriber completableSubscriber2 = completableSubscriber;
        Completable completable = new Completable(this, completableSubscriber2);
        completableSubscriber2.m10732a(completable);
        this.f26686j.m11107i0(completable);
    }
}
