package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.StickerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAutocompleteStickerAdapter3 extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, WidgetChatInputAutocompleteStickerAdapter2> {
    private final StickerAutocompleteItemBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.StickerViewHolder$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
    public static final class ViewOnClickListenerC77001 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2 $data;

        public ViewOnClickListenerC77001(WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2) {
            this.$data = widgetChatInputAutocompleteStickerAdapter2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInputAutocompleteStickerAdapter3.access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3.this).getOnClickSticker().invoke(this.$data.getSticker());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAutocompleteStickerAdapter3(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(C5419R.layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3 widgetChatInputAutocompleteStickerAdapter3) {
        return (WidgetChatInputAutocompleteStickerAdapter) widgetChatInputAutocompleteStickerAdapter3.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2) {
        onConfigure2(i, widgetChatInputAutocompleteStickerAdapter2);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatInputAutocompleteStickerAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerView.m8613e(this.binding.f15258b, data.getSticker(), null, 2);
        this.binding.f15258b.m8614b();
        this.binding.f15257a.setOnClickListener(new ViewOnClickListenerC77001(data));
    }
}
