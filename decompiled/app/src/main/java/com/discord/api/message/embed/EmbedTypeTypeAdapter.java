package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* compiled from: EmbedType.kt */
/* loaded from: classes.dex */
public final class EmbedTypeTypeAdapter extends TypeAdapter<EmbedType> {
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        EmbedType embedType;
        m.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        EmbedType[] embedTypeArrA = EmbedTypeKt.a();
        int length = embedTypeArrA.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                embedType = null;
                break;
            }
            embedType = embedTypeArrA[i];
            if (m.areEqual(embedType.getApiValue(), strJ)) {
                break;
            }
            i++;
        }
        return embedType != null ? embedType : EmbedType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, EmbedType embedType) throws IOException {
        EmbedType embedType2 = embedType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.H(embedType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
