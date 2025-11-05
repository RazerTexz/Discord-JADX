package b.a.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ConnectedAccountActionsDialog.kt */
/* loaded from: classes.dex */
public final class i extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(i.class, "binding", "getBinding()Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Object l;

        public a(int i, Object obj, Object obj2) {
            this.j = i;
            this.k = obj;
            this.l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context contextRequireContext = ((i) this.k).requireContext();
                d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                UriHandler.handle$default(uriHandler, contextRequireContext, (String) this.l, false, false, null, 28, null);
                ((i) this.k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            Context contextRequireContext2 = ((i) this.k).requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            String str = (String) this.l;
            d0.z.d.m.checkNotNullExpressionValue(str, "username");
            b.a.d.m.a(contextRequireContext2, str, R.string.copied_text);
            ((i) this.k).dismiss();
        }
    }

    /* compiled from: ConnectedAccountActionsDialog.kt */
    /* renamed from: b.a.a.i$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: ConnectedAccountActionsDialog.kt */
    public static final /* synthetic */ class c extends d0.z.d.k implements Function1<View, b.a.i.h> {
        public static final c j = new c();

        public c() {
            super(1, b.a.i.h.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.h invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.connected_account_actions_dialog_copy_username;
            TextView textView = (TextView) view2.findViewById(R.id.connected_account_actions_dialog_copy_username);
            if (textView != null) {
                i = R.id.connected_account_actions_dialog_header;
                TextView textView2 = (TextView) view2.findViewById(R.id.connected_account_actions_dialog_header);
                if (textView2 != null) {
                    i = R.id.connected_account_actions_dialog_open_in_browser;
                    TextView textView3 = (TextView) view2.findViewById(R.id.connected_account_actions_dialog_open_in_browser);
                    if (textView3 != null) {
                        return new b.a.i.h((LinearLayout) view2, textView, textView2, textView3);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public i() {
        super(R.layout.connected_account_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
    }

    public final b.a.i.h g() {
        return (b.a.i.h) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String string = getArgumentsOrDefault().getString("ARG_PROFILE_URL", "");
        String string2 = getArgumentsOrDefault().getString("ARG_USERNAME", "");
        int i = getArgumentsOrDefault().getInt("ARG_THEMED_PLATFORM_IMAGE_RES", 0);
        if (i != 0) {
            TextView textView = g().c;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.connectedAccountActionsDialogHeader");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(view, i, 0, 2, (Object) null), 0, 0, 0, 14, null);
        }
        TextView textView2 = g().c;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.connectedAccountActionsDialogHeader");
        textView2.setText(string2);
        TextView textView3 = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.connectedAccountActionsDialogOpenInBrowser");
        textView3.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        g().d.setOnClickListener(new a(0, this, string));
        g().f123b.setOnClickListener(new a(1, this, string2));
    }
}
