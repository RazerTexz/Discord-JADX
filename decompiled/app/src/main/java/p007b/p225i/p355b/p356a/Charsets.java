package p007b.p225i.p355b.p356a;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* compiled from: Charsets.java */
/* renamed from: b.i.b.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Charsets {

    /* renamed from: a */
    public static final Charset f11943a = Charset.forName("US-ASCII");

    /* renamed from: b */
    public static final Charset f11944b = Charset.forName("ISO-8859-1");

    /* renamed from: c */
    public static final Charset f11945c = Charset.forName(Constants.ENCODING);

    /* renamed from: d */
    public static final Charset f11946d;

    /* renamed from: e */
    public static final Charset f11947e;

    static {
        Charset.forName("UTF-16BE");
        f11946d = Charset.forName("UTF-16LE");
        f11947e = Charset.forName("UTF-16");
    }
}
