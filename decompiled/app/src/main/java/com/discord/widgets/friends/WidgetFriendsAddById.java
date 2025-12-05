package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFriendsAddByIdBinding;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* compiled from: WidgetFriendsAddById.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddById extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetFriendsAddById.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex PATTERN_USERNAME = new Regex("^(.*)#(\\d{4})$");

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* compiled from: WidgetFriendsAddById.kt */
    public static final class Companion {

        /* compiled from: WidgetFriendsAddById.kt */
        public static final /* data */ class UserNameDiscriminator {
            private final Integer discriminator;
            private final String username;

            public UserNameDiscriminator(String str, Integer num) {
                Intrinsics3.checkNotNullParameter(str, "username");
                this.username = str;
                this.discriminator = num;
            }

            public static /* synthetic */ UserNameDiscriminator copy$default(UserNameDiscriminator userNameDiscriminator, String str, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userNameDiscriminator.username;
                }
                if ((i & 2) != 0) {
                    num = userNameDiscriminator.discriminator;
                }
                return userNameDiscriminator.copy(str, num);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* renamed from: component2, reason: from getter */
            public final Integer getDiscriminator() {
                return this.discriminator;
            }

            public final UserNameDiscriminator copy(String username, Integer discriminator) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new UserNameDiscriminator(username, discriminator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UserNameDiscriminator)) {
                    return false;
                }
                UserNameDiscriminator userNameDiscriminator = (UserNameDiscriminator) other;
                return Intrinsics3.areEqual(this.username, userNameDiscriminator.username) && Intrinsics3.areEqual(this.discriminator, userNameDiscriminator.discriminator);
            }

            public final Integer getDiscriminator() {
                return this.discriminator;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                String str = this.username;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Integer num = this.discriminator;
                return iHashCode + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("UserNameDiscriminator(username=");
                sbM833U.append(this.username);
                sbM833U.append(", discriminator=");
                return outline.m818F(sbM833U, this.discriminator, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ UserNameDiscriminator access$extractUsernameAndDiscriminator(Companion companion, CharSequence charSequence) {
            return companion.extractUsernameAndDiscriminator(charSequence);
        }

        private final UserNameDiscriminator extractUsernameAndDiscriminator(CharSequence source) {
            List<String> groupValues;
            MatchResult matchResultMatchEntire = WidgetFriendsAddById.access$getPATTERN_USERNAME$cp().matchEntire(source);
            return (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || !(groupValues.isEmpty() ^ true)) ? new UserNameDiscriminator(source.toString(), null) : new UserNameDiscriminator(matchResultMatchEntire.getGroupValues().get(1), StringNumberConversions.toIntOrNull(matchResultMatchEntire.getGroupValues().get(2)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$1 */
    public static final class ViewOnClickListenerC83801 implements View.OnClickListener {
        public ViewOnClickListenerC83801() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAddById.extractTargetAndSendFriendRequest$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$2 */
    public static final class C83812 extends Lambda implements Function1<Editable, Unit> {
        public C83812() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            try {
                boolean z2 = true;
                if (editable.length() == 0) {
                    WidgetFriendsAddById.access$setInputEditError(WidgetFriendsAddById.this, null);
                }
                MaterialButton materialButton = WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).f16655d;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.friendsAddSend");
                if (editable.length() <= 0) {
                    z2 = false;
                }
                materialButton.setEnabled(z2);
            } catch (Exception unused) {
                AppLog appLog = AppLog.f14950g;
                StringBuilder sbM833U = outline.m833U("Detached: ");
                sbM833U.append(WidgetFriendsAddById.this.isDetached());
                sbM833U.append(" Visible: ");
                sbM833U.append(WidgetFriendsAddById.this.isVisible());
                Logger.e$default(appLog, "Failed to update views via TextWatcher", new Exception(sbM833U.toString()), null, 4, null);
            }
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$3 */
    public static final class C83823 extends Lambda implements Function1<TextView, Unit> {
        public C83823() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetFriendsAddById.extractTargetAndSendFriendRequest$default(WidgetFriendsAddById.this, null, 1, null);
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$4 */
    public static final class ViewOnClickListenerC83834 implements View.OnClickListener {
        public ViewOnClickListenerC83834() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$1 */
    public static final class C83841<T> implements Action1<Void> {
        public final /* synthetic */ String $username;

        public C83841(String str) {
            this.$username = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r8) {
            Context context = WidgetFriendsAddById.this.getContext();
            Context context2 = WidgetFriendsAddById.this.getContext();
            AppToast.m170h(context, context2 != null ? FormatUtils.m216h(context2, C5419R.string.add_friend_confirmation, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
            TextInputLayout textInputLayout = WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).f16656e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
            ViewExtensions.clear(textInputLayout);
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$2 */
    public static final class C83852<T> implements Action1<Error> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: WidgetFriendsAddById.kt */
        /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptcha4.isCaptchaError(error)) {
                    WidgetFriendsAddById widgetFriendsAddById = WidgetFriendsAddById.this;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetFriendsAddById.access$launchCaptchaFlow(widgetFriendsAddById, error2);
                    return;
                }
                WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).f16656e.setErrorTextAppearance(2131952238);
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetFriendsAddById.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                WidgetFriendsAddById.access$setInputEditError(WidgetFriendsAddById.this, String.valueOf(responseResolver.getRelationshipResponse(context, response.getCode(), C83852.this.$username + UserUtils.INSTANCE.padDiscriminator(C83852.this.$discriminator))));
            }
        }

        public C83852(String str, int i) {
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // p658rx.functions.Action1
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

    public WidgetFriendsAddById() {
        super(C5419R.layout.widget_friends_add_by_id);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsAddById2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsAddById3(this));
    }

    public static final /* synthetic */ void access$extractTargetAndSendFriendRequest(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaPayload);
    }

    public static final /* synthetic */ WidgetFriendsAddByIdBinding access$getBinding$p(WidgetFriendsAddById widgetFriendsAddById) {
        return widgetFriendsAddById.getBinding();
    }

    public static final /* synthetic */ Regex access$getPATTERN_USERNAME$cp() {
        return PATTERN_USERNAME;
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsAddById widgetFriendsAddById, Error error) {
        widgetFriendsAddById.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$setInputEditError(WidgetFriendsAddById widgetFriendsAddById, CharSequence charSequence) {
        widgetFriendsAddById.setInputEditError(charSequence);
    }

    private final void extractTargetAndSendFriendRequest(CaptchaHelper.CaptchaPayload captchaPayload) {
        TextInputLayout textInputLayout = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        Companion.UserNameDiscriminator userNameDiscriminatorAccess$extractUsernameAndDiscriminator = Companion.access$extractUsernameAndDiscriminator(INSTANCE, textOrEmpty);
        if (userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator() != null) {
            sendFriendRequest(userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator().intValue(), captchaPayload);
            return;
        }
        Context context = getContext();
        setInputEditError(context != null ? FormatUtils.m216h(context, C5419R.string.add_friend_error_username_only, new Object[]{userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername()}, null, 4) : null);
        AnalyticsTracker.INSTANCE.friendRequestFailed(textOrEmpty, userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator(), "Invalid Username");
    }

    public static /* synthetic */ void extractTargetAndSendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaPayload);
    }

    private final WidgetFriendsAddByIdBinding getBinding() {
        return (WidgetFriendsAddByIdBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SpannableStringBuilder getUsernameIndicatorText(User user) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence charSequenceM217i = FormatUtils.m217i(resources, C5419R.string.self_username_indicator, new Object[]{UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null)}, null, 4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceM217i);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) charSequenceM217i;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorHeaderPrimary)), spannableStringBuilder2.length() - UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null).length(), spannableStringBuilder2.length(), 33);
        return spannableStringBuilder;
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.INSTANCE.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.INSTANCE.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Search - Add Friend Search", username, discriminator, captchaPayload), this, null, 2, null).m11108k(C0879o.m181h(new C83841(username), getAppActivity(), new C83852(username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        widgetFriendsAddById.sendFriendRequest(str, i, captchaPayload);
    }

    private final void setInputEditError(CharSequence error) {
        TextInputLayout textInputLayout = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        textInputLayout.setError(error);
        TextInputLayout textInputLayout2 = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        textInputLayout2.setErrorEnabled(!(error == null || StringsJVM.isBlank(error)));
    }

    private final void setInputText(String text) {
        if (text == null || StringsJVM.isBlank(text)) {
            return;
        }
        TextInputLayout textInputLayout = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.setText(textInputLayout, text);
        TextInputLayout textInputLayout2 = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setSelectionEnd(textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void hideKeyboard(View view) {
        super.hideKeyboard(view);
        getBinding().f16656e.clearFocus();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AnalyticsTracker.INSTANCE.friendAddViewed("Id");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16655d.setOnClickListener(new ViewOnClickListenerC83801());
        TextInputLayout textInputLayout = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C83812());
        TextInputLayout textInputLayout2 = getBinding().f16656e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C83823(), 1, null);
        getBinding().f16654c.setOnClickListener(new ViewOnClickListenerC83834());
        Bundle extras = getMostRecentIntent().getExtras();
        setInputText(extras != null ? extras.getString("android.intent.extra.TEXT") : null);
        MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
        TextView textView = getBinding().f16653b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendAddUsernameIndicator");
        textView.setVisibility(0);
        TextView textView2 = getBinding().f16653b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendAddUsernameIndicator");
        textView2.setText(getUsernameIndicatorText(meSnapshot));
    }
}
