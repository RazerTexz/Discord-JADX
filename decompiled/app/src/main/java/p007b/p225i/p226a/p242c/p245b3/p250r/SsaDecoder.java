package p007b.p225i.p226a.p242c.p245b3.p250r;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p245b3.p250r.SsaStyle;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.r.a, reason: use source file name */
/* JADX INFO: compiled from: SsaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder2 {

    /* JADX INFO: renamed from: n */
    public static final Pattern f5986n = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o */
    public final boolean f5987o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final SsaDialogueFormat f5988p;

    /* JADX INFO: renamed from: q */
    public Map<String, SsaStyle> f5989q;

    /* JADX INFO: renamed from: r */
    public float f5990r;

    /* JADX INFO: renamed from: s */
    public float f5991s;

    public SsaDecoder(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f5990r = -3.4028235E38f;
        this.f5991s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f5987o = false;
            this.f5988p = null;
            return;
        }
        this.f5987o = true;
        String strM3004l = Util2.m3004l(list.get(0));
        AnimatableValueParser.m531j(strM3004l.startsWith("Format:"));
        SsaDialogueFormat ssaDialogueFormatM2672a = SsaDialogueFormat.m2672a(strM3004l);
        Objects.requireNonNull(ssaDialogueFormatM2672a);
        this.f5988p = ssaDialogueFormatM2672a;
        m2671m(new ParsableByteArray(list.get(1)));
    }

    /* JADX INFO: renamed from: k */
    public static int m2668k(long j, List<Long> list, List<List<Cue>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }

    /* JADX INFO: renamed from: l */
    public static float m2669l(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    /* JADX INFO: renamed from: n */
    public static long m2670n(String str) {
        Matcher matcher = f5986n.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = Util2.f6708a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(strGroup) * 60 * 60 * 1000000);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* JADX INFO: renamed from: j */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) {
        ParsableByteArray parsableByteArray;
        SsaDialogueFormat ssaDialogueFormat;
        long j;
        int i2;
        int i3;
        float f;
        Layout.Alignment alignment;
        int i4;
        int i5;
        float fM2669l;
        float fM2669l2;
        float f2;
        int i6;
        float f3;
        int i7;
        int i8;
        int iM2673a;
        int i9;
        SsaDecoder ssaDecoder = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        if (!ssaDecoder.f5987o) {
            ssaDecoder.m2671m(parsableByteArray2);
        }
        SsaDialogueFormat ssaDialogueFormatM2672a = ssaDecoder.f5987o ? ssaDecoder.f5988p : null;
        while (true) {
            String strM3087g = parsableByteArray2.m3087g();
            if (strM3087g == null) {
                return new SsaSubtitle(arrayList, arrayList2);
            }
            if (strM3087g.startsWith("Format:")) {
                ssaDialogueFormatM2672a = SsaDialogueFormat.m2672a(strM3087g);
            } else if (strM3087g.startsWith("Dialogue:")) {
                if (ssaDialogueFormatM2672a == null) {
                    Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping dialogue line before complete format: ".concat(strM3087g) : new String("Skipping dialogue line before complete format: "));
                } else {
                    AnimatableValueParser.m531j(strM3087g.startsWith("Dialogue:"));
                    String[] strArrSplit = strM3087g.substring(9).split(",", ssaDialogueFormatM2672a.f5996e);
                    if (strArrSplit.length != ssaDialogueFormatM2672a.f5996e) {
                        Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(strM3087g) : new String("Skipping dialogue line with fewer columns than format: "));
                    } else {
                        long jM2670n = m2670n(strArrSplit[ssaDialogueFormatM2672a.f5992a]);
                        if (jM2670n == -9223372036854775807L) {
                            Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping invalid timing: ".concat(strM3087g) : new String("Skipping invalid timing: "));
                        } else {
                            long jM2670n2 = m2670n(strArrSplit[ssaDialogueFormatM2672a.f5993b]);
                            if (jM2670n2 == -9223372036854775807L) {
                                Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping invalid timing: ".concat(strM3087g) : new String("Skipping invalid timing: "));
                            } else {
                                Map<String, SsaStyle> map = ssaDecoder.f5989q;
                                SsaStyle ssaStyle = (map == null || (i9 = ssaDialogueFormatM2672a.f5994c) == -1) ? null : map.get(strArrSplit[i9].trim());
                                String str = strArrSplit[ssaDialogueFormatM2672a.f5995d];
                                Matcher matcher = SsaStyle.b.f6014a.matcher(str);
                                PointF pointF = null;
                                int i10 = -1;
                                while (true) {
                                    parsableByteArray = parsableByteArray2;
                                    if (matcher.find()) {
                                        String strGroup = matcher.group(1);
                                        Objects.requireNonNull(strGroup);
                                        try {
                                            PointF pointFM2676a = SsaStyle.b.m2676a(strGroup);
                                            if (pointFM2676a != null) {
                                                pointF = pointFM2676a;
                                            }
                                        } catch (RuntimeException unused) {
                                        }
                                        try {
                                            Matcher matcher2 = SsaStyle.b.f6017d.matcher(strGroup);
                                            if (matcher2.find()) {
                                                String strGroup2 = matcher2.group(1);
                                                Objects.requireNonNull(strGroup2);
                                                iM2673a = SsaStyle.m2673a(strGroup2);
                                            } else {
                                                iM2673a = -1;
                                            }
                                            if (iM2673a != -1) {
                                                i10 = iM2673a;
                                            }
                                        } catch (RuntimeException unused2) {
                                        }
                                        parsableByteArray2 = parsableByteArray;
                                    } else {
                                        String strReplace = SsaStyle.b.f6014a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                        float f4 = ssaDecoder.f5990r;
                                        float f5 = ssaDecoder.f5991s;
                                        SpannableString spannableString = new SpannableString(strReplace);
                                        if (ssaStyle != null) {
                                            if (ssaStyle.f5999c != null) {
                                                ssaDialogueFormat = ssaDialogueFormatM2672a;
                                                j = jM2670n2;
                                                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.f5999c.intValue()), 0, spannableString.length(), 33);
                                            } else {
                                                ssaDialogueFormat = ssaDialogueFormatM2672a;
                                                j = jM2670n2;
                                            }
                                            float f6 = ssaStyle.f6000d;
                                            if (f6 == -3.4028235E38f || f5 == -3.4028235E38f) {
                                                f2 = -3.4028235E38f;
                                                i6 = Integer.MIN_VALUE;
                                            } else {
                                                f2 = f6 / f5;
                                                i6 = 1;
                                            }
                                            boolean z3 = ssaStyle.f6001e;
                                            if (z3 && ssaStyle.f6002f) {
                                                i7 = 0;
                                                f3 = f2;
                                                i8 = 33;
                                                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                            } else {
                                                f3 = f2;
                                                i7 = 0;
                                                i8 = 33;
                                                if (z3) {
                                                    spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                                } else if (ssaStyle.f6002f) {
                                                    spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                }
                                            }
                                            if (ssaStyle.f6003g) {
                                                spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                            }
                                            if (ssaStyle.f6004h) {
                                                spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                            }
                                            i2 = -1;
                                            i3 = i6;
                                            f = f3;
                                        } else {
                                            ssaDialogueFormat = ssaDialogueFormatM2672a;
                                            j = jM2670n2;
                                            i2 = -1;
                                            i3 = Integer.MIN_VALUE;
                                            f = -3.4028235E38f;
                                        }
                                        if (i10 == i2) {
                                            i10 = ssaStyle != null ? ssaStyle.f5998b : i2;
                                        }
                                        switch (i10) {
                                            case 0:
                                            default:
                                                Log.w("SsaDecoder", outline.m851g(30, "Unknown alignment: ", i10));
                                            case -1:
                                                alignment = null;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                alignment = Layout.Alignment.ALIGN_NORMAL;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                alignment = Layout.Alignment.ALIGN_CENTER;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                break;
                                        }
                                        Layout.Alignment alignment2 = alignment;
                                        switch (i10) {
                                            case 0:
                                            default:
                                                Log.w("SsaDecoder", outline.m851g(30, "Unknown alignment: ", i10));
                                            case -1:
                                                i4 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                i4 = 0;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                i4 = 1;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                i4 = 2;
                                                break;
                                        }
                                        switch (i10) {
                                            case 0:
                                            default:
                                                Log.w("SsaDecoder", outline.m851g(30, "Unknown alignment: ", i10));
                                            case -1:
                                                i5 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 2:
                                            case 3:
                                                i5 = 2;
                                                break;
                                            case 4:
                                            case 5:
                                            case 6:
                                                i5 = 1;
                                                break;
                                            case 7:
                                            case 8:
                                            case 9:
                                                i5 = 0;
                                                break;
                                        }
                                        if (pointF == null || f5 == -3.4028235E38f || f4 == -3.4028235E38f) {
                                            fM2669l = m2669l(i4);
                                            fM2669l2 = m2669l(i5);
                                        } else {
                                            fM2669l = pointF.x / f4;
                                            fM2669l2 = pointF.y / f5;
                                        }
                                        Cue cue = new Cue(spannableString, alignment2, null, null, fM2669l2, 0, i5, fM2669l, i4, i3, f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                        int iM2668k = m2668k(j, arrayList2, arrayList);
                                        for (int iM2668k2 = m2668k(jM2670n, arrayList2, arrayList); iM2668k2 < iM2668k; iM2668k2++) {
                                            ((List) arrayList.get(iM2668k2)).add(cue);
                                        }
                                        ssaDecoder = this;
                                        ssaDialogueFormatM2672a = ssaDialogueFormat;
                                        parsableByteArray2 = parsableByteArray;
                                    }
                                }
                            }
                        }
                    }
                }
                parsableByteArray = parsableByteArray2;
                ssaDialogueFormat = ssaDialogueFormatM2672a;
                ssaDecoder = this;
                ssaDialogueFormatM2672a = ssaDialogueFormat;
                parsableByteArray2 = parsableByteArray;
            } else {
                parsableByteArray = parsableByteArray2;
                ssaDialogueFormat = ssaDialogueFormatM2672a;
                ssaDecoder = this;
                ssaDialogueFormatM2672a = ssaDialogueFormat;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012f  */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2671m(ParsableByteArray parsableByteArray) {
        SsaStyle ssaStyle;
        String strTrim;
        int iM2673a;
        Integer numM2675c;
        int i;
        float f;
        while (true) {
            String strM3087g = parsableByteArray.m3087g();
            if (strM3087g == null) {
                return;
            }
            int i2 = 91;
            char c = 2;
            char c2 = 0;
            if ("[Script Info]".equalsIgnoreCase(strM3087g)) {
                while (true) {
                    String strM3087g2 = parsableByteArray.m3087g();
                    if (strM3087g2 == null || (parsableByteArray.m3081a() != 0 && parsableByteArray.m3083c() == 91)) {
                        break;
                    }
                    String[] strArrSplit = strM3087g2.split(":");
                    if (strArrSplit.length == 2) {
                        String strM4349u1 = C3404f.m4349u1(strArrSplit[0].trim());
                        strM4349u1.hashCode();
                        if (strM4349u1.equals("playresx")) {
                            this.f5990r = Float.parseFloat(strArrSplit[1].trim());
                        } else if (strM4349u1.equals("playresy")) {
                            try {
                                this.f5991s = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strM3087g)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (true) {
                    SsaStyle.a aVar = null;
                    while (true) {
                        String strM3087g3 = parsableByteArray.m3087g();
                        if (strM3087g3 != null && (parsableByteArray.m3081a() == 0 || parsableByteArray.m3083c() != i2)) {
                            if (strM3087g3.startsWith("Format:")) {
                                String[] strArrSplit2 = TextUtils.split(strM3087g3.substring(7), ",");
                                int i3 = -1;
                                int i4 = -1;
                                int i5 = -1;
                                int i6 = -1;
                                int i7 = -1;
                                int i8 = -1;
                                int i9 = -1;
                                int i10 = -1;
                                for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                                    String strM4349u12 = C3404f.m4349u1(strArrSplit2[i11].trim());
                                    strM4349u12.hashCode();
                                    switch (strM4349u12) {
                                        case "italic":
                                            i8 = i11;
                                            break;
                                        case "underline":
                                            i9 = i11;
                                            break;
                                        case "strikeout":
                                            i10 = i11;
                                            break;
                                        case "primarycolour":
                                            i5 = i11;
                                            break;
                                        case "bold":
                                            i7 = i11;
                                            break;
                                        case "name":
                                            i3 = i11;
                                            break;
                                        case "fontsize":
                                            i6 = i11;
                                            break;
                                        case "alignment":
                                            i4 = i11;
                                            break;
                                    }
                                }
                                if (i3 != -1) {
                                    aVar = new SsaStyle.a(i3, i4, i5, i6, i7, i8, i9, i10, strArrSplit2.length);
                                }
                            } else {
                                if (strM3087g3.startsWith("Style:")) {
                                    if (aVar == null) {
                                        Log.w("SsaDecoder", strM3087g3.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(strM3087g3) : new String("Skipping 'Style:' line before 'Format:' line: "));
                                    } else {
                                        AnimatableValueParser.m531j(strM3087g3.startsWith("Style:"));
                                        String[] strArrSplit3 = TextUtils.split(strM3087g3.substring(6), ",");
                                        int length = strArrSplit3.length;
                                        int i12 = aVar.f6013i;
                                        if (length != i12) {
                                            Object[] objArr = new Object[3];
                                            objArr[c2] = Integer.valueOf(i12);
                                            objArr[1] = Integer.valueOf(strArrSplit3.length);
                                            objArr[c] = strM3087g3;
                                            Log.w("SsaStyle", Util2.m3003k("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
                                        } else {
                                            try {
                                                strTrim = strArrSplit3[aVar.f6005a].trim();
                                                int i13 = aVar.f6006b;
                                                iM2673a = i13 != -1 ? SsaStyle.m2673a(strArrSplit3[i13].trim()) : -1;
                                                int i14 = aVar.f6007c;
                                                numM2675c = i14 != -1 ? SsaStyle.m2675c(strArrSplit3[i14].trim()) : null;
                                                i = aVar.f6008d;
                                            } catch (RuntimeException e) {
                                                Log2.m3040c("SsaStyle", outline.m859k(strM3087g3.length() + 36, "Skipping malformed 'Style:' line: '", strM3087g3, "'"), e);
                                                ssaStyle = null;
                                            }
                                            if (i != -1) {
                                                String strTrim2 = strArrSplit3[i].trim();
                                                try {
                                                    f = Float.parseFloat(strTrim2);
                                                } catch (NumberFormatException e2) {
                                                    StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                                                    sb.append("Failed to parse font size: '");
                                                    sb.append(strTrim2);
                                                    sb.append("'");
                                                    Log2.m3040c("SsaStyle", sb.toString(), e2);
                                                    f = -3.4028235E38f;
                                                }
                                                int i15 = aVar.f6009e;
                                                boolean z2 = i15 == -1 && SsaStyle.m2674b(strArrSplit3[i15].trim());
                                                int i16 = aVar.f6010f;
                                                boolean z3 = i16 == -1 && SsaStyle.m2674b(strArrSplit3[i16].trim());
                                                int i17 = aVar.f6011g;
                                                boolean z4 = i17 == -1 && SsaStyle.m2674b(strArrSplit3[i17].trim());
                                                int i18 = aVar.f6012h;
                                                ssaStyle = new SsaStyle(strTrim, iM2673a, numM2675c, f, z2, z3, z4, i18 == -1 && SsaStyle.m2674b(strArrSplit3[i18].trim()));
                                                if (ssaStyle != null) {
                                                    linkedHashMap.put(ssaStyle.f5997a, ssaStyle);
                                                }
                                            } else {
                                                f = -3.4028235E38f;
                                                int i152 = aVar.f6009e;
                                                if (i152 == -1) {
                                                    int i162 = aVar.f6010f;
                                                    if (i162 == -1) {
                                                        int i172 = aVar.f6011g;
                                                        if (i172 == -1) {
                                                            int i182 = aVar.f6012h;
                                                            if (i182 == -1) {
                                                                ssaStyle = new SsaStyle(strTrim, iM2673a, numM2675c, f, z2, z3, z4, i182 == -1 && SsaStyle.m2674b(strArrSplit3[i182].trim()));
                                                                if (ssaStyle != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        ssaStyle = null;
                                        if (ssaStyle != null) {
                                        }
                                    }
                                }
                                i2 = 91;
                                c = 2;
                                c2 = 0;
                            }
                        }
                    }
                }
                this.f5989q = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strM3087g)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strM3087g)) {
                return;
            }
        }
    }
}
