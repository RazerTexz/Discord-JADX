package p007b.p195g.p196a.p205c.p215g0;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ReadOnlyClassToSerializerMap;
import p007b.p195g.p196a.p205c.p219i0.TypeKey;

/* compiled from: SerializerCache.java */
/* renamed from: b.g.a.c.g0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class SerializerCache {

    /* renamed from: a */
    public final HashMap<TypeKey, JsonSerializer<Object>> f4815a = new HashMap<>(64);

    /* renamed from: b */
    public final AtomicReference<ReadOnlyClassToSerializerMap> f4816b = new AtomicReference<>();

    /* renamed from: a */
    public JsonSerializer<Object> m2008a(JavaType javaType) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = this.f4815a.get(new TypeKey(javaType, false));
        }
        return jsonSerializer;
    }

    /* renamed from: b */
    public JsonSerializer<Object> m2009b(Class<?> cls) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = this.f4815a.get(new TypeKey(cls, false));
        }
        return jsonSerializer;
    }
}
