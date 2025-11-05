package b.i.a.c.b3.t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.b;
import b.i.a.c.f3.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: TtmlSubtitle.java */
/* loaded from: classes3.dex */
public final class g implements b.i.a.c.b3.g {
    public final d j;
    public final long[] k;
    public final Map<String, f> l;
    public final Map<String, e> m;
    public final Map<String, String> n;

    public g(d dVar, Map<String, f> map, Map<String, e> map2, Map<String, String> map3) {
        this.j = dVar;
        this.m = map2;
        this.n = map3;
        this.l = Collections.unmodifiableMap(map);
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        dVar.e(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        this.k = jArr;
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        int iB = e0.b(this.k, j, false, false);
        if (iB < this.k.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        return this.k[i];
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j) {
        d dVar = this.j;
        Map<String, f> map = this.l;
        Map<String, e> map2 = this.m;
        Map<String, String> map3 = this.n;
        Objects.requireNonNull(dVar);
        ArrayList arrayList = new ArrayList();
        dVar.h(j, dVar.h, arrayList);
        TreeMap treeMap = new TreeMap();
        dVar.j(j, false, dVar.h, treeMap);
        dVar.i(j, map, map2, dVar.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = map2.get(pair.first);
                Objects.requireNonNull(eVar);
                arrayList2.add(new b.i.a.c.b3.b(null, null, null, bitmapDecodeByteArray, eVar.c, 0, eVar.e, eVar.f884b, 0, Integer.MIN_VALUE, -3.4028235E38f, eVar.f, eVar.g, false, ViewCompat.MEASURED_STATE_MASK, eVar.j, 0.0f, null));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = map2.get(entry.getKey());
            Objects.requireNonNull(eVar2);
            b.C0093b c0093b = (b.C0093b) entry.getValue();
            CharSequence charSequence = c0093b.a;
            Objects.requireNonNull(charSequence);
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), (CharSequence) "");
            }
            for (int i = 0; i < spannableStringBuilder.length(); i++) {
                if (spannableStringBuilder.charAt(i) == ' ') {
                    int i2 = i + 1;
                    int i3 = i2;
                    while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                        i3++;
                    }
                    int i4 = i3 - i2;
                    if (i4 > 0) {
                        spannableStringBuilder.delete(i, i4 + i);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
                if (spannableStringBuilder.charAt(i5) == '\n') {
                    int i6 = i5 + 1;
                    if (spannableStringBuilder.charAt(i6) == ' ') {
                        spannableStringBuilder.delete(i6, i5 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    int i8 = i7 + 1;
                    if (spannableStringBuilder.charAt(i8) == '\n') {
                        spannableStringBuilder.delete(i7, i8);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f = eVar2.c;
            int i9 = eVar2.d;
            c0093b.e = f;
            c0093b.f = i9;
            c0093b.g = eVar2.e;
            c0093b.h = eVar2.f884b;
            c0093b.l = eVar2.f;
            float f2 = eVar2.i;
            int i10 = eVar2.h;
            c0093b.k = f2;
            c0093b.j = i10;
            c0093b.p = eVar2.j;
            arrayList2.add(c0093b.a());
        }
        return arrayList2;
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return this.k.length;
    }
}
