package com.discord.widgets.guilds.invite;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guilds.invite.InviteSuggestionItemV2;
import com.discord.widgets.user.UserNameFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItemV2> {
    private Function1<? super InviteSuggestionItemV2, Unit> onClick;

    /* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
    public static final class EmptySearchResultsViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptySearchResultsViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
            super(C5419R.layout.guild_invite_empty_search_results_item, inviteSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
    public static final class InviteSuggestionViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
        private final WidgetGuildInviteShareItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InviteSuggestionViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
            super(C5419R.layout.widget_guild_invite_share_item, inviteSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
            WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingM8417a = WidgetGuildInviteShareItemBinding.m8417a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingM8417a, "WidgetGuildInviteShareItemBinding.bind(itemView)");
            this.binding = widgetGuildInviteShareItemBindingM8417a;
        }

        public static final /* synthetic */ InviteSuggestionsAdapter access$getAdapter$p(InviteSuggestionViewHolder inviteSuggestionViewHolder) {
            return (InviteSuggestionsAdapter) inviteSuggestionViewHolder.adapter;
        }

        private final void configureItemForChannel(Channel channel) {
            SimpleDraweeView simpleDraweeView = this.binding.f16833b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView, channel, 0, (MGImages.ChangeDetector) null, 12, (Object) null);
            TextView textView = this.binding.f16835d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
            textView.setText(ChannelUtils.m7679c(channel));
        }

        private final void configureItemForUser(User user) {
            SimpleDraweeView simpleDraweeView = this.binding.f16833b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
            TextView textView = this.binding.f16835d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
            textView.setText(UserNameFormatter.getSpannableForUserNameWithDiscrim(user, null, ((InviteSuggestionsAdapter) this.adapter).getContext(), C5419R.attr.colorHeaderPrimary, C5419R.attr.font_primary_semibold, C5419R.integer.uikit_textsize_large_sp, C5419R.attr.colorTextMuted, C5419R.attr.font_primary_normal, C5419R.integer.uikit_textsize_large_sp));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItemV2 inviteSuggestionItemV2) {
            onConfigure2(i, inviteSuggestionItemV2);
        }

        /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, InviteSuggestionItemV2 data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            boolean z2 = data instanceof InviteSuggestionItemV2.ChannelItem;
            if (z2) {
                InviteSuggestionItemV2.ChannelItem channelItem = (InviteSuggestionItemV2.ChannelItem) data;
                User userM7677a = ChannelUtils.m7677a(channelItem.getChannel());
                if (userM7677a != null) {
                    configureItemForUser(userM7677a);
                } else {
                    configureItemForChannel(channelItem.getChannel());
                }
            } else if (data instanceof InviteSuggestionItemV2.UserItem) {
                configureItemForUser(((InviteSuggestionItemV2.UserItem) data).getUser());
            }
            if (z2 || (data instanceof InviteSuggestionItemV2.UserItem)) {
                MaterialButton materialButton = this.binding.f16836e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                MaterialButton materialButton2 = this.binding.f16834c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                this.binding.f16834c.setOnClickListener(new InviteSuggestionsAdapter2(this, data));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = InviteSuggestionsAdapter3.INSTANCE;
    }

    public final Function1<InviteSuggestionItemV2, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClick(Function1<? super InviteSuggestionItemV2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new EmptySearchResultsViewHolder(this);
        }
        if (viewType == 2 || viewType == 3) {
            return new InviteSuggestionViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
