package com.discord.widgets.forums;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ForumBrowserPostView.kt */
/* renamed from: com.discord.widgets.forums.ForumBrowserPostView$cardPressHighlight$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ForumBrowserPostView2 extends Lambda implements Function0<Drawable> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Drawable invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Drawable invoke() {
        Context context = this.$context;
        return ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.bg_pressed_highlight, 0, 2, (Object) null));
    }
}
