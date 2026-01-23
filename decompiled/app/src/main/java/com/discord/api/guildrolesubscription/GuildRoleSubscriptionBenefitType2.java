package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildRoleSubscriptionBenefitType2 extends TypeAdapter<GuildRoleSubscriptionBenefitType> {
    @Override // com.google.gson.TypeAdapter
    public GuildRoleSubscriptionBenefitType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        GuildRoleSubscriptionBenefitType.Companion companion = GuildRoleSubscriptionBenefitType.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        return iMo6891y != 1 ? iMo6891y != 2 ? GuildRoleSubscriptionBenefitType.UNKNOWN : GuildRoleSubscriptionBenefitType.INTANGIBLE : GuildRoleSubscriptionBenefitType.CHANNEL;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) throws IOException {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = guildRoleSubscriptionBenefitType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildRoleSubscriptionBenefitType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildRoleSubscriptionBenefitType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
