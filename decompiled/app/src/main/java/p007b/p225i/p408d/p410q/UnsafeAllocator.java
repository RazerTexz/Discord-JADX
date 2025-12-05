package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: b.i.d.q.s, reason: use source file name */
/* loaded from: classes3.dex */
public class UnsafeAllocator extends UnsafeAllocator5 {

    /* renamed from: a */
    public final /* synthetic */ Method f13125a;

    /* renamed from: b */
    public final /* synthetic */ Object f13126b;

    public UnsafeAllocator(Method method, Object obj) {
        this.f13125a = method;
        this.f13126b = obj;
    }

    @Override // p007b.p225i.p408d.p410q.UnsafeAllocator5
    /* renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        UnsafeAllocator5.m6872a(cls);
        return (T) this.f13125a.invoke(this.f13126b, cls);
    }
}
