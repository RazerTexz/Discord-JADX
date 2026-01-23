package com.discord.models.experiments.dto;

import com.discord.api.guild.GuildHubType;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $hubTypes;
    public final /* synthetic */ Model.JsonReader $reader;

    /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$1 */
    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final class RunnableC55531 implements Runnable {
        public RunnableC55531() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1.this.$reader.skipValue();
        }
    }

    /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$2 */
    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final class RunnableC55542 implements Runnable {

        /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: GuildExperimentFilter.kt */
        public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<GuildHubType> {
            public AnonymousClass1() {
            }

            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public /* bridge */ /* synthetic */ GuildHubType get() {
                return get();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final GuildHubType get() {
                return (GuildHubType) InboundGatewayGsonParser.fromJson(GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1.this.$reader, GuildHubType.class);
            }
        }

        public RunnableC55542() {
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Set] */
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 = GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1.this;
            Ref$ObjectRef ref$ObjectRef = guildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1.$hubTypes;
            List listNextList = guildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1.$reader.nextList(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(listNextList, "reader.nextList {\n      …ass.java)\n              }");
            ref$ObjectRef.element = _Collections.toSet(listNextList);
        }
    }

    public GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$hubTypes = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new RunnableC55531(), new RunnableC55542());
    }
}
