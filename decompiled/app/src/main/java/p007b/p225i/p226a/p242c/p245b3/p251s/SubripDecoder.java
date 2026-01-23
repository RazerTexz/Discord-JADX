package p007b.p225i.p226a.p242c.p245b3.p251s;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* JADX INFO: renamed from: b.i.a.c.b3.s.a, reason: use source file name */
/* JADX INFO: compiled from: SubripDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder2 {

    /* JADX INFO: renamed from: n */
    public static final Pattern f6020n = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: o */
    public static final Pattern f6021o = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: p */
    public final StringBuilder f6022p;

    /* JADX INFO: renamed from: q */
    public final ArrayList<String> f6023q;

    public SubripDecoder() {
        super("SubripDecoder");
        this.f6022p = new StringBuilder();
        this.f6023q = new ArrayList<>();
    }

    /* JADX INFO: renamed from: k */
    public static float m2677k(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: l */
    public static long m2678l(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        Objects.requireNonNull(strGroup2);
        long j2 = (Long.parseLong(strGroup2) * 60 * 1000) + j;
        String strGroup3 = matcher.group(i + 3);
        Objects.requireNonNull(strGroup3);
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019f  */
    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) {
        ParsableByteArray parsableByteArray;
        String strM3087g;
        long[] jArr;
        ParsableByteArray parsableByteArray2;
        byte b2;
        int i2;
        byte b3;
        Cue cue;
        SubripDecoder subripDecoder = this;
        ArrayList arrayList = new ArrayList();
        long[] jArrCopyOf = new long[32];
        ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr, i);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String strM3087g2 = parsableByteArray3.m3087g();
            if (strM3087g2 != null) {
                if (strM3087g2.length() != 0) {
                    try {
                        Integer.parseInt(strM3087g2);
                        strM3087g = parsableByteArray3.m3087g();
                    } catch (NumberFormatException unused) {
                        parsableByteArray = parsableByteArray3;
                        Log.w("SubripDecoder", strM3087g2.length() != 0 ? "Skipping invalid index: ".concat(strM3087g2) : new String("Skipping invalid index: "));
                    }
                    if (strM3087g == null) {
                        Log.w("SubripDecoder", "Unexpected end");
                    } else {
                        Matcher matcher = f6020n.matcher(strM3087g);
                        if (matcher.matches()) {
                            long jM2678l = m2678l(matcher, 1);
                            if (i4 == jArrCopyOf.length) {
                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4 * 2);
                            }
                            int i5 = i4 + 1;
                            jArrCopyOf[i4] = jM2678l;
                            long jM2678l2 = m2678l(matcher, 6);
                            if (i5 == jArrCopyOf.length) {
                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i5 * 2);
                            }
                            int i6 = i5 + 1;
                            jArrCopyOf[i5] = jM2678l2;
                            subripDecoder.f6022p.setLength(i3);
                            subripDecoder.f6023q.clear();
                            for (String strM3087g3 = parsableByteArray3.m3087g(); !TextUtils.isEmpty(strM3087g3); strM3087g3 = parsableByteArray3.m3087g()) {
                                if (subripDecoder.f6022p.length() > 0) {
                                    subripDecoder.f6022p.append("<br>");
                                }
                                StringBuilder sb = subripDecoder.f6022p;
                                ArrayList<String> arrayList2 = subripDecoder.f6023q;
                                String strTrim = strM3087g3.trim();
                                StringBuilder sb2 = new StringBuilder(strTrim);
                                Matcher matcher2 = f6021o.matcher(strTrim);
                                int i7 = 0;
                                while (matcher2.find()) {
                                    String strGroup = matcher2.group();
                                    arrayList2.add(strGroup);
                                    int iStart = matcher2.start() - i7;
                                    int length = strGroup.length();
                                    sb2.replace(iStart, iStart + length, "");
                                    i7 += length;
                                }
                                sb.append(sb2.toString());
                            }
                            Spanned spannedFromHtml = Html.fromHtml(subripDecoder.f6022p.toString());
                            String str = null;
                            int i8 = 0;
                            while (true) {
                                if (i8 < subripDecoder.f6023q.size()) {
                                    String str2 = subripDecoder.f6023q.get(i8);
                                    if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                        str = str2;
                                    } else {
                                        i8++;
                                    }
                                }
                            }
                            if (str == null) {
                                cue = new Cue(spannedFromHtml, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                jArr = jArrCopyOf;
                                parsableByteArray2 = parsableByteArray3;
                                i2 = i6;
                            } else {
                                jArr = jArrCopyOf;
                                parsableByteArray2 = parsableByteArray3;
                                switch (str.hashCode()) {
                                    case -685620710:
                                        b2 = str.equals("{\\an1}") ? (byte) 0 : (byte) -1;
                                        break;
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            b2 = 6;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            b2 = 3;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            b2 = 1;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            b2 = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            b2 = 4;
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            b2 = 2;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            b2 = 8;
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            b2 = 5;
                                            break;
                                        }
                                        break;
                                }
                                i2 = i6;
                                int i9 = (b2 == 0 || b2 == 1 || b2 == 2) ? 0 : (b2 == 3 || b2 == 4 || b2 == 5) ? 2 : 1;
                                switch (str.hashCode()) {
                                    case -685620710:
                                        b3 = str.equals("{\\an1}") ? (byte) 0 : (byte) -1;
                                        break;
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            b3 = 1;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            b3 = 2;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            b3 = 6;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            b3 = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            b3 = 8;
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            b3 = 3;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            b3 = 4;
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            b3 = 5;
                                            break;
                                        }
                                        break;
                                }
                                int i10 = (b3 == 0 || b3 == 1 || b3 == 2) ? 2 : (b3 == 3 || b3 == 4 || b3 == 5) ? 0 : 1;
                                cue = new Cue(spannedFromHtml, null, null, null, m2677k(i10), 0, i10, m2677k(i9), i9, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                            }
                            arrayList.add(cue);
                            arrayList.add(Cue.f5754j);
                            subripDecoder = this;
                            jArrCopyOf = jArr;
                            parsableByteArray3 = parsableByteArray2;
                            i4 = i2;
                            i3 = 0;
                        } else {
                            parsableByteArray = parsableByteArray3;
                            Log.w("SubripDecoder", strM3087g.length() != 0 ? "Skipping invalid timing: ".concat(strM3087g) : new String("Skipping invalid timing: "));
                            subripDecoder = this;
                            parsableByteArray3 = parsableByteArray;
                            i3 = 0;
                        }
                    }
                }
            }
        }
        return new SubripSubtitle((Cue[]) arrayList.toArray(new Cue[0]), Arrays.copyOf(jArrCopyOf, i4));
    }
}
