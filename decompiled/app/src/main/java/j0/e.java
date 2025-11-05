package j0;

import rx.Subscription;

/* compiled from: CompletableSubscriber.java */
/* loaded from: classes3.dex */
public interface e {
    void a(Subscription subscription);

    void onCompleted();

    void onError(Throwable th);
}
