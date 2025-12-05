package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StickerType.kt */
/* renamed from: com.discord.api.sticker.StickerTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class StickerType2 extends TypeAdapter<StickerType> {
    @Override // com.google.gson.TypeAdapter
    public StickerType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return StickerType.INSTANCE.m8244a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerType stickerType) throws IOException {
        StickerType stickerType2 = stickerType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stickerType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(stickerType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
