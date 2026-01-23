package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $filters;
    public final /* synthetic */ Model.JsonReader $jsonReader;

    public GuildExperimentPopulationDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$filters = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$filters.element = GuildExperimentFilter.Parser.INSTANCE.parseFilters(this.$jsonReader);
    }
}
