package b.i.a.c.c3;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.n0;
import b.i.a.c.a3.o0;
import b.i.a.c.c3.f;
import b.i.a.c.c3.h;
import b.i.a.c.c3.j;
import b.i.a.c.c3.o;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.t;
import b.i.a.c.g2;
import b.i.a.c.h2;
import b.i.a.c.j1;
import b.i.a.c.o2;
import b.i.a.c.p2;
import b.i.a.c.v0;
import b.i.b.b.c0;
import b.i.b.b.d0;
import b.i.b.b.f0;
import b.i.b.b.g;
import b.i.b.b.h0;
import b.i.b.b.n;
import b.i.b.b.p;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* compiled from: MappingTrackSelector.java */
/* loaded from: classes3.dex */
public abstract class l extends q {

    /* compiled from: MappingTrackSelector.java */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f903b;
        public final o0[] c;
        public final int[] d;
        public final int[][][] e;
        public final o0 f;

        @VisibleForTesting
        public a(String[] strArr, int[] iArr, o0[] o0VarArr, int[] iArr2, int[][][] iArr3, o0 o0Var) {
            this.f903b = iArr;
            this.c = o0VarArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = o0Var;
            this.a = iArr.length;
        }

        public int a(int i, int i2, int i3) {
            return this.e[i][i2][i3] & 7;
        }
    }

    @Override // b.i.a.c.c3.q
    public final void a(@Nullable Object obj) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028d A[LOOP:8: B:67:0x0159->B:110:0x028d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x09b6  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0287 A[SYNTHETIC] */
    @Override // b.i.a.c.c3.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r b(g2[] g2VarArr, o0 o0Var, a0.a aVar, o2 o2Var) throws ExoPlaybackException {
        int i;
        boolean z2;
        boolean z3;
        j fVar;
        int[] iArr;
        int[] iArr2;
        String str;
        h.d dVar;
        Pair pairCreate;
        int[][] iArr3;
        n0 n0Var;
        String str2;
        int[][] iArr4;
        a aVar2;
        int i2;
        int i3;
        h.d dVar2;
        String str3;
        j.a aVar3;
        Pair pairCreate2;
        int i4;
        int[] iArr5;
        int i5;
        int i6;
        String str4;
        int i7;
        n0 n0Var2;
        h hVar;
        int i8;
        j.a[] aVarArr;
        int i9;
        int[][][] iArr6;
        int[] iArr7;
        h.d dVar3;
        boolean z4;
        a aVar4;
        h.d dVar4;
        o0 o0Var2;
        int[][] iArr8;
        j.a aVar5;
        List<Integer> list;
        ArrayList arrayList;
        boolean z5;
        String str5;
        int[] iArrQ1;
        ArrayList arrayList2;
        HashSet hashSet;
        int i10;
        int[] iArr9;
        o0 o0Var3 = o0Var;
        int[] iArr10 = new int[g2VarArr.length + 1];
        int length = g2VarArr.length + 1;
        n0[][] n0VarArr = new n0[length][];
        int[][][] iArr11 = new int[g2VarArr.length + 1][][];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = o0Var3.k;
            n0VarArr[i12] = new n0[i13];
            iArr11[i12] = new int[i13][];
        }
        int length2 = g2VarArr.length;
        int[] iArr12 = new int[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            iArr12[i14] = g2VarArr[i14].p();
        }
        int i15 = 0;
        while (i15 < o0Var3.k) {
            n0 n0Var3 = o0Var3.l[i15];
            boolean z6 = t.g(n0Var3.l[i11].w) == 5;
            int length3 = g2VarArr.length;
            int i16 = 0;
            int i17 = 0;
            boolean z7 = true;
            while (i16 < g2VarArr.length) {
                g2 g2Var = g2VarArr[i16];
                int iMax = 0;
                while (i11 < n0Var3.k) {
                    iMax = Math.max(iMax, g2Var.a(n0Var3.l[i11]) & 7);
                    i11++;
                }
                boolean z8 = iArr10[i16] == 0;
                if (iMax > i17 || (iMax == i17 && z6 && !z7 && z8)) {
                    z7 = z8;
                    i17 = iMax;
                    length3 = i16;
                }
                i16++;
                i11 = 0;
            }
            if (length3 == g2VarArr.length) {
                iArr9 = new int[n0Var3.k];
            } else {
                g2 g2Var2 = g2VarArr[length3];
                int[] iArr13 = new int[n0Var3.k];
                for (int i18 = 0; i18 < n0Var3.k; i18++) {
                    iArr13[i18] = g2Var2.a(n0Var3.l[i18]);
                }
                iArr9 = iArr13;
            }
            int i19 = iArr10[length3];
            n0VarArr[length3][i19] = n0Var3;
            iArr11[length3][i19] = iArr9;
            iArr10[length3] = iArr10[length3] + 1;
            i15++;
            o0Var3 = o0Var;
            i11 = 0;
        }
        o0[] o0VarArr = new o0[g2VarArr.length];
        String[] strArr = new String[g2VarArr.length];
        int[] iArr14 = new int[g2VarArr.length];
        for (int i20 = 0; i20 < g2VarArr.length; i20++) {
            int i21 = iArr10[i20];
            o0VarArr[i20] = new o0((n0[]) e0.D(n0VarArr[i20], i21));
            iArr11[i20] = (int[][]) e0.D(iArr11[i20], i21);
            strArr[i20] = g2VarArr[i20].getName();
            iArr14[i20] = ((v0) g2VarArr[i20]).j;
        }
        a aVar6 = new a(strArr, iArr14, o0VarArr, iArr12, iArr11, new o0((n0[]) e0.D(n0VarArr[g2VarArr.length], iArr10[g2VarArr.length])));
        h hVar2 = (h) this;
        h.d dVar5 = hVar2.f.get();
        int i22 = aVar6.a;
        j.a[] aVarArr2 = new j.a[i22];
        a aVar7 = aVar6;
        h.d dVar6 = dVar5;
        int i23 = 0;
        boolean z9 = false;
        boolean z10 = false;
        while (i23 < i22) {
            if (2 == aVar7.f903b[i23]) {
                if (z10) {
                    hVar = hVar2;
                    i8 = i22;
                    aVarArr = aVarArr2;
                    i9 = i23;
                    iArr6 = iArr11;
                    z4 = z9;
                    iArr7 = iArr12;
                    dVar3 = dVar5;
                } else {
                    o0 o0Var4 = aVar7.c[i23];
                    int[][] iArr15 = iArr11[i23];
                    int i24 = iArr12[i23];
                    if (dVar6.F || dVar6.E) {
                        aVar4 = aVar6;
                        hVar = hVar2;
                        dVar4 = dVar5;
                        i8 = i22;
                        aVarArr = aVarArr2;
                        i9 = i23;
                        iArr6 = iArr11;
                        z4 = z9;
                        o0Var2 = o0Var4;
                        iArr8 = iArr15;
                        iArr7 = iArr12;
                        aVar5 = null;
                        if (aVar5 != null) {
                            o0 o0Var5 = o0Var2;
                            n0 n0Var4 = null;
                            h.C0098h c0098h = null;
                            int i25 = 0;
                            int i26 = -1;
                            while (i25 < o0Var5.k) {
                                n0 n0Var5 = o0Var5.l[i25];
                                h.d dVar7 = dVar4;
                                List<Integer> listD = h.d(n0Var5, dVar7.f905s, dVar7.t, dVar7.u);
                                int[] iArr16 = iArr8[i25];
                                h.C0098h c0098h2 = c0098h;
                                n0 n0Var6 = n0Var4;
                                for (int i27 = 0; i27 < n0Var5.k; i27++) {
                                    j1 j1Var = n0Var5.l[i27];
                                    if ((j1Var.p & 16384) == 0 && h.e(iArr16[i27], dVar7.R)) {
                                        h.C0098h c0098h3 = new h.C0098h(j1Var, dVar7, iArr16[i27], ((ArrayList) listD).contains(Integer.valueOf(i27)));
                                        if ((c0098h3.j || dVar7.K) && (c0098h2 == null || c0098h3.f(c0098h2) > 0)) {
                                            i26 = i27;
                                            n0Var6 = n0Var5;
                                            c0098h2 = c0098h3;
                                        }
                                    }
                                }
                                i25++;
                                n0Var4 = n0Var6;
                                dVar4 = dVar7;
                                c0098h = c0098h2;
                            }
                            dVar3 = dVar4;
                            aVar5 = n0Var4 == null ? null : new j.a(n0Var4, i26);
                        } else {
                            dVar3 = dVar4;
                        }
                        aVarArr[i9] = aVar5;
                        z10 = aVarArr[i9] == null;
                        dVar6 = dVar3;
                        aVar6 = aVar4;
                    } else {
                        int i28 = dVar6.M ? 24 : 16;
                        boolean z11 = dVar6.L && (i24 & i28) != 0;
                        h.d dVar8 = dVar6;
                        int i29 = 0;
                        while (i29 < o0Var4.k) {
                            n0 n0Var7 = o0Var4.l[i29];
                            int[] iArr17 = iArr15[i29];
                            hVar = hVar2;
                            int i30 = dVar8.k;
                            iArr7 = iArr12;
                            int i31 = dVar8.l;
                            iArr6 = iArr11;
                            int i32 = dVar8.m;
                            i8 = i22;
                            int i33 = dVar8.n;
                            z4 = z9;
                            int i34 = dVar8.o;
                            aVar4 = aVar6;
                            int i35 = dVar8.p;
                            aVarArr = aVarArr2;
                            int i36 = dVar8.q;
                            i9 = i23;
                            int i37 = dVar8.r;
                            iArr8 = iArr15;
                            int i38 = dVar8.f905s;
                            dVar4 = dVar5;
                            int i39 = dVar8.t;
                            boolean z12 = dVar8.u;
                            o0Var2 = o0Var4;
                            int i40 = i29;
                            if (n0Var7.k < 2) {
                                iArrQ1 = h.f898b;
                            } else {
                                List<Integer> listD2 = h.d(n0Var7, i38, i39, z12);
                                ArrayList arrayList3 = (ArrayList) listD2;
                                if (arrayList3.size() < 2) {
                                    iArrQ1 = h.f898b;
                                } else {
                                    if (z11) {
                                        list = listD2;
                                        arrayList = arrayList3;
                                        z5 = z11;
                                        str5 = null;
                                    } else {
                                        HashSet hashSet2 = new HashSet();
                                        z5 = z11;
                                        int i41 = 0;
                                        int i42 = 0;
                                        str5 = null;
                                        while (i42 < arrayList3.size()) {
                                            List<Integer> list2 = listD2;
                                            String str6 = n0Var7.l[((Integer) arrayList3.get(i42)).intValue()].w;
                                            if (hashSet2.add(str6)) {
                                                hashSet = hashSet2;
                                                i10 = i42;
                                                int i43 = 0;
                                                int i44 = 0;
                                                while (i44 < arrayList3.size()) {
                                                    int iIntValue = ((Integer) arrayList3.get(i44)).intValue();
                                                    ArrayList arrayList4 = arrayList3;
                                                    if (h.f(n0Var7.l[iIntValue], str6, iArr17[iIntValue], i28, i30, i31, i32, i33, i34, i35, i36, i37)) {
                                                        i43++;
                                                    }
                                                    i44++;
                                                    arrayList3 = arrayList4;
                                                }
                                                arrayList2 = arrayList3;
                                                if (i43 > i41) {
                                                    str5 = str6;
                                                    i41 = i43;
                                                }
                                            } else {
                                                arrayList2 = arrayList3;
                                                hashSet = hashSet2;
                                                i10 = i42;
                                            }
                                            i42 = i10 + 1;
                                            listD2 = list2;
                                            hashSet2 = hashSet;
                                            arrayList3 = arrayList2;
                                        }
                                        list = listD2;
                                        arrayList = arrayList3;
                                    }
                                    int size = arrayList.size();
                                    while (true) {
                                        size--;
                                        if (size < 0) {
                                            break;
                                        }
                                        ArrayList arrayList5 = arrayList;
                                        int iIntValue2 = ((Integer) arrayList5.get(size)).intValue();
                                        if (!h.f(n0Var7.l[iIntValue2], str5, iArr17[iIntValue2], i28, i30, i31, i32, i33, i34, i35, i36, i37)) {
                                            arrayList5.remove(size);
                                        }
                                        arrayList = arrayList5;
                                    }
                                    iArrQ1 = arrayList.size() < 2 ? h.f898b : b.i.a.f.e.o.f.q1(list);
                                    if (iArrQ1.length <= 0) {
                                        aVar5 = new j.a(n0Var7, iArrQ1);
                                        break;
                                    }
                                    i29 = i40 + 1;
                                    hVar2 = hVar;
                                    iArr12 = iArr7;
                                    iArr11 = iArr6;
                                    i22 = i8;
                                    z9 = z4;
                                    aVar6 = aVar4;
                                    aVarArr2 = aVarArr;
                                    i23 = i9;
                                    iArr15 = iArr8;
                                    dVar5 = dVar4;
                                    dVar8 = dVar5;
                                    o0Var4 = o0Var2;
                                    z11 = z5;
                                }
                            }
                            z5 = z11;
                            if (iArrQ1.length <= 0) {
                            }
                        }
                        aVar4 = aVar6;
                        hVar = hVar2;
                        dVar4 = dVar5;
                        i8 = i22;
                        aVarArr = aVarArr2;
                        i9 = i23;
                        iArr6 = iArr11;
                        z4 = z9;
                        o0Var2 = o0Var4;
                        iArr8 = iArr15;
                        iArr7 = iArr12;
                        aVar5 = null;
                        if (aVar5 != null) {
                        }
                        aVarArr[i9] = aVar5;
                        z10 = aVarArr[i9] == null;
                        dVar6 = dVar3;
                        aVar6 = aVar4;
                    }
                }
                aVar7 = aVar6;
                z9 = z4 | (aVar6.c[i9].k > 0);
            } else {
                hVar = hVar2;
                i8 = i22;
                aVarArr = aVarArr2;
                i9 = i23;
                iArr6 = iArr11;
                iArr7 = iArr12;
                dVar3 = dVar5;
            }
            dVar5 = dVar3;
            iArr12 = iArr7;
            iArr11 = iArr6;
            i22 = i8;
            aVarArr2 = aVarArr;
            i23 = i9 + 1;
            hVar2 = hVar;
        }
        h hVar3 = hVar2;
        h.d dVar9 = dVar5;
        j.a[] aVarArr3 = aVarArr2;
        int[][][] iArr18 = iArr11;
        boolean z13 = z9;
        int[] iArr19 = iArr12;
        int i45 = i22;
        h.b bVar = null;
        int i46 = -1;
        int i47 = 0;
        String str7 = null;
        while (i47 < i45) {
            if (1 == aVar7.f903b[i47]) {
                boolean z14 = dVar6.T || !z13;
                o0 o0Var6 = aVar7.c[i47];
                int[][] iArr20 = iArr18[i47];
                int i48 = iArr19[i47];
                h.b bVar2 = null;
                int i49 = -1;
                int i50 = -1;
                int i51 = 0;
                while (i51 < o0Var6.k) {
                    n0 n0Var8 = o0Var6.l[i51];
                    int[] iArr21 = iArr20[i51];
                    int i52 = i49;
                    int i53 = i50;
                    h.b bVar3 = bVar2;
                    int i54 = 0;
                    while (i54 < n0Var8.k) {
                        String str8 = str7;
                        if (h.e(iArr21[i54], dVar6.R)) {
                            n0Var2 = n0Var8;
                            h.b bVar4 = new h.b(n0Var8.l[i54], dVar6, iArr21[i54]);
                            if ((bVar4.j || dVar6.N) && (bVar3 == null || bVar4.f(bVar3) > 0)) {
                                i53 = i54;
                                bVar3 = bVar4;
                                i52 = i51;
                            }
                        } else {
                            n0Var2 = n0Var8;
                        }
                        i54++;
                        str7 = str8;
                        n0Var8 = n0Var2;
                    }
                    i51++;
                    bVar2 = bVar3;
                    i50 = i53;
                    i49 = i52;
                }
                str3 = str7;
                if (i49 == -1) {
                    aVar2 = aVar6;
                    i2 = i47;
                    i3 = i45;
                    dVar2 = dVar9;
                    pairCreate2 = null;
                } else {
                    n0 n0Var9 = o0Var6.l[i49];
                    if (dVar6.F || dVar6.E || !z14) {
                        aVar2 = aVar6;
                        i2 = i47;
                        i3 = i45;
                        dVar2 = dVar9;
                    } else {
                        int[] iArr22 = iArr20[i49];
                        int i55 = dVar6.f908z;
                        boolean z15 = dVar6.O;
                        boolean z16 = dVar6.P;
                        boolean z17 = dVar6.Q;
                        j1 j1Var2 = n0Var9.l[i50];
                        int[] iArr23 = new int[n0Var9.k];
                        aVar2 = aVar6;
                        i3 = i45;
                        dVar2 = dVar9;
                        int i56 = 0;
                        int i57 = 0;
                        while (i57 < n0Var9.k) {
                            if (i57 != i50) {
                                j1 j1Var3 = n0Var9.l[i57];
                                i4 = i47;
                                iArr5 = iArr22;
                                if (h.e(iArr22[i57], false) && (i5 = j1Var3.f1017s) != -1 && i5 <= i55 && (z17 || ((i7 = j1Var3.J) != -1 && i7 == j1Var2.J)) && ((z15 || ((str4 = j1Var3.w) != null && TextUtils.equals(str4, j1Var2.w))) && (z16 || ((i6 = j1Var3.K) != -1 && i6 == j1Var2.K)))) {
                                }
                                i57++;
                                i47 = i4;
                                iArr22 = iArr5;
                            } else {
                                i4 = i47;
                                iArr5 = iArr22;
                            }
                            iArr23[i56] = i57;
                            i56++;
                            i57++;
                            i47 = i4;
                            iArr22 = iArr5;
                        }
                        i2 = i47;
                        int[] iArrCopyOf = Arrays.copyOf(iArr23, i56);
                        aVar3 = iArrCopyOf.length > 1 ? new j.a(n0Var9, iArrCopyOf) : null;
                        if (aVar3 == null) {
                            aVar3 = new j.a(n0Var9, i50);
                        }
                        Objects.requireNonNull(bVar2);
                        pairCreate2 = Pair.create(aVar3, bVar2);
                    }
                    if (aVar3 == null) {
                    }
                    Objects.requireNonNull(bVar2);
                    pairCreate2 = Pair.create(aVar3, bVar2);
                }
                if (pairCreate2 != null && (bVar == null || ((h.b) pairCreate2.second).f(bVar) > 0)) {
                    if (i46 != -1) {
                        aVarArr3[i46] = null;
                    }
                    j.a aVar8 = (j.a) pairCreate2.first;
                    aVarArr3[i2] = aVar8;
                    str7 = aVar8.a.l[aVar8.f902b[0]].n;
                    i46 = i2;
                    bVar = (h.b) pairCreate2.second;
                }
                i47 = i2 + 1;
                i45 = i3;
                aVar6 = aVar2;
                aVar7 = aVar6;
                dVar9 = dVar2;
                dVar6 = dVar9;
            } else {
                aVar2 = aVar6;
                i2 = i47;
                i3 = i45;
                dVar2 = dVar9;
                str3 = str7;
            }
            str7 = str3;
            i47 = i2 + 1;
            i45 = i3;
            aVar6 = aVar2;
            aVar7 = aVar6;
            dVar9 = dVar2;
            dVar6 = dVar9;
        }
        a aVar9 = aVar6;
        h.d dVar10 = dVar9;
        String str9 = str7;
        int i58 = i45;
        int i59 = -1;
        int i60 = 0;
        h.g gVar = null;
        while (i60 < i58) {
            a aVar10 = aVar9;
            int i61 = aVar10.f903b[i60];
            if (i61 == 1 || i61 == 2) {
                str = str9;
                dVar = dVar10;
            } else if (i61 != 3) {
                o0 o0Var7 = aVar10.c[i60];
                int[][] iArr24 = iArr18[i60];
                n0 n0Var10 = null;
                h.c cVar = null;
                int i62 = 0;
                int i63 = 0;
                while (i62 < o0Var7.k) {
                    n0 n0Var11 = o0Var7.l[i62];
                    int[] iArr25 = iArr24[i62];
                    int i64 = i63;
                    h.c cVar2 = cVar;
                    n0 n0Var12 = n0Var10;
                    int i65 = 0;
                    while (i65 < n0Var11.k) {
                        o0 o0Var8 = o0Var7;
                        h.d dVar11 = dVar10;
                        if (h.e(iArr25[i65], dVar11.R)) {
                            iArr4 = iArr24;
                            h.c cVar3 = new h.c(n0Var11.l[i65], iArr25[i65]);
                            if (cVar2 == null || cVar3.f(cVar2) > 0) {
                                i64 = i65;
                                n0Var12 = n0Var11;
                                cVar2 = cVar3;
                            }
                        } else {
                            iArr4 = iArr24;
                        }
                        i65++;
                        dVar10 = dVar11;
                        o0Var7 = o0Var8;
                        iArr24 = iArr4;
                    }
                    i62++;
                    n0Var10 = n0Var12;
                    cVar = cVar2;
                    i63 = i64;
                }
                dVar = dVar10;
                aVarArr3[i60] = n0Var10 == null ? null : new j.a(n0Var10, i63);
                str = str9;
            } else {
                dVar = dVar10;
                o0 o0Var9 = aVar10.c[i60];
                int[][] iArr26 = iArr18[i60];
                n0 n0Var13 = null;
                h.g gVar2 = null;
                int i66 = -1;
                int i67 = 0;
                while (i67 < o0Var9.k) {
                    n0 n0Var14 = o0Var9.l[i67];
                    int[] iArr27 = iArr26[i67];
                    int i68 = i66;
                    h.g gVar3 = gVar2;
                    n0 n0Var15 = n0Var13;
                    int i69 = 0;
                    while (i69 < n0Var14.k) {
                        o0 o0Var10 = o0Var9;
                        if (h.e(iArr27[i69], dVar.R)) {
                            iArr3 = iArr26;
                            n0Var = n0Var14;
                            str2 = str9;
                            h.g gVar4 = new h.g(n0Var14.l[i69], dVar, iArr27[i69], str2);
                            if (gVar4.j && (gVar3 == null || gVar4.f(gVar3) > 0)) {
                                i68 = i69;
                                gVar3 = gVar4;
                                n0Var15 = n0Var;
                            }
                        } else {
                            iArr3 = iArr26;
                            n0Var = n0Var14;
                            str2 = str9;
                        }
                        i69++;
                        str9 = str2;
                        o0Var9 = o0Var10;
                        iArr26 = iArr3;
                        n0Var14 = n0Var;
                    }
                    i67++;
                    n0Var13 = n0Var15;
                    gVar2 = gVar3;
                    i66 = i68;
                }
                str = str9;
                if (n0Var13 == null) {
                    pairCreate = null;
                } else {
                    j.a aVar11 = new j.a(n0Var13, i66);
                    Objects.requireNonNull(gVar2);
                    pairCreate = Pair.create(aVar11, gVar2);
                }
                if (pairCreate != null && (gVar == null || ((h.g) pairCreate.second).f(gVar) > 0)) {
                    if (i59 != -1) {
                        aVarArr3[i59] = null;
                    }
                    aVarArr3[i60] = (j.a) pairCreate.first;
                    gVar = (h.g) pairCreate.second;
                    i59 = i60;
                }
            }
            i60++;
            aVar9 = aVar10;
            str9 = str;
            dVar10 = dVar;
        }
        a aVar12 = aVar9;
        h.d dVar12 = dVar10;
        for (int i70 = 0; i70 < i58; i70++) {
            j.a aVar13 = aVarArr3[i70];
            int i71 = aVar12.f903b[i70];
            if (dVar12.V.get(i70) || dVar12.H.contains(Integer.valueOf(i71))) {
                aVar13 = null;
            } else {
                o0 o0Var11 = aVar12.c[i70];
                Map<o0, h.f> map = dVar12.U.get(i70);
                if (map != null && map.containsKey(o0Var11)) {
                    Map<o0, h.f> map2 = dVar12.U.get(i70);
                    h.f fVar2 = map2 != null ? map2.get(o0Var11) : null;
                    if (fVar2 != null) {
                        aVar13 = new j.a(o0Var11.l[fVar2.j], fVar2.k, fVar2.l);
                    }
                } else {
                    int i72 = 0;
                    while (true) {
                        if (i72 >= o0Var11.k) {
                            break;
                        }
                        n0 n0Var16 = o0Var11.l[i72];
                        o.a aVar14 = dVar12.G.l.get(n0Var16);
                        if (aVar14 != null) {
                            aVar13 = new j.a(n0Var16, b.i.a.f.e.o.f.q1(aVar14.l));
                            break;
                        }
                        i72++;
                    }
                }
            }
            aVarArr3[i70] = aVar13;
        }
        j.b bVar5 = hVar3.e;
        b.i.a.c.e3.f fVar3 = hVar3.a;
        Objects.requireNonNull(fVar3);
        Objects.requireNonNull((f.b) bVar5);
        ArrayList arrayList6 = new ArrayList();
        for (int i73 = 0; i73 < i58; i73++) {
            if (aVarArr3[i73] == null || aVarArr3[i73].f902b.length <= 1) {
                arrayList6.add(null);
            } else {
                b.i.b.b.a<Object> aVar15 = b.i.b.b.p.k;
                p.a aVar16 = new p.a();
                aVar16.b(new f.a(0L, 0L));
                arrayList6.add(aVar16);
            }
        }
        long[][] jArr = new long[i58][];
        for (int i74 = 0; i74 < i58; i74++) {
            j.a aVar17 = aVarArr3[i74];
            if (aVar17 == null) {
                jArr[i74] = new long[0];
            } else {
                jArr[i74] = new long[aVar17.f902b.length];
                int i75 = 0;
                while (true) {
                    if (i75 >= aVar17.f902b.length) {
                        break;
                    }
                    jArr[i74][i75] = aVar17.a.l[r11[i75]].f1017s;
                    i75++;
                }
                Arrays.sort(jArr[i74]);
            }
        }
        int[] iArr28 = new int[i58];
        long[] jArr2 = new long[i58];
        for (int i76 = 0; i76 < i58; i76++) {
            jArr2[i76] = jArr[i76].length == 0 ? 0L : jArr[i76][0];
        }
        f.m(arrayList6, jArr2);
        f0 f0Var = f0.j;
        b.i.a.f.e.o.f.A(2, "expectedValuesPerKey");
        d0 d0Var = new d0(new TreeMap(f0Var), new c0(2));
        int i77 = 0;
        while (i77 < i58) {
            if (jArr[i77].length <= 1) {
                iArr = iArr28;
            } else {
                int length4 = jArr[i77].length;
                double[] dArr = new double[length4];
                int i78 = 0;
                while (true) {
                    double dLog = 0.0d;
                    if (i78 >= jArr[i77].length) {
                        break;
                    }
                    if (jArr[i77][i78] == -1) {
                        iArr2 = iArr28;
                    } else {
                        iArr2 = iArr28;
                        dLog = Math.log(jArr[i77][i78]);
                    }
                    dArr[i78] = dLog;
                    i78++;
                    iArr28 = iArr2;
                }
                iArr = iArr28;
                int i79 = length4 - 1;
                double d = dArr[i79] - dArr[0];
                int i80 = 0;
                while (i80 < i79) {
                    double d2 = dArr[i80];
                    i80++;
                    Double dValueOf = Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i80]) * 0.5d) - dArr[0]) / d);
                    int i81 = i79;
                    Integer numValueOf = Integer.valueOf(i77);
                    double d3 = d;
                    Collection collection = (Collection) d0Var.m.get(dValueOf);
                    if (collection == null) {
                        Collection collectionE = d0Var.e();
                        if (!collectionE.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        d0Var.n++;
                        d0Var.m.put(dValueOf, collectionE);
                    } else if (collection.add(numValueOf)) {
                        d0Var.n++;
                    }
                    i79 = i81;
                    d = d3;
                }
            }
            i77++;
            iArr28 = iArr;
        }
        int[] iArr29 = iArr28;
        Collection aVar18 = d0Var.k;
        if (aVar18 == null) {
            aVar18 = new g.a();
            d0Var.k = aVar18;
        }
        b.i.b.b.p pVarN = b.i.b.b.p.n(aVar18);
        for (int i82 = 0; i82 < pVarN.size(); i82++) {
            int iIntValue3 = ((Integer) pVarN.get(i82)).intValue();
            int i83 = iArr29[iIntValue3] + 1;
            iArr29[iIntValue3] = i83;
            jArr2[iIntValue3] = jArr[iIntValue3][i83];
            f.m(arrayList6, jArr2);
        }
        for (int i84 = 0; i84 < i58; i84++) {
            if (arrayList6.get(i84) != null) {
                jArr2[i84] = jArr2[i84] * 2;
            }
        }
        f.m(arrayList6, jArr2);
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i85 = 0;
        int i86 = 0;
        while (i85 < arrayList6.size()) {
            p.a aVar19 = (p.a) arrayList6.get(i85);
            b.i.b.b.p<Object> pVarC = aVar19 == null ? h0.l : aVar19.c();
            Objects.requireNonNull(pVarC);
            int i87 = i86 + 1;
            if (objArrCopyOf.length < i87) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, n.b.a(objArrCopyOf.length, i87));
            }
            objArrCopyOf[i86] = pVarC;
            i85++;
            i86 = i87;
        }
        b.i.b.b.p pVarL = b.i.b.b.p.l(objArrCopyOf, i86);
        j[] jVarArr = new j[i58];
        for (int i88 = 0; i88 < i58; i88++) {
            j.a aVar20 = aVarArr3[i88];
            if (aVar20 != null) {
                int[] iArr30 = aVar20.f902b;
                if (iArr30.length != 0) {
                    if (iArr30.length == 1) {
                        fVar = new k(aVar20.a, iArr30[0], aVar20.c);
                    } else {
                        long j = 25000;
                        fVar = new f(aVar20.a, iArr30, aVar20.c, fVar3, 10000, j, j, 1279, 719, 0.7f, 0.75f, (b.i.b.b.p) pVarL.get(i88), b.i.a.c.f3.g.a);
                    }
                    jVarArr[i88] = fVar;
                }
            }
        }
        h2[] h2VarArr = new h2[i58];
        for (int i89 = 0; i89 < i58; i89++) {
            h2VarArr[i89] = !(dVar12.V.get(i89) || dVar12.H.contains(Integer.valueOf(aVar12.f903b[i89]))) && (aVar12.f903b[i89] == -2 || jVarArr[i89] != null) ? h2.a : null;
        }
        if (dVar12.S) {
            int i90 = -1;
            int i91 = -1;
            for (int i92 = 0; i92 < aVar12.a; i92++) {
                int i93 = aVar12.f903b[i92];
                j jVar = jVarArr[i92];
                if (i93 == 1 || i93 == 2) {
                    if (jVar != null) {
                        int[][] iArr31 = iArr18[i92];
                        int iA = aVar12.c[i92].a(jVar.a());
                        int i94 = 0;
                        while (true) {
                            if (i94 >= jVar.length()) {
                                z3 = true;
                                break;
                            }
                            if ((iArr31[iA][jVar.f(i94)] & 32) != 32) {
                                z3 = false;
                                break;
                            }
                            i94++;
                        }
                        if (z3) {
                            if (i93 == 1) {
                                i = -1;
                                if (i90 != -1) {
                                    z2 = false;
                                    break;
                                }
                                i90 = i92;
                            } else {
                                i = -1;
                                if (i91 != -1) {
                                    z2 = false;
                                    break;
                                }
                                i91 = i92;
                            }
                        }
                    }
                }
            }
            i = -1;
            z2 = true;
            if (z2 & ((i90 == i || i91 == i) ? false : true)) {
                h2 h2Var = new h2(true);
                h2VarArr[i90] = h2Var;
                h2VarArr[i91] = h2Var;
            }
        }
        Pair pairCreate3 = Pair.create(h2VarArr, jVarArr);
        m[] mVarArr = (m[]) pairCreate3.second;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf2 = new Object[4];
        int i95 = 0;
        int i96 = 0;
        while (i95 < aVar12.a) {
            o0 o0Var12 = aVar12.c[i95];
            m mVar = mVarArr[i95];
            Object[] objArrCopyOf3 = objArrCopyOf2;
            int i97 = i96;
            int i98 = 0;
            while (i98 < o0Var12.k) {
                n0 n0Var17 = o0Var12.l[i98];
                int i99 = n0Var17.k;
                int[] iArr32 = new int[i99];
                boolean[] zArr = new boolean[i99];
                for (int i100 = 0; i100 < n0Var17.k; i100++) {
                    iArr32[i100] = aVar12.a(i95, i98, i100);
                    if (mVar != null && mVar.a() == n0Var17) {
                        boolean z18 = mVar.l(i100) != -1;
                        zArr[i100] = z18;
                    }
                    zArr[i100] = z18;
                }
                p2.a aVar21 = new p2.a(n0Var17, iArr32, aVar12.f903b[i95], zArr);
                int i101 = i97 + 1;
                if (objArrCopyOf3.length < i101) {
                    objArrCopyOf3 = Arrays.copyOf(objArrCopyOf3, n.b.a(objArrCopyOf3.length, i101));
                }
                objArrCopyOf3[i97] = aVar21;
                i98++;
                i97 = i101;
            }
            i95++;
            i96 = i97;
            objArrCopyOf2 = objArrCopyOf3;
        }
        o0 o0Var13 = aVar12.f;
        int i102 = 0;
        while (i102 < o0Var13.k) {
            n0 n0Var18 = o0Var13.l[i102];
            int[] iArr33 = new int[n0Var18.k];
            Arrays.fill(iArr33, 0);
            p2.a aVar22 = new p2.a(n0Var18, iArr33, t.g(n0Var18.l[0].w), new boolean[n0Var18.k]);
            int i103 = i96 + 1;
            if (objArrCopyOf2.length < i103) {
                objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, n.b.a(objArrCopyOf2.length, i103));
            }
            objArrCopyOf2[i96] = aVar22;
            i102++;
            i96 = i103;
        }
        return new r((h2[]) pairCreate3.first, (j[]) pairCreate3.second, new p2(b.i.b.b.p.l(objArrCopyOf2, i96)), aVar12);
    }
}
