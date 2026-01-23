package com.discord.widgets.user;

import android.content.Context;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMentionsBinding;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.fragment.FragmentExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.views.CheckedSetting;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserMentions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_IS_EMBEDDED = "EXTRA_HIDE_TITLE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* JADX INFO: renamed from: isEmbedded$delegate, reason: from kotlin metadata */
    private final Lazy isEmbedded;
    private WidgetChatListAdapter mentionsAdapter;
    private final Model.MessageLoader mentionsLoader;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetUserMentions create$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.create(z2);
        }

        public final WidgetUserMentions create(boolean isEmbedded) {
            WidgetUserMentions widgetUserMentions = new WidgetUserMentions();
            widgetUserMentions.setArguments(Bundle2.bundleOf(Tuples.m10073to(WidgetUserMentions.EXTRA_IS_EMBEDDED, Boolean.valueOf(isEmbedded))));
            return widgetUserMentions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean animateEmojis;
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final String guildName;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final NavigationTab selectedTab;
        private final long userId;

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Observable<Model> get(MessageLoader messageLoader, NavigationTab selectedTab) {
                Intrinsics3.checkNotNullParameter(messageLoader, "messageLoader");
                Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
                Observable<R> observableM11099Y = messageLoader.getMentionsLoadingStateSubject().m11099Y(new WidgetUserMentions$Model$Companion$get$1(selectedTab));
                Observable<Model> observableM11112r = Observable.m11074h0(new OnSubscribeLift(observableM11099Y.f27640j, new LeadingEdgeThrottle(300L, TimeUnit.MILLISECONDS, Schedulers2.m10873a()))).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "messageLoader\n          …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class MessageLoader {
            private StoreChat.InteractionState interactionState;
            private boolean isFocused;
            private Long loadBeforeMessageId;
            private Subscription loadSubscription;
            private final BehaviorSubject<LoadingState> mentionsLoadingStateSubject;
            private Function0<Unit> retryAction;
            private final long retryDelayMs;
            private Subscription retrySubscription;
            private final ArrayList<Message> mentions = new ArrayList<>();
            private final int mentionLimit = 25;
            private LoadingState mentionsLoadingState = new LoadingState(false, false, null, 7, null);
            private Filters filters = new Filters(0, false, false, false, 15, null);

            /* JADX INFO: compiled from: WidgetUserMentions.kt */
            public static final /* data */ class Filters {
                private final boolean allGuilds;
                private final long guildId;
                private final boolean includeEveryone;
                private final boolean includeRoles;

                public Filters() {
                    this(0L, false, false, false, 15, null);
                }

                public Filters(long j, boolean z2, boolean z3, boolean z4) {
                    this.guildId = j;
                    this.allGuilds = z2;
                    this.includeEveryone = z3;
                    this.includeRoles = z4;
                }

                public static /* synthetic */ Filters copy$default(Filters filters, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = filters.guildId;
                    }
                    long j2 = j;
                    if ((i & 2) != 0) {
                        z2 = filters.allGuilds;
                    }
                    boolean z5 = z2;
                    if ((i & 4) != 0) {
                        z3 = filters.includeEveryone;
                    }
                    boolean z6 = z3;
                    if ((i & 8) != 0) {
                        z4 = filters.includeRoles;
                    }
                    return filters.copy(j2, z5, z6, z4);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final long getGuildId() {
                    return this.guildId;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                public final Filters copy(long guildId, boolean allGuilds, boolean includeEveryone, boolean includeRoles) {
                    return new Filters(guildId, allGuilds, includeEveryone, includeRoles);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Filters)) {
                        return false;
                    }
                    Filters filters = (Filters) other;
                    return this.guildId == filters.guildId && this.allGuilds == filters.allGuilds && this.includeEveryone == filters.includeEveryone && this.includeRoles == filters.includeRoles;
                }

                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                public final long getGuildId() {
                    return this.guildId;
                }

                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v1, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v6 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r1v8 */
                /* JADX WARN: Type inference failed for: r2v0 */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v2 */
                public int hashCode() {
                    int iM3a = C0002b.m3a(this.guildId) * 31;
                    boolean z2 = this.allGuilds;
                    ?? r1 = z2;
                    if (z2) {
                        r1 = 1;
                    }
                    int i = (iM3a + r1) * 31;
                    boolean z3 = this.includeEveryone;
                    ?? r12 = z3;
                    if (z3) {
                        r12 = 1;
                    }
                    int i2 = (i + r12) * 31;
                    boolean z4 = this.includeRoles;
                    return i2 + (z4 ? 1 : z4);
                }

                public String toString() {
                    StringBuilder sbM833U = outline.m833U("Filters(guildId=");
                    sbM833U.append(this.guildId);
                    sbM833U.append(", allGuilds=");
                    sbM833U.append(this.allGuilds);
                    sbM833U.append(", includeEveryone=");
                    sbM833U.append(this.includeEveryone);
                    sbM833U.append(", includeRoles=");
                    return outline.m827O(sbM833U, this.includeRoles, ")");
                }

                public /* synthetic */ Filters(long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
                }
            }

            /* JADX INFO: compiled from: WidgetUserMentions.kt */
            public static final /* data */ class LoadingState {
                private final boolean isAllLoaded;
                private final boolean isLoading;
                private final List<Message> mentions;

                public LoadingState() {
                    this(false, false, null, 7, null);
                }

                public LoadingState(boolean z2, boolean z3, List<Message> list) {
                    Intrinsics3.checkNotNullParameter(list, "mentions");
                    this.isLoading = z2;
                    this.isAllLoaded = z3;
                    this.mentions = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, boolean z2, boolean z3, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = loadingState.isLoading;
                    }
                    if ((i & 2) != 0) {
                        z3 = loadingState.isAllLoaded;
                    }
                    if ((i & 4) != 0) {
                        list = loadingState.mentions;
                    }
                    return loadingState.copy(z2, z3, list);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final boolean getIsLoading() {
                    return this.isLoading;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getIsAllLoaded() {
                    return this.isAllLoaded;
                }

                public final List<Message> component3() {
                    return this.mentions;
                }

                public final LoadingState copy(boolean isLoading, boolean isAllLoaded, List<Message> mentions) {
                    Intrinsics3.checkNotNullParameter(mentions, "mentions");
                    return new LoadingState(isLoading, isAllLoaded, mentions);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof LoadingState)) {
                        return false;
                    }
                    LoadingState loadingState = (LoadingState) other;
                    return this.isLoading == loadingState.isLoading && this.isAllLoaded == loadingState.isAllLoaded && Intrinsics3.areEqual(this.mentions, loadingState.mentions);
                }

                public final List<Message> getMentions() {
                    return this.mentions;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v1, types: [int] */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v1, types: [int] */
                /* JADX WARN: Type inference failed for: r1v6 */
                public int hashCode() {
                    boolean z2 = this.isLoading;
                    ?? r0 = z2;
                    if (z2) {
                        r0 = 1;
                    }
                    int i = r0 * 31;
                    boolean z3 = this.isAllLoaded;
                    int i2 = (i + (z3 ? 1 : z3)) * 31;
                    List<Message> list = this.mentions;
                    return i2 + (list != null ? list.hashCode() : 0);
                }

                public final boolean isAllLoaded() {
                    return this.isAllLoaded;
                }

                public final boolean isLoading() {
                    return this.isLoading;
                }

                public String toString() {
                    StringBuilder sbM833U = outline.m833U("LoadingState(isLoading=");
                    sbM833U.append(this.isLoading);
                    sbM833U.append(", isAllLoaded=");
                    sbM833U.append(this.isAllLoaded);
                    sbM833U.append(", mentions=");
                    return outline.m824L(sbM833U, this.mentions, ")");
                }

                public /* synthetic */ LoadingState(boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? Collections2.emptyList() : list);
                }
            }

            public MessageLoader(long j) {
                this.retryDelayMs = j;
                BehaviorSubject<LoadingState> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(this.mentionsLoadingState);
                Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(mentionsLoadingState)");
                this.mentionsLoadingStateSubject = behaviorSubjectM11130l0;
            }

            public static final /* synthetic */ Subscription access$getLoadSubscription$p(MessageLoader messageLoader) {
                return messageLoader.loadSubscription;
            }

            public static final /* synthetic */ Subscription access$getRetrySubscription$p(MessageLoader messageLoader) {
                return messageLoader.retrySubscription;
            }

            public static final /* synthetic */ void access$handleLoadError(MessageLoader messageLoader) {
                messageLoader.handleLoadError();
            }

            public static final /* synthetic */ void access$handleLoaded(MessageLoader messageLoader, List list) {
                messageLoader.handleLoaded(list);
            }

            public static final /* synthetic */ void access$setLoadSubscription$p(MessageLoader messageLoader, Subscription subscription) {
                messageLoader.loadSubscription = subscription;
            }

            public static final /* synthetic */ void access$setRetrySubscription$p(MessageLoader messageLoader, Subscription subscription) {
                messageLoader.retrySubscription = subscription;
            }

            @MainThread
            private final void handleLoadError() {
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoadError$1(this));
            }

            @MainThread
            private final void handleLoaded(List<Message> messages) {
                boolean z2 = messages.isEmpty() || messages.size() < this.mentionLimit;
                Message message = (Message) _Collections.lastOrNull((List) messages);
                this.loadBeforeMessageId = message != null ? Long.valueOf(message.getId()) : null;
                this.mentions.addAll(messages);
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, false, false, new ArrayList(this.mentions), 3, null));
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoaded$1(this, z2));
            }

            private final void retry(Function0<Unit> retryAction) {
                Subscription subscription = this.retrySubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.retryAction = retryAction;
                Observable<Long> observableM11068d0 = Observable.m11068d0(this.retryDelayMs, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(retryDe…s, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11068d0), MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$retry$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$retry$2(retryAction), 58, (Object) null);
            }

            private final void setMentionsLoadingState(LoadingState loadingState) {
                if (Intrinsics3.areEqual(this.mentionsLoadingState, loadingState)) {
                    return;
                }
                this.mentionsLoadingState = loadingState;
                this.mentionsLoadingStateSubject.onNext(loadingState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void tryLoad$default(MessageLoader messageLoader, Function1 function1, int i, Object obj) {
                if ((i & 1) != 0) {
                    function1 = WidgetUserMentions$Model$MessageLoader$tryLoad$1.INSTANCE;
                }
                messageLoader.tryLoad(function1);
            }

            public final Filters getFilters() {
                return this.filters;
            }

            public final BehaviorSubject<LoadingState> getMentionsLoadingStateSubject() {
                return this.mentionsLoadingStateSubject;
            }

            @MainThread
            public final void setFilters(Filters filters) {
                Intrinsics3.checkNotNullParameter(filters, "value");
                if (!Intrinsics3.areEqual(this.filters, filters)) {
                    this.filters = filters;
                    Subscription subscription = this.loadSubscription;
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.loadBeforeMessageId = null;
                    this.mentions.clear();
                    tryLoad(WidgetUserMentions$Model$MessageLoader$filters$1.INSTANCE);
                }
            }

            @MainThread
            public final void setInteractionState(StoreChat.InteractionState interactionState) {
                Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
                this.interactionState = interactionState;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void setIsFocused(boolean isFocused) {
                this.isFocused = isFocused;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void tryLoad(Function1<? super LoadingState, LoadingState> loadingStateUpdater) {
                StoreChat.InteractionState interactionState;
                Intrinsics3.checkNotNullParameter(loadingStateUpdater, "loadingStateUpdater");
                setMentionsLoadingState(loadingStateUpdater.invoke(this.mentionsLoadingState));
                if (this.mentionsLoadingState.isLoading() || this.mentionsLoadingState.isAllLoaded() || (interactionState = this.interactionState) == null || !interactionState.isAtTopIgnoringTouch() || !this.isFocused) {
                    return;
                }
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, true, false, null, 6, null));
                Observable observableM11083G = ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMentions(this.mentionLimit, this.filters.getIncludeRoles(), this.filters.getIncludeEveryone(), Long.valueOf(this.filters.getAllGuilds() ? 0L : this.filters.getGuildId()), this.loadBeforeMessageId), false, 1, null)).m11083G(WidgetUserMentions$Model$MessageLoader$tryLoad$2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11083G, "RestAPI\n            .api…messages.map(::Message) }");
                ObservableExtensionsKt.appSubscribe$default(observableM11083G, MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$5(this), new WidgetUserMentions$Model$MessageLoader$tryLoad$3(this), (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$4(this), 50, (Object) null);
            }
        }

        public Model(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<ChatListEntry> list, Set<Long> set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab) {
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            this.userId = j;
            this.channelId = j2;
            this.guild = guild;
            this.guildId = j3;
            this.channelNames = map;
            this.oldestMessageId = j4;
            this.list = list;
            this.myRoleIds = set;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
            this.animateEmojis = z3;
            this.guildName = str;
            this.selectedTab = navigationTab;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.getUserId() : j, (i & 2) != 0 ? model.getChannelId() : j2, (i & 4) != 0 ? model.getGuild() : guild, (i & 8) != 0 ? model.getGuildId() : j3, (i & 16) != 0 ? model.getChannelNames() : map, (i & 32) != 0 ? model.getOldestMessageId() : j4, (i & 64) != 0 ? model.getList() : list, (i & 128) != 0 ? model.getMyRoleIds() : set, (i & 256) != 0 ? model.getNewMessagesMarkerMessageId() : j5, (i & 512) != 0 ? model.getIsSpoilerClickAllowed() : z2, (i & 1024) != 0 ? model.animateEmojis : z3, (i & 2048) != 0 ? model.guildName : str, (i & 4096) != 0 ? model.selectedTab : navigationTab);
        }

        public final long component1() {
            return getUserId();
        }

        public final boolean component10() {
            return getIsSpoilerClickAllowed();
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final long component2() {
            return getChannelId();
        }

        public final Guild component3() {
            return getGuild();
        }

        public final long component4() {
            return getGuildId();
        }

        public final Map<Long, String> component5() {
            return getChannelNames();
        }

        public final long component6() {
            return getOldestMessageId();
        }

        public final List<ChatListEntry> component7() {
            return getList();
        }

        public final Set<Long> component8() {
            return getMyRoleIds();
        }

        public final long component9() {
            return getNewMessagesMarkerMessageId();
        }

        public final Model copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed, boolean animateEmojis, String guildName, NavigationTab selectedTab) {
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            return new Model(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, isSpoilerClickAllowed, animateEmojis, guildName, selectedTab);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return getUserId() == model.getUserId() && getChannelId() == model.getChannelId() && Intrinsics3.areEqual(getGuild(), model.getGuild()) && getGuildId() == model.getGuildId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && Intrinsics3.areEqual(getList(), model.getList()) && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed() && this.animateEmojis == model.animateEmojis && Intrinsics3.areEqual(this.guildName, model.guildName) && Intrinsics3.areEqual(this.selectedTab, model.selectedTab);
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public List<ChatListEntry> getList() {
            return this.list;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Set<Long> getMyRoleIds() {
            return this.myRoleIds;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getNewMessagesMarkerMessageId() {
            return this.newMessagesMarkerMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getOldestMessageId() {
            return this.oldestMessageId;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        public int hashCode() {
            int iM3a = (C0002b.m3a(getChannelId()) + (C0002b.m3a(getUserId()) * 31)) * 31;
            Guild guild = getGuild();
            int iM3a2 = (C0002b.m3a(getGuildId()) + ((iM3a + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iM3a3 = (C0002b.m3a(getOldestMessageId()) + ((iM3a2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode = (iM3a3 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iM3a4 = (C0002b.m3a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            ?? r1 = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                r1 = 1;
            }
            int i = (iM3a4 + r1) * 31;
            boolean z2 = this.animateEmojis;
            int i2 = (i + (z2 ? 1 : z2)) * 31;
            String str = this.guildName;
            int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            NavigationTab navigationTab = this.selectedTab;
            return iHashCode2 + (navigationTab != null ? navigationTab.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(userId=");
            sbM833U.append(getUserId());
            sbM833U.append(", channelId=");
            sbM833U.append(getChannelId());
            sbM833U.append(", guild=");
            sbM833U.append(getGuild());
            sbM833U.append(", guildId=");
            sbM833U.append(getGuildId());
            sbM833U.append(", channelNames=");
            sbM833U.append(getChannelNames());
            sbM833U.append(", oldestMessageId=");
            sbM833U.append(getOldestMessageId());
            sbM833U.append(", list=");
            sbM833U.append(getList());
            sbM833U.append(", myRoleIds=");
            sbM833U.append(getMyRoleIds());
            sbM833U.append(", newMessagesMarkerMessageId=");
            sbM833U.append(getNewMessagesMarkerMessageId());
            sbM833U.append(", isSpoilerClickAllowed=");
            sbM833U.append(getIsSpoilerClickAllowed());
            sbM833U.append(", animateEmojis=");
            sbM833U.append(this.animateEmojis);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", selectedTab=");
            sbM833U.append(this.selectedTab);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, guild, j3, map, j4, list, set, j5, (i & 512) != 0 ? false : z2, z3, str, navigationTab);
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class UserMentionsAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Function1<StoreChat.InteractionState, Unit> interactionStateUpdated;
        private final boolean isEmbedded;

        /* JADX WARN: Multi-variable type inference failed */
        public UserMentionsAdapterEventHandler(boolean z2, ChannelSelector channelSelector, Function1<? super StoreChat.InteractionState, Unit> function1) {
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            Intrinsics3.checkNotNullParameter(function1, "interactionStateUpdated");
            this.isEmbedded = z2;
            this.channelSelector = channelSelector;
            this.interactionStateUpdated = function1;
        }

        private final void jumpToMessage(Message message) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            companion.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            Intrinsics3.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long j, Long l, long j2, long j3, long j4, long j5, String str) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCommandClicked(this, j, l, j2, j3, j4, j5, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
            this.interactionStateUpdated.invoke(interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, StoreChannelsSelected3.EMBED, 2, null);
            StoreStream.INSTANCE.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUrlLongClicked(this, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(actionType, "actionType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class WidgetUserMentionFilter extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserMentionFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0)};

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;
        private Model.MessageLoader.Filters filters;
        private String guildName;
        private Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated;

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final WidgetUserMentionFilter show(FragmentManager fragmentManager, String guildName, Model.MessageLoader.Filters filters, Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated) {
                Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
                Intrinsics3.checkNotNullParameter(filters, "filters");
                Intrinsics3.checkNotNullParameter(onFiltersUpdated, "onFiltersUpdated");
                WidgetUserMentionFilter widgetUserMentionFilter = new WidgetUserMentionFilter();
                WidgetUserMentionFilter.access$setOnFiltersUpdated$p(widgetUserMentionFilter, onFiltersUpdated);
                WidgetUserMentionFilter.access$setFilters$p(widgetUserMentionFilter, filters);
                WidgetUserMentionFilter.access$setGuildName$p(widgetUserMentionFilter, guildName);
                widgetUserMentionFilter.show(fragmentManager, WidgetUserMentionFilter.class.getName());
                return widgetUserMentionFilter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public WidgetUserMentionFilter() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMentions$WidgetUserMentionFilter$binding$2.INSTANCE, null, 2, null);
        }

        public static final /* synthetic */ Job access$delayedDismiss(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.delayedDismiss();
        }

        public static final /* synthetic */ WidgetUserMentionsFilterBinding access$getBinding$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.getBinding();
        }

        public static final /* synthetic */ Model.MessageLoader.Filters access$getFilters$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Model.MessageLoader.Filters filters = widgetUserMentionFilter.filters;
            if (filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            return filters;
        }

        public static final /* synthetic */ String access$getGuildName$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.guildName;
        }

        public static final /* synthetic */ Function1 access$getOnFiltersUpdated$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = widgetUserMentionFilter.onFiltersUpdated;
            if (function1 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            return function1;
        }

        public static final /* synthetic */ void access$setFilters$p(WidgetUserMentionFilter widgetUserMentionFilter, Model.MessageLoader.Filters filters) {
            widgetUserMentionFilter.filters = filters;
        }

        public static final /* synthetic */ void access$setGuildName$p(WidgetUserMentionFilter widgetUserMentionFilter, String str) {
            widgetUserMentionFilter.guildName = str;
        }

        public static final /* synthetic */ void access$setOnFiltersUpdated$p(WidgetUserMentionFilter widgetUserMentionFilter, Function1 function1) {
            widgetUserMentionFilter.onFiltersUpdated = function1;
        }

        public static final /* synthetic */ void access$updateFilters(WidgetUserMentionFilter widgetUserMentionFilter, Model.MessageLoader.Filters filters) {
            widgetUserMentionFilter.updateFilters(filters);
        }

        private final Job delayedDismiss() {
            CoroutineScope coroutineScope;
            View view = getView();
            if (view == null || (coroutineScope = ViewCoroutineScope.getCoroutineScope(view)) == null) {
                return null;
            }
            return C3404f.m4211H0(coroutineScope, null, null, new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this, null), 3, null);
        }

        private final WidgetUserMentionsFilterBinding getBinding() {
            return (WidgetUserMentionsFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final void updateFilters(Model.MessageLoader.Filters filters) {
            this.filters = filters;
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = this.onFiltersUpdated;
            if (function1 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            function1.invoke(filters);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return C5419R.layout.widget_user_mentions_filter;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onPause() {
            dismissAllowingStateLoss();
            super.onPause();
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            CheckedSetting checkedSetting = getBinding().f18339d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterThisServer");
            if (this.filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting.setChecked(!r2.getAllGuilds());
            String str = this.guildName;
            if (str == null || StringsJVM.isBlank(str)) {
                CheckedSetting checkedSetting2 = getBinding().f18339d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.userMentionsFilterThisServer");
                checkedSetting2.setVisibility(8);
            } else {
                CheckedSetting checkedSetting3 = getBinding().f18339d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.userMentionsFilterThisServer");
                checkedSetting3.setVisibility(0);
                CheckedSetting checkedSetting4 = getBinding().f18339d;
                Context context = getContext();
                checkedSetting4.setText(context != null ? FormatUtils.m216h(context, C5419R.string.this_server_named, new Object[]{this.guildName}, null, 4) : null);
                getBinding().f18339d.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$1(this));
            }
            CheckedSetting checkedSetting5 = getBinding().f18337b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.userMentionsFilterIncludeEveryone");
            Model.MessageLoader.Filters filters = this.filters;
            if (filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting5.setChecked(filters.getIncludeEveryone());
            getBinding().f18337b.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$2(this));
            CheckedSetting checkedSetting6 = getBinding().f18338c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.userMentionsFilterIncludeRoles");
            Model.MessageLoader.Filters filters2 = this.filters;
            if (filters2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting6.setChecked(filters2.getIncludeRoles());
            getBinding().f18338c.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$3(this));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$configureToolbar$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class C102101<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ String $guildName;

        /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$configureToolbar$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Model.MessageLoader.Filters, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Model.MessageLoader.Filters filters) {
                invoke2(filters);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Model.MessageLoader.Filters filters) {
                Intrinsics3.checkNotNullParameter(filters, "filters");
                WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this).setFilters(filters);
            }
        }

        public C102101(String str) {
            this.$guildName = str;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() == C5419R.id.menu_user_mentions_filter) {
                WidgetUserMentionFilter.Companion companion = WidgetUserMentionFilter.INSTANCE;
                FragmentManager parentFragmentManager = WidgetUserMentions.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, this.$guildName, WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this).getFilters(), new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$observeModel$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class C102111<T, R> implements Func1<NavigationTab, Observable<? extends Model>> {
        public C102111() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Model> call(NavigationTab navigationTab) {
            return call2(navigationTab);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Model> call2(NavigationTab navigationTab) {
            if (navigationTab == NavigationTab.MENTIONS) {
                return Model.INSTANCE.get(WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this), navigationTab);
            }
            Model.Companion companion = Model.INSTANCE;
            Model.MessageLoader messageLoaderAccess$getMentionsLoader$p = WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this);
            Intrinsics3.checkNotNullExpressionValue(navigationTab, "selectedTab");
            return companion.get(messageLoaderAccess$getMentionsLoader$p, navigationTab).m11100Z(1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class ViewOnClickListenerC102121 implements View.OnClickListener {
        public ViewOnClickListenerC102121() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserMentions.access$getDismissViewModel$p(WidgetUserMentions.this).dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final /* synthetic */ class C102132 extends FunctionReferenceImpl implements Function1<StoreChat.InteractionState, Unit> {
        public C102132(Model.MessageLoader messageLoader) {
            super(1, messageLoader, Model.MessageLoader.class, "setInteractionState", "setInteractionState(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "p1");
            ((Model.MessageLoader) this.receiver).setInteractionState(interactionState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class C102141 extends Lambda implements Function1<Model, Unit> {
        public C102141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetUserMentions.access$configureUI(WidgetUserMentions.this, model);
        }
    }

    public WidgetUserMentions() {
        super(C5419R.layout.widget_user_mentions);
        this.isEmbedded = FragmentExtensions.booleanExtra$default(this, EXTRA_IS_EMBEDDED, false, 2, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMentions$binding$2.INSTANCE, null, 2, null);
        this.mentionsLoader = new Model.MessageLoader(1000L);
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetUserMentions$$special$$inlined$activityViewModels$1(this), new WidgetUserMentions$$special$$inlined$activityViewModels$2(this));
        WidgetUserMentions$viewModel$2 widgetUserMentions$viewModel$2 = WidgetUserMentions$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserMentionsViewModel.class), new WidgetUserMentions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserMentions$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMentions widgetUserMentions, Model model) {
        widgetUserMentions.configureUI(model);
    }

    public static final /* synthetic */ WidgetGlobalSearchDismissModel access$getDismissViewModel$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.getDismissViewModel();
    }

    public static final /* synthetic */ Model.MessageLoader access$getMentionsLoader$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.mentionsLoader;
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f18335c.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureToolbar(String guildName) {
        AppFragment.bindToolbar$default(this, null, 1, null);
        String string = this.mentionsLoader.getFilters().getAllGuilds() ? getString(C5419R.string.all_servers) : guildName;
        if (isEmbedded()) {
            setActionBarTitle(string);
        } else {
            setActionBarSubtitle(string);
        }
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_user_mentions, new C102101(guildName), null, 4, null);
    }

    private final void configureUI(Model model) {
        boolean allGuilds = model.getGuildId() > 0 ? this.mentionsLoader.getFilters().getAllGuilds() : true;
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
        Model.MessageLoader messageLoader = this.mentionsLoader;
        messageLoader.setFilters(Model.MessageLoader.Filters.copy$default(messageLoader.getFilters(), model.getGuildId(), allGuilds, false, false, 12, null));
        this.mentionsLoader.setIsFocused(model.getSelectedTab() == NavigationTab.MENTIONS);
        if (isEmbedded() || isOnMentionsTab()) {
            configureToolbar(model.getGuildName());
        }
        getViewModel().setModel$app_productionGoogleRelease(model);
    }

    private final WidgetChatListAdapter createAdapter(Function1<? super StoreChat.InteractionState, Unit> onInteractionStateUpdated) {
        RecyclerView recyclerView = getBinding().f18335c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userMentionsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new UserMentionsAdapterEventHandler(isEmbedded(), ChannelSelector.INSTANCE.getInstance(), onInteractionStateUpdated), null, null, 48, null);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        return widgetChatListAdapter;
    }

    private final WidgetUserMentionsBinding getBinding() {
        return (WidgetUserMentionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetUserMentionsViewModel getViewModel() {
        return (WidgetUserMentionsViewModel) this.viewModel.getValue();
    }

    private final boolean isEmbedded() {
        return ((Boolean) this.isEmbedded.getValue()).booleanValue();
    }

    private final boolean isOnMentionsTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.MENTIONS;
    }

    private final Observable<Model> observeModel() {
        if (isEmbedded()) {
            return Model.INSTANCE.get(this.mentionsLoader, NavigationTab.MENTIONS);
        }
        Observable observableM11099Y = StoreStream.INSTANCE.getTabsNavigation().observeSelectedTab().m11099Y(new C102111());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getTabsNavig…          }\n            }");
        return observableM11099Y;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        Model model$app_productionGoogleRelease = getViewModel().getModel();
        if (model$app_productionGoogleRelease != null) {
            configureToolbar(model$app_productionGoogleRelease.getGuildName());
        }
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        LinearLayoutManager layoutManager;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (isEmbedded()) {
            onTabSelected();
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            getBinding().f18334b.setNavigationOnClickListener(new ViewOnClickListenerC102121());
        } else {
            setActionBarTitle(C5419R.string.recent_mentions);
        }
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) MGRecyclerAdapter.INSTANCE.configure(createAdapter(new C102132(this.mentionsLoader)));
        this.mentionsAdapter = widgetChatListAdapter;
        if (widgetChatListAdapter != null && (layoutManager = widgetChatListAdapter.getLayoutManager()) != null) {
            layoutManager.setSmoothScrollbarEnabled(true);
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.mentionsAdapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.setMentionMeMessageLevelHighlighting(false);
        }
        Fragment parentFragment = getParentFragment();
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) (parentFragment instanceof WidgetTabsHost ? parentFragment : null);
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.MENTIONS, this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeModel()), this, null, 2, null), WidgetUserMentions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C102141(), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        Model.MessageLoader.tryLoad$default(this.mentionsLoader, null, 1, null);
    }
}
