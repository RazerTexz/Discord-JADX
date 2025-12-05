package com.discord.stores;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.contacts.ContactsFetcher;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncUpsellSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreContactSync.kt */
/* loaded from: classes2.dex */
public final class StoreContactSync extends StoreV2 {
    private final Clock clock;
    private final StoreUserConnections connectionsStore;
    private ContactsFetcher contactsFetcher;
    private final HashMap<String, Boolean> dismissState;
    private final Persister<Map<String, Boolean>> dismissStateCache;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final StoreNotices noticesStore;
    private final RestAPI restAPI;
    private boolean shouldTryUploadContacts;
    private final Persister<Long> uploadTimestampCache;
    private final StoreUserSettings userSettingsStore;
    private final StoreUser usersStore;

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$backgroundUploadContacts$1 */
    public static final class C58581 extends Lambda implements Function1<BulkFriendSuggestions, TrackNetworkMetadata2> {
        public static final C58581 INSTANCE = new C58581();

        public C58581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(BulkFriendSuggestions bulkFriendSuggestions) {
            return invoke2(bulkFriendSuggestions);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(BulkFriendSuggestions bulkFriendSuggestions) {
            return new TrackNetworkActionUserContactsSync();
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$clearDismissStates$1 */
    public static final class C58591 extends Lambda implements Function0<Unit> {
        public C58591() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).clear();
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$createContactSyncNotice$1 */
    public static final class C58601 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final C58601 INSTANCE = new C58601();

        public C58601() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
            AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Release Upsell", null, null, null, null, 30, null));
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.m10073to("location_page", "Release Upsell")), 1, null);
            ContactSyncUpsellSheet.Companion companion = ContactSyncUpsellSheet.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
            companion.show(supportFragmentManager);
            return true;
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$dismissFriendsListUpsell$1 */
    public static final class C58611 extends Lambda implements Function0<Unit> {
        public C58611() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).put("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$dismissUpsell$1 */
    public static final class C58621 extends Lambda implements Function0<Unit> {
        public C58621() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$handleConnectionOpen$1 */
    public static final class C58631 extends Lambda implements Function0<Unit> {
        public C58631() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.handlePostConnectionOpen();
        }
    }

    /* compiled from: StoreContactSync.kt */
    /* renamed from: com.discord.stores.StoreContactSync$setContactSyncUploadTimestamp$1 */
    public static final class C58641 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58641(long j) {
            super(0);
            this.$timestamp = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync storeContactSync = StoreContactSync.this;
            StoreContactSync.access$setShouldTryUploadContacts$p(storeContactSync, StoreContactSync.access$getClock$p(storeContactSync).currentTimeMillis() - this.$timestamp > 86400000);
            StoreContactSync.this.markChanged();
        }
    }

    public StoreContactSync(Dispatcher dispatcher, RestAPI restAPI, Clock clock, StoreUserConnections storeUserConnections, StoreUser storeUser, StoreExperiments storeExperiments, StoreNotices storeNotices, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeUserConnections, "connectionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeNotices, "noticesStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.connectionsStore = storeUserConnections;
        this.usersStore = storeUser;
        this.experimentsStore = storeExperiments;
        this.noticesStore = storeNotices;
        this.userSettingsStore = storeUserSettings;
        this.dismissStateCache = new Persister<>("CONTACT_SYNC_DISMISS_STATE", new HashMap());
        this.uploadTimestampCache = new Persister<>("CONTACT_SYNC_LAST_UPLOAD_TIME", 0L);
        this.dismissState = new HashMap<>();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreContactSync storeContactSync) {
        return storeContactSync.clock;
    }

    public static final /* synthetic */ HashMap access$getDismissState$p(StoreContactSync storeContactSync) {
        return storeContactSync.dismissState;
    }

    public static final /* synthetic */ boolean access$getShouldTryUploadContacts$p(StoreContactSync storeContactSync) {
        return storeContactSync.shouldTryUploadContacts;
    }

    public static final /* synthetic */ void access$setShouldTryUploadContacts$p(StoreContactSync storeContactSync, boolean z2) {
        storeContactSync.shouldTryUploadContacts = z2;
    }

    private final StoreNotices.Notice createContactSyncNotice() {
        return new StoreNotices.Notice("CONTACT_SYNC_UPSELL", null, 1336L, 0, true, null, 0L, false, 0L, C58601.INSTANCE, 482, null);
    }

    public final void backgroundUploadContacts() {
        ContactsFetcher contactsFetcher = this.contactsFetcher;
        if (contactsFetcher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contactsFetcher");
        }
        Set<String> setFetchContacts = contactsFetcher.fetchContacts();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setFetchContacts, 10));
        for (String str : setFetchContacts) {
            arrayList.add(new RestAPIParams.ContactEntry(str, str, MapsJVM.mapOf(new Tuples2("number", str))));
        }
        RestCallState5.logNetworkAction(this.restAPI.uploadContacts(new RestAPIParams.UploadContacts(arrayList, true, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO)), C58581.INSTANCE);
        setContactSyncUploadTimestamp(this.clock.currentTimeMillis());
    }

    public final void clearDismissStates() {
        this.dismissStateCache.clear(true);
        getPrefsSessionDurable().edit().remove("CONTACT_SYNC_DISMISS_UPSELL").apply();
        this.dispatcher.schedule(new C58591());
    }

    public final void dismissFriendsListUpsell() {
        this.dismissStateCache.set(this.dismissState, true);
        this.dispatcher.schedule(new C58611());
    }

    public final void dismissUpsell() {
        getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new C58621());
    }

    public final boolean getFriendsListUpsellDismissed() {
        return Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL"), Boolean.TRUE);
    }

    @Store3
    public final void handleConnectionOpen() {
        this.dispatcher.schedule(new C58631());
    }

    @Store3
    public final void handlePostConnectionOpen() {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.usersStore.getMeSnapshot();
        StoreUserConnections.State stateSnapshot = this.connectionsStore.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            } else {
                connectedAccountPrevious = listIterator.previous();
                if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        Boolean bool = this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL");
        Boolean contactSyncUpsellShown = this.userSettingsStore.getContactSyncUpsellShown();
        boolean z2 = false;
        Experiment userExperiment = this.experimentsStore.getUserExperiment("2021-04_contact_sync_android_main", connectedAccount == null);
        if (userExperiment != null && userExperiment.getBucket() == 1 && connectedAccount == null) {
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.getHasPhone(meSnapshot)) {
                Boolean bool2 = Boolean.TRUE;
                if ((!Intrinsics3.areEqual(bool, bool2)) && (!Intrinsics3.areEqual(contactSyncUpsellShown, bool2)) && userUtils.getAgeMs(meSnapshot, ClockFactory.get()) > 604800000) {
                    z2 = true;
                }
            }
        }
        if (Intrinsics3.areEqual(bool, Boolean.TRUE) && (!Intrinsics3.areEqual(contactSyncUpsellShown, r0))) {
            this.userSettingsStore.updateContactSyncShown();
        }
        if (z2) {
            this.noticesStore.requestToShow(createContactSyncNotice());
        }
        if (this.shouldTryUploadContacts) {
            backgroundUploadContacts();
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.contactsFetcher = new ContactsFetcher(context);
        this.dismissState.putAll(this.dismissStateCache.get());
        if (Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL"), Boolean.TRUE)) {
            getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        }
        this.dismissState.put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.valueOf(getPrefsSessionDurable().getBoolean("CONTACT_SYNC_DISMISS_UPSELL", false)));
        this.shouldTryUploadContacts = this.clock.currentTimeMillis() - this.uploadTimestampCache.get().longValue() > 86400000;
        markChanged();
    }

    public final void setContactSyncUploadTimestamp(long timestamp) {
        this.uploadTimestampCache.set(Long.valueOf(timestamp), true);
        this.dispatcher.schedule(new C58641(timestamp));
    }
}
