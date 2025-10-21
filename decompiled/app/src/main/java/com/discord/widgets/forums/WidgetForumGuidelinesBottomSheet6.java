package com.discord.widgets.forums;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$requestKey$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet6 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetForumGuidelinesBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumGuidelinesBottomSheet6(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet) {
        super(0);
        this.this$0 = widgetForumGuidelinesBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
