package h0.b.b;

import java.io.Serializable;

/* compiled from: StdInstantiatorStrategy.java */
/* loaded from: classes3.dex */
public class c implements a {
    @Override // h0.b.b.a
    public <T> h0.b.a.a<T> newInstantiatorOf(Class<T> cls) {
        if (b.b("Java HotSpot") || b.b("OpenJDK")) {
            return b.d != null ? Serializable.class.isAssignableFrom(cls) ? new h0.b.a.c.b(cls) : new h0.b.a.c.a(cls) : new h0.b.a.f.a(cls);
        }
        if (!b.b("Dalvik")) {
            return b.b("BEA") ? new h0.b.a.f.a(cls) : b.b("GNU libgcj") ? new h0.b.a.d.a(cls) : b.b("PERC") ? new h0.b.a.e.a(cls) : new h0.b.a.f.b(cls);
        }
        if (b.c) {
            return new h0.b.a.f.b(cls);
        }
        int i = b.f3734b;
        return i <= 10 ? new h0.b.a.b.a(cls) : i <= 17 ? new h0.b.a.b.b(cls) : new h0.b.a.b.c(cls);
    }
}
