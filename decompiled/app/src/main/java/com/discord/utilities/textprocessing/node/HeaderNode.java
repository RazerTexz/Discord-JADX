package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: HeaderNode.kt */
/* loaded from: classes2.dex */
public final class HeaderNode<T extends BasicRenderContext> extends Node<T> {
    private final int numHeaderIndicators;

    public HeaderNode(int i) {
        super(null, 1, null);
        this.numHeaderIndicators = i;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (BasicRenderContext) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        int i = this.numHeaderIndicators;
        int i2 = i != 1 ? i != 2 ? R.dimen.markdown_messages_header_3_top_padding : R.dimen.markdown_messages_header_2_top_padding : R.dimen.markdown_messages_header_1_top_padding;
        int i3 = i != 1 ? i != 2 ? R.dimen.markdown_messages_header_3_bottom_padding : R.dimen.markdown_messages_header_2_bottom_padding : R.dimen.markdown_messages_header_1_bottom_padding;
        TextAppearanceSpan textAppearanceSpan = i != 1 ? i != 2 ? new TextAppearanceSpan(context, 2131952044) : new TextAppearanceSpan(context, 2131952043) : new TextAppearanceSpan(context, 2131952042);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(textAppearanceSpan);
        arrayList.add(new VerticalPaddingSpan(context.getResources().getDimensionPixelSize(i2), context.getResources().getDimensionPixelSize(i3)));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
    }
}
