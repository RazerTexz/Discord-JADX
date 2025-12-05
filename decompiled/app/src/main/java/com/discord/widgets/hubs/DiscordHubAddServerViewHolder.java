package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.GuildView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DiscordHubAddServerViewHolder.kt */
/* loaded from: classes2.dex */
public final class DiscordHubAddServerViewHolder extends SimpleRecyclerAdapter.ViewHolder<Guild> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<Long, Unit> onClickListener;

    /* compiled from: DiscordHubAddServerViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.DiscordHubAddServerViewHolder$bind$2 */
    public static final class ViewOnClickListenerC89842 implements View.OnClickListener {
        public final /* synthetic */ Guild $data;

        public ViewOnClickListenerC89842(Guild guild) {
            this.$data = guild;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DiscordHubAddServerViewHolder.this.getOnClickListener().invoke(Long.valueOf(this.$data.getId()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public DiscordHubAddServerViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super Long, Unit> function1) {
        Intrinsics3.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.f15046a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(Guild guild) {
        bind2(guild);
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(Guild data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f15049d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        GuildView guildView = this.binding.f15047b;
        guildView.m8546b();
        guildView.m8545a(IconUtils.getForGuild$default(data, null, false, null, 14, null), data.getShortName());
        this.binding.f15048c.setOnClickListener(new ViewOnClickListenerC89842(data));
    }
}
