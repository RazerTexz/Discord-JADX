package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiCategoryViewHolder.kt */
/* loaded from: classes2.dex */
public abstract class EmojiCategoryViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: EmojiCategoryViewHolder.kt */
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
                iArr[EmojiCategory.RECENT.ordinal()] = 10;
                iArr[EmojiCategory.CUSTOM.ordinal()] = 11;
            }
        }

        private Companion() {
        }

        @DrawableRes
        public final int getCategoryIconResId(EmojiCategory emojiCategory) {
            m.checkNotNullParameter(emojiCategory, "emojiCategory");
            switch (emojiCategory) {
                case FAVORITE:
                    return R.drawable.ic_emoji_picker_category_favorites_star;
                case RECENT:
                    return R.drawable.ic_emoji_picker_category_recent;
                case CUSTOM:
                default:
                    return R.drawable.ic_emoji_picker_category_custom;
                case PEOPLE:
                    return R.drawable.ic_emoji_picker_category_people;
                case NATURE:
                    return R.drawable.ic_emoji_picker_category_nature;
                case FOOD:
                    return R.drawable.ic_emoji_picker_category_food;
                case ACTIVITY:
                    return R.drawable.ic_emoji_picker_category_activity;
                case TRAVEL:
                    return R.drawable.ic_emoji_picker_category_travel;
                case OBJECTS:
                    return R.drawable.ic_emoji_picker_category_objects;
                case SYMBOLS:
                    return R.drawable.ic_emoji_picker_category_symbols;
                case FLAGS:
                    return R.drawable.ic_emoji_picker_category_flags;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiCategoryViewHolder.kt */
    public static final class Guild extends EmojiCategoryViewHolder {
        private final EmojiCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding) {
            m.checkNotNullParameter(emojiCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = emojiCategoryItemGuildBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = emojiCategoryItemGuildBinding;
        }

        public final void configure(EmojiCategoryItem.GuildItem guildCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
            m.checkNotNullParameter(guildCategoryItem, "guildCategoryItem");
            m.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
            this.binding.f2099b.updateView(guildCategoryItem.getGuild());
            View view = this.binding.c.f163b;
            m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildCategoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new EmojiCategoryViewHolder$Guild$configure$1(onCategoryClicked, guildCategoryItem));
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildCategoryItem.getGuild().getName());
        }
    }

    /* compiled from: EmojiCategoryViewHolder.kt */
    public static final class Standard extends EmojiCategoryViewHolder {
        private final EmojiCategoryItemStandardBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Standard(EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding) {
            m.checkNotNullParameter(emojiCategoryItemStandardBinding, "binding");
            FrameLayout frameLayout = emojiCategoryItemStandardBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = emojiCategoryItemStandardBinding;
        }

        public final void configure(EmojiCategoryItem.StandardItem standardCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
            int themedColor;
            m.checkNotNullParameter(standardCategoryItem, "standardCategoryItem");
            m.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
            EmojiCategory emojiCategory = standardCategoryItem.getEmojiCategory();
            int categoryIconResId = EmojiCategoryViewHolder.INSTANCE.getCategoryIconResId(emojiCategory);
            ImageView imageView = this.binding.f2100b;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(), categoryIconResId, null));
            boolean isSelected = standardCategoryItem.getIsSelected();
            ImageView imageView2 = this.binding.f2100b;
            m.checkNotNullExpressionValue(imageView2, "binding.emojiCategoryItemStandardIcon");
            imageView2.setSelected(isSelected);
            View view2 = this.binding.c.f163b;
            m.checkNotNullExpressionValue(view2, "binding.overline.express…CategorySelectionOverline");
            view2.setVisibility(isSelected ? 0 : 8);
            if (isSelected) {
                ImageView imageView3 = this.binding.f2100b;
                m.checkNotNullExpressionValue(imageView3, "binding.emojiCategoryItemStandardIcon");
                themedColor = ColorCompat.getThemedColor(imageView3, R.attr.colorInteractiveActive);
            } else {
                ImageView imageView4 = this.binding.f2100b;
                m.checkNotNullExpressionValue(imageView4, "binding.emojiCategoryItemStandardIcon");
                themedColor = ColorCompat.getThemedColor(imageView4, R.attr.colorInteractiveNormal);
            }
            ImageView imageView5 = this.binding.f2100b;
            m.checkNotNullExpressionValue(imageView5, "binding.emojiCategoryItemStandardIcon");
            ColorCompatKt.tintWithColor(imageView5, themedColor);
            ImageView imageView6 = this.binding.f2100b;
            m.checkNotNullExpressionValue(imageView6, "binding.emojiCategoryItemStandardIcon");
            imageView6.setAlpha(isSelected ? 1.0f : 0.5f);
            this.itemView.setOnClickListener(new EmojiCategoryViewHolder$Standard$configure$1(onCategoryClicked, standardCategoryItem));
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            view3.setContentDescription(emojiCategory.name());
        }
    }

    private EmojiCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ EmojiCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
