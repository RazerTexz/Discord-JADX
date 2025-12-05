package p007b.p195g.p196a.p205c.p206a0;

import java.io.Serializable;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonDeserializer;
import p007b.p195g.p196a.p205c.p219i0.LRUMap;

/* compiled from: DeserializerCache.java */
/* renamed from: b.g.a.c.a0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializerCache implements Serializable {
    private static final long serialVersionUID = 1;
    public final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap<>(8);
    public final LRUMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new LRUMap<>(Math.min(64, 500), 2000);

    public Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }
}
