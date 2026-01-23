package p007b.p225i.p226a.p242c.p245b3.p254v;

import android.text.TextUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.ColorParser2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.v.i, reason: use source file name */
/* JADX INFO: compiled from: WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttDecoder extends SimpleSubtitleDecoder2 {

    /* JADX INFO: renamed from: n */
    public final ParsableByteArray f6158n;

    /* JADX INFO: renamed from: o */
    public final WebvttCssParser f6159o;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.f6158n = new ParsableByteArray();
        this.f6159o = new WebvttCssParser();
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x0395, code lost:
    
        r0.addAll(r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        WebvttCueInfo webvttCueInfoM2713d;
        String strSubstring;
        String str;
        WebvttCssParser webvttCssParser;
        String string;
        byte b2;
        int i2;
        ParsableByteArray parsableByteArray = this.f6158n;
        parsableByteArray.f6793a = bArr;
        parsableByteArray.f6795c = i;
        int i3 = 0;
        parsableByteArray.f6794b = 0;
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.m2721c(this.f6158n);
            while (!TextUtils.isEmpty(this.f6158n.m3087g())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                ParsableByteArray parsableByteArray2 = this.f6158n;
                int i4 = -1;
                ?? r7 = 1;
                byte b3 = -1;
                int i5 = 0;
                while (b3 == -1) {
                    i5 = parsableByteArray2.f6794b;
                    String strM3087g = parsableByteArray2.m3087g();
                    b3 = strM3087g == null ? (byte) 0 : "STYLE".equals(strM3087g) ? (byte) 2 : strM3087g.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                }
                parsableByteArray2.m3079E(i5);
                if (b3 == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (b3 == 1) {
                    while (!TextUtils.isEmpty(this.f6158n.m3087g())) {
                    }
                } else {
                    if (b3 == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.f6158n.m3087g();
                        WebvttCssParser webvttCssParser2 = this.f6159o;
                        ParsableByteArray parsableByteArray3 = this.f6158n;
                        webvttCssParser2.f6113d.setLength(i3);
                        int i6 = parsableByteArray3.f6794b;
                        while (!TextUtils.isEmpty(parsableByteArray3.m3087g())) {
                        }
                        webvttCssParser2.f6112c.m3077C(parsableByteArray3.f6793a, parsableByteArray3.f6794b);
                        webvttCssParser2.f6112c.m3079E(i6);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            ParsableByteArray parsableByteArray4 = webvttCssParser2.f6112c;
                            StringBuilder sb = webvttCssParser2.f6113d;
                            WebvttCssParser.m2707c(parsableByteArray4);
                            if (parsableByteArray4.m3081a() >= 5 && "::cue".equals(parsableByteArray4.m3097q(5))) {
                                int i7 = parsableByteArray4.f6794b;
                                String strM2706b = WebvttCssParser.m2706b(parsableByteArray4, sb);
                                if (strM2706b != null) {
                                    if ("{".equals(strM2706b)) {
                                        parsableByteArray4.m3079E(i7);
                                        strSubstring = "";
                                    } else {
                                        if ("(".equals(strM2706b)) {
                                            int i8 = parsableByteArray4.f6794b;
                                            int i9 = parsableByteArray4.f6795c;
                                            boolean z3 = false;
                                            while (i8 < i9 && !z3) {
                                                int i10 = i8 + 1;
                                                z3 = ((char) parsableByteArray4.f6793a[i8]) == ')';
                                                i8 = i10;
                                            }
                                            strSubstring = parsableByteArray4.m3097q((i8 - 1) - parsableByteArray4.f6794b).trim();
                                        } else {
                                            strSubstring = null;
                                        }
                                        if (!")".equals(WebvttCssParser.m2706b(parsableByteArray4, sb))) {
                                            strSubstring = null;
                                        }
                                    }
                                    if (strSubstring == null || !"{".equals(WebvttCssParser.m2706b(webvttCssParser2.f6112c, webvttCssParser2.f6113d))) {
                                        break;
                                    }
                                    WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
                                    if (!"".equals(strSubstring)) {
                                        int iIndexOf = strSubstring.indexOf(91);
                                        if (iIndexOf != i4) {
                                            Matcher matcher = WebvttCssParser.f6110a.matcher(strSubstring.substring(iIndexOf));
                                            if (matcher.matches()) {
                                                String strGroup = matcher.group((int) r7);
                                                Objects.requireNonNull(strGroup);
                                                webvttCssStyle.f6117d = strGroup;
                                            }
                                            strSubstring = strSubstring.substring(i3, iIndexOf);
                                        }
                                        String[] strArrM2987H = Util2.m2987H(strSubstring, "\\.");
                                        String str2 = strArrM2987H[i3];
                                        int iIndexOf2 = str2.indexOf(35);
                                        if (iIndexOf2 != i4) {
                                            webvttCssStyle.f6115b = str2.substring(i3, iIndexOf2);
                                            webvttCssStyle.f6114a = str2.substring(iIndexOf2 + 1);
                                        } else {
                                            webvttCssStyle.f6115b = str2;
                                        }
                                        if (strArrM2987H.length > r7) {
                                            int length = strArrM2987H.length;
                                            AnimatableValueParser.m531j(r7);
                                            AnimatableValueParser.m531j(length <= strArrM2987H.length);
                                            webvttCssStyle.f6116c = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrM2987H, (int) r7, length)));
                                        }
                                    }
                                    boolean z4 = false;
                                    String str3 = null;
                                    while (!z4) {
                                        ParsableByteArray parsableByteArray5 = webvttCssParser2.f6112c;
                                        int i11 = parsableByteArray5.f6794b;
                                        String strM2706b2 = WebvttCssParser.m2706b(parsableByteArray5, webvttCssParser2.f6113d);
                                        boolean z5 = strM2706b2 == null || "}".equals(strM2706b2);
                                        if (!z5) {
                                            webvttCssParser2.f6112c.m3079E(i11);
                                            ParsableByteArray parsableByteArray6 = webvttCssParser2.f6112c;
                                            StringBuilder sb2 = webvttCssParser2.f6113d;
                                            WebvttCssParser.m2707c(parsableByteArray6);
                                            String strM2705a = WebvttCssParser.m2705a(parsableByteArray6, sb2);
                                            if (!"".equals(strM2705a) && ":".equals(WebvttCssParser.m2706b(parsableByteArray6, sb2))) {
                                                WebvttCssParser.m2707c(parsableByteArray6);
                                                StringBuilder sb3 = new StringBuilder();
                                                boolean z6 = false;
                                                while (true) {
                                                    if (z6) {
                                                        str = strM2706b2;
                                                        webvttCssParser = webvttCssParser2;
                                                        string = sb3.toString();
                                                        break;
                                                    }
                                                    str = strM2706b2;
                                                    int i12 = parsableByteArray6.f6794b;
                                                    webvttCssParser = webvttCssParser2;
                                                    String strM2706b3 = WebvttCssParser.m2706b(parsableByteArray6, sb2);
                                                    if (strM2706b3 == null) {
                                                        string = null;
                                                        break;
                                                    }
                                                    if ("}".equals(strM2706b3) || ";".equals(strM2706b3)) {
                                                        parsableByteArray6.m3079E(i12);
                                                        z6 = true;
                                                    } else {
                                                        sb3.append(strM2706b3);
                                                    }
                                                    strM2706b2 = str;
                                                    webvttCssParser2 = webvttCssParser;
                                                }
                                                if (string != null && !"".equals(string)) {
                                                    int i13 = parsableByteArray6.f6794b;
                                                    String strM2706b4 = WebvttCssParser.m2706b(parsableByteArray6, sb2);
                                                    if (";".equals(strM2706b4)) {
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strM2705a)) {
                                                        }
                                                    } else if ("}".equals(strM2706b4)) {
                                                        parsableByteArray6.m3079E(i13);
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strM2705a)) {
                                                            webvttCssStyle.f6119f = ColorParser2.m3024a(string, true);
                                                            webvttCssStyle.f6120g = true;
                                                        } else if ("background-color".equals(strM2705a)) {
                                                            webvttCssStyle.f6121h = ColorParser2.m3024a(string, true);
                                                            webvttCssStyle.f6122i = true;
                                                        } else if ("ruby-position".equals(strM2705a)) {
                                                            if ("over".equals(string)) {
                                                                webvttCssStyle.f6129p = 1;
                                                            } else if ("under".equals(string)) {
                                                                webvttCssStyle.f6129p = 2;
                                                            }
                                                        } else if ("text-combine-upright".equals(strM2705a)) {
                                                            webvttCssStyle.f6130q = "all".equals(string) || string.startsWith("digits");
                                                        } else if ("text-decoration".equals(strM2705a)) {
                                                            if ("underline".equals(string)) {
                                                                webvttCssStyle.f6124k = 1;
                                                            }
                                                        } else if ("font-family".equals(strM2705a)) {
                                                            webvttCssStyle.f6118e = C3404f.m4349u1(string);
                                                        } else if ("font-weight".equals(strM2705a)) {
                                                            if ("bold".equals(string)) {
                                                                webvttCssStyle.f6125l = 1;
                                                            }
                                                        } else if ("font-style".equals(strM2705a)) {
                                                            if ("italic".equals(string)) {
                                                                webvttCssStyle.f6126m = 1;
                                                            }
                                                        } else if ("font-size".equals(strM2705a)) {
                                                            Matcher matcher2 = WebvttCssParser.f6111b.matcher(C3404f.m4349u1(string));
                                                            if (matcher2.matches()) {
                                                                String strGroup2 = matcher2.group(2);
                                                                Objects.requireNonNull(strGroup2);
                                                                int iHashCode = strGroup2.hashCode();
                                                                if (iHashCode == 37) {
                                                                    if (strGroup2.equals("%")) {
                                                                        b2 = 0;
                                                                    }
                                                                    if (b2 != 0) {
                                                                    }
                                                                    String strGroup3 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup3);
                                                                    webvttCssStyle.f6128o = Float.parseFloat(strGroup3);
                                                                } else if (iHashCode != 3240) {
                                                                    b2 = (iHashCode == 3592 && strGroup2.equals("px")) ? (byte) 2 : (byte) -1;
                                                                    if (b2 != 0) {
                                                                        i2 = 1;
                                                                        if (b2 == 1) {
                                                                            webvttCssStyle.f6127n = 2;
                                                                        } else {
                                                                            if (b2 != 2) {
                                                                                throw new IllegalStateException();
                                                                            }
                                                                            webvttCssStyle.f6127n = 1;
                                                                        }
                                                                    } else {
                                                                        i2 = 1;
                                                                        webvttCssStyle.f6127n = 3;
                                                                    }
                                                                    String strGroup32 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup32);
                                                                    webvttCssStyle.f6128o = Float.parseFloat(strGroup32);
                                                                } else {
                                                                    if (strGroup2.equals("em")) {
                                                                        b2 = 1;
                                                                    }
                                                                    if (b2 != 0) {
                                                                    }
                                                                    String strGroup322 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup322);
                                                                    webvttCssStyle.f6128o = Float.parseFloat(strGroup322);
                                                                }
                                                            } else {
                                                                outline.m856i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            } else {
                                                str = strM2706b2;
                                                webvttCssParser = webvttCssParser2;
                                            }
                                        }
                                        str3 = str;
                                        webvttCssParser2 = webvttCssParser;
                                        z4 = z5;
                                    }
                                    WebvttCssParser webvttCssParser3 = webvttCssParser2;
                                    if ("}".equals(str3)) {
                                        arrayList3.add(webvttCssStyle);
                                    }
                                    i3 = 0;
                                    i4 = -1;
                                    r7 = 1;
                                    webvttCssParser2 = webvttCssParser3;
                                }
                            }
                        }
                    } else if (b3 == 3) {
                        ParsableByteArray parsableByteArray7 = this.f6158n;
                        Pattern pattern = WebvttCueParser.f6134a;
                        String strM3087g2 = parsableByteArray7.m3087g();
                        if (strM3087g2 == null) {
                            webvttCueInfoM2713d = null;
                        } else {
                            Pattern pattern2 = WebvttCueParser.f6134a;
                            Matcher matcher3 = pattern2.matcher(strM3087g2);
                            if (matcher3.matches()) {
                                webvttCueInfoM2713d = WebvttCueParser.m2713d(null, matcher3, parsableByteArray7, arrayList);
                            } else {
                                String strM3087g3 = parsableByteArray7.m3087g();
                                if (strM3087g3 == null) {
                                    webvttCueInfoM2713d = null;
                                } else {
                                    Matcher matcher4 = pattern2.matcher(strM3087g3);
                                    if (matcher4.matches()) {
                                        webvttCueInfoM2713d = WebvttCueParser.m2713d(strM3087g2.trim(), matcher4, parsableByteArray7, arrayList);
                                    }
                                }
                            }
                        }
                        if (webvttCueInfoM2713d != null) {
                            arrayList2.add(webvttCueInfoM2713d);
                        }
                    }
                    i3 = 0;
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
