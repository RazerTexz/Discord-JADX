package com.discord.widgets.stage.sheet;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetAdapter;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel) {
            super(1, stageAudienceBlockedBottomSheetViewModel, StageAudienceBlockedBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            StageAudienceBlockedBottomSheetViewModel.access$handleStoreState((StageAudienceBlockedBottomSheetViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, StoreUserRelationships storeUserRelationships, StoreStageChannels storeStageChannels) {
            return companion.observeStores(j, storeUserRelationships, storeStageChannels);
        }

        private final Observable<StoreState> observeStores(long channelId, StoreUserRelationships userRelationshipsStore, StoreStageChannels stageStore) {
            Observable<StoreState> observableI = Observable.i(CallModel.INSTANCE.get(channelId), userRelationshipsStore.observeForType(2), stageStore.observeStageRolesByChannel(channelId), new StageAudienceBlockedBottomSheetViewModel2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest… emptyMap()\n      )\n    }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Set<Long> blockedUsers;
        private final CallModel callModel;
        private final long channelId;
        private final Map<Long, StageRoles> stageRoles;

        public StoreState(long j, CallModel callModel, Set<Long> set, Map<Long, StageRoles> map) {
            Intrinsics3.checkNotNullParameter(set, "blockedUsers");
            Intrinsics3.checkNotNullParameter(map, "stageRoles");
            this.channelId = j;
            this.callModel = callModel;
            this.blockedUsers = set;
            this.stageRoles = map;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, CallModel callModel, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                j = storeState.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                callModel = storeState.callModel;
            }
            CallModel callModel2 = callModel;
            if ((i & 4) != 0) {
                set = storeState.blockedUsers;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                map = storeState.stageRoles;
            }
            return storeState.copy(j2, callModel2, set2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final Set<Long> component3() {
            return this.blockedUsers;
        }

        public final Map<Long, StageRoles> component4() {
            return this.stageRoles;
        }

        public final StoreState copy(long channelId, CallModel callModel, Set<Long> blockedUsers, Map<Long, StageRoles> stageRoles) {
            Intrinsics3.checkNotNullParameter(blockedUsers, "blockedUsers");
            Intrinsics3.checkNotNullParameter(stageRoles, "stageRoles");
            return new StoreState(channelId, callModel, blockedUsers, stageRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.channelId == storeState.channelId && Intrinsics3.areEqual(this.callModel, storeState.callModel) && Intrinsics3.areEqual(this.blockedUsers, storeState.blockedUsers) && Intrinsics3.areEqual(this.stageRoles, storeState.stageRoles);
        }

        public final Set<Long> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, StageRoles> getStageRoles() {
            return this.stageRoles;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            CallModel callModel = this.callModel;
            int iHashCode = (iA + (callModel != null ? callModel.hashCode() : 0)) * 31;
            Set<Long> set = this.blockedUsers;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, StageRoles> map = this.stageRoles;
            return iHashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channelId=");
            sbU.append(this.channelId);
            sbU.append(", callModel=");
            sbU.append(this.callModel);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", stageRoles=");
            return outline.M(sbU, this.stageRoles, ")");
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final List<MGRecyclerDataPayload> listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Channel channel, List<? extends MGRecyclerDataPayload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(list, "listItems");
                this.channel = channel;
                this.listItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    list = loaded.listItems;
                }
                return loaded.copy(channel, list);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> component2() {
                return this.listItems;
            }

            public final Loaded copy(Channel channel, List<? extends MGRecyclerDataPayload> listItems) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                return new Loaded(channel, listItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.listItems, loaded.listItems);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> getListItems() {
                return this.listItems;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                List<MGRecyclerDataPayload> list = this.listItems;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", listItems=");
                return outline.L(sbU, this.listItems, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StageAudienceBlockedBottomSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStores(companion, j, companion2.getUserRelationships(), companion2.getStageChannels());
        }
        this(j, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel, StoreState storeState) {
        stageAudienceBlockedBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        CallModel callModel = storeState.getCallModel();
        if (callModel != null) {
            Map<Long, StoreVoiceParticipants.VoiceUser> participants = callModel.getParticipants();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = participants.entrySet().iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, StoreVoiceParticipants.VoiceUser> next = it.next();
                long jLongValue = next.getKey().longValue();
                if (next.getValue().isConnected() && storeState.getBlockedUsers().contains(Long.valueOf(jLongValue))) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                long jLongValue2 = ((Number) entry.getKey()).longValue();
                StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) entry.getValue();
                StageRoles stageRoles = storeState.getStageRoles().get(Long.valueOf(jLongValue2));
                arrayList.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Participant(voiceUser, stageRoles != null && StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())));
            }
            Channel channel = callModel.getChannel();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Header(arrayList.size()));
            arrayList2.addAll(arrayList);
            loaded = new ViewState.Loaded(channel, arrayList2);
        } else {
            loaded = ViewState.Invalid.INSTANCE;
        }
        updateViewState(loaded);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetViewModel(long j, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StageAudienceBlockedBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
