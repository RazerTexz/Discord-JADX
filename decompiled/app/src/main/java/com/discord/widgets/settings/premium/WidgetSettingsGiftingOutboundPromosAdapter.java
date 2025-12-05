package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewGiftOutboundPromoListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.recycler.SimpleItemCallback;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter extends ListAdapter<SettingsGiftingViewModel.OutboundPromoItem, OutboundPromoViewHolder> {
    private static final SimpleItemCallback<SettingsGiftingViewModel.OutboundPromoItem> DIFF_CALLBACK = new SimpleItemCallback<>(WidgetSettingsGiftingOutboundPromosAdapter2.INSTANCE);
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

    /* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
    public static final class OutboundPromoViewHolder extends RecyclerView.ViewHolder {
        private final ViewGiftOutboundPromoListItemBinding binding;
        private SettingsGiftingViewModel.OutboundPromoItem boundItem;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OutboundPromoViewHolder(ViewGroup viewGroup, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function12) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(C5419R.layout.view_gift_outbound_promo_list_item, viewGroup, false));
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
            Intrinsics3.checkNotNullParameter(function12, "onButtonClick");
            this.onMoreDetailsClick = function1;
            this.onButtonClick = function12;
            View view = this.itemView;
            int i = C5419R.id.giftPromoButton;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.giftPromoButton);
            if (materialButton != null) {
                i = C5419R.id.giftPromoDescription;
                TextView textView = (TextView) view.findViewById(C5419R.id.giftPromoDescription);
                if (textView != null) {
                    i = C5419R.id.giftPromoImage;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.giftPromoImage);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.giftPromoMoreDetails;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.giftPromoMoreDetails);
                        if (textView2 != null) {
                            i = C5419R.id.giftPromoTitle;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.giftPromoTitle);
                            if (textView3 != null) {
                                ViewGiftOutboundPromoListItemBinding viewGiftOutboundPromoListItemBinding = new ViewGiftOutboundPromoListItemBinding((MaterialCardView) view, materialButton, textView, simpleDraweeView, textView2, textView3);
                                textView2.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter3(this));
                                materialButton.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter4(this));
                                Intrinsics3.checkNotNullExpressionValue(viewGiftOutboundPromoListItemBinding, "ViewGiftOutboundPromoLis…nClick(boundItem) }\n    }");
                                this.binding = viewGiftOutboundPromoListItemBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ SettingsGiftingViewModel.OutboundPromoItem access$getBoundItem$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem = outboundPromoViewHolder.boundItem;
            if (outboundPromoItem == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("boundItem");
            }
            return outboundPromoItem;
        }

        public static final /* synthetic */ Function1 access$getOnButtonClick$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            return outboundPromoViewHolder.onButtonClick;
        }

        public static final /* synthetic */ Function1 access$getOnMoreDetailsClick$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            return outboundPromoViewHolder.onMoreDetailsClick;
        }

        public static final /* synthetic */ void access$setBoundItem$p(OutboundPromoViewHolder outboundPromoViewHolder, SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            outboundPromoViewHolder.boundItem = outboundPromoItem;
        }

        public final void bindTo(SettingsGiftingViewModel.OutboundPromoItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            this.boundItem = item;
            SimpleDraweeView simpleDraweeView = this.binding.f15437d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.giftPromoImage");
            IconUtils.setIcon$default(simpleDraweeView, item.getImageUrl(), 0, (Function1) null, new MGImages.DistinctChangeDetector(), 12, (Object) null);
            TextView textView = this.binding.f15439f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftPromoTitle");
            textView.setText(item.getTitle());
            ClaimStatus claimStatus = item.getClaimStatus();
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                long dateTimeMillis = ((ClaimStatus.Unclaimed) item.getClaimStatus()).getClaimBy().getDateTimeMillis();
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                String strRenderUtcDate = timeUtils.renderUtcDate(dateTimeMillis, context, 1);
                TextView textView2 = this.binding.f15436c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftPromoDescription");
                FormatUtils.m222n(textView2, C5419R.string.mobile_outbound_promotion_card_unclaimed_body, new Object[]{strRenderUtcDate}, null, 4);
                MaterialButton materialButton = this.binding.f15435b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftPromoButton");
                FormatUtils.m222n(materialButton, C5419R.string.promotion_card_action_claim, new Object[0], null, 4);
                return;
            }
            if (claimStatus instanceof ClaimStatus.Claimed) {
                long dateTimeMillis2 = ((ClaimStatus.Claimed) item.getClaimStatus()).getRedeemBy().getDateTimeMillis();
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                Context context2 = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
                String strRenderUtcDate2 = timeUtils2.renderUtcDate(dateTimeMillis2, context2, 1);
                TextView textView3 = this.binding.f15436c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.giftPromoDescription");
                FormatUtils.m222n(textView3, C5419R.string.mobile_outbound_promotion_card_claimed_body, new Object[]{strRenderUtcDate2}, null, 4);
                MaterialButton materialButton2 = this.binding.f15435b;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.giftPromoButton");
                FormatUtils.m222n(materialButton2, C5419R.string.outbound_promotion_see_code, new Object[0], null, 4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsGiftingOutboundPromosAdapter(Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function12) {
        super(DIFF_CALLBACK);
        Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
        Intrinsics3.checkNotNullParameter(function12, "onButtonClick");
        this.onMoreDetailsClick = function1;
        this.onButtonClick = function12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((OutboundPromoViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(OutboundPromoViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        SettingsGiftingViewModel.OutboundPromoItem item = getItem(position);
        Intrinsics3.checkNotNullExpressionValue(item, "getItem(position)");
        holder.bindTo(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OutboundPromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new OutboundPromoViewHolder(parent, this.onMoreDetailsClick, this.onButtonClick);
    }
}
