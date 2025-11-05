package b.i.e.r;

import b.i.e.d;
import b.i.e.i;
import b.i.e.k;
import b.i.e.n.e;
import b.i.e.r.d.f;
import b.i.e.r.d.g;
import b.i.e.r.d.h;
import b.i.e.r.d.j;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* loaded from: classes3.dex */
public final class b implements i {
    public static int b(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0;
        }
        return (int) Math.abs(kVar.a - kVar2.a);
    }

    public static int c(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(kVar.a - kVar2.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:325:0x064c, code lost:
    
        r3 = new com.google.zxing.Result(r2.c, r2.a, r4, b.i.e.a.PDF_417);
        r3.b(b.i.e.j.ERROR_CORRECTION_LEVEL, r2.e);
        r2 = (b.i.e.r.c) r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0662, code lost:
    
        if (r2 == null) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0664, code lost:
    
        r3.b(b.i.e.j.PDF417_EXTRA_METADATA, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0669, code lost:
    
        r0.add(r3);
        r3 = r25;
        r2 = 0;
        r5 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a2  */
    @Override // b.i.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result a(b.i.e.c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, NumberFormatException, FormatException {
        b.i.e.r.d.c cVar2;
        f fVar;
        int i;
        boolean z2;
        int i2;
        Iterator<k[]> it;
        b.i.e.r.d.c cVar3;
        int i3;
        Iterator<k[]> it2;
        int i4;
        b.i.e.r.d.d dVar;
        int i5;
        int i6;
        int i7;
        g gVar;
        int i8;
        int i9;
        int i10;
        b.i.e.r.d.c cVar4;
        int i11;
        int i12;
        b.i.e.r.d.c cVar5;
        b.i.e.r.d.a aVarC;
        b.i.e.r.d.a aVarC2;
        ArrayList arrayList = new ArrayList();
        b.i.e.n.b bVarA = cVar.a();
        char c = 0;
        List<k[]> listA = b.i.e.r.e.a.a(false, bVarA);
        int i13 = 2;
        if (((ArrayList) listA).isEmpty()) {
            int i14 = bVarA.j;
            int i15 = bVarA.k;
            b.i.e.n.b bVar = new b.i.e.n.b(i14, i15, bVarA.l, (int[]) bVarA.m.clone());
            b.i.e.n.a aVar = new b.i.e.n.a(i14);
            b.i.e.n.a aVar2 = new b.i.e.n.a(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                aVar = bVar.h(i16, aVar);
                int i17 = (i15 - 1) - i16;
                aVar2 = bVar.h(i17, aVar2);
                aVar.i();
                aVar2.i();
                int[] iArr = aVar2.j;
                int[] iArr2 = bVar.m;
                int i18 = bVar.l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = aVar.j;
                int[] iArr4 = bVar.m;
                int i19 = bVar.l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listA = b.i.e.r.e.a.a(false, bVar);
            bVarA = bVar;
        }
        Iterator<k[]> it3 = listA.iterator();
        while (it3.hasNext()) {
            k[] next = it3.next();
            k kVar = next[4];
            k kVar2 = next[5];
            k kVar3 = next[6];
            k kVar4 = next[7];
            int iMin = Math.min(Math.min(c(next[c], next[4]), (c(next[6], next[i13]) * 17) / 18), Math.min(c(next[1], next[5]), (c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(b(next[c], next[4]), (b(next[6], next[i13]) * 17) / 18), Math.max(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18));
            b.i.e.r.d.k.a aVar3 = j.a;
            b.i.e.r.d.c cVar6 = new b.i.e.r.d.c(bVarA, kVar, kVar2, kVar3, kVar4);
            f fVar2 = null;
            h hVarD = null;
            h hVarD2 = null;
            int i20 = 0;
            while (i20 < i13) {
                if (kVar != null) {
                    i12 = i20;
                    cVar5 = cVar6;
                    hVarD = j.d(bVarA, cVar6, kVar, true, iMin, iMax);
                } else {
                    i12 = i20;
                    cVar5 = cVar6;
                }
                h hVar = hVarD;
                if (kVar3 != null) {
                    hVarD2 = j.d(bVarA, cVar5, kVar3, false, iMin, iMax);
                }
                if (hVar != null || hVarD2 != null) {
                    if (hVar == null || (aVarC = hVar.c()) == null) {
                        aVarC = hVarD2 == null ? null : hVarD2.c();
                        if (aVarC != null) {
                            fVar2 = null;
                        } else {
                            b.i.e.r.d.c cVarA = j.a(hVar);
                            b.i.e.r.d.c cVarA2 = j.a(hVarD2);
                            if (cVarA == null) {
                                cVarA = cVarA2;
                            } else if (cVarA2 != null) {
                                cVarA = new b.i.e.r.d.c(cVarA.a, cVarA.f1877b, cVarA.c, cVarA2.d, cVarA2.e);
                            }
                            fVar2 = new f(aVarC, cVarA);
                        }
                        if (fVar2 != null) {
                            throw NotFoundException.l;
                        }
                        if (i12 != 0 || (cVar6 = fVar2.c) == null) {
                            cVar2 = cVar5;
                            fVar2.c = cVar2;
                            fVar = fVar2;
                            hVarD = hVar;
                            break;
                        }
                        cVar2 = cVar5;
                        if (cVar6.h >= cVar2.h && cVar6.i <= cVar2.i) {
                            fVar2.c = cVar2;
                            fVar = fVar2;
                            hVarD = hVar;
                            break;
                        }
                        i20 = i12 + 1;
                        hVarD = hVar;
                        i13 = 2;
                    } else {
                        if (hVarD2 != null && (aVarC2 = hVarD2.c()) != null && aVarC.a != aVarC2.a && aVarC.f1876b != aVarC2.f1876b && aVarC.e != aVarC2.e) {
                        }
                        if (aVarC != null) {
                        }
                        if (fVar2 != null) {
                        }
                    }
                }
            }
            cVar2 = cVar6;
            fVar = fVar2;
            int i21 = fVar.d + 1;
            g[] gVarArr = fVar.f1880b;
            gVarArr[c] = hVarD;
            gVarArr[i21] = hVarD2;
            boolean z3 = hVarD != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (fVar.f1880b[i24] == null) {
                    g hVar2 = (i24 == 0 || i24 == i21) ? new h(cVar2, i24 == 0) : new g(cVar2);
                    fVar.f1880b[i24] = hVar2;
                    int i25 = cVar2.h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= cVar2.i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (j.e(fVar, i29)) {
                            it2 = it3;
                            g gVar2 = fVar.f1880b[i29];
                            i4 = iMax2;
                            dVar = gVar2.f1881b[i25 - gVar2.a.h];
                        } else {
                            it2 = it3;
                            i4 = iMax2;
                            dVar = null;
                        }
                        if (dVar != null) {
                            i6 = z3 ? dVar.f1878b : dVar.a;
                        } else {
                            b.i.e.r.d.d dVarA = fVar.f1880b[i24].a(i25);
                            if (dVarA != null) {
                                i6 = z3 ? dVarA.a : dVarA.f1878b;
                            } else {
                                if (j.e(fVar, i29)) {
                                    dVarA = fVar.f1880b[i29].a(i25);
                                }
                                if (dVarA != null) {
                                    i6 = z3 ? dVarA.f1878b : dVarA.a;
                                } else {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (j.e(fVar, i32)) {
                                            b.i.e.r.d.d[] dVarArr = fVar.f1880b[i32].f1881b;
                                            int length = dVarArr.length;
                                            i5 = i25;
                                            int i33 = 0;
                                            while (i33 < length) {
                                                int i34 = length;
                                                b.i.e.r.d.d dVar2 = dVarArr[i33];
                                                if (dVar2 != null) {
                                                    i6 = ((dVar2.f1878b - dVar2.a) * i28 * i31) + (z3 ? dVar2.f1878b : dVar2.a);
                                                } else {
                                                    i33++;
                                                    length = i34;
                                                }
                                            }
                                            i31++;
                                            i30 = i32;
                                            i25 = i5;
                                        } else {
                                            i5 = i25;
                                            i6 = z3 ? fVar.c.f : fVar.c.g;
                                        }
                                    }
                                    if (i6 < 0 && i6 <= cVar2.g) {
                                        i11 = i6;
                                    } else if (i27 == -1) {
                                        i11 = i27;
                                    } else {
                                        i7 = i26;
                                        gVar = hVar2;
                                        i8 = i24;
                                        i9 = i21;
                                        iMax2 = i4;
                                        i10 = i5;
                                        cVar4 = cVar2;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        hVar2 = gVar;
                                        it3 = it2;
                                        cVar2 = cVar4;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                    int i35 = i4;
                                    i10 = i5;
                                    int i36 = i26;
                                    cVar4 = cVar2;
                                    i8 = i24;
                                    gVar = hVar2;
                                    i9 = i21;
                                    b.i.e.r.d.d dVarC = j.c(bVarA, cVar2.f, cVar2.g, z3, i11, i10, i36, i35);
                                    if (dVarC != null) {
                                        gVar.f1881b[i10 - gVar.a.h] = dVarC;
                                        int iMin2 = Math.min(i36, dVarC.f1878b - dVarC.a);
                                        iMax2 = Math.max(i35, dVarC.f1878b - dVarC.a);
                                        i26 = iMin2;
                                        i27 = i11;
                                        i25 = i10 + 1;
                                        hVar2 = gVar;
                                        it3 = it2;
                                        cVar2 = cVar4;
                                        i24 = i8;
                                        i21 = i9;
                                    } else {
                                        iMax2 = i35;
                                        i7 = i36;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        hVar2 = gVar;
                                        it3 = it2;
                                        cVar2 = cVar4;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                }
                            }
                        }
                        i5 = i25;
                        if (i6 < 0) {
                            if (i27 == -1) {
                            }
                        }
                        i25 = i10 + 1;
                        hVar2 = gVar;
                        it3 = it2;
                        cVar2 = cVar4;
                        i24 = i8;
                        i21 = i9;
                    }
                    it = it3;
                    cVar3 = cVar2;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it3;
                    cVar3 = cVar2;
                    i3 = i21;
                }
                i23++;
                it3 = it;
                cVar2 = cVar3;
                i21 = i3;
            }
            Iterator<k[]> it4 = it3;
            b.i.e.r.d.b[][] bVarArr = (b.i.e.r.d.b[][]) Array.newInstance((Class<?>) b.i.e.r.d.b.class, fVar.a.e, fVar.d + 2);
            for (int i37 = 0; i37 < bVarArr.length; i37++) {
                for (int i38 = 0; i38 < bVarArr[i37].length; i38++) {
                    bVarArr[i37][i38] = new b.i.e.r.d.b();
                }
            }
            char c2 = 0;
            fVar.a(fVar.f1880b[0]);
            int i39 = 1;
            fVar.a(fVar.f1880b[fVar.d + 1]);
            int i40 = 928;
            while (true) {
                g[] gVarArr2 = fVar.f1880b;
                if (gVarArr2[c2] != null) {
                    int i41 = fVar.d + i39;
                    if (gVarArr2[i41] != null) {
                        b.i.e.r.d.d[] dVarArr2 = gVarArr2[c2].f1881b;
                        b.i.e.r.d.d[] dVarArr3 = gVarArr2[i41].f1881b;
                        for (int i42 = 0; i42 < dVarArr2.length; i42++) {
                            if (dVarArr2[i42] != null && dVarArr3[i42] != null && dVarArr2[i42].e == dVarArr3[i42].e) {
                                for (int i43 = 1; i43 <= fVar.d; i43++) {
                                    b.i.e.r.d.d dVar3 = fVar.f1880b[i43].f1881b[i42];
                                    if (dVar3 != null) {
                                        dVar3.e = dVarArr2[i42].e;
                                        if (!dVar3.a()) {
                                            fVar.f1880b[i43].f1881b[i42] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                g[] gVarArr3 = fVar.f1880b;
                int i44 = 0;
                if (gVarArr3[0] != null) {
                    b.i.e.r.d.d[] dVarArr4 = gVarArr3[0].f1881b;
                    int i45 = 0;
                    for (int i46 = 0; i46 < dVarArr4.length; i46++) {
                        if (dVarArr4[i46] != null) {
                            int i47 = dVarArr4[i46].e;
                            int i48 = i45;
                            int iB = 0;
                            for (int i49 = 1; i49 < fVar.d + 1 && iB < 2; i49++) {
                                b.i.e.r.d.d dVar4 = fVar.f1880b[i49].f1881b[i46];
                                if (dVar4 != null) {
                                    iB = f.b(i47, iB, dVar4);
                                    if (!dVar4.a()) {
                                        i48++;
                                    }
                                }
                            }
                            i45 = i48;
                        }
                    }
                    i44 = i45;
                }
                g[] gVarArr4 = fVar.f1880b;
                int i50 = fVar.d + 1;
                if (gVarArr4[i50] == null) {
                    i = 0;
                } else {
                    b.i.e.r.d.d[] dVarArr5 = gVarArr4[i50].f1881b;
                    i = 0;
                    for (int i51 = 0; i51 < dVarArr5.length; i51++) {
                        if (dVarArr5[i51] != null) {
                            int i52 = dVarArr5[i51].e;
                            int i53 = i;
                            int iB2 = 0;
                            for (int i54 = fVar.d + 1; i54 > 0 && iB2 < 2; i54--) {
                                b.i.e.r.d.d dVar5 = fVar.f1880b[i54].f1881b[i51];
                                if (dVar5 != null) {
                                    iB2 = f.b(i52, iB2, dVar5);
                                    if (!dVar5.a()) {
                                        i53++;
                                    }
                                }
                            }
                            i = i53;
                        }
                    }
                }
                int i55 = i44 + i;
                if (i55 == 0) {
                    i55 = 0;
                } else {
                    for (int i56 = 1; i56 < fVar.d + 1; i56++) {
                        b.i.e.r.d.d[] dVarArr6 = fVar.f1880b[i56].f1881b;
                        for (int i57 = 0; i57 < dVarArr6.length; i57++) {
                            if (dVarArr6[i57] != null && !dVarArr6[i57].a()) {
                                b.i.e.r.d.d dVar6 = dVarArr6[i57];
                                g[] gVarArr5 = fVar.f1880b;
                                b.i.e.r.d.d[] dVarArr7 = gVarArr5[i56 - 1].f1881b;
                                int i58 = i56 + 1;
                                b.i.e.r.d.d[] dVarArr8 = gVarArr5[i58] != null ? gVarArr5[i58].f1881b : dVarArr7;
                                b.i.e.r.d.d[] dVarArr9 = new b.i.e.r.d.d[14];
                                dVarArr9[2] = dVarArr7[i57];
                                dVarArr9[3] = dVarArr8[i57];
                                if (i57 > 0) {
                                    int i59 = i57 - 1;
                                    dVarArr9[0] = dVarArr6[i59];
                                    dVarArr9[4] = dVarArr7[i59];
                                    dVarArr9[5] = dVarArr8[i59];
                                }
                                if (i57 > 1) {
                                    int i60 = i57 - 2;
                                    dVarArr9[8] = dVarArr6[i60];
                                    dVarArr9[10] = dVarArr7[i60];
                                    dVarArr9[11] = dVarArr8[i60];
                                }
                                if (i57 < dVarArr6.length - 1) {
                                    int i61 = i57 + 1;
                                    dVarArr9[1] = dVarArr6[i61];
                                    dVarArr9[6] = dVarArr7[i61];
                                    dVarArr9[7] = dVarArr8[i61];
                                }
                                if (i57 < dVarArr6.length - 2) {
                                    int i62 = i57 + 2;
                                    dVarArr9[9] = dVarArr6[i62];
                                    dVarArr9[12] = dVarArr7[i62];
                                    dVarArr9[13] = dVarArr8[i62];
                                }
                                int i63 = 0;
                                for (int i64 = 14; i63 < i64; i64 = 14) {
                                    b.i.e.r.d.d dVar7 = dVarArr9[i63];
                                    if (dVar7 != null && dVar7.a() && dVar7.c == dVar6.c) {
                                        dVar6.e = dVar7.e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i63++;
                                }
                            }
                        }
                    }
                }
                if (i55 <= 0 || i55 >= i40) {
                    break;
                }
                i40 = i55;
                c2 = 0;
                i39 = 1;
            }
            int i65 = 0;
            for (g gVar3 : fVar.f1880b) {
                if (gVar3 != null) {
                    for (b.i.e.r.d.d dVar8 : gVar3.f1881b) {
                        if (dVar8 != null && (i2 = dVar8.e) >= 0 && i2 < bVarArr.length) {
                            bVarArr[i2][i65].b(dVar8.d);
                        }
                    }
                }
                i65++;
            }
            b.i.e.r.d.b bVar2 = bVarArr[0][1];
            int[] iArrA = bVar2.a();
            int i66 = fVar.d;
            b.i.e.r.d.a aVar4 = fVar.a;
            int i67 = (i66 * aVar4.e) - (2 << aVar4.f1876b);
            if (iArrA.length == 0) {
                if (i67 <= 0 || i67 > 928) {
                    throw NotFoundException.l;
                }
                bVar2.b(i67);
            } else if (iArrA[0] != i67) {
                bVar2.b(i67);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[fVar.a.e * fVar.d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i68 = 0; i68 < fVar.a.e; i68++) {
                int i69 = 0;
                while (i69 < fVar.d) {
                    int i70 = i69 + 1;
                    int[] iArrA2 = bVarArr[i68][i70].a();
                    int i71 = (fVar.d * i68) + i69;
                    if (iArrA2.length == 0) {
                        arrayList2.add(Integer.valueOf(i71));
                    } else if (iArrA2.length == 1) {
                        iArr5[i71] = iArrA2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i71));
                        arrayList3.add(iArrA2);
                    }
                    i69 = i70;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i72 = 0; i72 < size; i72++) {
                iArr6[i72] = (int[]) arrayList3.get(i72);
            }
            int i73 = fVar.a.f1876b;
            int[] iArrB = a.b(arrayList2);
            int[] iArrB2 = a.b(arrayList4);
            int length2 = iArrB2.length;
            int[] iArr7 = new int[length2];
            int i74 = 100;
            while (true) {
                int i75 = i74 - 1;
                if (i74 <= 0) {
                    throw ChecksumException.a();
                }
                for (int i76 = 0; i76 < length2; i76++) {
                    iArr5[iArrB2[i76]] = iArr6[i76][iArr7[i76]];
                }
                try {
                    e eVarB = j.b(iArr5, i73, iArrB);
                    break;
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.a();
                    }
                    int i77 = 0;
                    while (true) {
                        if (i77 >= length2) {
                            break;
                        }
                        if (iArr7[i77] < iArr6[i77].length - 1) {
                            iArr7[i77] = iArr7[i77] + 1;
                            break;
                        }
                        iArr7[i77] = 0;
                        if (i77 == length2 - 1) {
                            throw ChecksumException.a();
                        }
                        i77++;
                    }
                    i74 = i75;
                }
            }
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.l;
        }
        return resultArr[0];
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
