package b.f.b.b;

import java.io.IOException;
import java.util.Collection;

/* compiled from: DiskStorage.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: DiskStorage.java */
    public interface a {
        long a();

        String getId();

        long getSize();
    }

    /* compiled from: DiskStorage.java */
    public interface b {
    }

    void a();

    b b(String str, Object obj) throws IOException;

    boolean c(String str, Object obj) throws IOException;

    b.f.a.a d(String str, Object obj) throws IOException;

    Collection<a> e() throws IOException;

    long f(String str) throws IOException;

    long g(a aVar) throws IOException;

    boolean isExternal();
}
