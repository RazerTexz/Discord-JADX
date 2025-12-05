package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GifCategoryViewHolder.kt */
/* loaded from: classes2.dex */
public final class GifCategoryViewHolder extends RecyclerView.ViewHolder {
    private final GifCategoryItemViewBinding binding;

    /* compiled from: GifCategoryViewHolder.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewHolder$configure$1 */
    public static final class ViewOnClickListenerC78671 implements View.OnClickListener {
        public final /* synthetic */ GifCategoryItem $gifCategoryItem;
        public final /* synthetic */ Function1 $onSelectGifCategory;

        public ViewOnClickListenerC78671(Function1 function1, GifCategoryItem gifCategoryItem) {
            this.$onSelectGifCategory = function1;
            this.$gifCategoryItem = gifCategoryItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$onSelectGifCategory;
            if (function1 != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewHolder(GifCategoryItemViewBinding gifCategoryItemViewBinding) {
        super(gifCategoryItemViewBinding.f15099a);
        Intrinsics3.checkNotNullParameter(gifCategoryItemViewBinding, "binding");
        this.binding = gifCategoryItemViewBinding;
        this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
    }

    private final void setPreviewImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.f15101c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.gifCategoryItemPreview");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        SimpleDraweeView simpleDraweeView2 = this.binding.f15101c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.gifCategoryItemPreview");
        MGImages.setImage$default(simpleDraweeView2, imageUrl, i, i2, false, null, null, 112, null);
    }

    public final void configure(GifCategoryItem gifCategoryItem, Function1<? super GifCategoryItem, Unit> onSelectGifCategory) {
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        if (gifCategoryItem instanceof GifCategoryItem.Standard) {
            ModelGifCategory gifCategory = ((GifCategoryItem.Standard) gifCategoryItem).getGifCategory();
            setPreviewImage(gifCategory.getGifPreviewUrl());
            TextView textView = this.binding.f15102d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifCategoryItemTitle");
            textView.setText(gifCategory.getCategoryName());
            ImageView imageView = this.binding.f15100b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.gifCategoryItemIcon");
            imageView.setVisibility(8);
        } else if (gifCategoryItem instanceof GifCategoryItem.Trending) {
            setPreviewImage(((GifCategoryItem.Trending) gifCategoryItem).getGifPreviewUrl());
            TextView textView2 = this.binding.f15102d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.gifCategoryItemTitle");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView2.setText(view.getResources().getString(C5419R.string.gif_picker_result_type_trending_gifs));
            ImageView imageView2 = this.binding.f15100b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.gifCategoryItemIcon");
            imageView2.setVisibility(0);
            ImageView imageView3 = this.binding.f15100b;
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            imageView3.setImageDrawable(ResourcesCompat.getDrawable(view2.getResources(), C5419R.drawable.ic_analytics_16dp, null));
        }
        this.itemView.setOnClickListener(new ViewOnClickListenerC78671(onSelectGifCategory, gifCategoryItem));
    }
}
