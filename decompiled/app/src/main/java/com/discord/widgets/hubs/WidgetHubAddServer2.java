package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubAddServer.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer2 extends Lambda implements Function2<LayoutInflater, ViewGroup, DiscordHubAddServerViewHolder> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* compiled from: WidgetHubAddServer.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Long, Unit> {
        public AnonymousClass1(WidgetHubAddServer widgetHubAddServer) {
            super(1, widgetHubAddServer, WidgetHubAddServer.class, "onServerClickListener", "onServerClickListener(JZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
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
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…tInflater, parent, false)");
        return new DiscordHubAddServerViewHolder(discordHubAddServerListItemBindingA, new AnonymousClass1(this.this$0));
    }
}
