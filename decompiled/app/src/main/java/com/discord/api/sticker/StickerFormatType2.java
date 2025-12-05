package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StickerFormatType.kt */
/* renamed from: com.discord.api.sticker.StickerFormatTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class StickerFormatType2 extends TypeAdapter<StickerFormatType> {
    @Override // com.google.gson.TypeAdapter
    public StickerFormatType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return StickerFormatType.INSTANCE.m8242a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerFormatType stickerFormatType) throws IOException {
        StickerFormatType stickerFormatType2 = stickerFormatType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stickerFormatType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(stickerFormatType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
