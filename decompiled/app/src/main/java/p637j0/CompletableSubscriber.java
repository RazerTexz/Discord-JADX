package p637j0;

import p658rx.Subscription;

/* JADX INFO: renamed from: j0.e, reason: use source file name */
/* JADX INFO: compiled from: CompletableSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CompletableSubscriber {
    /* JADX INFO: renamed from: a */
    void m10732a(Subscription subscription);

    void onCompleted();

    void onError(Throwable th);
}
