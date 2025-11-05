package b.i.c.m.d.k;

import b.i.c.m.d.k.x;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class g0 implements Callable<Task<Void>> {
    public final /* synthetic */ Boolean j;
    public final /* synthetic */ x.e k;

    public g0(x.e eVar, Boolean bool) {
        this.k = eVar;
        this.j = bool;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        b.i.c.m.d.q.a aVar = x.this.u;
        Objects.requireNonNull(aVar);
        b.i.c.m.d.b.a.b("Checking for crash reports...");
        File[] fileArrQ = x.this.q();
        File[] fileArrListFiles = x.this.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrQ != null) {
            for (File file : fileArrQ) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sbU = b.d.b.a.a.U("Found crash report ");
                sbU.append(file.getPath());
                bVar.b(sbU.toString());
                linkedList.add(new b.i.c.m.d.q.c.d(file, Collections.emptyMap()));
            }
        }
        for (File file2 : fileArrListFiles) {
            linkedList.add(new b.i.c.m.d.q.c.b(file2));
        }
        if (linkedList.isEmpty()) {
            b.i.c.m.d.b.a.b("No reports found.");
        }
        if (this.j.booleanValue()) {
            b.i.c.m.d.b.a.b("Reports are being sent.");
            boolean zBooleanValue = this.j.booleanValue();
            q0 q0Var = x.this.j;
            Objects.requireNonNull(q0Var);
            if (!zBooleanValue) {
                throw new IllegalStateException("An invalid data collection token was used.");
            }
            q0Var.h.b(null);
            x.e eVar = this.k;
            Executor executor = x.this.m.a;
            return eVar.a.r(executor, new f0(this, linkedList, zBooleanValue, executor));
        }
        b.i.c.m.d.b.a.b("Reports are being deleted.");
        for (File file3 : x.r(x.this.l(), m.a)) {
            file3.delete();
        }
        Objects.requireNonNull(x.this.u);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((b.i.c.m.d.q.c.c) it.next()).remove();
        }
        x.this.A.f1680b.b();
        x.this.E.b(null);
        return b.i.a.f.e.o.f.Z(null);
    }
}
