package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.app.AppDialog;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.WidgetEnableTwoFactorPasswordDialogBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* renamed from: b.a.a.s, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetEnableTwoFactorPasswordDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f428j = {outline.m846d0(WidgetEnableTwoFactorPasswordDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public Function1<? super String, Unit> onValidPasswordEntered;

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetEnableTwoFactorPasswordDialogBinding> {

        /* renamed from: j */
        public static final b f432j = new b();

        public b() {
            super(1, WidgetEnableTwoFactorPasswordDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetEnableTwoFactorPasswordDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.enable_two_factor_password_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.enable_two_factor_password_body_container);
            if (linearLayout != null) {
                i = C5419R.id.enable_two_factor_password_body_text;
                TextView textView = (TextView) view2.findViewById(C5419R.id.enable_two_factor_password_body_text);
                if (textView != null) {
                    i = C5419R.id.enable_two_factor_password_cancel;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.enable_two_factor_password_cancel);
                    if (materialButton != null) {
                        i = C5419R.id.enable_two_factor_password_header;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.enable_two_factor_password_header);
                        if (textView2 != null) {
                            i = C5419R.id.enable_two_factor_password_header_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C5419R.id.enable_two_factor_password_header_container);
                            if (linearLayout2 != null) {
                                i = C5419R.id.enable_two_factor_password_ok;
                                LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.enable_two_factor_password_ok);
                                if (loadingButton != null) {
                                    i = C5419R.id.enable_two_factor_password_view_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(C5419R.id.enable_two_factor_password_view_input);
                                    if (textInputLayout != null) {
                                        return new WidgetEnableTwoFactorPasswordDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$c */
    public static final class c extends Lambda implements Function1<String, Unit> {

        /* renamed from: j */
        public static final c f433j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$d */
    public static final class d implements View.OnClickListener {

        /* renamed from: k */
        public final /* synthetic */ View f435k;

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        /* renamed from: b.a.a.s$d$a */
        public static final class a extends Lambda implements Function1<EnableMfaResponse, Unit> {

            /* renamed from: j */
            public static final a f436j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EnableMfaResponse enableMfaResponse) {
                Intrinsics3.checkNotNullParameter(enableMfaResponse, "it");
                return Unit.f27425a;
            }
        }

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        /* renamed from: b.a.a.s$d$b */
        public static final class b extends Lambda implements Function1<Error, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Error error) {
                Error error2 = error;
                Intrinsics3.checkNotNullParameter(error2, "error");
                WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
                KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.f428j;
                widgetEnableTwoFactorPasswordDialog.m144g().f933c.setIsLoading(false);
                Error.Response response = error2.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 60005) {
                    error2.setShowErrorToasts(false);
                    WidgetEnableTwoFactorPasswordDialog.this.dismiss();
                    WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog2 = WidgetEnableTwoFactorPasswordDialog.this;
                    Function1<? super String, Unit> function1 = widgetEnableTwoFactorPasswordDialog2.onValidPasswordEntered;
                    TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog2.m144g().f934d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
                    function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
                }
                return Unit.f27425a;
            }
        }

        public d(View view) {
            this.f435k = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
            KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.f428j;
            TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog.m144g().f934d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            WidgetEnableTwoFactorPasswordDialog.this.m144g().f933c.setIsLoading(true);
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableMFA(new RestAPIParams.EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), WidgetEnableTwoFactorPasswordDialog.this, null, 2, null);
            a aVar = a.f436j;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, WidgetEnableTwoFactorPasswordDialog.this.getClass(), this.f435k.getContext(), (Function1) null, new b(), (Function0) null, (Function0) null, aVar, 52, (Object) null);
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$e */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetEnableTwoFactorPasswordDialog.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public WidgetEnableTwoFactorPasswordDialog() {
        super(C5419R.layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f432j, null, 2, null);
        this.onValidPasswordEntered = c.f433j;
    }

    /* renamed from: g */
    public final WidgetEnableTwoFactorPasswordDialogBinding m144g() {
        return (WidgetEnableTwoFactorPasswordDialogBinding) this.binding.getValue((Fragment) this, f428j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        m144g().f933c.setIsLoading(false);
        m144g().f933c.setOnClickListener(new d(view));
        m144g().f932b.setOnClickListener(new e());
    }
}
