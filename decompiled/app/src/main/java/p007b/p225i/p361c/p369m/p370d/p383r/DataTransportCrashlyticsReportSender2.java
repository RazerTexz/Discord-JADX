package p007b.p225i.p361c.p369m.p370d.p383r;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.r.b, reason: use source file name */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DataTransportCrashlyticsReportSender2 implements Transformer {

    /* JADX INFO: renamed from: a */
    public static final DataTransportCrashlyticsReportSender2 f12722a = new DataTransportCrashlyticsReportSender2();

    @Override // p007b.p225i.p226a.p228b.Transformer
    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender3.f12723a.m6620g((CrashlyticsReport) obj).getBytes(Charset.forName(Constants.ENCODING));
    }
}
