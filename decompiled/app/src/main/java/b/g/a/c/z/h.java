package b.g.a.c.z;

import java.io.Serializable;

/* compiled from: ConstructorDetector.java */
/* loaded from: classes3.dex */
public final class h implements Serializable {
    private static final long serialVersionUID = 1;
    public final boolean _allowJDKTypeCtors;
    public final boolean _requireCtorAnnotation;
    public final a _singleArgMode;

    /* compiled from: ConstructorDetector.java */
    public enum a {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }
}
