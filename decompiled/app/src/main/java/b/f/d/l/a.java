package b.f.d.l;

/* compiled from: TriState.java */
/* loaded from: classes.dex */
public enum a {
    YES,
    NO,
    UNSET;

    public static a f(boolean z2) {
        return z2 ? YES : NO;
    }
}
