package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.util.Map;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.p219i0.TypeKey;

/* JADX INFO: renamed from: b.g.a.c.g0.t.m, reason: use source file name */
/* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReadOnlyClassToSerializerMap {

    /* JADX INFO: renamed from: a */
    public final a[] f4836a;

    /* JADX INFO: renamed from: b */
    public final int f4837b;

    /* JADX INFO: renamed from: b.g.a.c.g0.t.m$a */
    /* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final JsonSerializer<Object> f4838a;

        /* JADX INFO: renamed from: b */
        public final a f4839b;

        /* JADX INFO: renamed from: c */
        public final Class<?> f4840c;

        /* JADX INFO: renamed from: d */
        public final JavaType f4841d;

        /* JADX INFO: renamed from: e */
        public final boolean f4842e;

        public a(a aVar, TypeKey typeKey, JsonSerializer<Object> jsonSerializer) {
            this.f4839b = aVar;
            this.f4838a = jsonSerializer;
            this.f4842e = typeKey.f4990d;
            this.f4840c = typeKey.f4988b;
            this.f4841d = typeKey.f4989c;
        }
    }

    public ReadOnlyClassToSerializerMap(Map<TypeKey, JsonSerializer<Object>> map) {
        int size = map.size();
        int i = 8;
        while (i < (size <= 64 ? size + size : size + (size >> 2))) {
            i += i;
        }
        this.f4837b = i - 1;
        a[] aVarArr = new a[i];
        for (Map.Entry<TypeKey, JsonSerializer<Object>> entry : map.entrySet()) {
            TypeKey key = entry.getKey();
            int i2 = key.f4987a & this.f4837b;
            aVarArr[i2] = new a(aVarArr[i2], key, entry.getValue());
        }
        this.f4836a = aVarArr;
    }

    /* JADX INFO: renamed from: a */
    public JsonSerializer<Object> m2035a(JavaType javaType) {
        a aVar = this.f4836a[(javaType._hash - 1) & this.f4837b];
        if (aVar == null) {
            return null;
        }
        if (!aVar.f4842e && javaType.equals(aVar.f4841d)) {
            return aVar.f4838a;
        }
        do {
            aVar = aVar.f4839b;
            if (aVar == null) {
                return null;
            }
        } while (!(!aVar.f4842e && javaType.equals(aVar.f4841d)));
        return aVar.f4838a;
    }

    /* JADX INFO: renamed from: b */
    public JsonSerializer<Object> m2036b(Class<?> cls) {
        a aVar = this.f4836a[cls.getName().hashCode() & this.f4837b];
        if (aVar == null) {
            return null;
        }
        if (aVar.f4840c == cls && !aVar.f4842e) {
            return aVar.f4838a;
        }
        do {
            aVar = aVar.f4839b;
            if (aVar == null) {
                return null;
            }
        } while (!(aVar.f4840c == cls && !aVar.f4842e));
        return aVar.f4838a;
    }
}
