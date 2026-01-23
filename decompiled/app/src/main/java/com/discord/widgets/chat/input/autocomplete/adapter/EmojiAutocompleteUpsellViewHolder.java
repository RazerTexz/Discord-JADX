package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatInputEmojiAutocompleteUpsellItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.views.PileView;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: EmojiAutocompleteUpsellViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputEmojiAutocompleteUpsellItemBinding binding;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.EmojiAutocompleteUpsellViewHolder$bind$1 */
    /* JADX INFO: compiled from: EmojiAutocompleteUpsellViewHolder.kt */
    public static final class ViewOnClickListenerC78001 implements View.OnClickListener {
        public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder;

        public ViewOnClickListenerC78001(EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
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
        super(widgetChatInputEmojiAutocompleteUpsellItemBinding.f16117a);
        Intrinsics3.checkNotNullParameter(widgetChatInputEmojiAutocompleteUpsellItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputEmojiAutocompleteUpsellItemBinding;
        this.onItemSelected = function1;
    }

    public static final /* synthetic */ WidgetChatInputEmojiAutocompleteUpsellItemBinding access$getBinding$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.binding;
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.onItemSelected;
    }

    public final void bind(EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
        Intrinsics3.checkNotNullParameter(emojiUpsellPlaceholder, "emojiUpsellPlaceholder");
        int lockedTotal = emojiUpsellPlaceholder.getLockedTotal();
        LinearLayout linearLayout = this.binding.f16117a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        Resources resources = linearLayout.getResources();
        String string = resources.getString(C5419R.string.autocomplete_emoji_upsell);
        Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(R.st…utocomplete_emoji_upsell)");
        String quantityString = resources.getQuantityString(C5419R.plurals.autocomplete_emoji_upsell_count, lockedTotal);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…moji_upsell_count, count)");
        TextView textView = this.binding.f16119c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputEmojiUpsellText");
        FormatUtils.m223o(textView, string, new Object[]{FormatUtils.m220l(quantityString, new Object[]{Integer.valueOf(lockedTotal)}, null, 2)}, null, 4);
        List<Emoji> lockedFirstThree = emojiUpsellPlaceholder.getLockedFirstThree();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(lockedFirstThree, 10));
        Iterator<T> it = lockedFirstThree.iterator();
        while (it.hasNext()) {
            arrayList.add(new PileView.C7089c(new EmojiAutocompleteUpsellViewHolder2((Emoji) it.next(), this, emojiUpsellPlaceholder), null));
        }
        this.binding.f16118b.setItems(arrayList);
        this.binding.f16117a.setOnClickListener(new ViewOnClickListenerC78001(emojiUpsellPlaceholder));
    }
}
