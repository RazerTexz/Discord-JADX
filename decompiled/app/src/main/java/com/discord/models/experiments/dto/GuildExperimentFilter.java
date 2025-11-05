package com.discord.models.experiments.dto;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.domain.Model;
import com.discord.models.experiments.domain.ExperimentHash;
import d0.o;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.LongRange;

/* compiled from: GuildExperimentFilter.kt */
/* loaded from: classes.dex */
public abstract class GuildExperimentFilter {

    /* compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildHasFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildFeature> features;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHasFeatureFilter(Set<? extends GuildFeature> set) {
            super(null);
            m.checkNotNullParameter(set, "features");
            this.features = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHasFeatureFilter copy$default(GuildHasFeatureFilter guildHasFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHasFeatureFilter.features;
            }
            return guildHasFeatureFilter.copy(set);
        }

        public final Set<GuildFeature> component1() {
            return this.features;
        }

        public final GuildHasFeatureFilter copy(Set<? extends GuildFeature> features) {
            m.checkNotNullParameter(features, "features");
            return new GuildHasFeatureFilter(features);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHasFeatureFilter) && m.areEqual(this.features, ((GuildHasFeatureFilter) other).features);
            }
            return true;
        }

        public final Set<GuildFeature> getFeatures() {
            return this.features;
        }

        public int hashCode() {
            Set<GuildFeature> set = this.features;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return a.N(a.U("GuildHasFeatureFilter(features="), this.features, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildHubTypesFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildHubType> hubTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHubTypesFeatureFilter(Set<? extends GuildHubType> set) {
            super(null);
            m.checkNotNullParameter(set, "hubTypes");
            this.hubTypes = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHubTypesFeatureFilter copy$default(GuildHubTypesFeatureFilter guildHubTypesFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHubTypesFeatureFilter.hubTypes;
            }
            return guildHubTypesFeatureFilter.copy(set);
        }

        public final Set<GuildHubType> component1() {
            return this.hubTypes;
        }

        public final GuildHubTypesFeatureFilter copy(Set<? extends GuildHubType> hubTypes) {
            m.checkNotNullParameter(hubTypes, "hubTypes");
            return new GuildHubTypesFeatureFilter(hubTypes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHubTypesFeatureFilter) && m.areEqual(this.hubTypes, ((GuildHubTypesFeatureFilter) other).hubTypes);
            }
            return true;
        }

        public final Set<GuildHubType> getHubTypes() {
            return this.hubTypes;
        }

        public int hashCode() {
            Set<GuildHubType> set = this.hubTypes;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return a.N(a.U("GuildHubTypesFeatureFilter(hubTypes="), this.hubTypes, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdRangeFilter extends GuildExperimentFilter {
        private final LongRange range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdRangeFilter(LongRange longRange) {
            super(null);
            m.checkNotNullParameter(longRange, "range");
            this.range = longRange;
        }

        public static /* synthetic */ GuildIdRangeFilter copy$default(GuildIdRangeFilter guildIdRangeFilter, LongRange longRange, int i, Object obj) {
            if ((i & 1) != 0) {
                longRange = guildIdRangeFilter.range;
            }
            return guildIdRangeFilter.copy(longRange);
        }

        /* renamed from: component1, reason: from getter */
        public final LongRange getRange() {
            return this.range;
        }

        public final GuildIdRangeFilter copy(LongRange range) {
            m.checkNotNullParameter(range, "range");
            return new GuildIdRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdRangeFilter) && m.areEqual(this.range, ((GuildIdRangeFilter) other).range);
            }
            return true;
        }

        public final LongRange getRange() {
            return this.range;
        }

        public int hashCode() {
            LongRange longRange = this.range;
            if (longRange != null) {
                return longRange.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("GuildIdRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdsFilter extends GuildExperimentFilter {
        private final Set<Long> guildIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdsFilter(Set<Long> set) {
            super(null);
            m.checkNotNullParameter(set, "guildIds");
            this.guildIds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildIdsFilter copy$default(GuildIdsFilter guildIdsFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildIdsFilter.guildIds;
            }
            return guildIdsFilter.copy(set);
        }

        public final Set<Long> component1() {
            return this.guildIds;
        }

        public final GuildIdsFilter copy(Set<Long> guildIds) {
            m.checkNotNullParameter(guildIds, "guildIds");
            return new GuildIdsFilter(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdsFilter) && m.areEqual(this.guildIds, ((GuildIdsFilter) other).guildIds);
            }
            return true;
        }

        public final Set<Long> getGuildIds() {
            return this.guildIds;
        }

        public int hashCode() {
            Set<Long> set = this.guildIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return a.N(a.U("GuildIdsFilter(guildIds="), this.guildIds, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildMemberCountRangeFilter extends GuildExperimentFilter {
        private final LongRange range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMemberCountRangeFilter(LongRange longRange) {
            super(null);
            m.checkNotNullParameter(longRange, "range");
            this.range = longRange;
        }

        public static /* synthetic */ GuildMemberCountRangeFilter copy$default(GuildMemberCountRangeFilter guildMemberCountRangeFilter, LongRange longRange, int i, Object obj) {
            if ((i & 1) != 0) {
                longRange = guildMemberCountRangeFilter.range;
            }
            return guildMemberCountRangeFilter.copy(longRange);
        }

        /* renamed from: component1, reason: from getter */
        public final LongRange getRange() {
            return this.range;
        }

        public final GuildMemberCountRangeFilter copy(LongRange range) {
            m.checkNotNullParameter(range, "range");
            return new GuildMemberCountRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildMemberCountRangeFilter) && m.areEqual(this.range, ((GuildMemberCountRangeFilter) other).range);
            }
            return true;
        }

        public final LongRange getRange() {
            return this.range;
        }

        public int hashCode() {
            LongRange longRange = this.range;
            if (longRange != null) {
                return longRange.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("GuildMemberCountRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    public static final class Parser {
        public static final Parser INSTANCE;
        private static final long MAX_ID_HASH;
        private static final long MIN_ID_HASH;
        private static final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> parsers;

        static {
            Parser parser = new Parser();
            INSTANCE = parser;
            ExperimentHash experimentHash = ExperimentHash.INSTANCE;
            parsers = h0.mapOf(o.to(Long.valueOf(experimentHash.from("guild_ids")), new GuildExperimentFilter$Parser$parsers$1(parser)), o.to(Long.valueOf(experimentHash.from("guild_id_range")), new GuildExperimentFilter$Parser$parsers$2(parser)), o.to(Long.valueOf(experimentHash.from("guild_member_count_range")), new GuildExperimentFilter$Parser$parsers$3(parser)), o.to(Long.valueOf(experimentHash.from("guild_has_feature")), new GuildExperimentFilter$Parser$parsers$4(parser)), o.to(Long.valueOf(experimentHash.from("guild_hub_types")), new GuildExperimentFilter$Parser$parsers$5(parser)));
            MIN_ID_HASH = experimentHash.from("min_id");
            MAX_ID_HASH = experimentHash.from("max_id");
        }

        private Parser() {
        }

        public static final /* synthetic */ long access$getMAX_ID_HASH$p(Parser parser) {
            return MAX_ID_HASH;
        }

        public static final /* synthetic */ long access$getMIN_ID_HASH$p(Parser parser) {
            return MIN_ID_HASH;
        }

        public static final /* synthetic */ GuildHasFeatureFilter access$parseGuildHasFeatureFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildHasFeatureFilter(jsonReader);
        }

        public static final /* synthetic */ GuildHubTypesFeatureFilter access$parseGuildHubTypesFeatureFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildHubTypesFeatureFilter(jsonReader);
        }

        public static final /* synthetic */ GuildIdRangeFilter access$parseGuildIdRangeFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildIdRangeFilter(jsonReader);
        }

        public static final /* synthetic */ GuildIdsFilter access$parseGuildIdsFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildIdsFilter(jsonReader);
        }

        public static final /* synthetic */ GuildMemberCountRangeFilter access$parseGuildMemberCountRangeFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildMemberCountRangeFilter(jsonReader);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHasFeatureFilter parseGuildHasFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = n0.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHasFeatureFilter((Set) ref$ObjectRef.element);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHubTypesFeatureFilter parseGuildHubTypesFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = n0.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHubTypesFeatureFilter((Set) ref$ObjectRef.element);
        }

        private final GuildIdRangeFilter parseGuildIdRangeFilter(Model.JsonReader reader) {
            return new GuildIdRangeFilter(parseRange(reader));
        }

        private final GuildIdsFilter parseGuildIdsFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildIdsFilter$1(reader, ref$ObjectRef));
            List list = (List) ref$ObjectRef.element;
            m.checkNotNull(list);
            return new GuildIdsFilter(u.toSet(list));
        }

        private final GuildMemberCountRangeFilter parseGuildMemberCountRangeFilter(Model.JsonReader reader) {
            return new GuildMemberCountRangeFilter(parseRange(reader));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final LongRange parseRange(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextList(new GuildExperimentFilter$Parser$parseRange$1(reader, ref$ObjectRef, ref$ObjectRef2));
            Long l = (Long) ref$ObjectRef.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Long l2 = (Long) ref$ObjectRef2.element;
            return new LongRange(jLongValue, l2 != null ? l2.longValue() : RecyclerView.FOREVER_NS);
        }

        public final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> getParsers() {
            return parsers;
        }

        public final List<GuildExperimentFilter> parseFilters(Model.JsonReader reader) throws IOException {
            m.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            reader.nextList(new GuildExperimentFilter$Parser$parseFilters$1(reader, arrayList));
            return arrayList;
        }
    }

    private GuildExperimentFilter() {
    }

    public /* synthetic */ GuildExperimentFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
