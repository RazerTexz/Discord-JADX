package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityType2 extends TypeAdapter<GuildScheduledEventEntityType> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventEntityType read(JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return GuildScheduledEventEntityType.INSTANCE.m7993a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventEntityType guildScheduledEventEntityType) throws IOException {
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = guildScheduledEventEntityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventEntityType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildScheduledEventEntityType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
