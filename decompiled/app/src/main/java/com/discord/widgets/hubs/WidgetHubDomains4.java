package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubDomainViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains4 extends SimpleRecyclerAdapter.ViewHolder<WidgetHubDomains2> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<WidgetHubDomains2, Unit> onClickListener;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubDomainViewHolder$bind$1 */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final class ViewOnClickListenerC89851 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubDomains2 $data;

        public ViewOnClickListenerC89851(WidgetHubDomains2 widgetHubDomains2) {
            this.$data = widgetHubDomains2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubDomains4.this.getOnClickListener().invoke(this.$data);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubDomains4(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super WidgetHubDomains2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.f15046a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(WidgetHubDomains2 widgetHubDomains2) {
        bind2(widgetHubDomains2);
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<WidgetHubDomains2, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(WidgetHubDomains2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f15047b.m8546b();
        TextView textView = this.binding.f15049d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        this.binding.f15047b.m8545a(data.getIcon(), GuildUtils.computeShortName(data.getName()));
        this.binding.f15048c.setOnClickListener(new ViewOnClickListenerC89851(data));
    }
}
