package p007b.p225i.p226a.p228b.p231j.p233r.p234a;

import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.r.a.b, reason: use source file name */
/* JADX INFO: compiled from: InstanceFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class InstanceFactory<T> implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final T f5328a;

    public InstanceFactory(T t) {
        this.f5328a = t;
    }

    @Override // p496c0.p497a.Provider3
    public T get() {
        return this.f5328a;
    }
}
