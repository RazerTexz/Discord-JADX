package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import p007b.p225i.p361c.p369m.p370d.p375m.ImmutableList3;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p393p.DataEncoder;

/* JADX INFO: renamed from: b.i.c.m.d.m.x.d, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform4 implements CrashlyticsReportJsonTransform8.a {

    /* JADX INFO: renamed from: a */
    public static final CrashlyticsReportJsonTransform4 f12652a = new CrashlyticsReportJsonTransform4();

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8.a
    /* JADX INFO: renamed from: a */
    public Object mo6613a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.f12656a;
        jsonReader.beginObject();
        String strNextString = null;
        Integer numValueOf = null;
        ImmutableList3 immutableList3M6614a = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    immutableList3M6614a = CrashlyticsReportJsonTransform8.m6614a(jsonReader, CrashlyticsReportJsonTransform7.f12655a);
                    break;
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "importance":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strM883w = strNextString == null ? " name" : "";
        if (numValueOf == null) {
            strM883w = outline.m883w(strM883w, " importance");
        }
        if (immutableList3M6614a == null) {
            strM883w = outline.m883w(strM883w, " frames");
        }
        if (strM883w.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(strNextString, numValueOf.intValue(), immutableList3M6614a, null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
    }
}
