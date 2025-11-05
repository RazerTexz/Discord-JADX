package b.g.a.c.z;

import b.g.a.a.p;
import b.g.a.a.z;
import b.g.a.c.c0.g0;
import java.io.Serializable;
import java.util.Map;

/* compiled from: ConfigOverrides.java */
/* loaded from: classes3.dex */
public class g implements Serializable {
    private static final long serialVersionUID = 1;
    public p.b _defaultInclusion;
    public Boolean _defaultLeniency;
    public Boolean _defaultMergeable;
    public z.a _defaultSetterInfo;
    public Map<Class<?>, ?> _overrides;
    public g0<?> _visibilityChecker;

    public g() {
        p.b bVar = p.b.j;
        p.b bVar2 = p.b.j;
        z.a aVar = z.a.j;
        g0.a aVar2 = g0.a.j;
        this._overrides = null;
        this._defaultInclusion = bVar2;
        this._defaultSetterInfo = aVar;
        this._visibilityChecker = aVar2;
        this._defaultMergeable = null;
        this._defaultLeniency = null;
    }

    public f a(Class<?> cls) {
        Map<Class<?>, ?> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (f) map.get(cls);
    }
}
