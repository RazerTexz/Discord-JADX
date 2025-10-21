package com.discord.utilities.textprocessing;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function3;

/* compiled from: Rules.kt */
/* loaded from: classes2.dex */
public final class Rules$createCustomEmojiRule$1$parse$emojiNode$1 extends Lambda implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ long $emojiId;
    public final /* synthetic */ boolean $isAnimated;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createCustomEmojiRule$1$parse$emojiNode$1(long j, boolean z2) {
        super(3);
        this.$emojiId = j;
        this.$isAnimated = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 2>");
        String imageUri = ModelEmojiCustom.getImageUri(this.$emojiId, z2 && this.$isAnimated, i);
        Intrinsics3.checkNotNullExpressionValue(imageUri, "ModelEmojiCustom.getImag…bled && isAnimated, size)");
        return imageUri;
    }
}
