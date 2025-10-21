package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildExperimentFilter.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class GuildExperimentFilter$Parser$parsers$5 extends FunctionReferenceImpl implements Function1<Model.JsonReader, GuildExperimentFilter.GuildHubTypesFeatureFilter> {
    public GuildExperimentFilter$Parser$parsers$5(GuildExperimentFilter.Parser parser) {
        super(1, parser, GuildExperimentFilter.Parser.class, "parseGuildHubTypesFeatureFilter", "parseGuildHubTypesFeatureFilter(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildExperimentFilter.GuildHubTypesFeatureFilter invoke(Model.JsonReader jsonReader) {
        return invoke2(jsonReader);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildExperimentFilter.GuildHubTypesFeatureFilter invoke2(Model.JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "p1");
        return GuildExperimentFilter.Parser.access$parseGuildHubTypesFeatureFilter((GuildExperimentFilter.Parser) this.receiver, jsonReader);
    }
}
