package com.discord.api.report;

import b.a.w.TypeTokens;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final class ReportNodeElementDataTypeAdapter extends TypeAdapter<ReportNodeElementData> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeElementData read(JsonReader jsonReader) throws JsonSyntaxException, JsonIOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "reader");
        Object objD = new Gson().d(jsonReader, TypeTokens.a);
        Intrinsics3.checkNotNullExpressionValue(objD, "Gson().fromJson(reader, STRING_LIST_TYPE)");
        List list = (List) objD;
        return new ReportNodeElementData((String) list.get(0), (String) list.get(1));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeElementData reportNodeElementData) throws IOException {
        ReportNodeElementData reportNodeElementData2 = reportNodeElementData;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (reportNodeElementData2 == null) {
            jsonWriter.s();
        } else {
            jsonWriter.b().H(reportNodeElementData2.getElementKey()).H(reportNodeElementData2.getElementValue()).e();
        }
    }
}
