package p007b.p109f.p111b.p113b;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p110a.FileBinaryResource;
import p007b.p109f.p111b.p112a.CacheErrorLogger;
import p007b.p109f.p111b.p112a.NoOpCacheErrorLogger;
import p007b.p109f.p111b.p112a.WriterCallback;
import p007b.p109f.p111b.p113b.DiskStorage;
import p007b.p109f.p115d.p118c.FileTreeVisitor;
import p007b.p109f.p115d.p119d.CountingOutputStream;
import p007b.p109f.p115d.p126k.Clock2;
import p007b.p109f.p115d.p126k.SystemClock;
import p007b.p109f.p161j.p168c.BufferedDiskCache4;

/* compiled from: DefaultDiskStorage.java */
/* renamed from: b.f.b.b.a, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultDiskStorage implements DiskStorage {

    /* renamed from: a */
    public static final long f3021a = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: b */
    public static final /* synthetic */ int f3022b = 0;

    /* renamed from: c */
    public final File f3023c;

    /* renamed from: d */
    public final boolean f3024d;

    /* renamed from: e */
    public final File f3025e;

    /* renamed from: f */
    public final CacheErrorLogger f3026f;

    /* renamed from: g */
    public final Clock2 f3027g;

    /* compiled from: DefaultDiskStorage.java */
    /* renamed from: b.f.b.b.a$b */
    public class b implements FileTreeVisitor {

        /* renamed from: a */
        public final List<DiskStorage.a> f3028a = new ArrayList();

        public b(a aVar) {
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: a */
        public void mo942a(File file) {
            d dVarM931h = DefaultDiskStorage.m931h(DefaultDiskStorage.this, file);
            if (dVarM931h == null || dVarM931h.f3034a != ".cnt") {
                return;
            }
            this.f3028a.add(new c(dVarM931h.f3035b, file, null));
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: b */
        public void mo943b(File file) {
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: c */
        public void mo944c(File file) {
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    /* renamed from: b.f.b.b.a$c */
    public static class c implements DiskStorage.a {

        /* renamed from: a */
        public final String f3030a;

        /* renamed from: b */
        public final FileBinaryResource f3031b;

        /* renamed from: c */
        public long f3032c;

        /* renamed from: d */
        public long f3033d;

        public c(String str, File file, a aVar) {
            Objects.requireNonNull(str);
            this.f3030a = str;
            this.f3031b = new FileBinaryResource(file);
            this.f3032c = -1L;
            this.f3033d = -1L;
        }

        @Override // p007b.p109f.p111b.p113b.DiskStorage.a
        /* renamed from: a */
        public long mo945a() {
            if (this.f3033d < 0) {
                this.f3033d = this.f3031b.f3016a.lastModified();
            }
            return this.f3033d;
        }

        @Override // p007b.p109f.p111b.p113b.DiskStorage.a
        public String getId() {
            return this.f3030a;
        }

        @Override // p007b.p109f.p111b.p113b.DiskStorage.a
        public long getSize() {
            if (this.f3032c < 0) {
                this.f3032c = this.f3031b.m928a();
            }
            return this.f3032c;
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* renamed from: b.f.b.b.a$d */
    public static class d {

        /* renamed from: a */
        public final String f3034a;

        /* renamed from: b */
        public final String f3035b;

        public d(String str, String str2) {
            this.f3034a = str;
            this.f3035b = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3034a);
            sb.append("(");
            return outline.m822J(sb, this.f3035b, ")");
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* renamed from: b.f.b.b.a$e */
    public static class e extends IOException {
        public e(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    /* renamed from: b.f.b.b.a$f */
    public class f implements DiskStorage.b {

        /* renamed from: a */
        public final String f3036a;

        /* renamed from: b */
        @VisibleForTesting
        public final File f3037b;

        public f(String str, File file) {
            this.f3036a = str;
            this.f3037b = file;
        }

        /* renamed from: a */
        public boolean m946a() {
            return !this.f3037b.exists() || this.f3037b.delete();
        }

        /* renamed from: b */
        public FileBinaryResource m947b(Object obj) throws IOException {
            Objects.requireNonNull((SystemClock) DefaultDiskStorage.this.f3027g);
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileM940j = DefaultDiskStorage.this.m940j(this.f3036a);
            try {
                AnimatableValueParser.m467Q1(this.f3037b, fileM940j);
                if (fileM940j.exists()) {
                    fileM940j.setLastModified(jCurrentTimeMillis);
                }
                return new FileBinaryResource(fileM940j);
            } catch (FileUtils$RenameException e) {
                Throwable cause = e.getCause();
                if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                    boolean z2 = cause instanceof FileNotFoundException;
                }
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.f3026f;
                int i = DefaultDiskStorage.f3022b;
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
                throw e;
            }
        }

        /* renamed from: c */
        public void m948c(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f3037b);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    BufferedDiskCache4 bufferedDiskCache4 = (BufferedDiskCache4) writerCallback;
                    InputStream inputStreamM1342e = bufferedDiskCache4.f3673a.m1342e();
                    Objects.requireNonNull(inputStreamM1342e);
                    bufferedDiskCache4.f3674b.f3663c.m998a(inputStreamM1342e, countingOutputStream);
                    countingOutputStream.flush();
                    long j = countingOutputStream.f3092j;
                    fileOutputStream.close();
                    if (this.f3037b.length() != j) {
                        throw new e(j, this.f3037b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.f3026f;
                int i = DefaultDiskStorage.f3022b;
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
                throw e;
            }
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* renamed from: b.f.b.b.a$g */
    public class g implements FileTreeVisitor {

        /* renamed from: a */
        public boolean f3039a;

        public g(a aVar) {
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: a */
        public void mo942a(File file) {
            if (this.f3039a) {
                d dVarM931h = DefaultDiskStorage.m931h(DefaultDiskStorage.this, file);
                if (dVarM931h != null) {
                    String str = dVarM931h.f3034a;
                    if (str == ".tmp") {
                        long jLastModified = file.lastModified();
                        Objects.requireNonNull((SystemClock) DefaultDiskStorage.this.f3027g);
                        if (jLastModified > System.currentTimeMillis() - DefaultDiskStorage.f3021a) {
                        }
                    } else {
                        AnimatableValueParser.m419B(str == ".cnt");
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            file.delete();
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: b */
        public void mo943b(File file) {
            if (this.f3039a || !file.equals(DefaultDiskStorage.this.f3025e)) {
                return;
            }
            this.f3039a = true;
        }

        @Override // p007b.p109f.p115d.p118c.FileTreeVisitor
        /* renamed from: c */
        public void mo944c(File file) {
            if (!DefaultDiskStorage.this.f3023c.equals(file) && !this.f3039a) {
                file.delete();
            }
            if (this.f3039a && file.equals(DefaultDiskStorage.this.f3025e)) {
                this.f3039a = false;
            }
        }
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        boolean zContains;
        File externalStorageDirectory;
        this.f3023c = file;
        boolean z2 = false;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        } catch (Exception unused) {
            Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
        }
        if (externalStorageDirectory != null) {
            try {
                zContains = file.getCanonicalPath().contains(externalStorageDirectory.toString());
            } catch (IOException unused2) {
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
            }
        } else {
            zContains = false;
        }
        this.f3024d = zContains;
        File file2 = new File(this.f3023c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.f3025e = file2;
        this.f3026f = cacheErrorLogger;
        if (!this.f3023c.exists()) {
            z2 = true;
        } else if (!file2.exists()) {
            AnimatableValueParser.m492Z(this.f3023c);
            z2 = true;
        }
        if (z2) {
            try {
                AnimatableValueParser.m541l1(file2);
            } catch (FileUtils$CreateDirectoryException unused3) {
                CacheErrorLogger cacheErrorLogger2 = this.f3026f;
                StringBuilder sbM833U = outline.m833U("version directory could not be created: ");
                sbM833U.append(this.f3025e);
                sbM833U.toString();
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger2);
            }
        }
        this.f3027g = SystemClock.f3133a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d m931h(DefaultDiskStorage defaultDiskStorage, File file) {
        d dVar;
        Objects.requireNonNull(defaultDiskStorage);
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
        if (dVar != null && new File(defaultDiskStorage.m941k(dVar.f3035b)).equals(file.getParentFile())) {
            return dVar;
        }
        return null;
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: a */
    public void mo932a() {
        AnimatableValueParser.m554o2(this.f3023c, new g(null));
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: b */
    public DiskStorage.b mo933b(String str, Object obj) throws IOException {
        File file = new File(m941k(str));
        if (!file.exists()) {
            try {
                AnimatableValueParser.m541l1(file);
            } catch (FileUtils$CreateDirectoryException e2) {
                Objects.requireNonNull((NoOpCacheErrorLogger) this.f3026f);
                throw e2;
            }
        }
        try {
            return new f(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e3) {
            Objects.requireNonNull((NoOpCacheErrorLogger) this.f3026f);
            throw e3;
        }
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: c */
    public boolean mo934c(String str, Object obj) {
        File fileM940j = m940j(str);
        boolean zExists = fileM940j.exists();
        if (zExists) {
            Objects.requireNonNull((SystemClock) this.f3027g);
            fileM940j.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: d */
    public FileBinaryResource mo935d(String str, Object obj) {
        File fileM940j = m940j(str);
        if (!fileM940j.exists()) {
            return null;
        }
        Objects.requireNonNull((SystemClock) this.f3027g);
        fileM940j.setLastModified(System.currentTimeMillis());
        return new FileBinaryResource(fileM940j);
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: e */
    public Collection mo936e() throws IOException {
        b bVar = new b(null);
        AnimatableValueParser.m554o2(this.f3025e, bVar);
        return Collections.unmodifiableList(bVar.f3028a);
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: f */
    public long mo937f(String str) {
        return m939i(m940j(str));
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    /* renamed from: g */
    public long mo938g(DiskStorage.a aVar) {
        return m939i(((c) aVar).f3031b.f3016a);
    }

    /* renamed from: i */
    public final long m939i(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // p007b.p109f.p111b.p113b.DiskStorage
    public boolean isExternal() {
        return this.f3024d;
    }

    @VisibleForTesting
    /* renamed from: j */
    public File m940j(String str) {
        return new File(outline.m823K(outline.m833U(m941k(str)), File.separator, str, ".cnt"));
    }

    /* renamed from: k */
    public final String m941k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3025e);
        return outline.m822J(sb, File.separator, strValueOf);
    }
}
