package b.g.a.a;

/* compiled from: OptBoolean.java */
/* loaded from: classes3.dex */
public enum m0 {
    TRUE,
    FALSE,
    DEFAULT;

    public Boolean f() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
