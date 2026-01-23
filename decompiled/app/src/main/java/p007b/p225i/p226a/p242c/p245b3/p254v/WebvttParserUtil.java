package p007b.p225i.p226a.p242c.p245b3.p254v;

import com.google.android.exoplayer2.ParserException;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.v.j, reason: use source file name */
/* JADX INFO: compiled from: WebvttParserUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttParserUtil {
    static {
        Pattern.compile("^NOTE([ \t].*)?$");
    }

    /* JADX INFO: renamed from: a */
    public static float m2719a(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    /* JADX INFO: renamed from: b */
    public static long m2720b(String str) throws NumberFormatException {
        int i = Util2.f6708a;
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str2 : Util2.m2987H(strArrSplit[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            j2 += Long.parseLong(strArrSplit[1]);
        }
        return j2 * 1000;
    }

    /* JADX INFO: renamed from: c */
    public static void m2721c(ParsableByteArray parsableByteArray) throws ParserException {
        int i = parsableByteArray.f6794b;
        String strM3087g = parsableByteArray.m3087g();
        if (strM3087g != null && strM3087g.startsWith("WEBVTT")) {
            return;
        }
        parsableByteArray.m3079E(i);
        String strValueOf = String.valueOf(parsableByteArray.m3087g());
        throw ParserException.m8755a(strValueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(strValueOf) : new String("Expected WEBVTT. Got "), null);
    }
}
