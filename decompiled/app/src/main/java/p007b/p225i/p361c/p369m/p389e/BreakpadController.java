package p007b.p225i.p361c.p369m.p389e;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p389e.SessionFiles;

/* compiled from: BreakpadController.java */
/* renamed from: b.i.c.m.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public class BreakpadController implements NativeComponentController {

    /* renamed from: a */
    public static final Charset f12784a = Charset.forName(Constants.ENCODING);

    /* renamed from: b */
    public final Context f12785b;

    /* renamed from: c */
    public final NativeApi f12786c;

    /* renamed from: d */
    public final NdkCrashFilesManager f12787d;

    public BreakpadController(Context context, NativeApi nativeApi, NdkCrashFilesManager ndkCrashFilesManager) {
        this.f12785b = context;
        this.f12786c = nativeApi;
        this.f12787d = ndkCrashFilesManager;
    }

    @Nullable
    /* renamed from: b */
    public static File m6698b(File file, String str) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    @NonNull
    /* renamed from: a */
    public SessionFiles m6699a(String str) {
        File fileM6702a = this.f12787d.m6702a(str);
        File file = new File(fileM6702a, "pending");
        Logger3 logger3 = Logger3.f12227a;
        StringBuilder sbM833U = outline.m833U("Minidump directory: ");
        sbM833U.append(file.getAbsolutePath());
        logger3.m6371b(sbM833U.toString());
        File fileM6698b = m6698b(file, ".dmp");
        StringBuilder sbM833U2 = outline.m833U("Minidump ");
        sbM833U2.append((fileM6698b == null || !fileM6698b.exists()) ? "does not exist" : "exists");
        logger3.m6371b(sbM833U2.toString());
        SessionFiles.b bVar = new SessionFiles.b();
        if (fileM6702a != null && fileM6702a.exists() && file.exists()) {
            bVar.f12797a = m6698b(file, ".dmp");
            bVar.f12798b = m6698b(fileM6702a, ".device_info");
            bVar.f12799c = new File(fileM6702a, "session.json");
            bVar.f12800d = new File(fileM6702a, "app.json");
            bVar.f12801e = new File(fileM6702a, "device.json");
            bVar.f12802f = new File(fileM6702a, "os.json");
        }
        return new SessionFiles(bVar, null);
    }

    /* renamed from: c */
    public final void m6700c(String str, String str2, String str3) throws Throwable {
        File file = new File(this.f12787d.m6702a(str), str3);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f12784a));
            try {
                bufferedWriter2.write(str2);
                CommonUtils.m6409c(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                CommonUtils.m6409c(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CommonUtils.m6409c(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
