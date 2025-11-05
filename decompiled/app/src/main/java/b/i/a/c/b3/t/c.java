package b.i.a.c.b3.t;

import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.i;
import b.i.a.c.f3.q;
import b.i.b.b.h;
import b.i.b.b.n0;
import b.i.b.b.p0;
import b.i.b.b.r;
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

/* compiled from: TtmlDecoder.java */
/* loaded from: classes3.dex */
public final class c extends b.i.a.c.b3.f {
    public static final Pattern n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f880s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern t = Pattern.compile("^(\\d+) (\\d+)$");
    public static final b u = new b(30.0f, 1, 1);
    public static final a v = new a(32, 15);
    public final XmlPullParserFactory w;

    /* compiled from: TtmlDecoder.java */
    public static final class a {
        public final int a;

        public a(int i, int i2) {
            this.a = i2;
        }
    }

    /* compiled from: TtmlDecoder.java */
    public static final class b {
        public final float a;

        /* renamed from: b, reason: collision with root package name */
        public final int f881b;
        public final int c;

        public b(float f, int i, int i2) {
            this.a = f;
            this.f881b = i;
            this.c = i2;
        }
    }

    /* compiled from: TtmlDecoder.java */
    /* renamed from: b.i.a.c.b3.t.c$c, reason: collision with other inner class name */
    public static final class C0097c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f882b;

        public C0097c(int i, int i2) {
            this.a = i;
            this.f882b = i2;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.w = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static f k(@Nullable f fVar) {
        return fVar == null ? new f() : fVar;
    }

    public static boolean l(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment m(String str) {
        String strU1 = b.i.a.f.e.o.f.u1(str);
        strU1.hashCode();
        switch (strU1) {
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

    public static a n(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = t.matcher(attributeValue);
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

    public static void o(String str, f fVar) throws SubtitleDecoderException {
        Matcher matcher;
        String strGroup;
        int i = e0.a;
        String[] strArrSplit = str.split("\\s+", -1);
        if (strArrSplit.length == 1) {
            matcher = p.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                int length = strArrSplit.length;
                StringBuilder sb = new StringBuilder(52);
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(length);
                sb.append(".");
                throw new SubtitleDecoderException(sb.toString());
            }
            matcher = p.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(b.d.b.a.a.k(str.length() + 36, "Invalid expression for fontSize: '", str, "'."));
        }
        strGroup = matcher.group(3);
        Objects.requireNonNull(strGroup);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                fVar.j = 3;
                break;
            case "em":
                fVar.j = 2;
                break;
            case "px":
                fVar.j = 1;
                break;
            default:
                throw new SubtitleDecoderException(b.d.b.a.a.k(strGroup.length() + 30, "Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        Objects.requireNonNull(strGroup2);
        fVar.k = Float.parseFloat(strGroup2);
    }

    public static b p(XmlPullParser xmlPullParser) throws SubtitleDecoderException, NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i2 = e0.a;
            if (attributeValue2.split(" ", -1).length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        }
        b bVar = u;
        int i3 = bVar.f881b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.c;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, f> q(XmlPullParser xmlPullParser, Map<String, f> map, a aVar, @Nullable C0097c c0097c, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        String strR0;
        e eVar;
        float f;
        float f2;
        String strR02;
        float f3;
        float f4;
        String strR03;
        float f5;
        int i;
        char c;
        do {
            xmlPullParser.next();
            if (b.c.a.a0.d.Y0(xmlPullParser, "style")) {
                String strR04 = b.c.a.a0.d.r0(xmlPullParser, "style");
                f fVarS = s(xmlPullParser, new f());
                if (strR04 != null) {
                    for (String str : t(strR04)) {
                        fVarS.a(map.get(str));
                    }
                }
                String str2 = fVarS.l;
                if (str2 != null) {
                    map.put(str2, fVarS);
                }
            } else if (b.c.a.a0.d.Y0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                String strR05 = b.c.a.a0.d.r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID);
                if (strR05 != null) {
                    String strR06 = b.c.a.a0.d.r0(xmlPullParser, "origin");
                    if (strR06 != null) {
                        Pattern pattern = r;
                        Matcher matcher = pattern.matcher(strR06);
                        Pattern pattern2 = f880s;
                        Matcher matcher2 = pattern2.matcher(strR06);
                        if (matcher.matches()) {
                            try {
                                String strGroup = matcher.group(1);
                                Objects.requireNonNull(strGroup);
                                f = Float.parseFloat(strGroup) / 100.0f;
                                String strGroup2 = matcher.group(2);
                                Objects.requireNonNull(strGroup2);
                                f2 = Float.parseFloat(strGroup2) / 100.0f;
                                strR02 = b.c.a.a0.d.r0(xmlPullParser, "extent");
                            } catch (NumberFormatException unused) {
                                Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with malformed origin: ".concat(strR06) : new String("Ignoring region with malformed origin: "));
                            }
                            if (strR02 == null) {
                                Matcher matcher3 = pattern.matcher(strR02);
                                Matcher matcher4 = pattern2.matcher(strR02);
                                if (matcher3.matches()) {
                                    try {
                                        String strGroup3 = matcher3.group(1);
                                        Objects.requireNonNull(strGroup3);
                                        float f6 = Float.parseFloat(strGroup3) / 100.0f;
                                        String strGroup4 = matcher3.group(2);
                                        Objects.requireNonNull(strGroup4);
                                        f3 = Float.parseFloat(strGroup4) / 100.0f;
                                        f4 = f6;
                                        strR03 = b.c.a.a0.d.r0(xmlPullParser, "displayAlign");
                                        if (strR03 == null) {
                                            String strU1 = b.i.a.f.e.o.f.u1(strR03);
                                            strU1.hashCode();
                                            if (strU1.equals("center")) {
                                                f5 = (f3 / 2.0f) + f2;
                                                i = 1;
                                            } else if (strU1.equals("after")) {
                                                f5 = f2 + f3;
                                                i = 2;
                                            } else {
                                                f5 = f2;
                                                i = 0;
                                            }
                                            float f7 = 1.0f / aVar.a;
                                            String strR07 = b.c.a.a0.d.r0(xmlPullParser, "writingMode");
                                            if (strR07 != null) {
                                                String strU12 = b.i.a.f.e.o.f.u1(strR07);
                                                strU12.hashCode();
                                                int iHashCode = strU12.hashCode();
                                                if (iHashCode == 3694) {
                                                    if (strU12.equals("tb")) {
                                                        c = 0;
                                                    }
                                                    if (c == 0) {
                                                    }
                                                } else if (iHashCode != 3553396) {
                                                    c = (iHashCode == 3553576 && strU12.equals("tbrl")) ? (char) 2 : (char) 65535;
                                                    int i2 = (c == 0 || c == 1) ? 2 : c != 2 ? Integer.MIN_VALUE : 1;
                                                    eVar = new e(strR05, f, f5, 0, i, f4, f3, 1, f7, i2);
                                                } else {
                                                    if (strU12.equals("tblr")) {
                                                        c = 1;
                                                    }
                                                    if (c == 0) {
                                                        eVar = new e(strR05, f, f5, 0, i, f4, f3, 1, f7, i2);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (NumberFormatException unused2) {
                                        Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with malformed extent: ".concat(strR06) : new String("Ignoring region with malformed extent: "));
                                    }
                                } else if (!matcher4.matches()) {
                                    Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with unsupported extent: ".concat(strR06) : new String("Ignoring region with unsupported extent: "));
                                } else if (c0097c == null) {
                                    Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strR06) : new String("Ignoring region with missing tts:extent: "));
                                } else {
                                    try {
                                        String strGroup5 = matcher4.group(1);
                                        Objects.requireNonNull(strGroup5);
                                        int i3 = Integer.parseInt(strGroup5);
                                        String strGroup6 = matcher4.group(2);
                                        Objects.requireNonNull(strGroup6);
                                        f4 = i3 / c0097c.a;
                                        f3 = Integer.parseInt(strGroup6) / c0097c.f882b;
                                        strR03 = b.c.a.a0.d.r0(xmlPullParser, "displayAlign");
                                        if (strR03 == null) {
                                        }
                                    } catch (NumberFormatException unused3) {
                                        Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with malformed extent: ".concat(strR06) : new String("Ignoring region with malformed extent: "));
                                    }
                                }
                                if (eVar != null) {
                                    map2.put(eVar.a, eVar);
                                }
                            } else {
                                Log.w("TtmlDecoder", "Ignoring region without an extent");
                            }
                        } else if (!matcher2.matches()) {
                            Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with unsupported origin: ".concat(strR06) : new String("Ignoring region with unsupported origin: "));
                        } else if (c0097c == null) {
                            Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strR06) : new String("Ignoring region with missing tts:extent: "));
                        } else {
                            try {
                                String strGroup7 = matcher2.group(1);
                                Objects.requireNonNull(strGroup7);
                                int i4 = Integer.parseInt(strGroup7);
                                String strGroup8 = matcher2.group(2);
                                Objects.requireNonNull(strGroup8);
                                float f8 = i4 / c0097c.a;
                                float f9 = Integer.parseInt(strGroup8) / c0097c.f882b;
                                f = f8;
                                f2 = f9;
                                strR02 = b.c.a.a0.d.r0(xmlPullParser, "extent");
                                if (strR02 == null) {
                                }
                            } catch (NumberFormatException unused4) {
                                Log.w("TtmlDecoder", strR06.length() != 0 ? "Ignoring region with malformed origin: ".concat(strR06) : new String("Ignoring region with malformed origin: "));
                            }
                        }
                    } else {
                        Log.w("TtmlDecoder", "Ignoring region without an origin");
                    }
                    eVar = null;
                    if (eVar != null) {
                    }
                } else {
                    eVar = null;
                    if (eVar != null) {
                    }
                }
            } else if (b.c.a.a0.d.Y0(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (b.c.a.a0.d.Y0(xmlPullParser, "image") && (strR0 = b.c.a.a0.d.r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID)) != null) {
                        map3.put(strR0, xmlPullParser.nextText());
                    }
                } while (!b.c.a.a0.d.R0(xmlPullParser, "metadata"));
            }
        } while (!b.c.a.a0.d.R0(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d r(XmlPullParser xmlPullParser, @Nullable d dVar, Map<String, e> map, b bVar) throws SubtitleDecoderException, NumberFormatException {
        long j;
        long j2;
        char c;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser.getAttributeCount();
        f fVarS = s(xmlPullParser2, null);
        String strSubstring = null;
        String str = "";
        long jU = -9223372036854775807L;
        long jU2 = -9223372036854775807L;
        long jU3 = -9223372036854775807L;
        String[] strArr = null;
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (!attributeName.equals(ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                        c = 65535;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c == 1) {
                    jU3 = u(attributeValue, bVar);
                } else if (c == 2) {
                    jU2 = u(attributeValue, bVar);
                } else if (c == 3) {
                    jU = u(attributeValue, bVar);
                } else if (c == 4) {
                    String[] strArrT = t(attributeValue);
                    if (strArrT.length > 0) {
                        strArr = strArrT;
                    }
                } else if (c == 5 && attributeValue.startsWith("#")) {
                    strSubstring = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str = attributeValue;
            }
            i++;
            xmlPullParser2 = xmlPullParser;
        }
        if (dVar != null) {
            long j3 = dVar.d;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jU != -9223372036854775807L) {
                    jU += j3;
                }
                if (jU2 != -9223372036854775807L) {
                    jU2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (jU2 != j) {
            j2 = jU2;
        } else if (jU3 != j) {
            j2 = jU + jU3;
        } else if (dVar != null) {
            long j4 = dVar.e;
            if (j4 != j) {
                j2 = j4;
            }
        }
        return new d(xmlPullParser.getName(), null, jU, j2, fVarS, strArr, str, strSubstring, dVar);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f s(XmlPullParser xmlPullParser, f fVar) {
        String attributeValue;
        int i;
        char c;
        char c2;
        h.a aVar;
        char c3;
        int iHashCode;
        b.i.a.c.b3.t.b bVar;
        int attributeCount = xmlPullParser.getAttributeCount();
        f fVarK = fVar;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            attributeName.hashCode();
            c = 1;
            switch (attributeName) {
                case "fontStyle":
                    fVarK = k(fVarK);
                    fVarK.i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "fontFamily":
                    fVarK = k(fVarK);
                    fVarK.a = attributeValue;
                    break;
                case "textAlign":
                    fVarK = k(fVarK);
                    fVarK.o = m(attributeValue);
                    break;
                case "textDecoration":
                    String strU1 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU1.hashCode();
                    switch (strU1.hashCode()) {
                        case -1461280213:
                            if (strU1.equals("nounderline")) {
                                i = 0;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (strU1.equals("underline")) {
                                i = 1;
                                break;
                            }
                            break;
                        case 913457136:
                            if (strU1.equals("nolinethrough")) {
                                i = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (strU1.equals("linethrough")) {
                                i = 3;
                                break;
                            }
                            break;
                    }
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    break;
                                } else {
                                    fVarK = k(fVarK);
                                    fVarK.f = 1;
                                    break;
                                }
                            } else {
                                fVarK = k(fVarK);
                                fVarK.f = 0;
                                break;
                            }
                        } else {
                            fVarK = k(fVarK);
                            fVarK.g = 1;
                            break;
                        }
                    } else {
                        fVarK = k(fVarK);
                        fVarK.g = 0;
                        break;
                    }
                case "fontWeight":
                    fVarK = k(fVarK);
                    fVarK.h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "id":
                    if ("style".equals(xmlPullParser.getName())) {
                        fVarK = k(fVarK);
                        fVarK.l = attributeValue;
                        break;
                    } else {
                        break;
                    }
                case "ruby":
                    String strU12 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU12.hashCode();
                    switch (strU12.hashCode()) {
                        case -618561360:
                            if (strU12.equals("baseContainer")) {
                                i = 0;
                                break;
                            }
                            break;
                        case -410956671:
                            if (strU12.equals("container")) {
                                i = 1;
                                break;
                            }
                            break;
                        case -250518009:
                            if (strU12.equals("delimiter")) {
                                i = 2;
                                break;
                            }
                            break;
                        case -136074796:
                            if (strU12.equals("textContainer")) {
                                i = 3;
                                break;
                            }
                            break;
                        case 3016401:
                            if (strU12.equals("base")) {
                                i = 4;
                                break;
                            }
                            break;
                        case 3556653:
                            if (strU12.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                                i = 5;
                                break;
                            }
                            break;
                    }
                    if (i == 0) {
                        fVarK = k(fVarK);
                        fVarK.m = 2;
                        break;
                    } else if (i == 1) {
                        fVarK = k(fVarK);
                        fVarK.m = 1;
                        break;
                    } else if (i == 2) {
                        fVarK = k(fVarK);
                        fVarK.m = 4;
                        break;
                    } else if (i == 3) {
                        fVarK = k(fVarK);
                        fVarK.m = 3;
                        break;
                    } else if (i != 4) {
                        if (i != 5) {
                            break;
                        }
                    }
                case "color":
                    fVarK = k(fVarK);
                    try {
                        fVarK.f885b = i.a(attributeValue, false);
                        fVarK.c = true;
                        break;
                    } catch (IllegalArgumentException unused) {
                        String strValueOf = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf.length() != 0 ? "Failed parsing color value: ".concat(strValueOf) : new String("Failed parsing color value: "));
                        break;
                    }
                case "shear":
                    f fVarK2 = k(fVarK);
                    Matcher matcher = q.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(1);
                            Objects.requireNonNull(strGroup);
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                        } catch (NumberFormatException e) {
                            String strValueOf2 = String.valueOf(attributeValue);
                            q.c("TtmlDecoder", strValueOf2.length() != 0 ? "Failed to parse shear: ".concat(strValueOf2) : new String("Failed to parse shear: "), e);
                        }
                    } else {
                        String strValueOf3 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf3.length() != 0 ? "Invalid value for shear: ".concat(strValueOf3) : new String("Invalid value for shear: "));
                    }
                    fVarK2.f886s = fMin;
                    fVarK = fVarK2;
                    break;
                case "textCombine":
                    String strU13 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU13.hashCode();
                    if (strU13.equals("all")) {
                        fVarK = k(fVarK);
                        fVarK.q = 1;
                        break;
                    } else if (strU13.equals("none")) {
                        fVarK = k(fVarK);
                        fVarK.q = 0;
                        break;
                    } else {
                        break;
                    }
                case "fontSize":
                    try {
                        fVarK = k(fVarK);
                        o(attributeValue, fVarK);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        String strValueOf4 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf4.length() != 0 ? "Failed parsing fontSize value: ".concat(strValueOf4) : new String("Failed parsing fontSize value: "));
                        break;
                    }
                case "textEmphasis":
                    fVarK = k(fVarK);
                    Pattern pattern = b.i.a.c.b3.t.b.a;
                    b.i.a.c.b3.t.b bVar2 = null;
                    if (attributeValue != null) {
                        String strU14 = b.i.a.f.e.o.f.u1(attributeValue.trim());
                        if (!strU14.isEmpty()) {
                            r rVarN = r.n(TextUtils.split(strU14, b.i.a.c.b3.t.b.a));
                            String str = (String) b.i.a.f.e.o.f.k0(h.b(b.i.a.c.b3.t.b.e, rVarN), "outside");
                            int iHashCode2 = str.hashCode();
                            if (iHashCode2 == -1392885889) {
                                if (str.equals("before")) {
                                    c2 = 2;
                                }
                                if (c2 != 0) {
                                }
                                aVar = (h.a) h.b(b.i.a.c.b3.t.b.f879b, rVarN);
                                if (aVar.isEmpty()) {
                                }
                                bVar2 = bVar;
                            } else if (iHashCode2 != -1106037339) {
                                c2 = (iHashCode2 == 92734940 && str.equals("after")) ? (char) 0 : (char) 65535;
                                int i3 = c2 != 0 ? c2 != 1 ? 1 : -2 : 2;
                                aVar = (h.a) h.b(b.i.a.c.b3.t.b.f879b, rVarN);
                                if (aVar.isEmpty()) {
                                    p0 p0VarB = h.b(b.i.a.c.b3.t.b.d, rVarN);
                                    p0 p0VarB2 = h.b(b.i.a.c.b3.t.b.c, rVarN);
                                    if (((h.a) p0VarB).isEmpty() && ((h.a) p0VarB2).isEmpty()) {
                                        bVar = new b.i.a.c.b3.t.b(-1, 0, i3);
                                    } else {
                                        String str2 = (String) b.i.a.f.e.o.f.k0(p0VarB, "filled");
                                        int iHashCode3 = str2.hashCode();
                                        if (iHashCode3 != -1274499742) {
                                            c3 = (iHashCode3 == 3417674 && str2.equals("open")) ? (char) 0 : (char) 65535;
                                            int i4 = c3 == 0 ? 1 : 2;
                                            String str3 = (String) b.i.a.f.e.o.f.k0(p0VarB2, "circle");
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
                                            bVar = new b.i.a.c.b3.t.b(i == 0 ? i != 1 ? 1 : 3 : 2, i4, i3);
                                        } else {
                                            if (str2.equals("filled")) {
                                                c3 = 1;
                                            }
                                            if (c3 == 0) {
                                            }
                                            String str32 = (String) b.i.a.f.e.o.f.k0(p0VarB2, "circle");
                                            iHashCode = str32.hashCode();
                                            if (iHashCode == -1360216880) {
                                            }
                                            bVar = new b.i.a.c.b3.t.b(i == 0 ? i != 1 ? 1 : 3 : 2, i4, i3);
                                        }
                                    }
                                } else {
                                    String str4 = (String) new n0(aVar).next();
                                    int iHashCode4 = str4.hashCode();
                                    if (iHashCode4 != 3005871) {
                                        c = (iHashCode4 == 3387192 && str4.equals("none")) ? (char) 0 : (char) 65535;
                                        bVar = new b.i.a.c.b3.t.b(c == 0 ? 0 : -1, 0, i3);
                                    } else {
                                        if (!str4.equals("auto")) {
                                        }
                                        bVar = new b.i.a.c.b3.t.b(c == 0 ? 0 : -1, 0, i3);
                                    }
                                }
                                bVar2 = bVar;
                            } else {
                                if (str.equals("outside")) {
                                    c2 = 1;
                                }
                                if (c2 != 0) {
                                }
                                aVar = (h.a) h.b(b.i.a.c.b3.t.b.f879b, rVarN);
                                if (aVar.isEmpty()) {
                                }
                                bVar2 = bVar;
                            }
                        }
                    }
                    fVarK.r = bVar2;
                    break;
                case "rubyPosition":
                    String strU15 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU15.hashCode();
                    if (strU15.equals("before")) {
                        fVarK = k(fVarK);
                        fVarK.n = 1;
                        break;
                    } else if (strU15.equals("after")) {
                        fVarK = k(fVarK);
                        fVarK.n = 2;
                        break;
                    } else {
                        break;
                    }
                case "backgroundColor":
                    fVarK = k(fVarK);
                    try {
                        fVarK.d = i.a(attributeValue, false);
                        fVarK.e = true;
                        break;
                    } catch (IllegalArgumentException unused3) {
                        String strValueOf5 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf5.length() != 0 ? "Failed parsing background value: ".concat(strValueOf5) : new String("Failed parsing background value: "));
                        break;
                    }
                case "multiRowAlign":
                    fVarK = k(fVarK);
                    fVarK.p = m(attributeValue);
                    break;
            }
        }
        return fVarK;
    }

    public static String[] t(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = e0.a;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long u(String str, b bVar) throws SubtitleDecoderException, NumberFormatException {
        double d;
        double d2;
        Matcher matcher = n.matcher(str);
        char c = 4;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            double d3 = Long.parseLong(strGroup) * 3600;
            Objects.requireNonNull(matcher.group(2));
            double d4 = d3 + (Long.parseLong(r13) * 60);
            Objects.requireNonNull(matcher.group(3));
            double d5 = d4 + Long.parseLong(r13);
            String strGroup2 = matcher.group(4);
            return (long) ((d5 + (strGroup2 != null ? Double.parseDouble(strGroup2) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / bVar.f881b) / bVar.a : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = o.matcher(str);
        if (!matcher2.matches()) {
            String strValueOf = String.valueOf(str);
            throw new SubtitleDecoderException(strValueOf.length() != 0 ? "Malformed time expression: ".concat(strValueOf) : new String("Malformed time expression: "));
        }
        String strGroup3 = matcher2.group(1);
        Objects.requireNonNull(strGroup3);
        double d6 = Double.parseDouble(strGroup3);
        String strGroup4 = matcher2.group(2);
        Objects.requireNonNull(strGroup4);
        switch (strGroup4.hashCode()) {
            case 102:
                if (!strGroup4.equals("f")) {
                    c = 65535;
                    break;
                } else {
                    c = 0;
                    break;
                }
            case 104:
                if (strGroup4.equals("h")) {
                    c = 1;
                    break;
                }
                break;
            case 109:
                if (strGroup4.equals("m")) {
                    c = 2;
                    break;
                }
                break;
            case 116:
                if (strGroup4.equals("t")) {
                    c = 3;
                    break;
                }
                break;
            case 3494:
                if (!strGroup4.equals("ms")) {
                }
                break;
        }
        switch (c) {
            case 0:
                d = bVar.a;
                d6 /= d;
                return (long) (d6 * 1000000.0d);
            case 1:
                d2 = 3600.0d;
                break;
            case 2:
                d2 = 60.0d;
                break;
            case 3:
                d = bVar.c;
                d6 /= d;
                return (long) (d6 * 1000000.0d);
            case 4:
                d = 1000.0d;
                d6 /= d;
                return (long) (d6 * 1000000.0d);
            default:
                return (long) (d6 * 1000000.0d);
        }
        d6 *= d2;
        return (long) (d6 * 1000000.0d);
    }

    @Nullable
    public static C0097c v(XmlPullParser xmlPullParser) {
        String strR0 = b.c.a.a0.d.r0(xmlPullParser, "extent");
        if (strR0 == null) {
            return null;
        }
        Matcher matcher = f880s.matcher(strR0);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", strR0.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(strR0) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            return new C0097c(i, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", strR0.length() != 0 ? "Ignoring malformed tts extent: ".concat(strR0) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // b.i.a.c.b3.f
    public b.i.a.c.b3.g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException, NumberFormatException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.w.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            C0097c c0097cV = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarP = u;
            a aVarN = v;
            g gVar = null;
            int i2 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarP = p(xmlPullParserNewPullParser);
                            aVarN = n(xmlPullParserNewPullParser, v);
                            c0097cV = v(xmlPullParserNewPullParser);
                        }
                        C0097c c0097c = c0097cV;
                        b bVar2 = bVarP;
                        a aVar = aVarN;
                        if (!l(name)) {
                            String strValueOf = String.valueOf(xmlPullParserNewPullParser.getName());
                            Log.i("TtmlDecoder", strValueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(strValueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            bVar = bVar2;
                        } else if ("head".equals(name)) {
                            bVar = bVar2;
                            q(xmlPullParserNewPullParser, map, aVar, c0097c, map2, map3);
                        } else {
                            bVar = bVar2;
                            try {
                                d dVarR = r(xmlPullParserNewPullParser, dVar, map2, bVar);
                                arrayDeque.push(dVarR);
                                if (dVar != null) {
                                    dVar.a(dVarR);
                                }
                            } catch (SubtitleDecoderException e) {
                                q.c("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                        bVarP = bVar;
                        c0097cV = c0097c;
                        aVarN = aVar;
                    } else if (eventType == 4) {
                        Objects.requireNonNull(dVar);
                        d dVarB = d.b(xmlPullParserNewPullParser.getText());
                        if (dVar.m == null) {
                            dVar.m = new ArrayList();
                        }
                        dVar.m.add(dVarB);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            d dVar2 = (d) arrayDeque.peek();
                            Objects.requireNonNull(dVar2);
                            gVar = new g(dVar2, map, map2, map3);
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
            if (gVar != null) {
                return gVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
