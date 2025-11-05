package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.ModeratorStartStageContinueItemBinding;
import com.discord.databinding.ModeratorStartStageHeaderItemBinding;
import com.discord.databinding.ModeratorStartStageListItemBinding;
import com.discord.databinding.ModeratorStartStageWaitingItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModeratorStartStageAdapter.kt */
/* loaded from: classes2.dex */
public final class ModeratorStartStageAdapter extends MGRecyclerAdapterSimple<ModeratorStartStageItem> {
    private final Function1<ModeratorStartStageItem, Unit> onItemClicked;

    /* compiled from: ModeratorStartStageAdapter.kt */
    public abstract class CreateStageEventViewHolder extends MGRecyclerViewHolder<ModeratorStartStageAdapter, ModeratorStartStageItem> {
        private final View rootView;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateStageEventViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, View view) {
            super(view, moderatorStartStageAdapter);
            m.checkNotNullParameter(view, "rootView");
            this.this$0 = moderatorStartStageAdapter;
            this.rootView = view;
        }

        public final View getRootView() {
            return this.rootView;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
            onConfigure2(i, moderatorStartStageItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ModeratorStartStageItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.rootView.setOnClickListener(new ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1(this, data));
        }
    }

    /* compiled from: ModeratorStartStageAdapter.kt */
    public final class ListItemViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageListItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding) {
            m.checkNotNullParameter(moderatorStartStageListItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            GuildEventPromptView guildEventPromptView = moderatorStartStageListItemBinding.a;
            m.checkNotNullExpressionValue(guildEventPromptView, "binding.root");
            super(moderatorStartStageAdapter, guildEventPromptView);
            this.binding = moderatorStartStageListItemBinding;
        }

        public final ModeratorStartStageListItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
            onConfigure(i, moderatorStartStageItem);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder
        public void onConfigure(int position, ModeratorStartStageItem data) {
            Pair pair;
            m.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            ModeratorStartStageItem.ListItem listItem = (ModeratorStartStageItem.ListItem) data;
            if (listItem instanceof ModeratorStartStageItem.ListItem.StaticOption) {
                ModeratorStartStageItem.ListItem.StaticOption staticOption = (ModeratorStartStageItem.ListItem.StaticOption) listItem;
                pair = new Pair(b.h(this.this$0.getContext(), staticOption.getTitleRes(), new Object[0], null, 4), b.h(this.this$0.getContext(), staticOption.getSubtitleRes(), new Object[0], null, 4));
            } else {
                if (!(listItem instanceof ModeratorStartStageItem.ListItem.Event)) {
                    throw new NoWhenBranchMatchedException();
                }
                ModeratorStartStageItem.ListItem.Event event = (ModeratorStartStageItem.ListItem.Event) listItem;
                pair = new Pair(event.getEvent().getName(), GuildScheduledEventUtilitiesKt.getEventStartingTimeString(event.getEvent(), this.this$0.getContext()));
            }
            this.binding.a.configure(listItem.getIconRes(), listItem.getIconBgColorRes(), (CharSequence) pair.component1(), (CharSequence) pair.component2());
        }

        public ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_list_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                Objects.requireNonNull(viewInflate, "rootView");
                ModeratorStartStageListItemBinding moderatorStartStageListItemBinding2 = new ModeratorStartStageListItemBinding((GuildEventPromptView) viewInflate);
                m.checkNotNullExpressionValue(moderatorStartStageListItemBinding2, "ModeratorStartStageListI…ontext), recycler, false)");
                moderatorStartStageListItemBinding = moderatorStartStageListItemBinding2;
            }
            this(moderatorStartStageAdapter, moderatorStartStageListItemBinding);
        }
    }

    /* compiled from: ModeratorStartStageAdapter.kt */
    public final class WaitingViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageWaitingItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding) {
            m.checkNotNullParameter(moderatorStartStageWaitingItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageWaitingItemBinding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageWaitingItemBinding;
        }

        public final ModeratorStartStageWaitingItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
            onConfigure(i, moderatorStartStageItem);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter.CreateStageEventViewHolder
        public void onConfigure(int position, ModeratorStartStageItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            ModeratorStartStageItem.Waiting waiting = (ModeratorStartStageItem.Waiting) data;
            UserSummaryView.b(this.binding.f2129b, waiting.getUsers(), false, 2);
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.moderatorStartStageWaitingUserText");
            int size = waiting.getUsers().size();
            CharSequence charSequenceH = null;
            if (size == 1) {
                charSequenceH = b.h(this.this$0.getContext(), R.string.stage_audience_waiting_one, new Object[]{waiting.getUsers().get(0).getNickOrUserName()}, null, 4);
            } else if (size == 2) {
                charSequenceH = b.h(this.this$0.getContext(), R.string.stage_audience_waiting_two, new Object[]{waiting.getUsers().get(0).getNickOrUserName(), waiting.getUsers().get(1).getNickOrUserName()}, null, 4);
            } else if (size == 3) {
                charSequenceH = StringResourceUtilsKt.getI18nPluralString(this.this$0.getContext(), R.plurals.stage_audience_waiting_many_numOthers, waiting.getUsers().size() - 2, waiting.getUsers().get(0).getNickOrUserName(), waiting.getUsers().get(1).getNickOrUserName());
            }
            ViewExtensions.setTextAndVisibilityBy(textView, charSequenceH);
        }

        public WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_waiting_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                int i2 = R.id.moderator_start_stage_waiting_user_list;
                UserSummaryView userSummaryView = (UserSummaryView) viewInflate.findViewById(R.id.moderator_start_stage_waiting_user_list);
                if (userSummaryView != null) {
                    i2 = R.id.moderator_start_stage_waiting_user_text;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_waiting_user_text);
                    if (textView != null) {
                        ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding2 = new ModeratorStartStageWaitingItemBinding((ConstraintLayout) viewInflate, userSummaryView, textView);
                        m.checkNotNullExpressionValue(moderatorStartStageWaitingItemBinding2, "ModeratorStartStageWaiti…ontext), recycler, false)");
                        moderatorStartStageWaitingItemBinding = moderatorStartStageWaitingItemBinding2;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            this(moderatorStartStageAdapter, moderatorStartStageWaitingItemBinding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModeratorStartStageAdapter(RecyclerView recyclerView, Function1<? super ModeratorStartStageItem, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onItemClicked");
        this.onItemClicked = function1;
    }

    public final Function1<ModeratorStartStageItem, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ModeratorStartStageItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this, null, 1, null);
        }
        if (viewType == 1) {
            return new ListItemViewHolder(this, null, 1, null);
        }
        if (viewType == 2) {
            return new ContinueViewHolder(this, null, 1, null);
        }
        if (viewType == 3) {
            return new WaitingViewHolder(this, null, 1, null);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: ModeratorStartStageAdapter.kt */
    public final class ContinueViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageContinueItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding) {
            m.checkNotNullParameter(moderatorStartStageContinueItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageContinueItemBinding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageContinueItemBinding;
        }

        public final ModeratorStartStageContinueItemBinding getBinding() {
            return this.binding;
        }

        public ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_continue_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                Objects.requireNonNull(viewInflate, "rootView");
                ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding2 = new ModeratorStartStageContinueItemBinding((ConstraintLayout) viewInflate);
                m.checkNotNullExpressionValue(moderatorStartStageContinueItemBinding2, "ModeratorStartStageConti…ontext), recycler, false)");
                moderatorStartStageContinueItemBinding = moderatorStartStageContinueItemBinding2;
            }
            this(moderatorStartStageAdapter, moderatorStartStageContinueItemBinding);
        }
    }

    /* compiled from: ModeratorStartStageAdapter.kt */
    public final class HeaderViewHolder extends CreateStageEventViewHolder {
        private final ModeratorStartStageHeaderItemBinding binding;
        public final /* synthetic */ ModeratorStartStageAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding) {
            m.checkNotNullParameter(moderatorStartStageHeaderItemBinding, "binding");
            this.this$0 = moderatorStartStageAdapter;
            ConstraintLayout constraintLayout = moderatorStartStageHeaderItemBinding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(moderatorStartStageAdapter, constraintLayout);
            this.binding = moderatorStartStageHeaderItemBinding;
        }

        public final ModeratorStartStageHeaderItemBinding getBinding() {
            return this.binding;
        }

        public HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R.layout.moderator_start_stage_header_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
                int i2 = R.id.moderator_start_stage_icon;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.moderator_start_stage_icon);
                if (imageView != null) {
                    i2 = R.id.moderator_start_stage_subtitle;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_subtitle);
                    if (textView != null) {
                        i2 = R.id.moderator_start_stage_title;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.moderator_start_stage_title);
                        if (textView2 != null) {
                            ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding2 = new ModeratorStartStageHeaderItemBinding((ConstraintLayout) viewInflate, imageView, textView, textView2);
                            m.checkNotNullExpressionValue(moderatorStartStageHeaderItemBinding2, "ModeratorStartStageHeade…ontext), recycler, false)");
                            moderatorStartStageHeaderItemBinding = moderatorStartStageHeaderItemBinding2;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            this(moderatorStartStageAdapter, moderatorStartStageHeaderItemBinding);
        }
    }
}
