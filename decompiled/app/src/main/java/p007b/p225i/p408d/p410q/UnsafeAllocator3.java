package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: b.i.d.q.u, reason: use source file name */
/* loaded from: classes3.dex */
public class UnsafeAllocator3 extends UnsafeAllocator5 {

    /* renamed from: a */
    public final /* synthetic */ Method f13129a;

    public UnsafeAllocator3(Method method) {
        this.f13129a = method;
    }

    @Override // p007b.p225i.p408d.p410q.UnsafeAllocator5
    /* renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        UnsafeAllocator5.m6872a(cls);
        return (T) this.f13129a.invoke(null, cls, Object.class);
    }
}
