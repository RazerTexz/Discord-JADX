package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains6 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetHubDomains4> {
    public final /* synthetic */ WidgetHubDomains this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$adapter$1$1 */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final /* synthetic */ class C90261 extends FunctionReferenceImpl implements Function1<WidgetHubDomains2, Unit> {
        public C90261(WidgetHubDomains widgetHubDomains) {
            super(1, widgetHubDomains, WidgetHubDomains.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomains2 widgetHubDomains2) {
            invoke2(widgetHubDomains2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomains2 widgetHubDomains2) {
            Intrinsics3.checkNotNullParameter(widgetHubDomains2, "p1");
            ((WidgetHubDomains) this.receiver).onServerClickListener(widgetHubDomains2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains6(WidgetHubDomains widgetHubDomains) {
        super(2);
        this.this$0 = widgetHubDomains;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetHubDomains4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomains4 invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingM8382a = DiscordHubAddServerListItemBinding.m8382a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingM8382a, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new WidgetHubDomains4(discordHubAddServerListItemBindingM8382a, new C90261(this.this$0));
    }
}
