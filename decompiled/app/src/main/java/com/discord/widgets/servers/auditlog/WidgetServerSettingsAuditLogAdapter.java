package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsAuditLogListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int ENTRY_ITEM = 0;
    private static final int LOADING_ITEM = 1;
    private boolean ensureExpandedIsVisible;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogEntryItem implements MGRecyclerDataPayload {
        private final ModelAuditLogEntry auditLogEntry;
        private final CharSequence changeText;
        private final GuildMember guildMember;
        private final boolean hasChangesToRender;
        private final CharSequence headerText;
        private final boolean isSelected;
        private final String key;
        private final CharSequence timeStampText;
        private final int type;
        private final User user;

        public AuditLogEntryItem(ModelAuditLogEntry modelAuditLogEntry, boolean z2, User user, GuildMember guildMember, CharSequence charSequence, CharSequence charSequence2, boolean z3, CharSequence charSequence3) {
            m.checkNotNullParameter(modelAuditLogEntry, "auditLogEntry");
            m.checkNotNullParameter(charSequence3, "timeStampText");
            this.auditLogEntry = modelAuditLogEntry;
            this.isSelected = z2;
            this.user = user;
            this.guildMember = guildMember;
            this.headerText = charSequence;
            this.changeText = charSequence2;
            this.hasChangesToRender = z3;
            this.timeStampText = charSequence3;
            this.key = String.valueOf(modelAuditLogEntry.getId());
        }

        public final ModelAuditLogEntry getAuditLogEntry() {
            return this.auditLogEntry;
        }

        public final CharSequence getChangeText() {
            return this.changeText;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final boolean getHasChangesToRender() {
            return this.hasChangesToRender;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getTimeStampText() {
            return this.timeStampText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* renamed from: isSelected, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogEntryViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogEntryViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(R.layout.widget_server_settings_audit_log_list_item, widgetServerSettingsAuditLogAdapter);
            m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_listitem_action_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.audit_log_listitem_action_container);
            if (frameLayout != null) {
                i = R.id.audit_log_listitem_actiontype_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.audit_log_listitem_actiontype_image);
                if (imageView != null) {
                    i = R.id.audit_log_listitem_arrow;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.audit_log_listitem_arrow);
                    if (imageView2 != null) {
                        i = R.id.audit_log_listitem_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.audit_log_listitem_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.audit_log_listitem_change_text;
                            TextView textView = (TextView) view.findViewById(R.id.audit_log_listitem_change_text);
                            if (textView != null) {
                                i = R.id.audit_log_listitem_date_text;
                                TextView textView2 = (TextView) view.findViewById(R.id.audit_log_listitem_date_text);
                                if (textView2 != null) {
                                    i = R.id.audit_log_listitem_header_text;
                                    TextView textView3 = (TextView) view.findViewById(R.id.audit_log_listitem_header_text);
                                    if (textView3 != null) {
                                        i = R.id.audit_log_listitem_targettype_image;
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.audit_log_listitem_targettype_image);
                                        if (imageView3 != null) {
                                            i = R.id.audit_log_listitem_top_container;
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.audit_log_listitem_top_container);
                                            if (relativeLayout != null) {
                                                WidgetServerSettingsAuditLogListItemBinding widgetServerSettingsAuditLogListItemBinding = new WidgetServerSettingsAuditLogListItemBinding((CardView) view, frameLayout, imageView, imageView2, simpleDraweeView, textView, textView2, textView3, imageView3, relativeLayout);
                                                m.checkNotNullExpressionValue(widgetServerSettingsAuditLogListItemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                                                this.binding = widgetServerSettingsAuditLogListItemBinding;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogAdapter access$getAdapter$p(AuditLogEntryViewHolder auditLogEntryViewHolder) {
            return (WidgetServerSettingsAuditLogAdapter) auditLogEntryViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            AuditLogEntryItem auditLogEntryItem = (AuditLogEntryItem) data;
            ModelAuditLogEntry auditLogEntry = auditLogEntryItem.getAuditLogEntry();
            User user = auditLogEntryItem.getUser();
            GuildMember guildMember = auditLogEntryItem.getGuildMember();
            ImageView imageView = this.binding.f2542b;
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            imageView.setImageResource(auditLogUtils.getActionTypeImage(auditLogEntry.getActionTypeId()));
            ImageView imageView2 = this.binding.h;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            imageView2.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogEntry.getActionTypeId()));
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.auditLogListitemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, guildMember, 28, null);
            this.binding.d.setOnClickListener(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$1(this, user, guildMember));
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.auditLogListitemDateText");
            textView.setText(auditLogEntryItem.getTimeStampText());
            TextView textView2 = this.binding.g;
            m.checkNotNullExpressionValue(textView2, "binding.auditLogListitemHeaderText");
            CharSequence headerText = auditLogEntryItem.getHeaderText();
            textView2.setText(headerText != null ? b.l(headerText, new Object[0], null, 2) : null);
            TextView textView3 = this.binding.e;
            m.checkNotNullExpressionValue(textView3, "binding.auditLogListitemChangeText");
            textView3.setVisibility(auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender() ? 0 : 8);
            ImageView imageView3 = this.binding.c;
            m.checkNotNullExpressionValue(imageView3, "binding.auditLogListitemArrow");
            imageView3.setVisibility(auditLogEntryItem.getHasChangesToRender() ? 0 : 4);
            if (auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender()) {
                TextView textView4 = this.binding.e;
                m.checkNotNullExpressionValue(textView4, "binding.auditLogListitemChangeText");
                textView4.setText(auditLogEntryItem.getChangeText());
                this.binding.c.setImageResource(R.drawable.ic_chevron_down_grey_12dp);
                RelativeLayout relativeLayout = this.binding.i;
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                relativeLayout.setBackgroundColor(ColorCompat.getThemedColor(view2, R.attr.primary_700_alpha_60));
                if (WidgetServerSettingsAuditLogAdapter.access$getEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter)) {
                    WidgetServerSettingsAuditLogAdapter.access$setEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter, false);
                    ((WidgetServerSettingsAuditLogAdapter) this.adapter).getRecycler().post(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2(this));
                }
            } else {
                this.binding.c.setImageResource(R.drawable.ic_chevron_right_grey_12dp);
                RelativeLayout relativeLayout2 = this.binding.i;
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                relativeLayout2.setBackgroundColor(ColorCompat.getThemedColor(view3, R.attr.primary_630));
            }
            this.itemView.setOnClickListener(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3(this, data));
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogLoadingItem implements MGRecyclerDataPayload {
        private final int type = 1;
        private final String key = "loading";

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    public static final class AuditLogLoadingViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogLoadingViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(R.layout.widget_server_settings_audit_log_loading_listitem, widgetServerSettingsAuditLogAdapter);
            m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter$onAuditLogAvatarClicked$1.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
        return widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible;
    }

    public static final /* synthetic */ void access$setEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter, boolean z2) {
        widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible = z2;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> auditLogEntryItems) {
        m.checkNotNullParameter(auditLogEntryItems, "auditLogEntryItems");
        setData(auditLogEntryItems);
    }

    public final Function2<Long, Long, Unit> getOnAuditLogAvatarClicked() {
        return this.onAuditLogAvatarClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnAuditLogAvatarClicked(Function2<? super Long, ? super Long, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onAuditLogAvatarClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AuditLogEntryViewHolder(this);
        }
        if (viewType == 1) {
            return new AuditLogLoadingViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
