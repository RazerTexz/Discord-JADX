package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentPopulationDto;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$4 implements Runnable {
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $populations;

    /* compiled from: GuildExperimentDto.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$4$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<GuildExperimentPopulationDto> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ GuildExperimentPopulationDto get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final GuildExperimentPopulationDto get() {
            return GuildExperimentPopulationDto.Parser.INSTANCE.parse(GuildExperimentDto$Parser$parse$4.this.$jsonReader);
        }
    }

    public GuildExperimentDto$Parser$parse$4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$populations = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$populations.element = this.$jsonReader.nextList(new AnonymousClass1());
    }
}
