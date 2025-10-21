package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccountEmailEdit.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountEmailEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOULD_CONFIRM_EMAIL = "extra_should_confirm_email";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> nextScreenLauncher;
    private final StatefulViews state;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, boolean shouldConfirmEmail) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEdit.EXTRA_SHOULD_CONFIRM_EMAIL, shouldConfirmEmail);
            AppScreen2.d(context, WidgetSettingsAccountEmailEdit.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountEmailEdit.access$showCodeVerification(WidgetSettingsAccountEmailEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountEmailEdit.access$showCodeVerification(WidgetSettingsAccountEmailEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountEmailEdit.access$showPasswordVerification(WidgetSettingsAccountEmailEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountEmailEdit.access$showPasswordVerification(WidgetSettingsAccountEmailEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountEmailEdit.access$configureUI(WidgetSettingsAccountEmailEdit.this, meUser);
            new GoogleSmartLockManager(WidgetSettingsAccountEmailEdit.this.requireContext(), null, 2, null).getSmartLockRepo().setPendingIdChange(meUser.getEmail());
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$showCodeVerification$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r5) {
            WidgetSettingsAccountEmailEditConfirm.Companion companion = WidgetSettingsAccountEmailEditConfirm.INSTANCE;
            Context contextRequireContext = WidgetSettingsAccountEmailEdit.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getNextScreenLauncher$p = WidgetSettingsAccountEmailEdit.access$getNextScreenLauncher$p(WidgetSettingsAccountEmailEdit.this);
            TextInputLayout textInputLayout = WidgetSettingsAccountEmailEdit.access$getBinding$p(WidgetSettingsAccountEmailEdit.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
            companion.launch(contextRequireContext, activityResultLauncherAccess$getNextScreenLauncher$p, ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    public WidgetSettingsAccountEmailEdit() {
        super(R.layout.widget_settings_account_email_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountEmailEdit2.INSTANCE, null, 2, null);
        this.nextScreenLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEdit3(this));
        this.state = new StatefulViews(R.id.edit_account_email_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetSettingsAccountEmailEdit4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit, MeUser meUser) {
        widgetSettingsAccountEmailEdit.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetSettingsAccountEmailEditBinding access$getBinding$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getNextScreenLauncher$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.nextScreenLauncher;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.state;
    }

    public static final /* synthetic */ void access$showCodeVerification(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        widgetSettingsAccountEmailEdit.showCodeVerification();
    }

    public static final /* synthetic */ void access$showPasswordVerification(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        widgetSettingsAccountEmailEdit.showPasswordVerification();
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountEmailWrap");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), meUser.getEmail()));
    }

    private final WidgetSettingsAccountEmailEditBinding getBinding() {
        return (WidgetSettingsAccountEmailEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void showCodeVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null), getBinding().f2599b, 0L, 2, null).k(o.j(new AnonymousClass1(), requireContext(), null, 4));
        }
    }

    private final void showPasswordVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetUserPasswordVerify.Companion companion = WidgetUserPasswordVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextScreenLauncher;
            TextInputLayout textInputLayout = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(companion, contextRequireContext, activityResultLauncher, ViewExtensions.getTextOrEmpty(textInputLayout), null, null, null, 56, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_change_email_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        if (!getMostRecentIntent().getBooleanExtra(EXTRA_SHOULD_CONFIRM_EMAIL, false)) {
            TextInputLayout textInputLayout = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
            ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass3(), 1, null);
            getBinding().f.setOnClickListener(new AnonymousClass4());
            StatefulViews statefulViews = this.state;
            FloatingActionButton floatingActionButton = getBinding().f;
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountEmailWrap");
            statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
            return;
        }
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountEmailWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout3, false, new AnonymousClass1(), 1, null);
        getBinding().e.setOnClickListener(new AnonymousClass2());
        StatefulViews statefulViews2 = this.state;
        Button button = getBinding().e;
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountEmailWrap");
        statefulViews2.setupTextWatcherWithSaveAction(this, button, textInputLayout4);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.editAccountEmailDescription");
        linkifiedTextView.setVisibility(0);
        LinkifiedTextView linkifiedTextView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.editAccountEmailDescription");
        FormatUtils.n(linkifiedTextView2, R.string.user_settings_account_email_description, new Object[]{AppHelpDesk.c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
