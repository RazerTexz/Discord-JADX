package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.PaymentMethodListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: PaymentSourceAdapter.kt */
/* loaded from: classes2.dex */
public final class PaymentSourceAdapter extends MGRecyclerAdapterSimple<Item> {
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_PAYMENT_ADD = 1;
    private static final int VIEW_TYPE_PAYMENT_SOURCE = 0;
    private final Function0<Unit> onAddClick;
    private final Function1<ModelPaymentSource, Unit> onEditPaymentSource;

    /* compiled from: PaymentSourceAdapter.kt */
    public interface Item extends MGRecyclerDataPayload {
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final class PaymentSourceAddItem implements Item {
        private final int type = 1;
        private final String key = "AddPaymentSource";

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final class PaymentSourceAddViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceAddViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_add_item, paymentSourceAdapter);
            m.checkNotNullParameter(paymentSourceAdapter, "adapter");
        }

        public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceAddViewHolder paymentSourceAddViewHolder) {
            return (PaymentSourceAdapter) paymentSourceAddViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            m.checkNotNullParameter(data, "data");
            this.itemView.setOnClickListener(new PaymentSourceAdapter$PaymentSourceAddViewHolder$onConfigure$1(this));
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final /* data */ class PaymentSourceHeader implements Item {
        private final Type headerType;
        private final String key;
        private final int type;

        /* compiled from: PaymentSourceAdapter.kt */
        public enum Type {
            DEFAULT,
            OTHER
        }

        public PaymentSourceHeader(Type type) {
            m.checkNotNullParameter(type, "headerType");
            this.headerType = type;
            this.type = 2;
            this.key = "headerType" + type;
        }

        public static /* synthetic */ PaymentSourceHeader copy$default(PaymentSourceHeader paymentSourceHeader, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                type = paymentSourceHeader.headerType;
            }
            return paymentSourceHeader.copy(type);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getHeaderType() {
            return this.headerType;
        }

        public final PaymentSourceHeader copy(Type headerType) {
            m.checkNotNullParameter(headerType, "headerType");
            return new PaymentSourceHeader(headerType);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PaymentSourceHeader) && m.areEqual(this.headerType, ((PaymentSourceHeader) other).headerType);
            }
            return true;
        }

        public final Type getHeaderType() {
            return this.headerType;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.headerType;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("PaymentSourceHeader(headerType=");
            sbU.append(this.headerType);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final class PaymentSourceHeaderViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                PaymentSourceHeader.Type.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[PaymentSourceHeader.Type.DEFAULT.ordinal()] = 1;
                iArr[PaymentSourceHeader.Type.OTHER.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceHeaderViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_header, paymentSourceAdapter);
            m.checkNotNullParameter(paymentSourceAdapter, "adapter");
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            int i;
            m.checkNotNullParameter(data, "data");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            int iOrdinal = ((PaymentSourceHeader) data).getHeaderType().ordinal();
            if (iOrdinal == 0) {
                i = R.string._default;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.other_options;
            }
            textView.setText(i);
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final /* data */ class PaymentSourceItem implements Item {
        private final boolean isPremium;
        private final String key;
        private final ModelPaymentSource paymentSource;
        private final int type;

        public PaymentSourceItem(ModelPaymentSource modelPaymentSource, boolean z2) {
            m.checkNotNullParameter(modelPaymentSource, "paymentSource");
            this.paymentSource = modelPaymentSource;
            this.isPremium = z2;
            this.key = modelPaymentSource.getId();
        }

        public static /* synthetic */ PaymentSourceItem copy$default(PaymentSourceItem paymentSourceItem, ModelPaymentSource modelPaymentSource, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelPaymentSource = paymentSourceItem.paymentSource;
            }
            if ((i & 2) != 0) {
                z2 = paymentSourceItem.isPremium;
            }
            return paymentSourceItem.copy(modelPaymentSource, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelPaymentSource getPaymentSource() {
            return this.paymentSource;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsPremium() {
            return this.isPremium;
        }

        public final PaymentSourceItem copy(ModelPaymentSource paymentSource, boolean isPremium) {
            m.checkNotNullParameter(paymentSource, "paymentSource");
            return new PaymentSourceItem(paymentSource, isPremium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentSourceItem)) {
                return false;
            }
            PaymentSourceItem paymentSourceItem = (PaymentSourceItem) other;
            return m.areEqual(this.paymentSource, paymentSourceItem.paymentSource) && this.isPremium == paymentSourceItem.isPremium;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final ModelPaymentSource getPaymentSource() {
            return this.paymentSource;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelPaymentSource modelPaymentSource = this.paymentSource;
            int iHashCode = (modelPaymentSource != null ? modelPaymentSource.hashCode() : 0) * 31;
            boolean z2 = this.isPremium;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isPremium() {
            return this.isPremium;
        }

        public String toString() {
            StringBuilder sbU = a.U("PaymentSourceItem(paymentSource=");
            sbU.append(this.paymentSource);
            sbU.append(", isPremium=");
            return a.O(sbU, this.isPremium, ")");
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    public static final class PaymentSourceItemViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {
        private final PaymentMethodListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceItemViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_item, paymentSourceAdapter);
            m.checkNotNullParameter(paymentSourceAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.payment_method_edit;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.payment_method_edit);
            if (materialButton != null) {
                i = R.id.payment_method_summary;
                PaymentSourceView paymentSourceView = (PaymentSourceView) view.findViewById(R.id.payment_method_summary);
                if (paymentSourceView != null) {
                    PaymentMethodListItemBinding paymentMethodListItemBinding = new PaymentMethodListItemBinding((RelativeLayout) view, materialButton, paymentSourceView);
                    m.checkNotNullExpressionValue(paymentMethodListItemBinding, "PaymentMethodListItemBinding.bind(itemView)");
                    this.binding = paymentMethodListItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceItemViewHolder paymentSourceItemViewHolder) {
            return (PaymentSourceAdapter) paymentSourceItemViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            m.checkNotNullParameter(data, "data");
            PaymentSourceItem paymentSourceItem = (PaymentSourceItem) data;
            ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
            this.binding.c.bind(paymentSource, paymentSourceItem.isPremium());
            this.binding.f2134b.setOnClickListener(new PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1(this, paymentSource));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentSourceAdapter(RecyclerView recyclerView, Function0<Unit> function0, Function1<? super ModelPaymentSource, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function0, "onAddClick");
        m.checkNotNullParameter(function1, "onEditPaymentSource");
        this.onAddClick = function0;
        this.onEditPaymentSource = function1;
    }

    public static final /* synthetic */ Function0 access$getOnAddClick$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onAddClick;
    }

    public static final /* synthetic */ Function1 access$getOnEditPaymentSource$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onEditPaymentSource;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new PaymentSourceItemViewHolder(this);
        }
        if (viewType == 1) {
            return new PaymentSourceAddViewHolder(this);
        }
        if (viewType == 2) {
            return new PaymentSourceHeaderViewHolder(this);
        }
        throw new IllegalArgumentException(a.q("unknown type ", viewType));
    }
}
