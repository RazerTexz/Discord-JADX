package p007b.p109f.p190m.p191n;

/* compiled from: SystemDelegate.java */
/* renamed from: b.f.m.n.c, reason: use source file name */
/* loaded from: classes3.dex */
public class SystemDelegate implements NativeLoaderDelegate {
    @Override // p007b.p109f.p190m.p191n.NativeLoaderDelegate
    /* renamed from: a */
    public boolean mo1578a(String str, int i) {
        System.loadLibrary(str);
        return true;
    }
}
