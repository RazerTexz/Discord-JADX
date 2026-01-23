package com.discord.utilities.platform;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.connectedaccounts.ConnectedAccount;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Platform {
    BATTLENET("Battle.net", Integer.valueOf(C5419R.color.battlenet), Integer.valueOf(C5419R.attr.ic_account_battlenet), Integer.valueOf(C5419R.drawable.ic_account_battlenet_white_24dp), false, false, false, 112, null),
    FACEBOOK("Facebook", Integer.valueOf(C5419R.color.facebook), Integer.valueOf(C5419R.attr.ic_account_facebook), Integer.valueOf(C5419R.drawable.ic_account_facebook_white_24dp), false, false, true, 48, null),
    GITHUB("GitHub", Integer.valueOf(C5419R.color.github), Integer.valueOf(C5419R.attr.ic_account_github), Integer.valueOf(C5419R.drawable.ic_account_github_white_24dp), false, false, true, 48, null),
    LEAGUEOFLEGENDS("League of Legends", Integer.valueOf(C5419R.color.league_of_legends), Integer.valueOf(C5419R.attr.ic_account_league_of_legends), Integer.valueOf(C5419R.drawable.ic_account_league_of_legends_white_24dp), false, false, false, 112, null),
    PLAYSTATION("PlayStation Network", Integer.valueOf(C5419R.color.playstation), Integer.valueOf(C5419R.attr.ic_account_playstation), Integer.valueOf(C5419R.drawable.ic_account_playstation_white_24dp), false, true, true, 16, null),
    REDDIT("Reddit", Integer.valueOf(C5419R.color.reddit), Integer.valueOf(C5419R.attr.ic_account_reddit), Integer.valueOf(C5419R.drawable.ic_account_reddit_white_24dp), false, false, true, 48, null),
    SAMSUNG("Samsung Galaxy", null, Integer.valueOf(C5419R.attr.ic_account_samsung), Integer.valueOf(C5419R.drawable.ic_account_samsung_white_24dp), false, true, false, 82, null),
    SKYPE("Skype", Integer.valueOf(C5419R.color.skype), Integer.valueOf(C5419R.attr.ic_account_skype), Integer.valueOf(C5419R.drawable.ic_account_skype_white_24dp), false, false, false, 112, null),
    SPOTIFY("Spotify", Integer.valueOf(C5419R.color.spotify), Integer.valueOf(C5419R.attr.ic_account_spotify), Integer.valueOf(C5419R.drawable.ic_account_spotify_white_24dp), false, true, true, 16, null),
    STEAM("Steam", Integer.valueOf(C5419R.color.steam), Integer.valueOf(C5419R.attr.ic_account_steam), Integer.valueOf(C5419R.drawable.ic_account_steam_white_24dp), false, false, true, 48, null),
    TWITCH("Twitch", Integer.valueOf(C5419R.color.twitch), Integer.valueOf(C5419R.attr.ic_account_twitch), Integer.valueOf(C5419R.drawable.ic_account_twitch_white_24dp), false, false, true, 48, null),
    TWITTER("Twitter", Integer.valueOf(C5419R.color.twitter), Integer.valueOf(C5419R.attr.ic_account_twitter), Integer.valueOf(C5419R.drawable.ic_account_twitter_white_24dp), false, false, true, 48, null),
    XBOX("Xbox", Integer.valueOf(C5419R.color.xbox), Integer.valueOf(C5419R.attr.ic_account_xbox), Integer.valueOf(C5419R.drawable.ic_account_xbox_white_24dp), false, true, true, 16, null),
    YOUTUBE("YouTube", Integer.valueOf(C5419R.color.youtube), Integer.valueOf(C5419R.attr.ic_account_youtube), Integer.valueOf(C5419R.drawable.ic_account_youtube_white_24dp), false, false, true, 48, null),
    NONE(null, null, null, null, false, false, false, Opcodes.LAND, null);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canShowActivity;
    private final boolean canSyncFriends;
    private final Integer colorResId;
    private final boolean enabled;
    private final String platformId;
    private final String properName;
    private final Integer themedPlatformImage;
    private final Integer whitePlatformImage;

    /* JADX INFO: compiled from: Platform.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ActivityPlatform.values();
                int[] iArr = new int[9];
                $EnumSwitchMapping$0 = iArr;
                iArr[ActivityPlatform.SAMSUNG.ordinal()] = 1;
                iArr[ActivityPlatform.SPOTIFY.ordinal()] = 2;
                iArr[ActivityPlatform.XBOX.ordinal()] = 3;
                iArr[ActivityPlatform.PS4.ordinal()] = 4;
                iArr[ActivityPlatform.PS5.ordinal()] = 5;
            }
        }

        private Companion() {
        }

        public final Platform from(ActivityPlatform activityPlatform) {
            if (activityPlatform != null) {
                int iOrdinal = activityPlatform.ordinal();
                if (iOrdinal == 1) {
                    return Platform.XBOX;
                }
                if (iOrdinal == 4) {
                    return Platform.SAMSUNG;
                }
                if (iOrdinal == 5) {
                    return Platform.SPOTIFY;
                }
                if (iOrdinal == 6) {
                    return Platform.PLAYSTATION;
                }
                if (iOrdinal == 7) {
                    return Platform.PLAYSTATION;
                }
            }
            return Platform.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform from(String platformName) {
            Intrinsics3.checkNotNullParameter(platformName, "platformName");
            try {
                String string = Strings4.trim(platformName).toString();
                Locale locale = Locale.ENGLISH;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase = string.toUpperCase(locale);
                Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return Platform.valueOf(upperCase);
            } catch (Exception unused) {
                return Platform.NONE;
            }
        }

        public final Platform from(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
            return from(connectedAccount.getType());
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Platform.values();
            int[] iArr = new int[15];
            $EnumSwitchMapping$0 = iArr;
            iArr[Platform.GITHUB.ordinal()] = 1;
            iArr[Platform.REDDIT.ordinal()] = 2;
            iArr[Platform.SPOTIFY.ordinal()] = 3;
            iArr[Platform.STEAM.ordinal()] = 4;
            iArr[Platform.TWITCH.ordinal()] = 5;
            iArr[Platform.TWITTER.ordinal()] = 6;
            iArr[Platform.YOUTUBE.ordinal()] = 7;
        }
    }

    Platform(String str, @ColorRes Integer num, @AttrRes Integer num2, @DrawableRes Integer num3, boolean z2, boolean z3, boolean z4) {
        this.properName = str;
        this.colorResId = num;
        this.themedPlatformImage = num2;
        this.whitePlatformImage = num3;
        this.canSyncFriends = z2;
        this.canShowActivity = z3;
        this.enabled = z4;
        String strName = name();
        Locale locale = Locale.ENGLISH;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.platformId = lowerCase;
    }

    public static final Platform from(ActivityPlatform activityPlatform) {
        return INSTANCE.from(activityPlatform);
    }

    public static final Platform from(ConnectedAccount connectedAccount) {
        return INSTANCE.from(connectedAccount);
    }

    public static final Platform from(String str) {
        return INSTANCE.from(str);
    }

    public final boolean getCanShowActivity() {
        return this.canShowActivity;
    }

    public final boolean getCanSyncFriends() {
        return this.canSyncFriends;
    }

    public final Integer getColorResId() {
        return this.colorResId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getPlatformId() {
        return this.platformId;
    }

    public final String getProfileUrl(ConnectedAccount connectedAccount) {
        Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
        int iOrdinal = ordinal();
        if (iOrdinal == 2) {
            StringBuilder sbM833U = outline.m833U("https://github.com/");
            sbM833U.append(connectedAccount.getName());
            return sbM833U.toString();
        }
        if (iOrdinal == 5) {
            StringBuilder sbM833U2 = outline.m833U("https://reddit.com/u/");
            sbM833U2.append(connectedAccount.getName());
            return sbM833U2.toString();
        }
        if (iOrdinal == 13) {
            StringBuilder sbM833U3 = outline.m833U("https://youtube.com/channel/");
            sbM833U3.append(connectedAccount.getId());
            return sbM833U3.toString();
        }
        switch (iOrdinal) {
            case 8:
                StringBuilder sbM833U4 = outline.m833U("https://open.spotify.com/user/");
                sbM833U4.append(connectedAccount.getId());
                return sbM833U4.toString();
            case 9:
                StringBuilder sbM833U5 = outline.m833U("https://steamcommunity.com/profiles/");
                sbM833U5.append(connectedAccount.getId());
                return sbM833U5.toString();
            case 10:
                StringBuilder sbM833U6 = outline.m833U("https://twitch.tv/");
                sbM833U6.append(connectedAccount.getName());
                return sbM833U6.toString();
            case 11:
                StringBuilder sbM833U7 = outline.m833U("https://www.twitter.com/");
                sbM833U7.append(connectedAccount.getName());
                return sbM833U7.toString();
            default:
                return null;
        }
    }

    public final String getProperName() {
        return this.properName;
    }

    public final Integer getThemedPlatformImage() {
        return this.themedPlatformImage;
    }

    public final Integer getWhitePlatformImage() {
        return this.whitePlatformImage;
    }

    /* synthetic */ Platform(String str, Integer num, Integer num2, Integer num3, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4);
    }
}
