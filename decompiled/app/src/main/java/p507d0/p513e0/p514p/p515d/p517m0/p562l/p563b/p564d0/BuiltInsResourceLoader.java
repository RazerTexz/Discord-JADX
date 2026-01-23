package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import java.io.InputStream;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.d, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        Intrinsics3.checkNotNullParameter(str, "path");
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
