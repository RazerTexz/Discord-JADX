package com.discord.widgets.voice.settings;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelVoiceRegion;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1 */
/* loaded from: classes.dex */
public final class C10560xd6cee3fb<T> implements Comparator {
    public final /* synthetic */ Comparator $comparator;

    public C10560xd6cee3fb(Comparator comparator) {
        this.$comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return this.$comparator.compare(((ModelVoiceRegion) t).getName(), ((ModelVoiceRegion) t2).getName());
    }
}
