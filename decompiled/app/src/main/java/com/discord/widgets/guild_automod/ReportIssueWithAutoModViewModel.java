package com.discord.widgets.guild_automod;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ReportIssueWithAutoModViewModel.kt */
/* loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long messageId;

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    /* renamed from: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel) {
            super(1, reportIssueWithAutoModViewModel, ReportIssueWithAutoModViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ReportIssueWithAutoModViewModel.access$handleStoreState((ReportIssueWithAutoModViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, long j2, StoreMessages storeMessages) {
            return companion.observeStores(j, j2, storeMessages);
        }

        private final Observable<StoreState> observeStores(long channelId, long messageId, StoreMessages messageStore) {
            Observable observableG = messageStore.observeMessagesForChannel(channelId, messageId).G(ReportIssueWithAutoModViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "messageStore.observeMess…te(clientMessage)\n      }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    public static final /* data */ class StoreState {
        private final Message message;

        public StoreState(Message message) {
            this.message = message;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = storeState.message;
            }
            return storeState.copy(message);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        public final StoreState copy(Message message) {
            return new StoreState(message);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.message, ((StoreState) other).message);
            }
            return true;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(message=");
            sbU.append(this.message);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ReportIssueWithAutoModViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ReportIssueWithAutoModViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Message message;
            private final String selectedOption;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Message message, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(str, "selectedOption");
                this.message = message;
                this.selectedOption = str;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Message message, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = valid.message;
                }
                if ((i & 2) != 0) {
                    str = valid.selectedOption;
                }
                return valid.copy(message, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public final Valid copy(Message message, String selectedOption) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(selectedOption, "selectedOption");
                return new Valid(message, selectedOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.message, valid.message) && Intrinsics3.areEqual(this.selectedOption, valid.selectedOption);
            }

            public final Message getMessage() {
                return this.message;
            }

            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public int hashCode() {
                Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                String str = this.selectedOption;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(message=");
                sbU.append(this.message);
                sbU.append(", selectedOption=");
                return outline.J(sbU, this.selectedOption, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeMessages = (i & 4) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        this(j, j2, storeMessages, (i & 8) != 0 ? Companion.access$observeStores(INSTANCE, j, j2, storeMessages) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel, StoreState storeState) {
        reportIssueWithAutoModViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        String value;
        ViewState valid;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        if (storeState.getMessage() == null) {
            valid = ViewState.Invalid.INSTANCE;
        } else {
            Message message = storeState.getMessage();
            if (valid2 == null || (value = valid2.getSelectedOption()) == null) {
                value = ReportIssueWithAutoModViewModel2.ALLOWED.getValue();
            }
            valid = new ViewState.Valid(message, value);
        }
        updateViewState(valid);
    }

    public final void onFeedbackTypeSelected(ReportIssueWithAutoModViewModel2 feedbackType) {
        Intrinsics3.checkNotNullParameter(feedbackType, "feedbackType");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, feedbackType.getValue(), 1, null));
        }
    }

    public final void onSubmit(Function0<Unit> onCompleted) {
        String embedFieldValue;
        Intrinsics3.checkNotNullParameter(onCompleted, "onCompleted");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            List<MessageEmbed> embeds = valid.getMessage().getEmbeds();
            MessageEmbed messageEmbed = embeds != null ? (MessageEmbed) _Collections.first((List) embeds) : null;
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            if (messageEmbed == null || (embedFieldValue = AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, "decision_id")) == null) {
                embedFieldValue = "";
            }
            long id2 = valid.getMessage().getId();
            String content = valid.getMessage().getContent();
            analyticsTracker.trackReportIssueWithAutoMod(embedFieldValue, id2, valid.getSelectedOption(), content != null ? content : "");
            onCompleted.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeMessages, "messageStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.messageId = j2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ReportIssueWithAutoModViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
