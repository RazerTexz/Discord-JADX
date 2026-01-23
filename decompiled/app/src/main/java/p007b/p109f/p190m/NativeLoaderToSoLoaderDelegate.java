package p007b.p109f.p190m;

import android.util.Log;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p007b.p109f.p190m.p191n.NativeLoaderDelegate;

/* JADX INFO: renamed from: b.f.m.j, reason: use source file name */
/* JADX INFO: compiled from: NativeLoaderToSoLoaderDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    @Override // p007b.p109f.p190m.p191n.NativeLoaderDelegate
    /* JADX INFO: renamed from: a */
    public boolean mo1578a(String str, int i) {
        boolean z2;
        boolean zContains;
        int i2 = ((i & 1) != 0 ? 16 : 0) | 0;
        ReentrantReadWriteLock reentrantReadWriteLock = SoLoader.f19643c;
        reentrantReadWriteLock.readLock().lock();
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (SoLoader.f19644d == null) {
            if (!"http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                synchronized (SoLoader.class) {
                    zContains = true ^ SoLoader.f19648h.contains(str);
                    if (zContains) {
                        System.loadLibrary(str);
                    }
                }
                reentrantReadWriteLock.readLock().unlock();
                return zContains;
            }
            reentrantReadWriteLock.readLock().lock();
            try {
                boolean z3 = SoLoader.f19644d != null;
                reentrantReadWriteLock.readLock().unlock();
                if (!z3) {
                    throw new IllegalStateException("SoLoader.init() not yet called");
                }
            } finally {
                SoLoader.f19643c.readLock().unlock();
            }
            throw th;
        }
        reentrantReadWriteLock.readLock().unlock();
        boolean z4 = SoLoader.f19652l;
        String strMapLibraryName = System.mapLibraryName(str);
        boolean zM8731d = false;
        do {
            try {
                zM8731d = SoLoader.m8731d(strMapLibraryName, str, null, i2, null);
                z2 = false;
            } catch (UnsatisfiedLinkError e) {
                int i3 = SoLoader.f19645e;
                SoLoader.f19643c.writeLock().lock();
                try {
                    try {
                        if (SoLoader.f19647g == null || !SoLoader.f19647g.m1570c()) {
                            z2 = false;
                        } else {
                            Log.w("SoLoader", "sApplicationSoSource updated during load: " + strMapLibraryName + ", attempting load again.");
                            SoLoader.f19645e = SoLoader.f19645e + 1;
                            z2 = true;
                        }
                        SoLoader.f19643c.writeLock().unlock();
                        if (SoLoader.f19645e == i3) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                } catch (Throwable th2) {
                    SoLoader.f19643c.writeLock().unlock();
                    throw th2;
                }
            }
        } while (z2);
        return zM8731d;
    }
}
