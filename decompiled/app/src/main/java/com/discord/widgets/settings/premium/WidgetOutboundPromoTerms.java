package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms extends AppBottomSheet {
    private static final String ARG_CONTENT = "ARG_CONTENT";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetOutboundPromoTerms.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(String content, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(content, "content");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetOutboundPromoTerms widgetOutboundPromoTerms = new WidgetOutboundPromoTerms();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetOutboundPromoTerms.ARG_CONTENT, content);
            widgetOutboundPromoTerms.setArguments(bundle);
            widgetOutboundPromoTerms.show(fragmentManager, WidgetOutboundPromoTerms.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
    public static final class ViewOnClickListenerC99011 implements View.OnClickListener {
        public ViewOnClickListenerC99011() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetOutboundPromoTerms.this.dismiss();
        }
    }

    public WidgetOutboundPromoTerms() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetOutboundPromoTerms2.INSTANCE, null, 2, null);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        this.parser = parser.addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlRule()).addRules(SimpleMarkdownRules5.m372b(false, false, 3));
    }

    private final WidgetOutboundPromoTermsBinding getBinding() {
        return (WidgetOutboundPromoTermsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final UrlNode.RenderContext getRenderContext() {
        return new WidgetOutboundPromoTerms3(this);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_outbound_promo_terms;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17346b.setOnClickListener(new ViewOnClickListenerC99011());
        String string = getArgumentsOrDefault().getString(ARG_CONTENT, "");
        Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser = this.parser;
        Intrinsics3.checkNotNullExpressionValue(string, "content");
        getBinding().f17347c.setDraweeSpanStringBuilder(AstRenderer.render(Parser.parse$default(parser, string, MessageParseState.INSTANCE.getInitialState(), null, 4, null), getRenderContext()));
    }
}
