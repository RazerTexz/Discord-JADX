package b.g.a.c.c0;

import b.g.a.c.c0.t;
import java.io.Serializable;
import java.util.Map;

/* compiled from: SimpleMixInResolver.java */
/* loaded from: classes3.dex */
public class d0 implements t.a, Serializable {
    private static final long serialVersionUID = 1;
    public Map<b.g.a.c.h0.b, Class<?>> _localMixIns;
    public final t.a _overrides = null;

    public d0(t.a aVar) {
    }

    @Override // b.g.a.c.c0.t.a
    public Class<?> a(Class<?> cls) {
        Map<b.g.a.c.h0.b, Class<?>> map;
        t.a aVar = this._overrides;
        Class<?> clsA = aVar == null ? null : aVar.a(cls);
        return (clsA != null || (map = this._localMixIns) == null) ? clsA : map.get(new b.g.a.c.h0.b(cls));
    }

    public boolean b() {
        if (this._localMixIns != null) {
            return true;
        }
        t.a aVar = this._overrides;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof d0) {
            return ((d0) aVar).b();
        }
        return true;
    }
}
