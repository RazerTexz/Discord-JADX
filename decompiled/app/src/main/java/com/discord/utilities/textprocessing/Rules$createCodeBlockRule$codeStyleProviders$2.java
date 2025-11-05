package com.discord.utilities.textprocessing;

import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.m;

/* compiled from: Rules.kt */
/* loaded from: classes2.dex */
public final class Rules$createCodeBlockRule$codeStyleProviders$2<RC> implements StyleNode.a<RC> {
    public static final Rules$createCodeBlockRule$codeStyleProviders$2 INSTANCE = new Rules$createCodeBlockRule$codeStyleProviders$2();

    @Override // com.discord.simpleast.core.node.StyleNode.a
    public /* bridge */ /* synthetic */ Iterable get(Object obj) {
        return get((BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
    public final Iterable get(BasicRenderContext basicRenderContext) {
        m.checkNotNullParameter(basicRenderContext, "it");
        return d0.t.m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), R.style.Code_TextAppearance_Comment));
    }
}
