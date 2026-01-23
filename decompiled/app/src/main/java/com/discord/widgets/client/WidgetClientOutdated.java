package com.discord.widgets.client;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClientOutdated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetClientOutdated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetClientOutdated.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetClientOutdated.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.client.WidgetClientOutdated$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetClientOutdated.kt */
    public static final class ViewOnClickListenerC82031 implements View.OnClickListener {
        public static final ViewOnClickListenerC82031 INSTANCE = new ViewOnClickListenerC82031();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            UriHandler.directToPlayStore$default(context, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.client.WidgetClientOutdated$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetClientOutdated.kt */
    public static final class C82042<R> implements Func0<Boolean> {
        public static final C82042 INSTANCE = new C82042();

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.TRUE;
        }
    }

    public WidgetClientOutdated() {
        super(C5419R.layout.widget_client_outdated);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetClientOutdated2.INSTANCE, null, 2, null);
    }

    private final WidgetClientOutdatedBinding getBinding() {
        return (WidgetClientOutdatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f16398b.setOnClickListener(ViewOnClickListenerC82031.INSTANCE);
        AppFragment.setOnBackPressed$default(this, C82042.INSTANCE, 0, 2, null);
    }
}
