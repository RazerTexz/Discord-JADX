package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: MemberVerificationPendingViewModel.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DialogState dialogState;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$1 */
    public static final class C95381 extends Lambda implements Function1<StoreState, Unit> {
        public C95381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            MemberVerificationPendingViewModel.access$handleStoreState(MemberVerificationPendingViewModel.this, storeState);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j) {
            return companion.observeStores(j);
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableM11075i = Observable.m11075i(companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), MemberVerificationPendingViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…Reason,\n        )\n      }");
            return observableM11075i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    public enum DialogState {
        UPGRADE,
        PENDING,
        CANCEL,
        REJECTED,
        LEAVE
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    public static abstract class Event {

        /* compiled from: MemberVerificationPendingViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: MemberVerificationPendingViewModel.kt */
        public static final class Success extends Event {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    public static final /* data */ class StoreState {
        private final ApplicationStatus applicationStatus;
        private final boolean isFormOutdated;
        private final boolean isPreviewEnabled;
        private final String rejectionReason;

        public StoreState(boolean z2, boolean z3, ApplicationStatus applicationStatus, String str) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            this.isFormOutdated = z2;
            this.isPreviewEnabled = z3;
            this.applicationStatus = applicationStatus;
            this.rejectionReason = str;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, ApplicationStatus applicationStatus, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isFormOutdated;
            }
            if ((i & 2) != 0) {
                z3 = storeState.isPreviewEnabled;
            }
            if ((i & 4) != 0) {
                applicationStatus = storeState.applicationStatus;
            }
            if ((i & 8) != 0) {
                str = storeState.rejectionReason;
            }
            return storeState.copy(z2, z3, applicationStatus, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsFormOutdated() {
            return this.isFormOutdated;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        /* renamed from: component3, reason: from getter */
        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        public final StoreState copy(boolean isFormOutdated, boolean isPreviewEnabled, ApplicationStatus applicationStatus, String rejectionReason) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            return new StoreState(isFormOutdated, isPreviewEnabled, applicationStatus, rejectionReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isFormOutdated == storeState.isFormOutdated && this.isPreviewEnabled == storeState.isPreviewEnabled && Intrinsics3.areEqual(this.applicationStatus, storeState.applicationStatus) && Intrinsics3.areEqual(this.rejectionReason, storeState.rejectionReason);
        }

        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z2 = this.isFormOutdated;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isPreviewEnabled;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            ApplicationStatus applicationStatus = this.applicationStatus;
            int iHashCode = (i2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
            String str = this.rejectionReason;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final boolean isFormOutdated() {
            return this.isFormOutdated;
        }

        public final boolean isPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(isFormOutdated=");
            sbM833U.append(this.isFormOutdated);
            sbM833U.append(", isPreviewEnabled=");
            sbM833U.append(this.isPreviewEnabled);
            sbM833U.append(", applicationStatus=");
            sbM833U.append(this.applicationStatus);
            sbM833U.append(", rejectionReason=");
            return outline.m822J(sbM833U, this.rejectionReason, ")");
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: MemberVerificationPendingViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final DialogState dialogState;
            private final boolean isPreviewEnabled;
            private final String rejectionReason;
            private final boolean showPendingImage;
            private final boolean showTertiaryButton;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(DialogState dialogState, boolean z2, boolean z3, boolean z4, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                this.dialogState = dialogState;
                this.showPendingImage = z2;
                this.showTertiaryButton = z3;
                this.isPreviewEnabled = z4;
                this.rejectionReason = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, DialogState dialogState, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    dialogState = loaded.dialogState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showPendingImage;
                }
                boolean z5 = z2;
                if ((i & 4) != 0) {
                    z3 = loaded.showTertiaryButton;
                }
                boolean z6 = z3;
                if ((i & 8) != 0) {
                    z4 = loaded.isPreviewEnabled;
                }
                boolean z7 = z4;
                if ((i & 16) != 0) {
                    str = loaded.rejectionReason;
                }
                return loaded.copy(dialogState, z5, z6, z7, str);
            }

            /* renamed from: component1, reason: from getter */
            public final DialogState getDialogState() {
                return this.dialogState;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            /* renamed from: component5, reason: from getter */
            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final Loaded copy(DialogState dialogState, boolean showPendingImage, boolean showTertiaryButton, boolean isPreviewEnabled, String rejectionReason) {
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                return new Loaded(dialogState, showPendingImage, showTertiaryButton, isPreviewEnabled, rejectionReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.dialogState, loaded.dialogState) && this.showPendingImage == loaded.showPendingImage && this.showTertiaryButton == loaded.showTertiaryButton && this.isPreviewEnabled == loaded.isPreviewEnabled && Intrinsics3.areEqual(this.rejectionReason, loaded.rejectionReason);
            }

            public final DialogState getDialogState() {
                return this.dialogState;
            }

            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                DialogState dialogState = this.dialogState;
                int iHashCode = (dialogState != null ? dialogState.hashCode() : 0) * 31;
                boolean z2 = this.showPendingImage;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.showTertiaryButton;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isPreviewEnabled;
                int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
                String str = this.rejectionReason;
                return i5 + (str != null ? str.hashCode() : 0);
            }

            public final boolean isPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(dialogState=");
                sbM833U.append(this.dialogState);
                sbM833U.append(", showPendingImage=");
                sbM833U.append(this.showPendingImage);
                sbM833U.append(", showTertiaryButton=");
                sbM833U.append(this.showTertiaryButton);
                sbM833U.append(", isPreviewEnabled=");
                sbM833U.append(this.isPreviewEnabled);
                sbM833U.append(", rejectionReason=");
                return outline.m822J(sbM833U, this.rejectionReason, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.PENDING.ordinal()] = 1;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$1 */
    public static final class C95391 extends Lambda implements Function1<Error, Unit> {
        public C95391() {
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$2 */
    public static final class C95402 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public C95402() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            MemberVerificationPendingViewModel.access$onResetSuccess(MemberVerificationPendingViewModel.this);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$1 */
    public static final class C95411 extends Lambda implements Function1<Error, Unit> {
        public C95411() {
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$2 */
    public static final class C95422 extends Lambda implements Function1<Void, Unit> {
        public C95422() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.Success.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$1 */
    public static final class C95431 extends Lambda implements Function1<Error, Unit> {
        public C95431() {
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$2 */
    public static final class C95442 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public C95442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            Intrinsics3.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
            MemberVerificationPendingViewModel.access$onResetSuccess(MemberVerificationPendingViewModel.this);
        }
    }

    public /* synthetic */ MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, dialogState, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? Companion.access$observeStores(INSTANCE, j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        return memberVerificationPendingViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(MemberVerificationPendingViewModel memberVerificationPendingViewModel, StoreState storeState) {
        memberVerificationPendingViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onResetSuccess(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        memberVerificationPendingViewModel.onResetSuccess();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        DialogState dialogState = this.dialogState;
        if (dialogState == null) {
            int iOrdinal = storeState.getApplicationStatus().ordinal();
            dialogState = iOrdinal != 1 ? iOrdinal != 2 ? null : DialogState.REJECTED : storeState.isPreviewEnabled() ? DialogState.CANCEL : DialogState.PENDING;
        }
        DialogState dialogState2 = dialogState;
        if (storeState.isFormOutdated()) {
            updateViewState(new ViewState.Loaded(DialogState.UPGRADE, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        } else if (dialogState2 != null) {
            updateViewState(new ViewState.Loaded(dialogState2, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        }
    }

    private final void onResetSuccess() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Success.INSTANCE);
    }

    public final void deleteGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new C95391(), (Function0) null, (Function0) null, new C95402(), 54, (Object) null);
    }

    public final void leaveGuild() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new C95411(), (Function0) null, (Function0) null, new C95422(), 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void resetGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.resetGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new C95431(), (Function0) null, (Function0) null, new C95442(), 54, (Object) null);
    }

    public final void updateDialogState(DialogState dialogState) {
        Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            DialogState dialogState2 = DialogState.PENDING;
            updateViewState(ViewState.Loaded.copy$default(loaded, dialogState, dialogState == dialogState2, dialogState == dialogState2 && !loaded.isPreviewEnabled(), false, null, 24, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.dialogState = dialogState;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95381(), 62, (Object) null);
    }
}
