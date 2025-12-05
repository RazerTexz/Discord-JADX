package p007b.p195g.p196a.p205c;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.UnwrappingBeanSerializer;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: JsonSerializer.java */
/* renamed from: b.g.a.c.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class JsonSerializer<T> {

    /* compiled from: JsonSerializer.java */
    /* renamed from: b.g.a.c.n$a */
    public static abstract class a extends JsonSerializer<Object> {
    }

    /* renamed from: c */
    public Class<T> mo2041c() {
        return null;
    }

    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, T t) {
        return t == null;
    }

    /* renamed from: e */
    public boolean mo2058e() {
        return this instanceof UnwrappingBeanSerializer;
    }

    /* renamed from: f */
    public abstract void mo1807f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    /* renamed from: g */
    public void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Class clsMo2041c = mo2041c();
        if (clsMo2041c == null) {
            clsMo2041c = t.getClass();
        }
        serializerProvider.mo1942f(serializerProvider.m1938b(clsMo2041c), String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsMo2041c.getName(), getClass().getName()));
        throw null;
    }

    /* renamed from: h */
    public JsonSerializer<T> mo1984h(NameTransformer4 nameTransformer4) {
        return this;
    }

    /* renamed from: i */
    public boolean mo2052i() {
        return false;
    }
}
