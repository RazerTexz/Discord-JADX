package p007b.p225i.p361c.p369m.p370d.p380q.p381c;

import java.io.File;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: NativeSessionReport.java */
/* renamed from: b.i.c.m.d.q.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public class NativeSessionReport implements Report2 {

    /* renamed from: a */
    public final File f12712a;

    public NativeSessionReport(File file) {
        this.f12712a = file;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: a */
    public String mo6672a() {
        return this.f12712a.getName();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: b */
    public Map<String, String> mo6673b() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: c */
    public File mo6674c() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: d */
    public int mo6675d() {
        return 2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: e */
    public File[] mo6676e() {
        return this.f12712a.listFiles();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    /* renamed from: f */
    public String mo6677f() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2
    public void remove() {
        for (File file : mo6676e()) {
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Removing native report file at ");
            sbM833U.append(file.getPath());
            logger3.m6371b(sbM833U.toString());
            file.delete();
        }
        Logger3 logger32 = Logger3.f12227a;
        StringBuilder sbM833U2 = outline.m833U("Removing native report directory at ");
        sbM833U2.append(this.f12712a);
        logger32.m6371b(sbM833U2.toString());
        this.f12712a.delete();
    }
}
