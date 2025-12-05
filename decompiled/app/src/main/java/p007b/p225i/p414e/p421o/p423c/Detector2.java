package p007b.p225i.p414e.p421o.p423c;

import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DefaultGridSampler;
import p007b.p225i.p414e.p418n.PerspectiveTransform;
import p007b.p225i.p414e.p418n.p419k.WhiteRectangleDetector;

/* compiled from: Detector.java */
/* renamed from: b.i.e.o.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Detector2 {

    /* renamed from: a */
    public final BitMatrix f13342a;

    /* renamed from: b */
    public final WhiteRectangleDetector f13343b;

    /* compiled from: Detector.java */
    /* renamed from: b.i.e.o.c.a$b */
    public static final class b {

        /* renamed from: a */
        public final ResultPoint f13344a;

        /* renamed from: b */
        public final ResultPoint f13345b;

        /* renamed from: c */
        public final int f13346c;

        public b(ResultPoint resultPoint, ResultPoint resultPoint2, int i, a aVar) {
            this.f13344a = resultPoint;
            this.f13345b = resultPoint2;
            this.f13346c = i;
        }

        public String toString() {
            return this.f13344a + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f13345b + MentionUtils.SLASH_CHAR + this.f13346c;
        }
    }

    /* compiled from: Detector.java */
    /* renamed from: b.i.e.o.c.a$c */
    public static final class c implements Serializable, Comparator<b> {
        public c(a aVar) {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.f13346c - bVar2.f13346c;
        }
    }

    public Detector2(BitMatrix bitMatrix) throws NotFoundException {
        this.f13342a = bitMatrix;
        this.f13343b = new WhiteRectangleDetector(bitMatrix, 10, bitMatrix.f13229j / 2, bitMatrix.f13230k / 2);
    }

    /* renamed from: a */
    public static int m6974a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return C3404f.m4265Z0(C3404f.m4237Q(resultPoint.f13207a, resultPoint.f13208b, resultPoint2.f13207a, resultPoint2.f13208b));
    }

    /* renamed from: b */
    public static void m6975b(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    /* renamed from: d */
    public static BitMatrix m6976d(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return DefaultGridSampler.f13274a.m6951a(bitMatrix, i, i2, PerspectiveTransform.m6954a(0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.f13207a, resultPoint.f13208b, resultPoint4.f13207a, resultPoint4.f13208b, resultPoint3.f13207a, resultPoint3.f13208b, resultPoint2.f13207a, resultPoint2.f13208b));
    }

    /* renamed from: c */
    public final boolean m6977c(ResultPoint resultPoint) {
        float f = resultPoint.f13207a;
        if (f < 0.0f) {
            return false;
        }
        BitMatrix bitMatrix = this.f13342a;
        if (f >= bitMatrix.f13229j) {
            return false;
        }
        float f2 = resultPoint.f13208b;
        return f2 > 0.0f && f2 < ((float) bitMatrix.f13230k);
    }

    /* renamed from: e */
    public final b m6978e(ResultPoint resultPoint, ResultPoint resultPoint2) {
        Detector2 detector2 = this;
        int i = (int) resultPoint.f13207a;
        int i2 = (int) resultPoint.f13208b;
        int i3 = (int) resultPoint2.f13207a;
        int i4 = (int) resultPoint2.f13208b;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i2 = i;
            i = i2;
            i4 = i3;
            i3 = i4;
        }
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int i5 = (-iAbs) / 2;
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i >= i3 ? -1 : 1;
        boolean zM6942f = detector2.f13342a.m6942f(z2 ? i2 : i, z2 ? i : i2);
        int i8 = 0;
        while (i != i3) {
            boolean zM6942f2 = detector2.f13342a.m6942f(z2 ? i2 : i, z2 ? i : i2);
            if (zM6942f2 != zM6942f) {
                i8++;
                zM6942f = zM6942f2;
            }
            i5 += iAbs2;
            if (i5 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i6;
                i5 -= iAbs;
            }
            i += i7;
            detector2 = this;
        }
        return new b(resultPoint, resultPoint2, i8, null);
    }
}
