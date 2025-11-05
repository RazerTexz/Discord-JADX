package b.f.b.b;

import androidx.annotation.VisibleForTesting;
import b.f.b.b.c;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* compiled from: DynamicDefaultDiskStorage.java */
/* loaded from: classes.dex */
public class e implements c {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final Supplier<File> f466b;
    public final String c;
    public final b.f.b.a.a d;

    @VisibleForTesting
    public volatile a e = new a(null, null);

    /* compiled from: DynamicDefaultDiskStorage.java */
    @VisibleForTesting
    public static class a {
        public final c a;

        /* renamed from: b, reason: collision with root package name */
        public final File f467b;

        @VisibleForTesting
        public a(File file, c cVar) {
            this.a = cVar;
            this.f467b = file;
        }
    }

    public e(int i, Supplier<File> supplier, String str, b.f.b.a.a aVar) {
        this.a = i;
        this.d = aVar;
        this.f466b = supplier;
        this.c = str;
    }

    @Override // b.f.b.b.c
    public void a() {
        try {
            i().a();
        } catch (IOException e) {
            b.f.d.e.a.b(e.class, "purgeUnexpectedResources", e);
        }
    }

    @Override // b.f.b.b.c
    public c.b b(String str, Object obj) throws IOException {
        return i().b(str, obj);
    }

    @Override // b.f.b.b.c
    public boolean c(String str, Object obj) throws IOException {
        return i().c(str, obj);
    }

    @Override // b.f.b.b.c
    public b.f.a.a d(String str, Object obj) throws IOException {
        return i().d(str, obj);
    }

    @Override // b.f.b.b.c
    public Collection<c.a> e() throws IOException {
        return i().e();
    }

    @Override // b.f.b.b.c
    public long f(String str) throws IOException {
        return i().f(str);
    }

    @Override // b.f.b.b.c
    public long g(c.a aVar) throws IOException {
        return i().g(aVar);
    }

    public final void h() throws IOException {
        File file = new File(this.f466b.get(), this.c);
        try {
            b.c.a.a0.d.l1(file);
            file.getAbsolutePath();
            int i = b.f.d.e.a.a;
            this.e = new a(file, new b.f.b.b.a(file, this.a, this.d));
        } catch (FileUtils$CreateDirectoryException e) {
            Objects.requireNonNull((b.f.b.a.d) this.d);
            throw e;
        }
    }

    @VisibleForTesting
    public synchronized c i() throws IOException {
        c cVar;
        File file;
        a aVar = this.e;
        if (aVar.a == null || (file = aVar.f467b) == null || !file.exists()) {
            if (this.e.a != null && this.e.f467b != null) {
                b.c.a.a0.d.Z(this.e.f467b);
            }
            h();
        }
        cVar = this.e.a;
        Objects.requireNonNull(cVar);
        return cVar;
    }

    @Override // b.f.b.b.c
    public boolean isExternal() {
        try {
            return i().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }
}
