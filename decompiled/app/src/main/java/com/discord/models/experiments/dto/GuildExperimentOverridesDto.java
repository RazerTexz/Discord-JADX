package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentOverridesDto {
    private final int bucket;
    private final List<Long> guilds;

    /* compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentOverridesDto parse(Model.JsonReader reader) throws IOException {
            m.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = n.emptyList();
            reader.nextObject(new GuildExperimentOverridesDto$Parser$parse$1(ref$IntRef, reader, ref$ObjectRef));
            return new GuildExperimentOverridesDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentOverridesDto(int i, List<Long> list) {
        m.checkNotNullParameter(list, "guilds");
        this.bucket = i;
        this.guilds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentOverridesDto copy$default(GuildExperimentOverridesDto guildExperimentOverridesDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentOverridesDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentOverridesDto.guilds;
        }
        return guildExperimentOverridesDto.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> component2() {
        return this.guilds;
    }

    public final GuildExperimentOverridesDto copy(int bucket, List<Long> guilds) {
        m.checkNotNullParameter(guilds, "guilds");
        return new GuildExperimentOverridesDto(bucket, guilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentOverridesDto)) {
            return false;
        }
        GuildExperimentOverridesDto guildExperimentOverridesDto = (GuildExperimentOverridesDto) other;
        return this.bucket == guildExperimentOverridesDto.bucket && m.areEqual(this.guilds, guildExperimentOverridesDto.guilds);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> getGuilds() {
        return this.guilds;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<Long> list = this.guilds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildExperimentOverridesDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", guilds=");
        return a.L(sbU, this.guilds, ")");
    }
}
