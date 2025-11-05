package com.discord.widgets.settings.premium;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.databinding.WidgetChoosePlanAdapterHeaderItemBinding;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChoosePlanAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan;

    /* compiled from: WidgetChoosePlanAdapter.kt */
    public static final class DividerViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_divider_item, widgetChoosePlanAdapter);
            m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_header_item, widgetChoosePlanAdapter);
            m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.select_subscription_header_text);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.select_subscription_header_text)));
            }
            WidgetChoosePlanAdapterHeaderItemBinding widgetChoosePlanAdapterHeaderItemBinding = new WidgetChoosePlanAdapterHeaderItemBinding((FrameLayout) view, textView);
            m.checkNotNullExpressionValue(widgetChoosePlanAdapterHeaderItemBinding, "WidgetChoosePlanAdapterH…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2347b;
            m.checkNotNullExpressionValue(textView, "binding.selectSubscriptionHeaderText");
            b.n(textView, ((Item.Header) data).getTitleStringResId(), new Object[0], null, 4);
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_DIVIDER = 2;
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_PLAN = 1;
        private final int type;

        /* compiled from: WidgetChoosePlanAdapter.kt */
        public static final class Divider extends Item {
            private final String key;

            public Divider() {
                super(2, null);
                this.key = String.valueOf(getType());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }
        }

        /* compiled from: WidgetChoosePlanAdapter.kt */
        public static final /* data */ class Header extends Item {
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i) {
                super(0, null);
                this.titleStringResId = i;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.titleStringResId;
                }
                return header.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public final Header copy(@StringRes int titleStringResId) {
                return new Header(titleStringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.titleStringResId == ((Header) other).titleStringResId;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return this.titleStringResId;
            }

            public String toString() {
                return a.B(a.U("Header(titleStringResId="), this.titleStringResId, ")");
            }
        }

        /* compiled from: WidgetChoosePlanAdapter.kt */
        public static final /* data */ class Plan extends Item {
            private final GooglePlaySku displaySku;
            private final boolean isCurrentPlan;
            private final String key;
            private final String oldSkuName;
            private final GooglePlaySku purchaseSku;
            private final SkuDetails skuDetails;
            private final SkuDetails upgradeSkuDetails;

            public /* synthetic */ Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(googlePlaySku, skuDetails, googlePlaySku2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : skuDetails2, (i & 32) != 0 ? false : z2);
            }

            public static /* synthetic */ Plan copy$default(Plan plan, GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    googlePlaySku = plan.displaySku;
                }
                if ((i & 2) != 0) {
                    skuDetails = plan.skuDetails;
                }
                SkuDetails skuDetails3 = skuDetails;
                if ((i & 4) != 0) {
                    googlePlaySku2 = plan.purchaseSku;
                }
                GooglePlaySku googlePlaySku3 = googlePlaySku2;
                if ((i & 8) != 0) {
                    str = plan.oldSkuName;
                }
                String str2 = str;
                if ((i & 16) != 0) {
                    skuDetails2 = plan.upgradeSkuDetails;
                }
                SkuDetails skuDetails4 = skuDetails2;
                if ((i & 32) != 0) {
                    z2 = plan.isCurrentPlan;
                }
                return plan.copy(googlePlaySku, skuDetails3, googlePlaySku3, str2, skuDetails4, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            /* renamed from: component2, reason: from getter */
            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            /* renamed from: component3, reason: from getter */
            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            /* renamed from: component4, reason: from getter */
            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            /* renamed from: component5, reason: from getter */
            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsCurrentPlan() {
                return this.isCurrentPlan;
            }

            public final Plan copy(GooglePlaySku displaySku, SkuDetails skuDetails, GooglePlaySku purchaseSku, String oldSkuName, SkuDetails upgradeSkuDetails, boolean isCurrentPlan) {
                m.checkNotNullParameter(displaySku, "displaySku");
                m.checkNotNullParameter(skuDetails, "skuDetails");
                return new Plan(displaySku, skuDetails, purchaseSku, oldSkuName, upgradeSkuDetails, isCurrentPlan);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Plan)) {
                    return false;
                }
                Plan plan = (Plan) other;
                return m.areEqual(this.displaySku, plan.displaySku) && m.areEqual(this.skuDetails, plan.skuDetails) && m.areEqual(this.purchaseSku, plan.purchaseSku) && m.areEqual(this.oldSkuName, plan.oldSkuName) && m.areEqual(this.upgradeSkuDetails, plan.upgradeSkuDetails) && this.isCurrentPlan == plan.isCurrentPlan;
            }

            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                GooglePlaySku googlePlaySku = this.displaySku;
                int iHashCode = (googlePlaySku != null ? googlePlaySku.hashCode() : 0) * 31;
                SkuDetails skuDetails = this.skuDetails;
                int iHashCode2 = (iHashCode + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
                GooglePlaySku googlePlaySku2 = this.purchaseSku;
                int iHashCode3 = (iHashCode2 + (googlePlaySku2 != null ? googlePlaySku2.hashCode() : 0)) * 31;
                String str = this.oldSkuName;
                int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                SkuDetails skuDetails2 = this.upgradeSkuDetails;
                int iHashCode5 = (iHashCode4 + (skuDetails2 != null ? skuDetails2.hashCode() : 0)) * 31;
                boolean z2 = this.isCurrentPlan;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode5 + i;
            }

            public final boolean isCurrentPlan() {
                return this.isCurrentPlan;
            }

            public String toString() {
                StringBuilder sbU = a.U("Plan(displaySku=");
                sbU.append(this.displaySku);
                sbU.append(", skuDetails=");
                sbU.append(this.skuDetails);
                sbU.append(", purchaseSku=");
                sbU.append(this.purchaseSku);
                sbU.append(", oldSkuName=");
                sbU.append(this.oldSkuName);
                sbU.append(", upgradeSkuDetails=");
                sbU.append(this.upgradeSkuDetails);
                sbU.append(", isCurrentPlan=");
                return a.O(sbU, this.isCurrentPlan, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2) {
                super(1, null);
                m.checkNotNullParameter(googlePlaySku, "displaySku");
                m.checkNotNullParameter(skuDetails, "skuDetails");
                this.displaySku = googlePlaySku;
                this.skuDetails = skuDetails;
                this.purchaseSku = googlePlaySku2;
                this.oldSkuName = str;
                this.upgradeSkuDetails = skuDetails2;
                this.isCurrentPlan = z2;
                this.key = getType() + googlePlaySku.getSkuName();
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    public static final class PlanViewHeader extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterPlanItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanViewHeader(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_plan_item, widgetChoosePlanAdapter);
            m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingA = WidgetChoosePlanAdapterPlanItemBinding.a(this.itemView);
            m.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingA, "WidgetChoosePlanAdapterP…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterPlanItemBindingA;
        }

        public static final /* synthetic */ WidgetChoosePlanAdapter access$getAdapter$p(PlanViewHeader planViewHeader) {
            return (WidgetChoosePlanAdapter) planViewHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            Item.Plan plan = (Item.Plan) data;
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.planItemName");
            textView.setText(plan.getSkuDetails().a());
            TextView textView2 = this.binding.g;
            m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            MaterialCardView materialCardView = this.binding.c;
            m.checkNotNullExpressionValue(materialCardView, "binding.planItemContainer");
            Context context = materialCardView.getContext();
            m.checkNotNullExpressionValue(context, "binding.planItemContainer.context");
            textView2.setText(premiumUtils.getPlanPriceText(context, plan.getSkuDetails()));
            this.binding.e.setImageResource(plan.getDisplaySku().getIconDrawableResId());
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
            textView3.setVisibility(plan.isCurrentPlan() ? 0 : 8);
            this.binding.f2348b.setImageResource(plan.isCurrentPlan() ? GooglePlaySku.INSTANCE.getBorderResource(plan.getDisplaySku().getType()) : 0);
            if (plan.getPurchaseSku() == null) {
                TextView textView4 = this.binding.g;
                m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView4, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
                return;
            }
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, R.attr.ic_navigate_next, 0, 2, (Object) null);
            TextView textView5 = this.binding.g;
            m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
            DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
            this.binding.c.setOnClickListener(new WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickPlan = WidgetChoosePlanAdapter$onClickPlan$1.INSTANCE;
    }

    public static final /* synthetic */ Function3 access$getOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
        return widgetChoosePlanAdapter.onClickPlan;
    }

    public static final /* synthetic */ void access$setOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter, Function3 function3) {
        widgetChoosePlanAdapter.onClickPlan = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickPlan(Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan) {
        m.checkNotNullParameter(onClickPlan, "onClickPlan");
        this.onClickPlan = onClickPlan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new PlanViewHeader(this);
        }
        if (viewType == 2) {
            return new DividerViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
