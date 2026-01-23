package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserPhoneManage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final ActivityResultLauncher<Intent> phoneVerificationLauncher;
    private String source;

    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
        public enum Source {
            USER_ACTION_REQUIRED("user_action_required"),
            USER_SETTINGS_UPDATE("user_settings_update"),
            GUILD_PHONE_REQUIRED("guild_phone_required"),
            MFA_PHONE_UPDATE("mfa_phone_update"),
            CONTACT_SYNC("contact_sync"),
            DEFAULT("update_phone");

            private final String source;

            Source(String str) {
                this.source = str;
            }

            public final String getSource() {
                return this.source;
            }
        }

        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, Source source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intrinsics3.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra("intent_args_key", source.getSource());
            AppScreen2.m156d(context, WidgetUserPhoneManage.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102591 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102591(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PhoneCountryCode invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102602 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public C102602() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            WidgetUserPhoneManage.access$getBinding$p(WidgetUserPhoneManage.this).f18353f.setCountryCode(phoneCountryCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102613 extends Lambda implements Function0<Unit> {
        public C102613() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserPhoneManage.access$handlePhoneNumberTextChanged(WidgetUserPhoneManage.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class ViewOnClickListenerC102624 implements View.OnClickListener {
        public ViewOnClickListenerC102624() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPhoneManage.updatePhoneNumber$default(WidgetUserPhoneManage.this, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class ViewOnClickListenerC102635 implements View.OnClickListener {
        public ViewOnClickListenerC102635() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPhoneManage.access$removePhoneNumber(WidgetUserPhoneManage.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102641 extends Lambda implements Function1<MeUser, Unit> {
        public C102641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetUserPhoneManage.access$configureUI(WidgetUserPhoneManage.this, meUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$removePhoneNumber$1 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102651 extends Lambda implements Function1<View, Unit> {
        public C102651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.access$getPasswordVerifyLauncher$p(WidgetUserPhoneManage.this));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$1 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102661 extends Lambda implements Function1<Error, Unit> {
        public C102661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
                Context contextRequireContext = WidgetUserPhoneManage.this.requireContext();
                ActivityResultLauncher<Intent> activityResultLauncherAccess$getCaptchaLauncher$p = WidgetUserPhoneManage.access$getCaptchaLauncher$p(WidgetUserPhoneManage.this);
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncherAccess$getCaptchaLauncher$p, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$2 */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class C102672 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $phoneNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102672(String str) {
            super(1);
            this.$phoneNumber = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetUserPhoneVerify.INSTANCE.launch(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.access$getPhoneVerificationLauncher$p(WidgetUserPhoneManage.this), WidgetUserPhoneManage.access$getMode$p(WidgetUserPhoneManage.this), this.$phoneNumber, WidgetUserPhoneManage.access$getSource$p(WidgetUserPhoneManage.this));
        }
    }

    public WidgetUserPhoneManage() {
        super(C5419R.layout.widget_user_phone_manage);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPhoneManage2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage4(this));
        this.phoneVerificationLauncher = WidgetUserPhoneVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage5(this));
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetUserPhoneManage3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserPhoneManage widgetUserPhoneManage, MeUser meUser) {
        widgetUserPhoneManage.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetUserPhoneManageBinding access$getBinding$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.captchaLauncher;
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getMode();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.passwordVerifyLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerificationLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.phoneVerificationLauncher;
    }

    public static final /* synthetic */ String access$getSource$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        String str = widgetUserPhoneManage.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        return str;
    }

    public static final /* synthetic */ void access$handlePhoneNumberTextChanged(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.handlePhoneNumberTextChanged();
    }

    public static final /* synthetic */ void access$removePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.removePhoneNumber();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneManage widgetUserPhoneManage, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserPhoneManage.setMode(mode);
    }

    public static final /* synthetic */ void access$setSource$p(WidgetUserPhoneManage widgetUserPhoneManage, String str) {
        widgetUserPhoneManage.source = str;
    }

    public static final /* synthetic */ void access$updatePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetUserPhoneManage.updatePhoneNumber(captchaPayload);
    }

    private final void configureUI(MeUser meUser) {
        if (meUser.getPhoneNumber() != null) {
            getBinding().f18354g.setText(C5419R.string.phone_verification_update_title);
            TextView textView = getBinding().f18351d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userPhoneAddDescriptionNote");
            FormatUtils.m222n(textView, C5419R.string.phone_verification_current_phone, new Object[]{meUser.getPhoneNumber()}, null, 4);
            TextView textView2 = getBinding().f18350c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.removePhone");
            textView2.setVisibility(0);
        } else {
            getBinding().f18354g.setText(C5419R.string.enter_phone_title);
            getBinding().f18351d.setText(C5419R.string.enter_phone_description);
            TextView textView3 = getBinding().f18350c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.removePhone");
            textView3.setVisibility(8);
        }
        if (meUser.getEmail() == null) {
            TextView textView4 = getBinding().f18350c;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.removePhone");
            textView4.setVisibility(8);
        }
    }

    private final WidgetUserPhoneManageBinding getBinding() {
        return (WidgetUserPhoneManageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f18353f.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f18352e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.userPhoneAddNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && StringsJVM.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void removePhoneNumber() {
        if (!UserUtils.INSTANCE.isMfaSMSEnabled(StoreStream.INSTANCE.getUsers().getMeSnapshot())) {
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(requireContext(), this.passwordVerifyLauncher);
            return;
        }
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence charSequenceM217i = FormatUtils.m217i(resources, C5419R.string.user_settings_account_remove_phone_number_warning_title, new Object[0], null, 4);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence charSequenceM217i2 = FormatUtils.m217i(resources2, C5419R.string.user_settings_account_remove_phone_number_warning_body, new Object[0], null, 4);
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        CharSequence charSequenceM217i3 = FormatUtils.m217i(resources3, C5419R.string.remove, new Object[0], null, 4);
        Resources resources4 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, charSequenceM217i, charSequenceM217i2, charSequenceM217i3, FormatUtils.m217i(resources4, C5419R.string.cancel, new Object[0], null, 4), MapsJVM.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C102651())), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void updatePhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f18353f.getTextOrEmpty();
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.userAddPhone(new RestAPIParams.Phone(textOrEmpty, str, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), getBinding().f18349b, 0L, 2, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, new C102661(), (Function0) null, (Function0) null, new C102672(textOrEmpty), 54, (Object) null);
    }

    public static /* synthetic */ void updatePhoneNumber$default(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetUserPhoneManage.updatePhoneNumber(captchaPayload);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(!isForced(), Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(view, C5419R.attr.ic_action_bar_close, 0, 2, (Object) null)), !isForced() ? Integer.valueOf(C5419R.string.close) : null);
        this.source = IntentUtilsKt.getStringExtraOrDefault(getMostRecentIntent(), "intent_args_key", Companion.Source.DEFAULT.getSource());
        getBinding().f18353f.m8600b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new C102591(phone), 14, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C102602(), 62, (Object) null);
        getBinding().f18353f.m8599a(this, new C102613());
        getBinding().f18352e.setOnClickListener(new ViewOnClickListenerC102624());
        getBinding().f18350c.setOnClickListener(new ViewOnClickListenerC102635());
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C102641(), 62, (Object) null);
    }
}
