package p007b.p225i.p226a.p288f.p299e.p308o;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RecentlyNullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.e.o.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3405g {

    /* JADX INFO: renamed from: a */
    public static String f9596a;

    /* JADX INFO: renamed from: b */
    public static int f9597b;

    @RecentlyNullable
    /* JADX INFO: renamed from: a */
    public static String m4370a() throws Throwable {
        BufferedReader bufferedReader;
        if (f9596a == null) {
            if (f9597b == 0) {
                f9597b = Process.myPid();
            }
            int i = f9597b;
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            strTrim = null;
            try {
                if (i > 0) {
                    try {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("/proc/");
                        sb.append(i);
                        sb.append("/cmdline");
                        String string = sb.toString();
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(string));
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (IOException unused) {
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        String line = bufferedReader.readLine();
                        Objects.requireNonNull(line, "null reference");
                        strTrim = line.trim();
                        bufferedReader.close();
                    } catch (IOException unused2) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        f9596a = strTrim;
                        return f9596a;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException unused4) {
            }
            f9596a = strTrim;
        }
        return f9596a;
    }
}
