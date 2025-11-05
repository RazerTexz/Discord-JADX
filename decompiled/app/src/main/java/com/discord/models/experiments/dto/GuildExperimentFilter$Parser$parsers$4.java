package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildExperimentFilter.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class GuildExperimentFilter$Parser$parsers$4 extends k implements Function1<Model.JsonReader, GuildExperimentFilter.GuildHasFeatureFilter> {
    public GuildExperimentFilter$Parser$parsers$4(GuildExperimentFilter.Parser parser) {
        super(1, parser, GuildExperimentFilter.Parser.class, "parseGuildHasFeatureFilter", "parseGuildHasFeatureFilter(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildExperimentFilter.GuildHasFeatureFilter invoke(Model.JsonReader jsonReader) {
        return invoke2(jsonReader);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildExperimentFilter.GuildHasFeatureFilter invoke2(Model.JsonReader jsonReader) {
        m.checkNotNullParameter(jsonReader, "p1");
        return GuildExperimentFilter.Parser.access$parseGuildHasFeatureFilter((GuildExperimentFilter.Parser) this.receiver, jsonReader);
    }
}
