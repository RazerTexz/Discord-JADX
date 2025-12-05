package p007b.p109f.p115d.p119d;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Closeables.java */
/* renamed from: b.f.d.d.a, reason: use source file name */
/* loaded from: classes.dex */
public final class Closeables {

    /* renamed from: a */
    @VisibleForTesting
    public static final Logger f3091a = Logger.getLogger(Closeables.class.getName());

    /* renamed from: a */
    public static void m965a(Closeable closeable, boolean z2) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (!z2) {
                throw e;
            }
            f3091a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
        }
    }

    /* renamed from: b */
    public static void m966b(InputStream inputStream) {
        try {
            m965a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
