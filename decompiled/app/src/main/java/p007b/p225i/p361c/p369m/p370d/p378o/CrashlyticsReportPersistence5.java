package p007b.p225i.p361c.p369m.p370d.p378o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: CrashlyticsReportPersistence.java */
/* renamed from: b.i.c.m.d.o.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence5 implements Comparator {

    /* renamed from: j */
    public static final CrashlyticsReportPersistence5 f12670j = new CrashlyticsReportPersistence5();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = CrashlyticsReportPersistence7.f12672a;
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
