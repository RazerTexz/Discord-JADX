package p007b.p109f.p111b.p113b;

import java.io.IOException;
import java.util.Collection;
import p007b.p109f.p110a.FileBinaryResource;

/* compiled from: DiskStorage.java */
/* renamed from: b.f.b.b.c, reason: use source file name */
/* loaded from: classes.dex */
public interface DiskStorage {

    /* compiled from: DiskStorage.java */
    /* renamed from: b.f.b.b.c$a */
    public interface a {
        /* renamed from: a */
        long mo945a();

        String getId();

        long getSize();
    }

    /* compiled from: DiskStorage.java */
    /* renamed from: b.f.b.b.c$b */
    public interface b {
    }

    /* renamed from: a */
    void mo932a();

    /* renamed from: b */
    b mo933b(String str, Object obj) throws IOException;

    /* renamed from: c */
    boolean mo934c(String str, Object obj) throws IOException;

    /* renamed from: d */
    FileBinaryResource mo935d(String str, Object obj) throws IOException;

    /* renamed from: e */
    Collection<a> mo936e() throws IOException;

    /* renamed from: f */
    long mo937f(String str) throws IOException;

    /* renamed from: g */
    long mo938g(a aVar) throws IOException;

    boolean isExternal();
}
