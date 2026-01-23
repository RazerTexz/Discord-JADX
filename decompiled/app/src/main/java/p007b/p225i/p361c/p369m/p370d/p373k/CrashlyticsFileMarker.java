package p007b.p225i.p361c.p369m.p370d.p373k;

import java.io.File;
import java.io.IOException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p378o.FileStoreImpl;

/* JADX INFO: renamed from: b.i.c.m.d.k.m0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsFileMarker.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsFileMarker {

    /* JADX INFO: renamed from: a */
    public final String f12348a;

    /* JADX INFO: renamed from: b */
    public final FileStoreImpl f12349b;

    public CrashlyticsFileMarker(String str, FileStoreImpl fileStoreImpl) {
        this.f12348a = str;
        this.f12349b = fileStoreImpl;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6444a() {
        try {
            return m6445b().createNewFile();
        } catch (IOException e) {
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Error creating marker: ");
            sbM833U.append(this.f12348a);
            logger3.m6374e(sbM833U.toString(), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final File m6445b() {
        return new File(this.f12349b.m6636a(), this.f12348a);
    }
}
