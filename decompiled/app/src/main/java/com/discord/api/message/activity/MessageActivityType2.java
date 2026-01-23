package com.discord.api.message.activity;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.message.activity.MessageActivityTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: MessageActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageActivityType2 extends TypeAdapter<MessageActivityType> {
    @Override // com.google.gson.TypeAdapter
    public MessageActivityType read(JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return MessageActivityType.INSTANCE.m8059a(AnimatableValueParser.m549n1(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, MessageActivityType messageActivityType) throws IOException {
        MessageActivityType messageActivityType2 = messageActivityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (messageActivityType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(messageActivityType2.getApiInt()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
