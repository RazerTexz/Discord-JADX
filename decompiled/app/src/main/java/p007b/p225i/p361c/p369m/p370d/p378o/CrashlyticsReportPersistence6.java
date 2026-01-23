package p007b.p225i.p361c.p369m.p370d.p378o;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.d.o.f, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence6 implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public static final CrashlyticsReportPersistence6 f12671a = new CrashlyticsReportPersistence6();

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        Charset charset = CrashlyticsReportPersistence7.f12672a;
        return str.startsWith("event");
    }
}
