package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreState currentStoreState;
    private final long guildId;
    private final boolean hideAnnouncementChannels;
    private String searchQuery;
    private final long selectedChannelId;

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel = WidgetChannelPickerBottomSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetChannelPickerBottomSheetViewModel.access$handleStoreState(widgetChannelPickerBottomSheetViewModel, storeState);
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, boolean z2) {
            return companion.observeStoreState(j, observationDeck, storeChannels, z2);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels, boolean hideAnnouncementChannels) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels}, false, null, null, new WidgetChannelPickerBottomSheetViewModel2(storeChannels, guildId, hideAnnouncementChannels), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final List<Channel> channels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Channel> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "channels");
                this.channels = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.channels;
                }
                return loaded.copy(list);
            }

            public final List<Channel> component1() {
                return this.channels;
            }

            public final Loaded copy(List<Channel> channels) {
                Intrinsics3.checkNotNullParameter(channels, "channels");
                return new Loaded(channels);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.channels, ((Loaded) other).channels);
                }
                return true;
            }

            public final List<Channel> getChannels() {
                return this.channels;
            }

            public int hashCode() {
                List<Channel> list = this.channels;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(channels="), this.channels, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<WidgetChannelPickerAdapter> adapterItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends WidgetChannelPickerAdapter> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<WidgetChannelPickerAdapter> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends WidgetChannelPickerAdapter> adapterItems) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<WidgetChannelPickerAdapter> getAdapterItems() {
                return this.adapterItems;
            }

            public int hashCode() {
                List<WidgetChannelPickerAdapter> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 8) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        this(j, j2, z2, observationDeck2, channels, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, channels, z2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel, StoreState storeState) {
        widgetChannelPickerBottomSheetViewModel.handleStoreState(storeState);
    }

    private final List<WidgetChannelPickerAdapter> buildChannelItemList(List<Channel> channels) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(WidgetChannelPickerAdapter.CreateChannelItem.INSTANCE);
        for (Channel channel : channels) {
            if (StringsJVM.isBlank(this.searchQuery) || Strings4.contains$default((CharSequence) ChannelUtils.c(channel), (CharSequence) this.searchQuery, false, 2, (Object) null)) {
                arrayList.add(new WidgetChannelPickerAdapter.ChannelItem(channel, channel.getId() == this.selectedChannelId));
            }
        }
        return arrayList;
    }

    private final ViewState generateViewState(StoreState storeState) {
        if (storeState instanceof StoreState.Invalid) {
            return ViewState.Loading.INSTANCE;
        }
        if (storeState instanceof StoreState.Loaded) {
            return new ViewState.Loaded(buildChannelItemList(((StoreState.Loaded) storeState).getChannels()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        updateViewState(generateViewState(storeState));
    }

    public final void updateSearchQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        if (Intrinsics3.areEqual(query, this.searchQuery)) {
            return;
        }
        this.searchQuery = query;
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.selectedChannelId = j2;
        this.hideAnnouncementChannels = z2;
        this.searchQuery = "";
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
