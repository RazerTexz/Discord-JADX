package b.f.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import b.f.m.f;
import b.f.m.m;
import java.io.File;
import java.io.IOException;

/* compiled from: ApkSoSource.java */
/* loaded from: classes3.dex */
public class a extends f {
    public final int h;

    /* compiled from: ApkSoSource.java */
    /* renamed from: b.f.m.a$a, reason: collision with other inner class name */
    public class C0078a extends f.c {
        public File n;
        public final int o;

        public C0078a(f fVar) throws IOException {
            super(fVar);
            this.n = new File(a.this.c.getApplicationInfo().nativeLibraryDir);
            this.o = a.this.h;
        }
    }

    public a(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.h = i;
    }

    @Override // b.f.m.m
    public byte[] g() throws IOException {
        int i;
        File canonicalFile = this.f.getCanonicalFile();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            Context context = this.c;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    i = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                }
            } else {
                i = 0;
            }
            parcelObtain.writeInt(i);
            if ((this.h & 1) == 0) {
                parcelObtain.writeByte((byte) 0);
                return parcelObtain.marshall();
            }
            String str = this.c.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile2.getPath());
            parcelObtain.writeLong(canonicalFile2.lastModified());
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // b.f.m.m
    public m.f i() throws IOException {
        return new C0078a(this);
    }
}
