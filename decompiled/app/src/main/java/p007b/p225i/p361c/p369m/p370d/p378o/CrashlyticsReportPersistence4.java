package p007b.p225i.p361c.p369m.p370d.p378o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: CrashlyticsReportPersistence.java */
/* renamed from: b.i.c.m.d.o.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence4 implements Comparator {

    /* renamed from: j */
    public static final CrashlyticsReportPersistence4 f12669j = new CrashlyticsReportPersistence4();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = CrashlyticsReportPersistence7.f12672a;
        String name = ((File) obj).getName();
        int i = CrashlyticsReportPersistence7.f12673b;
        return name.substring(0, i).compareTo(((File) obj2).getName().substring(0, i));
    }
}
