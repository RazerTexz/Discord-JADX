package p007b.p225i.p414e.p418n;

import java.nio.charset.Charset;

/* compiled from: StringUtils.java */
/* renamed from: b.i.e.n.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class StringUtils {

    /* renamed from: a */
    public static final String f13290a;

    /* renamed from: b */
    public static final boolean f13291b;

    static {
        String strName = Charset.defaultCharset().name();
        f13290a = strName;
        f13291b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
