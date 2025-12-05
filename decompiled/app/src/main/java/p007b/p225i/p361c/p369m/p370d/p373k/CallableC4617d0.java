package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p379p.ClsFileOutputStream;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.Settings2;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.d0 */
/* loaded from: classes3.dex */
public class CallableC4617d0 implements Callable<Task<Void>> {

    /* renamed from: j */
    public final /* synthetic */ Date f12273j;

    /* renamed from: k */
    public final /* synthetic */ Throwable f12274k;

    /* renamed from: l */
    public final /* synthetic */ Thread f12275l;

    /* renamed from: m */
    public final /* synthetic */ SettingsDataProvider f12276m;

    /* renamed from: n */
    public final /* synthetic */ C4663x f12277n;

    public CallableC4617d0(C4663x c4663x, Date date, Throwable th, Thread thread, SettingsDataProvider settingsDataProvider) {
        this.f12277n = c4663x;
        this.f12273j = date;
        this.f12274k = th;
        this.f12275l = thread;
        this.f12276m = settingsDataProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0127  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Task<Void> call() throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream2 codedOutputStream2M6646i;
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        long time = this.f12273j.getTime() / 1000;
        String strM6474i = this.f12277n.m6474i();
        CodedOutputStream2 codedOutputStream2 = null;
        if (strM6474i == null) {
            Logger3.f12227a.m6373d("Tried to write a fatal exception while no session was open.");
            return C3404f.m4264Z(null);
        }
        this.f12277n.f12431k.m6444a();
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.f12277n.f12422A;
        Throwable th = this.f12274k;
        Thread thread = this.f12275l;
        String strReplaceAll = strM6474i.replaceAll("-", "");
        Objects.requireNonNull(sessionReportingCoordinator3);
        outline.m868o0("Persisting fatal event for session ", strReplaceAll, Logger3.f12227a);
        sessionReportingCoordinator3.m6399a(th, thread, strReplaceAll, "crash", time, true);
        C4663x c4663x = this.f12277n;
        Thread thread2 = this.f12275l;
        Throwable th2 = this.f12274k;
        Objects.requireNonNull(c4663x);
        try {
            clsFileOutputStream = new ClsFileOutputStream(c4663x.m6476l(), strM6474i + "SessionCrash");
            try {
                codedOutputStream2M6646i = CodedOutputStream2.m6646i(clsFileOutputStream);
                try {
                    try {
                        c4663x.m6485y(codedOutputStream2M6646i, thread2, th2, time, "crash", true);
                    } catch (Exception e) {
                        e = e;
                        if (Logger3.f12227a.m6370a(6)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the fatal exception logger", e);
                        }
                        CommonUtils.m6414h(codedOutputStream2M6646i, "Failed to flush to session begin file.");
                        CommonUtils.m6409c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                        this.f12277n.m6472g(this.f12273j.getTime());
                        Settings2 settings2M6685c = ((SettingsController) this.f12276m).m6685c();
                        int i = settings2M6685c.mo6690b().f12758a;
                        Objects.requireNonNull(settings2M6685c.mo6690b());
                        this.f12277n.m6471f(i, false);
                        C4663x.m6461a(this.f12277n);
                        C4663x c4663x2 = this.f12277n;
                        File fileM6477m = c4663x2.m6477m();
                        File fileM6475k = c4663x2.m6475k();
                        Comparator<File> comparator = C4663x.f12418d;
                        FilenameFilter filenameFilter = Utils3.f12313a;
                        ArrayList arrayList = new ArrayList();
                        fileArrListFiles = fileM6477m.listFiles();
                        FilenameFilter filenameFilter2 = Utils3.f12313a;
                        fileArrListFiles2 = fileM6475k.listFiles(filenameFilter2);
                        if (fileArrListFiles == null) {
                        }
                        if (fileArrListFiles2 == null) {
                        }
                        arrayList.addAll(Arrays.asList(fileArrListFiles));
                        arrayList.addAll(Arrays.asList(fileArrListFiles2));
                        int iM6434c = 4 - Utils3.m6434c(arrayList, 4, comparator);
                        Utils3.m6433b(c4663x2.m6476l(), C4663x.f12416b, iM6434c - Utils3.m6433b(c4663x2.m6478n(), filenameFilter2, iM6434c, comparator), comparator);
                        if (this.f12277n.f12430j.m6450b()) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    codedOutputStream2 = codedOutputStream2M6646i;
                    CommonUtils.m6414h(codedOutputStream2, "Failed to flush to session begin file.");
                    CommonUtils.m6409c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                codedOutputStream2M6646i = null;
            } catch (Throwable th4) {
                th = th4;
                CommonUtils.m6414h(codedOutputStream2, "Failed to flush to session begin file.");
                CommonUtils.m6409c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            codedOutputStream2M6646i = null;
            clsFileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            clsFileOutputStream = null;
        }
        CommonUtils.m6414h(codedOutputStream2M6646i, "Failed to flush to session begin file.");
        CommonUtils.m6409c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        this.f12277n.m6472g(this.f12273j.getTime());
        Settings2 settings2M6685c2 = ((SettingsController) this.f12276m).m6685c();
        int i2 = settings2M6685c2.mo6690b().f12758a;
        Objects.requireNonNull(settings2M6685c2.mo6690b());
        this.f12277n.m6471f(i2, false);
        C4663x.m6461a(this.f12277n);
        C4663x c4663x22 = this.f12277n;
        File fileM6477m2 = c4663x22.m6477m();
        File fileM6475k2 = c4663x22.m6475k();
        Comparator<File> comparator2 = C4663x.f12418d;
        FilenameFilter filenameFilter3 = Utils3.f12313a;
        ArrayList arrayList2 = new ArrayList();
        fileArrListFiles = fileM6477m2.listFiles();
        FilenameFilter filenameFilter22 = Utils3.f12313a;
        fileArrListFiles2 = fileM6475k2.listFiles(filenameFilter22);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        arrayList2.addAll(Arrays.asList(fileArrListFiles));
        arrayList2.addAll(Arrays.asList(fileArrListFiles2));
        int iM6434c2 = 4 - Utils3.m6434c(arrayList2, 4, comparator2);
        Utils3.m6433b(c4663x22.m6476l(), C4663x.f12416b, iM6434c2 - Utils3.m6433b(c4663x22.m6478n(), filenameFilter22, iM6434c2, comparator2), comparator2);
        if (this.f12277n.f12430j.m6450b()) {
            return C3404f.m4264Z(null);
        }
        Executor executor = this.f12277n.f12433m.f12315a;
        return ((SettingsController) this.f12276m).m6683a().mo6023r(executor, new C4614c0(this, executor));
    }
}
