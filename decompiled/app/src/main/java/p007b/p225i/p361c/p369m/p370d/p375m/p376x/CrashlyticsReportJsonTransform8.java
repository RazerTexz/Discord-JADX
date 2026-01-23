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

/* JADX INFO: renamed from: b.i.c.m.d.m.x.h, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsReportJsonTransform8 {

    /* JADX INFO: renamed from: a */
    public static final DataEncoder f12656a;

    /* JADX INFO: renamed from: b.i.c.m.d.m.x.h$a */
    /* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
    public interface a<T> {
        /* JADX INFO: renamed from: a */
        T mo6613a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoCrashlyticsReportEncoder) AutoCrashlyticsReportEncoder.f12497a).m6514a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.f12825e = true;
        f12656a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
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
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [b.i.c.m.d.m.v$d$d$a$b] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [b.i.c.m.d.m.w] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [b.i.c.m.d.m.s$a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object, java.lang.String] */
    @NonNull
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport.d.AbstractC13233d m6615b(@NonNull JsonReader jsonReader) throws IOException {
        String strM883w;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        jsonReader.beginObject();
        Long lValueOf = null;
        ?? ValueOf = 0;
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
                    b2 = !strNextName.equals("device") ? (byte) -1 : (byte) 0;
                    break;
                case 96801:
                    if (strNextName.equals("app")) {
                        b2 = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (strNextName.equals("log")) {
                        b2 = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (strNextName.equals("type")) {
                        b2 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (strNextName.equals("timestamp")) {
                        b2 = 4;
                        break;
                    }
                    break;
            }
            if (b2 == 0) {
                AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    switch (strNextName2.hashCode()) {
                        case -1708606089:
                            b3 = !strNextName2.equals("batteryLevel") ? (byte) -1 : (byte) 0;
                            break;
                        case -1455558134:
                            if (strNextName2.equals("batteryVelocity")) {
                                b3 = 1;
                                break;
                            }
                            break;
                        case -1439500848:
                            if (strNextName2.equals("orientation")) {
                                b3 = 2;
                                break;
                            }
                            break;
                        case 279795450:
                            if (strNextName2.equals("diskUsed")) {
                                b3 = 3;
                                break;
                            }
                            break;
                        case 976541947:
                            if (strNextName2.equals("ramUsed")) {
                                b3 = 4;
                                break;
                            }
                            break;
                        case 1516795582:
                            if (strNextName2.equals("proximityOn")) {
                                b3 = 5;
                                break;
                            }
                            break;
                    }
                    if (b3 == 0) {
                        bVar.f12635a = Double.valueOf(jsonReader.nextDouble());
                    } else if (b3 == 1) {
                        bVar.f12636b = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 2) {
                        bVar.f12638d = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 3) {
                        bVar.f12640f = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 == 4) {
                        bVar.f12639e = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.f12637c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarM6605a = bVar.m6605a();
            } else if (b2 == 1) {
                jsonReader.beginObject();
                ?? autoValue_CrashlyticsReport_Session_Event_Application_Execution = ValueOf;
                ?? M6614a = autoValue_CrashlyticsReport_Session_Event_Application_Execution;
                ?? ValueOf2 = M6614a;
                while (true) {
                    char c = 3;
                    if (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3.hashCode()) {
                            case -1332194002:
                                b4 = !strNextName3.equals("background") ? (byte) -1 : (byte) 0;
                                break;
                            case -1090974952:
                                if (strNextName3.equals("execution")) {
                                    b4 = 1;
                                    break;
                                }
                                break;
                            case 555169704:
                                if (strNextName3.equals("customAttributes")) {
                                    b4 = 2;
                                    break;
                                }
                                break;
                            case 928737948:
                                if (strNextName3.equals("uiOrientation")) {
                                    b4 = 3;
                                    break;
                                }
                                break;
                        }
                        if (b4 == 0) {
                            ValueOf2 = Boolean.valueOf(jsonReader.nextBoolean());
                        } else if (b4 == 1) {
                            jsonReader.beginObject();
                            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6616c = null;
                            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = null;
                            ImmutableList3 immutableList3M6614a = null;
                            ImmutableList3 immutableList3M6614a2 = null;
                            while (jsonReader.hasNext()) {
                                String strNextName4 = jsonReader.nextName();
                                strNextName4.hashCode();
                                switch (strNextName4.hashCode()) {
                                    case -1337936983:
                                        b5 = !strNextName4.equals("threads") ? (byte) -1 : (byte) 0;
                                        break;
                                    case -902467928:
                                        if (strNextName4.equals("signal")) {
                                            b5 = 1;
                                            break;
                                        }
                                        break;
                                    case 937615455:
                                        if (strNextName4.equals("binaries")) {
                                            b5 = 2;
                                            break;
                                        }
                                        break;
                                    case 1481625679:
                                        if (strNextName4.equals("exception")) {
                                            b5 = 3;
                                            break;
                                        }
                                        break;
                                }
                                if (b5 == 0) {
                                    immutableList3M6614a2 = m6614a(jsonReader, CrashlyticsReportJsonTransform4.f12652a);
                                } else if (b5 == 1) {
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
                                                b6 = (iHashCode == 3373707 && strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) ? (byte) 2 : (byte) -1;
                                            } else if (strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                                                b6 = 1;
                                            }
                                        } else if (strNextName5.equals("address")) {
                                            b6 = 0;
                                        }
                                        if (b6 == 0) {
                                            lValueOf2 = Long.valueOf(jsonReader.nextLong());
                                        } else if (b6 == 1) {
                                            String strNextString = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString, "Null code");
                                            str3 = strNextString;
                                        } else if (b6 != 2) {
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
                                } else if (b5 == 2) {
                                    immutableList3M6614a = m6614a(jsonReader, CrashlyticsReportJsonTransform5.f12653a);
                                } else if (b5 != c) {
                                    jsonReader.skipValue();
                                } else {
                                    abstractC13236bM6616c = m6616c(jsonReader);
                                }
                                c = 3;
                            }
                            jsonReader.endObject();
                            String strM883w3 = immutableList3M6614a2 == null ? " threads" : "";
                            if (abstractC13236bM6616c == null) {
                                strM883w3 = outline.m883w(strM883w3, " exception");
                            }
                            if (autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal == null) {
                                strM883w3 = outline.m883w(strM883w3, " signal");
                            }
                            if (immutableList3M6614a == null) {
                                strM883w3 = outline.m883w(strM883w3, " binaries");
                            }
                            if (!strM883w3.isEmpty()) {
                                throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w3));
                            }
                            autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3M6614a2, abstractC13236bM6616c, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, immutableList3M6614a, null);
                        } else if (b4 == 2) {
                            M6614a = m6614a(jsonReader, CrashlyticsReportJsonTransform3.f12651a);
                        } else if (b4 != 3) {
                            jsonReader.skipValue();
                        } else {
                            ValueOf = Integer.valueOf(jsonReader.nextInt());
                        }
                    } else {
                        jsonReader.endObject();
                        strM883w = autoValue_CrashlyticsReport_Session_Event_Application_Execution == 0 ? " execution" : "";
                        if (ValueOf == 0) {
                            strM883w = outline.m883w(strM883w, " uiOrientation");
                        }
                        if (!strM883w.isEmpty()) {
                            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                        }
                        autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, M6614a, ValueOf2, ValueOf.intValue(), null);
                    }
                }
            } else if (b2 == 2) {
                jsonReader.beginObject();
                ?? NextString = ValueOf;
                while (jsonReader.hasNext()) {
                    String strNextName6 = jsonReader.nextName();
                    strNextName6.hashCode();
                    if (strNextName6.equals("content")) {
                        NextString = jsonReader.nextString();
                        Objects.requireNonNull(NextString, "Null content");
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                strM883w = NextString == 0 ? " content" : "";
                if (!strM883w.isEmpty()) {
                    throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                }
                autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(NextString, ValueOf);
            } else if (b2 == 3) {
                String strNextString3 = jsonReader.nextString();
                Objects.requireNonNull(strNextString3, "Null type");
                str = strNextString3;
            } else if (b2 != 4) {
                jsonReader.skipValue();
            } else {
                lValueOf = Long.valueOf(jsonReader.nextLong());
            }
            ValueOf = 0;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: c */
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
    /* JADX INFO: renamed from: d */
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
      0x021a: PHI (r17v18 java.lang.String) = 
      (r17v10 java.lang.String)
      (r17v11 java.lang.String)
      (r17v12 java.lang.String)
      (r17v13 java.lang.String)
      (r17v14 java.lang.String)
      (r17v16 java.lang.String)
      (r17v19 java.lang.String)
     binds: [B:146:0x0215, B:142:0x020a, B:138:0x01fd, B:414:?, B:413:?, B:412:?, B:123:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012b  */
    @NonNull
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport m6618e(@NonNull JsonReader jsonReader) throws IOException {
        byte b2;
        String str;
        byte b3;
        String str2;
        byte b4;
        Charset charset = CrashlyticsReport.f12647a;
        AutoValue_CrashlyticsReport.b bVar = new AutoValue_CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -2118372775:
                    b2 = !strNextName.equals("ndkPayload") ? (byte) -1 : (byte) 0;
                    break;
                case -1962630338:
                    if (strNextName.equals("sdkVersion")) {
                        b2 = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (strNextName.equals("buildVersion")) {
                        b2 = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (strNextName.equals("gmpAppId")) {
                        b2 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (strNextName.equals("installationUuid")) {
                        b2 = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (strNextName.equals("platform")) {
                        b2 = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (strNextName.equals("displayVersion")) {
                        b2 = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (strNextName.equals("session")) {
                        b2 = 7;
                        break;
                    }
                    break;
            }
            String str3 = "";
            switch (b2) {
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
                                            b3 = !strNextName5.equals("buildVersion") ? (byte) -1 : (byte) 0;
                                            break;
                                        case -293026577:
                                            if (strNextName5.equals("jailbroken")) {
                                                b3 = 1;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (strNextName5.equals("version")) {
                                                b3 = 2;
                                                break;
                                            }
                                            break;
                                        case 1874684019:
                                            if (strNextName5.equals("platform")) {
                                                b3 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    if (b3 == 0) {
                                        String strNextString10 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString10, "Null buildVersion");
                                        str6 = strNextString10;
                                    } else if (b3 == 1) {
                                        boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                                    } else if (b3 == 2) {
                                        String strNextString11 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString11, "Null version");
                                        str5 = strNextString11;
                                    } else if (b3 != 3) {
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
                                            b4 = !strNextName6.equals("identifier") ? (byte) -1 : (byte) 0;
                                            break;
                                        case -519438642:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatform")) {
                                                b4 = 1;
                                                break;
                                            }
                                            break;
                                        case 213652010:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatformVersion")) {
                                                b4 = 2;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (!strNextName6.equals("version")) {
                                                str2 = str3;
                                            } else {
                                                b4 = 3;
                                                str2 = str3;
                                            }
                                            break;
                                        case 719853845:
                                            if (!strNextName6.equals("installationUuid")) {
                                                str2 = str3;
                                            } else {
                                                b4 = 4;
                                                str2 = str3;
                                            }
                                            break;
                                        case 1975623094:
                                            if (!strNextName6.equals("displayVersion")) {
                                                str2 = str3;
                                            } else {
                                                b4 = 5;
                                                str2 = str3;
                                            }
                                            break;
                                        default:
                                            str2 = str3;
                                            break;
                                    }
                                    if (b4 == 0) {
                                        String strNextString16 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString16, "Null identifier");
                                        str7 = strNextString16;
                                    } else if (b4 == 1) {
                                        strNextString14 = jsonReader.nextString();
                                    } else if (b4 == 2) {
                                        strNextString15 = jsonReader.nextString();
                                    } else if (b4 == 3) {
                                        String strNextString17 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString17, "Null version");
                                        str8 = strNextString17;
                                    } else if (b4 == 4) {
                                        strNextString13 = jsonReader.nextString();
                                    } else if (b4 != 5) {
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
    /* JADX INFO: renamed from: f */
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
    /* JADX INFO: renamed from: g */
    public String m6620g(@NonNull CrashlyticsReport crashlyticsReport) {
        return ((JsonDataEncoderBuilder4) f12656a).m6711a(crashlyticsReport);
    }
}
