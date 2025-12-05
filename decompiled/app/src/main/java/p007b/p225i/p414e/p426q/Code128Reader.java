package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: Code128Reader.java */
/* renamed from: b.i.e.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Code128Reader extends OneDReader {

    /* renamed from: a */
    public static final int[][] f13358a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01a1, code lost:
    
        if (r3 != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01a3, code lost:
    
        r3 = false;
        r10 = false;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0150, code lost:
    
        if (r3 != false) goto L108;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ab A[PHI: r19
      0x01ab: PHI (r19v12 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:95:0x017c, B:70:0x0130] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015c A[PHI: r19
      0x015c: PHI (r19v11 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:94:0x017a, B:69:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v34 */
    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        float f;
        char c;
        boolean z2;
        boolean z3;
        int i2 = 1;
        ?? r3 = 0;
        boolean z4 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int i3 = bitArray.f13228k;
        int iM6936f = bitArray.m6936f(0);
        int i4 = 6;
        int[] iArr = new int[6];
        int i5 = iM6936f;
        boolean z5 = false;
        int i6 = 0;
        while (iM6936f < i3) {
            if (bitArray.m6935b(iM6936f) != z5) {
                iArr[i6] = iArr[i6] + i2;
            } else {
                if (i6 == 5) {
                    int i7 = 103;
                    int i8 = -1;
                    float f2 = 0.25f;
                    while (true) {
                        f = 0.7f;
                        if (i7 > 105) {
                            break;
                        }
                        float fM6996d = OneDReader.m6996d(iArr, f13358a[i7], 0.7f);
                        if (fM6996d < f2) {
                            f2 = fM6996d;
                            i8 = i7;
                        }
                        i7++;
                    }
                    if (i8 >= 0 && bitArray.m6938h(Math.max((int) r3, i5 - ((iM6936f - i5) / 2)), i5, r3)) {
                        int[] iArr2 = new int[3];
                        iArr2[r3] = i5;
                        iArr2[i2] = iM6936f;
                        iArr2[2] = i8;
                        int i9 = iArr2[2];
                        ArrayList arrayList = new ArrayList(20);
                        arrayList.add(Byte.valueOf((byte) i9));
                        switch (i9) {
                            case 103:
                                c = 'e';
                                break;
                            case 104:
                                c = 'd';
                                break;
                            case 105:
                                c = 'c';
                                break;
                            default:
                                throw FormatException.m9260a();
                        }
                        StringBuilder sb = new StringBuilder(20);
                        int i10 = iArr2[r3];
                        int i11 = iArr2[i2];
                        int[] iArr3 = new int[i4];
                        char c2 = c;
                        boolean z6 = false;
                        boolean z7 = false;
                        boolean z8 = true;
                        boolean z9 = false;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = i10;
                        int i16 = i11;
                        boolean z10 = r3;
                        while (!z7) {
                            OneDReader.m6997e(bitArray, i16, iArr3);
                            int i17 = -1;
                            int i18 = 0;
                            float f3 = 0.25f;
                            while (true) {
                                int[][] iArr4 = f13358a;
                                if (i18 < iArr4.length) {
                                    float fM6996d2 = OneDReader.m6996d(iArr3, iArr4[i18], f);
                                    if (fM6996d2 < f3) {
                                        f3 = fM6996d2;
                                        i17 = i18;
                                    }
                                    i18++;
                                } else {
                                    if (i17 < 0) {
                                        throw NotFoundException.f21665l;
                                    }
                                    arrayList.add(Byte.valueOf((byte) i17));
                                    if (i17 != 106) {
                                        z8 = true;
                                    }
                                    if (i17 != 106) {
                                        i13++;
                                        i9 = (i13 * i17) + i9;
                                    }
                                    int i19 = i16;
                                    for (int i20 = 0; i20 < 6; i20++) {
                                        i19 += iArr3[i20];
                                    }
                                    switch (i17) {
                                        case 103:
                                        case 104:
                                        case 105:
                                            throw FormatException.m9260a();
                                        default:
                                            switch (c2) {
                                                case 'c':
                                                    if (i17 >= 100) {
                                                        if (i17 != 106) {
                                                            z8 = false;
                                                        }
                                                        if (i17 == 106) {
                                                            z2 = false;
                                                            z7 = true;
                                                            z3 = z10;
                                                            break;
                                                        } else {
                                                            switch (i17) {
                                                                case 100:
                                                                    z2 = false;
                                                                    c2 = 'd';
                                                                    z3 = z10;
                                                                    break;
                                                                case 101:
                                                                    z2 = false;
                                                                    c2 = 'e';
                                                                    z3 = z10;
                                                                    break;
                                                                case 102:
                                                                    if (z4) {
                                                                        if (sb.length() == 0) {
                                                                            sb.append("]C1");
                                                                        } else {
                                                                            sb.append((char) 29);
                                                                        }
                                                                        break;
                                                                    }
                                                                default:
                                                                    z2 = false;
                                                                    z3 = z10;
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        if (i17 < 10) {
                                                            sb.append('0');
                                                        }
                                                        sb.append(i17);
                                                    }
                                                    z2 = false;
                                                    z3 = z10;
                                                    break;
                                                case 'd':
                                                    if (i17 < 96) {
                                                        if (z10 == z6) {
                                                            sb.append((char) (i17 + 32));
                                                        } else {
                                                            sb.append((char) (i17 + 32 + 128));
                                                        }
                                                        z10 = false;
                                                        z2 = false;
                                                        z3 = z10;
                                                    } else {
                                                        if (i17 != 106) {
                                                            z8 = false;
                                                        }
                                                        if (i17 != 106) {
                                                            switch (i17) {
                                                                case 98:
                                                                    z2 = true;
                                                                    c2 = 'e';
                                                                    z3 = z10;
                                                                    break;
                                                                case 99:
                                                                    z2 = false;
                                                                    c2 = 'c';
                                                                    z3 = z10;
                                                                    break;
                                                                case 100:
                                                                    if (z6 || !z10) {
                                                                        if (z6) {
                                                                        }
                                                                        z10 = true;
                                                                    }
                                                                    z3 = false;
                                                                    z2 = false;
                                                                    z6 = true;
                                                                    break;
                                                                case 101:
                                                                    z2 = false;
                                                                    c2 = 'e';
                                                                    z3 = z10;
                                                                    break;
                                                                case 102:
                                                                    if (z4) {
                                                                        if (sb.length() == 0) {
                                                                            sb.append("]C1");
                                                                        } else {
                                                                            sb.append((char) 29);
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            z7 = true;
                                                        }
                                                        z2 = false;
                                                        z3 = z10;
                                                    }
                                                    break;
                                                case 'e':
                                                    if (i17 >= 64) {
                                                        if (i17 >= 96) {
                                                            if (i17 != 106) {
                                                                z8 = false;
                                                            }
                                                            if (i17 != 106) {
                                                                switch (i17) {
                                                                    case 98:
                                                                        z2 = true;
                                                                        c2 = 'd';
                                                                        z3 = z10;
                                                                        break;
                                                                    case 100:
                                                                        z2 = false;
                                                                        c2 = 'd';
                                                                        z3 = z10;
                                                                        break;
                                                                    case 101:
                                                                        if (z6 || !z10) {
                                                                            if (z6) {
                                                                            }
                                                                            z10 = true;
                                                                        }
                                                                        z3 = false;
                                                                        z2 = false;
                                                                        z6 = true;
                                                                        break;
                                                                    case 102:
                                                                        if (z4) {
                                                                            if (sb.length() == 0) {
                                                                                sb.append("]C1");
                                                                            } else {
                                                                                sb.append((char) 29);
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                            z2 = false;
                                                            z3 = z10;
                                                            break;
                                                        } else if (z10 == z6) {
                                                            sb.append((char) (i17 - 64));
                                                        } else {
                                                            sb.append((char) (i17 + 64));
                                                        }
                                                    } else if (z10 == z6) {
                                                        sb.append((char) (i17 + 32));
                                                    } else {
                                                        sb.append((char) (i17 + 32 + 128));
                                                    }
                                                    z10 = false;
                                                    z2 = false;
                                                    z3 = z10;
                                                    break;
                                                default:
                                                    z2 = false;
                                                    z3 = z10;
                                                    break;
                                            }
                                            if (z9) {
                                                c2 = c2 == 'e' ? 'd' : 'e';
                                            }
                                            z9 = z2;
                                            i14 = i12;
                                            f = 0.7f;
                                            i12 = i17;
                                            int i21 = i19;
                                            i15 = i16;
                                            i16 = i21;
                                            z10 = z3;
                                            break;
                                    }
                                    while (!z7) {
                                    }
                                }
                            }
                        }
                        int i22 = i16 - i15;
                        int iM6937g = bitArray.m6937g(i16);
                        if (!bitArray.m6938h(iM6937g, Math.min(bitArray.f13228k, ((iM6937g - i15) / 2) + iM6937g), false)) {
                            throw NotFoundException.f21665l;
                        }
                        int i23 = i14;
                        if ((i9 - (i13 * i23)) % 103 != i23) {
                            throw ChecksumException.m9259a();
                        }
                        int length = sb.length();
                        if (length == 0) {
                            throw NotFoundException.f21665l;
                        }
                        if (length > 0 && z8) {
                            if (c2 == 'c') {
                                sb.delete(length - 2, length);
                            } else {
                                sb.delete(length - 1, length);
                            }
                        }
                        float f4 = (iArr2[1] + iArr2[0]) / 2.0f;
                        float f5 = (i22 / 2.0f) + i15;
                        int size = arrayList.size();
                        byte[] bArr = new byte[size];
                        for (int i24 = 0; i24 < size; i24++) {
                            bArr[i24] = ((Byte) arrayList.get(i24)).byteValue();
                        }
                        float f6 = i;
                        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f4, f6), new ResultPoint(f5, f6)}, BarcodeFormat.CODE_128);
                    }
                    i5 += iArr[0] + iArr[1];
                    int i25 = i6 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i25);
                    iArr[i25] = 0;
                    iArr[i6] = 0;
                    i6 = i25;
                } else {
                    i6++;
                }
                iArr[i6] = 1;
                z5 = !z5;
            }
            iM6936f++;
            i2 = 1;
            r3 = 0;
            i4 = 6;
        }
        throw NotFoundException.f21665l;
    }
}
