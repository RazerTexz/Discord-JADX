package com.discord.utilities.channel;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.Dispatcher;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: ChannelSelector.kt */
/* loaded from: classes2.dex */
public final class ChannelSelector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ChannelSelector INSTANCE;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreStream stream;

    /* compiled from: ChannelSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSelector getInstance() {
            ChannelSelector channelSelectorAccess$getINSTANCE$cp = ChannelSelector.access$getINSTANCE$cp();
            if (channelSelectorAccess$getINSTANCE$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return channelSelectorAccess$getINSTANCE$cp;
        }

        public final void init(StoreStream stream, Dispatcher dispatcher, ObservationDeck observationDeck) {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            ChannelSelector.access$setINSTANCE$cp(new ChannelSelector(stream, dispatcher, observationDeck));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$dismissCreateThread$1 */
    public static final class C67181 extends Lambda implements Function0<Unit> {
        public C67181() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getChannelsSelected().dismissCreateThread();
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$1 */
    public static final class C67191 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67191(long j, Context context) {
            super(0);
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            Context context = this.$context;
            if (context != null) {
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
                String string = context.getString(C5419R.string.inaccessible_channel_link_title);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…sible_channel_link_title)");
                accessibilityUtils.sendAnnouncement(context, string);
            }
            return null;
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$2 */
    public static final class C67202<T, R> implements Func1<Channel, Boolean> {
        public static final C67202 INSTANCE = new C67202();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel != null);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$3 */
    public static final class C67213 extends Lambda implements Function1<Channel, Unit> {
        public C67213() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            ChannelSelector.selectChannel$default(ChannelSelector.this, channel, null, null, 6, null);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetDirectMessage$1 */
    public static final class C67221 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67221(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.findAndSet(this.$context, channel.getId());
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1 */
    public static final class C67231 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* compiled from: ChannelSelector.kt */
        /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Channel channel) {
                super(0);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChannelSelector.this.getStream().handleThreadCreateOrUpdate(this.$channel);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67231(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.getDispatcher().schedule(new AnonymousClass1(channel));
            ChannelSelector.this.findAndSet(this.$context, this.$channelId);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$gotoChannel$1 */
    public static final class C67241 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67241(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().handleGuildSelected(this.$guildId);
            ChannelSelector.this.getStream().getChannelsSelected().trySelectChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$openCreateThread$1 */
    public static final class C67251 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $parentMessageId;
        public final /* synthetic */ String $startThreadLocation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67251(long j, long j2, Long l, String str) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$parentMessageId = l;
            this.$startThreadLocation = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getThreadDraft().clearDraftState();
            ChannelSelector.this.getStream().getChannelsSelected().openCreateThread(this.$guildId, this.$channelId, this.$parentMessageId, this.$startThreadLocation);
            AnalyticsTracker.INSTANCE.threadCreationStarted(this.$channelId, this.$guildId, this.$startThreadLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$1 */
    public static final class C67261 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67261(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            return null;
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$2 */
    public static final class C67272 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WeakReference $fragmentManagerRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67272(WeakReference weakReference, long j) {
            super(1);
            this.$fragmentManagerRef = weakReference;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            FragmentManager fragmentManager = (FragmentManager) this.$fragmentManagerRef.get();
            if (fragmentManager != null) {
                Intrinsics3.checkNotNullExpressionValue(fragmentManager, "fragmentManagerRef.get() ?: return@appSubscribe");
                StoreStream.INSTANCE.getGuildSelected().set(channel.getGuildId());
                WidgetVoiceBottomSheet.INSTANCE.show(fragmentManager, this.$channelId, true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$1 */
    public static final class C67281 extends Lambda implements Function1 {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67281(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Void) obj);
            return Unit.f27425a;
        }

        public final void invoke(Void r8) {
            ChannelSelector.access$gotoChannel(ChannelSelector.this, this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$2 */
    public static final class C67292 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67292(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Channel channel) {
            boolean z2;
            if (!TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (!ChannelUtils.m7675J(channel)) {
                    Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                    z2 = ChannelUtils.m7669D(channel);
                }
            }
            ChannelSelector.access$gotoChannel(ChannelSelector.this, this.$guildId, z2 ? this.$guildId : this.$channelId, this.$peekParent, this.$analyticsLocation);
            if (z2) {
                ChannelSelector.this.getStream().getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            }
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$1 */
    public static final class C67301<T, R> implements Func1<Long, Observable<? extends Channel>> {
        public C67301() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Long l) {
            StoreChannels channels = ChannelSelector.this.getStream().getChannels();
            Intrinsics3.checkNotNullExpressionValue(l, "previousChannelId");
            return channels.observeChannel(l.longValue());
        }
    }

    /* compiled from: ChannelSelector.kt */
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$2 */
    public static final class C67312 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67312(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            long id2 = 0;
            if (channel != null && !ChannelUtils.m7675J(channel) && channel.getId() >= 0) {
                id2 = channel.getId();
            }
            ChannelSelector.selectChannel$default(ChannelSelector.this, this.$guildId, id2, null, null, 12, null);
        }
    }

    public ChannelSelector(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ ChannelSelector access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$gotoChannel(ChannelSelector channelSelector, long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
        channelSelector.gotoChannel(j, j2, l, storeChannelsSelected3);
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ChannelSelector channelSelector) {
        INSTANCE = channelSelector;
    }

    public static /* synthetic */ void findAndSetDirectMessage$default(ChannelSelector channelSelector, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        channelSelector.findAndSetDirectMessage(context, j);
    }

    public static final ChannelSelector getInstance() {
        return INSTANCE.getInstance();
    }

    private final void gotoChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        this.dispatcher.schedule(new C67241(guildId, channelId, peekParent, analyticsLocation));
    }

    public static /* synthetic */ void openCreateThread$default(ChannelSelector channelSelector, long j, long j2, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        channelSelector.openCreateThread(j, j2, l, str);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, Channel channel, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            storeChannelsSelected3 = null;
        }
        channelSelector.selectChannel(channel, l, storeChannelsSelected3);
    }

    public final void dismissCreateThread() {
        this.dispatcher.schedule(new C67181());
    }

    public final void findAndSet(Context context, long channelId) {
        if (channelId <= 0) {
            return;
        }
        Observable observableM11118y = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new C67191(channelId, context), 14, null).m11118y(C67202.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "observationDeck\n        …   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, true, 1, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67213(), 62, (Object) null);
    }

    public final void findAndSetDirectMessage(Context context, long userId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (userId <= 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().createOrFetchDM(userId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67221(context), 60, (Object) null);
    }

    public final void findAndSetThread(Context context, long channelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().getChannel(channelId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67231(context, channelId), 60, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String startThreadLocation) {
        this.dispatcher.schedule(new C67251(guildId, channelId, parentMessageId, startThreadLocation));
    }

    public final void previewVoiceChannel(FragmentManager fragmentManager, long channelId) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        WeakReference weakReference = new WeakReference(fragmentManager);
        Observable observableM11083G = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new C67261(channelId), 14, null).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67272(weakReference, channelId), 62, (Object) null);
    }

    public final void selectChannel(Channel channel, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        if (channel != null) {
            selectChannel(channel.getGuildId(), channel.getId(), peekParent, analyticsLocation);
        }
    }

    public final void selectPreviousChannel(long guildId) {
        Observable<R> observableM11099Y = this.stream.getChannelsSelected().observePreviousId().m11099Y(new C67301());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "stream.channelsSelected.…nnel(previousChannelId) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67312(guildId), 62, (Object) null);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        channelSelector.selectChannel(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : storeChannelsSelected3);
    }

    public final void selectChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        StoreNavigation.setNavigationPanelAction$default(this.stream.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        if (guildId == 0 || channelId == 0) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(scalarSynchronousObservable), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67281(guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        } else {
            Observable<R> observableM11083G = this.stream.getChannels().observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67292(guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        }
    }
}
