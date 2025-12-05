package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoCrashlyticsReportEncoder;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_FilesPayload;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Application;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Device;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Device;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Log;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_User;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.ImmutableList3;
import p007b.p225i.p361c.p393p.DataEncoder;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder4;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsReportJsonTransform8 {

    /* renamed from: a */
    public static final DataEncoder f12656a;

    /* compiled from: CrashlyticsReportJsonTransform.java */
    /* renamed from: b.i.c.m.d.m.x.h$a */
    public interface a<T> {
        /* renamed from: a */
        T mo6613a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoCrashlyticsReportEncoder) AutoCrashlyticsReportEncoder.f12497a).m6514a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.f12825e = true;
        f12656a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @NonNull
    /* renamed from: a */
    public static <T> ImmutableList3<T> m6614a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.mo6613a(jsonReader));
        }
        jsonReader.endArray();
        return new ImmutableList3<>(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0113  */
    /* JADX WARN: Type inference failed for: r2v1, types: [b.i.c.m.d.m.s$a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @NonNull
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport.d.AbstractC13233d m6615b(@NonNull JsonReader jsonReader) throws IOException {
        String strM883w;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        jsonReader.beginObject();
        Long lValueOf = null;
        Integer numValueOf = 0;
        String str = null;
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = null;
        CrashlyticsReport.d.AbstractC13233d.b bVarM6605a = null;
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log = null;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                strM883w = lValueOf == null ? " timestamp" : "";
                if (str == null) {
                    strM883w = outline.m883w(strM883w, " type");
                }
                if (autoValue_CrashlyticsReport_Session_Event_Application == null) {
                    strM883w = outline.m883w(strM883w, " app");
                }
                if (bVarM6605a == null) {
                    strM883w = outline.m883w(strM883w, " device");
                }
                if (strM883w.isEmpty()) {
                    return new AutoValue_CrashlyticsReport_Session_Event(lValueOf.longValue(), str, autoValue_CrashlyticsReport_Session_Event_Application, bVarM6605a, autoValue_CrashlyticsReport_Session_Event_Log, null);
                }
                throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -1335157162:
                    c = !strNextName.equals("device") ? (char) 65535 : (char) 0;
                    break;
                case 96801:
                    if (strNextName.equals("app")) {
                        c = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (strNextName.equals("log")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (strNextName.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (strNextName.equals("timestamp")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    switch (strNextName2.hashCode()) {
                        case -1708606089:
                            c2 = !strNextName2.equals("batteryLevel") ? (char) 65535 : (char) 0;
                            break;
                        case -1455558134:
                            if (strNextName2.equals("batteryVelocity")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1439500848:
                            if (strNextName2.equals("orientation")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 279795450:
                            if (strNextName2.equals("diskUsed")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 976541947:
                            if (strNextName2.equals("ramUsed")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 1516795582:
                            if (strNextName2.equals("proximityOn")) {
                                c2 = 5;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        bVar.f12635a = Double.valueOf(jsonReader.nextDouble());
                    } else if (c2 == 1) {
                        bVar.f12636b = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 2) {
                        bVar.f12638d = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 3) {
                        bVar.f12640f = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 == 4) {
                        bVar.f12639e = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.f12637c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarM6605a = bVar.m6605a();
            } else if (c == 1) {
                jsonReader.beginObject();
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = numValueOf;
                ImmutableList3 immutableList3M6614a = autoValue_CrashlyticsReport_Session_Event_Application_Execution;
                Boolean boolValueOf = immutableList3M6614a;
                while (true) {
                    char c6 = 3;
                    if (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3.hashCode()) {
                            case -1332194002:
                                c3 = !strNextName3.equals("background") ? (char) 65535 : (char) 0;
                                break;
                            case -1090974952:
                                if (strNextName3.equals("execution")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 555169704:
                                if (strNextName3.equals("customAttributes")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 928737948:
                                if (strNextName3.equals("uiOrientation")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                        }
                        if (c3 == 0) {
                            boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                        } else if (c3 == 1) {
                            jsonReader.beginObject();
                            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6616c = null;
                            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = null;
                            ImmutableList3 immutableList3M6614a2 = null;
                            ImmutableList3 immutableList3M6614a3 = null;
                            while (jsonReader.hasNext()) {
                                String strNextName4 = jsonReader.nextName();
                                strNextName4.hashCode();
                                switch (strNextName4.hashCode()) {
                                    case -1337936983:
                                        c4 = !strNextName4.equals("threads") ? (char) 65535 : (char) 0;
                                        break;
                                    case -902467928:
                                        if (strNextName4.equals("signal")) {
                                            c4 = 1;
                                            break;
                                        }
                                        break;
                                    case 937615455:
                                        if (strNextName4.equals("binaries")) {
                                            c4 = 2;
                                            break;
                                        }
                                        break;
                                    case 1481625679:
                                        if (strNextName4.equals("exception")) {
                                            c4 = 3;
                                            break;
                                        }
                                        break;
                                }
                                if (c4 == 0) {
                                    immutableList3M6614a3 = m6614a(jsonReader, CrashlyticsReportJsonTransform4.f12652a);
                                } else if (c4 == 1) {
                                    jsonReader.beginObject();
                                    Long lValueOf2 = null;
                                    String str2 = null;
                                    String str3 = null;
                                    while (jsonReader.hasNext()) {
                                        String strNextName5 = jsonReader.nextName();
                                        strNextName5.hashCode();
                                        int iHashCode = strNextName5.hashCode();
                                        if (iHashCode != -1147692044) {
                                            if (iHashCode != 3059181) {
                                                c5 = (iHashCode == 3373707 && strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) ? (char) 2 : (char) 65535;
                                            } else if (strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                                                c5 = 1;
                                            }
                                        } else if (strNextName5.equals("address")) {
                                            c5 = 0;
                                        }
                                        if (c5 == 0) {
                                            lValueOf2 = Long.valueOf(jsonReader.nextLong());
                                        } else if (c5 == 1) {
                                            String strNextString = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString, "Null code");
                                            str3 = strNextString;
                                        } else if (c5 != 2) {
                                            jsonReader.skipValue();
                                        } else {
                                            String strNextString2 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString2, "Null name");
                                            str2 = strNextString2;
                                        }
                                    }
                                    jsonReader.endObject();
                                    String strM883w2 = str2 == null ? " name" : "";
                                    if (str3 == null) {
                                        strM883w2 = outline.m883w(strM883w2, " code");
                                    }
                                    if (lValueOf2 == null) {
                                        strM883w2 = outline.m883w(strM883w2, " address");
                                    }
                                    if (!strM883w2.isEmpty()) {
                                        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w2));
                                    }
                                    autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str2, str3, lValueOf2.longValue(), null);
                                } else if (c4 == 2) {
                                    immutableList3M6614a2 = m6614a(jsonReader, CrashlyticsReportJsonTransform5.f12653a);
                                } else if (c4 != c6) {
                                    jsonReader.skipValue();
                                } else {
                                    abstractC13236bM6616c = m6616c(jsonReader);
                                }
                                c6 = 3;
                            }
                            jsonReader.endObject();
                            String strM883w3 = immutableList3M6614a3 == null ? " threads" : "";
                            if (abstractC13236bM6616c == null) {
                                strM883w3 = outline.m883w(strM883w3, " exception");
                            }
                            if (autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal == null) {
                                strM883w3 = outline.m883w(strM883w3, " signal");
                            }
                            if (immutableList3M6614a2 == null) {
                                strM883w3 = outline.m883w(strM883w3, " binaries");
                            }
                            if (!strM883w3.isEmpty()) {
                                throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w3));
                            }
                            autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3M6614a3, abstractC13236bM6616c, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, immutableList3M6614a2, null);
                        } else if (c3 == 2) {
                            immutableList3M6614a = m6614a(jsonReader, CrashlyticsReportJsonTransform3.f12651a);
                        } else if (c3 != 3) {
                            jsonReader.skipValue();
                        } else {
                            numValueOf = Integer.valueOf(jsonReader.nextInt());
                        }
                    } else {
                        jsonReader.endObject();
                        strM883w = autoValue_CrashlyticsReport_Session_Event_Application_Execution == null ? " execution" : "";
                        if (numValueOf == 0) {
                            strM883w = outline.m883w(strM883w, " uiOrientation");
                        }
                        if (!strM883w.isEmpty()) {
                            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                        }
                        autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, immutableList3M6614a, boolValueOf, numValueOf.intValue(), null);
                    }
                }
            } else if (c == 2) {
                jsonReader.beginObject();
                String strNextString3 = numValueOf;
                while (jsonReader.hasNext()) {
                    String strNextName6 = jsonReader.nextName();
                    strNextName6.hashCode();
                    if (strNextName6.equals("content")) {
                        strNextString3 = jsonReader.nextString();
                        Objects.requireNonNull(strNextString3, "Null content");
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                strM883w = strNextString3 == null ? " content" : "";
                if (!strM883w.isEmpty()) {
                    throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                }
                autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(strNextString3, numValueOf);
            } else if (c == 3) {
                String strNextString4 = jsonReader.nextString();
                Objects.requireNonNull(strNextString4, "Null type");
                str = strNextString4;
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                lValueOf = Long.valueOf(jsonReader.nextLong());
            }
            numValueOf = 0;
        }
    }

    @NonNull
    /* renamed from: c */
    public static CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b m6616c(@NonNull JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Integer numValueOf = null;
        String strNextString = null;
        String strNextString2 = null;
        ImmutableList3 immutableList3M6614a = null;
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6616c = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    immutableList3M6614a = m6614a(jsonReader, CrashlyticsReportJsonTransform6.f12654a);
                    break;
                case "reason":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "type":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null type");
                    break;
                case "causedBy":
                    abstractC13236bM6616c = m6616c(jsonReader);
                    break;
                case "overflowCount":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strM883w = strNextString == null ? " type" : "";
        if (immutableList3M6614a == null) {
            strM883w = outline.m883w(strM883w, " frames");
        }
        if (numValueOf == null) {
            strM883w = outline.m883w(strM883w, " overflowCount");
        }
        if (strM883w.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(strNextString, strNextString2, immutableList3M6614a, abstractC13236bM6616c, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
    }

    @NonNull
    /* renamed from: d */
    public static CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a m6617d(@NonNull JsonReader jsonReader) throws IOException {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    bVar.f12627d = Long.valueOf(jsonReader.nextLong());
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null symbol");
                    bVar.f12625b = strNextString;
                    break;
                case "pc":
                    bVar.f12624a = Long.valueOf(jsonReader.nextLong());
                    break;
                case "file":
                    bVar.f12626c = jsonReader.nextString();
                    break;
                case "importance":
                    bVar.f12628e = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.m6598a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021a A[PHI: r17
      0x021a: PHI (r17v15 java.lang.String) = (r17v10 java.lang.String), (r17v11 java.lang.String), (r17v12 java.lang.String), (r17v16 java.lang.String) binds: [B:146:0x0215, B:142:0x020a, B:138:0x01fd, B:123:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012b  */
    @NonNull
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport m6618e(@NonNull JsonReader jsonReader) throws IOException {
        char c;
        String str;
        char c2;
        String str2;
        char c3;
        Charset charset = CrashlyticsReport.f12647a;
        AutoValue_CrashlyticsReport.b bVar = new AutoValue_CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -2118372775:
                    c = !strNextName.equals("ndkPayload") ? (char) 65535 : (char) 0;
                    break;
                case -1962630338:
                    if (strNextName.equals("sdkVersion")) {
                        c = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (strNextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (strNextName.equals("gmpAppId")) {
                        c = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (strNextName.equals("installationUuid")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (strNextName.equals("platform")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (strNextName.equals("displayVersion")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (strNextName.equals("session")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            String str3 = "";
            switch (c) {
                case 0:
                    jsonReader.beginObject();
                    String strNextString = null;
                    ImmutableList3 immutableList3M6614a = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(ChatInputComponentTypes.FILES)) {
                            immutableList3M6614a = m6614a(jsonReader, CrashlyticsReportJsonTransform2.f12650a);
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    String str4 = immutableList3M6614a == null ? " files" : "";
                    if (!str4.isEmpty()) {
                        throw new IllegalStateException(outline.m883w("Missing required properties:", str4));
                    }
                    bVar.f12533h = new AutoValue_CrashlyticsReport_FilesPayload(immutableList3M6614a, strNextString, null);
                    break;
                    break;
                case 1:
                    String strNextString2 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString2, "Null sdkVersion");
                    bVar.f12526a = strNextString2;
                    break;
                case 2:
                    String strNextString3 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString3, "Null buildVersion");
                    bVar.f12530e = strNextString3;
                    break;
                case 3:
                    String strNextString4 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString4, "Null gmpAppId");
                    bVar.f12527b = strNextString4;
                    break;
                case 4:
                    String strNextString5 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString5, "Null installationUuid");
                    bVar.f12529d = strNextString5;
                    break;
                case 5:
                    bVar.f12528c = Integer.valueOf(jsonReader.nextInt());
                    break;
                case 6:
                    String strNextString6 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString6, "Null displayVersion");
                    bVar.f12531f = strNextString6;
                    break;
                case 7:
                    AutoValue_CrashlyticsReport_Session.b bVar2 = new AutoValue_CrashlyticsReport_Session.b();
                    bVar2.m6544b(false);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3) {
                            case "startedAt":
                                str = str3;
                                bVar2.f12553c = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "identifier":
                                str = str3;
                                bVar2.f12552b = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.f12647a);
                                str3 = str;
                                break;
                            case "endedAt":
                                str = str3;
                                bVar2.f12554d = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "device":
                                str = str3;
                                AutoValue_CrashlyticsReport_Session_Device.b bVar3 = new AutoValue_CrashlyticsReport_Session_Device.b();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.hashCode();
                                    switch (strNextName4) {
                                        case "simulator":
                                            bVar3.f12583f = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString7, "Null manufacturer");
                                            bVar3.f12585h = strNextString7;
                                            break;
                                        case "ram":
                                            bVar3.f12581d = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "arch":
                                            bVar3.f12578a = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "diskSpace":
                                            bVar3.f12582e = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "cores":
                                            bVar3.f12580c = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString8, "Null model");
                                            bVar3.f12579b = strNextString8;
                                            break;
                                        case "state":
                                            bVar3.f12584g = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString9, "Null modelClass");
                                            bVar3.f12586i = strNextString9;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                bVar2.f12559i = bVar3.m6562a();
                                str3 = str;
                                break;
                            case "events":
                                str = str3;
                                bVar2.f12560j = m6614a(jsonReader, CrashlyticsReportJsonTransform.f12649a);
                                str3 = str;
                                break;
                            case "os":
                                str = str3;
                                jsonReader.beginObject();
                                Boolean boolValueOf = null;
                                Integer numValueOf = null;
                                String str5 = null;
                                String str6 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName5 = jsonReader.nextName();
                                    strNextName5.hashCode();
                                    switch (strNextName5.hashCode()) {
                                        case -911706486:
                                            c2 = !strNextName5.equals("buildVersion") ? (char) 65535 : (char) 0;
                                            break;
                                        case -293026577:
                                            if (strNextName5.equals("jailbroken")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (strNextName5.equals("version")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 1874684019:
                                            if (strNextName5.equals("platform")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c2 == 0) {
                                        String strNextString10 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString10, "Null buildVersion");
                                        str6 = strNextString10;
                                    } else if (c2 == 1) {
                                        boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                                    } else if (c2 == 2) {
                                        String strNextString11 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString11, "Null version");
                                        str5 = strNextString11;
                                    } else if (c2 != 3) {
                                        jsonReader.skipValue();
                                    } else {
                                        numValueOf = Integer.valueOf(jsonReader.nextInt());
                                    }
                                }
                                jsonReader.endObject();
                                String strM883w = numValueOf == null ? " platform" : str;
                                if (str5 == null) {
                                    strM883w = outline.m883w(strM883w, " version");
                                }
                                if (str6 == null) {
                                    strM883w = outline.m883w(strM883w, " buildVersion");
                                }
                                if (boolValueOf == null) {
                                    strM883w = outline.m883w(strM883w, " jailbroken");
                                }
                                if (!strM883w.isEmpty()) {
                                    throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                                }
                                bVar2.f12558h = new AutoValue_CrashlyticsReport_Session_OperatingSystem(numValueOf.intValue(), str5, str6, boolValueOf.booleanValue(), null);
                                str3 = str;
                                break;
                                break;
                            case "app":
                                jsonReader.beginObject();
                                String str7 = null;
                                String str8 = null;
                                String strNextString12 = null;
                                String strNextString13 = null;
                                String strNextString14 = null;
                                String strNextString15 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName6 = jsonReader.nextName();
                                    strNextName6.hashCode();
                                    switch (strNextName6.hashCode()) {
                                        case -1618432855:
                                            str2 = str3;
                                            c3 = !strNextName6.equals("identifier") ? (char) 65535 : (char) 0;
                                            break;
                                        case -519438642:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatform")) {
                                                c3 = 1;
                                                break;
                                            }
                                            break;
                                        case 213652010:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatformVersion")) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (strNextName6.equals("version")) {
                                                c3 = 3;
                                                str2 = str3;
                                            }
                                            str2 = str3;
                                            break;
                                        case 719853845:
                                            if (strNextName6.equals("installationUuid")) {
                                                c3 = 4;
                                                str2 = str3;
                                            }
                                            str2 = str3;
                                            break;
                                        case 1975623094:
                                            if (strNextName6.equals("displayVersion")) {
                                                c3 = 5;
                                                str2 = str3;
                                            }
                                            str2 = str3;
                                            break;
                                        default:
                                            str2 = str3;
                                            break;
                                    }
                                    if (c3 == 0) {
                                        String strNextString16 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString16, "Null identifier");
                                        str7 = strNextString16;
                                    } else if (c3 == 1) {
                                        strNextString14 = jsonReader.nextString();
                                    } else if (c3 == 2) {
                                        strNextString15 = jsonReader.nextString();
                                    } else if (c3 == 3) {
                                        String strNextString17 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString17, "Null version");
                                        str8 = strNextString17;
                                    } else if (c3 == 4) {
                                        strNextString13 = jsonReader.nextString();
                                    } else if (c3 != 5) {
                                        jsonReader.skipValue();
                                    } else {
                                        strNextString12 = jsonReader.nextString();
                                    }
                                    str3 = str2;
                                }
                                str = str3;
                                jsonReader.endObject();
                                String strM883w2 = str7 == null ? " identifier" : str;
                                if (str8 == null) {
                                    strM883w2 = outline.m883w(strM883w2, " version");
                                }
                                if (!strM883w2.isEmpty()) {
                                    throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w2));
                                }
                                bVar2.f12556f = new AutoValue_CrashlyticsReport_Session_Application(str7, str8, strNextString12, null, strNextString13, strNextString14, strNextString15, null);
                                str3 = str;
                                break;
                                break;
                            case "user":
                                jsonReader.beginObject();
                                String strNextString18 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName7 = jsonReader.nextName();
                                    strNextName7.hashCode();
                                    if (strNextName7.equals("identifier")) {
                                        strNextString18 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString18, "Null identifier");
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                String str9 = strNextString18 == null ? " identifier" : str3;
                                if (!str9.isEmpty()) {
                                    throw new IllegalStateException(outline.m883w("Missing required properties:", str9));
                                }
                                bVar2.f12557g = new AutoValue_CrashlyticsReport_Session_User(strNextString18, null);
                                str = str3;
                                str3 = str;
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                Objects.requireNonNull(strNextString19, "Null generator");
                                bVar2.f12551a = strNextString19;
                                str = str3;
                                str3 = str;
                                break;
                            case "crashed":
                                bVar2.m6544b(jsonReader.nextBoolean());
                                str = str3;
                                str3 = str;
                                break;
                            case "generatorType":
                                bVar2.f12561k = Integer.valueOf(jsonReader.nextInt());
                                str = str3;
                                str3 = str;
                                break;
                            default:
                                str = str3;
                                jsonReader.skipValue();
                                str3 = str;
                                break;
                        }
                    }
                    jsonReader.endObject();
                    bVar.f12532g = bVar2.mo6543a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.mo6524a();
    }

    @NonNull
    /* renamed from: f */
    public CrashlyticsReport m6619f(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport crashlyticsReportM6618e = m6618e(jsonReader);
                jsonReader.close();
                return crashlyticsReportM6618e;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    /* renamed from: g */
    public String m6620g(@NonNull CrashlyticsReport crashlyticsReport) {
        return ((JsonDataEncoderBuilder4) f12656a).m6711a(crashlyticsReport);
    }
}
