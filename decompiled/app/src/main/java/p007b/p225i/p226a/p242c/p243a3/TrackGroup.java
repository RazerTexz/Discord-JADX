package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.Log2;

/* compiled from: TrackGroup.java */
/* renamed from: b.i.a.c.a3.n0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrackGroup implements Bundleable {

    /* renamed from: j */
    public static final /* synthetic */ int f5660j = 0;

    /* renamed from: k */
    public final int f5661k;

    /* renamed from: l */
    public final Format2[] f5662l;

    /* renamed from: m */
    public int f5663m;

    public TrackGroup(Format2... format2Arr) {
        int i = 1;
        AnimatableValueParser.m531j(format2Arr.length > 0);
        this.f5662l = format2Arr;
        this.f5661k = format2Arr.length;
        String str = format2Arr[0].f7146n;
        str = (str == null || str.equals("und")) ? "" : str;
        int i2 = format2Arr[0].f7148p | 16384;
        while (true) {
            Format2[] format2Arr2 = this.f5662l;
            if (i >= format2Arr2.length) {
                return;
            }
            String str2 = format2Arr2[i].f7146n;
            if (!str.equals((str2 == null || str2.equals("und")) ? "" : str2)) {
                Format2[] format2Arr3 = this.f5662l;
                m2565a("languages", format2Arr3[0].f7146n, format2Arr3[i].f7146n, i);
                return;
            } else {
                Format2[] format2Arr4 = this.f5662l;
                if (i2 != (format2Arr4[i].f7148p | 16384)) {
                    m2565a("role flags", Integer.toBinaryString(format2Arr4[0].f7148p), Integer.toBinaryString(this.f5662l[i].f7148p), i);
                    return;
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    public static void m2565a(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sbM831S = outline.m831S(outline.m841b(str3, outline.m841b(str2, str.length() + 78)), "Different ", str, " combined in one TrackGroup: '", str2);
        sbM831S.append("' (track 0) and '");
        sbM831S.append(str3);
        sbM831S.append("' (track ");
        sbM831S.append(i);
        sbM831S.append(")");
        Log2.m3039b("TrackGroup", "", new IllegalStateException(sbM831S.toString()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.f5661k == trackGroup.f5661k && Arrays.equals(this.f5662l, trackGroup.f5662l);
    }

    public int hashCode() {
        if (this.f5663m == 0) {
            this.f5663m = 527 + Arrays.hashCode(this.f5662l);
        }
        return this.f5663m;
    }
}
