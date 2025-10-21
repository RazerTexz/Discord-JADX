package com.discord.widgets.phone;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import d0.z.d.Intrinsics3;

/* compiled from: PhoneCountryCodeAdapterItem.kt */
/* loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem extends RecyclerView.ViewHolder {
    private final PhoneCountryCodeAdapter adapter;
    private final WidgetPhoneCountryCodeListItemBinding binding;

    /* compiled from: PhoneCountryCodeAdapterItem.kt */
    /* renamed from: com.discord.widgets.phone.PhoneCountryCodeAdapterItem$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ PhoneCountryCode $data;

        public AnonymousClass1(PhoneCountryCode phoneCountryCode) {
            this.$data = phoneCountryCode;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PhoneCountryCodeAdapter2 onCountryCodeSelectedListener = PhoneCountryCodeAdapterItem.access$getAdapter$p(PhoneCountryCodeAdapterItem.this).getOnCountryCodeSelectedListener();
            if (onCountryCodeSelectedListener != null) {
                onCountryCodeSelectedListener.onCountryCodeSelected(this.$data);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountryCodeAdapterItem(PhoneCountryCodeAdapter phoneCountryCodeAdapter, WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding) {
        super(widgetPhoneCountryCodeListItemBinding.a);
        Intrinsics3.checkNotNullParameter(phoneCountryCodeAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(widgetPhoneCountryCodeListItemBinding, "binding");
        this.adapter = phoneCountryCodeAdapter;
        this.binding = widgetPhoneCountryCodeListItemBinding;
    }

    public static final /* synthetic */ PhoneCountryCodeAdapter access$getAdapter$p(PhoneCountryCodeAdapterItem phoneCountryCodeAdapterItem) {
        return phoneCountryCodeAdapterItem.adapter;
    }

    public final void bind(PhoneCountryCode data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.phoneCountryCodeName");
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(phoneUtils.getTranslatedStringForCountry(data, context));
        TextView textView2 = this.binding.f2510b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.phoneCountryCodeCode");
        textView2.setText(data.getPhoneCountryCode());
        this.binding.c.setOnClickListener(new AnonymousClass1(data));
    }
}
