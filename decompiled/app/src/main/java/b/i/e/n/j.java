package b.i.e.n;

import java.nio.charset.Charset;

/* compiled from: StringUtils.java */
/* loaded from: classes3.dex */
public final class j {
    public static final String a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1839b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        f1839b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
