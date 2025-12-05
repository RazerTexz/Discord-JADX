package p007b.p225i.p226a.p242c.p245b3.p254v;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.p249q.HorizontalTextInVerticalContextSpan;
import p007b.p225i.p226a.p242c.p245b3.p249q.RubySpan;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: WebvttCueParser.java */
/* renamed from: b.i.a.c.b3.v.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebvttCueParser {

    /* renamed from: a */
    public static final Pattern f6134a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b */
    public static final Pattern f6135b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c */
    public static final Map<String, Integer> f6136c;

    /* renamed from: d */
    public static final Map<String, Integer> f6137d;

    /* compiled from: WebvttCueParser.java */
    /* renamed from: b.i.a.c.b3.v.h$b */
    public static class b {

        /* renamed from: a */
        public static final /* synthetic */ int f6138a = 0;

        /* renamed from: b */
        public final c f6139b;

        /* renamed from: c */
        public final int f6140c;

        public b(c cVar, int i, a aVar) {
            this.f6139b = cVar;
            this.f6140c = i;
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* renamed from: b.i.a.c.b3.v.h$c */
    public static final class c {

        /* renamed from: a */
        public final String f6141a;

        /* renamed from: b */
        public final int f6142b;

        /* renamed from: c */
        public final String f6143c;

        /* renamed from: d */
        public final Set<String> f6144d;

        public c(String str, int i, String str2, Set<String> set) {
            this.f6142b = i;
            this.f6141a = str;
            this.f6143c = str2;
            this.f6144d = set;
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* renamed from: b.i.a.c.b3.v.h$d */
    public static final class d implements Comparable<d> {

        /* renamed from: j */
        public final int f6145j;

        /* renamed from: k */
        public final WebvttCssStyle f6146k;

        public d(int i, WebvttCssStyle webvttCssStyle) {
            this.f6145j = i;
            this.f6146k = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            return Integer.compare(this.f6145j, dVar.f6145j);
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* renamed from: b.i.a.c.b3.v.h$e */
    public static final class e {

        /* renamed from: c */
        public CharSequence f6149c;

        /* renamed from: a */
        public long f6147a = 0;

        /* renamed from: b */
        public long f6148b = 0;

        /* renamed from: d */
        public int f6150d = 2;

        /* renamed from: e */
        public float f6151e = -3.4028235E38f;

        /* renamed from: f */
        public int f6152f = 1;

        /* renamed from: g */
        public int f6153g = 0;

        /* renamed from: h */
        public float f6154h = -3.4028235E38f;

        /* renamed from: i */
        public int f6155i = Integer.MIN_VALUE;

        /* renamed from: j */
        public float f6156j = 1.0f;

        /* renamed from: k */
        public int f6157k = Integer.MIN_VALUE;

        /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Cue.b m2718a() {
            Layout.Alignment alignment;
            float f = this.f6154h;
            float f2 = -3.4028235E38f;
            if (f == -3.4028235E38f) {
                int i = this.f6150d;
                f = i != 4 ? i != 5 ? 0.5f : 1.0f : 0.0f;
            }
            int i2 = this.f6155i;
            if (i2 == Integer.MIN_VALUE) {
                int i3 = this.f6150d;
                if (i3 == 1) {
                    i2 = 0;
                } else if (i3 == 3) {
                    i2 = 2;
                } else if (i3 != 4) {
                    if (i3 != 5) {
                        i2 = 1;
                    }
                }
            }
            Cue.b bVar = new Cue.b();
            int i4 = this.f6150d;
            if (i4 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 == 2) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            } else if (i4 == 3) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i4 != 4) {
                if (i4 != 5) {
                    outline.m852g0(34, "Unknown textAlignment: ", i4, "WebvttCueParser");
                    alignment = null;
                }
            }
            bVar.f5775c = alignment;
            float f3 = this.f6151e;
            int i5 = this.f6152f;
            if (f3 == -3.4028235E38f || i5 != 0 || (f3 >= 0.0f && f3 <= 1.0f)) {
                if (f3 != -3.4028235E38f) {
                    f2 = f3;
                } else if (i5 == 0) {
                    f2 = 1.0f;
                }
            }
            bVar.f5777e = f2;
            bVar.f5778f = i5;
            bVar.f5779g = this.f6153g;
            bVar.f5780h = f;
            bVar.f5781i = i2;
            float f4 = this.f6156j;
            if (i2 == 0) {
                f = 1.0f - f;
            } else if (i2 == 1) {
                f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            } else if (i2 != 2) {
                throw new IllegalStateException(String.valueOf(i2));
            }
            bVar.f5784l = Math.min(f4, f);
            bVar.f5788p = this.f6157k;
            CharSequence charSequence = this.f6149c;
            if (charSequence != null) {
                bVar.f5773a = charSequence;
            }
            return bVar;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f6136c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f6137d = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2710a(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        char c2;
        int i = cVar.f6142b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f6141a;
        str2.hashCode();
        int iHashCode = str2.hashCode();
        int i2 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode != 3511770) {
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 117) {
                                    c2 = (iHashCode == 118 && str2.equals("v")) ? (char) 5 : (char) 65535;
                                } else if (str2.equals("u")) {
                                    c2 = 4;
                                }
                            } else if (str2.equals("c")) {
                                c2 = 2;
                            }
                        } else if (str2.equals("b")) {
                            c2 = 1;
                        }
                    } else if (str2.equals("ruby")) {
                        c2 = 7;
                    }
                } else if (str2.equals("lang")) {
                    c2 = 6;
                }
            } else if (str2.equals("i")) {
                c2 = 3;
            }
        } else if (str2.equals("")) {
            c2 = 0;
        }
        switch (c2) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 2:
                for (String str3 : cVar.f6144d) {
                    Map<String, Integer> map = f6136c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str3).intValue()), i, length, 33);
                    } else {
                        Map<String, Integer> map2 = f6137d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str3).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 7:
                int iM2712c = m2712c(list2, str, cVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                int i3 = b.f6138a;
                Collections.sort(arrayList, C2620a.f6106j);
                int i4 = cVar.f6142b;
                int i5 = 0;
                int length2 = 0;
                while (i5 < arrayList.size()) {
                    if ("rt".equals(((b) arrayList.get(i5)).f6139b.f6141a)) {
                        b bVar = (b) arrayList.get(i5);
                        int iM2712c2 = m2712c(list2, str, bVar.f6139b);
                        if (iM2712c2 == i2) {
                            iM2712c2 = iM2712c != i2 ? iM2712c : 1;
                        }
                        int i6 = bVar.f6139b.f6142b - length2;
                        int i7 = bVar.f6140c - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i6, i7);
                        spannableStringBuilder.delete(i6, i7);
                        spannableStringBuilder.setSpan(new RubySpan(charSequenceSubSequence.toString(), iM2712c2), i4, i6, 33);
                        length2 = charSequenceSubSequence.length() + length2;
                        i4 = i6;
                    }
                    i5++;
                    i2 = -1;
                }
                break;
            default:
                return;
        }
        List<d> listM2711b = m2711b(list2, str, cVar);
        int i8 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) listM2711b;
            if (i8 >= arrayList2.size()) {
                return;
            }
            WebvttCssStyle webvttCssStyle = ((d) arrayList2.get(i8)).f6146k;
            if (webvttCssStyle != null) {
                if (webvttCssStyle.m2709a() != -1) {
                    AnimatableValueParser.m503c(spannableStringBuilder, new StyleSpan(webvttCssStyle.m2709a()), i, length, 33);
                }
                if (webvttCssStyle.f6123j == 1) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (webvttCssStyle.f6124k == 1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (webvttCssStyle.f6120g) {
                    if (!webvttCssStyle.f6120g) {
                        throw new IllegalStateException("Font color not defined");
                    }
                    AnimatableValueParser.m503c(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.f6119f), i, length, 33);
                }
                if (webvttCssStyle.f6122i) {
                    if (!webvttCssStyle.f6122i) {
                        throw new IllegalStateException("Background color not defined.");
                    }
                    AnimatableValueParser.m503c(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.f6121h), i, length, 33);
                }
                if (webvttCssStyle.f6118e != null) {
                    AnimatableValueParser.m503c(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.f6118e), i, length, 33);
                }
                int i9 = webvttCssStyle.f6127n;
                if (i9 == 1) {
                    AnimatableValueParser.m503c(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.f6128o, true), i, length, 33);
                } else if (i9 == 2) {
                    AnimatableValueParser.m503c(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.f6128o), i, length, 33);
                } else if (i9 == 3) {
                    AnimatableValueParser.m503c(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.f6128o / 100.0f), i, length, 33);
                }
                if (webvttCssStyle.f6130q) {
                    spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i, length, 33);
                }
            }
            i8++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static List<d> m2711b(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WebvttCssStyle webvttCssStyle = list.get(i);
            String str2 = cVar.f6141a;
            Set<String> set = cVar.f6144d;
            String str3 = cVar.f6143c;
            if (webvttCssStyle.f6114a.isEmpty() && webvttCssStyle.f6115b.isEmpty() && webvttCssStyle.f6116c.isEmpty() && webvttCssStyle.f6117d.isEmpty()) {
                size = TextUtils.isEmpty(str2);
            } else {
                int iM2708b = WebvttCssStyle.m2708b(WebvttCssStyle.m2708b(WebvttCssStyle.m2708b(0, webvttCssStyle.f6114a, str, BasicMeasure.EXACTLY), webvttCssStyle.f6115b, str2, 2), webvttCssStyle.f6117d, str3, 4);
                size = (iM2708b == -1 || !set.containsAll(webvttCssStyle.f6116c)) ? 0 : iM2708b + (webvttCssStyle.f6116c.size() * 4);
            }
            if (size > 0) {
                arrayList.add(new d(size, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public static int m2712c(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        List<d> listM2711b = m2711b(list, str, cVar);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) listM2711b;
            if (i >= arrayList.size()) {
                return -1;
            }
            int i2 = ((d) arrayList.get(i)).f6146k.f6129p;
            if (i2 != -1) {
                return i2;
            }
            i++;
        }
    }

    @Nullable
    /* renamed from: d */
    public static WebvttCueInfo m2713d(@Nullable String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        e eVar = new e();
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            eVar.f6147a = WebvttParserUtil.m2720b(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            eVar.f6148b = WebvttParserUtil.m2720b(strGroup2);
            String strGroup3 = matcher.group(3);
            Objects.requireNonNull(strGroup3);
            m2714e(strGroup3, eVar);
            StringBuilder sb = new StringBuilder();
            String strM3087g = parsableByteArray.m3087g();
            while (!TextUtils.isEmpty(strM3087g)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strM3087g.trim());
                strM3087g = parsableByteArray.m3087g();
            }
            eVar.f6149c = m2715f(str, sb.toString(), list);
            return new WebvttCueInfo(eVar.m2718a().m2606a(), eVar.f6147a, eVar.f6148b);
        } catch (NumberFormatException unused) {
            String strValueOf = String.valueOf(matcher.group());
            Log.w("WebvttCueParser", strValueOf.length() != 0 ? "Skipping cue with bad header: ".concat(strValueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: e */
    public static void m2714e(String str, e eVar) {
        Matcher matcher = f6135b.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            try {
                if ("line".equals(strGroup)) {
                    m2716g(strGroup2, eVar);
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2) {
                        case "center":
                        case "middle":
                            i = 2;
                            break;
                        case "end":
                            i = 3;
                            break;
                        case "left":
                            i = 4;
                            break;
                        case "right":
                            i = 5;
                            break;
                        case "start":
                            break;
                        default:
                            Log.w("WebvttCueParser", strGroup2.length() != 0 ? "Invalid alignment value: ".concat(strGroup2) : new String("Invalid alignment value: "));
                            i = 2;
                            break;
                    }
                    eVar.f6150d = i;
                } else if (ModelAuditLogEntry.CHANGE_KEY_POSITION.equals(strGroup)) {
                    m2717h(strGroup2, eVar);
                } else if ("size".equals(strGroup)) {
                    eVar.f6156j = WebvttParserUtil.m2719a(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    if (strGroup2.equals("lr")) {
                        i = 2;
                    } else if (!strGroup2.equals("rl")) {
                        Log.w("WebvttCueParser", strGroup2.length() != 0 ? "Invalid 'vertical' value: ".concat(strGroup2) : new String("Invalid 'vertical' value: "));
                        i = Integer.MIN_VALUE;
                    }
                    eVar.f6157k = i;
                } else {
                    StringBuilder sb = new StringBuilder(strGroup.length() + 21 + strGroup2.length());
                    sb.append("Unknown cue setting ");
                    sb.append(strGroup);
                    sb.append(":");
                    sb.append(strGroup2);
                    Log.w("WebvttCueParser", sb.toString());
                }
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(matcher.group());
                Log.w("WebvttCueParser", strValueOf.length() != 0 ? "Skipping bad cue setting: ".concat(strValueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f5  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannedString m2715f(@Nullable String str, String str2, List<WebvttCssStyle> list) {
        String strSubstring;
        boolean z2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            String strTrim = "";
            if (i2 >= str2.length()) {
                while (!arrayDeque.isEmpty()) {
                    m2710a(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                m2710a(str, new c("", 0, "", Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char cCharAt = str2.charAt(i2);
            if (cCharAt == '&') {
                i2++;
                int iIndexOf = str2.indexOf(59, i2);
                int iIndexOf2 = str2.indexOf(32, i2);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    strSubstring = str2.substring(i2, iIndexOf);
                    strSubstring.hashCode();
                    strSubstring.hashCode();
                    switch (strSubstring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            outline.m856i0(strSubstring.length() + 33, "ignoring unsupported entity: '&", strSubstring, ";'", "WebvttCueParser");
                            break;
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i2 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i2++;
            } else {
                int length = i2 + 1;
                if (length < str2.length()) {
                    boolean z3 = str2.charAt(length) == '/';
                    int iIndexOf3 = str2.indexOf(62, length);
                    length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                    int i3 = length - 2;
                    boolean z4 = str2.charAt(i3) == '/';
                    int i4 = i2 + (z3 ? 2 : 1);
                    if (!z4) {
                        i3 = length - 1;
                    }
                    String strSubstring2 = str2.substring(i4, i3);
                    if (!strSubstring2.trim().isEmpty()) {
                        String strTrim2 = strSubstring2.trim();
                        AnimatableValueParser.m531j(!strTrim2.isEmpty());
                        int i5 = Util2.f6708a;
                        String str3 = strTrim2.split("[ \\.]", 2)[i];
                        str3.hashCode();
                        switch (str3) {
                            case "b":
                            case "c":
                            case "i":
                            case "u":
                            case "v":
                            case "rt":
                            case "lang":
                            case "ruby":
                                z2 = true;
                                break;
                            default:
                                z2 = false;
                                break;
                        }
                        if (z2) {
                            if (z3) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    m2710a(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length(), null));
                                    }
                                    if (cVar.f6141a.equals(str3)) {
                                    }
                                }
                            } else if (!z4) {
                                int length2 = spannableStringBuilder.length();
                                String strTrim3 = strSubstring2.trim();
                                AnimatableValueParser.m531j(!strTrim3.isEmpty());
                                int iIndexOf4 = strTrim3.indexOf(" ");
                                if (iIndexOf4 != -1) {
                                    strTrim = strTrim3.substring(iIndexOf4).trim();
                                    strTrim3 = strTrim3.substring(i, iIndexOf4);
                                }
                                String[] strArrM2987H = Util2.m2987H(strTrim3, "\\.");
                                String str4 = strArrM2987H[i];
                                HashSet hashSet = new HashSet();
                                for (int i6 = 1; i6 < strArrM2987H.length; i6++) {
                                    hashSet.add(strArrM2987H[i6]);
                                }
                                arrayDeque.push(new c(str4, length2, strTrim, hashSet));
                            }
                        }
                    }
                    i2 = length;
                }
                i2 = length;
            }
            i = 0;
        }
    }

    /* renamed from: g */
    public static void m2716g(String str, e eVar) {
        String strSubstring;
        int i;
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            strSubstring = str.substring(iIndexOf + 1);
            strSubstring.hashCode();
            i = 2;
            switch (strSubstring) {
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i = 0;
                    break;
                default:
                    Log.w("WebvttCueParser", strSubstring.length() != 0 ? "Invalid anchor value: ".concat(strSubstring) : new String("Invalid anchor value: "));
                    i = Integer.MIN_VALUE;
                    break;
            }
            eVar.f6153g = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.f6151e = WebvttParserUtil.m2719a(str);
            eVar.f6152f = 0;
        } else {
            eVar.f6151e = Integer.parseInt(str);
            eVar.f6152f = 1;
        }
    }

    /* renamed from: h */
    public static void m2717h(String str, e eVar) {
        String strSubstring;
        int i;
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            strSubstring = str.substring(iIndexOf + 1);
            strSubstring.hashCode();
            i = 2;
            switch (strSubstring) {
                case "line-left":
                case "start":
                    i = 0;
                    break;
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "line-right":
                case "end":
                    break;
                default:
                    Log.w("WebvttCueParser", strSubstring.length() != 0 ? "Invalid anchor value: ".concat(strSubstring) : new String("Invalid anchor value: "));
                    i = Integer.MIN_VALUE;
                    break;
            }
            eVar.f6155i = i;
            str = str.substring(0, iIndexOf);
        }
        eVar.f6154h = WebvttParserUtil.m2719a(str);
    }
}
