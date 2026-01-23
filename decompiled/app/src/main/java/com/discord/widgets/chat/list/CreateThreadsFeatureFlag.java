package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import kotlin.Lazy;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(CreateThreadsFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean computeIsEnabled(Experiment createExperiment, Experiment rolloutExperiment, Guild guild) {
            if (guild == null) {
                return false;
            }
            if (guild.hasFeature(GuildFeature.THREADS_ENABLED)) {
                return true;
            }
            return ((rolloutExperiment != null && rolloutExperiment.getBucket() == 2) || !guild.hasFeature(GuildFeature.COMMUNITY)) && createExperiment != null && createExperiment.getBucket() == 1;
        }

        public final CreateThreadsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = CreateThreadsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = CreateThreadsFeatureFlag.INSTANCE;
            return (CreateThreadsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.CreateThreadsFeatureFlag$observeEnabled$1 */
    /* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
    public static final /* synthetic */ class C79321 extends FunctionReferenceImpl implements Function3<Experiment, Experiment, Guild, Boolean> {
        public C79321(Companion companion) {
            super(3, companion, Companion.class, "computeIsEnabled", "computeIsEnabled(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(Experiment experiment, Experiment experiment2, Guild guild) {
            return Boolean.valueOf(invoke2(experiment, experiment2, guild));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Experiment experiment, Experiment experiment2, Guild guild) {
            return ((Companion) this.receiver).computeIsEnabled(experiment, experiment2, guild);
        }
    }

    public CreateThreadsFeatureFlag() {
        this(null, null, 3, null);
    }

    public CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled(long guildId) {
        return INSTANCE.computeIsEnabled(this.storeExperiments.getGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.getGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableM11075i = Observable.m11075i(this.storeExperiments.observeGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.observeGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.observeGuild(guildId), new CreateThreadsFeatureFlag3(new C79321(INSTANCE)));
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest… ::computeIsEnabled\n    )");
        return observableM11075i;
    }

    public /* synthetic */ CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }
}
