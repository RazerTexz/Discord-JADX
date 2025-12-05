package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: b.i.d.q.t, reason: use source file name */
/* loaded from: classes3.dex */
public class UnsafeAllocator2 extends UnsafeAllocator5 {

    /* renamed from: a */
    public final /* synthetic */ Method f13127a;

    /* renamed from: b */
    public final /* synthetic */ int f13128b;

    public UnsafeAllocator2(Method method, int i) {
        this.f13127a = method;
        this.f13128b = i;
    }

    @Override // p007b.p225i.p408d.p410q.UnsafeAllocator5
    /* renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        UnsafeAllocator5.m6872a(cls);
        return (T) this.f13127a.invoke(null, cls, Integer.valueOf(this.f13128b));
    }
}
