package com.discord.widgets.chat;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.chat.WidgetUrlActions;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.WidgetUrlActions$Companion$requestNotice$notice$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrlActions2(String str) {
        super(1);
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetUrlActions.Companion companion = WidgetUrlActions.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        companion.launch(supportFragmentManager, this.$url);
        return true;
    }
}
