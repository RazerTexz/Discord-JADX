package p507d0.p579g0;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Charsets.kt */
/* renamed from: d0.g0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Charsets2 {

    /* renamed from: a */
    public static final Charset f25136a;

    /* renamed from: b */
    public static Charset f25137b;

    /* renamed from: c */
    public static Charset f25138c;

    /* renamed from: d */
    public static final Charsets2 f25139d = new Charsets2();

    static {
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        f25136a = charsetForName;
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    public final Charset UTF32_BE() {
        Charset charset = f25138c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32BE\")");
        f25138c = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f25137b;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32LE\")");
        f25137b = charsetForName;
        return charsetForName;
    }
}
