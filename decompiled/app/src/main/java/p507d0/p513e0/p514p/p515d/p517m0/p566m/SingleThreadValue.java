package p507d0.p513e0.p514p.p515d.p517m0.p566m;

/* compiled from: SingleThreadValue.java */
/* renamed from: d0.e0.p.d.m0.m.m, reason: use source file name */
/* loaded from: classes3.dex */
public class SingleThreadValue<T> {

    /* renamed from: a */
    public final T f24735a;

    /* renamed from: b */
    public final Thread f24736b = Thread.currentThread();

    public SingleThreadValue(T t) {
        this.f24735a = t;
    }

    public T getValue() {
        if (hasValue()) {
            return this.f24735a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        return this.f24736b == Thread.currentThread();
    }
}
