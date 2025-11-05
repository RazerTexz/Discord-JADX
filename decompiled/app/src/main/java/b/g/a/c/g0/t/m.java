package b.g.a.c.g0.t;

import java.util.Map;

/* compiled from: ReadOnlyClassToSerializerMap.java */
/* loaded from: classes3.dex */
public final class m {
    public final a[] a;

    /* renamed from: b, reason: collision with root package name */
    public final int f711b;

    /* compiled from: ReadOnlyClassToSerializerMap.java */
    public static final class a {
        public final b.g.a.c.n<Object> a;

        /* renamed from: b, reason: collision with root package name */
        public final a f712b;
        public final Class<?> c;
        public final b.g.a.c.j d;
        public final boolean e;

        public a(a aVar, b.g.a.c.i0.u uVar, b.g.a.c.n<Object> nVar) {
            this.f712b = aVar;
            this.a = nVar;
            this.e = uVar.d;
            this.c = uVar.f730b;
            this.d = uVar.c;
        }
    }

    public m(Map<b.g.a.c.i0.u, b.g.a.c.n<Object>> map) {
        int size = map.size();
        int i = 8;
        while (i < (size <= 64 ? size + size : size + (size >> 2))) {
            i += i;
        }
        this.f711b = i - 1;
        a[] aVarArr = new a[i];
        for (Map.Entry<b.g.a.c.i0.u, b.g.a.c.n<Object>> entry : map.entrySet()) {
            b.g.a.c.i0.u key = entry.getKey();
            int i2 = key.a & this.f711b;
            aVarArr[i2] = new a(aVarArr[i2], key, entry.getValue());
        }
        this.a = aVarArr;
    }

    public b.g.a.c.n<Object> a(b.g.a.c.j jVar) {
        a aVar = this.a[(jVar._hash - 1) & this.f711b];
        if (aVar == null) {
            return null;
        }
        if (!aVar.e && jVar.equals(aVar.d)) {
            return aVar.a;
        }
        do {
            aVar = aVar.f712b;
            if (aVar == null) {
                return null;
            }
        } while (!(!aVar.e && jVar.equals(aVar.d)));
        return aVar.a;
    }

    public b.g.a.c.n<Object> b(Class<?> cls) {
        a aVar = this.a[cls.getName().hashCode() & this.f711b];
        if (aVar == null) {
            return null;
        }
        if (aVar.c == cls && !aVar.e) {
            return aVar.a;
        }
        do {
            aVar = aVar.f712b;
            if (aVar == null) {
                return null;
            }
        } while (!(aVar.c == cls && !aVar.e));
        return aVar.a;
    }
}
