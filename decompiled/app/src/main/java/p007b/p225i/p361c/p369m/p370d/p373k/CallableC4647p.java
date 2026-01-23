package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence7;

/* JADX INFO: renamed from: b.i.c.m.d.k.p */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4647p implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ UserMetadata f12363j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4663x f12364k;

    public CallableC4647p(C4663x c4663x, UserMetadata userMetadata) {
        this.f12364k = c4663x;
        this.f12363j = userMetadata;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String string;
        String strM6474i = this.f12364k.m6474i();
        BufferedWriter bufferedWriter2 = null;
        if (strM6474i == null) {
            Logger3.f12227a.m6371b("Tried to cache user data while no session was open.");
        } else {
            SessionReportingCoordinator3 sessionReportingCoordinator3 = this.f12364k.f12422A;
            String strReplaceAll = strM6474i.replaceAll("-", "");
            String str = sessionReportingCoordinator3.f12282e.f12290a;
            if (str == null) {
                Logger3.f12227a.m6371b("Could not persist user ID; no user ID available");
            } else {
                try {
                    CrashlyticsReportPersistence7.m6631l(new File(sessionReportingCoordinator3.f12279b.m6635h(strReplaceAll), "user"), str);
                } catch (IOException e) {
                    Logger3.f12227a.m6372c("Could not persist user ID for session " + strReplaceAll, e);
                }
            }
            MetaDataStore2 metaDataStore2 = new MetaDataStore2(this.f12364k.m6476l());
            UserMetadata userMetadata = this.f12363j;
            File fileM6490b = metaDataStore2.m6490b(strM6474i);
            try {
                string = new MetaDataStore(userMetadata).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileM6490b), MetaDataStore2.f12468a));
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CommonUtils.m6409c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            try {
                bufferedWriter.write(string);
                bufferedWriter.flush();
            } catch (Exception e3) {
                e = e3;
                try {
                    if (Logger3.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "Error serializing user metadata.", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.m6409c(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                CommonUtils.m6409c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            CommonUtils.m6409c(bufferedWriter, "Failed to close user metadata file.");
        }
        return null;
    }
}
