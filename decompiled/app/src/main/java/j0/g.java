package j0;

/* compiled from: Observer.java */
/* loaded from: classes3.dex */
public interface g<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
