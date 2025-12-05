package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.Base64;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_FilesPayload_File;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p393p.DataEncoder;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform2 implements CrashlyticsReportJsonTransform8.a {

    /* renamed from: a */
    public static final CrashlyticsReportJsonTransform2 f12650a = new CrashlyticsReportJsonTransform2();

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8.a
    /* renamed from: a */
    public Object mo6613a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.f12656a;
        jsonReader.beginObject();
        String strNextString = null;
        byte[] bArrDecode = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("filename")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null filename");
            } else if (strNextName.equals("contents")) {
                bArrDecode = Base64.decode(jsonReader.nextString(), 2);
                Objects.requireNonNull(bArrDecode, "Null contents");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strM883w = strNextString == null ? " filename" : "";
        if (bArrDecode == null) {
            strM883w = outline.m883w(strM883w, " contents");
        }
        if (strM883w.isEmpty()) {
            return new AutoValue_CrashlyticsReport_FilesPayload_File(strNextString, bArrDecode, null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
    }
}
