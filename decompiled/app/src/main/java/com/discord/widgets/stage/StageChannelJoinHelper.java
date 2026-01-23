package com.discord.widgets.stage;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.RxCoroutineUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.GuildVideoAtCapacityDialog;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p584w.p586i.p587a.boxing;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p659s.p660a.CancellableContinuationImpl5;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper {
    public static final StageChannelJoinHelper INSTANCE = new StageChannelJoinHelper();
    private static Job lurkJob;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 1;
            iArr[VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING.ordinal()] = 2;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_FULL.ordinal()] = 3;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST.ordinal()] = 4;
            iArr[VoiceChannelJoinabilityUtils2.CAN_JOIN.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100041 extends Lambda implements Function0<Unit> {
        public static final C100041 INSTANCE = new C100041();

        public C100041() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100052 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ Function0 $onCompleted;
        public final /* synthetic */ StoreUserRelationships $userRelationshipsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
        public final /* synthetic */ StoreVoiceStates $voiceStatesStore;
        public final /* synthetic */ boolean $warnedAboutBlockedUsers;

        /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreVoiceChannelSelected.JoinVoiceChannelResult, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                invoke2(joinVoiceChannelResult);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                Intrinsics3.checkNotNullParameter(joinVoiceChannelResult, "it");
                C100052 c100052 = C100052.this;
                if (c100052.$launchFullscreen) {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, c100052.$context, c100052.$channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
                }
                C100052.this.$onCompleted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100052(StoreChannels storeChannels, long j, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, boolean z2, StoreVoiceChannelSelected storeVoiceChannelSelected, FragmentManager fragmentManager, boolean z3, Function0 function0, Context context) {
            super(0);
            this.$channelsStore = storeChannels;
            this.$channelId = j;
            this.$voiceStatesStore = storeVoiceStates;
            this.$userRelationshipsStore = storeUserRelationships;
            this.$warnedAboutBlockedUsers = z2;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$fragmentManager = fragmentManager;
            this.$launchFullscreen = z3;
            this.$onCompleted = function0;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2() {
            boolean z2;
            Object next;
            Channel channel = this.$channelsStore.getChannel(this.$channelId);
            if (channel != null) {
                Map mapEmptyMap = (Map) outline.m843c(channel, this.$voiceStatesStore.get());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                Sequence map = _Sequences2.map(_Sequences2.filter(_Collections.asSequence(mapEmptyMap.values()), new StageChannelJoinHelper2(channel)), StageChannelJoinHelper3.INSTANCE);
                Map<Long, Integer> relationships = this.$userRelationshipsStore.getRelationships();
                if (!this.$warnedAboutBlockedUsers) {
                    Iterator it = map.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        Integer num = relationships.get(Long.valueOf(((Number) next).longValue()));
                        if (num != null && num.intValue() == 2) {
                            break;
                        }
                    }
                    z2 = (next == null || this.$voiceChannelSelectedStore.getSelectedVoiceChannelId() == this.$channelId) ? false : true;
                }
                if (!z2) {
                    ObservableExtensionsKt.appSubscribe$default(this.$voiceChannelSelectedStore.selectVoiceChannel(this.$channelId), StageChannelJoinHelper.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
                } else {
                    WidgetStageAudienceBlockedBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channelId, this.$launchFullscreen);
                    this.$onCompleted.invoke();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1", m10085f = "StageChannelJoinHelper.kt", m10086l = {123}, m10087m = "invokeSuspend")
    public static final class C100081 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ StoreLurking $lurkingStore;
        public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100081(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$guildId = j;
            this.$channelId = j2;
            this.$launchFullscreen = z2;
            this.$guildsStore = storeGuilds;
            this.$lurkingStore = storeLurking;
            this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C100081(this.$context, this.$fragmentManager, this.$guildId, this.$channelId, this.$launchFullscreen, this.$guildsStore, this.$lurkingStore, this.$selectedVoiceChannelStore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C100081) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context context = this.$context;
                FragmentManager fragmentManager = this.$fragmentManager;
                long j = this.$guildId;
                long j2 = this.$channelId;
                boolean z2 = this.$launchFullscreen;
                StoreGuilds storeGuilds = this.$guildsStore;
                StoreLurking storeLurking = this.$lurkingStore;
                StoreVoiceChannelSelected storeVoiceChannelSelected = this.$selectedVoiceChannelStore;
                this.label = 1;
                if (stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, z2, storeGuilds, storeLurking, storeVoiceChannelSelected, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.stage.StageChannelJoinHelper", m10085f = "StageChannelJoinHelper.kt", m10086l = {180, Opcodes.IF_ICMPEQ, Opcodes.IF_ACMPNE}, m10087m = "lurkAndJoinStageAsync")
    public static final class C100091 extends ContinuationImpl3 {
        public long J$0;
        public long J$1;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C100091(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StageChannelJoinHelper.this.lurkAndJoinStageAsync(null, null, 0L, 0L, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$3 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100103<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $guildId;

        public C100103(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$4 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100114<T, R> implements Func1<Channel, Boolean> {
        public static final C100114 INSTANCE = new C100114();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel == null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$5 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100125 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreLurking $lurkingStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100125(StoreLurking storeLurking, long j) {
            super(0);
            this.$lurkingStore = storeLurking;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lurkingStore.removeOldLurkingGuilds(this.$guildId);
        }
    }

    private StageChannelJoinHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connectToStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, boolean z2, boolean z3, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, Function0 function0, int i, Object obj) {
        stageChannelJoinHelper.connectToStage(context, fragmentManager, j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 256) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 512) != 0 ? C100041.INSTANCE : function0);
    }

    public static /* synthetic */ void lurkAndJoinStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, int i, Object obj) {
        stageChannelJoinHelper.lurkAndJoinStage(context, fragmentManager, coroutineScope, j, j2, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 256) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected);
    }

    public static /* synthetic */ Object lurkAndJoinStageAsync$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation, int i, Object obj) {
        return stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 128) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, continuation);
    }

    @MainThread
    public final void connectToStage(Context context, FragmentManager fragmentManager, long channelId, boolean warnedAboutBlockedUsers, boolean launchFullscreen, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreChannels channelsStore, StoreVoiceStates voiceStatesStore, StoreUserRelationships userRelationshipsStore, Function0<Unit> onCompleted) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
        Intrinsics3.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        Intrinsics3.checkNotNullParameter(userRelationshipsStore, "userRelationshipsStore");
        Intrinsics3.checkNotNullParameter(onCompleted, "onCompleted");
        verifyStageJoinability(context, fragmentManager, channelId, new C100052(channelsStore, channelId, voiceStatesStore, userRelationshipsStore, warnedAboutBlockedUsers, voiceChannelSelectedStore, fragmentManager, launchFullscreen, onCompleted, context));
    }

    @MainThread
    public final void lurkAndJoinStage(Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long guildId, long channelId, boolean launchFullscreen, StoreGuilds guildsStore, StoreLurking lurkingStore, StoreVoiceChannelSelected selectedVoiceChannelStore) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
        Intrinsics3.checkNotNullParameter(lurkingStore, "lurkingStore");
        Intrinsics3.checkNotNullParameter(selectedVoiceChannelStore, "selectedVoiceChannelStore");
        Job job = lurkJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        lurkJob = coroutineScope != null ? C3404f.m4211H0(coroutineScope, null, null, new C100081(context, fragmentManager, guildId, channelId, launchFullscreen, guildsStore, lurkingStore, selectedVoiceChannelStore, null), 3, null) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object lurkAndJoinStageAsync(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation<? super Boolean> continuation) {
        C100091 c100091;
        FragmentManager fragmentManager2;
        StoreGuilds storeGuilds2;
        StoreLurking storeLurking2;
        long j3;
        long j4;
        StageChannelJoinHelper stageChannelJoinHelper;
        Object obj;
        StoreVoiceChannelSelected storeVoiceChannelSelected2;
        Context context2;
        boolean z3;
        StoreLurking storeLurking3;
        Context context3;
        StoreVoiceChannelSelected storeVoiceChannelSelected3;
        StageChannelJoinHelper stageChannelJoinHelper2;
        FragmentManager fragmentManager3;
        boolean z4;
        Observable<Channel> observableM11119z;
        boolean z5;
        StageChannelJoinHelper stageChannelJoinHelper3;
        long j5;
        long j6;
        StoreLurking storeLurking4;
        FragmentManager fragmentManager4;
        Context context4;
        if (continuation instanceof C100091) {
            c100091 = (C100091) continuation;
            int i = c100091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c100091.label = i - Integer.MIN_VALUE;
            } else {
                c100091 = new C100091(continuation);
            }
        }
        Object obj2 = c100091.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c100091.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj2);
            storeVoiceChannelSelected.clear();
            c100091.L$0 = this;
            c100091.L$1 = context;
            fragmentManager2 = fragmentManager;
            c100091.L$2 = fragmentManager2;
            storeGuilds2 = storeGuilds;
            c100091.L$3 = storeGuilds2;
            storeLurking2 = storeLurking;
            c100091.L$4 = storeLurking2;
            c100091.L$5 = storeVoiceChannelSelected;
            c100091.J$0 = j;
            c100091.J$1 = j2;
            c100091.Z$0 = z2;
            c100091.label = 1;
            CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(c100091), 1);
            cancellableContinuationImpl5.m11318A();
            storeLurking.startLurking(j, boxing.boxLong(j2), false, new StageChannelJoinHelper4(cancellableContinuationImpl5), new StageChannelJoinHelper5(cancellableContinuationImpl5));
            Object objM11326u = cancellableContinuationImpl5.m11326u();
            if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(c100091);
            }
            if (objM11326u == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = j;
            j4 = j2;
            stageChannelJoinHelper = this;
            obj = objM11326u;
            storeVoiceChannelSelected2 = storeVoiceChannelSelected;
            context2 = context;
            z3 = z2;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z6 = c100091.Z$0;
                    long j7 = c100091.J$1;
                    j6 = c100091.J$0;
                    storeLurking4 = (StoreLurking) c100091.L$3;
                    FragmentManager fragmentManager5 = (FragmentManager) c100091.L$2;
                    Context context5 = (Context) c100091.L$1;
                    StageChannelJoinHelper stageChannelJoinHelper4 = (StageChannelJoinHelper) c100091.L$0;
                    Result3.throwOnFailure(obj2);
                    stageChannelJoinHelper3 = stageChannelJoinHelper4;
                    z5 = z6;
                    j5 = j7;
                    fragmentManager4 = fragmentManager5;
                    context4 = context5;
                    connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new C100125(storeLurking4, j6), 488, null);
                    return boxing.boxBoolean(true);
                }
                z4 = c100091.Z$0;
                j4 = c100091.J$1;
                j3 = c100091.J$0;
                storeVoiceChannelSelected3 = (StoreVoiceChannelSelected) c100091.L$4;
                storeLurking3 = (StoreLurking) c100091.L$3;
                fragmentManager3 = (FragmentManager) c100091.L$2;
                context3 = (Context) c100091.L$1;
                stageChannelJoinHelper2 = (StageChannelJoinHelper) c100091.L$0;
                Result3.throwOnFailure(obj2);
                observableM11119z = storeVoiceChannelSelected3.observeSelectedChannel().m11118y(C100114.INSTANCE).m11119z();
                Intrinsics3.checkNotNullExpressionValue(observableM11119z, "selectedVoiceChannelStor…= null }\n        .first()");
                c100091.L$0 = stageChannelJoinHelper2;
                c100091.L$1 = context3;
                c100091.L$2 = fragmentManager3;
                c100091.L$3 = storeLurking3;
                c100091.L$4 = null;
                c100091.J$0 = j3;
                c100091.J$1 = j4;
                c100091.Z$0 = z4;
                c100091.label = 3;
                if (RxCoroutineUtils.awaitSingle(observableM11119z, c100091) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                z5 = z4;
                stageChannelJoinHelper3 = stageChannelJoinHelper2;
                j5 = j4;
                j6 = j3;
                storeLurking4 = storeLurking3;
                fragmentManager4 = fragmentManager3;
                context4 = context3;
                connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new C100125(storeLurking4, j6), 488, null);
                return boxing.boxBoolean(true);
            }
            boolean z7 = c100091.Z$0;
            j4 = c100091.J$1;
            j3 = c100091.J$0;
            StoreVoiceChannelSelected storeVoiceChannelSelected4 = (StoreVoiceChannelSelected) c100091.L$5;
            StoreLurking storeLurking5 = (StoreLurking) c100091.L$4;
            StoreGuilds storeGuilds3 = (StoreGuilds) c100091.L$3;
            FragmentManager fragmentManager6 = (FragmentManager) c100091.L$2;
            context2 = (Context) c100091.L$1;
            StageChannelJoinHelper stageChannelJoinHelper5 = (StageChannelJoinHelper) c100091.L$0;
            Result3.throwOnFailure(obj2);
            storeVoiceChannelSelected2 = storeVoiceChannelSelected4;
            storeLurking2 = storeLurking5;
            obj = obj2;
            z3 = z7;
            fragmentManager2 = fragmentManager6;
            stageChannelJoinHelper = stageChannelJoinHelper5;
            storeGuilds2 = storeGuilds3;
        }
        if (((Unit) obj) == null) {
            return boxing.boxBoolean(false);
        }
        Observable<Set<Long>> observableM11119z2 = storeGuilds2.observeGuildIds().m11118y(new C100103(j3)).m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z2, "guildsStore\n        .obs…in ids }\n        .first()");
        c100091.L$0 = stageChannelJoinHelper;
        c100091.L$1 = context2;
        c100091.L$2 = fragmentManager2;
        c100091.L$3 = storeLurking2;
        c100091.L$4 = storeVoiceChannelSelected2;
        c100091.L$5 = null;
        c100091.J$0 = j3;
        c100091.J$1 = j4;
        c100091.Z$0 = z3;
        c100091.label = 2;
        if (RxCoroutineUtils.awaitSingle(observableM11119z2, c100091) == coroutine_suspended) {
            return coroutine_suspended;
        }
        storeLurking3 = storeLurking2;
        context3 = context2;
        storeVoiceChannelSelected3 = storeVoiceChannelSelected2;
        stageChannelJoinHelper2 = stageChannelJoinHelper;
        fragmentManager3 = fragmentManager2;
        z4 = z3;
        observableM11119z = storeVoiceChannelSelected3.observeSelectedChannel().m11118y(C100114.INSTANCE).m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z, "selectedVoiceChannelStor…= null }\n        .first()");
        c100091.L$0 = stageChannelJoinHelper2;
        c100091.L$1 = context3;
        c100091.L$2 = fragmentManager3;
        c100091.L$3 = storeLurking3;
        c100091.L$4 = null;
        c100091.J$0 = j3;
        c100091.J$1 = j4;
        c100091.Z$0 = z4;
        c100091.label = 3;
        if (RxCoroutineUtils.awaitSingle(observableM11119z, c100091) != coroutine_suspended) {
        }
    }

    @MainThread
    public final void verifyStageJoinability(Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onJoinVerified) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onJoinVerified, "onJoinVerified");
        int iOrdinal = VoiceChannelJoinabilityUtils.INSTANCE.getJoinability(channelId).ordinal();
        if (iOrdinal == 0) {
            onJoinVerified.invoke();
            return;
        }
        if (iOrdinal == 1) {
            AppToast.m169g(context, C5419R.string.channel_locked, 0, null, 12);
            return;
        }
        if (iOrdinal == 2) {
            GuildVideoAtCapacityDialog.INSTANCE.m140a(fragmentManager);
        } else if (iOrdinal == 3) {
            AppToast.m169g(context, C5419R.string.unable_to_join_channel_full, 0, null, 12);
        } else {
            if (iOrdinal != 4) {
                return;
            }
            AppToast.m169g(context, C5419R.string.guild_settings_public_welcome_invalid_channel, 0, null, 12);
        }
    }
}
