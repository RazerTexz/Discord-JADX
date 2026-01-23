package p007b.p225i.p361c.p369m.p370d.p378o;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.d.o.a, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final String f12666a;

    public CrashlyticsReportPersistence(String str) {
        this.f12666a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        String str2 = this.f12666a;
        Charset charset = CrashlyticsReportPersistence7.f12672a;
        return str.startsWith(str2);
    }
}
