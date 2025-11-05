package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.i18n.RenderContext;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGiftingAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.EntitlementListItem this$0;

    /* compiled from: WidgetSettingsGiftingAdapter.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            WidgetSettingsGiftingAdapter.access$getOnRevokeClickListener$p(WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4.this.this$0)).invoke(WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4.this.$data.getGift());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(WidgetSettingsGiftingAdapter.EntitlementListItem entitlementListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem) {
        super(1);
        this.this$0 = entitlementListItem;
        this.$data = giftItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("revokeHook", new AnonymousClass1());
    }
}
