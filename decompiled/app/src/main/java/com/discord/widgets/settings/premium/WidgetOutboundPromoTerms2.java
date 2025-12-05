package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetOutboundPromoTerms.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetOutboundPromoTerms2 extends FunctionReferenceImpl implements Function1<View, WidgetOutboundPromoTermsBinding> {
    public static final WidgetOutboundPromoTerms2 INSTANCE = new WidgetOutboundPromoTerms2();

    public WidgetOutboundPromoTerms2() {
        super(1, WidgetOutboundPromoTermsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetOutboundPromoTermsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetOutboundPromoTermsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.promoTermsClose;
        TextView textView = (TextView) view.findViewById(C5419R.id.promoTermsClose);
        if (textView != null) {
            i = C5419R.id.promoTermsContent;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.promoTermsContent);
            if (linkifiedTextView != null) {
                return new WidgetOutboundPromoTermsBinding((LinearLayout) view, textView, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
