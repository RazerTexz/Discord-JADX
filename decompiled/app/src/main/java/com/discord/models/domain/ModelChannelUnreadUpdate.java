package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelChannelUnreadUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelChannelUnreadUpdate {
    private final List<ModelReadState> channelReadStates;

    /* compiled from: ModelChannelUnreadUpdate.kt */
    public static final class Parser implements Model.Parser<ModelChannelUnreadUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelChannelUnreadUpdate parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.Parser
        public ModelChannelUnreadUpdate parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            reader.nextObject(new ModelChannelUnreadUpdate2(ref$ObjectRefC0, reader));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("channelReadStates");
            }
            return new ModelChannelUnreadUpdate((List) t);
        }
    }

    public ModelChannelUnreadUpdate(List<ModelReadState> list) {
        Intrinsics3.checkNotNullParameter(list, "channelReadStates");
        this.channelReadStates = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelChannelUnreadUpdate copy$default(ModelChannelUnreadUpdate modelChannelUnreadUpdate, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelChannelUnreadUpdate.channelReadStates;
        }
        return modelChannelUnreadUpdate.copy(list);
    }

    public final List<ModelReadState> component1() {
        return this.channelReadStates;
    }

    public final ModelChannelUnreadUpdate copy(List<ModelReadState> channelReadStates) {
        Intrinsics3.checkNotNullParameter(channelReadStates, "channelReadStates");
        return new ModelChannelUnreadUpdate(channelReadStates);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelChannelUnreadUpdate) && Intrinsics3.areEqual(this.channelReadStates, ((ModelChannelUnreadUpdate) other).channelReadStates);
        }
        return true;
    }

    public final List<ModelReadState> getChannelReadStates() {
        return this.channelReadStates;
    }

    public int hashCode() {
        List<ModelReadState> list = this.channelReadStates;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.L(outline.U("ModelChannelUnreadUpdate(channelReadStates="), this.channelReadStates, ")");
    }
}
