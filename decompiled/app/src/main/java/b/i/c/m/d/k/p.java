package b.i.c.m.d.k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class p implements Callable<Void> {
    public final /* synthetic */ f1 j;
    public final /* synthetic */ x k;

    public p(x xVar, f1 f1Var) {
        this.k = xVar;
        this.j = f1Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String string;
        String strI = this.k.i();
        BufferedWriter bufferedWriter2 = null;
        if (strI == null) {
            b.i.c.m.d.b.a.b("Tried to cache user data while no session was open.");
        } else {
            d1 d1Var = this.k.A;
            String strReplaceAll = strI.replaceAll("-", "");
            String str = d1Var.e.a;
            if (str == null) {
                b.i.c.m.d.b.a.b("Could not persist user ID; no user ID available");
            } else {
                try {
                    b.i.c.m.d.o.g.l(new File(d1Var.f1680b.h(strReplaceAll), "user"), str);
                } catch (IOException e) {
                    b.i.c.m.d.b.a.c("Could not persist user ID for session " + strReplaceAll, e);
                }
            }
            z0 z0Var = new z0(this.k.l());
            f1 f1Var = this.j;
            File fileB = z0Var.b(strI);
            try {
                string = new y0(f1Var).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileB), z0.a));
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                h.c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            try {
                bufferedWriter.write(string);
                bufferedWriter.flush();
            } catch (Exception e3) {
                e = e3;
                try {
                    if (b.i.c.m.d.b.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Error serializing user metadata.", e);
                    }
                    h.c(bufferedWriter, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    bufferedWriter = bufferedWriter2;
                    h.c(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                h.c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            h.c(bufferedWriter, "Failed to close user metadata file.");
        }
        return null;
    }
}
