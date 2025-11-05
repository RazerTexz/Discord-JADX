package b.i.d.q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes3.dex */
public class s extends w {
    public final /* synthetic */ Method a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1811b;

    public s(Method method, Object obj) {
        this.a = method;
        this.f1811b = obj;
    }

    @Override // b.i.d.q.w
    public <T> T b(Class<T> cls) throws Exception {
        w.a(cls);
        return (T) this.a.invoke(this.f1811b, cls);
    }
}
