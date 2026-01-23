package com.discord.views.phone;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewPhoneOrEmailInputBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19276j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewPhoneOrEmailInputBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Mode mode;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public CharSequence email;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public CharSequence phone;

    /* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
    public enum Mode {
        ADAPTIVE,
        EMAIL,
        PHONE
    }

    /* JADX INFO: renamed from: com.discord.views.phone.PhoneOrEmailInputView$a */
    /* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
    public static final class C7116a extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function0 $onAfterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7116a(Function0 function0) {
            super(1);
            this.$onAfterTextChanged = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            this.$onAfterTextChanged.invoke();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.phone.PhoneOrEmailInputView$b */
    /* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
    public static final class C7117b extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function0 $onAfterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7117b(Function0 function0) {
            super(1);
            this.$onAfterTextChanged = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            PhoneOrEmailInputView phoneOrEmailInputView = PhoneOrEmailInputView.this;
            int i = PhoneOrEmailInputView.f19276j;
            phoneOrEmailInputView.m8601c();
            this.$onAfterTextChanged.invoke();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.phone.PhoneOrEmailInputView$c */
    /* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
    public static final class C7118c extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Fragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7118c(Fragment fragment) {
            super(1);
            this.$fragment = fragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetPhoneCountryCodeBottomSheet.Companion companion = WidgetPhoneCountryCodeBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = this.$fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            companion.show(parentFragmentManager);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.phone.PhoneOrEmailInputView$d */
    /* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
    public static final class C7119d extends Lambda implements Function1<Editable, Unit> {
        public C7119d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            PhoneOrEmailInputView phoneOrEmailInputView = PhoneOrEmailInputView.this;
            int i = PhoneOrEmailInputView.f19276j;
            phoneOrEmailInputView.m8604f();
            PhoneOrEmailInputView.this.m8601c();
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_phone_or_email_input, this);
        int i = C5419R.id.phone_or_email_country_code_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(C5419R.id.phone_or_email_country_code_wrap);
        if (textInputLayout != null) {
            i = C5419R.id.phone_or_email_main_input;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(C5419R.id.phone_or_email_main_input);
            if (textInputEditText != null) {
                i = C5419R.id.phone_or_email_main_input_wrap;
                TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(C5419R.id.phone_or_email_main_input_wrap);
                if (textInputLayout2 != null) {
                    ViewPhoneOrEmailInputBinding viewPhoneOrEmailInputBinding = new ViewPhoneOrEmailInputBinding(this, textInputLayout, textInputEditText, textInputLayout2);
                    Intrinsics3.checkNotNullExpressionValue(viewPhoneOrEmailInputBinding, "ViewPhoneOrEmailInputBin…ater.from(context), this)");
                    this.binding = viewPhoneOrEmailInputBinding;
                    Mode mode = Mode.ADAPTIVE;
                    this.mode = mode;
                    this.email = "";
                    this.phone = "";
                    setLayoutTransition(new LayoutTransition());
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.PhoneOrEmailInputView, 0, 0);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…neOrEmailInputView, 0, 0)");
                        try {
                            setHint(typedArrayObtainStyledAttributes.getString(1));
                            setMode(Mode.values()[typedArrayObtainStyledAttributes.getInt(0, mode.ordinal())]);
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
                            if (resourceId != -1) {
                                setMainInputNextFocusForwardId(resourceId);
                            }
                            return;
                        } finally {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final void setMainInputNextFocusForwardId(int id2) {
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setNextFocusForwardId(id2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8599a(Fragment fragment, Function0<Unit> onAfterTextChanged) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextInputLayout textInputLayout = this.binding.f1287b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, fragment, new C7116a(onAfterTextChanged));
        TextInputLayout textInputLayout2 = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new C7117b(onAfterTextChanged));
    }

    /* JADX INFO: renamed from: b */
    public final void m8600b(Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        TextInputLayout textInputLayout = this.binding.f1287b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new C7118c(fragment));
        TextInputLayout textInputLayout2 = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new C7119d());
        m8601c();
        m8602d();
    }

    /* JADX INFO: renamed from: c */
    public final void m8601c() {
        TextInputLayout textInputLayout = this.binding.f1287b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        textInputLayout.setVisibility(m8603e() ? 0 : 8);
    }

    /* JADX INFO: renamed from: d */
    public final void m8602d() {
        if (this.mode.ordinal() != 2) {
            TextInputEditText textInputEditText = this.binding.f1288c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
            textInputEditText.setInputType(32);
            if (Build.VERSION.SDK_INT >= 26) {
                this.binding.f1288c.setAutofillHints(new String[]{"emailAddress"});
            }
            TextInputLayout textInputLayout = this.binding.f1289d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            ViewExtensions.setText(textInputLayout, this.email);
            this.binding.f1288c.setSelection(this.email.length());
            return;
        }
        TextInputEditText textInputEditText2 = this.binding.f1288c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.phoneOrEmailMainInput");
        textInputEditText2.setInputType(3);
        if (Build.VERSION.SDK_INT >= 26) {
            this.binding.f1288c.setAutofillHints(new String[]{"phone"});
        }
        TextInputLayout textInputLayout2 = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout2, this.phone);
        this.binding.f1288c.setSelection(this.phone.length());
    }

    /* JADX INFO: renamed from: e */
    public final boolean m8603e() {
        int iOrdinal = this.mode.ordinal();
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal == 2) {
            return true;
        }
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return phoneUtils.isLikelyToContainPhoneNumber(ViewExtensions.getTextOrEmpty(textInputLayout));
    }

    /* JADX INFO: renamed from: f */
    public final void m8604f() {
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (this.mode == Mode.PHONE || PhoneUtils.INSTANCE.isLikelyToContainPhoneNumber(textOrEmpty)) {
            this.phone = textOrEmpty;
        } else {
            this.email = textOrEmpty;
        }
    }

    public final TextInputEditText getMainEditText() {
        TextInputEditText textInputEditText = this.binding.f1288c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
        return textInputEditText;
    }

    public final TextInputLayout getMainTextInputLayout() {
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return textInputLayout;
    }

    public final String getTextOrEmpty() {
        if (!m8603e()) {
            TextInputLayout textInputLayout = this.binding.f1289d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            return ViewExtensions.getTextOrEmpty(textInputLayout);
        }
        StringBuilder sb = new StringBuilder();
        TextInputLayout textInputLayout2 = this.binding.f1287b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailCountryCodeWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout2));
        TextInputLayout textInputLayout3 = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.phoneOrEmailMainInputWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout3));
        return sb.toString();
    }

    public final void setCountryCode(PhoneCountryCode countryCode) {
        Intrinsics3.checkNotNullParameter(countryCode, "countryCode");
        TextInputLayout textInputLayout = this.binding.f1287b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setText(textInputLayout, countryCode.getPhoneCountryCode());
    }

    public final void setHint(CharSequence hint) {
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setHint(hint);
    }

    public final void setMode(Mode mode) {
        Intrinsics3.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        m8601c();
        m8602d();
    }

    public final void setText(CharSequence text) {
        TextInputLayout textInputLayout = this.binding.f1289d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout, text);
        m8604f();
    }
}
