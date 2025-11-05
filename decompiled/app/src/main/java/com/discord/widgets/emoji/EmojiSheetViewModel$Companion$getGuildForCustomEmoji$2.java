package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import retrofit2.HttpException;
import rx.Observable;

/* compiled from: EmojiSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2<T, R> implements b<Guild, Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo>> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType.Custom $emoji;
    public final /* synthetic */ RestAPI $restAPI;

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<com.discord.api.guild.Guild, Guild> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            m.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Guild guild) {
            m.checkNotNullExpressionValue(guild, "responseGuild");
            return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public final /* synthetic */ Guild $localGuild;

        public AnonymousClass3(Guild guild) {
            this.$localGuild = guild;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Throwable th) {
            return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(this.$localGuild, false, true, null) : EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<com.discord.api.guild.Guild, Guild> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            m.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements b<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Guild guild) {
            m.checkNotNullExpressionValue(guild, "responseGuild");
            return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$6, reason: invalid class name */
    public static final class AnonymousClass6<T, R> implements b<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call2(Throwable th) {
            return EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
        }
    }

    public EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2(RestAPI restAPI, EmojiNode.EmojiIdAndType.Custom custom) {
        this.$restAPI = restAPI;
        this.$emoji = custom;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo> call2(Guild guild) {
        return guild != null ? guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getEmojiGuild(this.$emoji.getId()).G(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE).M(new AnonymousClass3(guild)) : new k(new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, false, true, null)) : this.$restAPI.getEmojiGuild(this.$emoji.getId()).G(AnonymousClass4.INSTANCE).G(AnonymousClass5.INSTANCE).M(AnonymousClass6.INSTANCE);
    }
}
