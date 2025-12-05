package p007b.p225i.p226a.p242c;

import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo.java */
/* renamed from: b.i.a.c.i1, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoPlayerLibraryInfo {

    /* renamed from: a */
    public static final HashSet<String> f7121a = new HashSet<>();

    /* renamed from: b */
    public static String f7122b = "goog.exo.core";

    /* renamed from: a */
    public static synchronized void m3272a(String str) {
        if (f7121a.add(str)) {
            String str2 = f7122b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            f7122b = sb.toString();
        }
    }
}
