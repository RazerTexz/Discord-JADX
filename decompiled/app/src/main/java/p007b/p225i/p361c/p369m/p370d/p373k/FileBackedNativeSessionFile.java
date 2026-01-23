package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_FilesPayload_File;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.k.u0, reason: use source file name */
/* JADX INFO: compiled from: FileBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class FileBackedNativeSessionFile implements NativeSessionFile {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final File f12398a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final String f12399b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final String f12400c;

    public FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f12399b = str;
        this.f12400c = str2;
        this.f12398a = file;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.NativeSessionFile
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6392a() {
        return this.f12400c;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[ORIG_RETURN, RETURN] */
    @Override // p007b.p225i.p361c.p369m.p370d.p373k.NativeSessionFile
    @Nullable
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CrashlyticsReport.c.a mo6393b() {
        byte[] byteArray;
        InputStream inputStreamMo6394h;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            inputStreamMo6394h = mo6394h();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (inputStreamMo6394h != null) {
                    try {
                        inputStreamMo6394h.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused3) {
        }
        if (inputStreamMo6394h == null) {
            byteArrayOutputStream.close();
            if (inputStreamMo6394h != null) {
                inputStreamMo6394h.close();
            }
            byteArray = null;
            if (byteArray != null) {
                return null;
            }
            Objects.requireNonNull(byteArray, "Null contents");
            String str = this.f12399b;
            Objects.requireNonNull(str, "Null filename");
            if (1 != 0) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(str, byteArray, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", ""));
        }
        while (true) {
            try {
                int i = inputStreamMo6394h.read(bArr);
                if (i <= 0) {
                    break;
                }
                gZIPOutputStream.write(bArr, 0, i);
            } finally {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable unused4) {
                }
            }
        }
        gZIPOutputStream.finish();
        byteArray = byteArrayOutputStream.toByteArray();
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        inputStreamMo6394h.close();
        if (byteArray != null) {
        }
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.NativeSessionFile
    @Nullable
    /* JADX INFO: renamed from: h */
    public InputStream mo6394h() {
        if (this.f12398a.exists() && this.f12398a.isFile()) {
            try {
                return new FileInputStream(this.f12398a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
