package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.C5419R;
import com.discord.utilities.textprocessing.node.UrlNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetOutboundPromoTerms.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms3 implements UrlNode.RenderContext {
    private final Context context;
    private final int linkColorAttrResId;
    private final Function3<Context, String, String, Unit> onClickUrl = WidgetOutboundPromoTerms4.INSTANCE;
    private final Function1<String, Unit> onLongPressUrl;
    public final /* synthetic */ WidgetOutboundPromoTerms this$0;

    public WidgetOutboundPromoTerms3(WidgetOutboundPromoTerms widgetOutboundPromoTerms) {
        this.this$0 = widgetOutboundPromoTerms;
        Context contextRequireContext = widgetOutboundPromoTerms.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.context = contextRequireContext;
        this.linkColorAttrResId = C5419R.attr.colorTextLink;
        this.onLongPressUrl = WidgetOutboundPromoTerms5.INSTANCE;
    }

    @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext, com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public int getLinkColorAttrResId() {
        return this.linkColorAttrResId;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function3<Context, String, String, Unit> getOnClickUrl() {
        return this.onClickUrl;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }
}
