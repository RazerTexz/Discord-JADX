package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.WidgetChatInputEmojiAutocompleteUpsellItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.views.PileView;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiAutocompleteUpsellViewHolder.kt */
/* loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputEmojiAutocompleteUpsellItemBinding binding;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* compiled from: EmojiAutocompleteUpsellViewHolder.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.EmojiAutocompleteUpsellViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder;

        public AnonymousClass1(EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
            this.$emojiUpsellPlaceholder = emojiUpsellPlaceholder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EmojiAutocompleteUpsellViewHolder.access$getOnItemSelected$p(EmojiAutocompleteUpsellViewHolder.this).invoke(this.$emojiUpsellPlaceholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiAutocompleteUpsellViewHolder(WidgetChatInputEmojiAutocompleteUpsellItemBinding widgetChatInputEmojiAutocompleteUpsellItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputEmojiAutocompleteUpsellItemBinding.a);
        m.checkNotNullParameter(widgetChatInputEmojiAutocompleteUpsellItemBinding, "binding");
        m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputEmojiAutocompleteUpsellItemBinding;
        this.onItemSelected = function1;
    }

    public static final /* synthetic */ WidgetChatInputEmojiAutocompleteUpsellItemBinding access$getBinding$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.binding;
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.onItemSelected;
    }

    public final void bind(EmojiUpsellPlaceholder emojiUpsellPlaceholder) throws Resources.NotFoundException {
        m.checkNotNullParameter(emojiUpsellPlaceholder, "emojiUpsellPlaceholder");
        int lockedTotal = emojiUpsellPlaceholder.getLockedTotal();
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        Resources resources = linearLayout.getResources();
        String string = resources.getString(R.string.autocomplete_emoji_upsell);
        m.checkNotNullExpressionValue(string, "resources.getString(R.st…utocomplete_emoji_upsell)");
        String quantityString = resources.getQuantityString(R.plurals.autocomplete_emoji_upsell_count, lockedTotal);
        m.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…moji_upsell_count, count)");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.chatInputEmojiUpsellText");
        b.o(textView, string, new Object[]{b.l(quantityString, new Object[]{Integer.valueOf(lockedTotal)}, null, 2)}, null, 4);
        List<Emoji> lockedFirstThree = emojiUpsellPlaceholder.getLockedFirstThree();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(lockedFirstThree, 10));
        Iterator<T> it = lockedFirstThree.iterator();
        while (it.hasNext()) {
            arrayList.add(new PileView.c(new EmojiAutocompleteUpsellViewHolder$bind$$inlined$map$lambda$1((Emoji) it.next(), this, emojiUpsellPlaceholder), null));
        }
        this.binding.f2306b.setItems(arrayList);
        this.binding.a.setOnClickListener(new AnonymousClass1(emojiUpsellPlaceholder));
    }
}
