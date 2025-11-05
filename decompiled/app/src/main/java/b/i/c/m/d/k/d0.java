package b.i.c.m.d.k;

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

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class d0 implements Callable<Task<Void>> {
    public final /* synthetic */ Date j;
    public final /* synthetic */ Throwable k;
    public final /* synthetic */ Thread l;
    public final /* synthetic */ b.i.c.m.d.s.d m;
    public final /* synthetic */ x n;

    public d0(x xVar, Date date, Throwable th, Thread thread, b.i.c.m.d.s.d dVar) {
        this.n = xVar;
        this.j = date;
        this.k = th;
        this.l = thread;
        this.m = dVar;
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
        b.i.c.m.d.p.b bVar;
        b.i.c.m.d.p.c cVarI;
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        long time = this.j.getTime() / 1000;
        String strI = this.n.i();
        b.i.c.m.d.p.c cVar = null;
        if (strI == null) {
            b.i.c.m.d.b.a.d("Tried to write a fatal exception while no session was open.");
            return b.i.a.f.e.o.f.Z(null);
        }
        this.n.k.a();
        d1 d1Var = this.n.A;
        Throwable th = this.k;
        Thread thread = this.l;
        String strReplaceAll = strI.replaceAll("-", "");
        Objects.requireNonNull(d1Var);
        b.d.b.a.a.o0("Persisting fatal event for session ", strReplaceAll, b.i.c.m.d.b.a);
        d1Var.a(th, thread, strReplaceAll, "crash", time, true);
        x xVar = this.n;
        Thread thread2 = this.l;
        Throwable th2 = this.k;
        Objects.requireNonNull(xVar);
        try {
            bVar = new b.i.c.m.d.p.b(xVar.l(), strI + "SessionCrash");
            try {
                cVarI = b.i.c.m.d.p.c.i(bVar);
                try {
                    try {
                        xVar.y(cVarI, thread2, th2, time, "crash", true);
                    } catch (Exception e) {
                        e = e;
                        if (b.i.c.m.d.b.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the fatal exception logger", e);
                        }
                        h.h(cVarI, "Failed to flush to session begin file.");
                        h.c(bVar, "Failed to close fatal exception file output stream.");
                        this.n.g(this.j.getTime());
                        b.i.c.m.d.s.h.e eVarC = ((b.i.c.m.d.s.c) this.m).c();
                        int i = eVarC.b().a;
                        Objects.requireNonNull(eVarC.b());
                        this.n.f(i, false);
                        x.a(this.n);
                        x xVar2 = this.n;
                        File fileM = xVar2.m();
                        File fileK = xVar2.k();
                        Comparator<File> comparator = x.d;
                        FilenameFilter filenameFilter = h1.a;
                        ArrayList arrayList = new ArrayList();
                        fileArrListFiles = fileM.listFiles();
                        FilenameFilter filenameFilter2 = h1.a;
                        fileArrListFiles2 = fileK.listFiles(filenameFilter2);
                        if (fileArrListFiles == null) {
                        }
                        if (fileArrListFiles2 == null) {
                        }
                        arrayList.addAll(Arrays.asList(fileArrListFiles));
                        arrayList.addAll(Arrays.asList(fileArrListFiles2));
                        int iC = 4 - h1.c(arrayList, 4, comparator);
                        h1.b(xVar2.l(), x.f1699b, iC - h1.b(xVar2.n(), filenameFilter2, iC, comparator), comparator);
                        if (this.n.j.b()) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cVar = cVarI;
                    h.h(cVar, "Failed to flush to session begin file.");
                    h.c(bVar, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cVarI = null;
            } catch (Throwable th4) {
                th = th4;
                h.h(cVar, "Failed to flush to session begin file.");
                h.c(bVar, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cVarI = null;
            bVar = null;
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
        h.h(cVarI, "Failed to flush to session begin file.");
        h.c(bVar, "Failed to close fatal exception file output stream.");
        this.n.g(this.j.getTime());
        b.i.c.m.d.s.h.e eVarC2 = ((b.i.c.m.d.s.c) this.m).c();
        int i2 = eVarC2.b().a;
        Objects.requireNonNull(eVarC2.b());
        this.n.f(i2, false);
        x.a(this.n);
        x xVar22 = this.n;
        File fileM2 = xVar22.m();
        File fileK2 = xVar22.k();
        Comparator<File> comparator2 = x.d;
        FilenameFilter filenameFilter3 = h1.a;
        ArrayList arrayList2 = new ArrayList();
        fileArrListFiles = fileM2.listFiles();
        FilenameFilter filenameFilter22 = h1.a;
        fileArrListFiles2 = fileK2.listFiles(filenameFilter22);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        arrayList2.addAll(Arrays.asList(fileArrListFiles));
        arrayList2.addAll(Arrays.asList(fileArrListFiles2));
        int iC2 = 4 - h1.c(arrayList2, 4, comparator2);
        h1.b(xVar22.l(), x.f1699b, iC2 - h1.b(xVar22.n(), filenameFilter22, iC2, comparator2), comparator2);
        if (this.n.j.b()) {
            return b.i.a.f.e.o.f.Z(null);
        }
        Executor executor = this.n.m.a;
        return ((b.i.c.m.d.s.c) this.m).a().r(executor, new c0(this, executor));
    }
}
