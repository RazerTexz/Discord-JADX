package p007b.p225i.p226a.p242c.p256d3;

import android.content.Context;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.SparseArray;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p505ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.p249q.HorizontalTextInVerticalContextSpan;
import p007b.p225i.p226a.p242c.p245b3.p249q.RubySpan;
import p007b.p225i.p226a.p242c.p245b3.p249q.TextEmphasisSpan;
import p007b.p225i.p226a.p242c.p256d3.SpannedToHtmlConverter;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p355b.p356a.Charsets;
import p007b.p225i.p355b.p357b.RegularImmutableMap;

/* compiled from: WebViewSubtitleOutput.java */
/* renamed from: b.i.a.c.d3.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebViewSubtitleOutput2 extends FrameLayout implements SubtitleView.InterfaceC10760a {

    /* renamed from: j */
    public final CanvasSubtitleOutput f6402j;

    /* renamed from: k */
    public final WebView f6403k;

    /* renamed from: l */
    public List<Cue> f6404l;

    /* renamed from: m */
    public CaptionStyleCompat f6405m;

    /* renamed from: n */
    public float f6406n;

    /* renamed from: o */
    public int f6407o;

    /* renamed from: p */
    public float f6408p;

    /* compiled from: WebViewSubtitleOutput.java */
    /* renamed from: b.i.a.c.d3.r$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6409a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f6409a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6409a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6409a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput2(Context context) {
        super(context, null);
        this.f6404l = Collections.emptyList();
        this.f6405m = CaptionStyleCompat.f6349a;
        this.f6406n = 0.0533f;
        this.f6407o = 0;
        this.f6408p = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.f6402j = canvasSubtitleOutput;
        WebViewSubtitleOutput webViewSubtitleOutput = new WebViewSubtitleOutput(context, null);
        this.f6403k = webViewSubtitleOutput;
        webViewSubtitleOutput.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webViewSubtitleOutput);
    }

    /* renamed from: b */
    public static int m2766b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    /* renamed from: c */
    public static String m2767c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = a.f6409a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    @Override // com.google.android.exoplayer2.p505ui.SubtitleView.InterfaceC10760a
    /* renamed from: a */
    public void mo2758a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.f6405m = captionStyleCompat;
        this.f6406n = f;
        this.f6407o = i;
        this.f6408p = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.f5761o != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.f6404l.isEmpty() || !arrayList2.isEmpty()) {
            this.f6404l = arrayList2;
            m2769e();
        }
        this.f6402j.mo2758a(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    /* renamed from: d */
    public final String m2768d(int i, float f) {
        float fM479U1 = AnimatableValueParser.m479U1(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fM479U1 == -3.4028235E38f ? "unset" : Util2.m3003k("%.2fpx", Float.valueOf(fM479U1 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x0462, code lost:
    
        if (((android.text.style.TypefaceSpan) r9).getFamily() != null) goto L206;
     */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b5  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2769e() {
        char c;
        String strM3003k;
        int iM2766b;
        int i;
        String strM3003k2;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SpannedToHtmlConverter.b bVar;
        String str11;
        String str12;
        float f;
        String str13;
        String str14;
        int i3;
        String strM3003k3;
        String str15;
        String strM859k;
        float f2;
        int i4;
        String strM3003k4;
        Layout.Alignment alignment;
        String str16;
        WebViewSubtitleOutput2 webViewSubtitleOutput2 = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c2 = 0;
        objArr[0] = AnimatableValueParser.m518f2(webViewSubtitleOutput2.f6405m.f6350b);
        int i5 = 1;
        objArr[1] = webViewSubtitleOutput2.m2768d(webViewSubtitleOutput2.f6407o, webViewSubtitleOutput2.f6406n);
        float f3 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        CaptionStyleCompat captionStyleCompat = webViewSubtitleOutput2.f6405m;
        int i6 = captionStyleCompat.f6353e;
        objArr[3] = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "unset" : Util2.m3003k("-0.05em -0.05em 0.15em %s", AnimatableValueParser.m518f2(captionStyleCompat.f6354f)) : Util2.m3003k("0.06em 0.08em 0.15em %s", AnimatableValueParser.m518f2(captionStyleCompat.f6354f)) : Util2.m3003k("0.1em 0.12em 0.15em %s", AnimatableValueParser.m518f2(captionStyleCompat.f6354f)) : Util2.m3003k("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", AnimatableValueParser.m518f2(captionStyleCompat.f6354f));
        sb.append(Util2.m3003k("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr));
        HashMap map = new HashMap();
        String str17 = "default_bg";
        String str18 = "background-color:%s;";
        map.put(AnimatableValueParser.m483W("default_bg"), Util2.m3003k("background-color:%s;", AnimatableValueParser.m518f2(webViewSubtitleOutput2.f6405m.f6351c)));
        int i7 = 0;
        while (i7 < webViewSubtitleOutput2.f6404l.size()) {
            Cue cue = webViewSubtitleOutput2.f6404l.get(i7);
            float f4 = cue.f5765s;
            float f5 = f4 != -3.4028235E38f ? f4 * 100.0f : 50.0f;
            int iM2766b2 = m2766b(cue.f5766t);
            float f6 = cue.f5762p;
            if (f6 == -3.4028235E38f) {
                c = 0;
                Object[] objArr2 = new Object[i5];
                objArr2[0] = Float.valueOf((1.0f - webViewSubtitleOutput2.f6408p) * 100.0f);
                strM3003k = Util2.m3003k("%.2f%%", objArr2);
                c2 = 0;
                iM2766b = -100;
            } else if (cue.f5763q != i5) {
                Object[] objArr3 = new Object[i5];
                objArr3[c2] = Float.valueOf(f6 * 100.0f);
                strM3003k = Util2.m3003k("%.2f%%", objArr3);
                c = 0;
                iM2766b = cue.f5756A == i5 ? -m2766b(cue.f5764r) : m2766b(cue.f5764r);
            } else {
                if (f6 >= 0.0f) {
                    Object[] objArr4 = new Object[i5];
                    Float fValueOf = Float.valueOf(f6 * f3);
                    c = 0;
                    objArr4[0] = fValueOf;
                    strM3003k = Util2.m3003k("%.2fem", objArr4);
                    c2 = 0;
                } else {
                    Object[] objArr5 = new Object[i5];
                    Float fValueOf2 = Float.valueOf(((-f6) - 1.0f) * f3);
                    c = 0;
                    objArr5[0] = fValueOf2;
                    strM3003k = Util2.m3003k("%.2fem", objArr5);
                    c2 = 1;
                }
                iM2766b = 0;
            }
            float f7 = cue.f5767u;
            if (f7 != -3.4028235E38f) {
                i = iM2766b2;
                Object[] objArr6 = new Object[i5];
                objArr6[c] = Float.valueOf(f7 * 100.0f);
                strM3003k2 = Util2.m3003k("%.2f%%", objArr6);
            } else {
                i = iM2766b2;
                strM3003k2 = "fit-content";
            }
            String strM2767c = m2767c(cue.f5759m);
            int i8 = cue.f5756A;
            String str19 = i8 != i5 ? i8 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
            String strM2768d = webViewSubtitleOutput2.m2768d(cue.f5771y, cue.f5772z);
            String strM518f2 = AnimatableValueParser.m518f2(cue.f5769w ? cue.f5770x : webViewSubtitleOutput2.f6405m.f6352d);
            int i9 = cue.f5756A;
            String str20 = "right";
            String str21 = "left";
            String str22 = str17;
            if (i9 == 1) {
                if (c2 != 0) {
                }
                i2 = 2;
                str21 = "top";
                str = str20;
            } else if (i9 != 2) {
                str = c2 != 0 ? "bottom" : "top";
                i2 = 2;
            } else {
                if (c2 == 0) {
                    str20 = "left";
                }
                i2 = 2;
                str21 = "top";
                str = str20;
            }
            if (i9 == i2 || i9 == 1) {
                str2 = "height";
            } else {
                str2 = "width";
                int i10 = i;
                i = iM2766b;
                iM2766b = i10;
            }
            CharSequence charSequence = cue.f5758l;
            float f8 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = SpannedToHtmlConverter.f6357a;
            StringBuilder sb2 = sb;
            if (charSequence == null) {
                bVar = new SpannedToHtmlConverter.b("", RegularImmutableMap.f12015m, null);
                str3 = "";
            } else if (charSequence instanceof Spanned) {
                str3 = "";
                Spanned spanned = (Spanned) charSequence;
                HashSet hashSet = new HashSet();
                str4 = strM518f2;
                str5 = strM2768d;
                BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
                int length = backgroundColorSpanArr.length;
                int i11 = 0;
                while (i11 < length) {
                    hashSet.add(Integer.valueOf(backgroundColorSpanArr[i11].getBackgroundColor()));
                    i11++;
                    backgroundColorSpanArr = backgroundColorSpanArr;
                }
                HashMap map2 = new HashMap();
                for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    StringBuilder sb3 = new StringBuilder(14);
                    sb3.append("bg_");
                    sb3.append(iIntValue);
                    map2.put(AnimatableValueParser.m483W(sb3.toString()), Util2.m3003k(str18, AnimatableValueParser.m518f2(iIntValue)));
                }
                SparseArray sparseArray = new SparseArray();
                str6 = str18;
                Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
                int length2 = spans.length;
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = length2;
                    Object obj = spans[i12];
                    Object[] objArr7 = spans;
                    boolean z2 = obj instanceof StrikethroughSpan;
                    if (z2) {
                        str14 = str2;
                        f = f8;
                        str13 = strM3003k2;
                        str12 = strM2767c;
                        str11 = str19;
                        strM3003k3 = "<span style='text-decoration:line-through;'>";
                    } else {
                        str11 = str19;
                        if (obj instanceof ForegroundColorSpan) {
                            str12 = strM2767c;
                            strM3003k3 = Util2.m3003k("<span style='color:%s;'>", AnimatableValueParser.m518f2(((ForegroundColorSpan) obj).getForegroundColor()));
                        } else {
                            str12 = strM2767c;
                            if (obj instanceof BackgroundColorSpan) {
                                strM3003k3 = Util2.m3003k("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
                            } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
                                strM3003k3 = "<span style='text-combine-upright:all;'>";
                            } else if (obj instanceof AbsoluteSizeSpan) {
                                strM3003k3 = Util2.m3003k("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r6.getSize() : r6.getSize() / f8));
                            } else {
                                if (obj instanceof RelativeSizeSpan) {
                                    strM3003k3 = Util2.m3003k("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
                                } else if (obj instanceof TypefaceSpan) {
                                    String family = ((TypefaceSpan) obj).getFamily();
                                    strM3003k3 = family != null ? Util2.m3003k("<span style='font-family:\"%s\";'>", family) : null;
                                } else if (obj instanceof StyleSpan) {
                                    int style = ((StyleSpan) obj).getStyle();
                                    if (style == 1) {
                                        strM3003k3 = "<b>";
                                    } else if (style != 2) {
                                        if (style == 3) {
                                            strM3003k3 = "<b><i>";
                                        }
                                        str14 = str2;
                                        f = f8;
                                        str13 = strM3003k2;
                                        strM3003k3 = null;
                                    } else {
                                        strM3003k3 = "<i>";
                                    }
                                } else if (obj instanceof RubySpan) {
                                    int i14 = ((RubySpan) obj).f5982b;
                                    if (i14 == -1) {
                                        strM3003k3 = "<ruby style='ruby-position:unset;'>";
                                    } else if (i14 != 1) {
                                        if (i14 == 2) {
                                            strM3003k3 = "<ruby style='ruby-position:under;'>";
                                        }
                                        str14 = str2;
                                        f = f8;
                                        str13 = strM3003k2;
                                        strM3003k3 = null;
                                    } else {
                                        strM3003k3 = "<ruby style='ruby-position:over;'>";
                                    }
                                } else if (obj instanceof UnderlineSpan) {
                                    strM3003k3 = "<u>";
                                } else if (obj instanceof TextEmphasisSpan) {
                                    TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                                    int i15 = textEmphasisSpan.f5983a;
                                    f = f8;
                                    int i16 = textEmphasisSpan.f5984b;
                                    str13 = strM3003k2;
                                    StringBuilder sb4 = new StringBuilder();
                                    str14 = str2;
                                    if (i16 != 1) {
                                        i3 = 2;
                                        if (i16 == 2) {
                                            sb4.append("open ");
                                        }
                                    } else {
                                        i3 = 2;
                                        sb4.append("filled ");
                                    }
                                    if (i15 == 0) {
                                        sb4.append("none");
                                    } else if (i15 == 1) {
                                        sb4.append("circle");
                                    } else if (i15 == i3) {
                                        sb4.append("dot");
                                    } else if (i15 != 3) {
                                        sb4.append("unset");
                                    } else {
                                        sb4.append("sesame");
                                    }
                                    strM3003k3 = Util2.m3003k("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4.toString(), textEmphasisSpan.f5985c != 2 ? "over right" : "under left");
                                } else {
                                    str14 = str2;
                                    f = f8;
                                    str13 = strM3003k2;
                                    strM3003k3 = null;
                                }
                                str14 = str2;
                                f = f8;
                                str13 = strM3003k2;
                            }
                        }
                        str14 = str2;
                        f = f8;
                        str13 = strM3003k2;
                    }
                    String str23 = strM3003k3;
                    if (z2 || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
                        str15 = "</span>";
                    } else {
                        if (!(obj instanceof TypefaceSpan)) {
                            if (obj instanceof StyleSpan) {
                                int style2 = ((StyleSpan) obj).getStyle();
                                if (style2 == 1) {
                                    strM859k = "</b>";
                                } else if (style2 == 2) {
                                    strM859k = "</i>";
                                } else if (style2 == 3) {
                                    strM859k = "</i></b>";
                                }
                                str15 = strM859k;
                            } else {
                                if (obj instanceof RubySpan) {
                                    String strM2759a = SpannedToHtmlConverter.m2759a(((RubySpan) obj).f5981a);
                                    strM859k = outline.m859k(outline.m841b(strM2759a, 16), "<rt>", strM2759a, "</rt></ruby>");
                                } else if (obj instanceof UnderlineSpan) {
                                    strM859k = "</u>";
                                }
                                str15 = strM859k;
                            }
                        }
                        strM859k = null;
                        str15 = strM859k;
                    }
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    if (str23 != null) {
                        Objects.requireNonNull(str15);
                        SpannedToHtmlConverter.c cVar = new SpannedToHtmlConverter.c(spanStart, spanEnd, str23, str15, null);
                        SpannedToHtmlConverter.d dVar = (SpannedToHtmlConverter.d) sparseArray.get(spanStart);
                        if (dVar == null) {
                            dVar = new SpannedToHtmlConverter.d();
                            sparseArray.put(spanStart, dVar);
                        }
                        dVar.f6364a.add(cVar);
                        SpannedToHtmlConverter.d dVar2 = (SpannedToHtmlConverter.d) sparseArray.get(spanEnd);
                        if (dVar2 == null) {
                            dVar2 = new SpannedToHtmlConverter.d();
                            sparseArray.put(spanEnd, dVar2);
                        }
                        dVar2.f6365b.add(cVar);
                    }
                    i12++;
                    length2 = i13;
                    spans = objArr7;
                    str19 = str11;
                    strM2767c = str12;
                    f8 = f;
                    strM3003k2 = str13;
                    str2 = str14;
                }
                str7 = str2;
                str8 = str19;
                str9 = strM3003k2;
                str10 = strM2767c;
                StringBuilder sb5 = new StringBuilder(spanned.length());
                int i17 = 0;
                int i18 = 0;
                while (i17 < sparseArray.size()) {
                    int iKeyAt = sparseArray.keyAt(i17);
                    sb5.append(SpannedToHtmlConverter.m2759a(spanned.subSequence(i18, iKeyAt)));
                    SpannedToHtmlConverter.d dVar3 = (SpannedToHtmlConverter.d) sparseArray.get(iKeyAt);
                    Collections.sort(dVar3.f6365b, C2662f.f6340j);
                    Iterator<SpannedToHtmlConverter.c> it2 = dVar3.f6365b.iterator();
                    while (it2.hasNext()) {
                        sb5.append(it2.next().f6363d);
                    }
                    Collections.sort(dVar3.f6364a, C2661e.f6339j);
                    Iterator<SpannedToHtmlConverter.c> it3 = dVar3.f6364a.iterator();
                    while (it3.hasNext()) {
                        sb5.append(it3.next().f6362c);
                    }
                    i17++;
                    i18 = iKeyAt;
                }
                sb5.append(SpannedToHtmlConverter.m2759a(spanned.subSequence(i18, spanned.length())));
                bVar = new SpannedToHtmlConverter.b(sb5.toString(), map2, null);
                for (String str24 : map.keySet()) {
                    String str25 = (String) map.put(str24, (String) map.get(str24));
                    AnimatableValueParser.m426D(str25 == null || str25.equals(map.get(str24)));
                }
                Object[] objArr8 = new Object[14];
                objArr8[0] = Integer.valueOf(i7);
                objArr8[1] = str21;
                objArr8[2] = Float.valueOf(f5);
                objArr8[3] = str;
                objArr8[4] = strM3003k;
                objArr8[5] = str7;
                objArr8[6] = str9;
                objArr8[7] = str10;
                objArr8[8] = str8;
                objArr8[9] = str5;
                objArr8[10] = str4;
                objArr8[11] = Integer.valueOf(iM2766b);
                objArr8[12] = Integer.valueOf(i);
                f2 = cue.f5757B;
                if (f2 == 0.0f) {
                    int i19 = cue.f5756A;
                    i4 = 1;
                    strM3003k4 = Util2.m3003k("%s(%.2fdeg)", (i19 == 2 || i19 == 1) ? "skewY" : "skewX", Float.valueOf(f2));
                } else {
                    i4 = 1;
                    strM3003k4 = str3;
                }
                objArr8[13] = strM3003k4;
                sb = sb2;
                sb.append(Util2.m3003k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr8));
                Object[] objArr9 = new Object[i4];
                objArr9[0] = str22;
                sb.append(Util2.m3003k("<span class='%s'>", objArr9));
                alignment = cue.f5760n;
                if (alignment == null) {
                    Object[] objArr10 = new Object[i4];
                    objArr10[0] = m2767c(alignment);
                    sb.append(Util2.m3003k("<span style='display:inline-block; text-align:%s;'>", objArr10));
                    sb.append(bVar.f6358a);
                    str16 = "</span>";
                    sb.append(str16);
                } else {
                    str16 = "</span>";
                    sb.append(bVar.f6358a);
                }
                sb.append(str16);
                sb.append("</div>");
                i7++;
                f3 = 1.2f;
                c2 = 0;
                i5 = 1;
                webViewSubtitleOutput2 = this;
                str17 = str22;
                str18 = str6;
            } else {
                str3 = "";
                bVar = new SpannedToHtmlConverter.b(SpannedToHtmlConverter.m2759a(charSequence), RegularImmutableMap.f12015m, null);
            }
            str7 = str2;
            str8 = str19;
            str6 = str18;
            str9 = strM3003k2;
            str10 = strM2767c;
            str5 = strM2768d;
            str4 = strM518f2;
            while (r0.hasNext()) {
            }
            Object[] objArr82 = new Object[14];
            objArr82[0] = Integer.valueOf(i7);
            objArr82[1] = str21;
            objArr82[2] = Float.valueOf(f5);
            objArr82[3] = str;
            objArr82[4] = strM3003k;
            objArr82[5] = str7;
            objArr82[6] = str9;
            objArr82[7] = str10;
            objArr82[8] = str8;
            objArr82[9] = str5;
            objArr82[10] = str4;
            objArr82[11] = Integer.valueOf(iM2766b);
            objArr82[12] = Integer.valueOf(i);
            f2 = cue.f5757B;
            if (f2 == 0.0f) {
            }
            objArr82[13] = strM3003k4;
            sb = sb2;
            sb.append(Util2.m3003k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr82));
            Object[] objArr92 = new Object[i4];
            objArr92[0] = str22;
            sb.append(Util2.m3003k("<span class='%s'>", objArr92));
            alignment = cue.f5760n;
            if (alignment == null) {
            }
            sb.append(str16);
            sb.append("</div>");
            i7++;
            f3 = 1.2f;
            c2 = 0;
            i5 = 1;
            webViewSubtitleOutput2 = this;
            str17 = str22;
            str18 = str6;
        }
        sb.append("</div></body></html>");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("<html><head><style>");
        for (String str26 : map.keySet()) {
            sb6.append(str26);
            sb6.append("{");
            sb6.append((String) map.get(str26));
            sb6.append("}");
        }
        sb6.append("</style></head>");
        sb.insert(0, sb6.toString());
        this.f6403k.loadData(Base64.encodeToString(sb.toString().getBytes(Charsets.f11945c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (!z2 || this.f6404l.isEmpty()) {
            return;
        }
        m2769e();
    }
}
