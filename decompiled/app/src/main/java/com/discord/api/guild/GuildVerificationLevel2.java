package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guild.GuildVerificationLevelTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildVerificationLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildVerificationLevel2 extends TypeAdapter<GuildVerificationLevel> {
    @Override // com.google.gson.TypeAdapter
    public GuildVerificationLevel read(JsonReader jsonReader) throws IOException {
        GuildVerificationLevel guildVerificationLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        GuildVerificationLevel[] guildVerificationLevelArrValues = GuildVerificationLevel.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                guildVerificationLevel = null;
                break;
            }
            guildVerificationLevel = guildVerificationLevelArrValues[i];
            if (guildVerificationLevel.getApiValue() == iMo6891y) {
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
            jsonWriter.mo6894D(Integer.valueOf(guildVerificationLevel2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
