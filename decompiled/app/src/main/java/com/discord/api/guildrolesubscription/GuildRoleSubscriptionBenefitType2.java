package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;

/* compiled from: GuildRoleSubscriptionBenefitType.kt */
/* renamed from: com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildRoleSubscriptionBenefitType2 extends TypeAdapter<GuildRoleSubscriptionBenefitType> {
    @Override // com.google.gson.TypeAdapter
    public GuildRoleSubscriptionBenefitType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        GuildRoleSubscriptionBenefitType.Companion companion = GuildRoleSubscriptionBenefitType.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        return iY != 1 ? iY != 2 ? GuildRoleSubscriptionBenefitType.UNKNOWN : GuildRoleSubscriptionBenefitType.INTANGIBLE : GuildRoleSubscriptionBenefitType.CHANNEL;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) throws IOException {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = guildRoleSubscriptionBenefitType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildRoleSubscriptionBenefitType2 != null) {
            jsonWriter.D(Integer.valueOf(guildRoleSubscriptionBenefitType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
