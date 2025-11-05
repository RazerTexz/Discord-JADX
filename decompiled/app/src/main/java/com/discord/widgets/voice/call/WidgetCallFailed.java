package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetCallFailed.kt */
/* loaded from: classes.dex */
public final class WidgetCallFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCallFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_USER_ID = "INTENT_USER_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetCallFailed.kt */
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

    /* compiled from: WidgetCallFailed.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallFailed.this.dismiss();
        }
    }

    /* compiled from: WidgetCallFailed.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
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
            WidgetCallFailed.access$configureUI(WidgetCallFailed.this, user);
        }
    }

    /* compiled from: WidgetCallFailed.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r4) {
            AppToast.i(WidgetCallFailed.this, R.string.friend_request_sent, 0, 4);
            WidgetCallFailed.this.dismiss();
        }
    }

    /* compiled from: WidgetCallFailed.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public final /* synthetic */ long $userId;
        public final /* synthetic */ String $username;

        /* compiled from: WidgetCallFailed.kt */
        /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* compiled from: WidgetCallFailed.kt */
            /* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03591 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
                public C03591() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    invoke2(appFragment, captchaPayload);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    WidgetCallFailed.access$sendFriendRequest(WidgetCallFailed.this, anonymousClass2.$userId, anonymousClass2.$username, captchaPayload);
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
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptcha4.isCaptchaError(error)) {
                    WidgetCaptchaBottomSheet.Companion companion = WidgetCaptchaBottomSheet.INSTANCE;
                    C03591 c03591 = new C03591();
                    CaptchaErrorBody.Companion companion2 = CaptchaErrorBody.INSTANCE;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetCaptchaBottomSheet.Companion.enqueue$default(companion, "Add Friend Captcha", c03591, null, companion2.createFromError(error2), 4, null);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetCallFailed.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                AppToast.h(WidgetCallFailed.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), AnonymousClass2.this.$username), 0, null, 12);
            }
        }

        public AnonymousClass2(long j, String str) {
            this.$userId = j;
            this.$username = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetCallFailed() {
        super(R.layout.view_dialog_confirmation);
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
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationText");
        FormatUtils.n(textView, R.string.call_invite_not_friends, new Object[]{user.getUsername()}, null, 4);
        getBinding().c.setOnClickListener(new WidgetCallFailed3(this, user));
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendFriendRequest(long userId, String username, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.addRelationship$default(RestAPI.INSTANCE.getApi(), "Call", userId, null, null, captchaPayload, 8, null), this, null, 2, null).k(o.h(new AnonymousClass1(), getAppActivity(), new AnonymousClass2(userId, username)));
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
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(getString(R.string.start_call));
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(getString(R.string.add_friend_button));
        MaterialButton materialButton2 = getBinding().f2185b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setText(getString(R.string.okay));
        getBinding().f2185b.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUsers().observeUser(getArgumentsOrDefault().getLong(INTENT_USER_ID)), this, null, 2, null), WidgetCallFailed.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
