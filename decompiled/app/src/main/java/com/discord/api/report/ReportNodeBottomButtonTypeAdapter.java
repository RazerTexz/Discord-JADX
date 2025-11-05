package com.discord.api.report;

import com.discord.api.report.ReportNodeBottomButton;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.y.b;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;
import kotlin.Unit;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final class ReportNodeBottomButtonTypeAdapter extends TypeAdapter<ReportNodeBottomButton> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[6] = 1;
            iArr[5] = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ReportNodeBottomButton read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.U();
            return null;
        }
        jsonReader.b();
        String strJ = "";
        Object objJ = "";
        while (jsonReader.q()) {
            String strC = jsonReader.C();
            if (strC != null) {
                int iHashCode = strC.hashCode();
                if (iHashCode != -880905839) {
                    if (iHashCode == 3575610 && strC.equals("type")) {
                        strJ = jsonReader.J();
                        m.checkNotNullExpressionValue(strJ, "reader.nextString()");
                    }
                } else if (strC.equals("target")) {
                    JsonToken jsonTokenN = jsonReader.N();
                    if (jsonTokenN != null) {
                        int iOrdinal = jsonTokenN.ordinal();
                        if (iOrdinal == 5) {
                            objJ = jsonReader.J();
                        } else if (iOrdinal != 6) {
                            jsonReader.U();
                            objJ = Unit.a;
                        } else {
                            objJ = Integer.valueOf(jsonReader.y());
                        }
                        m.checkNotNullExpressionValue(objJ, "when (reader.peek()) {\n …der.skipValue()\n        }");
                    }
                }
            }
            jsonReader.U();
        }
        jsonReader.f();
        switch (strJ.hashCode()) {
            case -1367724422:
                if (strJ.equals("cancel")) {
                    return ReportNodeBottomButton.Cancel.INSTANCE;
                }
                return null;
            case -891535336:
                if (strJ.equals("submit")) {
                    return ReportNodeBottomButton.Submit.INSTANCE;
                }
                return null;
            case 3089282:
                if (strJ.equals("done")) {
                    return ReportNodeBottomButton.Done.INSTANCE;
                }
                return null;
            case 3377907:
                if (!strJ.equals("next")) {
                    return null;
                }
                Objects.requireNonNull(objJ, "null cannot be cast to non-null type kotlin.Int");
                return new ReportNodeBottomButton.Next(((Integer) objJ).intValue());
            default:
                return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeBottomButton reportNodeBottomButton) throws IOException {
        ReportNodeBottomButton reportNodeBottomButton2 = reportNodeBottomButton;
        m.checkNotNullParameter(jsonWriter, "out");
        if (reportNodeBottomButton2 == null) {
            jsonWriter.s();
            return;
        }
        JsonWriter jsonWriterN = jsonWriter.c().n("type").H(reportNodeBottomButton2.getType()).n("target");
        try {
            JsonWriter jsonWriterD = reportNodeBottomButton2 instanceof ReportNodeBottomButton.Next ? jsonWriterN.D(Integer.valueOf(((ReportNodeBottomButton.Next) reportNodeBottomButton2).getTarget())) : jsonWriterN.s();
            b.closeFinally(jsonWriterN, null);
            jsonWriterD.f();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(jsonWriterN, th);
                throw th2;
            }
        }
    }
}
