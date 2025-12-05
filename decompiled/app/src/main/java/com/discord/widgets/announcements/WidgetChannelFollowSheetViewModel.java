package com.discord.widgets.announcements;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func5;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetChannelFollowSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel extends AppViewModel<ViewState> implements AppComponent {
    private final PublishSubject<Event> eventSubject;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Long> selectedGuildSubject;
    private final long sourceChannelId;
    private final long sourceGuildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$1 */
    public static final class C71451 extends Lambda implements Function1<ViewState.Loaded, Unit> {
        public C71451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetChannelFollowSheetViewModel.access$updateViewState(WidgetChannelFollowSheetViewModel.this, loaded);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        public static final class FollowSuccess extends Event {
            public static final FollowSuccess INSTANCE = new FollowSuccess();

            private FollowSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Set<Long> availableChannels;
            private final Set<Long> availableGuilds;
            private final Integer errorTextRes;
            private final Channel selectedChannel;
            private final Guild selectedGuild;
            private final Channel sourceChannel;
            private final Guild sourceGuild;

            public /* synthetic */ Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, guild, guild2, channel2, set, set2, (i & 64) != 0 ? null : num);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.sourceChannel;
                }
                if ((i & 2) != 0) {
                    guild = loaded.sourceGuild;
                }
                Guild guild3 = guild;
                if ((i & 4) != 0) {
                    guild2 = loaded.selectedGuild;
                }
                Guild guild4 = guild2;
                if ((i & 8) != 0) {
                    channel2 = loaded.selectedChannel;
                }
                Channel channel3 = channel2;
                if ((i & 16) != 0) {
                    set = loaded.availableGuilds;
                }
                Set set3 = set;
                if ((i & 32) != 0) {
                    set2 = loaded.availableChannels;
                }
                Set set4 = set2;
                if ((i & 64) != 0) {
                    num = loaded.errorTextRes;
                }
                return loaded.copy(channel, guild3, guild4, channel3, set3, set4, num);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            /* renamed from: component3, reason: from getter */
            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            /* renamed from: component4, reason: from getter */
            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Set<Long> component5() {
                return this.availableGuilds;
            }

            public final Set<Long> component6() {
                return this.availableChannels;
            }

            /* renamed from: component7, reason: from getter */
            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Loaded copy(Channel sourceChannel, Guild sourceGuild, Guild selectedGuild, Channel selectedChannel, Set<Long> availableGuilds, Set<Long> availableChannels, Integer errorTextRes) {
                Intrinsics3.checkNotNullParameter(availableGuilds, "availableGuilds");
                Intrinsics3.checkNotNullParameter(availableChannels, "availableChannels");
                return new Loaded(sourceChannel, sourceGuild, selectedGuild, selectedChannel, availableGuilds, availableChannels, errorTextRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.sourceChannel, loaded.sourceChannel) && Intrinsics3.areEqual(this.sourceGuild, loaded.sourceGuild) && Intrinsics3.areEqual(this.selectedGuild, loaded.selectedGuild) && Intrinsics3.areEqual(this.selectedChannel, loaded.selectedChannel) && Intrinsics3.areEqual(this.availableGuilds, loaded.availableGuilds) && Intrinsics3.areEqual(this.availableChannels, loaded.availableChannels) && Intrinsics3.areEqual(this.errorTextRes, loaded.errorTextRes);
            }

            public final Set<Long> getAvailableChannels() {
                return this.availableChannels;
            }

            public final Set<Long> getAvailableGuilds() {
                return this.availableGuilds;
            }

            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            public int hashCode() {
                Channel channel = this.sourceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Guild guild = this.sourceGuild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                Guild guild2 = this.selectedGuild;
                int iHashCode3 = (iHashCode2 + (guild2 != null ? guild2.hashCode() : 0)) * 31;
                Channel channel2 = this.selectedChannel;
                int iHashCode4 = (iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                Set<Long> set = this.availableGuilds;
                int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.availableChannels;
                int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Integer num = this.errorTextRes;
                return iHashCode6 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(sourceChannel=");
                sbM833U.append(this.sourceChannel);
                sbM833U.append(", sourceGuild=");
                sbM833U.append(this.sourceGuild);
                sbM833U.append(", selectedGuild=");
                sbM833U.append(this.selectedGuild);
                sbM833U.append(", selectedChannel=");
                sbM833U.append(this.selectedChannel);
                sbM833U.append(", availableGuilds=");
                sbM833U.append(this.availableGuilds);
                sbM833U.append(", availableChannels=");
                sbM833U.append(this.availableChannels);
                sbM833U.append(", errorTextRes=");
                return outline.m818F(sbM833U, this.errorTextRes, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set<Long> set, Set<Long> set2, Integer num) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "availableGuilds");
                Intrinsics3.checkNotNullParameter(set2, "availableChannels");
                this.sourceChannel = channel;
                this.sourceGuild = guild;
                this.selectedGuild = guild2;
                this.selectedChannel = channel2;
                this.availableGuilds = set;
                this.availableChannels = set2;
                this.errorTextRes = num;
            }
        }

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
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

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1 */
    public static final class C71461<T, R> implements Func1<Map<Long, ? extends Long>, Observable<? extends Map<Long, ? extends List<? extends Channel>>>> {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Channel>>> {
            public final /* synthetic */ Map $perms;

            public AnonymousClass1(Map map) {
                this.$perms = map;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Channel>> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Map<Long, List<Channel>> call2(Map<Long, Channel> map) {
                boolean z2;
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Channel> entry : map.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    Channel value = entry.getValue();
                    if (value.getType() == 5 || value.getType() == 0) {
                        Long l = (Long) this.$perms.get(Long.valueOf(jLongValue));
                        z2 = PermissionUtils.can(Permission.MANAGE_WEBHOOKS, Long.valueOf(l != null ? l.longValue() : 0L));
                    }
                    if (z2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Collection collectionValues = linkedHashMap.values();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (T t : collectionValues) {
                    Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
                    Object arrayList = linkedHashMap2.get(lValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap2.put(lValueOf, arrayList);
                    }
                    ((List) arrayList).add(t);
                }
                return linkedHashMap2;
            }
        }

        public C71461() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends List<? extends Channel>>> call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, List<Channel>>> call2(Map<Long, Long> map) {
            return WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeGuildAndPrivateChannels().m11112r().m11083G(new AnonymousClass1(map));
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$1 */
    public static final /* synthetic */ class C71471 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public C71471(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
            super(1, widgetChannelFollowSheetViewModel, WidgetChannelFollowSheetViewModel.class, "handleChannelFollowError", "handleChannelFollowError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            WidgetChannelFollowSheetViewModel.access$handleChannelFollowError((WidgetChannelFollowSheetViewModel) this.receiver, error);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$2 */
    public static final class C71482 extends Lambda implements Function1<Void, Unit> {
        public C71482() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelFollowSheetViewModel.access$getEventSubject$p(WidgetChannelFollowSheetViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.FollowSuccess.INSTANCE);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$1 */
    public static final class C71491<T, R> implements Func1<Long, Observable<? extends Guild>> {
        public C71491() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Guild> call2(Long l) {
            if (l != null) {
                Observable<Guild> observableObserveGuild = WidgetChannelFollowSheetViewModel.this.getStoreGuilds().observeGuild(l.longValue());
                if (observableObserveGuild != null) {
                    return observableObserveGuild;
                }
            }
            return new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$2 */
    public static final class C71502<T, R> implements Func1<Long, Observable<? extends Channel>> {
        public C71502() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Long l) {
            if (l != null) {
                Observable<Channel> observableObserveChannel = WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeChannel(l.longValue());
                if (observableObserveChannel != null) {
                    return observableObserveChannel;
                }
            }
            return new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3 */
    public static final class C71513<T1, T2, T3, T4, T5, R> implements Func5<Guild, Channel, Map<Long, ? extends List<? extends Channel>>, Guild, Channel, ViewState.Loaded> {
        public static final C71513 INSTANCE = new C71513();

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ ViewState.Loaded call(Guild guild, Channel channel, Map<Long, ? extends List<? extends Channel>> map, Guild guild2, Channel channel2) {
            return call2(guild, channel, (Map<Long, ? extends List<Channel>>) map, guild2, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState.Loaded call2(Guild guild, Channel channel, Map<Long, ? extends List<Channel>> map, Guild guild2, Channel channel2) {
            Set<Long> setKeySet = map.keySet();
            List listFlatten = Iterables2.flatten(map.values());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFlatten, 10));
            Iterator it = listFlatten.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
            }
            return new ViewState.Loaded(channel, guild, guild2, channel2, setKeySet, _Collections.toSet(arrayList), null, 64, null);
        }
    }

    public /* synthetic */ WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        return widgetChannelFollowSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleChannelFollowError(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, Error error) {
        widgetChannelFollowSheetViewModel.handleChannelFollowError(error);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, ViewState viewState) {
        widgetChannelFollowSheetViewModel.updateViewState(viewState);
    }

    private final Observable<Map<Long, List<Channel>>> calculateChannelsWithPermissions() {
        return this.storePermissions.observePermissionsForAllChannels().m11112r().m11099Y(new C71461());
    }

    private final void handleChannelFollowError(Error error) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        int i = response.getCode() != 30007 ? C5419R.string.follow_modal_fail : C5419R.string.follow_modal_too_many_webhooks;
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
        updateViewState(ViewState.Loaded.copy$default((ViewState.Loaded) viewState, null, null, null, null, null, null, Integer.valueOf(i), 63, null));
    }

    private final Observable<ViewState.Loaded> observeViewStateFromStores() {
        Observable<ViewState.Loaded> observableM11072g = Observable.m11072g(this.storeGuilds.observeGuild(this.sourceGuildId), this.storeChannels.observeChannel(this.sourceChannelId), calculateChannelsWithPermissions(), this.selectedGuildSubject.m11099Y(new C71491()), this.selectedChannelSubject.m11099Y(new C71502()), C71513.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11072g, "Observable.combineLatest…  )\n\n      expected\n    }");
        return observableM11072g;
    }

    public final void followChannel(long webhookChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createChannelFollower(this.sourceChannelId, new RestAPIParams.ChannelFollowerPost(webhookChannelId)), false, 1, null), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, new C71471(this), (Function0) null, (Function0) null, new C71482(), 54, (Object) null);
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void selectGuild(long guildId) {
        this.selectedGuildSubject.onNext(Long.valueOf(guildId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        this.sourceGuildId = j;
        this.sourceChannelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.selectedGuildSubject = BehaviorSubject.m11130l0(null);
        this.selectedChannelSubject = BehaviorSubject.m11130l0(null);
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeViewStateFromStores()), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71451(), 62, (Object) null);
    }
}
