package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* compiled from: GuildExplicitContentFilter.kt */
/* loaded from: classes.dex */
public final class GuildExplicitContentFilterTypeAdapter extends TypeAdapter<GuildExplicitContentFilter> {
    @Override // com.google.gson.TypeAdapter
    public GuildExplicitContentFilter read(JsonReader jsonReader) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter;
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        GuildExplicitContentFilter[] guildExplicitContentFilterArrValues = GuildExplicitContentFilter.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                guildExplicitContentFilter = null;
                break;
            }
            guildExplicitContentFilter = guildExplicitContentFilterArrValues[i];
            if (guildExplicitContentFilter.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return guildExplicitContentFilter != null ? guildExplicitContentFilter : GuildExplicitContentFilter.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildExplicitContentFilter guildExplicitContentFilter) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter2 = guildExplicitContentFilter;
        m.checkNotNullParameter(jsonWriter, "out");
        if (guildExplicitContentFilter2 != null) {
            jsonWriter.D(Integer.valueOf(guildExplicitContentFilter2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
