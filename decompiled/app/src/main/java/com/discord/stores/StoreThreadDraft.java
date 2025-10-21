package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreThreadDraft.kt */
/* loaded from: classes2.dex */
public final class StoreThreadDraft extends StoreV2 {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<ThreadDraftState> draftStateSubject;

    /* compiled from: StoreThreadDraft.kt */
    public static final /* data */ class ThreadDraftState {
        private final Integer autoArchiveDuration;
        private final boolean isPrivate;
        private final boolean isSending;
        private final boolean shouldDisplayNameError;
        private final String threadName;

        public ThreadDraftState() {
            this(false, null, null, false, false, 31, null);
        }

        public ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4) {
            this.isPrivate = z2;
            this.autoArchiveDuration = num;
            this.threadName = str;
            this.isSending = z3;
            this.shouldDisplayNameError = z4;
        }

        public static /* synthetic */ ThreadDraftState copy$default(ThreadDraftState threadDraftState, boolean z2, Integer num, String str, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = threadDraftState.isPrivate;
            }
            if ((i & 2) != 0) {
                num = threadDraftState.autoArchiveDuration;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                str = threadDraftState.threadName;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                z3 = threadDraftState.isSending;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                z4 = threadDraftState.shouldDisplayNameError;
            }
            return threadDraftState.copy(z2, num2, str2, z5, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsPrivate() {
            return this.isPrivate;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        /* renamed from: component3, reason: from getter */
        public final String getThreadName() {
            return this.threadName;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsSending() {
            return this.isSending;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final ThreadDraftState copy(boolean isPrivate, Integer autoArchiveDuration, String threadName, boolean isSending, boolean shouldDisplayNameError) {
            return new ThreadDraftState(isPrivate, autoArchiveDuration, threadName, isSending, shouldDisplayNameError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadDraftState)) {
                return false;
            }
            ThreadDraftState threadDraftState = (ThreadDraftState) other;
            return this.isPrivate == threadDraftState.isPrivate && Intrinsics3.areEqual(this.autoArchiveDuration, threadDraftState.autoArchiveDuration) && Intrinsics3.areEqual(this.threadName, threadDraftState.threadName) && this.isSending == threadDraftState.isSending && this.shouldDisplayNameError == threadDraftState.shouldDisplayNameError;
        }

        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isPrivate;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.autoArchiveDuration;
            int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.threadName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            ?? r2 = this.isSending;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (iHashCode2 + i2) * 31;
            boolean z3 = this.shouldDisplayNameError;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isPrivate() {
            return this.isPrivate;
        }

        public final boolean isSending() {
            return this.isSending;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadDraftState(isPrivate=");
            sbU.append(this.isPrivate);
            sbU.append(", autoArchiveDuration=");
            sbU.append(this.autoArchiveDuration);
            sbU.append(", threadName=");
            sbU.append(this.threadName);
            sbU.append(", isSending=");
            sbU.append(this.isSending);
            sbU.append(", shouldDisplayNameError=");
            return outline.O(sbU, this.shouldDisplayNameError, ")");
        }

        public /* synthetic */ ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num, (i & 4) == 0 ? str : null, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    /* renamed from: com.discord.stores.StoreThreadDraft$clearDraftState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
            StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this).onNext(new ThreadDraftState(false, null, null, false, false, 31, null));
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    /* renamed from: com.discord.stores.StoreThreadDraft$setDraftSending$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
            BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p = StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this);
            BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p2 = StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getDraftStateSubject$p2, "draftStateSubject");
            behaviorSubjectAccess$getDraftStateSubject$p.onNext(ThreadDraftState.copy$default((ThreadDraftState) behaviorSubjectAccess$getDraftStateSubject$p2.n0(), false, null, null, true, false, 23, null));
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    /* renamed from: com.discord.stores.StoreThreadDraft$setDraftState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ThreadDraftState $draftState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ThreadDraftState threadDraftState) {
            super(0);
            this.$draftState = threadDraftState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this).onNext(this.$draftState);
        }
    }

    public StoreThreadDraft(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.draftStateSubject = BehaviorSubject.l0(new ThreadDraftState(false, null, null, false, false, 31, null));
    }

    public static final /* synthetic */ BehaviorSubject access$getDraftStateSubject$p(StoreThreadDraft storeThreadDraft) {
        return storeThreadDraft.draftStateSubject;
    }

    public final void clearDraftState() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<ThreadDraftState> observeDraftState() {
        BehaviorSubject<ThreadDraftState> behaviorSubject = this.draftStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "draftStateSubject");
        return behaviorSubject;
    }

    public final void setDraftSending() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void setDraftState(ThreadDraftState draftState) {
        Intrinsics3.checkNotNullParameter(draftState, "draftState");
        this.dispatcher.schedule(new AnonymousClass1(draftState));
    }
}
