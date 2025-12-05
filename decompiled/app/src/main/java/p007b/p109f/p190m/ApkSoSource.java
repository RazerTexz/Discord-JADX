package p007b.p109f.p190m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import java.io.File;
import java.io.IOException;
import p007b.p109f.p190m.ExtractFromZipSoSource;
import p007b.p109f.p190m.UnpackingSoSource;

/* compiled from: ApkSoSource.java */
/* renamed from: b.f.m.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ApkSoSource extends ExtractFromZipSoSource {

    /* renamed from: h */
    public final int f4312h;

    /* compiled from: ApkSoSource.java */
    /* renamed from: b.f.m.a$a */
    public class a extends ExtractFromZipSoSource.c {

        /* renamed from: n */
        public File f4313n;

        /* renamed from: o */
        public final int f4314o;

        public a(ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(extractFromZipSoSource);
            this.f4313n = new File(ApkSoSource.this.f4344c.getApplicationInfo().nativeLibraryDir);
            this.f4314o = ApkSoSource.this.f4312h;
        }
    }

    public ApkSoSource(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f4312h = i;
    }

    @Override // p007b.p109f.p190m.UnpackingSoSource
    /* renamed from: g */
    public byte[] mo1565g() throws IOException {
        int i;
        File canonicalFile = this.f4325f.getCanonicalFile();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            Context context = this.f4344c;
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
            if ((this.f4312h & 1) == 0) {
                parcelObtain.writeByte((byte) 0);
                return parcelObtain.marshall();
            }
            String str = this.f4344c.getApplicationInfo().nativeLibraryDir;
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

    @Override // p007b.p109f.p190m.UnpackingSoSource
    /* renamed from: i */
    public UnpackingSoSource.f mo1566i() throws IOException {
        return new a(this);
    }
}
