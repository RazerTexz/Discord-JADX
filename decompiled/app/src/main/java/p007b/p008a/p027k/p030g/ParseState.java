package p007b.p008a.p027k.p030g;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: ParseState.kt */
/* renamed from: b.a.k.g.c, reason: use source file name */
/* loaded from: classes.dex */
public final class ParseState {

    /* renamed from: a */
    public final boolean f1501a;

    /* renamed from: b */
    public int f1502b;

    public ParseState() {
        this(false, 0, 3);
    }

    public ParseState(boolean z2, int i) {
        this.f1501a = z2;
        this.f1502b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParseState)) {
            return false;
        }
        ParseState parseState = (ParseState) obj;
        return this.f1501a == parseState.f1501a && this.f1502b == parseState.f1502b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.f1501a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return (r0 * 31) + this.f1502b;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ParseState(isEscaped=");
        sbM833U.append(this.f1501a);
        sbM833U.append(", argumentIndex=");
        return outline.m814B(sbM833U, this.f1502b, ")");
    }

    public ParseState(boolean z2, int i, int i2) {
        z2 = (i2 & 1) != 0 ? false : z2;
        i = (i2 & 2) != 0 ? 0 : i;
        this.f1501a = z2;
        this.f1502b = i;
    }
}
