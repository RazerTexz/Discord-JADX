package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.message.embed.EmbedTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: EmbedType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmbedType3 extends TypeAdapter<EmbedType> {
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        EmbedType embedType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strMo6877J = jsonReader.mo6877J();
        EmbedType[] embedTypeArrM8093a = EmbedType2.m8093a();
        int length = embedTypeArrM8093a.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                embedType = null;
                break;
            }
            embedType = embedTypeArrM8093a[i];
            if (Intrinsics3.areEqual(embedType.getApiValue(), strMo6877J)) {
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
            jsonWriter.mo6895H(embedType2.getApiValue());
        } else {
            jsonWriter.mo6905s();
        }
    }
}
