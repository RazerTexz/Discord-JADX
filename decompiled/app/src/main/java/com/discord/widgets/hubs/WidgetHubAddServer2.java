package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AdaptedFunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubAddServer.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer2 extends Lambda implements Function2<LayoutInflater, ViewGroup, DiscordHubAddServerViewHolder> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* compiled from: WidgetHubAddServer.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1$1 */
    public static final /* synthetic */ class C89911 extends AdaptedFunctionReference implements Function1<Long, Unit> {
        public C89911(WidgetHubAddServer widgetHubAddServer) {
            super(1, widgetHubAddServer, WidgetHubAddServer.class, "onServerClickListener", "onServerClickListener(JZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetHubAddServer.onServerClickListener$default((WidgetHubAddServer) this.receiver, j, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer2(WidgetHubAddServer widgetHubAddServer) {
        super(2);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ DiscordHubAddServerViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DiscordHubAddServerViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingM8382a = DiscordHubAddServerListItemBinding.m8382a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingM8382a, "DiscordHubAddServerListI…tInflater, parent, false)");
        return new DiscordHubAddServerViewHolder(discordHubAddServerListItemBindingM8382a, new C89911(this.this$0));
    }
}
