package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.media.AudioAttributesCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetAgeVerifyViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventsSubject;
    private final RestAPI restAPI;
    private final StoreAuthentication storeAuth;

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$1, reason: invalid class name */
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
            WidgetAgeVerifyViewModel.access$handleStoreState(WidgetAgeVerifyViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableI = Observable.i(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), companion.getChannelsSelected().observeSelectedChannel().Y(WidgetAgeVerifyViewModel$Companion$observeStores$1.INSTANCE), WidgetAgeVerifyViewModel$Companion$observeStores$2.INSTANCE);
            m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…hed\n          )\n        }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetAgeVerifyViewModel.kt */
        public static final class Verified extends Event {
            public static final Verified INSTANCE = new Verified();

            private Verified() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean authed;
        private final NsfwAllowance nsfwAllowed;
        private final Channel safeChannel;

        public StoreState(Channel channel, NsfwAllowance nsfwAllowance, boolean z2) {
            m.checkNotNullParameter(nsfwAllowance, "nsfwAllowed");
            this.safeChannel = channel;
            this.nsfwAllowed = nsfwAllowance;
            this.authed = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, NsfwAllowance nsfwAllowance, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.safeChannel;
            }
            if ((i & 2) != 0) {
                nsfwAllowance = storeState.nsfwAllowed;
            }
            if ((i & 4) != 0) {
                z2 = storeState.authed;
            }
            return storeState.copy(channel, nsfwAllowance, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* renamed from: component2, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAuthed() {
            return this.authed;
        }

        public final StoreState copy(Channel safeChannel, NsfwAllowance nsfwAllowed, boolean authed) {
            m.checkNotNullParameter(nsfwAllowed, "nsfwAllowed");
            return new StoreState(safeChannel, nsfwAllowed, authed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.safeChannel, storeState.safeChannel) && m.areEqual(this.nsfwAllowed, storeState.nsfwAllowed) && this.authed == storeState.authed;
        }

        public final boolean getAuthed() {
            return this.authed;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.safeChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            int iHashCode2 = (iHashCode + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
            boolean z2 = this.authed;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(safeChannel=");
            sbU.append(this.safeChannel);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(", authed=");
            return a.O(sbU, this.authed, ")");
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    public static final /* data */ class ViewState {
        private Long dateOfBirth;
        private final int displayedChild;
        private final Integer errorStringId;
        private final boolean isSubmitting;
        private final Channel safeChannel;
        private final boolean shouldClose;
        private String underageMessage;

        public ViewState(boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3) {
            this.isSubmitting = z2;
            this.errorStringId = num;
            this.displayedChild = i;
            this.dateOfBirth = l;
            this.underageMessage = str;
            this.safeChannel = channel;
            this.shouldClose = z3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isSubmitting;
            }
            if ((i2 & 2) != 0) {
                num = viewState.errorStringId;
            }
            Integer num2 = num;
            if ((i2 & 4) != 0) {
                i = viewState.displayedChild;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                l = viewState.dateOfBirth;
            }
            Long l2 = l;
            if ((i2 & 16) != 0) {
                str = viewState.underageMessage;
            }
            String str2 = str;
            if ((i2 & 32) != 0) {
                channel = viewState.safeChannel;
            }
            Channel channel2 = channel;
            if ((i2 & 64) != 0) {
                z3 = viewState.shouldClose;
            }
            return viewState.copy(z2, num2, i3, l2, str2, channel2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getErrorStringId() {
            return this.errorStringId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getDisplayedChild() {
            return this.displayedChild;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getDateOfBirth() {
            return this.dateOfBirth;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUnderageMessage() {
            return this.underageMessage;
        }

        /* renamed from: component6, reason: from getter */
        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getShouldClose() {
            return this.shouldClose;
        }

        public final ViewState copy(boolean isSubmitting, Integer errorStringId, int displayedChild, Long dateOfBirth, String underageMessage, Channel safeChannel, boolean shouldClose) {
            return new ViewState(isSubmitting, errorStringId, displayedChild, dateOfBirth, underageMessage, safeChannel, shouldClose);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isSubmitting == viewState.isSubmitting && m.areEqual(this.errorStringId, viewState.errorStringId) && this.displayedChild == viewState.displayedChild && m.areEqual(this.dateOfBirth, viewState.dateOfBirth) && m.areEqual(this.underageMessage, viewState.underageMessage) && m.areEqual(this.safeChannel, viewState.safeChannel) && this.shouldClose == viewState.shouldClose;
        }

        public final Long getDateOfBirth() {
            return this.dateOfBirth;
        }

        public final int getDisplayedChild() {
            return this.displayedChild;
        }

        public final Integer getErrorStringId() {
            return this.errorStringId;
        }

        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        public final boolean getShouldClose() {
            return this.shouldClose;
        }

        public final String getUnderageMessage() {
            return this.underageMessage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.isSubmitting;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.errorStringId;
            int iHashCode = (((i + (num != null ? num.hashCode() : 0)) * 31) + this.displayedChild) * 31;
            Long l = this.dateOfBirth;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.underageMessage;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Channel channel = this.safeChannel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z3 = this.shouldClose;
            return iHashCode4 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public final void setDateOfBirth(Long l) {
            this.dateOfBirth = l;
        }

        public final void setUnderageMessage(String str) {
            this.underageMessage = str;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", errorStringId=");
            sbU.append(this.errorStringId);
            sbU.append(", displayedChild=");
            sbU.append(this.displayedChild);
            sbU.append(", dateOfBirth=");
            sbU.append(this.dateOfBirth);
            sbU.append(", underageMessage=");
            sbU.append(this.underageMessage);
            sbU.append(", safeChannel=");
            sbU.append(this.safeChannel);
            sbU.append(", shouldClose=");
            return a.O(sbU, this.shouldClose, ")");
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    public static final class Views {
        public static final Views INSTANCE = new Views();
        public static final int VIEW_AGE_CONFIRM = 1;
        public static final int VIEW_AGE_GATED = 2;
        public static final int VIEW_AGE_VERIFY = 0;

        private Views() {
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<User, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            m.checkNotNullParameter(user, "it");
            WidgetAgeVerifyViewModel.access$handleUserUpdateSuccess(WidgetAgeVerifyViewModel.this);
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$submit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
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
            m.checkNotNullParameter(error, "it");
            WidgetAgeVerifyViewModel.access$handleUserUpdateFailure(WidgetAgeVerifyViewModel.this, error);
        }
    }

    public WidgetAgeVerifyViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 2) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication, (i & 4) != 0 ? INSTANCE.observeStores() : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, StoreState storeState) {
        widgetAgeVerifyViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$handleUserUpdateFailure(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, Error error) {
        widgetAgeVerifyViewModel.handleUserUpdateFailure(error);
    }

    public static final /* synthetic */ void access$handleUserUpdateSuccess(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel) {
        widgetAgeVerifyViewModel.handleUserUpdateSuccess();
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, storeState.getSafeChannel(), (storeState.getAuthed() && storeState.getNsfwAllowed() == NsfwAllowance.UNKNOWN) ? false : true, 31, null));
        }
    }

    @MainThread
    private final void handleUserUpdateFailure(Error error) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            m.checkNotNullExpressionValue(messages, "error.response.messages");
            if (!messages.containsKey(BirthdayHelper.DATE_OF_BIRTH_KEY)) {
                updateViewState(ViewState.copy$default(viewState, false, Integer.valueOf(R.string.age_gate_failed_to_update_birthday), 0, null, null, null, false, 124, null));
                return;
            }
            Error.Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages2 = response2.getMessages();
            m.checkNotNullExpressionValue(messages2, "error.response.messages");
            List<String> listEmptyList = messages2.get(BirthdayHelper.DATE_OF_BIRTH_KEY);
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            m.checkNotNullExpressionValue(listEmptyList, "error.response.messages\n…IRTH_KEY) { emptyList() }");
            String strJoinToString$default = u.joinToString$default(listEmptyList, "\n", null, null, 0, null, null, 62, null);
            updateViewState(ViewState.copy$default(viewState, false, null, 2, null, strJoinToString$default, null, false, 106, null));
            this.storeAuth.setAgeGateError(strJoinToString$default);
        }
    }

    @MainThread
    private final void handleUserUpdateSuccess() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 126, null));
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.Verified.INSTANCE);
        }
    }

    @MainThread
    public final boolean backToSafety() {
        ViewState viewState = getViewState();
        Channel safeChannel = viewState != null ? viewState.getSafeChannel() : null;
        if (safeChannel == null) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
            return true;
        }
        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), safeChannel, null, null, 6, null);
        return false;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConfirmBackClicked() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 123, null));
        }
    }

    @MainThread
    public final void setDateOfBirth(long dateOfBirth) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, Long.valueOf(dateOfBirth), null, null, false, 119, null));
        }
    }

    @MainThread
    public final void submit(boolean isNSFWChannel) {
        Long dateOfBirth;
        ViewState viewState = getViewState();
        if (viewState == null || (dateOfBirth = viewState.getDateOfBirth()) == null) {
            return;
        }
        long jLongValue = dateOfBirth.longValue();
        boolean z2 = BirthdayHelper.INSTANCE.getAge(jLongValue) < 18;
        if (isNSFWChannel && z2 && viewState.getDisplayedChild() == 0) {
            updateViewState(ViewState.copy$default(viewState, false, null, 1, null, null, null, false, 123, null));
            return;
        }
        RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, null, null, null, null, null, null, null, TimeUtils.toUTCDateTime(Long.valueOf(jLongValue), TimeUtils.UTCFormat.SHORT), AudioAttributesCompat.FLAG_ALL, null);
        updateViewState(ViewState.copy$default(viewState, true, null, 0, null, null, null, false, 124, null));
        AnalyticsTracker.INSTANCE.ageGateSubmitted(jLongValue, isNSFWChannel ? "NSFW Channel" : "Public Server");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(userInfo), false, 1, null), this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable<StoreState> observable) {
        super(new ViewState(false, null, 0, null, null, null, false));
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeAuthentication, "storeAuth");
        m.checkNotNullParameter(observable, "storeObservable");
        this.restAPI = restAPI;
        this.storeAuth = storeAuthentication;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
