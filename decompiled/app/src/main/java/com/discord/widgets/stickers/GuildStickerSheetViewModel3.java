package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import retrofit2.HttpException;

/* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2, reason: use source file name */
/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel3<T, R> implements Func1<Guild, Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>> {
    public final /* synthetic */ RestAPI $restAPI;
    public final /* synthetic */ Sticker $sticker;

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$1 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101201<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final C101201 INSTANCE = new C101201();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101212<T, R> implements Func1<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final C101212 INSTANCE = new C101212();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101223<T, R> implements Func1<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public final /* synthetic */ Guild $localGuild;

        public C101223(Guild guild) {
            this.$localGuild = guild;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return ((th instanceof HttpException) && ((HttpException) th).m11055a() == 404) ? new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(this.$localGuild, false, true, null) : GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101234<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final C101234 INSTANCE = new C101234();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$5 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101245<T, R> implements Func1<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final C101245 INSTANCE = new C101245();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$6 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101256<T, R> implements Func1<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final C101256 INSTANCE = new C101256();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    public GuildStickerSheetViewModel3(RestAPI restAPI, Sticker sticker) {
        this.$restAPI = restAPI;
        this.$sticker = sticker;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call2(Guild guild) {
        return guild != null ? guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getStickerGuild(this.$sticker.getId()).m11083G(C101201.INSTANCE).m11083G(C101212.INSTANCE).m11087M(new C101223(guild)) : new ScalarSynchronousObservable(new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, false, true, null)) : this.$restAPI.getStickerGuild(this.$sticker.getId()).m11083G(C101234.INSTANCE).m11083G(C101245.INSTANCE).m11087M(C101256.INSTANCE);
    }
}
