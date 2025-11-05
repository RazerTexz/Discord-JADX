package b.f.b.b;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
import b.f.b.b.c;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultDiskStorage.java */
/* loaded from: classes.dex */
public class a implements b.f.b.b.c {
    public static final long a = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f457b = 0;
    public final File c;
    public final boolean d;
    public final File e;
    public final b.f.b.a.a f;
    public final b.f.d.k.a g;

    /* compiled from: DefaultDiskStorage.java */
    public class b implements b.f.d.c.a {
        public final List<c.a> a = new ArrayList();

        public b(C0065a c0065a) {
        }

        @Override // b.f.d.c.a
        public void a(File file) {
            d dVarH = a.h(a.this, file);
            if (dVarH == null || dVarH.a != ".cnt") {
                return;
            }
            this.a.add(new c(dVarH.f460b, file, null));
        }

        @Override // b.f.d.c.a
        public void b(File file) {
        }

        @Override // b.f.d.c.a
        public void c(File file) {
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public static class c implements c.a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final b.f.a.a f459b;
        public long c;
        public long d;

        public c(String str, File file, C0065a c0065a) {
            Objects.requireNonNull(str);
            this.a = str;
            this.f459b = new b.f.a.a(file);
            this.c = -1L;
            this.d = -1L;
        }

        @Override // b.f.b.b.c.a
        public long a() {
            if (this.d < 0) {
                this.d = this.f459b.a.lastModified();
            }
            return this.d;
        }

        @Override // b.f.b.b.c.a
        public String getId() {
            return this.a;
        }

        @Override // b.f.b.b.c.a
        public long getSize() {
            if (this.c < 0) {
                this.c = this.f459b.a();
            }
            return this.c;
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    public static class d {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f460b;

        public d(String str, String str2) {
            this.a = str;
            this.f460b = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("(");
            return b.d.b.a.a.J(sb, this.f460b, ")");
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    public static class e extends IOException {
        public e(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public class f implements c.b {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        public final File f461b;

        public f(String str, File file) {
            this.a = str;
            this.f461b = file;
        }

        public boolean a() {
            return !this.f461b.exists() || this.f461b.delete();
        }

        public b.f.a.a b(Object obj) throws IOException {
            Objects.requireNonNull((b.f.d.k.c) a.this.g);
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileJ = a.this.j(this.a);
            try {
                b.c.a.a0.d.Q1(this.f461b, fileJ);
                if (fileJ.exists()) {
                    fileJ.setLastModified(jCurrentTimeMillis);
                }
                return new b.f.a.a(fileJ);
            } catch (FileUtils$RenameException e) {
                Throwable cause = e.getCause();
                if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                    boolean z2 = cause instanceof FileNotFoundException;
                }
                b.f.b.a.a aVar = a.this.f;
                int i = a.f457b;
                Objects.requireNonNull((b.f.b.a.d) aVar);
                throw e;
            }
        }

        public void c(b.f.b.a.g gVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f461b);
                try {
                    b.f.d.d.b bVar = new b.f.d.d.b(fileOutputStream);
                    b.f.j.c.h hVar = (b.f.j.c.h) gVar;
                    InputStream inputStreamE = hVar.a.e();
                    Objects.requireNonNull(inputStreamE);
                    hVar.f556b.c.a(inputStreamE, bVar);
                    bVar.flush();
                    long j = bVar.j;
                    fileOutputStream.close();
                    if (this.f461b.length() != j) {
                        throw new e(j, this.f461b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                b.f.b.a.a aVar = a.this.f;
                int i = a.f457b;
                Objects.requireNonNull((b.f.b.a.d) aVar);
                throw e;
            }
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    public class g implements b.f.d.c.a {
        public boolean a;

        public g(C0065a c0065a) {
        }

        @Override // b.f.d.c.a
        public void a(File file) {
            if (this.a) {
                d dVarH = a.h(a.this, file);
                if (dVarH != null) {
                    String str = dVarH.a;
                    if (str == ".tmp") {
                        long jLastModified = file.lastModified();
                        Objects.requireNonNull((b.f.d.k.c) a.this.g);
                        if (jLastModified > System.currentTimeMillis() - a.a) {
                        }
                    } else {
                        b.c.a.a0.d.B(str == ".cnt");
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            file.delete();
        }

        @Override // b.f.d.c.a
        public void b(File file) {
            if (this.a || !file.equals(a.this.e)) {
                return;
            }
            this.a = true;
        }

        @Override // b.f.d.c.a
        public void c(File file) {
            if (!a.this.c.equals(file) && !this.a) {
                file.delete();
            }
            if (this.a && file.equals(a.this.e)) {
                this.a = false;
            }
        }
    }

    public a(File file, int i, b.f.b.a.a aVar) {
        boolean zContains;
        File externalStorageDirectory;
        this.c = file;
        boolean z2 = false;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        } catch (Exception unused) {
            Objects.requireNonNull((b.f.b.a.d) aVar);
        }
        if (externalStorageDirectory != null) {
            try {
                zContains = file.getCanonicalPath().contains(externalStorageDirectory.toString());
            } catch (IOException unused2) {
                Objects.requireNonNull((b.f.b.a.d) aVar);
            }
        } else {
            zContains = false;
        }
        this.d = zContains;
        File file2 = new File(this.c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.e = file2;
        this.f = aVar;
        if (!this.c.exists()) {
            z2 = true;
        } else if (!file2.exists()) {
            b.c.a.a0.d.Z(this.c);
            z2 = true;
        }
        if (z2) {
            try {
                b.c.a.a0.d.l1(file2);
            } catch (FileUtils$CreateDirectoryException unused3) {
                b.f.b.a.a aVar2 = this.f;
                StringBuilder sbU = b.d.b.a.a.U("version directory could not be created: ");
                sbU.append(this.e);
                sbU.toString();
                Objects.requireNonNull((b.f.b.a.d) aVar2);
            }
        }
        this.g = b.f.d.k.c.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d h(a aVar, File file) {
        d dVar;
        Objects.requireNonNull(aVar);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            dVar = null;
        } else {
            String strSubstring = name.substring(iLastIndexOf);
            String str = ".cnt".equals(strSubstring) ? ".cnt" : ".tmp".equals(strSubstring) ? ".tmp" : null;
            if (str != null) {
                String strSubstring2 = name.substring(0, iLastIndexOf);
                if (str.equals(".tmp")) {
                    int iLastIndexOf2 = strSubstring2.lastIndexOf(46);
                    if (iLastIndexOf2 > 0) {
                        strSubstring2 = strSubstring2.substring(0, iLastIndexOf2);
                    }
                    dVar = null;
                }
                dVar = new d(str, strSubstring2);
            }
        }
        if (dVar != null && new File(aVar.k(dVar.f460b)).equals(file.getParentFile())) {
            return dVar;
        }
        return null;
    }

    @Override // b.f.b.b.c
    public void a() {
        b.c.a.a0.d.o2(this.c, new g(null));
    }

    @Override // b.f.b.b.c
    public c.b b(String str, Object obj) throws IOException {
        File file = new File(k(str));
        if (!file.exists()) {
            try {
                b.c.a.a0.d.l1(file);
            } catch (FileUtils$CreateDirectoryException e2) {
                Objects.requireNonNull((b.f.b.a.d) this.f);
                throw e2;
            }
        }
        try {
            return new f(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e3) {
            Objects.requireNonNull((b.f.b.a.d) this.f);
            throw e3;
        }
    }

    @Override // b.f.b.b.c
    public boolean c(String str, Object obj) {
        File fileJ = j(str);
        boolean zExists = fileJ.exists();
        if (zExists) {
            Objects.requireNonNull((b.f.d.k.c) this.g);
            fileJ.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // b.f.b.b.c
    public b.f.a.a d(String str, Object obj) {
        File fileJ = j(str);
        if (!fileJ.exists()) {
            return null;
        }
        Objects.requireNonNull((b.f.d.k.c) this.g);
        fileJ.setLastModified(System.currentTimeMillis());
        return new b.f.a.a(fileJ);
    }

    @Override // b.f.b.b.c
    public Collection e() throws IOException {
        b bVar = new b(null);
        b.c.a.a0.d.o2(this.e, bVar);
        return Collections.unmodifiableList(bVar.a);
    }

    @Override // b.f.b.b.c
    public long f(String str) {
        return i(j(str));
    }

    @Override // b.f.b.b.c
    public long g(c.a aVar) {
        return i(((c) aVar).f459b.a);
    }

    public final long i(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // b.f.b.b.c
    public boolean isExternal() {
        return this.d;
    }

    @VisibleForTesting
    public File j(String str) {
        return new File(b.d.b.a.a.K(b.d.b.a.a.U(k(str)), File.separator, str, ".cnt"));
    }

    public final String k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        return b.d.b.a.a.J(sb, File.separator, strValueOf);
    }
}
