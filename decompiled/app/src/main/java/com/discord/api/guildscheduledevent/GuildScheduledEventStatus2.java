package com.discord.api.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;

/* compiled from: GuildScheduledEventStatus.kt */
/* renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventStatusTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildScheduledEventStatus2 extends TypeAdapter<GuildScheduledEventStatus> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        GuildScheduledEventStatus.Companion companion = GuildScheduledEventStatus.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        return iY != 1 ? iY != 2 ? iY != 3 ? iY != 4 ? GuildScheduledEventStatus.UNKNOWN : GuildScheduledEventStatus.CANCELED : GuildScheduledEventStatus.COMPLETED : GuildScheduledEventStatus.ACTIVE : GuildScheduledEventStatus.SCHEDULED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventStatus guildScheduledEventStatus) throws IOException {
        GuildScheduledEventStatus guildScheduledEventStatus2 = guildScheduledEventStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventStatus2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
