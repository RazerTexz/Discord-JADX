package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetAuthAgeGated.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthAgeGated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthAgeGated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_UNDERAGE_MESSAGE = "INTENT_UNDERAGE_MESSAGE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetAuthAgeGated.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            Bundle bundle = new Bundle();
            bundle.putString(WidgetAuthAgeGated.INTENT_UNDERAGE_MESSAGE, message);
            AppScreen2.m156d(context, WidgetAuthAgeGated.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthAgeGated.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthAgeGated$onViewBound$1 */
    public static final class ViewOnClickListenerC71661 implements View.OnClickListener {
        public ViewOnClickListenerC71661() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthAgeGated.this.requireActivity().finish();
        }
    }

    public WidgetAuthAgeGated() {
        super(C5419R.layout.widget_auth_age_gated);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthAgeGated2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthAgeGated3.INSTANCE, 3);
    }

    private final WidgetAuthAgeGatedBinding getBinding() {
        return (WidgetAuthAgeGatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Age Gate Underage", "viewed", null, 4, null);
        getBinding().f15669b.setOnClickListener(new ViewOnClickListenerC71661());
    }
}
