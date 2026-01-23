package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.t.g, reason: use source file name */
/* JADX INFO: compiled from: TtmlSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlSubtitle implements Subtitle {

    /* JADX INFO: renamed from: j */
    public final TtmlNode f6092j;

    /* JADX INFO: renamed from: k */
    public final long[] f6093k;

    /* JADX INFO: renamed from: l */
    public final Map<String, TtmlStyle> f6094l;

    /* JADX INFO: renamed from: m */
    public final Map<String, TtmlRegion> f6095m;

    /* JADX INFO: renamed from: n */
    public final Map<String, String> f6096n;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        this.f6092j = ttmlNode;
        this.f6095m = map2;
        this.f6096n = map3;
        this.f6094l = Collections.unmodifiableMap(map);
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        ttmlNode.m2696e(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        this.f6093k = jArr;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int iM2994b = Util2.m2994b(this.f6093k, j, false, false);
        if (iM2994b < this.f6093k.length) {
            return iM2994b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        return this.f6093k[i];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: h */
    public List<Cue> mo2614h(long j) {
        TtmlNode ttmlNode = this.f6092j;
        Map<String, TtmlStyle> map = this.f6094l;
        Map<String, TtmlRegion> map2 = this.f6095m;
        Map<String, String> map3 = this.f6096n;
        Objects.requireNonNull(ttmlNode);
        ArrayList<Pair> arrayList = new ArrayList();
        ttmlNode.m2698h(j, ttmlNode.f6057h, arrayList);
        TreeMap treeMap = new TreeMap();
        ttmlNode.m2700j(j, false, ttmlNode.f6057h, treeMap);
        ttmlNode.m2699i(j, map, map2, ttmlNode.f6057h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = map2.get(pair.first);
                Objects.requireNonNull(ttmlRegion);
                arrayList2.add(new Cue(null, null, null, bitmapDecodeByteArray, ttmlRegion.f6065c, 0, ttmlRegion.f6067e, ttmlRegion.f6064b, 0, Integer.MIN_VALUE, -3.4028235E38f, ttmlRegion.f6068f, ttmlRegion.f6069g, false, ViewCompat.MEASURED_STATE_MASK, ttmlRegion.f6072j, 0.0f, null));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = map2.get(entry.getKey());
            Objects.requireNonNull(ttmlRegion2);
            Cue.b bVar = (Cue.b) entry.getValue();
            CharSequence charSequence = bVar.f5773a;
            Objects.requireNonNull(charSequence);
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), (CharSequence) "");
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
            float f = ttmlRegion2.f6065c;
            int i9 = ttmlRegion2.f6066d;
            bVar.f5777e = f;
            bVar.f5778f = i9;
            bVar.f5779g = ttmlRegion2.f6067e;
            bVar.f5780h = ttmlRegion2.f6064b;
            bVar.f5784l = ttmlRegion2.f6068f;
            float f2 = ttmlRegion2.f6071i;
            int i10 = ttmlRegion2.f6070h;
            bVar.f5783k = f2;
            bVar.f5782j = i10;
            bVar.f5788p = ttmlRegion2.f6072j;
            arrayList2.add(bVar.m2606a());
        }
        return arrayList2;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6093k.length;
    }
}
