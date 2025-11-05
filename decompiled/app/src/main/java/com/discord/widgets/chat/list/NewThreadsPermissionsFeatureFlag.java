package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: NewThreadsPermissionsFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class NewThreadsPermissionsFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(NewThreadsPermissionsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* compiled from: NewThreadsPermissionsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final NewThreadsPermissionsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = NewThreadsPermissionsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = NewThreadsPermissionsFeatureFlag.INSTANCE;
            return (NewThreadsPermissionsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NewThreadsPermissionsFeatureFlag.kt */
    /* renamed from: com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag$observeEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Experiment, Guild, Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Experiment experiment, Guild guild) {
            return call2(experiment, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Experiment experiment, Guild guild) {
            return Boolean.valueOf(NewThreadsPermissionsFeatureFlag.access$isEnabled(NewThreadsPermissionsFeatureFlag.this, experiment, guild));
        }
    }

    public NewThreadsPermissionsFeatureFlag() {
        this(null, null, 3, null);
    }

    public NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ boolean access$isEnabled(NewThreadsPermissionsFeatureFlag newThreadsPermissionsFeatureFlag, Experiment experiment, Guild guild) {
        return newThreadsPermissionsFeatureFlag.isEnabled(experiment, guild);
    }

    public final boolean isEnabled(long guildId) {
        return isEnabled(this.storeExperiments.getGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.observeGuild(guildId), new AnonymousClass1());
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dExperiment, guild)\n    }");
        return observableJ;
    }

    public /* synthetic */ NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.NEW_THREAD_PERMISSIONS));
    }
}
