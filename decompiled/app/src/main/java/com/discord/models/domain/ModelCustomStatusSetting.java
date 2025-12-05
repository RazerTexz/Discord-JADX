package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelCustomStatusSetting.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelCustomStatusSetting {
    private final Long emojiId;
    private final String emojiName;
    private final String expiresAt;
    private final String text;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelCustomStatusSetting CLEAR = new ModelCustomStatusSetting(null, null, null, null);

    /* compiled from: ModelCustomStatusSetting.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelCustomStatusSetting getCLEAR() {
            return ModelCustomStatusSetting.access$getCLEAR$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModelCustomStatusSetting.kt */
    public static final class Parser implements Model.Parser<ModelCustomStatusSetting> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelCustomStatusSetting parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelCustomStatusSetting parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return ModelCustomStatusSetting.INSTANCE.getCLEAR();
            }
            reader.nextObject(new ModelCustomStatusSetting2(ref$ObjectRefM844c0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            return new ModelCustomStatusSetting((String) ref$ObjectRefM844c0.element, (Long) ref$ObjectRef.element, (String) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelCustomStatusSetting(String str, Long l, String str2, String str3) {
        this.text = str;
        this.emojiId = l;
        this.emojiName = str2;
        this.expiresAt = str3;
    }

    public static final /* synthetic */ ModelCustomStatusSetting access$getCLEAR$cp() {
        return CLEAR;
    }

    public static /* synthetic */ ModelCustomStatusSetting copy$default(ModelCustomStatusSetting modelCustomStatusSetting, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelCustomStatusSetting.text;
        }
        if ((i & 2) != 0) {
            l = modelCustomStatusSetting.emojiId;
        }
        if ((i & 4) != 0) {
            str2 = modelCustomStatusSetting.emojiName;
        }
        if ((i & 8) != 0) {
            str3 = modelCustomStatusSetting.expiresAt;
        }
        return modelCustomStatusSetting.copy(str, l, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final ModelCustomStatusSetting copy(String text, Long emojiId, String emojiName, String expiresAt) {
        return new ModelCustomStatusSetting(text, emojiId, emojiName, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCustomStatusSetting)) {
            return false;
        }
        ModelCustomStatusSetting modelCustomStatusSetting = (ModelCustomStatusSetting) other;
        return Intrinsics3.areEqual(this.text, modelCustomStatusSetting.text) && Intrinsics3.areEqual(this.emojiId, modelCustomStatusSetting.emojiId) && Intrinsics3.areEqual(this.emojiName, modelCustomStatusSetting.emojiName) && Intrinsics3.areEqual(this.expiresAt, modelCustomStatusSetting.expiresAt);
    }

    public final Long getEmojiId() {
        return this.emojiId;
    }

    public final String getEmojiName() {
        return this.emojiName;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiresAt;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelCustomStatusSetting(text=");
        sbM833U.append(this.text);
        sbM833U.append(", emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", emojiName=");
        sbM833U.append(this.emojiName);
        sbM833U.append(", expiresAt=");
        return outline.m822J(sbM833U, this.expiresAt, ")");
    }
}
