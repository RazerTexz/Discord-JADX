package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemThreadDraftFormBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p012b.GuildBoostUpsellDialog;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm extends WidgetChatListItem {
    private final WidgetChatListAdapterItemThreadDraftFormBinding binding;
    private final AppFlexInputViewModel flexInputViewModel;
    private TextWatcher nameTextWatcher;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    public static final class C81391 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ ThreadDraftFormEntry $data;
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
            public static final class C132811 extends Lambda implements Function1<View, Unit> {
                public C132811() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), C81391.this.$data.getGuildId());
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                Context context = WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext();
                Integer autoArchiveDuration = C81391.this.$draftState.getAutoArchiveDuration();
                if (autoArchiveDuration == null) {
                    autoArchiveDuration = C81391.this.$data.getDefaultAutoArchiveDuration();
                }
                String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440);
                Locale locale = Locale.getDefault();
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                hook.replacementText = lowerCase;
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext(), C5419R.attr.colorHeaderPrimary)), true, null, new C132811(), 4, null));
                hook.styles.add(new StyleSpan(1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81391(StoreThreadDraft.ThreadDraftState threadDraftState, ThreadDraftFormEntry threadDraftFormEntry) {
            super(1);
            this.$draftState = threadDraftState;
            this.$data = threadDraftFormEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("durationHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    public static final class ViewOnClickListenerC81402 implements View.OnClickListener {
        public final /* synthetic */ ThreadDraftFormEntry $data;

        public ViewOnClickListenerC81402(ThreadDraftFormEntry threadDraftFormEntry) {
            this.$data = threadDraftFormEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), this.$data.getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    public static final class ViewOnClickListenerC81411 implements View.OnClickListener {
        public final /* synthetic */ ThreadDraftFormEntry $data;

        public ViewOnClickListenerC81411(ThreadDraftFormEntry threadDraftFormEntry) {
            this.$data = threadDraftFormEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildBoostUpsellDialog.INSTANCE.m119a(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), this.$data.getGuildId(), Long.valueOf(this.$data.getParentChannel().getId()), PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.PRIVATE_THREADS), new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 24, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    public static final class ViewOnClickListenerC81422 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;
        public final /* synthetic */ StoreThreadDraft $storeThreadDraft;

        public ViewOnClickListenerC81422(StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$storeThreadDraft = storeThreadDraft;
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$storeThreadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(this.$draftState, !r0.isPrivate(), null, null, false, false, 30, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm(WidgetChatListAdapter widgetChatListAdapter, AppFlexInputViewModel appFlexInputViewModel) {
        super(C5419R.layout.widget_chat_list_adapter_item_thread_draft_form, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.flexInputViewModel = appFlexInputViewModel;
        View view = this.itemView;
        int i = C5419R.id.auto_archive_duration;
        TextView textView = (TextView) view.findViewById(C5419R.id.auto_archive_duration);
        if (textView != null) {
            i = C5419R.id.divider_stroke;
            View viewFindViewById = view.findViewById(C5419R.id.divider_stroke);
            if (viewFindViewById != null) {
                i = C5419R.id.private_thread_toggle;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.private_thread_toggle);
                if (constraintLayout != null) {
                    i = C5419R.id.private_thread_toggle_badge;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.private_thread_toggle_badge);
                    if (textView2 != null) {
                        i = C5419R.id.private_thread_toggle_switch;
                        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(C5419R.id.private_thread_toggle_switch);
                        if (switchMaterial != null) {
                            i = C5419R.id.private_thread_toggle_text;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.private_thread_toggle_text);
                            if (linearLayout != null) {
                                i = C5419R.id.thread_icon;
                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.thread_icon);
                                if (imageView != null) {
                                    i = C5419R.id.thread_name_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.thread_name_input);
                                    if (textInputLayout != null) {
                                        WidgetChatListAdapterItemThreadDraftFormBinding widgetChatListAdapterItemThreadDraftFormBinding = new WidgetChatListAdapterItemThreadDraftFormBinding((LinearLayout) view, textView, viewFindViewById, constraintLayout, textView2, switchMaterial, linearLayout, imageView, textInputLayout);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemThreadDraftFormBinding, "WidgetChatListAdapterIte…ormBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemThreadDraftFormBinding;
                                        return;
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

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemThreadDraftForm.adapter;
    }

    private final void configureAutoArchive(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        TextView textView = this.binding.f16330b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.autoArchiveDuration");
        FormatUtils.m221m(textView, C5419R.string.create_thread_header_2, new Object[0], new C81391(threadDraftState, data));
        this.binding.f16330b.setOnClickListener(new ViewOnClickListenerC81402(data));
    }

    private final void configureIcon(ThreadDraftFormEntry data) {
        this.binding.f16334f.setImageResource(ChannelUtils.m7693q(data.getParentChannel()) ? C5419R.drawable.ic_channel_forum_post : data.getThreadDraftState().isPrivate() ? C5419R.drawable.ic_thread_locked : C5419R.drawable.ic_thread);
    }

    private final void configurePrivateThreadOption(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        if (ChannelUtils.m7693q(data.getParentChannel())) {
            ConstraintLayout constraintLayout = this.binding.f16331c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.privateThreadToggle");
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.binding.f16331c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.privateThreadToggle");
        constraintLayout2.setVisibility(data.getParentMessageId() == null && data.getCanSeePrivateThreadOption() ? 0 : 8);
        if (!data.getCanCreatePublicThread() && !threadDraftState.isPrivate()) {
            threadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, true, null, null, false, false, 30, null));
            this.binding.f16331c.setOnClickListener(null);
        } else if (data.getCanCreatePrivateThread()) {
            this.binding.f16331c.setOnClickListener(new ViewOnClickListenerC81422(threadDraft, threadDraftState));
        } else {
            this.binding.f16331c.setOnClickListener(new ViewOnClickListenerC81411(data));
        }
        SwitchMaterial switchMaterial = this.binding.f16333e;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.privateThreadToggleSwitch");
        switchMaterial.setChecked(threadDraftState.isPrivate());
        PremiumUtils.BoostFeatureBadgeData boostFeatureBadgeDataForGuildFeature$default = PremiumUtils.getBoostFeatureBadgeDataForGuildFeature$default(PremiumUtils.INSTANCE, data.getGuild(), Long.valueOf(data.getParentChannel().getId()), GuildFeature.PRIVATE_THREADS, ((WidgetChatListAdapter) this.adapter).getContext(), ((WidgetChatListAdapter) this.adapter).getFragmentManager(), null, new Traits.Location(null, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 25, null), 32, null);
        TextView textView = this.binding.f16332d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.privateThreadToggleBadge");
        textView.setText(boostFeatureBadgeDataForGuildFeature$default.getText());
        TextView textView2 = this.binding.f16332d;
        Drawable drawable = ContextCompat.getDrawable(((WidgetChatListAdapter) this.adapter).getContext(), C5419R.drawable.ic_boosted_badge_12dp);
        if (drawable != null) {
            drawable.setTint(boostFeatureBadgeDataForGuildFeature$default.getIconColor());
        } else {
            drawable = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void configureThreadNameInput(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            TextInputLayout textInputLayout = this.binding.f16335g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadNameInput");
            ViewExtensions.clear(textInputLayout);
        }
        TextInputLayout textInputLayout2 = this.binding.f16335g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.threadNameInput");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.removeTextChangedListener(this.nameTextWatcher);
            C8143xf5e71743 c8143xf5e71743 = new C8143xf5e71743(this, threadDraft, threadDraftState);
            editText.addTextChangedListener(c8143xf5e71743);
            this.nameTextWatcher = c8143xf5e71743;
            editText.setOnFocusChangeListener(new WidgetChatListAdapterItemThreadDraftForm2(this, threadDraft, threadDraftState));
            editText.setOnEditorActionListener(new WidgetChatListAdapterItemThreadDraftForm3(this, threadDraft, threadDraftState));
        }
        if (!threadDraftState.getShouldDisplayNameError()) {
            TextInputLayout textInputLayout3 = this.binding.f16335g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.threadNameInput");
            textInputLayout3.setErrorEnabled(false);
            return;
        }
        TextInputLayout textInputLayout4 = this.binding.f16335g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.threadNameInput");
        TextInputLayout textInputLayout5 = this.binding.f16335g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.threadNameInput");
        textInputLayout4.setError(textInputLayout5.getContext().getString(C5419R.string.member_verification_form_required_item));
        TextInputLayout textInputLayout6 = this.binding.f16335g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.threadNameInput");
        textInputLayout6.setErrorEnabled(true);
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) data;
        configureThreadNameInput(threadDraftFormEntry);
        configureAutoArchive(threadDraftFormEntry);
        configureIcon(threadDraftFormEntry);
        configurePrivateThreadOption(threadDraftFormEntry);
        this.binding.f16335g.requestFocus();
    }
}
