package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.premium.ClaimStatus;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ClaimOutboundPromoViewModel.kt */
/* loaded from: classes2.dex */
public final class ClaimOutboundPromoViewModel extends AppViewModel<ViewState> {
    private ClaimStatus claimStatus;
    private final PublishSubject<Event> eventSubject;
    private final StoreOutboundPromotions storeOutboundPromotions;

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    public static abstract class Event {

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final /* data */ class Claimed extends Event {
            private final ClaimStatus.Claimed claimedStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Claimed(ClaimStatus.Claimed claimed) {
                super(null);
                Intrinsics3.checkNotNullParameter(claimed, "claimedStatus");
                this.claimedStatus = claimed;
            }

            public static /* synthetic */ Claimed copy$default(Claimed claimed, ClaimStatus.Claimed claimed2, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimed2 = claimed.claimedStatus;
                }
                return claimed.copy(claimed2);
            }

            /* renamed from: component1, reason: from getter */
            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public final Claimed copy(ClaimStatus.Claimed claimedStatus) {
                Intrinsics3.checkNotNullParameter(claimedStatus, "claimedStatus");
                return new Claimed(claimedStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Claimed) && Intrinsics3.areEqual(this.claimedStatus, ((Claimed) other).claimedStatus);
                }
                return true;
            }

            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public int hashCode() {
                ClaimStatus.Claimed claimed = this.claimedStatus;
                if (claimed != null) {
                    return claimed.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Claimed(claimedStatus=");
                sbU.append(this.claimedStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final /* data */ class CopyCode extends Event {
            private final String code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyCode(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
                this.code = str;
            }

            public static /* synthetic */ CopyCode copy$default(CopyCode copyCode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = copyCode.code;
                }
                return copyCode.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            public final CopyCode copy(String code) {
                Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
                return new CopyCode(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CopyCode) && Intrinsics3.areEqual(this.code, ((CopyCode) other).code);
                }
                return true;
            }

            public final String getCode() {
                return this.code;
            }

            public int hashCode() {
                String str = this.code;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("CopyCode(code="), this.code, ")");
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final /* data */ class OpenRedemptionUrl extends Event {
            private final String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenRedemptionUrl(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "url");
                this.url = str;
            }

            public static /* synthetic */ OpenRedemptionUrl copy$default(OpenRedemptionUrl openRedemptionUrl, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openRedemptionUrl.url;
                }
                return openRedemptionUrl.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final OpenRedemptionUrl copy(String url) {
                Intrinsics3.checkNotNullParameter(url, "url");
                return new OpenRedemptionUrl(url);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof OpenRedemptionUrl) && Intrinsics3.areEqual(this.url, ((OpenRedemptionUrl) other).url);
                }
                return true;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.url;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("OpenRedemptionUrl(url="), this.url, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final class ClaimFailed extends ViewState {
            public static final ClaimFailed INSTANCE = new ClaimFailed();

            private ClaimFailed() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final class ClaimInProgress extends ViewState {
            public static final ClaimInProgress INSTANCE = new ClaimInProgress();

            private ClaimInProgress() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        public static final /* data */ class Claimed extends ViewState {
            private final ClaimStatus.Claimed claimedStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Claimed(ClaimStatus.Claimed claimed) {
                super(null);
                Intrinsics3.checkNotNullParameter(claimed, "claimedStatus");
                this.claimedStatus = claimed;
            }

            public static /* synthetic */ Claimed copy$default(Claimed claimed, ClaimStatus.Claimed claimed2, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimed2 = claimed.claimedStatus;
                }
                return claimed.copy(claimed2);
            }

            /* renamed from: component1, reason: from getter */
            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public final Claimed copy(ClaimStatus.Claimed claimedStatus) {
                Intrinsics3.checkNotNullParameter(claimedStatus, "claimedStatus");
                return new Claimed(claimedStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Claimed) && Intrinsics3.areEqual(this.claimedStatus, ((Claimed) other).claimedStatus);
                }
                return true;
            }

            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public int hashCode() {
                ClaimStatus.Claimed claimed = this.claimedStatus;
                if (claimed != null) {
                    return claimed.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Claimed(claimedStatus=");
                sbU.append(this.claimedStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    /* renamed from: com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel$claimPromo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ClaimedOutboundPromotion, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimedOutboundPromotion claimedOutboundPromotion) {
            invoke2(claimedOutboundPromotion);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimedOutboundPromotion claimedOutboundPromotion) {
            Intrinsics3.checkNotNullParameter(claimedOutboundPromotion, "claimedPromo");
            ClaimOutboundPromoViewModel claimOutboundPromoViewModel = ClaimOutboundPromoViewModel.this;
            ClaimStatus.Claimed claimed = new ClaimStatus.Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.d(), claimedOutboundPromotion.c());
            ClaimOutboundPromoViewModel.access$updateViewState(ClaimOutboundPromoViewModel.this, new ViewState.Claimed(claimed));
            PublishSubject publishSubjectAccess$getEventSubject$p = ClaimOutboundPromoViewModel.access$getEventSubject$p(ClaimOutboundPromoViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.Claimed(claimed));
            ClaimOutboundPromoViewModel.access$setClaimStatus$p(claimOutboundPromoViewModel, claimed);
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    /* renamed from: com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel$claimPromo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            ClaimOutboundPromoViewModel.access$updateViewState(ClaimOutboundPromoViewModel.this, ViewState.ClaimFailed.INSTANCE);
        }
    }

    public /* synthetic */ ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(claimStatus, (i & 2) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.claimStatus;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$setClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ClaimStatus claimStatus) {
        claimOutboundPromoViewModel.claimStatus = claimStatus;
    }

    public static final /* synthetic */ void access$updateViewState(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ViewState viewState) {
        claimOutboundPromoViewModel.updateViewState(viewState);
    }

    private final void claimPromo(long promoId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.claimOutboundPromotion(promoId), false, 1, null), this, null, 2, null), ClaimOutboundPromoViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    private final void handleClaimStatus() {
        ClaimStatus claimStatus = this.claimStatus;
        if (claimStatus instanceof ClaimStatus.Claimed) {
            updateViewState(new ViewState.Claimed((ClaimStatus.Claimed) claimStatus));
        } else if (claimStatus instanceof ClaimStatus.Unclaimed) {
            claimPromo(((ClaimStatus.Unclaimed) claimStatus).getPromoId());
        }
    }

    @MainThread
    public final void copyClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus.Claimed)) {
            claimStatus = null;
        }
        ClaimStatus.Claimed claimed = (ClaimStatus.Claimed) claimStatus;
        if (claimed != null) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.CopyCode(claimed.getCode()));
        }
    }

    @MainThread
    public final void failureCloseClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    @MainThread
    public final void maybeLaterClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void redeemClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus.Claimed)) {
            claimStatus = null;
        }
        ClaimStatus.Claimed claimed = (ClaimStatus.Claimed) claimStatus;
        if (claimed != null) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.OpenRedemptionUrl(claimed.getLink()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions) {
        super(ViewState.ClaimInProgress.INSTANCE);
        Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
        Intrinsics3.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        this.claimStatus = claimStatus;
        this.storeOutboundPromotions = storeOutboundPromotions;
        this.eventSubject = PublishSubject.k0();
        handleClaimStatus();
    }
}
