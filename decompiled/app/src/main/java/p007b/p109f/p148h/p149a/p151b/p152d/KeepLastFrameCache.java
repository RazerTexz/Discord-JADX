package p007b.p109f.p148h.p149a.p151b.p152d;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameCache;

/* JADX INFO: renamed from: b.f.h.a.b.d.c, reason: use source file name */
/* JADX INFO: compiled from: KeepLastFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class KeepLastFrameCache implements BitmapFrameCache {

    /* JADX INFO: renamed from: a */
    public int f3513a = -1;

    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> f3514b;

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: a */
    public synchronized CloseableReference<Bitmap> mo1151a(int i, int i2, int i3) {
        try {
        } finally {
            m1158g();
        }
        return CloseableReference.m8636n(this.f3514b);
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: b */
    public void mo1152b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean mo1153c(int i) {
        boolean z2;
        if (i == this.f3513a) {
            z2 = CloseableReference.m8640y(this.f3514b);
        }
        return z2;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    public synchronized void clear() {
        m1158g();
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: d */
    public synchronized CloseableReference<Bitmap> mo1154d(int i) {
        if (this.f3513a != i) {
            return null;
        }
        return CloseableReference.m8636n(this.f3514b);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:10:0x001b, B:12:0x0021, B:13:0x0024), top: B:19:0x0003 }] */
    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void mo1155e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<Bitmap> closeableReference2;
        if (closeableReference == null) {
            closeableReference2 = this.f3514b;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
            }
            this.f3514b = CloseableReference.m8636n(closeableReference);
            this.f3513a = i;
            return;
        }
        if (this.f3514b != null && closeableReference.m8642u().equals(this.f3514b.m8642u())) {
            return;
        }
        closeableReference2 = this.f3514b;
        Class<CloseableReference> cls2 = CloseableReference.f19438j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
        this.f3514b = CloseableReference.m8636n(closeableReference);
        this.f3513a = i;
        return;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: f */
    public synchronized CloseableReference<Bitmap> mo1156f(int i) {
        return CloseableReference.m8636n(this.f3514b);
    }

    /* JADX INFO: renamed from: g */
    public final synchronized void m1158g() {
        CloseableReference<Bitmap> closeableReference = this.f3514b;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3514b = null;
        this.f3513a = -1;
    }
}
