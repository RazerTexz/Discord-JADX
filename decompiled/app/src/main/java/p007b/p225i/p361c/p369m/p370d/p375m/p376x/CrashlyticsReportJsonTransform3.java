package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_CustomAttribute;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p393p.DataEncoder;

/* JADX INFO: renamed from: b.i.c.m.d.m.x.c, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform3 implements CrashlyticsReportJsonTransform8.a {

    /* JADX INFO: renamed from: a */
    public static final CrashlyticsReportJsonTransform3 f12651a = new CrashlyticsReportJsonTransform3();

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8.a
    /* JADX INFO: renamed from: a */
    public Object mo6613a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.f12656a;
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null key");
            } else if (strNextName.equals("value")) {
                strNextString2 = jsonReader.nextString();
                Objects.requireNonNull(strNextString2, "Null value");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strM883w = strNextString == null ? " key" : "";
        if (strNextString2 == null) {
            strM883w = outline.m883w(strM883w, " value");
        }
        if (strM883w.isEmpty()) {
            return new AutoValue_CrashlyticsReport_CustomAttribute(strNextString, strNextString2, null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
    }
}
