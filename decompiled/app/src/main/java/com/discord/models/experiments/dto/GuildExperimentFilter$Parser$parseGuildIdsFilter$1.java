package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildIdsFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentFilter.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.skipValue();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {

        /* compiled from: GuildExperimentFilter.kt */
        /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Long> {
            public AnonymousClass1() {
            }

            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public /* bridge */ /* synthetic */ Long get() {
                return get();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final Long get() {
                return GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.nextLongOrNull();
            }
        }

        public AnonymousClass2() {
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
        @Override // java.lang.Runnable
        public final void run() {
            GuildExperimentFilter$Parser$parseGuildIdsFilter$1 guildExperimentFilter$Parser$parseGuildIdsFilter$1 = GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this;
            guildExperimentFilter$Parser$parseGuildIdsFilter$1.$guildIds.element = guildExperimentFilter$Parser$parseGuildIdsFilter$1.$reader.nextList(new AnonymousClass1());
        }
    }

    public GuildExperimentFilter$Parser$parseGuildIdsFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$guildIds = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new AnonymousClass1(), new AnonymousClass2());
    }
}
