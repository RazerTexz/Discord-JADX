package b.i.c.m.d.q;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.c.m.d.k.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: ReportUploader.java */
/* loaded from: classes3.dex */
public class b {
    public static final short[] a = {10, 20, 30, 60, 120, 300};

    /* renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.q.d.b f1741b;

    @Nullable
    public final String c;
    public final String d;
    public final int e;
    public final b.i.c.m.d.q.a f;
    public final a g;
    public Thread h;

    /* compiled from: ReportUploader.java */
    public interface a {
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: b.i.c.m.d.q.b$b, reason: collision with other inner class name */
    public interface InterfaceC0150b {
    }

    /* compiled from: ReportUploader.java */
    public interface c {
    }

    /* compiled from: ReportUploader.java */
    public class d extends b.i.c.m.d.k.d {
        public final List<b.i.c.m.d.q.c.c> j;
        public final boolean k;
        public final float l;

        public d(List<b.i.c.m.d.q.c.c> list, boolean z2, float f) {
            this.j = list;
            this.k = z2;
            this.l = f;
        }

        @Override // b.i.c.m.d.k.d
        public void a() {
            try {
                b(this.j, this.k);
            } catch (Exception e) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "An unexpected error occurred while attempting to upload crash reports.", e);
                }
            }
            b.this.h = null;
        }

        public final void b(List<b.i.c.m.d.q.c.c> list, boolean z2) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Starting report processing in ");
            sbU.append(this.l);
            sbU.append(" second(s)...");
            bVar.b(sbU.toString());
            float f = this.l;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (x.this.p()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !x.this.p()) {
                b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
                StringBuilder sbU2 = b.d.b.a.a.U("Attempting to send ");
                sbU2.append(list.size());
                sbU2.append(" report(s)");
                bVar2.b(sbU2.toString());
                ArrayList arrayList = new ArrayList();
                for (b.i.c.m.d.q.c.c cVar : list) {
                    if (!b.this.a(cVar, z2)) {
                        arrayList.add(cVar);
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = i + 1;
                    long j = b.a[Math.min(i, r8.length - 1)];
                    b.i.c.m.d.b.a.b("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }

    public b(@Nullable String str, String str2, int i, b.i.c.m.d.q.a aVar, b.i.c.m.d.q.d.b bVar, a aVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f1741b = bVar;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = aVar;
        this.g = aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:6:0x0011, B:19:0x0053, B:9:0x001a, B:11:0x0020, B:13:0x0027, B:17:0x0040), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(b.i.c.m.d.q.c.c cVar, boolean z2) {
        b.i.c.m.d.q.c.a aVar;
        int i;
        boolean zA;
        try {
            aVar = new b.i.c.m.d.q.c.a(this.c, this.d, cVar);
            i = this.e;
        } catch (Exception e) {
            b.i.c.m.d.b.a.e("Error occurred sending report " + cVar, e);
        }
        if (i == 3) {
            b.i.c.m.d.b.a.b("Report configured to be sent via DataTransport.");
        } else {
            if (i != 2 || cVar.d() != 1) {
                zA = this.f1741b.a(aVar, z2);
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics Reports Endpoint upload ");
                sb.append(zA ? "complete: " : "FAILED: ");
                sb.append(cVar.a());
                bVar.f(sb.toString());
                if (zA) {
                    Objects.requireNonNull(this.f);
                    cVar.remove();
                    return true;
                }
                return false;
            }
            b.i.c.m.d.b.a.b("Report configured to be sent via DataTransport.");
        }
        zA = true;
        if (zA) {
        }
        return false;
    }
}
