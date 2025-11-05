package com.discord.models.experiments.dto;

import com.discord.api.guild.GuildFeature;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import d0.t.u;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $features;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentFilter.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader.skipValue();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {

        /* compiled from: GuildExperimentFilter.kt */
        /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<GuildFeature> {
            public AnonymousClass1() {
            }

            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public /* bridge */ /* synthetic */ GuildFeature get() {
                return get();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final GuildFeature get() {
                return (GuildFeature) InboundGatewayGsonParser.fromJson(GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader, GuildFeature.class);
            }
        }

        public AnonymousClass2() {
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Set] */
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 = GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this;
            Ref$ObjectRef ref$ObjectRef = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$features;
            List listNextList = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$reader.nextList(new AnonymousClass1());
            m.checkNotNullExpressionValue(listNextList, "reader.nextList {\n      …ass.java)\n              }");
            ref$ObjectRef.element = u.toSet(listNextList);
        }
    }

    public GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$features = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new AnonymousClass1(), new AnonymousClass2());
    }
}
