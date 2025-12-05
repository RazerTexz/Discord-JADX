package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.Base64;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p393p.DataEncoder;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform5 implements CrashlyticsReportJsonTransform8.a {

    /* renamed from: a */
    public static final CrashlyticsReportJsonTransform5 f12653a = new CrashlyticsReportJsonTransform5();

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8.a
    /* renamed from: a */
    public Object mo6613a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.f12656a;
        jsonReader.beginObject();
        Long lValueOf = null;
        Long lValueOf2 = null;
        String strNextString = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "size":
                    lValueOf2 = Long.valueOf(jsonReader.nextLong());
                    break;
                case "uuid":
                    str = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.f12647a);
                    break;
                case "baseAddress":
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strM883w = lValueOf == null ? " baseAddress" : "";
        if (lValueOf2 == null) {
            strM883w = outline.m883w(strM883w, " size");
        }
        if (strNextString == null) {
            strM883w = outline.m883w(strM883w, " name");
        }
        if (strM883w.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(lValueOf.longValue(), lValueOf2.longValue(), strNextString, str, null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
    }
}
