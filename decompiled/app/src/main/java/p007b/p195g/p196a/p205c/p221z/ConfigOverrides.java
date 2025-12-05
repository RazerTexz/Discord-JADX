package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Map;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;

/* compiled from: ConfigOverrides.java */
/* renamed from: b.g.a.c.z.g, reason: use source file name */
/* loaded from: classes3.dex */
public class ConfigOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    public JsonInclude.b _defaultInclusion;
    public Boolean _defaultLeniency;
    public Boolean _defaultMergeable;
    public JsonSetter.a _defaultSetterInfo;
    public Map<Class<?>, ?> _overrides;
    public VisibilityChecker<?> _visibilityChecker;

    public ConfigOverrides() {
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        JsonInclude.b bVar2 = JsonInclude.b.f4436j;
        JsonSetter.a aVar = JsonSetter.a.f4443j;
        VisibilityChecker.a aVar2 = VisibilityChecker.a.f4709j;
        this._overrides = null;
        this._defaultInclusion = bVar2;
        this._defaultSetterInfo = aVar;
        this._visibilityChecker = aVar2;
        this._defaultMergeable = null;
        this._defaultLeniency = null;
    }

    /* renamed from: a */
    public ConfigOverride m2263a(Class<?> cls) {
        Map<Class<?>, ?> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (ConfigOverride) map.get(cls);
    }
}
