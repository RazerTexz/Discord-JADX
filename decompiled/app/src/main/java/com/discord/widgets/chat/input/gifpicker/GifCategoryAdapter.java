package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: GifCategoryAdapter.kt */
/* loaded from: classes2.dex */
public final class GifCategoryAdapter extends RecyclerView.Adapter<GifCategoryViewHolder> {
    private final DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator;
    private List<? extends GifCategoryItem> items;
    private final Function1<GifCategoryItem, Unit> onSelectGifCategory;

    /* compiled from: GifCategoryAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryAdapter$setItems$1 */
    public static final class C78661 extends Lambda implements Function1<List<? extends GifCategoryItem>, Unit> {
        public C78661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifCategoryItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GifCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GifCategoryAdapter.access$setItems$p(GifCategoryAdapter.this, list);
        }
    }

    public /* synthetic */ GifCategoryAdapter(AppComponent appComponent, Function1 function1, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, function1, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GifCategoryAdapter gifCategoryAdapter) {
        return gifCategoryAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GifCategoryAdapter gifCategoryAdapter, List list) {
        gifCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((GifCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GifCategoryItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C78661(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifCategoryAdapter(AppComponent appComponent, Function1<? super GifCategoryItem, Unit> function1, DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGifCategory = function1;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(GifCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position), this.onSelectGifCategory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GifCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.gif_category_item_view, parent, false);
        int i = C5419R.id.gif_category_item_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.gif_category_item_icon);
        if (imageView != null) {
            i = C5419R.id.gif_category_item_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.gif_category_item_preview);
            if (simpleDraweeView != null) {
                i = C5419R.id.gif_category_item_title;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.gif_category_item_title);
                if (textView != null) {
                    GifCategoryItemViewBinding gifCategoryItemViewBinding = new GifCategoryItemViewBinding((CardView) viewInflate, imageView, simpleDraweeView, textView);
                    Intrinsics3.checkNotNullExpressionValue(gifCategoryItemViewBinding, "GifCategoryItemViewBindi….context), parent, false)");
                    return new GifCategoryViewHolder(gifCategoryItemViewBinding);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
