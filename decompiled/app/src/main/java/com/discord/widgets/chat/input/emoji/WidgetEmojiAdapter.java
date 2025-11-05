package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.EmojiPickerEmojiItemBinding;
import com.discord.databinding.EmojiPickerPremiumUpsellBinding;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ImageViewExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0.f;
import d0.t.u;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetEmojiAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetEmojiAdapter extends WidgetExpressionPickerAdapter {
    private static final int DEFAULT_NUM_COLUMNS = 8;
    private static final int ITEM_TYPE_EMOJI = 1;
    private static final int ITEM_TYPE_PREMIUM_UPSELL = 2;
    private static final int MAX_EMOJI_SIZE_PX = 64;
    private final int emojiSizePx;
    private final FragmentManager fragmentManager;
    private final Function0<Unit> hideKeyboard;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final OnEmojiSelectedListener onEmojiSelectedListener;
    private final Function0<Unit> onGetPremiumCtaClicked;

    /* compiled from: WidgetEmojiAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends GridLayoutManager.SpanSizeLookup {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int itemViewType = WidgetEmojiAdapter.this.getItemViewType(position);
            if (itemViewType == 0 || itemViewType == 2) {
                return WidgetEmojiAdapter.this.getNumColumns();
            }
            return 1;
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static final class EmojiViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerEmojiItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_emoji_item, widgetEmojiAdapter);
            m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
            EmojiPickerEmojiItemBinding emojiPickerEmojiItemBinding = new EmojiPickerEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            m.checkNotNullExpressionValue(emojiPickerEmojiItemBinding, "EmojiPickerEmojiItemBinding.bind(itemView)");
            this.binding = emojiPickerEmojiItemBinding;
        }

        public static final /* synthetic */ WidgetEmojiAdapter access$getAdapter$p(EmojiViewHolder emojiViewHolder) {
            return (WidgetEmojiAdapter) emojiViewHolder.adapter;
        }

        public static final /* synthetic */ EmojiPickerEmojiItemBinding access$getBinding$p(EmojiViewHolder emojiViewHolder) {
            return emojiViewHolder.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof EmojiItem)) {
                data = null;
            }
            EmojiItem emojiItem = (EmojiItem) data;
            if (emojiItem != null) {
                Emoji emoji = emojiItem.getEmoji();
                int iCoerceAtMost = f.coerceAtMost(IconUtils.getMediaProxySize(WidgetEmojiAdapter.access$getEmojiSizePx$p((WidgetEmojiAdapter) this.adapter)), 64);
                boolean allowEmojisToAnimate = emojiItem.getAllowEmojisToAnimate();
                SimpleDraweeView simpleDraweeView = this.binding.f2101b;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiItemDraweeview");
                String imageUri = emoji.getImageUri(allowEmojisToAnimate, iCoerceAtMost, simpleDraweeView.getContext());
                SimpleDraweeView simpleDraweeView2 = this.binding.f2101b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiItemDraweeview");
                MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, true, null, null, 108, null);
                SimpleDraweeView simpleDraweeView3 = this.binding.f2101b;
                m.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiItemDraweeview");
                ImageViewExtensionsKt.setGrayscale(simpleDraweeView3, (emoji.isUsable() && emoji.isAvailable()) ? false : true);
                SimpleDraweeView simpleDraweeView4 = this.binding.f2101b;
                m.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiItemDraweeview");
                simpleDraweeView4.setImageAlpha((emoji.isUsable() && emoji.isAvailable()) ? 255 : 100);
                SimpleDraweeView simpleDraweeView5 = this.binding.f2101b;
                m.checkNotNullExpressionValue(simpleDraweeView5, "binding.emojiItemDraweeview");
                simpleDraweeView5.setContentDescription(emoji.getFirstName());
                this.binding.a.setOnClickListener(new WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1(this, emoji));
                SimpleDraweeView simpleDraweeView6 = this.binding.a;
                m.checkNotNullExpressionValue(simpleDraweeView6, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView6, new WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2(this, emojiItem));
            }
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static abstract class HeaderItem implements MGRecyclerDataPayload {
        private final int type;

        /* compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class GuildHeaderItem extends HeaderItem {
            private final String key;
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(String str, String str2) {
                super(null);
                m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                m.checkNotNullParameter(str2, "key");
                this.text = str;
                this.key = str2;
            }

            public static /* synthetic */ GuildHeaderItem copy$default(GuildHeaderItem guildHeaderItem, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = guildHeaderItem.text;
                }
                if ((i & 2) != 0) {
                    str2 = guildHeaderItem.getKey();
                }
                return guildHeaderItem.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final String component2() {
                return getKey();
            }

            public final GuildHeaderItem copy(String text, String key) {
                m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                m.checkNotNullParameter(key, "key");
                return new GuildHeaderItem(text, key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildHeaderItem)) {
                    return false;
                }
                GuildHeaderItem guildHeaderItem = (GuildHeaderItem) other;
                return m.areEqual(this.text, guildHeaderItem.text) && m.areEqual(getKey(), guildHeaderItem.getKey());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String key = getKey();
                return iHashCode + (key != null ? key.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("GuildHeaderItem(text=");
                sbU.append(this.text);
                sbU.append(", key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(Guild guild) {
                this(guild.getName(), String.valueOf(guild.getId()));
                m.checkNotNullParameter(guild, "guild");
            }
        }

        /* compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class StandardHeaderItem extends HeaderItem {
            private final EmojiCategory emojiCategory;
            private final String key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StandardHeaderItem(EmojiCategory emojiCategory) {
                super(null);
                m.checkNotNullParameter(emojiCategory, "emojiCategory");
                this.emojiCategory = emojiCategory;
                this.key = emojiCategory.name();
            }

            public static /* synthetic */ StandardHeaderItem copy$default(StandardHeaderItem standardHeaderItem, EmojiCategory emojiCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    emojiCategory = standardHeaderItem.emojiCategory;
                }
                return standardHeaderItem.copy(emojiCategory);
            }

            /* renamed from: component1, reason: from getter */
            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            public final StandardHeaderItem copy(EmojiCategory emojiCategory) {
                m.checkNotNullParameter(emojiCategory, "emojiCategory");
                return new StandardHeaderItem(emojiCategory);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StandardHeaderItem) && m.areEqual(this.emojiCategory, ((StandardHeaderItem) other).emojiCategory);
                }
                return true;
            }

            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                EmojiCategory emojiCategory = this.emojiCategory;
                if (emojiCategory != null) {
                    return emojiCategory.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("StandardHeaderItem(emojiCategory=");
                sbU.append(this.emojiCategory);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class StringHeaderItem extends HeaderItem {
            private final String key;
            private final int stringRes;

            public StringHeaderItem(@StringRes int i) {
                super(null);
                this.stringRes = i;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ StringHeaderItem copy$default(StringHeaderItem stringHeaderItem, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = stringHeaderItem.stringRes;
                }
                return stringHeaderItem.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final StringHeaderItem copy(@StringRes int stringRes) {
                return new StringHeaderItem(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StringHeaderItem) && this.stringRes == ((StringHeaderItem) other).stringRes;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return a.B(a.U("StringHeaderItem(stringRes="), this.stringRes, ")");
            }
        }

        private HeaderItem() {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ HeaderItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ExpressionPickerHeaderItemBinding binding;
        public HeaderItem boundItem;

        /* compiled from: WidgetEmojiAdapter.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    EmojiCategory.values();
                    int[] iArr = new int[11];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[EmojiCategory.FAVORITE.ordinal()] = 1;
                    iArr[EmojiCategory.PEOPLE.ordinal()] = 2;
                    iArr[EmojiCategory.NATURE.ordinal()] = 3;
                    iArr[EmojiCategory.FOOD.ordinal()] = 4;
                    iArr[EmojiCategory.ACTIVITY.ordinal()] = 5;
                    iArr[EmojiCategory.TRAVEL.ordinal()] = 6;
                    iArr[EmojiCategory.OBJECTS.ordinal()] = 7;
                    iArr[EmojiCategory.SYMBOLS.ordinal()] = 8;
                    iArr[EmojiCategory.FLAGS.ordinal()] = 9;
                    iArr[EmojiCategory.CUSTOM.ordinal()] = 10;
                    iArr[EmojiCategory.RECENT.ordinal()] = 11;
                }
            }

            private Companion() {
            }

            @StringRes
            public final int getCategoryString(EmojiCategory emojiCategory) {
                m.checkNotNullParameter(emojiCategory, "emojiCategory");
                switch (emojiCategory) {
                    case FAVORITE:
                        return R.string.category_favorite;
                    case RECENT:
                        return R.string.emoji_category_recent;
                    case CUSTOM:
                        return R.string.emoji_category_custom;
                    case PEOPLE:
                        return R.string.emoji_category_people;
                    case NATURE:
                        return R.string.emoji_category_nature;
                    case FOOD:
                        return R.string.emoji_category_food;
                    case ACTIVITY:
                        return R.string.emoji_category_activity;
                    case TRAVEL:
                        return R.string.emoji_category_travel;
                    case OBJECTS:
                        return R.string.emoji_category_objects;
                    case SYMBOLS:
                        return R.string.emoji_category_symbols;
                    case FLAGS:
                        return R.string.emoji_category_flags;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.expression_picker_header_item, widgetEmojiAdapter);
            m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
            m.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
            this.binding = expressionPickerHeaderItemBinding;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public void bind(int position, MGRecyclerDataPayload data) {
            m.checkNotNullParameter(data, "data");
            onConfigure2(position, data);
        }

        public final HeaderItem getBoundItem() {
            HeaderItem headerItem = this.boundItem;
            if (headerItem == null) {
                m.throwUninitializedPropertyAccessException("boundItem");
            }
            return headerItem;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public View getItemView() {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return view;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        public final void setBoundItem(HeaderItem headerItem) {
            m.checkNotNullParameter(headerItem, "<set-?>");
            this.boundItem = headerItem;
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Unit unit;
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof HeaderItem)) {
                data = null;
            }
            HeaderItem headerItem = (HeaderItem) data;
            if (headerItem != null) {
                this.boundItem = headerItem;
                if (headerItem instanceof HeaderItem.StandardHeaderItem) {
                    TextView textView = this.binding.f2105b;
                    m.checkNotNullExpressionValue(textView, "binding.headerItemText");
                    b.n(textView, INSTANCE.getCategoryString(((HeaderItem.StandardHeaderItem) headerItem).getEmojiCategory()), new Object[0], null, 4);
                    unit = Unit.a;
                } else if (headerItem instanceof HeaderItem.GuildHeaderItem) {
                    TextView textView2 = this.binding.f2105b;
                    m.checkNotNullExpressionValue(textView2, "binding.headerItemText");
                    textView2.setText(((HeaderItem.GuildHeaderItem) headerItem).getText());
                    unit = Unit.a;
                } else {
                    if (!(headerItem instanceof HeaderItem.StringHeaderItem)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    TextView textView3 = this.binding.f2105b;
                    m.checkNotNullExpressionValue(textView3, "binding.headerItemText");
                    b.n(textView3, ((HeaderItem.StringHeaderItem) headerItem).getStringRes(), new Object[0], null, 4);
                    unit = Unit.a;
                }
                KotlinExtensionsKt.getExhaustive(unit);
            }
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static final class PremiumEmojiUpsellViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerPremiumUpsellBinding binding;

        /* compiled from: WidgetEmojiAdapter.kt */
        /* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ WidgetEmojiAdapter $adapter;

            public AnonymousClass1(WidgetEmojiAdapter widgetEmojiAdapter) {
                this.$adapter = widgetEmojiAdapter;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEmojiAdapter.access$getOnGetPremiumCtaClicked$p(this.$adapter).invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PremiumEmojiUpsellViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_premium_upsell, widgetEmojiAdapter);
            m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.emojiPickerPremiumCta);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.emojiPickerPremiumCta)));
            }
            EmojiPickerPremiumUpsellBinding emojiPickerPremiumUpsellBinding = new EmojiPickerPremiumUpsellBinding((LinearLayout) view, textView);
            m.checkNotNullExpressionValue(emojiPickerPremiumUpsellBinding, "EmojiPickerPremiumUpsellBinding.bind(itemView)");
            this.binding = emojiPickerPremiumUpsellBinding;
            textView.setOnClickListener(new AnonymousClass1(widgetEmojiAdapter));
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static final class UpsellItem implements MGRecyclerDataPayload {
        private static final String key;
        public static final UpsellItem INSTANCE = new UpsellItem();
        private static final int type = 2;

        static {
            String name = UpsellItem.class.getName();
            m.checkNotNullExpressionValue(name, "javaClass.name");
            key = name;
        }

        private UpsellItem() {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, OnEmojiSelectedListener onEmojiSelectedListener, Function0<Unit> function0, Function0<Unit> function02) {
        super(recyclerView, null, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onEmojiSelectedListener, "onEmojiSelectedListener");
        m.checkNotNullParameter(function0, "onGetPremiumCtaClicked");
        m.checkNotNullParameter(function02, "hideKeyboard");
        this.fragmentManager = fragmentManager;
        this.onEmojiSelectedListener = onEmojiSelectedListener;
        this.onGetPremiumCtaClicked = function0;
        this.hideKeyboard = function02;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.emojiSizePx = context.getResources().getDimensionPixelSize(R.dimen.chat_input_emoji_size);
        Context context2 = recyclerView.getContext();
        m.checkNotNullExpressionValue(context2, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.INSTANCE.calculateNumOfColumns(recyclerView, context2.getResources().getDimension(R.dimen.chat_input_emoji_size), 8);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new AnonymousClass1());
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    public static final /* synthetic */ int access$getEmojiSizePx$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.emojiSizePx;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.fragmentManager;
    }

    public static final /* synthetic */ Function0 access$getHideKeyboard$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.hideKeyboard;
    }

    public static final /* synthetic */ OnEmojiSelectedListener access$getOnEmojiSelectedListener$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onEmojiSelectedListener;
    }

    public static final /* synthetic */ Function0 access$getOnGetPremiumCtaClicked$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onGetPremiumCtaClicked;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public /* bridge */ /* synthetic */ WidgetExpressionPickerAdapter.StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        return createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return u.getOrNull(getInternalData(), position) instanceof HeaderItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public HeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        m.checkNotNullParameter(adapter, "adapter");
        return new HeaderViewHolder((WidgetEmojiAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new EmojiViewHolder(this);
        }
        if (viewType == 2) {
            return new PremiumEmojiUpsellViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    public static final /* data */ class EmojiItem implements MGRecyclerDataPayload {
        private final boolean allowEmojisToAnimate;
        private final Emoji emoji;
        private final String emojiName;
        private final String guildName;
        private final String key;
        private final int type;

        public EmojiItem(String str, Emoji emoji, String str2, boolean z2) {
            m.checkNotNullParameter(emoji, "emoji");
            m.checkNotNullParameter(str2, "emojiName");
            this.guildName = str;
            this.emoji = emoji;
            this.emojiName = str2;
            this.allowEmojisToAnimate = z2;
            this.type = 1;
            String uniqueId = emoji.getUniqueId();
            m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
            this.key = uniqueId;
        }

        public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, String str, Emoji emoji, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emojiItem.guildName;
            }
            if ((i & 2) != 0) {
                emoji = emojiItem.emoji;
            }
            if ((i & 4) != 0) {
                str2 = emojiItem.emojiName;
            }
            if ((i & 8) != 0) {
                z2 = emojiItem.allowEmojisToAnimate;
            }
            return emojiItem.copy(str, emoji, str2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component2, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEmojiName() {
            return this.emojiName;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final EmojiItem copy(String guildName, Emoji emoji, String emojiName, boolean allowEmojisToAnimate) {
            m.checkNotNullParameter(emoji, "emoji");
            m.checkNotNullParameter(emojiName, "emojiName");
            return new EmojiItem(guildName, emoji, emojiName, allowEmojisToAnimate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojiItem)) {
                return false;
            }
            EmojiItem emojiItem = (EmojiItem) other;
            return m.areEqual(this.guildName, emojiItem.guildName) && m.areEqual(this.emoji, emojiItem.emoji) && m.areEqual(this.emojiName, emojiItem.emojiName) && this.allowEmojisToAnimate == emojiItem.allowEmojisToAnimate;
        }

        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final String getEmojiName() {
            return this.emojiName;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.guildName;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Emoji emoji = this.emoji;
            int iHashCode2 = (iHashCode + (emoji != null ? emoji.hashCode() : 0)) * 31;
            String str2 = this.emojiName;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.allowEmojisToAnimate;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("EmojiItem(guildName=");
            sbU.append(this.guildName);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", emojiName=");
            sbU.append(this.emojiName);
            sbU.append(", allowEmojisToAnimate=");
            return a.O(sbU, this.allowEmojisToAnimate, ")");
        }

        public /* synthetic */ EmojiItem(String str, Emoji emoji, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, str2, (i & 8) != 0 ? false : z2);
        }
    }
}
