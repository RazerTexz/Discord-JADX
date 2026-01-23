package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.DatePickerDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthBirthday.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RESULT_EXTRA_BIRTHDAY = "RESULT_EXTRA_BIRTHDAY";
    private static final String VALIDATOR_DATE_OF_BIRTH = "dateOfBirth";
    private static final String VALIDATOR_TOS = "tos";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final DateFormat formatter;
    private boolean isConsentRequired;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetAuthBirthday.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            AppScreen2.f524g.m160f(context, launcher, WidgetAuthBirthday.class, null);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Long, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthBirthday2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ay)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetAuthBirthday.kt */
    public static final class C71671 extends Lambda implements Function1<View, Unit> {
        public C71671() {
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
            DatePickerDialog.Companion companion = DatePickerDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAuthBirthday.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String string = WidgetAuthBirthday.this.getString(C5419R.string.age_gate_date_of_birth);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.age_gate_date_of_birth)");
            Long lAccess$getBirthday = WidgetAuthBirthday.access$getBirthday(WidgetAuthBirthday.this);
            companion.m139a(parentFragmentManager, string, lAccess$getBirthday != null ? lAccess$getBirthday.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAuthBirthday4(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetAuthBirthday.kt */
    public static final class ViewOnClickListenerC71692 implements View.OnClickListener {
        public ViewOnClickListenerC71692() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthBirthday.this.submit();
        }
    }

    public WidgetAuthBirthday() {
        super(C5419R.layout.widget_auth_birthday);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthBirthday3.INSTANCE, null, 2, null);
        this.isConsentRequired = true;
        this.formatter = DateFormat.getDateInstance(3);
        this.validationManager = LazyJVM.lazy(new WidgetAuthBirthday5(this));
    }

    public static final /* synthetic */ WidgetAuthBirthdayBinding access$getBinding$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBinding();
    }

    public static final /* synthetic */ Long access$getBirthday(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBirthday();
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.isConsentRequired;
    }

    public static final /* synthetic */ void access$setBirthday(WidgetAuthBirthday widgetAuthBirthday, long j) {
        widgetAuthBirthday.setBirthday(j);
    }

    public static final /* synthetic */ void access$setConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday, boolean z2) {
        widgetAuthBirthday.isConsentRequired = z2;
    }

    private final WidgetAuthBirthdayBinding getBinding() {
        return (WidgetAuthBirthdayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getBirthday() {
        try {
            DateFormat dateFormat = this.formatter;
            TextInputLayout textInputLayout = getBinding().f15672c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
            Date date = dateFormat.parse(ViewExtensions.getTextOrEmpty(textInputLayout));
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (ParseException unused) {
            return null;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void setBirthday(long date) {
        String str = this.formatter.format(Long.valueOf(date));
        TextInputLayout textInputLayout = getBinding().f15672c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Age Gate", "viewed", null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        DateFormat dateFormat = this.formatter;
        Intrinsics3.checkNotNullExpressionValue(dateFormat, "formatter");
        dateFormat.setTimeZone(calendar.getTimeZone());
        this.isConsentRequired = StoreStream.INSTANCE.getAuthentication().isConsentRequired();
        MaterialCheckBox materialCheckBox = getBinding().f15674e;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f15671b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
        FormatUtils.m222n(linkifiedTextView, this.isConsentRequired ? C5419R.string.terms_privacy_opt_in : C5419R.string.terms_privacy, new Object[]{getString(C5419R.string.terms_of_service_url), getString(C5419R.string.privacy_policy_url)}, null, 4);
        TextInputLayout textInputLayout = getBinding().f15672c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new C71671());
        getBinding().f15673d.setOnClickListener(new ViewOnClickListenerC71692());
    }

    public final void submit() {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "submitted", null, 4, null);
        if (!ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        Intent intent = new Intent();
        intent.putExtra(RESULT_EXTRA_BIRTHDAY, getBirthday());
        requireActivity().setResult(-1, intent);
        requireActivity().onBackPressed();
    }
}
