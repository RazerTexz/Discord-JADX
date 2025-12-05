package p007b.p085c.p086a.p099z;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: NetworkCache.java */
/* renamed from: b.c.a.z.b, reason: use source file name */
/* loaded from: classes.dex */
public class NetworkCache {

    /* renamed from: a */
    public final Context f2927a;

    public NetworkCache(Context context) {
        this.f2927a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static String m793a(String str, FileExtension fileExtension, boolean z2) {
        String str2;
        StringBuilder sbM833U = outline.m833U("lottie_cache_");
        sbM833U.append(str.replaceAll("\\W+", ""));
        if (z2) {
            Objects.requireNonNull(fileExtension);
            str2 = ".temp" + fileExtension.extension;
        } else {
            str2 = fileExtension.extension;
        }
        sbM833U.append(str2);
        return sbM833U.toString();
    }

    /* renamed from: b */
    public final File m794b() {
        File file = new File(this.f2927a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: c */
    public File m795c(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(m794b(), m793a(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
