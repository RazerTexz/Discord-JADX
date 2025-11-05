package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.rlottie.RLottieImageView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerCategoryViewHolder.kt */
/* loaded from: classes2.dex */
public abstract class StickerCategoryViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: StickerCategoryViewHolder.kt */
    public static final class Guild extends StickerCategoryViewHolder {
        private final StickerCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
            m.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemGuildBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemGuildBinding;
        }

        public final void configure(StickerCategoryItem.GuildItem guildItem, Function1<? super StickerCategoryItem.GuildItem, Unit> onGuildClicked) {
            m.checkNotNullParameter(guildItem, "guildItem");
            m.checkNotNullParameter(onGuildClicked, "onGuildClicked");
            this.binding.c.updateView(guildItem.getGuild());
            View view = this.binding.f2148b.f163b;
            m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder$Guild$configure$1(onGuildClicked, guildItem));
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildItem.getGuild().getName());
        }
    }

    /* compiled from: StickerCategoryViewHolder.kt */
    public static final class Pack extends StickerCategoryViewHolder {
        private final StickerCategoryItemPackBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
            m.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemPackBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemPackBinding;
        }

        public final void configure(StickerCategoryItem.PackItem packItem, Function1<? super StickerCategoryItem.PackItem, Unit> onPackClicked) {
            m.checkNotNullParameter(packItem, "packItem");
            m.checkNotNullParameter(onPackClicked, "onPackClicked");
            this.binding.c.d(packItem.getPack().getCoverSticker(), 2);
            this.binding.c.setOnClickListener(new StickerCategoryViewHolder$Pack$configure$1(onPackClicked, packItem));
            StickerView stickerView = this.binding.c;
            SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setImportantForAccessibility(4);
            RLottieImageView rLottieImageView = stickerView.binding.c;
            m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setImportantForAccessibility(4);
            ImageView imageView = stickerView.binding.d;
            m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setImportantForAccessibility(4);
            StickerView stickerView2 = this.binding.c;
            m.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
            stickerView2.setContentDescription(packItem.getPack().getName());
            View view = this.binding.f2149b.f163b;
            m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(packItem.getIsSelected() ? 0 : 8);
        }
    }

    /* compiled from: StickerCategoryViewHolder.kt */
    public static final class Recent extends StickerCategoryViewHolder {
        private final StickerCategoryItemRecentBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
            m.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemRecentBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemRecentBinding;
        }

        public final void configure(StickerCategoryItem.RecentItem categoryItem, Function0<Unit> onRecentClicked) {
            m.checkNotNullParameter(categoryItem, "categoryItem");
            m.checkNotNullParameter(onRecentClicked, "onRecentClicked");
            View view = this.binding.f2150b.f163b;
            m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(categoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder$Recent$configure$1(onRecentClicked));
        }
    }

    private StickerCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ StickerCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
