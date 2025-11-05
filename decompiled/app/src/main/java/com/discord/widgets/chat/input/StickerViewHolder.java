package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import d0.z.d.m;

/* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* loaded from: classes2.dex */
public final class StickerViewHolder extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, AutocompleteStickerItem> {
    private final StickerAutocompleteItemBinding binding;

    /* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.StickerViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AutocompleteStickerItem $data;

        public AnonymousClass1(AutocompleteStickerItem autocompleteStickerItem) {
            this.$data = autocompleteStickerItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerViewHolder.access$getAdapter$p(StickerViewHolder.this).getOnClickSticker().invoke(this.$data.getSticker());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(R.layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        m.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        m.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(StickerViewHolder stickerViewHolder) {
        return (WidgetChatInputAutocompleteStickerAdapter) stickerViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, AutocompleteStickerItem autocompleteStickerItem) {
        onConfigure2(i, autocompleteStickerItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, AutocompleteStickerItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StickerView.e(this.binding.f2147b, data.getSticker(), null, 2);
        this.binding.f2147b.b();
        this.binding.a.setOnClickListener(new AnonymousClass1(data));
    }
}
