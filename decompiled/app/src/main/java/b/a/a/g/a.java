package b.a.a.g;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.q5;
import b.a.k.b;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMaskedLinksDialog.kt */
/* loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.g.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0026a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Object l;

        public ViewOnClickListenerC0026a(int i, Object obj, Object obj2) {
            this.j = i;
            this.k = obj;
            this.l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                a aVar = (a) this.k;
                m.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "v.context");
                String str = (String) this.l;
                KProperty[] kPropertyArr = a.j;
                aVar.h(context, str);
                return;
            }
            if (i != 1) {
                throw null;
            }
            a aVar2 = (a) this.k;
            m.checkNotNullExpressionValue(view, "v");
            Context context2 = view.getContext();
            m.checkNotNullExpressionValue(context2, "v.context");
            String str2 = (String) this.l;
            KProperty[] kPropertyArr2 = a.j;
            Objects.requireNonNull(aVar2);
            StoreStream.INSTANCE.getMaskedLinks().trustDomain(str2);
            aVar2.h(context2, str2);
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    /* renamed from: b.a.a.g.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    public static final /* synthetic */ class c extends k implements Function1<View, q5> {
        public static final c j = new c();

        public c() {
            super(1, q5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public q5 invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.masked_links_body_text;
            TextView textView = (TextView) view2.findViewById(R.id.masked_links_body_text);
            if (textView != null) {
                i = R.id.masked_links_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.masked_links_cancel);
                if (materialButton != null) {
                    i = R.id.masked_links_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.masked_links_confirm);
                    if (materialButton2 != null) {
                        i = R.id.masked_links_trust_domain;
                        TextView textView2 = (TextView) view2.findViewById(R.id.masked_links_trust_domain);
                        if (textView2 != null) {
                            i = R.id.view_dialog_confirmation_header;
                            TextView textView3 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                            if (textView3 != null) {
                                return new q5((LinearLayout) view2, textView, materialButton, materialButton2, textView2, textView3);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.dismiss();
        }
    }

    public a() {
        super(R.layout.widget_masked_links_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
    }

    public final q5 g() {
        return (q5) this.binding.getValue((Fragment) this, j[0]);
    }

    public final void h(Context context, String url) {
        UriHandler.handle$default(UriHandler.INSTANCE, context, url, false, false, null, 28, null);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        Objects.requireNonNull(INSTANCE);
        StoreNotices.markSeen$default(notices, "WIDGET_SPOOPY_LINKS_DIALOG", 0L, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        String string;
        Object punyCodeASCIIUrl;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("WIDGET_SPOOPY_LINKS_DIALOG_URL")) == null) {
            string = "";
        }
        m.checkNotNullExpressionValue(string, "arguments?.getString(DIALOG_URL) ?: \"\"");
        try {
            punyCodeASCIIUrl = StringUtilsKt.toPunyCodeASCIIUrl(string);
        } catch (Exception unused) {
            dismiss();
            punyCodeASCIIUrl = Unit.a;
        }
        TextView textView = g().f188b;
        m.checkNotNullExpressionValue(textView, "binding.maskedLinksBodyText");
        b.n(textView, R.string.masked_link_body, new Object[]{punyCodeASCIIUrl}, null, 4);
        g().c.setOnClickListener(new d());
        g().d.setOnClickListener(new ViewOnClickListenerC0026a(0, this, string));
        g().e.setOnClickListener(new ViewOnClickListenerC0026a(1, this, string));
    }
}
