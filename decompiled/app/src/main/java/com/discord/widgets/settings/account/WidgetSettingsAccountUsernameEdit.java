package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.MultiValuePropPremiumUpsellDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAccountUsernameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final StatefulViews state;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsAccountUsernameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$configureUI$1 */
    public static final class ViewOnFocusChangeListenerC97691 implements View.OnFocusChangeListener {

        /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
        /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f17831b.clearFocus();
            }
        }

        public ViewOnFocusChangeListenerC97691() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (z2) {
                WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f17831b.post(new AnonymousClass1());
                MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccountUsernameEdit.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                MultiValuePropPremiumUpsellDialog.Companion.m114a(companion, parentFragmentManager, 0, WidgetSettingsAccountUsernameEdit.this.getString(C5419R.string.premium_upsell_tag_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "Edit Account", null, null, false, false, 968);
            }
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$1 */
    public static final class C97701 extends Lambda implements Function1<Editable, Unit> {
        public C97701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f17831b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$2 */
    public static final class C97712 extends Lambda implements Function1<TextView, Unit> {
        public C97712() {
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
            WidgetSettingsAccountUsernameEdit.access$showPasswordVerification(WidgetSettingsAccountUsernameEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$3 */
    public static final class ViewOnClickListenerC97723 implements View.OnClickListener {
        public ViewOnClickListenerC97723() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountUsernameEdit.access$showPasswordVerification(WidgetSettingsAccountUsernameEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBoundOrOnResume$1 */
    public static final class C97731 extends Lambda implements Function1<MeUser, Unit> {
        public C97731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountUsernameEdit.access$configureUI(WidgetSettingsAccountUsernameEdit.this, meUser);
        }
    }

    public WidgetSettingsAccountUsernameEdit() {
        super(C5419R.layout.widget_settings_account_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountUsernameEdit2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountUsernameEdit3(this));
        this.state = new StatefulViews(C5419R.id.edit_account_username_wrap, C5419R.id.edit_account_discriminator_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetSettingsAccountUsernameEdit4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit, MeUser meUser) {
        widgetSettingsAccountUsernameEdit.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetSettingsAccountEditBinding access$getBinding$p(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        return widgetSettingsAccountUsernameEdit.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        return widgetSettingsAccountUsernameEdit.state;
    }

    public static final /* synthetic */ void access$showPasswordVerification(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        widgetSettingsAccountUsernameEdit.showPasswordVerification();
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().f17832c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f17832c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountUsernameWrap");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), meUser.getUsername()));
        TextInputLayout textInputLayout3 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountDiscriminatorWrap");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        int id2 = textInputLayout4.getId();
        String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(meUser.getDiscriminator())}, 1));
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, str));
        TextInputLayout textInputLayout5 = getBinding().f17832c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editAccountUsernameWrap");
        EditText editText = textInputLayout5.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        TextInputLayout textInputLayout6 = getBinding().f17832c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.editAccountUsernameWrap");
        Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout6).length());
        boolean zGrantsAccessToCustomTagAndAnimatedAvatarFeatures = PremiumUtils3.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
        TextInputLayout textInputLayout7 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.editAccountDiscriminatorWrap");
        textInputLayout7.setLongClickable(zGrantsAccessToCustomTagAndAnimatedAvatarFeatures);
        if (zGrantsAccessToCustomTagAndAnimatedAvatarFeatures) {
            return;
        }
        TextInputLayout textInputLayout8 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout8, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout8, new ViewOnFocusChangeListenerC97691());
    }

    private final WidgetSettingsAccountEditBinding getBinding() {
        return (WidgetSettingsAccountEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void showPasswordVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetUserPasswordVerify.Companion companion = WidgetUserPasswordVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.passwordVerifyLauncher;
            TextInputLayout textInputLayout = getBinding().f17832c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            TextInputLayout textInputLayout2 = getBinding().f17831b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(companion, contextRequireContext, activityResultLauncher, null, textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout2), null, 36, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_account_change_username_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C97701());
        TextInputLayout textInputLayout2 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C97712(), 1, null);
        getBinding().f17833d.setOnClickListener(new ViewOnClickListenerC97723());
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f17833d;
        TextInputLayout textInputLayout3 = getBinding().f17832c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountUsernameWrap");
        TextInputLayout textInputLayout4 = getBinding().f17831b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3, textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountUsernameEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97731(), 62, (Object) null);
    }
}
