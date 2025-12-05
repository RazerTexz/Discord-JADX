package p600f0.p601e0.p613n;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WebSocketExtensions.kt */
/* renamed from: f0.e0.n.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebSocketExtensions {

    /* renamed from: a */
    public final boolean f25861a;

    /* renamed from: b */
    public final Integer f25862b;

    /* renamed from: c */
    public final boolean f25863c;

    /* renamed from: d */
    public final Integer f25864d;

    /* renamed from: e */
    public final boolean f25865e;

    /* renamed from: f */
    public final boolean f25866f;

    public WebSocketExtensions() {
        this.f25861a = false;
        this.f25862b = null;
        this.f25863c = false;
        this.f25864d = null;
        this.f25865e = false;
        this.f25866f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.f25861a == webSocketExtensions.f25861a && Intrinsics3.areEqual(this.f25862b, webSocketExtensions.f25862b) && this.f25863c == webSocketExtensions.f25863c && Intrinsics3.areEqual(this.f25864d, webSocketExtensions.f25864d) && this.f25865e == webSocketExtensions.f25865e && this.f25866f == webSocketExtensions.f25866f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.f25861a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.f25862b;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        ?? r2 = this.f25863c;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        Integer num2 = this.f25864d;
        int iHashCode2 = (i3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r22 = this.f25865e;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode2 + i4) * 31;
        boolean z3 = this.f25866f;
        return i5 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WebSocketExtensions(perMessageDeflate=");
        sbM833U.append(this.f25861a);
        sbM833U.append(", clientMaxWindowBits=");
        sbM833U.append(this.f25862b);
        sbM833U.append(", clientNoContextTakeover=");
        sbM833U.append(this.f25863c);
        sbM833U.append(", serverMaxWindowBits=");
        sbM833U.append(this.f25864d);
        sbM833U.append(", serverNoContextTakeover=");
        sbM833U.append(this.f25865e);
        sbM833U.append(", unknownValues=");
        return outline.m827O(sbM833U, this.f25866f, ")");
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.f25861a = z2;
        this.f25862b = num;
        this.f25863c = z3;
        this.f25864d = num2;
        this.f25865e = z4;
        this.f25866f = z5;
    }
}
