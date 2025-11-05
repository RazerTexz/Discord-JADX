package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: MemberVerificationPendingViewModel.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DialogState dialogState;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
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
            m.checkNotNullParameter(storeState, "storeState");
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
            Observable<StoreState> observableI = Observable.i(companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), MemberVerificationPendingViewModel$Companion$observeStores$1.INSTANCE);
            m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…Reason,\n        )\n      }");
            return observableI;
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
            m.checkNotNullParameter(applicationStatus, "applicationStatus");
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
            m.checkNotNullParameter(applicationStatus, "applicationStatus");
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
            return this.isFormOutdated == storeState.isFormOutdated && this.isPreviewEnabled == storeState.isPreviewEnabled && m.areEqual(this.applicationStatus, storeState.applicationStatus) && m.areEqual(this.rejectionReason, storeState.rejectionReason);
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
            StringBuilder sbU = a.U("StoreState(isFormOutdated=");
            sbU.append(this.isFormOutdated);
            sbU.append(", isPreviewEnabled=");
            sbU.append(this.isPreviewEnabled);
            sbU.append(", applicationStatus=");
            sbU.append(this.applicationStatus);
            sbU.append(", rejectionReason=");
            return a.J(sbU, this.rejectionReason, ")");
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
                m.checkNotNullParameter(dialogState, "dialogState");
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
                m.checkNotNullParameter(dialogState, "dialogState");
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
                return m.areEqual(this.dialogState, loaded.dialogState) && this.showPendingImage == loaded.showPendingImage && this.showTertiaryButton == loaded.showTertiaryButton && this.isPreviewEnabled == loaded.isPreviewEnabled && m.areEqual(this.rejectionReason, loaded.rejectionReason);
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
                StringBuilder sbU = a.U("Loaded(dialogState=");
                sbU.append(this.dialogState);
                sbU.append(", showPendingImage=");
                sbU.append(this.showPendingImage);
                sbU.append(", showTertiaryButton=");
                sbU.append(this.showTertiaryButton);
                sbU.append(", isPreviewEnabled=");
                sbU.append(this.isPreviewEnabled);
                sbU.append(", rejectionReason=");
                return a.J(sbU, this.rejectionReason, ")");
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
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            MemberVerificationPendingViewModel.access$onResetSuccess(MemberVerificationPendingViewModel.this);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Success.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            m.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
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
        publishSubject.k.onNext(Event.Success.INSTANCE);
    }

    public final void deleteGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void leaveGuild() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void resetGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.resetGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void updateDialogState(DialogState dialogState) {
        m.checkNotNullParameter(dialogState, "dialogState");
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
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.dialogState = dialogState;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
