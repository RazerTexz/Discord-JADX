package com.discord.widgets.forums;

import android.content.Context;
import android.content.res.ColorStateList;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ForumBrowserPostView.kt */
/* renamed from: com.discord.widgets.forums.ForumBrowserPostView$reactionMeTextColor$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ForumBrowserPostView4 extends Lambda implements Function0<ColorStateList> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView4(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ColorStateList invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ColorStateList.valueOf(ColorCompat.getThemedColor(this.$context, C5419R.attr.colorHeaderPrimary));
    }
}
