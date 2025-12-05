package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import retrofit2.HttpException;

/* compiled from: EmojiSheetViewModel.kt */
/* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel3<T, R> implements Func1<Guild, Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo>> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType.Custom $emoji;
    public final /* synthetic */ RestAPI $restAPI;

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$1 */
    public static final class C83041<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final C83041 INSTANCE = new C83041();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$2 */
    public static final class C83052<T, R> implements Func1<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final C83052 INSTANCE = new C83052();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$3 */
    public static final class C83063<T, R> implements Func1<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public final /* synthetic */ Guild $localGuild;

        public C83063(Guild guild) {
            this.$localGuild = guild;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Throwable th) {
            return ((th instanceof HttpException) && ((HttpException) th).m11055a() == 404) ? new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(this.$localGuild, false, true, null) : EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$4 */
    public static final class C83074<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final C83074 INSTANCE = new C83074();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5 */
    public static final class C83085<T, R> implements Func1<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final C83085 INSTANCE = new C83085();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$6 */
    public static final class C83096<T, R> implements Func1<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final C83096 INSTANCE = new C83096();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Throwable th) {
            return EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
        }
    }

    public EmojiSheetViewModel3(RestAPI restAPI, EmojiNode.EmojiIdAndType.Custom custom) {
        this.$restAPI = restAPI;
        this.$emoji = custom;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo> call2(Guild guild) {
        return guild != null ? guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getEmojiGuild(this.$emoji.getId()).m11083G(C83041.INSTANCE).m11083G(C83052.INSTANCE).m11087M(new C83063(guild)) : new ScalarSynchronousObservable(new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, false, true, null)) : this.$restAPI.getEmojiGuild(this.$emoji.getId()).m11083G(C83074.INSTANCE).m11083G(C83085.INSTANCE).m11087M(C83096.INSTANCE);
    }
}
