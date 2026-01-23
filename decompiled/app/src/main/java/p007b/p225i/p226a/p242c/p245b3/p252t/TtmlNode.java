package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.p249q.HorizontalTextInVerticalContextSpan;
import p007b.p225i.p226a.p242c.p245b3.p249q.RubySpan;
import p007b.p225i.p226a.p242c.p245b3.p249q.TextEmphasisSpan;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.t.d, reason: use source file name */
/* JADX INFO: compiled from: TtmlNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlNode {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f6050a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f6051b;

    /* JADX INFO: renamed from: c */
    public final boolean f6052c;

    /* JADX INFO: renamed from: d */
    public final long f6053d;

    /* JADX INFO: renamed from: e */
    public final long f6054e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final TtmlStyle f6055f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String[] f6056g;

    /* JADX INFO: renamed from: h */
    public final String f6057h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final String f6058i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public final TtmlNode f6059j;

    /* JADX INFO: renamed from: k */
    public final HashMap<String, Integer> f6060k;

    /* JADX INFO: renamed from: l */
    public final HashMap<String, Integer> f6061l;

    /* JADX INFO: renamed from: m */
    public List<TtmlNode> f6062m;

    public TtmlNode(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable TtmlNode ttmlNode) {
        this.f6050a = str;
        this.f6051b = str2;
        this.f6058i = str4;
        this.f6055f = ttmlStyle;
        this.f6056g = strArr;
        this.f6052c = str2 != null;
        this.f6053d = j;
        this.f6054e = j2;
        Objects.requireNonNull(str3);
        this.f6057h = str3;
        this.f6059j = ttmlNode;
        this.f6060k = new HashMap<>();
        this.f6061l = new HashMap<>();
    }

    /* JADX INFO: renamed from: b */
    public static TtmlNode m2691b(String str) {
        return new TtmlNode(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    /* JADX INFO: renamed from: f */
    public static SpannableStringBuilder m2692f(String str, Map<String, Cue.b> map) {
        if (!map.containsKey(str)) {
            Cue.b bVar = new Cue.b();
            bVar.f5773a = new SpannableStringBuilder();
            map.put(str, bVar);
        }
        CharSequence charSequence = map.get(str).f5773a;
        Objects.requireNonNull(charSequence);
        return (SpannableStringBuilder) charSequence;
    }

    /* JADX INFO: renamed from: a */
    public void m2693a(TtmlNode ttmlNode) {
        if (this.f6062m == null) {
            this.f6062m = new ArrayList();
        }
        this.f6062m.add(ttmlNode);
    }

    /* JADX INFO: renamed from: c */
    public TtmlNode m2694c(int i) {
        List<TtmlNode> list = this.f6062m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX INFO: renamed from: d */
    public int m2695d() {
        List<TtmlNode> list = this.f6062m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: renamed from: e */
    public final void m2696e(TreeSet<Long> treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.f6050a);
        boolean zEquals2 = "div".equals(this.f6050a);
        if (z2 || zEquals || (zEquals2 && this.f6058i != null)) {
            long j = this.f6053d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.f6054e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.f6062m == null) {
            return;
        }
        for (int i = 0; i < this.f6062m.size(); i++) {
            this.f6062m.get(i).m2696e(treeSet, z2 || zEquals);
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m2697g(long j) {
        long j2 = this.f6053d;
        return (j2 == -9223372036854775807L && this.f6054e == -9223372036854775807L) || (j2 <= j && this.f6054e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.f6054e) || (j2 <= j && j < this.f6054e));
    }

    /* JADX INFO: renamed from: h */
    public final void m2698h(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f6057h)) {
            str = this.f6057h;
        }
        if (m2697g(j) && "div".equals(this.f6050a) && this.f6058i != null) {
            list.add(new Pair<>(str, this.f6058i));
            return;
        }
        for (int i = 0; i < m2695d(); i++) {
            m2694c(i).m2698h(j, str, list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025a A[SYNTHETIC] */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2699i(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.b> map3) {
        Iterator<Map.Entry<String, Integer>> it;
        TtmlNode ttmlNode;
        boolean z2;
        TtmlStyle ttmlStyleM476T1;
        int i;
        int i2;
        if (m2697g(j)) {
            String str2 = "".equals(this.f6057h) ? str : this.f6057h;
            Iterator<Map.Entry<String, Integer>> it2 = this.f6061l.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Integer> next = it2.next();
                String key = next.getKey();
                int iIntValue = this.f6060k.containsKey(key) ? this.f6060k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    Cue.b bVar = map3.get(key);
                    Objects.requireNonNull(bVar);
                    TtmlRegion ttmlRegion = map2.get(str2);
                    Objects.requireNonNull(ttmlRegion);
                    int i3 = ttmlRegion.f6072j;
                    TtmlStyle ttmlStyleM476T12 = AnimatableValueParser.m476T1(this.f6055f, this.f6056g, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.f5773a;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        bVar.f5773a = spannableStringBuilder;
                    }
                    if (ttmlStyleM476T12 != null) {
                        TtmlNode ttmlNode2 = this.f6059j;
                        if (ttmlStyleM476T12.m2702b() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyleM476T12.m2702b()), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleM476T12.f6078f == 1) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleM476T12.f6079g == 1) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleM476T12.f6075c) {
                            if (!ttmlStyleM476T12.f6075c) {
                                throw new IllegalStateException("Font color has not been defined.");
                            }
                            AnimatableValueParser.m503c(spannableStringBuilder, new ForegroundColorSpan(ttmlStyleM476T12.f6074b), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleM476T12.f6077e) {
                            if (!ttmlStyleM476T12.f6077e) {
                                throw new IllegalStateException("Background color has not been defined.");
                            }
                            AnimatableValueParser.m503c(spannableStringBuilder, new BackgroundColorSpan(ttmlStyleM476T12.f6076d), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleM476T12.f6073a != null) {
                            AnimatableValueParser.m503c(spannableStringBuilder, new TypefaceSpan(ttmlStyleM476T12.f6073a), iIntValue, iIntValue2, 33);
                        }
                        TextEmphasis textEmphasis = ttmlStyleM476T12.f6090r;
                        if (textEmphasis != null) {
                            int i4 = textEmphasis.f6031f;
                            it = it2;
                            if (i4 == -1) {
                                i4 = (i3 == 2 || i3 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = textEmphasis.f6032g;
                            }
                            int i5 = textEmphasis.f6033h;
                            if (i5 == -2) {
                                i5 = 1;
                            }
                            AnimatableValueParser.m503c(spannableStringBuilder, new TextEmphasisSpan(i4, i2, i5), iIntValue, iIntValue2, 33);
                        } else {
                            it = it2;
                        }
                        int i6 = ttmlStyleM476T12.f6085m;
                        if (i6 == 2) {
                            while (true) {
                                if (ttmlNode2 == null) {
                                    ttmlNode2 = null;
                                    break;
                                }
                                TtmlStyle ttmlStyleM476T13 = AnimatableValueParser.m476T1(ttmlNode2.f6055f, ttmlNode2.f6056g, map);
                                if (ttmlStyleM476T13 != null && ttmlStyleM476T13.f6085m == 1) {
                                    break;
                                } else {
                                    ttmlNode2 = ttmlNode2.f6059j;
                                }
                            }
                            if (ttmlNode2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(ttmlNode2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        ttmlNode = null;
                                        break;
                                    }
                                    TtmlNode ttmlNode3 = (TtmlNode) arrayDeque.pop();
                                    TtmlStyle ttmlStyleM476T14 = AnimatableValueParser.m476T1(ttmlNode3.f6055f, ttmlNode3.f6056g, map);
                                    if (ttmlStyleM476T14 != null && ttmlStyleM476T14.f6085m == 3) {
                                        ttmlNode = ttmlNode3;
                                        break;
                                    }
                                    for (int iM2695d = ttmlNode3.m2695d() - 1; iM2695d >= 0; iM2695d--) {
                                        arrayDeque.push(ttmlNode3.m2694c(iM2695d));
                                    }
                                }
                                if (ttmlNode != null) {
                                    if (ttmlNode.m2695d() == 1) {
                                        z2 = false;
                                        if (ttmlNode.m2694c(0).f6051b != null) {
                                            String str3 = ttmlNode.m2694c(0).f6051b;
                                            int i7 = Util2.f6708a;
                                            TtmlStyle ttmlStyleM476T15 = AnimatableValueParser.m476T1(ttmlNode.f6055f, ttmlNode.f6056g, map);
                                            int i8 = ttmlStyleM476T15 != null ? ttmlStyleM476T15.f6086n : -1;
                                            if (i8 == -1 && (ttmlStyleM476T1 = AnimatableValueParser.m476T1(ttmlNode2.f6055f, ttmlNode2.f6056g, map)) != null) {
                                                i8 = ttmlStyleM476T1.f6086n;
                                            }
                                            spannableStringBuilder.setSpan(new RubySpan(str3, i8), iIntValue, iIntValue2, 33);
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                                if (ttmlStyleM476T12.f6089q == 1) {
                                    z2 = true;
                                }
                                if (z2) {
                                    AnimatableValueParser.m503c(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), iIntValue, iIntValue2, 33);
                                }
                                i = ttmlStyleM476T12.f6082j;
                                if (i != 1) {
                                    AnimatableValueParser.m503c(spannableStringBuilder, new AbsoluteSizeSpan((int) ttmlStyleM476T12.f6083k, true), iIntValue, iIntValue2, 33);
                                } else if (i == 2) {
                                    AnimatableValueParser.m503c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleM476T12.f6083k), iIntValue, iIntValue2, 33);
                                } else if (i == 3) {
                                    AnimatableValueParser.m503c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleM476T12.f6083k / 100.0f), iIntValue, iIntValue2, 33);
                                }
                                if (!"p".equals(this.f6050a)) {
                                    float f = ttmlStyleM476T12.f6091s;
                                    if (f != Float.MAX_VALUE) {
                                        bVar.f5789q = (f * (-90.0f)) / 100.0f;
                                    }
                                    Layout.Alignment alignment = ttmlStyleM476T12.f6087o;
                                    if (alignment != null) {
                                        bVar.f5775c = alignment;
                                    }
                                    Layout.Alignment alignment2 = ttmlStyleM476T12.f6088p;
                                    if (alignment2 != null) {
                                        bVar.f5776d = alignment2;
                                    }
                                }
                            }
                        } else if (i6 == 3 || i6 == 4) {
                            spannableStringBuilder.setSpan(new DeleteTextSpan(), iIntValue, iIntValue2, 33);
                        }
                        z2 = false;
                        if (ttmlStyleM476T12.f6089q == 1) {
                        }
                        if (z2) {
                        }
                        i = ttmlStyleM476T12.f6082j;
                        if (i != 1) {
                        }
                        if (!"p".equals(this.f6050a)) {
                        }
                    }
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            for (int i9 = 0; i9 < m2695d(); i9++) {
                m2694c(i9).m2699i(j, map, map2, str2, map3);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m2700j(long j, boolean z2, String str, Map<String, Cue.b> map) {
        this.f6060k.clear();
        this.f6061l.clear();
        if ("metadata".equals(this.f6050a)) {
            return;
        }
        if (!"".equals(this.f6057h)) {
            str = this.f6057h;
        }
        if (this.f6052c && z2) {
            SpannableStringBuilder spannableStringBuilderM2692f = m2692f(str, map);
            String str2 = this.f6051b;
            Objects.requireNonNull(str2);
            spannableStringBuilderM2692f.append((CharSequence) str2);
            return;
        }
        if ("br".equals(this.f6050a) && z2) {
            m2692f(str, map).append('\n');
            return;
        }
        if (m2697g(j)) {
            for (Map.Entry<String, Cue.b> entry : map.entrySet()) {
                HashMap<String, Integer> map2 = this.f6060k;
                String key = entry.getKey();
                CharSequence charSequence = entry.getValue().f5773a;
                Objects.requireNonNull(charSequence);
                map2.put(key, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(this.f6050a);
            for (int i = 0; i < m2695d(); i++) {
                m2694c(i).m2700j(j, z2 || zEquals, str, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderM2692f2 = m2692f(str, map);
                int length = spannableStringBuilderM2692f2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderM2692f2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderM2692f2.charAt(length) != '\n') {
                    spannableStringBuilderM2692f2.append('\n');
                }
            }
            for (Map.Entry<String, Cue.b> entry2 : map.entrySet()) {
                HashMap<String, Integer> map3 = this.f6061l;
                String key2 = entry2.getKey();
                CharSequence charSequence2 = entry2.getValue().f5773a;
                Objects.requireNonNull(charSequence2);
                map3.put(key2, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
