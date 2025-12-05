package com.discord.widgets.status;

import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetForumPostStatus.kt */
/* renamed from: com.discord.widgets.status.WidgetForumPostStatus$defaultReactionMeTextColor$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumPostStatus3 extends Lambda implements Function0<ColorStateList> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus3(WidgetForumPostStatus widgetForumPostStatus) {
        super(0);
        this.this$0 = widgetForumPostStatus;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ColorStateList invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ContextCompat.getColorStateList(this.this$0.requireContext(), C5419R.color.status_red_500);
    }
}
