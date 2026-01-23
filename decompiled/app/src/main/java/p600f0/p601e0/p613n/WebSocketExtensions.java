package p600f0.p601e0.p613n;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.n.f, reason: use source file name */
/* JADX INFO: compiled from: WebSocketExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketExtensions {

    /* JADX INFO: renamed from: a */
    public final boolean f25861a;

    /* JADX INFO: renamed from: b */
    public final Integer f25862b;

    /* JADX INFO: renamed from: c */
    public final boolean f25863c;

    /* JADX INFO: renamed from: d */
    public final Integer f25864d;

    /* JADX INFO: renamed from: e */
    public final boolean f25865e;

    /* JADX INFO: renamed from: f */
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.f25861a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.f25862b;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.f25863c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.f25864d;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z4 = this.f25865e;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int i3 = (iHashCode2 + r22) * 31;
        boolean z5 = this.f25866f;
        return i3 + (z5 ? 1 : z5);
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
