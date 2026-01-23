package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCallFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_USER_ID = "INTENT_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long userId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetCallFailed widgetCallFailed = new WidgetCallFailed();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetCallFailed.INTENT_USER_ID, userId);
            widgetCallFailed.setArguments(bundle);
            widgetCallFailed.show(fragmentManager, WidgetCallFailed.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class ViewOnClickListenerC104111 implements View.OnClickListener {
        public ViewOnClickListenerC104111() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallFailed.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class C104121 extends Lambda implements Function1<User, Unit> {
        public C104121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            WidgetCallFailed.access$configureUI(WidgetCallFailed.this, user);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class C104131<T> implements Action1<Void> {
        public C104131() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r4) {
            AppToast.m171i(WidgetCallFailed.this, C5419R.string.friend_request_sent, 0, 4);
            WidgetCallFailed.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class C104142<T> implements Action1<Error> {
        public final /* synthetic */ long $userId;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetCallFailed.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetCallFailed.kt */
            public static final class C132971 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
                public C132971() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    invoke2(appFragment, captchaPayload);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
                    C104142 c104142 = C104142.this;
                    WidgetCallFailed.access$sendFriendRequest(WidgetCallFailed.this, c104142.$userId, c104142.$username, captchaPayload);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptcha4.isCaptchaError(error)) {
                    WidgetCaptchaBottomSheet.Companion companion = WidgetCaptchaBottomSheet.INSTANCE;
                    C132971 c132971 = new C132971();
                    CaptchaErrorBody.Companion companion2 = CaptchaErrorBody.INSTANCE;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetCaptchaBottomSheet.Companion.enqueue$default(companion, "Add Friend Captcha", c132971, null, companion2.createFromError(error2), 4, null);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetCallFailed.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                AppToast.m170h(WidgetCallFailed.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), C104142.this.$username), 0, null, 12);
            }
        }

        public C104142(long j, String str) {
            this.$userId = j;
            this.$username = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetCallFailed() {
        super(C5419R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCallFailed2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallFailed widgetCallFailed, User user) {
        widgetCallFailed.configureUI(user);
    }

    public static final /* synthetic */ void access$sendFriendRequest(WidgetCallFailed widgetCallFailed, long j, String str, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetCallFailed.sendFriendRequest(j, str, captchaPayload);
    }

    private final void configureUI(User user) {
        if (user == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().f15424e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationText");
        FormatUtils.m222n(textView, C5419R.string.call_invite_not_friends, new Object[]{user.getUsername()}, null, 4);
        getBinding().f15422c.setOnClickListener(new WidgetCallFailed3(this, user));
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendFriendRequest(long userId, String username, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.addRelationship$default(RestAPI.INSTANCE.getApi(), "Call", userId, null, null, captchaPayload, 8, null), this, null, 2, null).m11108k(C0879o.m181h(new C104131(), getAppActivity(), new C104142(userId, username)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetCallFailed widgetCallFailed, long j, String str, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        widgetCallFailed.sendFriendRequest(j, str, captchaPayload);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15423d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(getString(C5419R.string.start_call));
        MaterialButton materialButton = getBinding().f15422c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(getString(C5419R.string.add_friend_button));
        MaterialButton materialButton2 = getBinding().f15421b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setText(getString(C5419R.string.okay));
        getBinding().f15421b.setOnClickListener(new ViewOnClickListenerC104111());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUsers().observeUser(getArgumentsOrDefault().getLong(INTENT_USER_ID)), this, null, 2, null), WidgetCallFailed.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C104121(), 62, (Object) null);
    }
}
