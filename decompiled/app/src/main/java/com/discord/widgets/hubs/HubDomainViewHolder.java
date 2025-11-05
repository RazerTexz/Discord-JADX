package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDomains.kt */
/* loaded from: classes2.dex */
public final class HubDomainViewHolder extends SimpleRecyclerAdapter.ViewHolder<DomainGuildInfo> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<DomainGuildInfo, Unit> onClickListener;

    /* compiled from: WidgetHubDomains.kt */
    /* renamed from: com.discord.widgets.hubs.HubDomainViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ DomainGuildInfo $data;

        public AnonymousClass1(DomainGuildInfo domainGuildInfo) {
            this.$data = domainGuildInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            HubDomainViewHolder.this.getOnClickListener().invoke(this.$data);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public HubDomainViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super DomainGuildInfo, Unit> function1) {
        m.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        m.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(DomainGuildInfo domainGuildInfo) {
        bind2(domainGuildInfo);
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<DomainGuildInfo, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(DomainGuildInfo data) {
        m.checkNotNullParameter(data, "data");
        this.binding.f2098b.b();
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        this.binding.f2098b.a(data.getIcon(), GuildUtilsKt.computeShortName(data.getName()));
        this.binding.c.setOnClickListener(new AnonymousClass1(data));
    }
}
