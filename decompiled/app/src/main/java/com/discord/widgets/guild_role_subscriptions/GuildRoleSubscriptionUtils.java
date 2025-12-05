package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: GuildRoleSubscriptionUtils.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils {
    public static final GuildRoleSubscriptionUtils INSTANCE = new GuildRoleSubscriptionUtils();

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionGroupListing$1 */
    public static final class C84201<T, R> implements Func1<GuildRoleSubscriptionGroupListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ boolean $canAccessAllChannels;
        public final /* synthetic */ List $channelBenefits;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $intangibleBenefits;
        public final /* synthetic */ String $memberBadge;
        public final /* synthetic */ int $memberColor;
        public final /* synthetic */ int $priceTier;
        public final /* synthetic */ RestAPI $restApi;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ String $tierDescription;
        public final /* synthetic */ String $tierImage;
        public final /* synthetic */ String $tierName;

        public C84201(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, RestAPI restAPI, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$restApi = restAPI;
            this.$tierName = str;
            this.$tierDescription = str2;
            this.$priceTier = i;
            this.$tierImage = str3;
            this.$memberColor = i2;
            this.$memberBadge = str4;
            this.$canAccessAllChannels = z2;
            this.$channelBenefits = list;
            this.$intangibleBenefits = list2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            return call2(guildRoleSubscriptionGroupListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "subscriptionGroupListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
            return GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.$restApi, this.$storeGuildRoleSubscriptions, this.$guildId, guildRoleSubscriptionGroupListing.getId(), this.$tierName, this.$tierDescription, this.$priceTier, this.$tierImage, this.$memberColor, this.$memberBadge, this.$canAccessAllChannels, this.$channelBenefits, this.$intangibleBenefits);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$1 */
    public static final class C84211<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ int $memberColor;
        public final /* synthetic */ String $memberIcon;
        public final /* synthetic */ RestAPI $restApi;

        public C84211(RestAPI restAPI, long j, int i, String str) {
            this.$restApi = restAPI;
            this.$guildId = j;
            this.$memberColor = i;
            this.$memberIcon = str;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            long j = this.$guildId;
            Integer numValueOf = Integer.valueOf(this.$memberColor);
            String str = this.$memberIcon;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionDesign(guildRoleSubscriptionUtils, restAPI, j, numValueOf, str, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$2 */
    public static final class C84222<T> implements Action1<GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ long $groupListingId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public C84222(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$groupListingId = j2;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            long j2 = this.$groupListingId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "tierListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingCreate(j, j2, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$deleteGuildRoleSubscriptionTierListing$1 */
    public static final class C84231<T> implements Action1<Void> {
        public final /* synthetic */ long $groupListingId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ long $tierListingId;

        public C84231(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$groupListingId = j2;
            this.$tierListingId = j3;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r8) {
            this.$storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingDelete(this.$guildId, this.$groupListingId, this.$tierListingId);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionDesign$1 */
    public static final class C84241<T, R> implements Func1<Void, GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        public C84241(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierListing call(Void r1) {
            return call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildRoleSubscriptionTierListing call2(Void r1) {
            return this.$guildRoleSubscriptionTierListing;
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionGroupListing$1 */
    public static final class C84251<T> implements Action1<GuildRoleSubscriptionGroupListing> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public C84251(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            call2(guildRoleSubscriptionGroupListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "groupListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$2 */
    public static final class C84262<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Integer $memberColor;
        public final /* synthetic */ String $memberIcon;
        public final /* synthetic */ RestAPI $restApi;

        public C84262(RestAPI restAPI, long j, Integer num, String str) {
            this.$restApi = restAPI;
            this.$guildId = j;
            this.$memberColor = num;
            this.$memberIcon = str;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            long j = this.$guildId;
            Integer num = this.$memberColor;
            String str = this.$memberIcon;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionDesign(guildRoleSubscriptionUtils, restAPI, j, num, str, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$3 */
    public static final class C84273<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ NullSerializable $activeTrialUserLimit;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ RestAPI $restApi;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ NullSerializable $trialInterval;

        public C84273(RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
            this.$restApi = restAPI;
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$trialInterval = nullSerializable;
            this.$activeTrialUserLimit = nullSerializable2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionTrial(guildRoleSubscriptionUtils, restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, this.$trialInterval, this.$activeTrialUserLimit);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$4 */
    public static final class C84284<T> implements Action1<GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public C84284(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "it");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingUpdate(j, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$1 */
    public static final class C84291<T> implements Action1<GuildRoleSubscriptionTierFreeTrial> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public C84291(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            call2(guildRoleSubscriptionTierFreeTrial);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            long id2 = this.$guildRoleSubscriptionTierListing.getId();
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierFreeTrial, "it");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierTrialUpdate(j, id2, guildRoleSubscriptionTierFreeTrial);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$2 */
    public static final class C84302<T, R> implements Func1<GuildRoleSubscriptionTierFreeTrial, GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        public C84302(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierListing call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            return call2(guildRoleSubscriptionTierFreeTrial);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildRoleSubscriptionTierListing call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            return this.$guildRoleSubscriptionTierListing;
        }
    }

    private GuildRoleSubscriptionUtils() {
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionDesign(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, num, str, guildRoleSubscriptionTierListing);
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionTrial(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, nullSerializable, nullSerializable2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionGroupListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, String str, String str2, Boolean bool, String str3, String str4, int i, String str5, int i2, String str6, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionGroupListing(restAPI, storeGuildRoleSubscriptions, j, str, str2, bool, str3, str4, i, (i3 & 512) != 0 ? null : str5, i2, (i3 & 2048) != 0 ? null : str6, z2, list, list2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, str, str2, i, (i3 & 128) != 0 ? null : str3, i2, (i3 & 512) != 0 ? null : str4, z2, list, list2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionDesign(RestAPI restApi, long guildId, Integer memberColor, String memberIcon, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Observable observableM11083G = restApi.updateRole(guildId, guildRoleSubscriptionTierListing.getRoleId(), new RestAPIParams.Role(null, null, null, memberColor, null, null, guildRoleSubscriptionTierListing.getRoleId(), memberIcon, 55, null)).m11083G(new C84241(guildRoleSubscriptionTierListing));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "restApi\n          .updat…onTierListing\n          }");
        return observableM11083G;
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionDesign$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, guildRoleSubscriptionTierListing);
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3, String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool, List list, List list2, Boolean bool2, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, j3, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : list, (i & 8192) != 0 ? null : list2, (i & 16384) != 0 ? null : bool2, (32768 & i) != 0 ? null : nullSerializable, (i & 65536) != 0 ? null : nullSerializable2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTrial(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        if (trialInterval == null && activeTrialUserLimit == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(guildRoleSubscriptionTierListing);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(guildRoleSubscriptionTierListing)");
            return scalarSynchronousObservable;
        }
        Observable observableM11083G = restApi.updateGuildRoleSubscriptionTierFreeTrial(guildId, guildRoleSubscriptionTierListing.getId(), new RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial(trialInterval, activeTrialUserLimit)).m11115u(new C84291(storeGuildRoleSubscriptions, guildId, guildRoleSubscriptionTierListing)).m11083G(new C84302(guildRoleSubscriptionTierListing));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "restApi\n          .updat…SubscriptionTierListing }");
        return observableM11083G;
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionTrial$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, String coverImage, String planDescription, Boolean isFullServerGating, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberBadge, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        Observable<R> observableM11082A = restApi.createGuildRoleSubscriptionGroupListing(guildId, new RestAPIParams.CreateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)).m11082A(new C84201(storeGuildRoleSubscriptions, guildId, restApi, tierName, tierDescription, priceTier, tierImage, memberColor, memberBadge, canAccessAllChannels, channelBenefits, intangibleBenefits));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "restApi\n        .createG…ts,\n          )\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberIcon, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        List listPlus = _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
        }
        Observable<R> observableM11082A = restApi.createGuildRoleSubscriptionTier(guildId, groupListingId, new RestAPIParams.CreateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, arrayList, priceTier, canAccessAllChannels)).m11082A(new C84211(restApi, guildId, memberColor, memberIcon));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "restApi\n        .createG…ng,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null).m11115u(new C84222(storeGuildRoleSubscriptions, guildId, groupListingId));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "restApi\n        .createG…ing\n          )\n        }");
        return observableM11115u;
    }

    public final Observable<Void> deleteGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<Void> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(restApi.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId), false, 1, null).m11115u(new C84231(storeGuildRoleSubscriptions, guildId, groupListingId, tierListingId));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "restApi\n        .deleteG…Id,\n          )\n        }");
        return observableM11115u;
    }

    public final Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String coverImage, String planDescription, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<GuildRoleSubscriptionGroupListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(restApi.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, new RestAPIParams.UpdateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)), false, 1, null).m11115u(new C84251(storeGuildRoleSubscriptions, guildId));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "restApi\n        .updateG…, groupListing)\n        }");
        return observableM11115u;
    }

    public final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId, String tierName, String tierDescription, String tierImage, Integer priceTier, Integer memberColor, String memberIcon, Boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits, Boolean published, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        List<? extends Benefit> listPlus = (channelBenefits == null || intangibleBenefits == null) ? channelBenefits != null ? channelBenefits : intangibleBenefits : _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        if (listPlus != null) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
            Iterator<T> it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Observable observableM11082A = restApi.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, new RestAPIParams.UpdateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, priceTier, arrayList, published, canAccessAllChannels)).m11082A(new C84262(restApi, guildId, memberColor, memberIcon)).m11082A(new C84273(restApi, storeGuildRoleSubscriptions, guildId, trialInterval, activeTrialUserLimit));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "restApi\n        .updateG…it,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null).m11115u(new C84284(storeGuildRoleSubscriptions, guildId));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "restApi\n        .updateG…te(guildId, it)\n        }");
        return observableM11115u;
    }
}
