package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import retrofit2.HttpException;
import rx.Observable;

/* compiled from: GuildStickerSheetViewModel.kt */
/* loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2<T, R> implements b<Guild, Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>> {
    public final /* synthetic */ RestAPI $restAPI;
    public final /* synthetic */ Sticker $sticker;

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$1, reason: invalid class name */
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

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            m.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public final /* synthetic */ Guild $localGuild;

        public AnonymousClass3(Guild guild) {
            this.$localGuild = guild;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(this.$localGuild, false, true, null) : GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4, reason: invalid class name */
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

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements b<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            m.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$6, reason: invalid class name */
    public static final class AnonymousClass6<T, R> implements b<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    public GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2(RestAPI restAPI, Sticker sticker) {
        this.$restAPI = restAPI;
        this.$sticker = sticker;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call2(Guild guild) {
        return guild != null ? guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getStickerGuild(this.$sticker.getId()).G(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE).M(new AnonymousClass3(guild)) : new k(new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, false, true, null)) : this.$restAPI.getStickerGuild(this.$sticker.getId()).G(AnonymousClass4.INSTANCE).G(AnonymousClass5.INSTANCE).M(AnonymousClass6.INSTANCE);
    }
}
