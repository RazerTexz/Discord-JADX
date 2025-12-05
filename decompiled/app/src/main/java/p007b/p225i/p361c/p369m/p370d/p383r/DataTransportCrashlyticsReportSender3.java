package p007b.p225i.p361c.p369m.p370d.p383r;

import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p226a.p228b.Transport2;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;

/* compiled from: DataTransportCrashlyticsReportSender.java */
/* renamed from: b.i.c.m.d.r.c, reason: use source file name */
/* loaded from: classes3.dex */
public class DataTransportCrashlyticsReportSender3 {

    /* renamed from: a */
    public static final CrashlyticsReportJsonTransform8 f12723a = new CrashlyticsReportJsonTransform8();

    /* renamed from: b */
    public static final String f12724b = m6679a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: c */
    public static final String f12725c = m6679a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: d */
    public static final Transformer<CrashlyticsReport, byte[]> f12726d = DataTransportCrashlyticsReportSender2.f12722a;

    /* renamed from: e */
    public final Transport2<CrashlyticsReport> f12727e;

    public DataTransportCrashlyticsReportSender3(Transport2<CrashlyticsReport> transport2, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.f12727e = transport2;
    }

    /* renamed from: a */
    public static String m6679a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }
}
