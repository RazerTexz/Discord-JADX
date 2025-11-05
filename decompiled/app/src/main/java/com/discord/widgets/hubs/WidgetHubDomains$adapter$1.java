package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubDomains.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDomains$adapter$1 extends o implements Function2<LayoutInflater, ViewGroup, HubDomainViewHolder> {
    public final /* synthetic */ WidgetHubDomains this$0;

    /* compiled from: WidgetHubDomains.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$adapter$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<DomainGuildInfo, Unit> {
        public AnonymousClass1(WidgetHubDomains widgetHubDomains) {
            super(1, widgetHubDomains, WidgetHubDomains.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DomainGuildInfo domainGuildInfo) {
            invoke2(domainGuildInfo);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DomainGuildInfo domainGuildInfo) {
            m.checkNotNullParameter(domainGuildInfo, "p1");
            ((WidgetHubDomains) this.receiver).onServerClickListener(domainGuildInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$adapter$1(WidgetHubDomains widgetHubDomains) {
        super(2);
        this.this$0 = widgetHubDomains;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ HubDomainViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HubDomainViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "inflater");
        m.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        m.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new HubDomainViewHolder(discordHubAddServerListItemBindingA, new AnonymousClass1(this.this$0));
    }
}
