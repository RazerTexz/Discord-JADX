package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.databinding.WidgetManageReactionsResultErrorBinding;
import com.discord.databinding.WidgetManageReactionsResultUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int VIEW_TYPE_ERROR = 2;
    private static final int VIEW_TYPE_LOADING = 1;
    private static final int VIEW_TYPE_USER = 0;

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ErrorItem implements MGRecyclerDataPayload {
        private final long channelId;
        private final MessageReactionEmoji emoji;
        private final String key;
        private final long messageId;
        private final int type;

        public ErrorItem(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
            this.channelId = j;
            this.messageId = j2;
            this.emoji = messageReactionEmoji;
            this.type = 2;
            this.key = String.valueOf(getType());
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ErrorViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        private final WidgetManageReactionsResultErrorBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_error, manageReactionsResultsAdapter);
            Intrinsics3.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.manage_reactions_result_error_img;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.manage_reactions_result_error_img);
            if (imageView != null) {
                i = C5419R.id.manage_reactions_result_error_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.manage_reactions_result_error_text);
                if (textView != null) {
                    WidgetManageReactionsResultErrorBinding widgetManageReactionsResultErrorBinding = new WidgetManageReactionsResultErrorBinding((RelativeLayout) view, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(widgetManageReactionsResultErrorBinding, "WidgetManageReactionsRes…rorBinding.bind(itemView)");
                    this.binding = widgetManageReactionsResultErrorBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f17223b.setOnClickListener(new ManageReactionsResultsAdapter2(data));
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class LoadingItem implements MGRecyclerDataPayload {
        private final int type = 1;
        private final String key = String.valueOf(getType());

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class LoadingViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_loading, manageReactionsResultsAdapter);
            Intrinsics3.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final /* data */ class ReactionUserItem implements MGRecyclerDataPayload {
        private final boolean canDelete;
        private final long channelId;
        private final MessageReactionEmoji emoji;
        private final GuildMember guildMember;
        private final String key;
        private final long messageId;
        private final int type;
        private final User user;

        public ReactionUserItem(User user, long j, long j2, MessageReactionEmoji messageReactionEmoji, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
            this.user = user;
            this.channelId = j;
            this.messageId = j2;
            this.emoji = messageReactionEmoji;
            this.canDelete = z2;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ ReactionUserItem copy$default(ReactionUserItem reactionUserItem, User user, long j, long j2, MessageReactionEmoji messageReactionEmoji, boolean z2, GuildMember guildMember, int i, Object obj) {
            return reactionUserItem.copy((i & 1) != 0 ? reactionUserItem.user : user, (i & 2) != 0 ? reactionUserItem.channelId : j, (i & 4) != 0 ? reactionUserItem.messageId : j2, (i & 8) != 0 ? reactionUserItem.emoji : messageReactionEmoji, (i & 16) != 0 ? reactionUserItem.canDelete : z2, (i & 32) != 0 ? reactionUserItem.guildMember : guildMember);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final ReactionUserItem copy(User user, long channelId, long messageId, MessageReactionEmoji emoji, boolean canDelete, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new ReactionUserItem(user, channelId, messageId, emoji, canDelete, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReactionUserItem)) {
                return false;
            }
            ReactionUserItem reactionUserItem = (ReactionUserItem) other;
            return Intrinsics3.areEqual(this.user, reactionUserItem.user) && this.channelId == reactionUserItem.channelId && this.messageId == reactionUserItem.messageId && Intrinsics3.areEqual(this.emoji, reactionUserItem.emoji) && this.canDelete == reactionUserItem.canDelete && Intrinsics3.areEqual(this.guildMember, reactionUserItem.guildMember);
        }

        public final boolean getCanDelete() {
            return this.canDelete;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        public int hashCode() {
            User user = this.user;
            int iM3a = (C0002b.m3a(this.messageId) + ((C0002b.m3a(this.channelId) + ((user != null ? user.hashCode() : 0) * 31)) * 31)) * 31;
            MessageReactionEmoji messageReactionEmoji = this.emoji;
            int iHashCode = (iM3a + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
            boolean z2 = this.canDelete;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            GuildMember guildMember = this.guildMember;
            return i + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ReactionUserItem(user=");
            sbM833U.append(this.user);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", emoji=");
            sbM833U.append(this.emoji);
            sbM833U.append(", canDelete=");
            sbM833U.append(this.canDelete);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ReactionUserViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        private final WidgetManageReactionsResultUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReactionUserViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_user, manageReactionsResultsAdapter);
            Intrinsics3.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.manage_reactions_result_remove_reaction;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.manage_reactions_result_remove_reaction);
            if (imageView != null) {
                i = C5419R.id.manage_reactions_result_user_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.manage_reactions_result_user_avatar);
                if (simpleDraweeView != null) {
                    i = C5419R.id.manage_reactions_result_user_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.manage_reactions_result_user_name);
                    if (textView != null) {
                        WidgetManageReactionsResultUserBinding widgetManageReactionsResultUserBinding = new WidgetManageReactionsResultUserBinding((RelativeLayout) view, imageView, simpleDraweeView, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetManageReactionsResultUserBinding, "WidgetManageReactionsRes…serBinding.bind(itemView)");
                        this.binding = widgetManageReactionsResultUserBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            String username;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ReactionUserItem) {
                TextView textView = this.binding.f17227d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.manageReactionsResultUserName");
                ReactionUserItem reactionUserItem = (ReactionUserItem) data;
                GuildMember guildMember = reactionUserItem.getGuildMember();
                if (guildMember == null || (username = guildMember.getNick()) == null) {
                    username = reactionUserItem.getUser().getUsername();
                }
                textView.setText(username);
                SimpleDraweeView simpleDraweeView = this.binding.f17226c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.manageReactionsResultUserAvatar");
                IconUtils.setIcon$default(simpleDraweeView, reactionUserItem.getUser(), C5419R.dimen.avatar_size_standard, null, null, reactionUserItem.getGuildMember(), 24, null);
                ImageView imageView = this.binding.f17225b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.manageReactionsResultRemoveReaction");
                imageView.setVisibility(reactionUserItem.getCanDelete() ? 0 : 8);
                this.binding.f17225b.setOnClickListener(new ManageReactionsResultsAdapter3(data));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsResultsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ReactionUserViewHolder(this);
        }
        if (viewType == 1) {
            return new LoadingViewHolder(this);
        }
        if (viewType == 2) {
            return new ErrorViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
