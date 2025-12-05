package p007b.p225i.p361c.p369m.p389e;

import androidx.annotation.NonNull;
import java.io.File;

/* compiled from: NdkCrashFilesManager.java */
/* renamed from: b.i.c.m.e.f, reason: use source file name */
/* loaded from: classes3.dex */
public class NdkCrashFilesManager {

    /* renamed from: a */
    public final File f12790a;

    public NdkCrashFilesManager(File file) {
        this.f12790a = file;
    }

    /* renamed from: b */
    public static void m6701b(@NonNull File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m6701b(file2);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public File m6702a(String str) {
        File file = new File(this.f12790a, str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
