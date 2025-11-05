package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreNux.kt */
/* loaded from: classes2.dex */
public final class StoreNux extends Store {
    private final Dispatcher dispatcher;
    private NuxState nuxState;
    private final BehaviorSubject<NuxState> nuxStateSubject;

    /* compiled from: StoreNux.kt */
    public static final /* data */ class NuxState {
        private final boolean addGuildHint;
        private final boolean contactSyncCompleted;
        private final boolean firstOpen;
        private final Long guildBoostHintGuildId;
        private final boolean postRegister;
        private final boolean postRegisterWithInvite;

        public NuxState() {
            this(false, false, false, false, false, null, 63, null);
        }

        public NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l) {
            this.postRegister = z2;
            this.postRegisterWithInvite = z3;
            this.contactSyncCompleted = z4;
            this.firstOpen = z5;
            this.addGuildHint = z6;
            this.guildBoostHintGuildId = l;
        }

        public static /* synthetic */ NuxState copy$default(NuxState nuxState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = nuxState.postRegister;
            }
            if ((i & 2) != 0) {
                z3 = nuxState.postRegisterWithInvite;
            }
            boolean z7 = z3;
            if ((i & 4) != 0) {
                z4 = nuxState.contactSyncCompleted;
            }
            boolean z8 = z4;
            if ((i & 8) != 0) {
                z5 = nuxState.firstOpen;
            }
            boolean z9 = z5;
            if ((i & 16) != 0) {
                z6 = nuxState.addGuildHint;
            }
            boolean z10 = z6;
            if ((i & 32) != 0) {
                l = nuxState.guildBoostHintGuildId;
            }
            return nuxState.copy(z2, z7, z8, z9, z10, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getPostRegister() {
            return this.postRegister;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final NuxState copy(boolean postRegister, boolean postRegisterWithInvite, boolean contactSyncCompleted, boolean firstOpen, boolean addGuildHint, Long guildBoostHintGuildId) {
            return new NuxState(postRegister, postRegisterWithInvite, contactSyncCompleted, firstOpen, addGuildHint, guildBoostHintGuildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NuxState)) {
                return false;
            }
            NuxState nuxState = (NuxState) other;
            return this.postRegister == nuxState.postRegister && this.postRegisterWithInvite == nuxState.postRegisterWithInvite && this.contactSyncCompleted == nuxState.contactSyncCompleted && this.firstOpen == nuxState.firstOpen && this.addGuildHint == nuxState.addGuildHint && m.areEqual(this.guildBoostHintGuildId, nuxState.guildBoostHintGuildId);
        }

        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final boolean getPostRegister() {
            return this.postRegister;
        }

        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.postRegister;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.postRegisterWithInvite;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.contactSyncCompleted;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.firstOpen;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            boolean z3 = this.addGuildHint;
            int i8 = (i7 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Long l = this.guildBoostHintGuildId;
            return i8 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("NuxState(postRegister=");
            sbU.append(this.postRegister);
            sbU.append(", postRegisterWithInvite=");
            sbU.append(this.postRegisterWithInvite);
            sbU.append(", contactSyncCompleted=");
            sbU.append(this.contactSyncCompleted);
            sbU.append(", firstOpen=");
            sbU.append(this.firstOpen);
            sbU.append(", addGuildHint=");
            sbU.append(this.addGuildHint);
            sbU.append(", guildBoostHintGuildId=");
            return a.G(sbU, this.guildBoostHintGuildId, ")");
        }

        public /* synthetic */ NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) == 0 ? z6 : false, (i & 32) != 0 ? null : l);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$clearNux$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux.access$setNuxState$p(StoreNux.this, new NuxState(false, false, false, false, false, null, 63, null));
            StoreNux storeNux = StoreNux.this;
            StoreNux.access$publishNuxUpdated(storeNux, StoreNux.access$getNuxState$p(storeNux));
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$setContactSyncCompleted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, this.$value, false, false, null, 59, null);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$setFirstOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, this.$value, false, null, 55, null);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$setPostRegister$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, this.$value, false, false, false, false, null, 62, null);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$setPostRegisterWithInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, this.$value, false, false, false, null, 61, null);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$setPremiumGuildHintGuildId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NuxState, NuxState> {
        public final /* synthetic */ Long $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$value = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, false, false, this.$value, 31, null);
        }
    }

    /* compiled from: StoreNux.kt */
    /* renamed from: com.discord.stores.StoreNux$updateNux$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Function1 $updateFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(0);
            this.$updateFunction = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux storeNux = StoreNux.this;
            StoreNux.access$setNuxState$p(storeNux, (NuxState) this.$updateFunction.invoke(StoreNux.access$getNuxState$p(storeNux)));
            StoreNux storeNux2 = StoreNux.this;
            StoreNux.access$publishNuxUpdated(storeNux2, StoreNux.access$getNuxState$p(storeNux2));
        }
    }

    public StoreNux(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        NuxState nuxState = new NuxState(false, false, false, false, false, null, 63, null);
        this.nuxState = nuxState;
        this.nuxStateSubject = BehaviorSubject.l0(nuxState);
    }

    public static final /* synthetic */ NuxState access$getNuxState$p(StoreNux storeNux) {
        return storeNux.nuxState;
    }

    public static final /* synthetic */ void access$publishNuxUpdated(StoreNux storeNux, NuxState nuxState) {
        storeNux.publishNuxUpdated(nuxState);
    }

    public static final /* synthetic */ void access$setNuxState$p(StoreNux storeNux, NuxState nuxState) {
        storeNux.nuxState = nuxState;
    }

    private final void publishNuxUpdated(NuxState nuxState) {
        this.nuxStateSubject.onNext(nuxState);
    }

    public final void clearNux() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<NuxState> getNuxState() {
        Observable<NuxState> observableR = this.nuxStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "nuxStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleGuildSelected(long guildId) {
        Long guildBoostHintGuildId = this.nuxState.getGuildBoostHintGuildId();
        if (guildBoostHintGuildId != null && guildBoostHintGuildId.longValue() == guildId) {
            return;
        }
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, null, 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    @StoreThread
    public final void handleSamplePremiumGuildSelected(long guildId) {
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, Long.valueOf(guildId), 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    public final void setContactSyncCompleted(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setFirstOpen(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegister(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegisterWithInvite(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPremiumGuildHintGuildId(Long value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void updateNux(Function1<? super NuxState, NuxState> updateFunction) {
        m.checkNotNullParameter(updateFunction, "updateFunction");
        this.dispatcher.schedule(new AnonymousClass1(updateFunction));
    }
}
