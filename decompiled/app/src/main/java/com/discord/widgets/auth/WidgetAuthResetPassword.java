package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetAuthResetPassword.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthResetPassword extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthResetPassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_TOKEN = "INTENT_EXTRA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String token;

    /* compiled from: WidgetAuthResetPassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String token) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(token, "token");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthResetPassword.INTENT_EXTRA_TOKEN, token);
            AppScreen2.m156d(context, WidgetAuthResetPassword.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthResetPassword.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthResetPassword$onViewBound$1 */
    public static final class ViewOnClickListenerC72371 implements View.OnClickListener {
        public ViewOnClickListenerC72371() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = WidgetAuthResetPassword.this.requireContext();
            StringBuilder sbM833U = outline.m833U("https://discord.com/reset#token=");
            sbM833U.append(WidgetAuthResetPassword.access$getToken$p(WidgetAuthResetPassword.this));
            UriHandler.handle$default(uriHandler, contextRequireContext, sbM833U.toString(), false, false, null, 28, null);
            WidgetAuthResetPassword.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetAuthResetPassword.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthResetPassword$onViewBound$2 */
    public static final class ViewOnClickListenerC72382 implements View.OnClickListener {
        public ViewOnClickListenerC72382() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthResetPassword.this.requireActivity().finish();
        }
    }

    public WidgetAuthResetPassword() {
        super(C5419R.layout.widget_auth_reset_password);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthResetPassword2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ String access$getToken$p(WidgetAuthResetPassword widgetAuthResetPassword) {
        String str = widgetAuthResetPassword.token;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("token");
        }
        return str;
    }

    public static final /* synthetic */ void access$setToken$p(WidgetAuthResetPassword widgetAuthResetPassword, String str) {
        widgetAuthResetPassword.token = str;
    }

    private final WidgetAuthResetPasswordBinding getBinding() {
        return (WidgetAuthResetPasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_TOKEN);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.token = stringExtra;
        getBinding().f15718c.setOnClickListener(new ViewOnClickListenerC72371());
        getBinding().f15717b.setOnClickListener(new ViewOnClickListenerC72382());
    }
}
