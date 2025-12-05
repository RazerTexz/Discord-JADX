package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelReadState;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: ModelChannelUnreadUpdate.kt */
/* renamed from: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelChannelUnreadUpdate2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $channelReadStates;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: ModelChannelUnreadUpdate.kt */
    /* renamed from: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1$1 */
    public static final class C55341<T> implements Model.JsonReader.ItemFactory<ModelReadState> {
        public C55341() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelReadState get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelReadState get() {
            return ModelReadState.Parser.INSTANCE.parse(ModelChannelUnreadUpdate2.this.$reader);
        }
    }

    public ModelChannelUnreadUpdate2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$channelReadStates = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != -298662154 || !str.equals("channel_unread_updates")) {
            this.$reader.skipValue();
            return;
        }
        Ref$ObjectRef ref$ObjectRef = this.$channelReadStates;
        T t = (T) this.$reader.nextList(new C55341());
        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { ModelR…te.Parser.parse(reader) }");
        ref$ObjectRef.element = t;
    }
}
