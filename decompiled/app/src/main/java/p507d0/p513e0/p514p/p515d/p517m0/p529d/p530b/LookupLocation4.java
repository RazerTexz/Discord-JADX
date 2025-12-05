package p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: LookupLocation.kt */
/* renamed from: d0.e0.p.d.m0.d.b.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class LookupLocation4 implements Serializable {

    /* renamed from: j */
    public static final a f23135j = new a(null);

    /* renamed from: k */
    public static final LookupLocation4 f23136k = new LookupLocation4(-1, -1);
    private final int column;
    private final int line;

    /* compiled from: LookupLocation.kt */
    /* renamed from: d0.e0.p.d.m0.d.b.e$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final LookupLocation4 getNO_POSITION() {
            return LookupLocation4.access$getNO_POSITION$cp();
        }
    }

    public LookupLocation4(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public static final /* synthetic */ LookupLocation4 access$getNO_POSITION$cp() {
        return f23136k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookupLocation4)) {
            return false;
        }
        LookupLocation4 lookupLocation4 = (LookupLocation4) obj;
        return this.line == lookupLocation4.line && this.column == lookupLocation4.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Position(line=");
        sbM833U.append(this.line);
        sbM833U.append(", column=");
        return outline.m813A(sbM833U, this.column, ')');
    }
}
