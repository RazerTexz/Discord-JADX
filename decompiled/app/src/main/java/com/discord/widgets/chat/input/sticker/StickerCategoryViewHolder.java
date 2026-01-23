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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Guild extends StickerCategoryViewHolder {
        private final StickerCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemGuildBinding.f15259a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemGuildBinding;
        }

        public final void configure(StickerCategoryItem.GuildItem guildItem, Function1<? super StickerCategoryItem.GuildItem, Unit> onGuildClicked) {
            Intrinsics3.checkNotNullParameter(guildItem, "guildItem");
            Intrinsics3.checkNotNullParameter(onGuildClicked, "onGuildClicked");
            this.binding.f15261c.updateView(guildItem.getGuild());
            View view = this.binding.f15260b.f1066b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder2(onGuildClicked, guildItem));
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildItem.getGuild().getName());
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Pack extends StickerCategoryViewHolder {
        private final StickerCategoryItemPackBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemPackBinding.f15262a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemPackBinding;
        }

        public final void configure(StickerCategoryItem.PackItem packItem, Function1<? super StickerCategoryItem.PackItem, Unit> onPackClicked) {
            Intrinsics3.checkNotNullParameter(packItem, "packItem");
            Intrinsics3.checkNotNullParameter(onPackClicked, "onPackClicked");
            this.binding.f15264c.m8616d(packItem.getPack().getCoverSticker(), 2);
            this.binding.f15264c.setOnClickListener(new StickerCategoryViewHolder3(onPackClicked, packItem));
            StickerView stickerView = this.binding.f15264c;
            SimpleDraweeView simpleDraweeView = stickerView.binding.f1177b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setImportantForAccessibility(4);
            RLottieImageView rLottieImageView = stickerView.binding.f1178c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setImportantForAccessibility(4);
            ImageView imageView = stickerView.binding.f1179d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setImportantForAccessibility(4);
            StickerView stickerView2 = this.binding.f15264c;
            Intrinsics3.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
            stickerView2.setContentDescription(packItem.getPack().getName());
            View view = this.binding.f15263b.f1066b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(packItem.getIsSelected() ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Recent extends StickerCategoryViewHolder {
        private final StickerCategoryItemRecentBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemRecentBinding.f15265a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemRecentBinding;
        }

        public final void configure(StickerCategoryItem.RecentItem categoryItem, Function0<Unit> onRecentClicked) {
            Intrinsics3.checkNotNullParameter(categoryItem, "categoryItem");
            Intrinsics3.checkNotNullParameter(onRecentClicked, "onRecentClicked");
            View view = this.binding.f15266b.f1066b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(categoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder4(onRecentClicked));
        }
    }

    private StickerCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ StickerCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
