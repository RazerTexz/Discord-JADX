package b.i.d.q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes3.dex */
public class u extends w {
    public final /* synthetic */ Method a;

    public u(Method method) {
        this.a = method;
    }

    @Override // b.i.d.q.w
    public <T> T b(Class<T> cls) throws Exception {
        w.a(cls);
        return (T) this.a.invoke(null, cls, Object.class);
    }
}
