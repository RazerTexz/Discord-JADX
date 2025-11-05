package com.discord.widgets.chat.input.sticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerCategoryAdapter.kt */
/* loaded from: classes2.dex */
public final class StickerCategoryAdapter extends RecyclerView.Adapter<StickerCategoryViewHolder> {
    private final DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator;
    private List<? extends StickerCategoryItem> items;
    private final Function1<StickerCategoryItem.GuildItem, Unit> onGuildClicked;
    private final Function1<StickerCategoryItem.PackItem, Unit> onPackClicked;
    private final Function0<Unit> onRecentClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* compiled from: StickerCategoryAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends StickerCategoryItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends StickerCategoryItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends StickerCategoryItem> list) {
            m.checkNotNullParameter(list, "items");
            StickerCategoryAdapter.access$setItems$p(StickerCategoryAdapter.this, list);
            Iterator<? extends StickerCategoryItem> it = list.iterator();
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
                StickerCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(StickerCategoryAdapter.this).invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ StickerCategoryAdapter(Function1 function1, Function1 function12, Function0 function0, Function1 function13, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function0, function13, appComponent, (i & 32) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(StickerCategoryAdapter stickerCategoryAdapter, List list) {
        stickerCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return -1L;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return ((StickerCategoryItem.PackItem) stickerCategoryItem).getPack().getId();
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return ((StickerCategoryItem.GuildItem) stickerCategoryItem).getGuild().getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return 0;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return 1;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((StickerCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends StickerCategoryItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerCategoryAdapter(Function1<? super StickerCategoryItem.GuildItem, Unit> function1, Function1<? super StickerCategoryItem.PackItem, Unit> function12, Function0<Unit> function0, Function1<? super Integer, Unit> function13, AppComponent appComponent, DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator) {
        m.checkNotNullParameter(function1, "onGuildClicked");
        m.checkNotNullParameter(function12, "onPackClicked");
        m.checkNotNullParameter(function0, "onRecentClicked");
        m.checkNotNullParameter(function13, "onSelectedItemAdapterPositionUpdated");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onGuildClicked = function1;
        this.onPackClicked = function12;
        this.onRecentClicked = function0;
        this.onSelectedItemAdapterPositionUpdated = function13;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(StickerCategoryViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            ((StickerCategoryViewHolder.Recent) holder).configure((StickerCategoryItem.RecentItem) stickerCategoryItem, this.onRecentClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            ((StickerCategoryViewHolder.Pack) holder).configure((StickerCategoryItem.PackItem) stickerCategoryItem, this.onPackClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            ((StickerCategoryViewHolder.Guild) holder).configure((StickerCategoryItem.GuildItem) stickerCategoryItem, this.onGuildClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StickerCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.sticker_category_item_recent, parent, false);
            View viewFindViewById = viewInflate.findViewById(R.id.overline);
            if (viewFindViewById == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.overline)));
            }
            StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding = new StickerCategoryItemRecentBinding((FrameLayout) viewInflate, new b.a.i.n(viewFindViewById, viewFindViewById));
            m.checkNotNullExpressionValue(stickerCategoryItemRecentBinding, "StickerCategoryItemRecen…(inflater, parent, false)");
            return new StickerCategoryViewHolder.Recent(stickerCategoryItemRecentBinding);
        }
        if (viewType == 1) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.sticker_category_item_pack, parent, false);
            View viewFindViewById2 = viewInflate2.findViewById(R.id.overline);
            if (viewFindViewById2 != null) {
                b.a.i.n nVar = new b.a.i.n(viewFindViewById2, viewFindViewById2);
                StickerView stickerView = (StickerView) viewInflate2.findViewById(R.id.sticker_category_item_pack_avatar);
                if (stickerView != null) {
                    StickerCategoryItemPackBinding stickerCategoryItemPackBinding = new StickerCategoryItemPackBinding((FrameLayout) viewInflate2, nVar, stickerView);
                    m.checkNotNullExpressionValue(stickerCategoryItemPackBinding, "StickerCategoryItemPackB…(inflater, parent, false)");
                    return new StickerCategoryViewHolder.Pack(stickerCategoryItemPackBinding);
                }
                i = R.id.sticker_category_item_pack_avatar;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        if (viewType != 2) {
            throw new IllegalStateException(a.q("Invalid Sticker Category Type: ", viewType));
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.sticker_category_item_guild, parent, false);
        View viewFindViewById3 = viewInflate3.findViewById(R.id.overline);
        if (viewFindViewById3 != null) {
            b.a.i.n nVar2 = new b.a.i.n(viewFindViewById3, viewFindViewById3);
            GuildIcon guildIcon = (GuildIcon) viewInflate3.findViewById(R.id.sticker_category_item_guild_icon);
            if (guildIcon != null) {
                StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding = new StickerCategoryItemGuildBinding((FrameLayout) viewInflate3, nVar2, guildIcon);
                m.checkNotNullExpressionValue(stickerCategoryItemGuildBinding, "StickerCategoryItemGuild…(inflater, parent, false)");
                return new StickerCategoryViewHolder.Guild(stickerCategoryItemGuildBinding);
            }
            i = R.id.sticker_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
