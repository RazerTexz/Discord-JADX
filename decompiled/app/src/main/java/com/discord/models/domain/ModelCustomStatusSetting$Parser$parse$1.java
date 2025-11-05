package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelCustomStatusSetting.kt */
/* loaded from: classes.dex */
public final class ModelCustomStatusSetting$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $emojiId;
    public final /* synthetic */ Ref$ObjectRef $emojiName;
    public final /* synthetic */ Ref$ObjectRef $expiresAt;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $text;

    public ModelCustomStatusSetting$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4) {
        this.$text = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$emojiId = ref$ObjectRef2;
        this.$emojiName = ref$ObjectRef3;
        this.$expiresAt = ref$ObjectRef4;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -833811170:
                    if (str.equals("expires_at")) {
                        this.$expiresAt.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 3556653:
                    if (str.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                        this.$text.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 749661924:
                    if (str.equals("emoji_name")) {
                        this.$emojiName.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 1162789812:
                    if (str.equals("emoji_id")) {
                        this.$emojiId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
