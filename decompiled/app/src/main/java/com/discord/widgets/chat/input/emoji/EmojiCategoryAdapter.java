package com.discord.widgets.chat.input.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryAdapter extends RecyclerView.Adapter<EmojiCategoryViewHolder> {
    private final DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator;
    private List<? extends EmojiCategoryItem> items;
    private final Function1<EmojiCategoryItem, Unit> onCategoryClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryAdapter$setItems$1 */
    /* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
    public static final class C78111 extends Lambda implements Function1<List<? extends EmojiCategoryItem>, Unit> {
        public C78111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EmojiCategoryItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EmojiCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            EmojiCategoryAdapter.access$setItems$p(EmojiCategoryAdapter.this, list);
            Iterator<? extends EmojiCategoryItem> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getIsSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                EmojiCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(EmojiCategoryAdapter.this).invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ EmojiCategoryAdapter(Function1 function1, Function1 function12, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, appComponent, (i & 8) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(EmojiCategoryAdapter emojiCategoryAdapter, List list) {
        emojiCategoryAdapter.items = list;
    }

    public final EmojiCategoryItem getItemAtPosition(int position) {
        return this.items.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        EmojiCategoryItem emojiCategoryItem = this.items.get(position);
        if (emojiCategoryItem instanceof EmojiCategoryItem.StandardItem) {
            return 0;
        }
        if (emojiCategoryItem instanceof EmojiCategoryItem.GuildItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((EmojiCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends EmojiCategoryItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C78111(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiCategoryAdapter(Function1<? super EmojiCategoryItem, Unit> function1, Function1<? super Integer, Unit> function12, AppComponent appComponent, DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(function1, "onCategoryClicked");
        Intrinsics3.checkNotNullParameter(function12, "onSelectedItemAdapterPositionUpdated");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onCategoryClicked = function1;
        this.onSelectedItemAdapterPositionUpdated = function12;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(EmojiCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof EmojiCategoryViewHolder.Standard) {
            EmojiCategoryItem emojiCategoryItem = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.StandardItem");
            ((EmojiCategoryViewHolder.Standard) holder).configure((EmojiCategoryItem.StandardItem) emojiCategoryItem, this.onCategoryClicked);
        } else if (holder instanceof EmojiCategoryViewHolder.Guild) {
            EmojiCategoryItem emojiCategoryItem2 = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem2, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.GuildItem");
            ((EmojiCategoryViewHolder.Guild) holder).configure((EmojiCategoryItem.GuildItem) emojiCategoryItem2, this.onCategoryClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmojiCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = C5419R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.emoji_category_item_standard, parent, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.emoji_category_item_standard_icon);
            if (imageView != null) {
                View viewFindViewById = viewInflate.findViewById(C5419R.id.overline);
                if (viewFindViewById != null) {
                    EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding = new EmojiCategoryItemStandardBinding((FrameLayout) viewInflate, imageView, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById, viewFindViewById));
                    Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemStandardBinding, "EmojiCategoryItemStandar…(inflater, parent, false)");
                    return new EmojiCategoryViewHolder.Standard(emojiCategoryItemStandardBinding);
                }
            } else {
                i = C5419R.id.emoji_category_item_standard_icon;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            StringBuilder sbM834V = outline.m834V("invalid viewType ", viewType, " for ");
            sbM834V.append(EmojiCategoryAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbM834V.toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.emoji_category_item_guild, parent, false);
        GuildIcon guildIcon = (GuildIcon) viewInflate2.findViewById(C5419R.id.emoji_category_item_guild_icon);
        if (guildIcon != null) {
            View viewFindViewById2 = viewInflate2.findViewById(C5419R.id.overline);
            if (viewFindViewById2 != null) {
                EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding = new EmojiCategoryItemGuildBinding((FrameLayout) viewInflate2, guildIcon, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById2, viewFindViewById2));
                Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemGuildBinding, "EmojiCategoryItemGuildBi…(inflater, parent, false)");
                return new EmojiCategoryViewHolder.Guild(emojiCategoryItemGuildBinding);
            }
        } else {
            i = C5419R.id.emoji_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
