package com.discord.widgets.botuikit.views;

import com.discord.C5419R;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ComponentViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentViewUtils {
    public static final ComponentViewUtils INSTANCE = new ComponentViewUtils();

    private ComponentViewUtils() {
    }

    public final void setEmojiOrHide(SimpleDraweeView simpleDraweeView, ComponentEmoji componentEmoji, boolean z2) {
        String imageUri;
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "$this$setEmojiOrHide");
        if (componentEmoji == null) {
            simpleDraweeView.setVisibility(8);
            return;
        }
        boolean z3 = false;
        simpleDraweeView.setVisibility(0);
        String id2 = componentEmoji.getId();
        Long longOrNull = id2 != null ? StringNumberConversions.toLongOrNull(id2) : null;
        if (longOrNull != null) {
            long jLongValue = longOrNull.longValue();
            if (z2 && Intrinsics3.areEqual(componentEmoji.getAnimated(), Boolean.TRUE)) {
                z3 = true;
            }
            imageUri = ModelEmojiCustom.getImageUri(jLongValue, z3, 64);
        } else {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(componentEmoji.getName());
            imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, simpleDraweeView.getContext());
        }
        if (!Intrinsics3.areEqual(simpleDraweeView.getTag(C5419R.string.tag_emoji_url), imageUri)) {
            simpleDraweeView.setTag(C5419R.string.tag_emoji_url, imageUri);
            MGImages.setImage$default(simpleDraweeView, imageUri, C5419R.dimen.emoji_size, C5419R.dimen.emoji_size, true, null, null, 96, null);
        }
    }
}
