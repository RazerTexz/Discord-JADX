package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.ColorParser2;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.Collections2;
import p007b.p225i.p355b.p357b.ImmutableSet2;
import p007b.p225i.p355b.p357b.Sets2;
import p007b.p225i.p355b.p357b.Sets4;

/* compiled from: TtmlDecoder.java */
/* renamed from: b.i.a.c.b3.t.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder2 {

    /* renamed from: n */
    public static final Pattern f6034n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: o */
    public static final Pattern f6035o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: p */
    public static final Pattern f6036p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: q */
    public static final Pattern f6037q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: r */
    public static final Pattern f6038r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: s */
    public static final Pattern f6039s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: t */
    public static final Pattern f6040t = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: u */
    public static final b f6041u = new b(30.0f, 1, 1);

    /* renamed from: v */
    public static final a f6042v = new a(32, 15);

    /* renamed from: w */
    public final XmlPullParserFactory f6043w;

    /* compiled from: TtmlDecoder.java */
    /* renamed from: b.i.a.c.b3.t.c$a */
    public static final class a {

        /* renamed from: a */
        public final int f6044a;

        public a(int i, int i2) {
            this.f6044a = i2;
        }
    }

    /* compiled from: TtmlDecoder.java */
    /* renamed from: b.i.a.c.b3.t.c$b */
    public static final class b {

        /* renamed from: a */
        public final float f6045a;

        /* renamed from: b */
        public final int f6046b;

        /* renamed from: c */
        public final int f6047c;

        public b(float f, int i, int i2) {
            this.f6045a = f;
            this.f6046b = i;
            this.f6047c = i2;
        }
    }

    /* compiled from: TtmlDecoder.java */
    /* renamed from: b.i.a.c.b3.t.c$c */
    public static final class c {

        /* renamed from: a */
        public final int f6048a;

        /* renamed from: b */
        public final int f6049b;

        public c(int i, int i2) {
            this.f6048a = i;
            this.f6049b = i2;
        }
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f6043w = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* renamed from: k */
    public static TtmlStyle m2679k(@Nullable TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    /* renamed from: l */
    public static boolean m2680l(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    /* renamed from: m */
    public static Layout.Alignment m2681m(String str) {
        String strM4349u1 = C3404f.m4349u1(str);
        strM4349u1.hashCode();
        switch (strM4349u1) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* renamed from: n */
    public static a m2682n(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f6040t.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            int i2 = Integer.parseInt(strGroup2);
            if (i != 0 && i2 != 0) {
                return new a(i, i2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(i);
            sb.append(" ");
            sb.append(i2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    /* renamed from: o */
    public static void m2683o(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String strGroup;
        int i = Util2.f6708a;
        String[] strArrSplit = str.split("\\s+", -1);
        if (strArrSplit.length == 1) {
            matcher = f6036p.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                int length = strArrSplit.length;
                StringBuilder sb = new StringBuilder(52);
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(length);
                sb.append(".");
                throw new SubtitleDecoderException(sb.toString());
            }
            matcher = f6036p.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(outline.m859k(str.length() + 36, "Invalid expression for fontSize: '", str, "'."));
        }
        strGroup = matcher.group(3);
        Objects.requireNonNull(strGroup);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                ttmlStyle.f6082j = 3;
                break;
            case "em":
                ttmlStyle.f6082j = 2;
                break;
            case "px":
                ttmlStyle.f6082j = 1;
                break;
            default:
                throw new SubtitleDecoderException(outline.m859k(strGroup.length() + 30, "Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        Objects.requireNonNull(strGroup2);
        ttmlStyle.f6083k = Float.parseFloat(strGroup2);
    }

    /* renamed from: p */
    public static b m2684p(XmlPullParser xmlPullParser) throws SubtitleDecoderException, NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i2 = Util2.f6708a;
            if (attributeValue2.split(" ", -1).length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        }
        b bVar = f6041u;
        int i3 = bVar.f6046b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.f6047c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f7  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, TtmlStyle> m2685q(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, a aVar, @Nullable c cVar, Map<String, TtmlRegion> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        String strM564r0;
        TtmlRegion ttmlRegion;
        float f;
        float f2;
        String strM564r02;
        float f3;
        float f4;
        String strM564r03;
        float f5;
        int i;
        char c2;
        do {
            xmlPullParser.next();
            if (AnimatableValueParser.m490Y0(xmlPullParser, "style")) {
                String strM564r04 = AnimatableValueParser.m564r0(xmlPullParser, "style");
                TtmlStyle ttmlStyleM2687s = m2687s(xmlPullParser, new TtmlStyle());
                if (strM564r04 != null) {
                    for (String str : m2688t(strM564r04)) {
                        ttmlStyleM2687s.m2701a(map.get(str));
                    }
                }
                String str2 = ttmlStyleM2687s.f6084l;
                if (str2 != null) {
                    map.put(str2, ttmlStyleM2687s);
                }
            } else if (AnimatableValueParser.m490Y0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                String strM564r05 = AnimatableValueParser.m564r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID);
                if (strM564r05 != null) {
                    String strM564r06 = AnimatableValueParser.m564r0(xmlPullParser, "origin");
                    if (strM564r06 != null) {
                        Pattern pattern = f6038r;
                        Matcher matcher = pattern.matcher(strM564r06);
                        Pattern pattern2 = f6039s;
                        Matcher matcher2 = pattern2.matcher(strM564r06);
                        if (matcher.matches()) {
                            try {
                                String strGroup = matcher.group(1);
                                Objects.requireNonNull(strGroup);
                                f = Float.parseFloat(strGroup) / 100.0f;
                                String strGroup2 = matcher.group(2);
                                Objects.requireNonNull(strGroup2);
                                f2 = Float.parseFloat(strGroup2) / 100.0f;
                                strM564r02 = AnimatableValueParser.m564r0(xmlPullParser, "extent");
                            } catch (NumberFormatException unused) {
                                Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with malformed origin: ".concat(strM564r06) : new String("Ignoring region with malformed origin: "));
                            }
                            if (strM564r02 == null) {
                                Matcher matcher3 = pattern.matcher(strM564r02);
                                Matcher matcher4 = pattern2.matcher(strM564r02);
                                if (matcher3.matches()) {
                                    try {
                                        String strGroup3 = matcher3.group(1);
                                        Objects.requireNonNull(strGroup3);
                                        float f6 = Float.parseFloat(strGroup3) / 100.0f;
                                        String strGroup4 = matcher3.group(2);
                                        Objects.requireNonNull(strGroup4);
                                        f3 = Float.parseFloat(strGroup4) / 100.0f;
                                        f4 = f6;
                                        strM564r03 = AnimatableValueParser.m564r0(xmlPullParser, "displayAlign");
                                        if (strM564r03 == null) {
                                            String strM4349u1 = C3404f.m4349u1(strM564r03);
                                            strM4349u1.hashCode();
                                            if (strM4349u1.equals("center")) {
                                                f5 = (f3 / 2.0f) + f2;
                                                i = 1;
                                            } else if (strM4349u1.equals("after")) {
                                                f5 = f2 + f3;
                                                i = 2;
                                            } else {
                                                f5 = f2;
                                                i = 0;
                                            }
                                            float f7 = 1.0f / aVar.f6044a;
                                            String strM564r07 = AnimatableValueParser.m564r0(xmlPullParser, "writingMode");
                                            if (strM564r07 != null) {
                                                String strM4349u12 = C3404f.m4349u1(strM564r07);
                                                strM4349u12.hashCode();
                                                int iHashCode = strM4349u12.hashCode();
                                                if (iHashCode == 3694) {
                                                    if (strM4349u12.equals("tb")) {
                                                        c2 = 0;
                                                    }
                                                    if (c2 == 0) {
                                                    }
                                                } else if (iHashCode != 3553396) {
                                                    c2 = (iHashCode == 3553576 && strM4349u12.equals("tbrl")) ? (char) 2 : (char) 65535;
                                                    int i2 = (c2 == 0 || c2 == 1) ? 2 : c2 != 2 ? Integer.MIN_VALUE : 1;
                                                    ttmlRegion = new TtmlRegion(strM564r05, f, f5, 0, i, f4, f3, 1, f7, i2);
                                                } else {
                                                    if (strM4349u12.equals("tblr")) {
                                                        c2 = 1;
                                                    }
                                                    if (c2 == 0) {
                                                        ttmlRegion = new TtmlRegion(strM564r05, f, f5, 0, i, f4, f3, 1, f7, i2);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (NumberFormatException unused2) {
                                        Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with malformed extent: ".concat(strM564r06) : new String("Ignoring region with malformed extent: "));
                                    }
                                } else if (!matcher4.matches()) {
                                    Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with unsupported extent: ".concat(strM564r06) : new String("Ignoring region with unsupported extent: "));
                                } else if (cVar == null) {
                                    Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strM564r06) : new String("Ignoring region with missing tts:extent: "));
                                } else {
                                    try {
                                        String strGroup5 = matcher4.group(1);
                                        Objects.requireNonNull(strGroup5);
                                        int i3 = Integer.parseInt(strGroup5);
                                        String strGroup6 = matcher4.group(2);
                                        Objects.requireNonNull(strGroup6);
                                        f4 = i3 / cVar.f6048a;
                                        f3 = Integer.parseInt(strGroup6) / cVar.f6049b;
                                        strM564r03 = AnimatableValueParser.m564r0(xmlPullParser, "displayAlign");
                                        if (strM564r03 == null) {
                                        }
                                    } catch (NumberFormatException unused3) {
                                        Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with malformed extent: ".concat(strM564r06) : new String("Ignoring region with malformed extent: "));
                                    }
                                }
                                if (ttmlRegion != null) {
                                    map2.put(ttmlRegion.f6063a, ttmlRegion);
                                }
                            } else {
                                Log.w("TtmlDecoder", "Ignoring region without an extent");
                            }
                        } else if (!matcher2.matches()) {
                            Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with unsupported origin: ".concat(strM564r06) : new String("Ignoring region with unsupported origin: "));
                        } else if (cVar == null) {
                            Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strM564r06) : new String("Ignoring region with missing tts:extent: "));
                        } else {
                            try {
                                String strGroup7 = matcher2.group(1);
                                Objects.requireNonNull(strGroup7);
                                int i4 = Integer.parseInt(strGroup7);
                                String strGroup8 = matcher2.group(2);
                                Objects.requireNonNull(strGroup8);
                                float f8 = i4 / cVar.f6048a;
                                float f9 = Integer.parseInt(strGroup8) / cVar.f6049b;
                                f = f8;
                                f2 = f9;
                                strM564r02 = AnimatableValueParser.m564r0(xmlPullParser, "extent");
                                if (strM564r02 == null) {
                                }
                            } catch (NumberFormatException unused4) {
                                Log.w("TtmlDecoder", strM564r06.length() != 0 ? "Ignoring region with malformed origin: ".concat(strM564r06) : new String("Ignoring region with malformed origin: "));
                            }
                        }
                    } else {
                        Log.w("TtmlDecoder", "Ignoring region without an origin");
                    }
                    ttmlRegion = null;
                    if (ttmlRegion != null) {
                    }
                } else {
                    ttmlRegion = null;
                    if (ttmlRegion != null) {
                    }
                }
            } else if (AnimatableValueParser.m490Y0(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (AnimatableValueParser.m490Y0(xmlPullParser, "image") && (strM564r0 = AnimatableValueParser.m564r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID)) != null) {
                        map3.put(strM564r0, xmlPullParser.nextText());
                    }
                } while (!AnimatableValueParser.m469R0(xmlPullParser, "metadata"));
            }
        } while (!AnimatableValueParser.m469R0(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TtmlNode m2686r(XmlPullParser xmlPullParser, @Nullable TtmlNode ttmlNode, Map<String, TtmlRegion> map, b bVar) throws SubtitleDecoderException, NumberFormatException {
        long j;
        long j2;
        char c2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleM2687s = m2687s(xmlPullParser2, null);
        String strSubstring = null;
        String str = "";
        long jM2689u = -9223372036854775807L;
        long jM2689u2 = -9223372036854775807L;
        long jM2689u3 = -9223372036854775807L;
        String[] strArr = null;
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    c2 = !attributeName.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) ? (char) 65535 : (char) 0;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    jM2689u3 = m2689u(attributeValue, bVar);
                } else if (c2 == 2) {
                    jM2689u2 = m2689u(attributeValue, bVar);
                } else if (c2 == 3) {
                    jM2689u = m2689u(attributeValue, bVar);
                } else if (c2 == 4) {
                    String[] strArrM2688t = m2688t(attributeValue);
                    if (strArrM2688t.length > 0) {
                        strArr = strArrM2688t;
                    }
                } else if (c2 == 5 && attributeValue.startsWith("#")) {
                    strSubstring = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str = attributeValue;
            }
            i++;
            xmlPullParser2 = xmlPullParser;
        }
        if (ttmlNode != null) {
            long j3 = ttmlNode.f6053d;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jM2689u != -9223372036854775807L) {
                    jM2689u += j3;
                }
                if (jM2689u2 != -9223372036854775807L) {
                    jM2689u2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (jM2689u2 != j) {
            j2 = jM2689u2;
        } else if (jM2689u3 != j) {
            j2 = jM2689u + jM2689u3;
        } else if (ttmlNode != null) {
            long j4 = ttmlNode.f6054e;
            if (j4 != j) {
                j2 = j4;
            }
        }
        return new TtmlNode(xmlPullParser.getName(), null, jM2689u, j2, ttmlStyleM2687s, strArr, str, strSubstring, ttmlNode);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TtmlStyle m2687s(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        String attributeValue;
        int i;
        char c2;
        char c3;
        Collections2.a aVar;
        char c4;
        int iHashCode;
        TextEmphasis textEmphasis;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleM2679k = ttmlStyle;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            attributeName.hashCode();
            c2 = 1;
            switch (attributeName) {
                case "fontStyle":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    ttmlStyleM2679k.f6081i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "fontFamily":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    ttmlStyleM2679k.f6073a = attributeValue;
                    break;
                case "textAlign":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    ttmlStyleM2679k.f6087o = m2681m(attributeValue);
                    break;
                case "textDecoration":
                    String strM4349u1 = C3404f.m4349u1(attributeValue);
                    strM4349u1.hashCode();
                    switch (strM4349u1.hashCode()) {
                        case -1461280213:
                            if (strM4349u1.equals("nounderline")) {
                                i = 0;
                            }
                            break;
                        case -1026963764:
                            if (strM4349u1.equals("underline")) {
                                i = 1;
                            }
                            break;
                        case 913457136:
                            if (strM4349u1.equals("nolinethrough")) {
                                i = 2;
                            }
                            break;
                        case 1679736913:
                            if (strM4349u1.equals("linethrough")) {
                                i = 3;
                            }
                            break;
                    }
                    if (i == 0) {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6079g = 0;
                        break;
                    } else {
                        if (i == 1) {
                            ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                            ttmlStyleM2679k.f6079g = 1;
                        } else if (i == 2) {
                            ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                            ttmlStyleM2679k.f6078f = 0;
                        } else if (i == 3) {
                            ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                            ttmlStyleM2679k.f6078f = 1;
                        }
                        break;
                    }
                    break;
                case "fontWeight":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    ttmlStyleM2679k.f6080h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6084l = attributeValue;
                        break;
                    }
                    break;
                case "ruby":
                    String strM4349u12 = C3404f.m4349u1(attributeValue);
                    strM4349u12.hashCode();
                    switch (strM4349u12.hashCode()) {
                        case -618561360:
                            if (strM4349u12.equals("baseContainer")) {
                                i = 0;
                            }
                            break;
                        case -410956671:
                            if (strM4349u12.equals("container")) {
                                i = 1;
                            }
                            break;
                        case -250518009:
                            if (strM4349u12.equals("delimiter")) {
                                i = 2;
                            }
                            break;
                        case -136074796:
                            if (strM4349u12.equals("textContainer")) {
                                i = 3;
                            }
                            break;
                        case 3016401:
                            if (strM4349u12.equals("base")) {
                                i = 4;
                            }
                            break;
                        case 3556653:
                            if (strM4349u12.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                                i = 5;
                            }
                            break;
                    }
                    if (i == 0) {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6085m = 2;
                        break;
                    } else if (i == 1) {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6085m = 1;
                        break;
                    } else if (i == 2) {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6085m = 4;
                        break;
                    } else if (i == 3) {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6085m = 3;
                        break;
                    } else if (i != 4) {
                        if (i != 5) {
                            break;
                        }
                    }
                    break;
                case "color":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    try {
                        ttmlStyleM2679k.f6074b = ColorParser2.m3024a(attributeValue, false);
                        ttmlStyleM2679k.f6075c = true;
                        break;
                    } catch (IllegalArgumentException unused) {
                        String strValueOf = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf.length() != 0 ? "Failed parsing color value: ".concat(strValueOf) : new String("Failed parsing color value: "));
                        break;
                    }
                    break;
                case "shear":
                    TtmlStyle ttmlStyleM2679k2 = m2679k(ttmlStyleM2679k);
                    Matcher matcher = f6037q.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(1);
                            Objects.requireNonNull(strGroup);
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                        } catch (NumberFormatException e) {
                            String strValueOf2 = String.valueOf(attributeValue);
                            Log2.m3040c("TtmlDecoder", strValueOf2.length() != 0 ? "Failed to parse shear: ".concat(strValueOf2) : new String("Failed to parse shear: "), e);
                        }
                        break;
                    } else {
                        String strValueOf3 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf3.length() != 0 ? "Invalid value for shear: ".concat(strValueOf3) : new String("Invalid value for shear: "));
                    }
                    ttmlStyleM2679k2.f6091s = fMin;
                    ttmlStyleM2679k = ttmlStyleM2679k2;
                    break;
                case "textCombine":
                    String strM4349u13 = C3404f.m4349u1(attributeValue);
                    strM4349u13.hashCode();
                    if (!strM4349u13.equals("all")) {
                        if (strM4349u13.equals("none")) {
                            ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                            ttmlStyleM2679k.f6089q = 0;
                        }
                        break;
                    } else {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6089q = 1;
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        m2683o(attributeValue, ttmlStyleM2679k);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        String strValueOf4 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf4.length() != 0 ? "Failed parsing fontSize value: ".concat(strValueOf4) : new String("Failed parsing fontSize value: "));
                        break;
                    }
                    break;
                case "textEmphasis":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    Pattern pattern = TextEmphasis.f6026a;
                    TextEmphasis textEmphasis2 = null;
                    if (attributeValue != null) {
                        String strM4349u14 = C3404f.m4349u1(attributeValue.trim());
                        if (!strM4349u14.isEmpty()) {
                            ImmutableSet2 immutableSet2M6282n = ImmutableSet2.m6282n(TextUtils.split(strM4349u14, TextEmphasis.f6026a));
                            String str = (String) C3404f.m4308k0(Collections2.m6239b(TextEmphasis.f6030e, immutableSet2M6282n), "outside");
                            int iHashCode2 = str.hashCode();
                            if (iHashCode2 == -1392885889) {
                                if (str.equals("before")) {
                                    c3 = 2;
                                }
                                if (c3 != 0) {
                                }
                                aVar = (Collections2.a) Collections2.m6239b(TextEmphasis.f6027b, immutableSet2M6282n);
                                if (aVar.isEmpty()) {
                                }
                                textEmphasis2 = textEmphasis;
                            } else if (iHashCode2 != -1106037339) {
                                c3 = (iHashCode2 == 92734940 && str.equals("after")) ? (char) 0 : (char) 65535;
                                int i3 = c3 != 0 ? c3 != 1 ? 1 : -2 : 2;
                                aVar = (Collections2.a) Collections2.m6239b(TextEmphasis.f6027b, immutableSet2M6282n);
                                if (aVar.isEmpty()) {
                                    Sets4 sets4M6239b = Collections2.m6239b(TextEmphasis.f6029d, immutableSet2M6282n);
                                    Sets4 sets4M6239b2 = Collections2.m6239b(TextEmphasis.f6028c, immutableSet2M6282n);
                                    if (((Collections2.a) sets4M6239b).isEmpty() && ((Collections2.a) sets4M6239b2).isEmpty()) {
                                        textEmphasis = new TextEmphasis(-1, 0, i3);
                                    } else {
                                        String str2 = (String) C3404f.m4308k0(sets4M6239b, "filled");
                                        int iHashCode3 = str2.hashCode();
                                        if (iHashCode3 != -1274499742) {
                                            c4 = (iHashCode3 == 3417674 && str2.equals("open")) ? (char) 0 : (char) 65535;
                                            int i4 = c4 == 0 ? 1 : 2;
                                            String str3 = (String) C3404f.m4308k0(sets4M6239b2, "circle");
                                            iHashCode = str3.hashCode();
                                            if (iHashCode == -1360216880) {
                                                if (iHashCode != -905816648) {
                                                    if (iHashCode == 99657 && str3.equals("dot")) {
                                                        i = 0;
                                                    }
                                                } else if (str3.equals("sesame")) {
                                                    i = 1;
                                                }
                                            } else if (str3.equals("circle")) {
                                                i = 2;
                                            }
                                            textEmphasis = new TextEmphasis(i == 0 ? i != 1 ? 1 : 3 : 2, i4, i3);
                                        } else {
                                            if (str2.equals("filled")) {
                                                c4 = 1;
                                            }
                                            if (c4 == 0) {
                                            }
                                            String str32 = (String) C3404f.m4308k0(sets4M6239b2, "circle");
                                            iHashCode = str32.hashCode();
                                            if (iHashCode == -1360216880) {
                                            }
                                            textEmphasis = new TextEmphasis(i == 0 ? i != 1 ? 1 : 3 : 2, i4, i3);
                                        }
                                    }
                                } else {
                                    String str4 = (String) new Sets2(aVar).next();
                                    int iHashCode4 = str4.hashCode();
                                    if (iHashCode4 != 3005871) {
                                        c2 = (iHashCode4 == 3387192 && str4.equals("none")) ? (char) 0 : (char) 65535;
                                        textEmphasis = new TextEmphasis(c2 == 0 ? 0 : -1, 0, i3);
                                    } else {
                                        if (!str4.equals("auto")) {
                                        }
                                        textEmphasis = new TextEmphasis(c2 == 0 ? 0 : -1, 0, i3);
                                    }
                                }
                                textEmphasis2 = textEmphasis;
                            } else {
                                if (str.equals("outside")) {
                                    c3 = 1;
                                }
                                if (c3 != 0) {
                                }
                                aVar = (Collections2.a) Collections2.m6239b(TextEmphasis.f6027b, immutableSet2M6282n);
                                if (aVar.isEmpty()) {
                                }
                                textEmphasis2 = textEmphasis;
                            }
                        }
                    }
                    ttmlStyleM2679k.f6090r = textEmphasis2;
                    break;
                case "rubyPosition":
                    String strM4349u15 = C3404f.m4349u1(attributeValue);
                    strM4349u15.hashCode();
                    if (!strM4349u15.equals("before")) {
                        if (strM4349u15.equals("after")) {
                            ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                            ttmlStyleM2679k.f6086n = 2;
                        }
                        break;
                    } else {
                        ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                        ttmlStyleM2679k.f6086n = 1;
                        break;
                    }
                    break;
                case "backgroundColor":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    try {
                        ttmlStyleM2679k.f6076d = ColorParser2.m3024a(attributeValue, false);
                        ttmlStyleM2679k.f6077e = true;
                        break;
                    } catch (IllegalArgumentException unused3) {
                        String strValueOf5 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf5.length() != 0 ? "Failed parsing background value: ".concat(strValueOf5) : new String("Failed parsing background value: "));
                        break;
                    }
                    break;
                case "multiRowAlign":
                    ttmlStyleM2679k = m2679k(ttmlStyleM2679k);
                    ttmlStyleM2679k.f6088p = m2681m(attributeValue);
                    break;
            }
        }
        return ttmlStyleM2679k;
    }

    /* renamed from: t */
    public static String[] m2688t(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = Util2.f6708a;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long m2689u(String str, b bVar) throws SubtitleDecoderException, NumberFormatException {
        double d;
        double d2;
        Matcher matcher = f6034n.matcher(str);
        char c2 = 4;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            double d3 = Long.parseLong(strGroup) * 3600;
            Objects.requireNonNull(matcher.group(2));
            Objects.requireNonNull(matcher.group(3));
            double d4 = d3 + (Long.parseLong(r13) * 60) + Long.parseLong(r13);
            String strGroup2 = matcher.group(4);
            return (long) ((d4 + (strGroup2 != null ? Double.parseDouble(strGroup2) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.f6045a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / bVar.f6046b) / bVar.f6045a : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f6035o.matcher(str);
        if (!matcher2.matches()) {
            String strValueOf = String.valueOf(str);
            throw new SubtitleDecoderException(strValueOf.length() != 0 ? "Malformed time expression: ".concat(strValueOf) : new String("Malformed time expression: "));
        }
        String strGroup3 = matcher2.group(1);
        Objects.requireNonNull(strGroup3);
        double d5 = Double.parseDouble(strGroup3);
        String strGroup4 = matcher2.group(2);
        Objects.requireNonNull(strGroup4);
        switch (strGroup4.hashCode()) {
            case 102:
                c2 = !strGroup4.equals("f") ? (char) 65535 : (char) 0;
                break;
            case 104:
                if (strGroup4.equals("h")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109:
                if (strGroup4.equals("m")) {
                    c2 = 2;
                    break;
                }
                break;
            case 116:
                if (strGroup4.equals("t")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3494:
                if (!strGroup4.equals("ms")) {
                }
                break;
        }
        switch (c2) {
            case 0:
                d = bVar.f6045a;
                d5 /= d;
                return (long) (d5 * 1000000.0d);
            case 1:
                d2 = 3600.0d;
                break;
            case 2:
                d2 = 60.0d;
                break;
            case 3:
                d = bVar.f6047c;
                d5 /= d;
                return (long) (d5 * 1000000.0d);
            case 4:
                d = 1000.0d;
                d5 /= d;
                return (long) (d5 * 1000000.0d);
            default:
                return (long) (d5 * 1000000.0d);
        }
        d5 *= d2;
        return (long) (d5 * 1000000.0d);
    }

    @Nullable
    /* renamed from: v */
    public static c m2690v(XmlPullParser xmlPullParser) {
        String strM564r0 = AnimatableValueParser.m564r0(xmlPullParser, "extent");
        if (strM564r0 == null) {
            return null;
        }
        Matcher matcher = f6039s.matcher(strM564r0);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", strM564r0.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(strM564r0) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            return new c(i, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", strM564r0.length() != 0 ? "Ignoring malformed tts extent: ".concat(strM564r0) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* renamed from: j */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException, NumberFormatException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f6043w.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            c cVarM2690v = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarM2684p = f6041u;
            a aVarM2682n = f6042v;
            TtmlSubtitle ttmlSubtitle = null;
            int i2 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarM2684p = m2684p(xmlPullParserNewPullParser);
                            aVarM2682n = m2682n(xmlPullParserNewPullParser, f6042v);
                            cVarM2690v = m2690v(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarM2690v;
                        b bVar2 = bVarM2684p;
                        a aVar = aVarM2682n;
                        if (!m2680l(name)) {
                            String strValueOf = String.valueOf(xmlPullParserNewPullParser.getName());
                            Log.i("TtmlDecoder", strValueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(strValueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            bVar = bVar2;
                        } else if ("head".equals(name)) {
                            bVar = bVar2;
                            m2685q(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                        } else {
                            bVar = bVar2;
                            try {
                                TtmlNode ttmlNodeM2686r = m2686r(xmlPullParserNewPullParser, ttmlNode, map2, bVar);
                                arrayDeque.push(ttmlNodeM2686r);
                                if (ttmlNode != null) {
                                    ttmlNode.m2693a(ttmlNodeM2686r);
                                }
                            } catch (SubtitleDecoderException e) {
                                Log2.m3040c("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                        bVarM2684p = bVar;
                        cVarM2690v = cVar;
                        aVarM2682n = aVar;
                    } else if (eventType == 4) {
                        Objects.requireNonNull(ttmlNode);
                        TtmlNode ttmlNodeM2691b = TtmlNode.m2691b(xmlPullParserNewPullParser.getText());
                        if (ttmlNode.f6062m == null) {
                            ttmlNode.f6062m = new ArrayList();
                        }
                        ttmlNode.f6062m.add(ttmlNodeM2691b);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.peek();
                            Objects.requireNonNull(ttmlNode2);
                            ttmlSubtitle = new TtmlSubtitle(ttmlNode2, map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
