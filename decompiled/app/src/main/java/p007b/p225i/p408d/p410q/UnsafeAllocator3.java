package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.i.d.q.u, reason: use source file name */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnsafeAllocator3 extends UnsafeAllocator5 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Method f13129a;

    public UnsafeAllocator3(Method method) {
        this.f13129a = method;
    }

    @Override // p007b.p225i.p408d.p410q.UnsafeAllocator5
    /* JADX INFO: renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        UnsafeAllocator5.m6872a(cls);
        return (T) this.f13129a.invoke(null, cls, Object.class);
    }
}
