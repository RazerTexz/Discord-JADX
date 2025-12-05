package p007b.p195g.p196a.p197a;

/* compiled from: OptBoolean.java */
/* renamed from: b.g.a.a.m0, reason: use source file name */
/* loaded from: classes3.dex */
public enum OptBoolean {
    TRUE,
    FALSE,
    DEFAULT;

    /* renamed from: f */
    public Boolean m1613f() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
