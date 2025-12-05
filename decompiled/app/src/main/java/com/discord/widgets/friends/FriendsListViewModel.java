package com.discord.widgets.friends;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.widgets.captcha.WidgetCaptcha4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollectionsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p580t._Maps;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p653p.Schedulers2;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Cancellable;
import p658rx.subjects.PublishSubject;

/* compiled from: FriendsListViewModel.kt */
/* loaded from: classes2.dex */
public final class FriendsListViewModel extends AppViewModel<ViewState> {
    private static final int COLLAPSED_ITEM_COUNT = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOCATION = "Friends List";
    private Cancellable computeItemJob;
    private final PublishSubject<Event> eventSubject;
    private boolean isPendingSectionExpanded;
    private boolean isSuggestedSectionExpanded;
    private ListSections listSections;
    private final RestAPI restAPI;
    private final StoreChannels storeChannels;
    private final Observable<StoreState> storeObservable;

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$1 */
    public static final class C83561 extends Lambda implements Function1<StoreState, Unit> {
        public C83561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) throws Exception {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) throws Exception {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            FriendsListViewModel.access$handleStoreState(FriendsListViewModel.this, storeState);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreChannelsSelected channelsSelected = companion.getChannelsSelected();
            StoreUserPresence presences = companion.getPresences();
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreUserConnections userConnections = companion.getUserConnections();
            Observable<StoreState> observableM11083G = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{companion.getChannelsSelected(), companion.getPresences(), companion.getUsers(), companion.getUserRelationships(), companion.getApplicationStreaming(), companion.getUserConnections(), companion.getExperiments(), companion.getContactSync()}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).m11083G(new FriendsListViewModel2(channelsSelected, presences, users, userRelationships, companion.getApplicationStreaming(), userConnections, companion.getExperiments(), companion.getContactSync(), companion.getFriendSuggestions()));
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "ObservationDeckProvider\n…            )\n          }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static abstract class Event {

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class CaptchaError extends Event {
            private final int discriminator;
            private final Error error;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CaptchaError(Error error, String str, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                Intrinsics3.checkNotNullParameter(str, "username");
                this.error = error;
                this.username = str;
                this.discriminator = i;
            }

            public static /* synthetic */ CaptchaError copy$default(CaptchaError captchaError, Error error, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    error = captchaError.error;
                }
                if ((i2 & 2) != 0) {
                    str = captchaError.username;
                }
                if ((i2 & 4) != 0) {
                    i = captchaError.discriminator;
                }
                return captchaError.copy(error, str, i);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* renamed from: component3, reason: from getter */
            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final CaptchaError copy(Error error, String username, int discriminator) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Intrinsics3.checkNotNullParameter(username, "username");
                return new CaptchaError(error, username, discriminator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CaptchaError)) {
                    return false;
                }
                CaptchaError captchaError = (CaptchaError) other;
                return Intrinsics3.areEqual(this.error, captchaError.error) && Intrinsics3.areEqual(this.username, captchaError.username) && this.discriminator == captchaError.discriminator;
            }

            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final Error getError() {
                return this.error;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                Error error = this.error;
                int iHashCode = (error != null ? error.hashCode() : 0) * 31;
                String str = this.username;
                return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.discriminator;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("CaptchaError(error=");
                sbM833U.append(this.error);
                sbM833U.append(", username=");
                sbM833U.append(this.username);
                sbM833U.append(", discriminator=");
                return outline.m814B(sbM833U, this.discriminator, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class LaunchVoiceCall extends Event {
            private final long channelId;

            public LaunchVoiceCall(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchVoiceCall copy$default(LaunchVoiceCall launchVoiceCall, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVoiceCall.channelId;
                }
                return launchVoiceCall.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchVoiceCall copy(long channelId) {
                return new LaunchVoiceCall(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchVoiceCall) && this.channelId == ((LaunchVoiceCall) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return C0002b.m3a(this.channelId);
            }

            public String toString() {
                return outline.m815C(outline.m833U("LaunchVoiceCall(channelId="), this.channelId, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ShowFriendRequestErrorToast extends Event {
            private final int abortCode;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFriendRequestErrorToast(int i, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "username");
                this.abortCode = i;
                this.username = str;
            }

            public static /* synthetic */ ShowFriendRequestErrorToast copy$default(ShowFriendRequestErrorToast showFriendRequestErrorToast, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showFriendRequestErrorToast.abortCode;
                }
                if ((i2 & 2) != 0) {
                    str = showFriendRequestErrorToast.username;
                }
                return showFriendRequestErrorToast.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getAbortCode() {
                return this.abortCode;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            public final ShowFriendRequestErrorToast copy(int abortCode, String username) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new ShowFriendRequestErrorToast(abortCode, username);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFriendRequestErrorToast)) {
                    return false;
                }
                ShowFriendRequestErrorToast showFriendRequestErrorToast = (ShowFriendRequestErrorToast) other;
                return this.abortCode == showFriendRequestErrorToast.abortCode && Intrinsics3.areEqual(this.username, showFriendRequestErrorToast.username);
            }

            public final int getAbortCode() {
                return this.abortCode;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                int i = this.abortCode * 31;
                String str = this.username;
                return i + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ShowFriendRequestErrorToast(abortCode=");
                sbM833U.append(this.abortCode);
                sbM833U.append(", username=");
                return outline.m822J(sbM833U, this.username, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int stringRes;

            public ShowToast(int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringRes;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final ShowToast copy(int stringRes) {
                return new ShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringRes == ((ShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.m814B(outline.m833U("ShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CONTACT_SYNC_UPSELL = 6;
        public static final int TYPE_FRIEND = 0;
        public static final int TYPE_HEADER = 3;
        public static final int TYPE_PENDING_FRIEND = 1;
        public static final int TYPE_PENDING_HEADER = 2;
        public static final int TYPE_SUGGESTED_FRIEND = 5;
        public static final int TYPE_SUGGESTED_FRIEND_HEADER = 4;
        private final int type;

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ContactSyncUpsell extends Item {
            private final boolean dismissed;
            private final String key;

            public ContactSyncUpsell(boolean z2) {
                super(6, null);
                this.dismissed = z2;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ ContactSyncUpsell copy$default(ContactSyncUpsell contactSyncUpsell, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = contactSyncUpsell.dismissed;
                }
                return contactSyncUpsell.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getDismissed() {
                return this.dismissed;
            }

            public final ContactSyncUpsell copy(boolean dismissed) {
                return new ContactSyncUpsell(dismissed);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ContactSyncUpsell) && this.dismissed == ((ContactSyncUpsell) other).dismissed;
                }
                return true;
            }

            public final boolean getDismissed() {
                return this.dismissed;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                boolean z2 = this.dismissed;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.m827O(outline.m833U("ContactSyncUpsell(dismissed="), this.dismissed, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Friend extends Item {
            private final boolean isApplicationStreaming;
            private final String key;
            private final Presence presence;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Friend(User user, Presence presence, boolean z2) {
                super(0, null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.isApplicationStreaming = z2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ Friend copy$default(Friend friend, User user, Presence presence, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = friend.user;
                }
                if ((i & 2) != 0) {
                    presence = friend.presence;
                }
                if ((i & 4) != 0) {
                    z2 = friend.isApplicationStreaming;
                }
                return friend.copy(user, presence, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final Friend copy(User user, Presence presence, boolean isApplicationStreaming) {
                Intrinsics3.checkNotNullParameter(user, "user");
                return new Friend(user, presence, isApplicationStreaming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Friend)) {
                    return false;
                }
                Friend friend = (Friend) other;
                return Intrinsics3.areEqual(this.user, friend.user) && Intrinsics3.areEqual(this.presence, friend.presence) && this.isApplicationStreaming == friend.isApplicationStreaming;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                boolean z2 = this.isApplicationStreaming;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode2 + i;
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isOnline() {
                return this.presence != null && Sets5.setOf((Object[]) new ClientStatus[]{ClientStatus.ONLINE, ClientStatus.IDLE, ClientStatus.DND}).contains(this.presence.getStatus());
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Friend(user=");
                sbM833U.append(this.user);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", isApplicationStreaming=");
                return outline.m827O(sbM833U, this.isApplicationStreaming, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Header extends Item {
            private final int count;
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i, int i2) {
                super(3, null);
                this.titleStringResId = i;
                this.count = i2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(i);
                this.key = sb.toString();
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = header.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = header.count;
                }
                return header.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final Header copy(@StringRes int titleStringResId, int count) {
                return new Header(titleStringResId, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return this.titleStringResId == header.titleStringResId && this.count == header.count;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return (this.titleStringResId * 31) + this.count;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Header(titleStringResId=");
                sbM833U.append(this.titleStringResId);
                sbM833U.append(", count=");
                return outline.m814B(sbM833U, this.count, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class PendingFriendRequest extends Item {
            private final String key;
            private final Presence presence;
            private final int relationshipType;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PendingFriendRequest(User user, Presence presence, int i) {
                super(1, null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.relationshipType = i;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ PendingFriendRequest copy$default(PendingFriendRequest pendingFriendRequest, User user, Presence presence, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    user = pendingFriendRequest.user;
                }
                if ((i2 & 2) != 0) {
                    presence = pendingFriendRequest.presence;
                }
                if ((i2 & 4) != 0) {
                    i = pendingFriendRequest.relationshipType;
                }
                return pendingFriendRequest.copy(user, presence, i);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component3, reason: from getter */
            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final PendingFriendRequest copy(User user, Presence presence, int relationshipType) {
                Intrinsics3.checkNotNullParameter(user, "user");
                return new PendingFriendRequest(user, presence, relationshipType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingFriendRequest)) {
                    return false;
                }
                PendingFriendRequest pendingFriendRequest = (PendingFriendRequest) other;
                return Intrinsics3.areEqual(this.user, pendingFriendRequest.user) && Intrinsics3.areEqual(this.presence, pendingFriendRequest.presence) && this.relationshipType == pendingFriendRequest.relationshipType;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                return ((iHashCode + (presence != null ? presence.hashCode() : 0)) * 31) + this.relationshipType;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("PendingFriendRequest(user=");
                sbM833U.append(this.user);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", relationshipType=");
                return outline.m814B(sbM833U, this.relationshipType, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class PendingHeader extends Item {
            private final int count;
            private final boolean isPendingSectionExpanded;
            private final String key;
            private final boolean showExpandButton;
            private final int titleStringResId;

            public PendingHeader(@StringRes int i, int i2, boolean z2, boolean z3) {
                super(2, null);
                this.titleStringResId = i;
                this.count = i2;
                this.isPendingSectionExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ PendingHeader copy$default(PendingHeader pendingHeader, int i, int i2, boolean z2, boolean z3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = pendingHeader.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = pendingHeader.count;
                }
                if ((i3 & 4) != 0) {
                    z2 = pendingHeader.isPendingSectionExpanded;
                }
                if ((i3 & 8) != 0) {
                    z3 = pendingHeader.showExpandButton;
                }
                return pendingHeader.copy(i, i2, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final PendingHeader copy(@StringRes int titleStringResId, int count, boolean isPendingSectionExpanded, boolean showExpandButton) {
                return new PendingHeader(titleStringResId, count, isPendingSectionExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingHeader)) {
                    return false;
                }
                PendingHeader pendingHeader = (PendingHeader) other;
                return this.titleStringResId == pendingHeader.titleStringResId && this.count == pendingHeader.count && this.isPendingSectionExpanded == pendingHeader.isPendingSectionExpanded && this.showExpandButton == pendingHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = ((this.titleStringResId * 31) + this.count) * 31;
                boolean z2 = this.isPendingSectionExpanded;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                boolean z3 = this.showExpandButton;
                return i3 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("PendingHeader(titleStringResId=");
                sbM833U.append(this.titleStringResId);
                sbM833U.append(", count=");
                sbM833U.append(this.count);
                sbM833U.append(", isPendingSectionExpanded=");
                sbM833U.append(this.isPendingSectionExpanded);
                sbM833U.append(", showExpandButton=");
                return outline.m827O(sbM833U, this.showExpandButton, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class SuggestedFriend extends Item {
            private final String key;
            private final FriendSuggestion suggestion;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedFriend(FriendSuggestion friendSuggestion) {
                super(5, null);
                Intrinsics3.checkNotNullParameter(friendSuggestion, "suggestion");
                this.suggestion = friendSuggestion;
                this.key = getType() + " -- " + friendSuggestion.getUser().getId();
            }

            public static /* synthetic */ SuggestedFriend copy$default(SuggestedFriend suggestedFriend, FriendSuggestion friendSuggestion, int i, Object obj) {
                if ((i & 1) != 0) {
                    friendSuggestion = suggestedFriend.suggestion;
                }
                return suggestedFriend.copy(friendSuggestion);
            }

            /* renamed from: component1, reason: from getter */
            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public final SuggestedFriend copy(FriendSuggestion suggestion) {
                Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
                return new SuggestedFriend(suggestion);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SuggestedFriend) && Intrinsics3.areEqual(this.suggestion, ((SuggestedFriend) other).suggestion);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public int hashCode() {
                FriendSuggestion friendSuggestion = this.suggestion;
                if (friendSuggestion != null) {
                    return friendSuggestion.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("SuggestedFriend(suggestion=");
                sbM833U.append(this.suggestion);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class SuggestedFriendsHeader extends Item {
            private final int count;
            private final boolean isExpanded;
            private final String key;
            private final boolean showExpandButton;

            public SuggestedFriendsHeader(int i, boolean z2, boolean z3) {
                super(4, null);
                this.count = i;
                this.isExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ SuggestedFriendsHeader copy$default(SuggestedFriendsHeader suggestedFriendsHeader, int i, boolean z2, boolean z3, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = suggestedFriendsHeader.count;
                }
                if ((i2 & 2) != 0) {
                    z2 = suggestedFriendsHeader.isExpanded;
                }
                if ((i2 & 4) != 0) {
                    z3 = suggestedFriendsHeader.showExpandButton;
                }
                return suggestedFriendsHeader.copy(i, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsExpanded() {
                return this.isExpanded;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final SuggestedFriendsHeader copy(int count, boolean isExpanded, boolean showExpandButton) {
                return new SuggestedFriendsHeader(count, isExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedFriendsHeader)) {
                    return false;
                }
                SuggestedFriendsHeader suggestedFriendsHeader = (SuggestedFriendsHeader) other;
                return this.count == suggestedFriendsHeader.count && this.isExpanded == suggestedFriendsHeader.isExpanded && this.showExpandButton == suggestedFriendsHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = this.count * 31;
                boolean z2 = this.isExpanded;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                boolean z3 = this.showExpandButton;
                return i3 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isExpanded() {
                return this.isExpanded;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("SuggestedFriendsHeader(count=");
                sbM833U.append(this.count);
                sbM833U.append(", isExpanded=");
                sbM833U.append(this.isExpanded);
                sbM833U.append(", showExpandButton=");
                return outline.m827O(sbM833U, this.showExpandButton, ")");
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static final /* data */ class ListSections {
        private final Item.ContactSyncUpsell contactSyncUpsell;
        private final List<Item> friendsItemsWithHeaders;
        private final Item.PendingHeader pendingHeaderItem;
        private final List<Item> pendingItems;
        private final List<Item.SuggestedFriend> suggestedFriendItems;
        private final Item.SuggestedFriendsHeader suggestionsHeaderItem;

        /* JADX WARN: Multi-variable type inference failed */
        public ListSections(Item.SuggestedFriendsHeader suggestedFriendsHeader, List<Item.SuggestedFriend> list, Item.PendingHeader pendingHeader, List<? extends Item> list2, List<? extends Item> list3, Item.ContactSyncUpsell contactSyncUpsell) {
            Intrinsics3.checkNotNullParameter(list, "suggestedFriendItems");
            Intrinsics3.checkNotNullParameter(list2, "pendingItems");
            Intrinsics3.checkNotNullParameter(list3, "friendsItemsWithHeaders");
            this.suggestionsHeaderItem = suggestedFriendsHeader;
            this.suggestedFriendItems = list;
            this.pendingHeaderItem = pendingHeader;
            this.pendingItems = list2;
            this.friendsItemsWithHeaders = list3;
            this.contactSyncUpsell = contactSyncUpsell;
        }

        public static /* synthetic */ ListSections copy$default(ListSections listSections, Item.SuggestedFriendsHeader suggestedFriendsHeader, List list, Item.PendingHeader pendingHeader, List list2, List list3, Item.ContactSyncUpsell contactSyncUpsell, int i, Object obj) {
            if ((i & 1) != 0) {
                suggestedFriendsHeader = listSections.suggestionsHeaderItem;
            }
            if ((i & 2) != 0) {
                list = listSections.suggestedFriendItems;
            }
            List list4 = list;
            if ((i & 4) != 0) {
                pendingHeader = listSections.pendingHeaderItem;
            }
            Item.PendingHeader pendingHeader2 = pendingHeader;
            if ((i & 8) != 0) {
                list2 = listSections.pendingItems;
            }
            List list5 = list2;
            if ((i & 16) != 0) {
                list3 = listSections.friendsItemsWithHeaders;
            }
            List list6 = list3;
            if ((i & 32) != 0) {
                contactSyncUpsell = listSections.contactSyncUpsell;
            }
            return listSections.copy(suggestedFriendsHeader, list4, pendingHeader2, list5, list6, contactSyncUpsell);
        }

        /* renamed from: component1, reason: from getter */
        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public final List<Item.SuggestedFriend> component2() {
            return this.suggestedFriendItems;
        }

        /* renamed from: component3, reason: from getter */
        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> component4() {
            return this.pendingItems;
        }

        public final List<Item> component5() {
            return this.friendsItemsWithHeaders;
        }

        /* renamed from: component6, reason: from getter */
        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final ListSections copy(Item.SuggestedFriendsHeader suggestionsHeaderItem, List<Item.SuggestedFriend> suggestedFriendItems, Item.PendingHeader pendingHeaderItem, List<? extends Item> pendingItems, List<? extends Item> friendsItemsWithHeaders, Item.ContactSyncUpsell contactSyncUpsell) {
            Intrinsics3.checkNotNullParameter(suggestedFriendItems, "suggestedFriendItems");
            Intrinsics3.checkNotNullParameter(pendingItems, "pendingItems");
            Intrinsics3.checkNotNullParameter(friendsItemsWithHeaders, "friendsItemsWithHeaders");
            return new ListSections(suggestionsHeaderItem, suggestedFriendItems, pendingHeaderItem, pendingItems, friendsItemsWithHeaders, contactSyncUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListSections)) {
                return false;
            }
            ListSections listSections = (ListSections) other;
            return Intrinsics3.areEqual(this.suggestionsHeaderItem, listSections.suggestionsHeaderItem) && Intrinsics3.areEqual(this.suggestedFriendItems, listSections.suggestedFriendItems) && Intrinsics3.areEqual(this.pendingHeaderItem, listSections.pendingHeaderItem) && Intrinsics3.areEqual(this.pendingItems, listSections.pendingItems) && Intrinsics3.areEqual(this.friendsItemsWithHeaders, listSections.friendsItemsWithHeaders) && Intrinsics3.areEqual(this.contactSyncUpsell, listSections.contactSyncUpsell);
        }

        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final List<Item> getFriendsItemsWithHeaders() {
            return this.friendsItemsWithHeaders;
        }

        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> getPendingItems() {
            return this.pendingItems;
        }

        public final List<Item.SuggestedFriend> getSuggestedFriendItems() {
            return this.suggestedFriendItems;
        }

        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public int hashCode() {
            Item.SuggestedFriendsHeader suggestedFriendsHeader = this.suggestionsHeaderItem;
            int iHashCode = (suggestedFriendsHeader != null ? suggestedFriendsHeader.hashCode() : 0) * 31;
            List<Item.SuggestedFriend> list = this.suggestedFriendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Item.PendingHeader pendingHeader = this.pendingHeaderItem;
            int iHashCode3 = (iHashCode2 + (pendingHeader != null ? pendingHeader.hashCode() : 0)) * 31;
            List<Item> list2 = this.pendingItems;
            int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Item> list3 = this.friendsItemsWithHeaders;
            int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Item.ContactSyncUpsell contactSyncUpsell = this.contactSyncUpsell;
            return iHashCode5 + (contactSyncUpsell != null ? contactSyncUpsell.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ListSections(suggestionsHeaderItem=");
            sbM833U.append(this.suggestionsHeaderItem);
            sbM833U.append(", suggestedFriendItems=");
            sbM833U.append(this.suggestedFriendItems);
            sbM833U.append(", pendingHeaderItem=");
            sbM833U.append(this.pendingHeaderItem);
            sbM833U.append(", pendingItems=");
            sbM833U.append(this.pendingItems);
            sbM833U.append(", friendsItemsWithHeaders=");
            sbM833U.append(this.friendsItemsWithHeaders);
            sbM833U.append(", contactSyncUpsell=");
            sbM833U.append(this.contactSyncUpsell);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final long channelId;
        private final Map<Long, FriendSuggestion> friendSuggestions;
        private final Map<Long, Presence> presences;
        private final StoreUserRelationships.UserRelationshipsState relationshipsState;
        private final boolean showContactSyncIcon;
        private final boolean showContactSyncUpsell;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(boolean z2, boolean z3, long j, StoreUserRelationships.UserRelationshipsState userRelationshipsState, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, FriendSuggestion> map4) {
            Intrinsics3.checkNotNullParameter(userRelationshipsState, "relationshipsState");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
            Intrinsics3.checkNotNullParameter(map4, "friendSuggestions");
            this.showContactSyncIcon = z2;
            this.showContactSyncUpsell = z3;
            this.channelId = j;
            this.relationshipsState = userRelationshipsState;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
            this.friendSuggestions = map4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, long j, StoreUserRelationships.UserRelationshipsState userRelationshipsState, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.showContactSyncIcon : z2, (i & 2) != 0 ? storeState.showContactSyncUpsell : z3, (i & 4) != 0 ? storeState.channelId : j, (i & 8) != 0 ? storeState.relationshipsState : userRelationshipsState, (i & 16) != 0 ? storeState.users : map, (i & 32) != 0 ? storeState.presences : map2, (i & 64) != 0 ? storeState.applicationStreams : map3, (i & 128) != 0 ? storeState.friendSuggestions : map4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        /* renamed from: component3, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final Map<Long, User> component5() {
            return this.users;
        }

        public final Map<Long, Presence> component6() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component7() {
            return this.applicationStreams;
        }

        public final Map<Long, FriendSuggestion> component8() {
            return this.friendSuggestions;
        }

        public final StoreState copy(boolean showContactSyncIcon, boolean showContactSyncUpsell, long channelId, StoreUserRelationships.UserRelationshipsState relationshipsState, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, FriendSuggestion> friendSuggestions) {
            Intrinsics3.checkNotNullParameter(relationshipsState, "relationshipsState");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
            Intrinsics3.checkNotNullParameter(friendSuggestions, "friendSuggestions");
            return new StoreState(showContactSyncIcon, showContactSyncUpsell, channelId, relationshipsState, users, presences, applicationStreams, friendSuggestions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.showContactSyncIcon == storeState.showContactSyncIcon && this.showContactSyncUpsell == storeState.showContactSyncUpsell && this.channelId == storeState.channelId && Intrinsics3.areEqual(this.relationshipsState, storeState.relationshipsState) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.presences, storeState.presences) && Intrinsics3.areEqual(this.applicationStreams, storeState.applicationStreams) && Intrinsics3.areEqual(this.friendSuggestions, storeState.friendSuggestions);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, FriendSuggestion> getFriendSuggestions() {
            return this.friendSuggestions;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        public int hashCode() {
            boolean z2 = this.showContactSyncIcon;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showContactSyncUpsell;
            int iM3a = (C0002b.m3a(this.channelId) + ((i + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31;
            StoreUserRelationships.UserRelationshipsState userRelationshipsState = this.relationshipsState;
            int iHashCode = (iM3a + (userRelationshipsState != null ? userRelationshipsState.hashCode() : 0)) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, FriendSuggestion> map4 = this.friendSuggestions;
            return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(showContactSyncIcon=");
            sbM833U.append(this.showContactSyncIcon);
            sbM833U.append(", showContactSyncUpsell=");
            sbM833U.append(this.showContactSyncUpsell);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", relationshipsState=");
            sbM833U.append(this.relationshipsState);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", presences=");
            sbM833U.append(this.presences);
            sbM833U.append(", applicationStreams=");
            sbM833U.append(this.applicationStreams);
            sbM833U.append(", friendSuggestions=");
            return outline.m825M(sbM833U, this.friendSuggestions, ")");
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Empty extends ViewState {
            private final boolean showContactSyncIcon;

            public Empty(boolean z2) {
                super(null);
                this.showContactSyncIcon = z2;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = empty.showContactSyncIcon;
                }
                return empty.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final Empty copy(boolean showContactSyncIcon) {
                return new Empty(showContactSyncIcon);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && this.showContactSyncIcon == ((Empty) other).showContactSyncIcon;
                }
                return true;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.m827O(outline.m833U("Empty(showContactSyncIcon="), this.showContactSyncIcon, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Item> items;
            private final boolean showContactSyncIcon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, List<? extends Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.showContactSyncIcon = z2;
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.showContactSyncIcon;
                }
                if ((i & 2) != 0) {
                    list = loaded.items;
                }
                return loaded.copy(z2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final List<Item> component2() {
                return this.items;
            }

            public final Loaded copy(boolean showContactSyncIcon, List<? extends Item> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Loaded(showContactSyncIcon, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.showContactSyncIcon == loaded.showContactSyncIcon && Intrinsics3.areEqual(this.items, loaded.items);
            }

            public final List<Item> getItems() {
                return this.items;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                List<Item> list = this.items;
                return i + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(showContactSyncIcon=");
                sbM833U.append(this.showContactSyncIcon);
                sbM833U.append(", items=");
                return outline.m824L(sbM833U, this.items, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$1 */
    public static final class C83571 extends Lambda implements Function1<Void, Unit> {
        public C83571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, C5419R.string.accept_request_button_after);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2 */
    public static final class C83582 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $username;

        /* compiled from: FriendsListViewModel.kt */
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendsListViewModel friendsListViewModel = FriendsListViewModel.this;
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                FriendsListViewModel.access$emitShowFriendRequestAbortToast(friendsListViewModel, response.getCode(), C83582.this.$username);
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, C5419R.string.default_failure_to_perform_action_message);
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83582(String str) {
            super(1);
            this.$username = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new AnonymousClass1(error), new AnonymousClass2());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$1 */
    public static final class C83591 extends Lambda implements Function1<Void, Unit> {
        public static final C83591 INSTANCE = new C83591();

        public C83591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2 */
    public static final class C83602 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: FriendsListViewModel.kt */
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (WidgetCaptcha4.isCaptchaError(this.$error)) {
                    C83602 c83602 = C83602.this;
                    FriendsListViewModel.access$emitCaptchaErrorEvent(FriendsListViewModel.this, this.$error, c83602.$username, c83602.$discriminator);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83602(String str, int i) {
            super(1);
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(RestAPIAbortMessages.INSTANCE, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$1 */
    public static final class C83611<T> implements Action1<Emitter<T>> {
        public final /* synthetic */ Function0 $compute;

        public C83611(Function0 function0) {
            this.$compute = function0;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Emitter) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void call(Emitter<T> emitter) {
            emitter.onNext(this.$compute.invoke());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$2 */
    public static final class C83622<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83622(Function1 function1) {
            super(1);
            this.$onSuccess = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$onSuccess.invoke(t);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$3 */
    public static final class C83633 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83633(Function1 function1) {
            super(1);
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$4 */
    public static final class C83644 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83644(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscription = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            this.$subscription.element = subscription;
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$5 */
    public static final class C83655 implements Cancellable {
        public final /* synthetic */ Ref$ObjectRef $subscription;

        public C83655(Ref$ObjectRef ref$ObjectRef) {
            this.$subscription = ref$ObjectRef;
        }

        @Override // p658rx.functions.Cancellable
        public final void cancel() {
            Subscription subscription = (Subscription) this.$subscription.element;
            if (subscription != null) {
                subscription.unsubscribe();
            }
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$3 */
    public static final class C83663 extends Lambda implements Function1<Integer, Boolean> {
        public static final C83663 INSTANCE = new C83663();

        public C83663() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(int i) {
            return Sets5.setOf((Object[]) new Integer[]{3, 4}).contains(Integer.valueOf(i));
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$1 */
    public static final class C83671 extends Lambda implements Function0<ListSections> {
        public final /* synthetic */ Map $relationships;
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83671(Map map, StoreState storeState) {
            super(0);
            this.$relationships = map;
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ListSections invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ListSections invoke() {
            return FriendsListViewModel.access$getItems(FriendsListViewModel.this, this.$relationships, this.$storeState.getUsers(), this.$storeState.getPresences(), this.$storeState.getApplicationStreams(), this.$storeState.getShowContactSyncUpsell(), this.$storeState.getFriendSuggestions());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$2 */
    public static final class C83682 extends Lambda implements Function1<ListSections, Unit> {
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83682(StoreState storeState) {
            super(1);
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListSections listSections) {
            invoke2(listSections);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ListSections listSections) {
            Intrinsics3.checkNotNullParameter(listSections, "it");
            FriendsListViewModel.access$handleComputedItems(FriendsListViewModel.this, listSections, this.$storeState.getShowContactSyncIcon());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$ignoreSuggestion$1 */
    public static final class C83691 extends Lambda implements Function1<Void, Unit> {
        public static final C83691 INSTANCE = new C83691();

        public C83691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$1 */
    public static final class C83701 extends Lambda implements Function1<Channel, Unit> {
        public C83701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            FriendsListViewModel.access$emitLaunchVoiceCallEvent(FriendsListViewModel.this, channel.getId());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$2 */
    public static final class C83712 extends Lambda implements Function1<Error, Unit> {
        public C83712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, C5419R.string.default_failure_to_perform_action_message);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$1 */
    public static final class C83721 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83721(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, this.$successMessageStringRes);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$2 */
    public static final class C83732 extends Lambda implements Function1<Error, Unit> {
        public C83732() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, C5419R.string.default_failure_to_perform_action_message);
        }
    }

    public FriendsListViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ FriendsListViewModel(Observable observable, StoreChannels storeChannels, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.observeStores() : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static /* synthetic */ void acceptFriendSuggestion$default(FriendsListViewModel friendsListViewModel, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        friendsListViewModel.acceptFriendSuggestion(str, i, captchaPayload);
    }

    public static final /* synthetic */ void access$emitCaptchaErrorEvent(FriendsListViewModel friendsListViewModel, Error error, String str, int i) {
        friendsListViewModel.emitCaptchaErrorEvent(error, str, i);
    }

    public static final /* synthetic */ void access$emitLaunchVoiceCallEvent(FriendsListViewModel friendsListViewModel, long j) {
        friendsListViewModel.emitLaunchVoiceCallEvent(j);
    }

    public static final /* synthetic */ void access$emitShowFriendRequestAbortToast(FriendsListViewModel friendsListViewModel, int i, String str) {
        friendsListViewModel.emitShowFriendRequestAbortToast(i, str);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(FriendsListViewModel friendsListViewModel, int i) {
        friendsListViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ ListSections access$getItems(FriendsListViewModel friendsListViewModel, Map map, Map map2, Map map3, Map map4, boolean z2, Map map5) {
        return friendsListViewModel.getItems(map, map2, map3, map4, z2, map5);
    }

    public static final /* synthetic */ void access$handleComputedItems(FriendsListViewModel friendsListViewModel, ListSections listSections, boolean z2) {
        friendsListViewModel.handleComputedItems(listSections, z2);
    }

    public static final /* synthetic */ void access$handleStoreState(FriendsListViewModel friendsListViewModel, StoreState storeState) throws Exception {
        friendsListViewModel.handleStoreState(storeState);
    }

    private final <T> Cancellable asyncComputeAndHandleOnUiThread(Function0<? extends T> compute, Function1<? super Error, Unit> onError, Function1<? super T, Unit> onSuccess) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableM11098X = Observable.m11080o(new C83611(compute), Emitter.BackpressureMode.NONE).m11098X(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "Observable\n        .crea…Schedulers.computation())");
        Observable observableUi$default = ObservableExtensionsKt.ui$default(observableM11098X, this, null, 2, null);
        C83622 c83622 = new C83622(onSuccess);
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, FriendsListViewModel.class, (Context) null, new C83644(ref$ObjectRef), new C83633(onError), (Function0) null, (Function0) null, c83622, 50, (Object) null);
        return new C83655(ref$ObjectRef);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cancellable asyncComputeAndHandleOnUiThread$default(FriendsListViewModel friendsListViewModel, Function0 function0, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return friendsListViewModel.asyncComputeAndHandleOnUiThread(function0, function1, function12);
    }

    private final void emitCaptchaErrorEvent(Error error, String username, int discriminator) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.CaptchaError(error, username, discriminator));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.LaunchVoiceCall(channelId));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowToast(stringRes));
    }

    @MainThread
    private final void generateLoadedItems(boolean showContactSyncIcon) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = this.listSections.getSuggestionsHeaderItem();
        Item.SuggestedFriendsHeader suggestedFriendsHeaderCopy$default = suggestionsHeaderItem != null ? Item.SuggestedFriendsHeader.copy$default(suggestionsHeaderItem, 0, this.isSuggestedSectionExpanded, false, 5, null) : null;
        Item.PendingHeader pendingHeaderItem = this.listSections.getPendingHeaderItem();
        ListSections listSectionsCopy$default = ListSections.copy$default(this.listSections, suggestedFriendsHeaderCopy$default, null, pendingHeaderItem != null ? Item.PendingHeader.copy$default(pendingHeaderItem, 0, 0, this.isPendingSectionExpanded, false, 11, null) : null, null, null, null, 58, null);
        this.listSections = listSectionsCopy$default;
        List<Item> visibleItems = getVisibleItems(listSectionsCopy$default);
        updateViewState(visibleItems.isEmpty() ^ true ? new ViewState.Loaded(showContactSyncIcon, visibleItems) : new ViewState.Empty(showContactSyncIcon));
    }

    public static /* synthetic */ void generateLoadedItems$default(FriendsListViewModel friendsListViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        friendsListViewModel.generateLoadedItems(z2);
    }

    private final ListSections getItems(Map<Long, Integer> relationships, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, boolean showContactSyncUpsell, Map<Long, FriendSuggestion> friendSuggestions) {
        ArrayList arrayList = new ArrayList();
        if (!friendSuggestions.isEmpty()) {
            Iterator<T> it = friendSuggestions.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new Item.SuggestedFriend((FriendSuggestion) it.next()));
            }
            if (arrayList.size() > 1) {
                MutableCollectionsJVM.sortWith(arrayList, new FriendsListViewModel$getItems$$inlined$sortBy$1());
            }
        }
        Item.SuggestedFriendsHeader suggestedFriendsHeader = !arrayList.isEmpty() ? new Item.SuggestedFriendsHeader(arrayList.size(), false, arrayList.size() > 2) : null;
        C83663 c83663 = C83663.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : _Maps.asSequence(relationships)) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            int iIntValue = ((Number) entry.getValue()).intValue();
            User user = users.get(Long.valueOf(jLongValue));
            int type = ModelUserRelationship.getType(Integer.valueOf(iIntValue));
            Presence presence = presences.get(Long.valueOf(jLongValue));
            boolean zContainsKey = applicationStreams.containsKey(Long.valueOf(jLongValue));
            if (user != null && type != 2) {
                if (C83663.INSTANCE.invoke(type)) {
                    arrayList2.add(new Item.PendingFriendRequest(user, presence, type));
                } else {
                    arrayList3.add(new Item.Friend(user, presence, zContainsKey));
                }
            }
        }
        List list = _Collections.toList(_Collections.sortedWith(arrayList2, FriendsListViewModel5.INSTANCE));
        Item.PendingHeader pendingHeader = !list.isEmpty() ? new Item.PendingHeader(C5419R.string.friends_pending_request_header, list.size(), false, list.size() > 2) : null;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((Item.Friend) obj).isOnline()) {
                arrayList5.add(obj);
            }
        }
        List list2 = _Collections.toList(_Collections.sortedWith(arrayList5, FriendsListViewModel4.INSTANCE));
        if (!list2.isEmpty()) {
            arrayList4.add(new Item.Header(C5419R.string.friends_online_header, list2.size()));
            arrayList4.addAll(list2);
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((Item.Friend) obj2).isOnline()) {
                arrayList6.add(obj2);
            }
        }
        List list3 = _Collections.toList(_Collections.sortedWith(arrayList6, FriendsListViewModel3.INSTANCE));
        if (true ^ list3.isEmpty()) {
            arrayList4.add(new Item.Header(C5419R.string.friends_offline_header, list3.size()));
            arrayList4.addAll(list3);
        }
        return new ListSections(suggestedFriendsHeader, arrayList, pendingHeader, list, arrayList4, showContactSyncUpsell ? new Item.ContactSyncUpsell(false) : null);
    }

    private final List<Item> getVisibleItems(ListSections listSections) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = listSections.getSuggestionsHeaderItem();
        List<Item.SuggestedFriend> suggestedFriendItems = listSections.getSuggestedFriendItems();
        Item.PendingHeader pendingHeaderItem = listSections.getPendingHeaderItem();
        List<Item> pendingItems = listSections.getPendingItems();
        List<Item> friendsItemsWithHeaders = listSections.getFriendsItemsWithHeaders();
        ArrayList arrayList = new ArrayList();
        if (listSections.getContactSyncUpsell() != null) {
            arrayList.add(listSections.getContactSyncUpsell());
        }
        if (!this.isSuggestedSectionExpanded) {
            suggestedFriendItems = _Collections.take(suggestedFriendItems, 2);
        }
        if (suggestionsHeaderItem != null && (!suggestedFriendItems.isEmpty())) {
            arrayList.add(suggestionsHeaderItem);
            arrayList.addAll(suggestedFriendItems);
        }
        if (!this.isPendingSectionExpanded) {
            pendingItems = _Collections.take(pendingItems, 2);
        }
        if (pendingHeaderItem != null && (!pendingItems.isEmpty())) {
            arrayList.add(pendingHeaderItem);
            arrayList.addAll(pendingItems);
        }
        arrayList.addAll(friendsItemsWithHeaders);
        return arrayList;
    }

    @MainThread
    private final void handleComputedItems(ListSections listSections, boolean showContactSyncIcon) {
        this.listSections = listSections;
        generateLoadedItems(showContactSyncIcon);
    }

    private final void handleStoreState(StoreState storeState) throws Exception {
        Cancellable cancellable = this.computeItemJob;
        if (cancellable != null) {
            cancellable.cancel();
        }
        if (!(storeState.getRelationshipsState() instanceof StoreUserRelationships.UserRelationshipsState.Loaded)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        Map<Long, Integer> relationships = ((StoreUserRelationships.UserRelationshipsState.Loaded) storeState.getRelationshipsState()).getRelationships();
        if (relationships.isEmpty()) {
            updateViewState(new ViewState.Empty(storeState.getShowContactSyncIcon() || storeState.getShowContactSyncUpsell()));
        } else {
            this.computeItemJob = asyncComputeAndHandleOnUiThread$default(this, new C83671(relationships, storeState), null, new C83682(storeState), 2, null);
        }
    }

    public final void acceptFriendRequest(long userId, String username) {
        Intrinsics3.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(this.restAPI, LOCATION, userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new C83582(username), (Function0) null, (Function0) null, new C83571(), 54, (Object) null);
    }

    public final void acceptFriendSuggestion(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Friends List - Friend Suggestion", username, discriminator, captchaPayload), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new C83602(username, discriminator), (Function0) null, (Function0) null, C83591.INSTANCE, 54, (Object) null);
    }

    @MainThread
    public final void dismissContactSyncUpsell() {
        StoreStream.INSTANCE.getContactSync().dismissFriendsListUpsell();
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final Observable<StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    @MainThread
    public final void handleClickPendingHeader() {
        this.isPendingSectionExpanded = !this.isPendingSectionExpanded;
        ViewState viewState = getViewState();
        generateLoadedItems(viewState instanceof ViewState.Empty ? ((ViewState.Empty) viewState).getShowContactSyncIcon() : viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false);
    }

    @MainThread
    public final void handleClickSuggestedHeader() {
        this.isSuggestedSectionExpanded = !this.isSuggestedSectionExpanded;
        ViewState viewState = getViewState();
        generateLoadedItems(viewState instanceof ViewState.Empty ? ((ViewState.Empty) viewState).getShowContactSyncIcon() : viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false);
    }

    public final void ignoreSuggestion(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ignoreFriendSuggestion(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C83691.INSTANCE, 62, (Object) null);
    }

    public final void launchVoiceCall(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createOrFetchDM(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new C83712(), (Function0) null, (Function0) null, new C83701(), 54, (Object) null);
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeFriendRequest(long userId, int relationshipType) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new C83732(), (Function0) null, (Function0) null, new C83721(relationshipType == 3 ? C5419R.string.friend_request_ignored : C5419R.string.friend_request_cancelled), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel(Observable<StoreState> observable, StoreChannels storeChannels, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.storeObservable = observable;
        this.storeChannels = storeChannels;
        this.restAPI = restAPI;
        this.listSections = new ListSections(null, Collections2.emptyList(), null, Collections2.emptyList(), Collections2.emptyList(), null);
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83561(), 62, (Object) null);
    }
}
