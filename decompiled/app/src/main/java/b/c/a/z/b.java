package b.c.a.z;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class b {
    public final Context a;

    public b(Context context) {
        this.a = context.getApplicationContext();
    }

    public static String a(String str, a aVar, boolean z2) {
        String str2;
        StringBuilder sbU = b.d.b.a.a.U("lottie_cache_");
        sbU.append(str.replaceAll("\\W+", ""));
        if (z2) {
            Objects.requireNonNull(aVar);
            str2 = ".temp" + aVar.extension;
        } else {
            str2 = aVar.extension;
        }
        sbU.append(str2);
        return sbU.toString();
    }

    public final File b() {
        File file = new File(this.a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public File c(String str, InputStream inputStream, a aVar) throws IOException {
        File file = new File(b(), a(str, aVar, true));
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
