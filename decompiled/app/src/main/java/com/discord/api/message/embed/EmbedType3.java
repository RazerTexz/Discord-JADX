package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* compiled from: EmbedType.kt */
/* renamed from: com.discord.api.message.embed.EmbedTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class EmbedType3 extends TypeAdapter<EmbedType> {
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        EmbedType embedType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        EmbedType[] embedTypeArrA = EmbedType2.a();
        int length = embedTypeArrA.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                embedType = null;
                break;
            }
            embedType = embedTypeArrA[i];
            if (Intrinsics3.areEqual(embedType.getApiValue(), strJ)) {
                break;
            }
            i++;
        }
        return embedType != null ? embedType : EmbedType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, EmbedType embedType) throws IOException {
        EmbedType embedType2 = embedType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.H(embedType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
