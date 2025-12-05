package p007b.p085c.p086a.p095y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: DocumentData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: b.c.a.y.c, reason: use source file name */
/* loaded from: classes.dex */
public class DocumentData {

    /* renamed from: a */
    public final String f2693a;

    /* renamed from: b */
    public final String f2694b;

    /* renamed from: c */
    public final float f2695c;

    /* renamed from: d */
    public final int f2696d;

    /* renamed from: e */
    public final int f2697e;

    /* renamed from: f */
    public final float f2698f;

    /* renamed from: g */
    public final float f2699g;

    /* renamed from: h */
    @ColorInt
    public final int f2700h;

    /* renamed from: i */
    @ColorInt
    public final int f2701i;

    /* renamed from: j */
    public final float f2702j;

    /* renamed from: k */
    public final boolean f2703k;

    public DocumentData(String str, String str2, float f, int i, int i2, float f2, float f3, @ColorInt int i3, @ColorInt int i4, float f4, boolean z2) {
        this.f2693a = str;
        this.f2694b = str2;
        this.f2695c = f;
        this.f2696d = i;
        this.f2697e = i2;
        this.f2698f = f2;
        this.f2699g = f3;
        this.f2700h = i3;
        this.f2701i = i4;
        this.f2702j = f4;
        this.f2703k = z2;
    }

    public int hashCode() {
        int iM758h = ((C1563b.m758h(this.f2696d) + (((int) (outline.m863m(this.f2694b, this.f2693a.hashCode() * 31, 31) + this.f2695c)) * 31)) * 31) + this.f2697e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f2698f);
        return (((iM758h * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f2700h;
    }
}
