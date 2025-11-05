package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ExtensionRegistryLite.java */
/* loaded from: classes3.dex */
public class e {
    public static final e a = new e(true);

    /* renamed from: b, reason: collision with root package name */
    public final Map<a, g.f<?, ?>> f3427b;

    /* compiled from: ExtensionRegistryLite.java */
    public static final class a {
        public final Object a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3428b;

        public a(Object obj, int i) {
            this.a = obj;
            this.f3428b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f3428b == aVar.f3428b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.f3428b;
        }
    }

    public e() {
        this.f3427b = new HashMap();
    }

    public static e getEmptyRegistry() {
        return a;
    }

    public static e newInstance() {
        return new e();
    }

    public final void add(g.f<?, ?> fVar) {
        this.f3427b.put(new a(fVar.getContainingTypeDefaultInstance(), fVar.getNumber()), fVar);
    }

    public <ContainingType extends n> g.f<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (g.f) this.f3427b.get(new a(containingtype, i));
    }

    public e(boolean z2) {
        this.f3427b = Collections.emptyMap();
    }
}
