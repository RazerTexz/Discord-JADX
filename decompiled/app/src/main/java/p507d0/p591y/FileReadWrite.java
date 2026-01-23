package p507d0.p591y;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import p507d0.p579g0.Charsets2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.y.f, reason: use source file name */
/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileReadWrite {
    public static final String readText(File file, Charset charset) throws IOException {
        Intrinsics3.checkNotNullParameter(file, "$this$readText");
        Intrinsics3.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = ReadWrite.readText(inputStreamReader);
            Closeable.closeFinally(inputStreamReader, null);
            return text;
        } finally {
        }
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets2.f25136a;
        }
        return readText(file, charset);
    }
}
