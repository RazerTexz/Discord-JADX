package p007b.p225i.p361c.p369m.p370d.p378o;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.d.o.b, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence2 implements FileFilter {

    /* JADX INFO: renamed from: a */
    public final String f12667a;

    public CrashlyticsReportPersistence2(String str) {
        this.f12667a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String str = this.f12667a;
        Charset charset = CrashlyticsReportPersistence7.f12672a;
        return file.isDirectory() && !file.getName().equals(str);
    }
}
