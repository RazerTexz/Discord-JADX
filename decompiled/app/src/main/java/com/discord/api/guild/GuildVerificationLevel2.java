package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* compiled from: GuildVerificationLevel.kt */
/* renamed from: com.discord.api.guild.GuildVerificationLevelTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildVerificationLevel2 extends TypeAdapter<GuildVerificationLevel> {
    @Override // com.google.gson.TypeAdapter
    public GuildVerificationLevel read(JsonReader jsonReader) throws IOException {
        GuildVerificationLevel guildVerificationLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        GuildVerificationLevel[] guildVerificationLevelArrValues = GuildVerificationLevel.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                guildVerificationLevel = null;
                break;
            }
            guildVerificationLevel = guildVerificationLevelArrValues[i];
            if (guildVerificationLevel.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return guildVerificationLevel != null ? guildVerificationLevel : GuildVerificationLevel.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildVerificationLevel guildVerificationLevel) throws IOException {
        GuildVerificationLevel guildVerificationLevel2 = guildVerificationLevel;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildVerificationLevel2 != null) {
            jsonWriter.D(Integer.valueOf(guildVerificationLevel2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
