package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: TextInVoiceFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(TextInVoiceFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* compiled from: TextInVoiceFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final TextInVoiceFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = TextInVoiceFeatureFlag.access$getINSTANCE$cp();
            Companion companion = TextInVoiceFeatureFlag.INSTANCE;
            return (TextInVoiceFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TextInVoiceFeatureFlag.kt */
    /* renamed from: com.discord.widgets.chat.list.TextInVoiceFeatureFlag$observeEnabled$1 */
    public static final class C79501<T1, T2, R> implements Func2<Experiment, Guild, Boolean> {
        public C79501() {
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Experiment experiment, Guild guild) {
            return call2(experiment, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Experiment experiment, Guild guild) {
            return Boolean.valueOf(TextInVoiceFeatureFlag.access$isEnabled(TextInVoiceFeatureFlag.this, experiment, guild));
        }
    }

    public TextInVoiceFeatureFlag() {
        this(null, null, 3, null);
    }

    public TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ boolean access$isEnabled(TextInVoiceFeatureFlag textInVoiceFeatureFlag, Experiment experiment, Guild guild) {
        return textInVoiceFeatureFlag.isEnabled(experiment, guild);
    }

    public final boolean isEnabled(Long guildId) {
        if (guildId != null) {
            return isEnabled(this.storeExperiments.getGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.getGuild(guildId.longValue()));
        }
        return false;
    }

    public final Observable<Boolean> observeEnabled(Long guildId) {
        if (guildId == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(false)");
            return scalarSynchronousObservable;
        }
        Observable<Boolean> observableM11076j = Observable.m11076j(this.storeExperiments.observeGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.observeGuild(guildId.longValue()), new C79501());
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…xperiment, guild)\n      }");
        return observableM11076j;
    }

    public /* synthetic */ TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.TEXT_IN_VOICE_ENABLED));
    }
}
