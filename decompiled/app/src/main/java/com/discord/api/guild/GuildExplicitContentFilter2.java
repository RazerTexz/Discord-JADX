package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildExplicitContentFilter.kt */
/* renamed from: com.discord.api.guild.GuildExplicitContentFilterTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildExplicitContentFilter2 extends TypeAdapter<GuildExplicitContentFilter> {
    @Override // com.google.gson.TypeAdapter
    public GuildExplicitContentFilter read(JsonReader jsonReader) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        GuildExplicitContentFilter[] guildExplicitContentFilterArrValues = GuildExplicitContentFilter.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                guildExplicitContentFilter = null;
                break;
            }
            guildExplicitContentFilter = guildExplicitContentFilterArrValues[i];
            if (guildExplicitContentFilter.getApiValue() == iMo6891y) {
                break;
            }
            i++;
        }
        return guildExplicitContentFilter != null ? guildExplicitContentFilter : GuildExplicitContentFilter.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildExplicitContentFilter guildExplicitContentFilter) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter2 = guildExplicitContentFilter;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildExplicitContentFilter2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildExplicitContentFilter2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
