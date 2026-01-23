package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.util.Map;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p218h0.ClassKey;

/* JADX INFO: renamed from: b.g.a.c.c0.d0, reason: use source file name */
/* JADX INFO: compiled from: SimpleMixInResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleMixInResolver implements ClassIntrospector.a, Serializable {
    private static final long serialVersionUID = 1;
    public Map<ClassKey, Class<?>> _localMixIns;
    public final ClassIntrospector.a _overrides = null;

    public SimpleMixInResolver(ClassIntrospector.a aVar) {
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.ClassIntrospector.a
    /* JADX INFO: renamed from: a */
    public Class<?> mo1885a(Class<?> cls) {
        Map<ClassKey, Class<?>> map;
        ClassIntrospector.a aVar = this._overrides;
        Class<?> clsMo1885a = aVar == null ? null : aVar.mo1885a(cls);
        return (clsMo1885a != null || (map = this._localMixIns) == null) ? clsMo1885a : map.get(new ClassKey(cls));
    }

    /* JADX INFO: renamed from: b */
    public boolean m1886b() {
        if (this._localMixIns != null) {
            return true;
        }
        ClassIntrospector.a aVar = this._overrides;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof SimpleMixInResolver) {
            return ((SimpleMixInResolver) aVar).m1886b();
        }
        return true;
    }
}
