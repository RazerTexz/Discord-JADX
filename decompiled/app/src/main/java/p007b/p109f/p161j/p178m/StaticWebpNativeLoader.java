package p007b.p109f.p161j.p178m;

import p007b.p109f.p190m.p191n.NativeLoader;

/* JADX INFO: renamed from: b.f.j.m.b, reason: use source file name */
/* JADX INFO: compiled from: StaticWebpNativeLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class StaticWebpNativeLoader {

    /* JADX INFO: renamed from: a */
    public static boolean f3981a;

    /* JADX INFO: renamed from: a */
    public static synchronized void m1411a() {
        if (!f3981a) {
            NativeLoader.m1589c("static-webp");
            f3981a = true;
        }
    }
}
