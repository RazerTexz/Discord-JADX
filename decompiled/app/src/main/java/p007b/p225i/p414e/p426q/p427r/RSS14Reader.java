package p007b.p225i.p414e.p426q.p427r;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitArray;
import p007b.p225i.p414e.p426q.OneDReader;

/* compiled from: RSS14Reader.java */
/* renamed from: b.i.e.q.r.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class RSS14Reader extends AbstractRSSReader {

    /* renamed from: g */
    public static final int[] f13412g = {1, 10, 34, 70, 126};

    /* renamed from: h */
    public static final int[] f13413h = {4, 20, 48, 81};

    /* renamed from: i */
    public static final int[] f13414i = {0, Opcodes.IF_ICMPLT, 961, 2015, 2715};

    /* renamed from: j */
    public static final int[] f13415j = {0, 336, 1036, 1516};

    /* renamed from: k */
    public static final int[] f13416k = {8, 6, 4, 3, 1};

    /* renamed from: l */
    public static final int[] f13417l = {2, 4, 6, 8};

    /* renamed from: m */
    public static final int[][] f13418m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: n */
    public final List<Pair3> f13419n = new ArrayList();

    /* renamed from: o */
    public final List<Pair3> f13420o = new ArrayList();

    /* renamed from: k */
    public static void m7013k(Collection<Pair3> collection, Pair3 pair3) {
        if (pair3 == null) {
            return;
        }
        boolean z2 = false;
        Iterator<Pair3> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair3 next = it.next();
            if (next.f13405a == pair3.f13405a) {
                next.f13411d++;
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        collection.add(pair3);
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* renamed from: b */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        m7013k(this.f13419n, m7015m(bitArray, false, i, map));
        bitArray.m6939i();
        m7013k(this.f13420o, m7015m(bitArray, true, i, map));
        bitArray.m6939i();
        for (Pair3 pair3 : this.f13419n) {
            if (pair3.f13411d > 1) {
                for (Pair3 pair32 : this.f13420o) {
                    if (pair32.f13411d > 1) {
                        int i2 = ((pair32.f13406b * 16) + pair3.f13406b) % 79;
                        int i3 = (pair3.f13410c.f13407a * 9) + pair32.f13410c.f13407a;
                        if (i3 > 72) {
                            i3--;
                        }
                        if (i3 > 8) {
                            i3--;
                        }
                        if (i2 == i3) {
                            String strValueOf = String.valueOf((pair3.f13405a * 4537077) + pair32.f13405a);
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - strValueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(strValueOf);
                            int i4 = 0;
                            for (int i5 = 0; i5 < 13; i5++) {
                                int iCharAt = sb.charAt(i5) - '0';
                                if ((i5 & 1) == 0) {
                                    iCharAt *= 3;
                                }
                                i4 += iCharAt;
                            }
                            int i6 = 10 - (i4 % 10);
                            if (i6 == 10) {
                                i6 = 0;
                            }
                            sb.append(i6);
                            ResultPoint[] resultPointArr = pair3.f13410c.f13409c;
                            ResultPoint[] resultPointArr2 = pair32.f13410c.f13409c;
                            return new Result(sb.toString(), null, new ResultPoint[]{resultPointArr[0], resultPointArr[1], resultPointArr2[0], resultPointArr2[1]}, BarcodeFormat.RSS_14);
                        }
                    }
                }
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[PHI: r12 r13
      0x00b4: PHI (r12v9 boolean) = (r12v6 boolean), (r12v20 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r13v4 boolean) = (r13v1 boolean), (r13v11 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b6 A[PHI: r12 r13
      0x00b6: PHI (r12v16 boolean) = (r12v6 boolean), (r12v20 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r13v9 boolean) = (r13v1 boolean), (r13v11 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DataCharacter m7014l(BitArray bitArray, FinderPattern finderPattern, boolean z2) throws NotFoundException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[] iArr = this.f13400b;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
        if (z2) {
            OneDReader.m6998f(bitArray, finderPattern.f13408b[0], iArr);
        } else {
            OneDReader.m6997e(bitArray, finderPattern.f13408b[1] + 1, iArr);
            int i2 = 0;
            for (int length = iArr.length - 1; i2 < length; length--) {
                int i3 = iArr[i2];
                iArr[i2] = iArr[length];
                iArr[length] = i3;
                i2++;
            }
        }
        int i4 = z2 ? 16 : 15;
        float fM4297h1 = C3404f.m4297h1(iArr) / i4;
        int[] iArr2 = this.f13403e;
        int[] iArr3 = this.f13404f;
        float[] fArr = this.f13401c;
        float[] fArr2 = this.f13402d;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f = iArr[i5] / fM4297h1;
            int i6 = (int) (0.5f + f);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArr2[i7] = i6;
                fArr[i7] = f - i6;
            } else {
                iArr3[i7] = i6;
                fArr2[i7] = f - i6;
            }
        }
        int iM4297h1 = C3404f.m4297h1(this.f13403e);
        int iM4297h12 = C3404f.m4297h1(this.f13404f);
        if (z2) {
            if (iM4297h1 > 12) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iM4297h1 < 4;
                z4 = false;
            }
            if (iM4297h12 <= 12) {
                z5 = iM4297h12 < 4;
                z6 = false;
            }
            z5 = false;
            z6 = true;
        } else {
            if (iM4297h1 > 11) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iM4297h1 < 5;
                z4 = false;
            }
            if (iM4297h12 <= 10) {
                if (iM4297h12 < 4) {
                }
                z6 = false;
            }
            z5 = false;
            z6 = true;
        }
        int i8 = (iM4297h1 + iM4297h12) - i4;
        boolean z7 = (iM4297h1 & 1) == z2;
        boolean z8 = (iM4297h12 & 1) == 1;
        if (i8 == 1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.f21665l;
                }
                z4 = true;
            } else {
                if (!z8) {
                    throw NotFoundException.f21665l;
                }
                z6 = true;
            }
        } else if (i8 != -1) {
            if (i8 != 0) {
                throw NotFoundException.f21665l;
            }
            if (z7) {
                if (!z8) {
                    throw NotFoundException.f21665l;
                }
                if (iM4297h1 < iM4297h12) {
                    z3 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                }
            } else if (z8) {
                throw NotFoundException.f21665l;
            }
        } else if (z7) {
            if (z8) {
                throw NotFoundException.f21665l;
            }
            z3 = true;
        } else {
            if (!z8) {
                throw NotFoundException.f21665l;
            }
            z5 = true;
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.f21665l;
            }
            AbstractRSSReader.m7010h(this.f13403e, this.f13401c);
        }
        if (z4) {
            AbstractRSSReader.m7009g(this.f13403e, this.f13401c);
        }
        if (z5) {
            if (z6) {
                throw NotFoundException.f21665l;
            }
            AbstractRSSReader.m7010h(this.f13404f, this.f13401c);
        }
        if (z6) {
            AbstractRSSReader.m7009g(this.f13404f, this.f13402d);
        }
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + iArr2[length2];
            i10 += iArr2[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + iArr3[length3];
            i12 += iArr3[length3];
        }
        int i13 = (i11 * 3) + i9;
        if (!z2) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw NotFoundException.f21665l;
            }
            int i14 = (10 - i12) / 2;
            int i15 = f13417l[i14];
            return new DataCharacter((C3404f.m4328p0(iArr3, 9 - i15, false) * f13413h[i14]) + C3404f.m4328p0(iArr2, i15, true) + f13415j[i14], i13);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw NotFoundException.f21665l;
        }
        int i16 = (12 - i10) / 2;
        int i17 = f13416k[i16];
        return new DataCharacter((C3404f.m4328p0(iArr2, i17, false) * f13412g[i16]) + C3404f.m4328p0(iArr3, 9 - i17, true) + f13414i[i16], i13);
    }

    /* renamed from: m */
    public final Pair3 m7015m(BitArray bitArray, boolean z2, int i, Map<DecodeHintType, ?> map) {
        try {
            FinderPattern finderPatternM7017o = m7017o(bitArray, i, z2, m7016n(bitArray, z2));
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = (r1[0] + r1[1]) / 2.0f;
                if (z2) {
                    f = (bitArray.f13228k - 1) - f;
                }
                resultPointCallback.m6924a(new ResultPoint(f, i));
            }
            DataCharacter dataCharacterM7014l = m7014l(bitArray, finderPatternM7017o, true);
            DataCharacter dataCharacterM7014l2 = m7014l(bitArray, finderPatternM7017o, false);
            return new Pair3((dataCharacterM7014l.f13405a * 1597) + dataCharacterM7014l2.f13405a, (dataCharacterM7014l2.f13406b * 4) + dataCharacterM7014l.f13406b, finderPatternM7017o);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* renamed from: n */
    public final int[] m7016n(BitArray bitArray, boolean z2) throws NotFoundException {
        int[] iArr = this.f13399a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i = bitArray.f13228k;
        int i2 = 0;
        boolean z3 = false;
        while (i2 < i) {
            z3 = !bitArray.m6935b(i2);
            if (z2 == z3) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < i) {
            if (bitArray.m6935b(i2) != z3) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (AbstractRSSReader.m7011i(iArr)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.f21665l;
    }

    /* renamed from: o */
    public final FinderPattern m7017o(BitArray bitArray, int i, boolean z2, int[] iArr) throws NotFoundException {
        int i2;
        int i3;
        boolean zM6935b = bitArray.m6935b(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zM6935b != bitArray.m6935b(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArr2 = this.f13399a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i6;
        int iM7012j = AbstractRSSReader.m7012j(iArr2, f13418m);
        int i7 = iArr[1];
        if (z2) {
            int i8 = bitArray.f13228k;
            i2 = (i8 - 1) - i7;
            i3 = (i8 - 1) - i5;
        } else {
            i2 = i7;
            i3 = i5;
        }
        return new FinderPattern(iM7012j, new int[]{i5, iArr[1]}, i3, i2, i);
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader, p007b.p225i.p414e.Reader
    public void reset() {
        this.f13419n.clear();
        this.f13420o.clear();
    }
}
