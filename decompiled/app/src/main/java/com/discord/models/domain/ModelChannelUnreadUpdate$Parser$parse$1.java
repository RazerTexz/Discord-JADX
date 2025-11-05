package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelReadState;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelChannelUnreadUpdate.kt */
/* loaded from: classes.dex */
public final class ModelChannelUnreadUpdate$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $channelReadStates;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: ModelChannelUnreadUpdate.kt */
    /* renamed from: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<ModelReadState> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelReadState get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelReadState get() {
            return ModelReadState.Parser.INSTANCE.parse(ModelChannelUnreadUpdate$Parser$parse$1.this.$reader);
        }
    }

    public ModelChannelUnreadUpdate$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$channelReadStates = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    @Override // rx.functions.Action1
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
        T t = (T) this.$reader.nextList(new AnonymousClass1());
        m.checkNotNullExpressionValue(t, "reader.nextList { ModelR…te.Parser.parse(reader) }");
        ref$ObjectRef.element = t;
    }
}
