package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import b.i.c.m.d.m.b;
import b.i.c.m.d.m.f;
import b.i.c.m.d.m.i;
import b.i.c.m.d.m.j;
import b.i.c.m.d.m.k;
import b.i.c.m.d.m.l;
import b.i.c.m.d.m.n;
import b.i.c.m.d.m.o;
import b.i.c.m.d.m.q;
import b.i.c.m.d.m.r;
import b.i.c.m.d.m.s;
import b.i.c.m.d.m.t;
import b.i.c.m.d.m.u;
import b.i.c.m.d.m.v;
import b.i.c.m.d.m.w;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* loaded from: classes3.dex */
public class h {
    public static final b.i.c.p.a a;

    /* compiled from: CrashlyticsReportJsonTransform.java */
    public interface a<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        b.i.c.p.h.e eVar = new b.i.c.p.h.e();
        ((b.i.c.m.d.m.a) b.i.c.m.d.m.a.a).a(eVar);
        eVar.e = true;
        a = new b.i.c.p.h.d(eVar);
    }

    @NonNull
    public static <T> w<T> a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return new w<>(arrayList);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static v.d.AbstractC0143d b(@NonNull JsonReader jsonReader) throws IOException {
        String strW;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        jsonReader.beginObject();
        Long lValueOf = null;
        Integer numValueOf = 0;
        String str = null;
        k kVar = null;
        v.d.AbstractC0143d.b bVarA = null;
        s sVar = null;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                strW = lValueOf == null ? " timestamp" : "";
                if (str == null) {
                    strW = b.d.b.a.a.w(strW, " type");
                }
                if (kVar == null) {
                    strW = b.d.b.a.a.w(strW, " app");
                }
                if (bVarA == null) {
                    strW = b.d.b.a.a.w(strW, " device");
                }
                if (strW.isEmpty()) {
                    return new j(lValueOf.longValue(), str, kVar, bVarA, sVar, null);
                }
                throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -1335157162:
                    if (!strNextName.equals("device")) {
                        c = 65535;
                    } else {
                        c = 0;
                    }
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
                r.b bVar = new r.b();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    switch (strNextName2.hashCode()) {
                        case -1708606089:
                            if (!strNextName2.equals("batteryLevel")) {
                                c2 = 65535;
                            } else {
                                c2 = 0;
                            }
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
                        bVar.a = Double.valueOf(jsonReader.nextDouble());
                    } else if (c2 == 1) {
                        bVar.f1734b = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 2) {
                        bVar.d = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 3) {
                        bVar.f = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 == 4) {
                        bVar.e = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarA = bVar.a();
            } else if (c == 1) {
                jsonReader.beginObject();
                l lVar = numValueOf;
                w wVarA = lVar;
                Boolean boolValueOf = wVarA;
                while (true) {
                    char c6 = 3;
                    if (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3.hashCode()) {
                            case -1332194002:
                                if (!strNextName3.equals("background")) {
                                    c3 = 65535;
                                } else {
                                    c3 = 0;
                                }
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
                            v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146bC = null;
                            o oVar = null;
                            w wVarA2 = null;
                            w wVarA3 = null;
                            while (jsonReader.hasNext()) {
                                String strNextName4 = jsonReader.nextName();
                                strNextName4.hashCode();
                                switch (strNextName4.hashCode()) {
                                    case -1337936983:
                                        if (!strNextName4.equals("threads")) {
                                            c4 = 65535;
                                        } else {
                                            c4 = 0;
                                        }
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
                                    wVarA3 = a(jsonReader, d.a);
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
                                    String strW2 = str2 == null ? " name" : "";
                                    if (str3 == null) {
                                        strW2 = b.d.b.a.a.w(strW2, " code");
                                    }
                                    if (lValueOf2 == null) {
                                        strW2 = b.d.b.a.a.w(strW2, " address");
                                    }
                                    if (!strW2.isEmpty()) {
                                        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW2));
                                    }
                                    oVar = new o(str2, str3, lValueOf2.longValue(), null);
                                } else if (c4 == 2) {
                                    wVarA2 = a(jsonReader, e.a);
                                } else if (c4 != c6) {
                                    jsonReader.skipValue();
                                } else {
                                    abstractC0146bC = c(jsonReader);
                                }
                                c6 = 3;
                            }
                            jsonReader.endObject();
                            String strW3 = wVarA3 == null ? " threads" : "";
                            if (abstractC0146bC == null) {
                                strW3 = b.d.b.a.a.w(strW3, " exception");
                            }
                            if (oVar == null) {
                                strW3 = b.d.b.a.a.w(strW3, " signal");
                            }
                            if (wVarA2 == null) {
                                strW3 = b.d.b.a.a.w(strW3, " binaries");
                            }
                            if (!strW3.isEmpty()) {
                                throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW3));
                            }
                            lVar = new l(wVarA3, abstractC0146bC, oVar, wVarA2, null);
                        } else if (c3 == 2) {
                            wVarA = a(jsonReader, c.a);
                        } else if (c3 != 3) {
                            jsonReader.skipValue();
                        } else {
                            numValueOf = Integer.valueOf(jsonReader.nextInt());
                        }
                    } else {
                        jsonReader.endObject();
                        strW = lVar == null ? " execution" : "";
                        if (numValueOf == 0) {
                            strW = b.d.b.a.a.w(strW, " uiOrientation");
                        }
                        if (!strW.isEmpty()) {
                            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
                        }
                        kVar = new k(lVar, wVarA, boolValueOf, numValueOf.intValue(), null);
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
                strW = strNextString3 == null ? " content" : "";
                if (!strW.isEmpty()) {
                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
                }
                sVar = new s(strNextString3, numValueOf);
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
    public static v.d.AbstractC0143d.a.b.AbstractC0146b c(@NonNull JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Integer numValueOf = null;
        String strNextString = null;
        String strNextString2 = null;
        w wVarA = null;
        v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146bC = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    wVarA = a(jsonReader, f.a);
                    break;
                case "reason":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "type":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null type");
                    break;
                case "causedBy":
                    abstractC0146bC = c(jsonReader);
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
        String strW = strNextString == null ? " type" : "";
        if (wVarA == null) {
            strW = b.d.b.a.a.w(strW, " frames");
        }
        if (numValueOf == null) {
            strW = b.d.b.a.a.w(strW, " overflowCount");
        }
        if (strW.isEmpty()) {
            return new n(strNextString, strNextString2, wVarA, abstractC0146bC, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    @NonNull
    public static v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a d(@NonNull JsonReader jsonReader) throws IOException {
        q.b bVar = new q.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    bVar.d = Long.valueOf(jsonReader.nextLong());
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null symbol");
                    bVar.f1732b = strNextString;
                    break;
                case "pc":
                    bVar.a = Long.valueOf(jsonReader.nextLong());
                    break;
                case "file":
                    bVar.c = jsonReader.nextString();
                    break;
                case "importance":
                    bVar.e = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.a();
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static v e(@NonNull JsonReader jsonReader) throws IOException {
        char c;
        String str;
        char c2;
        String str2;
        char c3;
        Charset charset = v.a;
        b.C0141b c0141b = new b.C0141b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -2118372775:
                    if (!strNextName.equals("ndkPayload")) {
                        c = 65535;
                    } else {
                        c = 0;
                    }
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
                    w wVarA = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(ChatInputComponentTypes.FILES)) {
                            wVarA = a(jsonReader, b.a);
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    String str4 = wVarA == null ? " files" : "";
                    if (!str4.isEmpty()) {
                        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str4));
                    }
                    c0141b.h = new b.i.c.m.d.m.d(wVarA, strNextString, null);
                    break;
                    break;
                case 1:
                    String strNextString2 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString2, "Null sdkVersion");
                    c0141b.a = strNextString2;
                    break;
                case 2:
                    String strNextString3 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString3, "Null buildVersion");
                    c0141b.e = strNextString3;
                    break;
                case 3:
                    String strNextString4 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString4, "Null gmpAppId");
                    c0141b.f1714b = strNextString4;
                    break;
                case 4:
                    String strNextString5 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString5, "Null installationUuid");
                    c0141b.d = strNextString5;
                    break;
                case 5:
                    c0141b.c = Integer.valueOf(jsonReader.nextInt());
                    break;
                case 6:
                    String strNextString6 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString6, "Null displayVersion");
                    c0141b.f = strNextString6;
                    break;
                case 7:
                    f.b bVar = new f.b();
                    bVar.b(false);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3) {
                            case "startedAt":
                                str = str3;
                                bVar.c = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "identifier":
                                str = str3;
                                bVar.f1719b = new String(Base64.decode(jsonReader.nextString(), 2), v.a);
                                str3 = str;
                                break;
                            case "endedAt":
                                str = str3;
                                bVar.d = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "device":
                                str = str3;
                                i.b bVar2 = new i.b();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.hashCode();
                                    switch (strNextName4) {
                                        case "simulator":
                                            bVar2.f = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString7, "Null manufacturer");
                                            bVar2.h = strNextString7;
                                            break;
                                        case "ram":
                                            bVar2.d = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "arch":
                                            bVar2.a = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "diskSpace":
                                            bVar2.e = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "cores":
                                            bVar2.c = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString8, "Null model");
                                            bVar2.f1722b = strNextString8;
                                            break;
                                        case "state":
                                            bVar2.g = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString9, "Null modelClass");
                                            bVar2.i = strNextString9;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                bVar.i = bVar2.a();
                                str3 = str;
                                break;
                            case "events":
                                str = str3;
                                bVar.j = a(jsonReader, b.i.c.m.d.m.x.a.a);
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
                                            if (!strNextName5.equals("buildVersion")) {
                                                c2 = 65535;
                                                break;
                                            } else {
                                                c2 = 0;
                                                break;
                                            }
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
                                String strW = numValueOf == null ? " platform" : str;
                                if (str5 == null) {
                                    strW = b.d.b.a.a.w(strW, " version");
                                }
                                if (str6 == null) {
                                    strW = b.d.b.a.a.w(strW, " buildVersion");
                                }
                                if (boolValueOf == null) {
                                    strW = b.d.b.a.a.w(strW, " jailbroken");
                                }
                                if (!strW.isEmpty()) {
                                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
                                }
                                bVar.h = new t(numValueOf.intValue(), str5, str6, boolValueOf.booleanValue(), null);
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
                                            if (!strNextName6.equals("identifier")) {
                                                c3 = 65535;
                                                break;
                                            } else {
                                                c3 = 0;
                                                break;
                                            }
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
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        case 719853845:
                                            if (strNextName6.equals("installationUuid")) {
                                                c3 = 4;
                                                str2 = str3;
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        case 1975623094:
                                            if (strNextName6.equals("displayVersion")) {
                                                c3 = 5;
                                                str2 = str3;
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        default:
                                            str2 = str3;
                                            c3 = 65535;
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
                                String strW2 = str7 == null ? " identifier" : str;
                                if (str8 == null) {
                                    strW2 = b.d.b.a.a.w(strW2, " version");
                                }
                                if (!strW2.isEmpty()) {
                                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW2));
                                }
                                bVar.f = new b.i.c.m.d.m.g(str7, str8, strNextString12, null, strNextString13, strNextString14, strNextString15, null);
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
                                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str9));
                                }
                                bVar.g = new u(strNextString18, null);
                                str = str3;
                                str3 = str;
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                Objects.requireNonNull(strNextString19, "Null generator");
                                bVar.a = strNextString19;
                                str = str3;
                                str3 = str;
                                break;
                            case "crashed":
                                bVar.b(jsonReader.nextBoolean());
                                str = str3;
                                str3 = str;
                                break;
                            case "generatorType":
                                bVar.k = Integer.valueOf(jsonReader.nextInt());
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
                    c0141b.g = bVar.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return c0141b.a();
    }

    @NonNull
    public v f(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                v vVarE = e(jsonReader);
                jsonReader.close();
                return vVarE;
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
    public String g(@NonNull v vVar) {
        return ((b.i.c.p.h.d) a).a(vVar);
    }
}
