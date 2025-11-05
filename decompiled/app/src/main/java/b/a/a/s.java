package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.i.h5;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.app.AppDialog;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* loaded from: classes.dex */
public final class s extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(s.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};

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
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, h5> {
        public static final b j = new b();

        public b() {
            super(1, h5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public h5 invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.enable_two_factor_password_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_body_container);
            if (linearLayout != null) {
                i = R.id.enable_two_factor_password_body_text;
                TextView textView = (TextView) view2.findViewById(R.id.enable_two_factor_password_body_text);
                if (textView != null) {
                    i = R.id.enable_two_factor_password_cancel;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.enable_two_factor_password_cancel);
                    if (materialButton != null) {
                        i = R.id.enable_two_factor_password_header;
                        TextView textView2 = (TextView) view2.findViewById(R.id.enable_two_factor_password_header);
                        if (textView2 != null) {
                            i = R.id.enable_two_factor_password_header_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_header_container);
                            if (linearLayout2 != null) {
                                i = R.id.enable_two_factor_password_ok;
                                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.enable_two_factor_password_ok);
                                if (loadingButton != null) {
                                    i = R.id.enable_two_factor_password_view_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R.id.enable_two_factor_password_view_input);
                                    if (textInputLayout != null) {
                                        return new h5((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
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
    public static final class c extends d0.z.d.o implements Function1<String, Unit> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            d0.z.d.m.checkNotNullParameter(str, "it");
            return Unit.a;
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ View k;

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class a extends d0.z.d.o implements Function1<EnableMfaResponse, Unit> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EnableMfaResponse enableMfaResponse) {
                d0.z.d.m.checkNotNullParameter(enableMfaResponse, "it");
                return Unit.a;
            }
        }

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class b extends d0.z.d.o implements Function1<Error, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Error error) {
                Error error2 = error;
                d0.z.d.m.checkNotNullParameter(error2, "error");
                s sVar = s.this;
                KProperty[] kPropertyArr = s.j;
                sVar.g().c.setIsLoading(false);
                Error.Response response = error2.getResponse();
                d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 60005) {
                    error2.setShowErrorToasts(false);
                    s.this.dismiss();
                    s sVar2 = s.this;
                    Function1<? super String, Unit> function1 = sVar2.onValidPasswordEntered;
                    TextInputLayout textInputLayout = sVar2.g().d;
                    d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
                    function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
                }
                return Unit.a;
            }
        }

        public d(View view) {
            this.k = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            s sVar = s.this;
            KProperty[] kPropertyArr = s.j;
            TextInputLayout textInputLayout = sVar.g().d;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            s.this.g().c.setIsLoading(true);
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableMFA(new RestAPIParams.EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), s.this, null, 2, null);
            a aVar = a.j;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, s.this.getClass(), this.k.getContext(), (Function1) null, new b(), (Function0) null, (Function0) null, aVar, 52, (Object) null);
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = s.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public s() {
        super(R.layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
        this.onValidPasswordEntered = c.j;
    }

    public final h5 g() {
        return (h5) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        g().c.setIsLoading(false);
        g().c.setOnClickListener(new d(view));
        g().f129b.setOnClickListener(new e());
    }
}
