package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentPopulationDto {
    private final List<GuildExperimentBucketDto> buckets;
    private final List<GuildExperimentFilter> filters;

    /* compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public final GuildExperimentPopulationDto parse(Model.JsonReader jsonReader) throws IOException {
            Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(jsonReader, "jsonReader");
            ref$ObjectRefM844c0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            jsonReader.nextListIndexed(new GuildExperimentPopulationDto$Parser$parse$1(ref$ObjectRefM844c0, jsonReader), new GuildExperimentPopulationDto$Parser$parse$2(ref$ObjectRef, jsonReader));
            List list = (List) ref$ObjectRefM844c0.element;
            Intrinsics3.checkNotNull(list);
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new GuildExperimentPopulationDto(list, listEmptyList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentPopulationDto(List<GuildExperimentBucketDto> list, List<? extends GuildExperimentFilter> list2) {
        Intrinsics3.checkNotNullParameter(list, "buckets");
        Intrinsics3.checkNotNullParameter(list2, "filters");
        this.buckets = list;
        this.filters = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentPopulationDto copy$default(GuildExperimentPopulationDto guildExperimentPopulationDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildExperimentPopulationDto.buckets;
        }
        if ((i & 2) != 0) {
            list2 = guildExperimentPopulationDto.filters;
        }
        return guildExperimentPopulationDto.copy(list, list2);
    }

    public final List<GuildExperimentBucketDto> component1() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> component2() {
        return this.filters;
    }

    public final GuildExperimentPopulationDto copy(List<GuildExperimentBucketDto> buckets, List<? extends GuildExperimentFilter> filters) {
        Intrinsics3.checkNotNullParameter(buckets, "buckets");
        Intrinsics3.checkNotNullParameter(filters, "filters");
        return new GuildExperimentPopulationDto(buckets, filters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentPopulationDto)) {
            return false;
        }
        GuildExperimentPopulationDto guildExperimentPopulationDto = (GuildExperimentPopulationDto) other;
        return Intrinsics3.areEqual(this.buckets, guildExperimentPopulationDto.buckets) && Intrinsics3.areEqual(this.filters, guildExperimentPopulationDto.filters);
    }

    public final List<GuildExperimentBucketDto> getBuckets() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        List<GuildExperimentBucketDto> list = this.buckets;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildExperimentFilter> list2 = this.filters;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildExperimentPopulationDto(buckets=");
        sbM833U.append(this.buckets);
        sbM833U.append(", filters=");
        return outline.m824L(sbM833U, this.filters, ")");
    }
}
